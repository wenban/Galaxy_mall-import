package galaxy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.OrderDAO;
import galaxy.model.Discount;
import galaxy.model.Order;
import galaxy.model.OrderDetail;
import galaxy.model.ShoppingTrolley;

@Service
public class OrderService {

	@Autowired
	private OrderDAO OrderDAO;

	@Autowired
	private OrderDetailService OrderDetailService;

	@Autowired
	private ShoppingTrolleyService ShoppingTrolleyService;

	@Autowired
	private DiscountService DiscountService;

	@Autowired
	private StoreService StoreService;

	public List<Order> selectNewOrder(Integer id) {
		List<Order> orderList = OrderDAO.selectNewOrder(id);
		for (Order od : orderList) {
			od.setOrderDetailList(OrderDetailService.selectOrderDetail(od.getId()));
		}
		return orderList;
	}

	public List<Order> createDirectOrder(OrderDetail orderDetail, int userId) {
		//创建order参数
		Order order = new Order();
		order.setUserId(userId);
		order.setStoreId(orderDetail.getStoreId());
		
		Double priceTotal=null;
		//判断宝贝是否参与折扣
		if (OrderDetailService.judegeDiscount(orderDetail.getGoodsId()) == 1) {
			//宝贝参与折扣执行打折方法，返回折扣后的priceTotal和discountId
			String discountInfo = discount(orderDetail.getStoreId(),(orderDetail.getGoodsPrice() * orderDetail.getGoodsCount()));
			priceTotal= Double.valueOf(discountInfo.split(",")[0]);
			Integer discountId=Integer.valueOf(discountInfo.split(",")[1]);
			orderDetail.setDiscountId(discountId);
		}else {
			double expressExpenses = StoreService.selectExpressExpenses(orderDetail.getStoreId());
			priceTotal = orderDetail.getGoodsPrice() * orderDetail.getGoodsCount()+expressExpenses;
		}
		order.setTotalPrice(priceTotal);
		//创建订单userId,storeId,totalprice,返回主键在order.id里面，用order.getId()获取次订单Id
		OrderDAO.createOrderDirect(order);
		
		//orderDetail添加orderId后提交
		orderDetail.setOrderId(order.getId());
		OrderDetailService.addOrderDetail(orderDetail);
		
		
		return selectNewOrder(order.getId());
	}
	
	
	//????????mybatis 遍历
	public List<Order> createShoppingTrolleyOrder(int userId,String shoppingTrolleyIdList) {
		
				
		Order order = new Order();// 前面传过来的数据
		order.setUserId(userId);
		OrderDetail orderDetail = new OrderDetail();
		//存取店铺ID和订单ID的关系
		Map<Integer, Integer> storeId_OrderId = new HashMap<Integer, Integer>();
		//存取订单ID和其订单下所有未参与折扣的总价的关系
		Map<Integer, Double> OrderId_notJoinDiscounttotalPrice = new HashMap<Integer, Double>();
		//存取订单ID和其订单下所有参与折扣的总价的关系
		Map<Integer, Double> OrderId_joinDiscountTotalPrice = new HashMap<Integer, Double>();
		
		
		//没有考虑用户选择指定的购物车宝贝
		
		//????????mybatis 可以遍历
		//遍历用户购物车
		List<ShoppingTrolley> shoppingTrolleyList=new ArrayList<>();
		
		//拼接的字符串转化为字符串数组
		//传过来为-1则购买购物车全部商品，用userId查询购物车Id较快
		if (shoppingTrolleyIdList.equals("-1")) {
			System.out.println("userId"+userId);
			shoppingTrolleyList=ShoppingTrolleyService.selectShoppingtrolley(userId);
			//清空购物车
			ShoppingTrolleyService.cleanShoppingtrolley(-1, userId);
	
		}else {
			String[] stIdList=shoppingTrolleyIdList.split(",");
			for (String stId : stIdList) {			
				shoppingTrolleyList.add(ShoppingTrolleyService.selectShoppingtrolleyById(Integer.parseInt(stId)));
				//清空购物车
				ShoppingTrolleyService.removeShoppingtrolley((Integer.parseInt(stId)));
			}
		}
		
		
		for (ShoppingTrolley sT : shoppingTrolleyList) {
			//如果map没有key为此购物车宝贝的storeId，则创建一个此店铺的订单Order(没有总金额)，并且返回订单Id，存入三个map
			if (!storeId_OrderId.containsKey(sT.getStoreId())) {
				order.setStoreId(sT.getStoreId());
				OrderDAO.createOrderShoppingTrolley(order);
				Integer orderId = order.getId();
				storeId_OrderId.put(sT.getStoreId(), orderId);
				OrderId_notJoinDiscounttotalPrice.put(orderId, 0.0);
				OrderId_joinDiscountTotalPrice.put(orderId, 0.0);
			}
			//购物车的数据转为订单详情的数据
			orderDetail.setGoodsId(sT.getGoodsId());
			orderDetail.setStoreId(sT.getStoreId());
			orderDetail.setGoodsPrice(sT.getGoodsPrice());
			orderDetail.setGoodsCount(sT.getGoodsCount());
			//订单详情的orderId为map中购物车宝贝sT的storeId对应的orderId
			orderDetail.setOrderId(storeId_OrderId.get(sT.getStoreId()));
			//判断次宝贝是否参与折扣，参与 则宝贝总金额添加到订单	打折总金额，否则添加到订单	不打折总金额
			if (OrderDetailService.judegeDiscount(orderDetail.getGoodsId()) == 1) {
				//如果参与打折，根据storeId获取dicountId
				orderDetail.setDiscountId(DiscountService.selectDiscountByStore(sT.getStoreId()).getId());
				OrderId_joinDiscountTotalPrice.put(storeId_OrderId.get(sT.getStoreId()),(OrderId_joinDiscountTotalPrice.get(storeId_OrderId.get(sT.getStoreId())) + (sT.getGoodsPrice() * sT.getGoodsCount())));
			} else {
				OrderId_notJoinDiscounttotalPrice.put(storeId_OrderId.get(sT.getStoreId()),(OrderId_notJoinDiscounttotalPrice.get(storeId_OrderId.get(sT.getStoreId())) + (sT.getGoodsPrice() * sT.getGoodsCount())));
			}
			//添加订单详情
			OrderDetailService.addOrderDetail(orderDetail);
		}
		
		//遍历map
		for (Entry<Integer, Double> otp : OrderId_joinDiscountTotalPrice.entrySet()) {
			//为更新价格设置orderId和totalPrice
			Order OTP = new Order();
			OTP.setId(otp.getKey());
			//找到value为当前orderId的storeId
			for(Entry<Integer, Integer> entry:storeId_OrderId.entrySet()){
			    if(otp.getKey().equals(entry.getValue())){
			    	//设置总金额
			    Double joinDiscountTotalPrice=Double.valueOf(discount(entry.getKey(), otp.getValue()).split(",")[0]);
			    OTP.setTotalPrice(OrderId_notJoinDiscounttotalPrice.get(otp.getKey())+joinDiscountTotalPrice);
			    }
			}
			
			OrderDAO.setOrderTotalPrice(OTP);
		}
		List<Order> orderList = new ArrayList<Order>();
		for (Entry<Integer, Integer> ID : storeId_OrderId.entrySet()) {
			orderList.addAll(selectNewOrder(ID.getValue()));
		}
		
		return orderList;
	}

	public void confirmOrder(Integer orderId) {
		// 生成总价
	}

	public void payOrder(Integer orderId) {
	}

	public void deliverOrder(Order order) {
	}

	public void accomplishOrder(Integer orderId) {
	}

	public void cancelOrder(Integer orderId) {
	}

	
	private String discount(Integer storeId, Double priceTotal) {
		Integer expressExpenses = StoreService.selectExpressExpenses(storeId);
		priceTotal += expressExpenses;
		Discount discount = DiscountService.selectDiscountByStore(storeId);
		if (discount.getDiscountWay() == 0) {
			priceTotal -= expressExpenses;
		} else if (discount.getDiscountWay() == 1) {
			priceTotal -= (int) (priceTotal / discount.getEnoughMoney()) * discount.getReduceMoney();
		} else if (discount.getDiscountWay() == 2) {
			priceTotal -= ((int) (priceTotal / discount.getEnoughMoney()) * discount.getReduceMoney()
					+ expressExpenses);
		}
		return priceTotal+","+discount.getId();
	}
}
