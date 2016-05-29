package galaxy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.orderDAO;
import galaxy.model.Discount;
import galaxy.model.Order;
import galaxy.model.OrderDetail;
import galaxy.model.ShoppingTrolley;

@Service
public class orderService {

	@Autowired
	private orderDAO orderDAO;

	@Autowired
	private orderDetailService orderDetailService;

	@Autowired
	private shoppingTrolleyService shoppingTrolleyService;

	@Autowired
	private discountService discountService;

	@Autowired
	private storeService storeService;

	public List<Order> selectNewOrder(Order order) {
		List<Order> orderList = orderDAO.selectNewOrder(order);
		for (Order od : orderList) {
			od.setOrderDetailList(orderDetailService.selectOrderDetail(od.getId()));
		}
		return orderList;
	}

	public Order createDirectOrder(OrderDetail orderDetail, int userId) {
		Order order = new Order();
		order.setUserId(userId);
		order.setStoreId(orderDetail.getStoreId());
		Double priceTotal=null;
		if (orderDetailService.judegeDiscount(orderDetail.getGoodsId()) == 1) {
			
			priceTotal = discount(orderDetail.getStoreId(),(orderDetail.getGoodsPrice() * orderDetail.getGoodsCount()));
		}else {
			double expressExpenses = storeService.selectExpressExpenses(orderDetail.getGoodsId());
			priceTotal = orderDetail.getGoodsPrice() * orderDetail.getGoodsCount()+expressExpenses;
		}
		System.out.println(priceTotal);
		order.setTotalPrice(priceTotal);
		orderDAO.createOrderDirect(order);
		Integer orderId = order.getId();
		System.out.println("返回主键"+orderId);
		orderDetail.setOrderId(orderId);
		orderDetailService.addOrderDetail(orderDetail);
		Order orderIdObject = new Order();
		orderIdObject.setId(orderId);
		return selectNewOrder(orderIdObject).get(0);
	}
	
	public List<Order> createShoppingTrolleyOrder(int userId) {
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
		
		
		//遍历用户购物车
		List<ShoppingTrolley> shoppingTrolleyList = shoppingTrolleyService.selectShoppingtrolley(userId);
		for (ShoppingTrolley sT : shoppingTrolleyList) {
			//如果map没有key为此购物车宝贝的storeId，则创建一个此店铺的订单Order(没有总金额)，并且返回订单Id，存入三个map
			if (!storeId_OrderId.containsKey(sT.getStoreId())) {
				order.setStoreId(sT.getStoreId());
				Integer orderId = orderDAO.createOrderShoppingTrolley(order);
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
			if (orderDetailService.judegeDiscount(orderDetail.getGoodsId()) == 1) {
				OrderId_notJoinDiscounttotalPrice.put(storeId_OrderId.get(sT.getStoreId()),(OrderId_notJoinDiscounttotalPrice.get(storeId_OrderId.get(sT.getStoreId())) + (sT.getGoodsPrice() * sT.getGoodsCount())));
			} else {
				OrderId_joinDiscountTotalPrice.put(storeId_OrderId.get(sT.getStoreId()),(OrderId_joinDiscountTotalPrice.get(storeId_OrderId.get(sT.getStoreId())) + (sT.getGoodsPrice() * sT.getGoodsCount())));
			}
			//添加订单详情
			orderDetailService.addOrderDetail(orderDetail);
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
			    OTP.setTotalPrice(OrderId_notJoinDiscounttotalPrice.get(otp.getKey())+discount(entry.getKey(), otp.getValue()));
			    }
			}
			
			orderDAO.setOrderTotalPrice(OTP);
		}
		List<Order> orderList = new ArrayList<Order>();
		for (Entry<Integer, Integer> ID : storeId_OrderId.entrySet()) {
			Order orderIdObject = new Order();
			orderIdObject.setId(ID.getValue());
			orderList.addAll(selectNewOrder(orderIdObject));
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

	
	private double discount(Integer storeId, Double priceTotal) {
		Integer expressExpenses = storeService.selectExpressExpenses(storeId);
		System.out.println(expressExpenses);
		priceTotal += expressExpenses;
		Discount discount = new Discount();
		discount.setStoreId(storeId);
		discount = discountService.selectDiscount(discount);
		if (discount.getDiscountWay() == 0) {
			priceTotal -= expressExpenses;
		} else if (discount.getDiscountWay() == 1) {
			priceTotal -= (int) (priceTotal / discount.getEnoughMoney()) * discount.getReduceMoney();
		} else if (discount.getDiscountWay() == 2) {
			priceTotal -= ((int) (priceTotal / discount.getEnoughMoney()) * discount.getReduceMoney()
					+ expressExpenses);
		}
		return priceTotal;
	}
}
