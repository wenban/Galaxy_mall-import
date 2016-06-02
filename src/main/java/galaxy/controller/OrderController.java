package galaxy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.xpath.internal.operations.Mod;

import galaxy.model.Order;
import galaxy.model.OrderDetail;
import galaxy.security.ShiroTool;
import galaxy.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService OrderService;

	//******下单调用goods方法减少库存，确认调用address方法查询地址，支付调用账单方法添加明细，完成调用评论方法添加评论
	
	
	
	/**直接购买，下单。session获取用户Id
	 */
	@RequestMapping(value = "/order/create/direct", method = RequestMethod.GET)
	public String orderCreateDirect(Model model, OrderDetail orderDetail,HttpSession session) {
		model.addAttribute("orderList",OrderService.createDirectOrder(orderDetail,ShiroTool.getUserId()));
		return "order_list";
	}
	
	/**购物车下单。获取要下单的购物车的Id，js转成字符串再来解析。,session获取userId
	 */
	@RequestMapping(value = "/order/creat/shoppingTrolley", method = RequestMethod.GET)
	public String orderCreateShoppingTrolleyAll(Model model,String shoppingTrolleyIdList) {
		model.addAttribute("orderList",OrderService.createShoppingTrolleyOrder(ShiroTool.getUserId(),shoppingTrolleyIdList));
		return "order_list";
	}
	
	
	/**确认订单，填写地址。session获取用户Id
	 */
	@RequestMapping(value = "/order/confirm", method = RequestMethod.GET)
	public String orderConfirm(Model model, Order order) {
		OrderService.confirmOrder(order);
		return "redirect:/order/select?id="+order.getId();
	}
	
	/**支付订单。session获取用户Id
	 */
	@RequestMapping(value = "/order/pay", method = RequestMethod.GET)
	public String orderPay(Model model, Integer id) {
		OrderService.payOrder(id);
		return "redirect:/order/select?id="+id;
	}
	
	/**发货填写快递单。session获取用户Id
	 */
	@RequestMapping(value = "/order/deliver", method = RequestMethod.POST)
	public String orderDeliver(Model model, Order order) {
		OrderService.deliverOrder(order);
		return "redirect:/order/select?id="+order.getId();
	}
	
	/**完成订单。session获取用户Id
	 */
	@RequestMapping(value = "/order/accomplish", method = RequestMethod.GET)
	public String orderAccomplish(Model model, Integer id) {
		OrderService.accomplishOrder(id);
		return "redirect:/order/select?id="+id;
	}
	
	/**取消订单。session获取用户Id
	 */
	@RequestMapping(value = "/order/cancel", method = RequestMethod.GET)
	public String orderCancel(Model model, Integer id) {
		OrderService.cancelOrder(id);
		return "redirect:/order/select/all/forUser";
	}
	
	@RequestMapping(value = "/order/select", method = RequestMethod.GET)
	public String orderSelec(Model model,Integer id) {
		model.addAttribute("order", OrderService.selectOrderById(id));
		return "order_info";
	}
	
	@RequestMapping(value = "/order/select/all/forUser", method = RequestMethod.GET)
	public String orderSelectAllForUser(Model model,HttpSession session) {
		Order order=new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", OrderService.selectAllOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/all/forStore", method = RequestMethod.GET)
	public String orderSelectAllForStore(Model model,HttpSession session) {
		Order order=new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", OrderService.selectAllOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/waitConfirm/forUser", method = RequestMethod.GET)
	public String orderSelectWaitConfirmForUser(Model model,HttpSession session) {
		Order order=new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", OrderService.selectWaitConfirmOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/waitConfirm/forStore", method = RequestMethod.GET)
	public String orderSelectWaitConfirmForStore(Model model,HttpSession session) {
		Order order=new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", OrderService.selectWaitConfirmOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/waitPay/forUser", method = RequestMethod.GET)
	public String orderSelectWaitPayForUser(Model model,HttpSession session) {
		Order order=new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", OrderService.selectWaitPayOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/waitPay/forStore", method = RequestMethod.GET)
	public String orderSelectWaitPayForStore(Model model,HttpSession session) {
		Order order=new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", OrderService.selectWaitPayOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/waitDeliver/forUser", method = RequestMethod.GET)
	public String orderSelectWaitDeliverForUser(Model model,HttpSession session) {
		Order order=new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", OrderService.selectWaitDeliverOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/waitDeliver/forStore", method = RequestMethod.GET)
	public String orderSelectWaitDeliverForStore(Model model,HttpSession session) {
		Order order=new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", OrderService.selectWaitDeliverOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/waitAccomplish/forUser", method = RequestMethod.GET)
	public String orderSelectWaitAccomplishForUser(Model model,HttpSession session) {
		Order order=new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", OrderService.selectWaitAccomplishOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/waitAccomplish/forStore", method = RequestMethod.GET)
	public String orderSelectWaitAccomplishForStore(Model model,HttpSession session) {
		Order order=new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", OrderService.selectWaitAccomplishOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/accomplish/forUser", method = RequestMethod.GET)
	public String orderSelectAccomplishForUser(Model model,HttpSession session) {
		Order order=new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", OrderService.selectAccomplishOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/accomplish/forStore", method = RequestMethod.GET)
	public String orderSelectAccomplishForStore(Model model,HttpSession session) {
		Order order=new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", OrderService.selectAccomplishOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/cancel/forUser", method = RequestMethod.GET)
	public String orderSelectCancelForUser(Model model,HttpSession session) {
		Order order=new Order();
		order.setUserId(ShiroTool.getUserId());
		model.addAttribute("orderList", OrderService.selectCancelOrder(order));
		return "order_list";
	}
	
	@RequestMapping(value = "/order/select/cancel/forStore", method = RequestMethod.GET)
	public String orderSelectCancelForStore(Model model,HttpSession session) {
		Order order=new Order();
		order.setStoreId(ShiroTool.getStoreId());
		model.addAttribute("orderList", OrderService.selectCancelOrder(order));
		return "order_list";
	}
	
	

}
