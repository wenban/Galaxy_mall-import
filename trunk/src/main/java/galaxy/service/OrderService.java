package galaxy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import galaxy.dao.GoodsDAO;
import galaxy.dao.ModelDAO;
import galaxy.dao.OrderDAO;
import galaxy.dao.UserInfoDAO;
import galaxy.model.Discount;
import galaxy.model.GoodsModel;
import galaxy.model.Order;
import galaxy.model.OrderDetail;
import galaxy.model.ShoppingTrolley;
import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.security.ShiroTool;

@Service
public class OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private GoodsDAO goodsDAO;

	@Autowired
	private ModelDAO modelDAO;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private ShoppingTrolleyService shoppingTrolleyService;

	@Autowired
	private DiscountService discountService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private AssetHistoryService assetHistoryService;

	public Order selectOrderById(Integer id) {
		Order order = orderDAO.selectOrderById(id);
		order.setOrderDetailList(orderDetailService.selectOrderDetail(order.getId()));
		if (order.getDiscountId() != null) {
			Discount discount = discountService.selectDiscountById(order.getDiscountId());
			order.setDiscountWay(discount.getDiscountWay());
			order.setEnoughMoney(discount.getEnoughMoney());
			order.setReduceMoney(discount.getReduceMoney());
		}
		return order;
	}

	public List<Order> selectAllOrder(Order order) {
		List<Order> orderList = orderDAO.selectAllOrder(order);
		setOrderDetail(orderList);
		return orderList;
	}

	public List<Order> selectWaitConfirmOrder(Order order) {

		List<Order> orderList = orderDAO.selectWaitConfirmOrderOrder(order);
		setOrderDetail(orderList);
		return orderList;
	}

	public List<Order> selectWaitPayOrder(Order order) {

		List<Order> orderList = orderDAO.selectConfirmOrderOrder(order);
		setOrderDetail(orderList);
		return orderList;
	}

	public List<Order> selectWaitDeliverOrder(Order order) {

		List<Order> orderList = orderDAO.selectPayOrder(order);
		setOrderDetail(orderList);
		return orderList;
	}

	public List<Order> selectWaitAccomplishOrder(Order order) {

		List<Order> orderList = orderDAO.selectDeliverOrder(order);
		setOrderDetail(orderList);
		return orderList;
	}

	public List<Order> selectAccomplishOrder(Order order) {

		List<Order> orderList = orderDAO.selectAccomplishOrder(order);
		setOrderDetail(orderList);
		return orderList;
	}

	public List<Order> selectCancelOrder(Order order) {

		List<Order> orderList = orderDAO.selectCancelOrder(order);
		setOrderDetail(orderList);
		return orderList;
	}

	public void setOrderDetail(List<Order> orderList) {
		for (Order od : orderList) {
			od.setOrderDetailList(orderDetailService.selectOrderDetail(od.getId()));
		}
	}

	public List<Order> createDirectOrder(OrderDetail orderDetail) {
		// 创建order参数
		Order order = new Order();
		order.setUserId(ShiroTool.getUserId());
		order.setStoreId(orderDetail.getStoreId());

		Double priceTotal = null;
		// 判断宝贝是否参与折扣
		if (orderDetailService.judgeDiscount(orderDetail.getGoodsId()) == 1) {
			// 宝贝参与折扣执行打折方法，返回折扣后的priceTotal和discountId
			String discountInfo = discount(orderDetail.getStoreId(),
					(orderDetail.getGoodsPrice() * orderDetail.getGoodsCount()));
			priceTotal = Double.valueOf(discountInfo.split(",")[0]);
			Integer discountId = Integer.valueOf(discountInfo.split(",")[1]);
			order.setDiscountId(discountId);
			orderDetail.setDiscountId(discountId);
		} else {
			double expressExpenses = storeService.selectExpressExpenses(orderDetail.getStoreId());
			priceTotal = orderDetail.getGoodsPrice() * orderDetail.getGoodsCount() + expressExpenses;
		}
		order.setTotalPrice(priceTotal);

		// 创建订单userId,storeId,totalprice,discountId返回主键在order.id里面，用order.getId()获取次订单Id
		orderDAO.createOrderDirect(order);

		// orderDetail添加orderId后提交
		orderDetail.setOrderId(order.getId());
		orderDetailService.addOrderDetail(orderDetail);

		// 减库存
		Map<String, Integer> reduceGoodsInventory = new HashMap<String, Integer>();
		reduceGoodsInventory.put("id", orderDetail.getGoodsId());
		reduceGoodsInventory.put("count", orderDetail.getGoodsCount());
		goodsDAO.reduceGoodsInventory(reduceGoodsInventory);

		// 加销量
		GoodsModel goodsModel = new GoodsModel();
		goodsModel.setId(goodsDAO.selectModelId(orderDetail.getGoodsId()));
		goodsModel.setDealCount(orderDetail.getGoodsCount());
		modelDAO.addDealCount(goodsModel);

		List<Order> orderList = new ArrayList<>();
		orderList.add(selectOrderById(order.getId()));
		return orderList;
	}

	// ????????mybatis 遍历
	public List<Order> createShoppingTrolleyOrder(String shoppingTrolleyIdList) {

		Order order = new Order();// 前面传过来的数据
		order.setUserId(ShiroTool.getUserId());
		OrderDetail orderDetail = new OrderDetail();
		// 存取店铺ID和订单ID的关系
		Map<Integer, Integer> storeId_OrderId = new HashMap<Integer, Integer>();
		// 存取订单ID和其订单下所有未参与折扣的总价的关系
		Map<Integer, Double> OrderId_notJoinDiscounttotalPrice = new HashMap<Integer, Double>();
		// 存取订单ID和其订单下所有参与折扣的总价的关系
		Map<Integer, Double> OrderId_joinDiscountTotalPrice = new HashMap<Integer, Double>();

		// 没有考虑用户选择指定的购物车宝贝

		// ????????mybatis 可以遍历
		// 遍历用户购物车
		List<ShoppingTrolley> shoppingTrolleyList = new ArrayList<>();

		// 拼接的字符串转化为字符串数组
		// 传过来为-1则购买购物车全部商品，用userId查询购物车Id较快
		if ("-1".equals(shoppingTrolleyIdList)) {
			shoppingTrolleyList = shoppingTrolleyService.selectShoppingtrolley();
			// 清空购物车
			shoppingTrolleyService.cleanAllShoppingtrolley();

		} else {
			String[] stIdList = shoppingTrolleyIdList.split(",");// 用id in ()
			for (String stId : stIdList) {
				shoppingTrolleyList.add(shoppingTrolleyService.selectShoppingtrolleyById(Integer.parseInt(stId)));
				// 清空购物车
				shoppingTrolleyService.cleanShoppingtrolley((Integer.parseInt(stId)));
			}
		}

		for (ShoppingTrolley sT : shoppingTrolleyList) {
			// 如果map没有key为此购物车宝贝的storeId，则创建一个此店铺的订单Order(没有总金额)，并且返回订单Id，存入三个map
			if (!storeId_OrderId.containsKey(sT.getStoreId())) {
				order.setStoreId(sT.getStoreId());
				orderDAO.createOrderShoppingTrolley(order);
				Integer orderId = order.getId();
				storeId_OrderId.put(sT.getStoreId(), orderId);
				OrderId_notJoinDiscounttotalPrice.put(orderId, 0.0);
				OrderId_joinDiscountTotalPrice.put(orderId, 0.0);
			}
			// 购物车的数据转为订单详情的数据
			orderDetail.setGoodsId(sT.getGoodsId());
			orderDetail.setStoreId(sT.getStoreId());
			orderDetail.setGoodsPrice(sT.getGoodsPrice());
			orderDetail.setGoodsCount(sT.getGoodsCount());
			// 订单详情的orderId为map中购物车宝贝sT的storeId对应的orderId
			orderDetail.setOrderId(storeId_OrderId.get(sT.getStoreId()));
			// 判断次宝贝是否参与折扣，参与 则宝贝总金额添加到订单 打折总金额，否则添加到订单 不打折总金额
			if (orderDetailService.judgeDiscount(orderDetail.getGoodsId()) == 1) {
				// 如果参与打折，根据storeId获取dicountId
				orderDetail.setDiscountId(-1);
				OrderId_joinDiscountTotalPrice.put(storeId_OrderId.get(sT.getStoreId()),
						(OrderId_joinDiscountTotalPrice.get(storeId_OrderId.get(sT.getStoreId()))
								+ (sT.getGoodsPrice() * sT.getGoodsCount())));
			} else {
				OrderId_notJoinDiscounttotalPrice.put(storeId_OrderId.get(sT.getStoreId()),
						(OrderId_notJoinDiscounttotalPrice.get(storeId_OrderId.get(sT.getStoreId()))
								+ (sT.getGoodsPrice() * sT.getGoodsCount())));
			}
			// 添加订单详情
			orderDetailService.addOrderDetail(orderDetail);

			// 减库存
			Map<String, Integer> reduceGoodsInventory = new HashMap<String, Integer>();
			reduceGoodsInventory.put("id", orderDetail.getGoodsId());
			reduceGoodsInventory.put("count", orderDetail.getGoodsCount());
			goodsDAO.reduceGoodsInventory(reduceGoodsInventory);

			// 加销量
			GoodsModel goodsModel = new GoodsModel();
			goodsModel.setId(goodsDAO.selectModelId(orderDetail.getGoodsId()));
			goodsModel.setDealCount(orderDetail.getGoodsCount());
			modelDAO.addDealCount(goodsModel);
		}

		// 遍历map
		for (Entry<Integer, Double> otp : OrderId_joinDiscountTotalPrice.entrySet()) {
			// 为更新价格设置orderId和totalPrice
			Order OTP = new Order();
			OTP.setId(otp.getKey());
			// 找到value为当前orderId的storeId
			Integer discountId = 0;
			for (Entry<Integer, Integer> entry : storeId_OrderId.entrySet()) {
				if (otp.getKey().equals(entry.getValue())) {
					// 设置总金额
					String discountInfo = discount(entry.getKey(), otp.getValue());
					Double joinDiscountTotalPrice = Double.valueOf(discountInfo.split(",")[0]);
					discountId = Integer.valueOf(discountInfo.split(",")[1]);
					OTP.setTotalPrice(OrderId_notJoinDiscounttotalPrice.get(otp.getKey()) + joinDiscountTotalPrice);
					OTP.setDiscountId(discountId);
				}
			}
			List<OrderDetail> orderDetailList = orderDetailService.selectOrderDetail(OTP.getId());
			for (OrderDetail od : orderDetailList) {
				od.setDiscountId(discountId);
				orderDetailService.setOrderDetailDiscountId(od);
			}
			orderDAO.setOrderTotalPrice(OTP);
		}
		List<Order> orderList = new ArrayList<Order>();
		for (Entry<Integer, Integer> ID : storeId_OrderId.entrySet()) {
			orderList.add(selectOrderById(ID.getValue()));
		}

		return orderList;
	}

	public void confirmOrder(Order order) {
		orderDAO.confirmOrder(order);
	}

	public void payOrder(Integer orderId) {
		Order order = orderDAO.selectOrderById(orderId);
		assetHistoryService.userAssetChange(-order.getTotalPrice(), order.getUserId());
		assetHistoryService.storeAssetChange(order.getTotalPrice(), order.getStoreId());
		orderDAO.payOrder(orderId);
	}

	public void deliverOrder(Order order) {
		orderDAO.deliverOrder(order);
	}

	public void accomplishOrder(Integer orderId) {
		orderDAO.accomplishOrder(orderId);
	}

	public void cancelOrder(Integer orderId) {
		orderDAO.cancelOrder(orderId);
	}

	private String discount(Integer storeId, Double priceTotal) {
		System.out.println("打折前 $" + priceTotal);
		Integer expressExpenses = storeService.selectExpressExpenses(storeId);
		Discount discount = discountService.selectReasonableDiscount(storeId, priceTotal);
		if (discount.getDiscountWay() == 0) {
		} else if (discount.getDiscountWay() == 1) {
			priceTotal -= discount.getReduceMoney() + expressExpenses;
		} else if (discount.getDiscountWay() == 2) {
			priceTotal -= discount.getReduceMoney();
		}
		System.out.println("打折后 $" + priceTotal);
		return priceTotal + "," + discount.getId();
	}

	public List<Order> selectOrderForManager(Integer orderStatus) {
		return orderDAO.selectOrderForManager(orderStatus);
	}
}
