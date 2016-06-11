package galaxy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.dao.UserInfoDAO;
import galaxy.model.Order;
import galaxy.model.OrderDetail;
import galaxy.model.UserAddress;
import galaxy.security.ShiroTool;
import galaxy.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private UserInfoDAO userInfoDAO;

	@Autowired
	private OrderService orderService;

	// ******下单调用goods方法减少库存，确认调用address方法查询地址，支付调用账单方法添加明细，完成调用评论方法添加评论

	/**
	 * 直接购买，下单。
	 * 
	 */
	@RequestMapping(value = "/order/create/direct", method = RequestMethod.GET)
	public String orderCreateDirect(Model model, OrderDetail orderDetail) {
		model.addAttribute("orderList", orderService.createDirectOrder(orderDetail));
		return "order_list";
	}

	/**
	 * 购物车下单。获取要下单的购物车的Id，js转成字符串再来解析。
	 */
	@RequestMapping(value = "/order/creat/shoppingTrolley", method = RequestMethod.GET)
	public String orderCreateShoppingTrolleyAll(Model model, String shoppingTrolleyIdList) {
		model.addAttribute("orderList", orderService.createShoppingTrolleyOrder(shoppingTrolleyIdList));
		return "order_list";
	}

	/**
	 * 确认订单，填写地址。
	 */
	@RequestMapping(value = "/order/confirm", method = RequestMethod.GET)
	public String orderConfirm(Order order) {
		orderService.confirmOrder(order);
		return "redirect:/order/detailInfo?id=" + order.getId();
	}

	/**
	 * 支付订单。
	 */
	@RequestMapping(value = "/order/pay", method = RequestMethod.GET)
	public String orderPay(Integer id) {
		orderService.payOrder(id);
		return "redirect:/order/detailInfo?id=" + id;
	}

	/**
	 * 发货填写快递单。
	 */
	@RequestMapping(value = "/order/deliver", method = RequestMethod.POST)
	public String orderDeliver(Order order) {
		orderService.deliverOrder(order);
		return "redirect:/order/detailInfo?id=" + order.getId();
	}

	/**
	 * 完成订单。
	 */
	@RequestMapping(value = "/order/accomplish", method = RequestMethod.GET)
	public String orderAccomplish(Integer id) {
		orderService.accomplishOrder(id);
		return "redirect:/order/detailInfo?id=" + id;
	}

	/**
	 * 取消订单。
	 */
	@RequestMapping(value = "/order/cancel", method = RequestMethod.GET)
	public String orderCancel(Integer id) {
		orderService.cancelOrder(id);
		return "redirect:/order/list/all/forUser";
	}

	@RequestMapping(value = "/order/detailInfo", method = RequestMethod.GET)
	public String orderDetailInfo(Model model, Integer id) {
		model.addAttribute("order", orderService.selectOrderById(id));
		UserAddress address = userInfoDAO.selectUserDefaultAddrById(ShiroTool.getUserId());
		if (address != null) {
			model.addAttribute("address", address);
		}
		return "order_info";
	}

	@RequestMapping(value = "/order/list/all/forUser", method = RequestMethod.GET)
	public String orderSelectAllForUser(Model model) {
		Order order = new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", orderService.selectAllOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/all/forStore", method = RequestMethod.GET)
	public String orderSelectAllForStore(Model model) {
		Order order = new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", orderService.selectAllOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/waitConfirm/forUser", method = RequestMethod.GET)
	public String orderSelectWaitConfirmForUser(Model model) {
		Order order = new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", orderService.selectWaitConfirmOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/waitConfirm/forStore", method = RequestMethod.GET)
	public String orderSelectWaitConfirmForStore(Model model) {
		Order order = new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", orderService.selectWaitConfirmOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/waitPay/forUser", method = RequestMethod.GET)
	public String orderSelectWaitPayForUser(Model model) {
		Order order = new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", orderService.selectWaitPayOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/waitPay/forStore", method = RequestMethod.GET)
	public String orderSelectWaitPayForStore(Model model) {
		Order order = new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", orderService.selectWaitPayOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/waitDeliver/forUser", method = RequestMethod.GET)
	public String orderSelectWaitDeliverForUser(Model model) {
		Order order = new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", orderService.selectWaitDeliverOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/waitDeliver/forStore", method = RequestMethod.GET)
	public String orderSelectWaitDeliverForStore(Model model) {
		Order order = new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", orderService.selectWaitDeliverOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/waitAccomplish/forUser", method = RequestMethod.GET)
	public String orderSelectWaitAccomplishForUser(Model model) {
		Order order = new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", orderService.selectWaitAccomplishOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/waitAccomplish/forStore", method = RequestMethod.GET)
	public String orderSelectWaitAccomplishForStore(Model model) {
		Order order = new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", orderService.selectWaitAccomplishOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/accomplish/forUser", method = RequestMethod.GET)
	public String orderSelectAccomplishForUser(Model model) {
		Order order = new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", orderService.selectAccomplishOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/accomplish/forStore", method = RequestMethod.GET)
	public String orderSelectAccomplishForStore(Model model) {
		Order order = new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", orderService.selectAccomplishOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/cancel/forUser", method = RequestMethod.GET)
	public String orderSelectCancelForUser(Model model) {
		Order order = new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", orderService.selectCancelOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/cancel/forStore", method = RequestMethod.GET)
	public String orderSelectCancelForStore(Model model) {
		Order order = new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", orderService.selectCancelOrder(order));
		return "order_list";
	}

	@RequestMapping(value = "/order/list/all/forManager", method = RequestMethod.GET)
	public String orderSelectAllForforManager(Model model, Integer orderStatus) {
		model.addAttribute("orderList", orderService.selectOrderForManager(orderStatus));
		return "null";
	}

}
