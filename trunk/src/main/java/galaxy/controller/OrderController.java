package galaxy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.Order;
import galaxy.model.OrderDetail;
import galaxy.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService OrderService;

	/**直接购买，下单。session获取用户Id
	 */
	@RequestMapping(value = "/order/create/direct", method = RequestMethod.GET)
	public String orderCreateDirect(Model model, OrderDetail orderDetail,HttpSession session) {
		model.addAttribute("orderList",OrderService.createDirectOrder(orderDetail,1));
		return "order_new";
	}
	
	/**购物车下单。获取要下单的购物车的Id，js转成字符串再来解析。,session获取userId
	 */
	@RequestMapping(value = "/order/creat/shoppingTrolley", method = RequestMethod.GET)
	public String orderCreateShoppingTrolleyAll(Model model,String shoppingTrolleyIdList) {
		//不需要userId，session获取
		//js转成字符串再来解析。
		model.addAttribute("orderList",OrderService.createShoppingTrolleyOrder(1,shoppingTrolleyIdList));
		return "order_new";
	}
	
	
	/**直接购买，下单。session获取用户Id
	 */
	@RequestMapping(value = "/order/confirm", method = RequestMethod.GET)
	public String orderConfirm(Model model, Order order) {
		return "";
	}
	
	/**直接购买，下单。session获取用户Id
	 */
	@RequestMapping(value = "/order/pay", method = RequestMethod.GET)
	public String orderPay(Model model, Order order) {
		return "";
	}
	
	/**直接购买，下单。session获取用户Id
	 */
	@RequestMapping(value = "/order/deliver", method = RequestMethod.POST)
	public String orderDeliver(Model model, Order order) {
		return "";
	}
	
	/**直接购买，下单。session获取用户Id
	 */
	@RequestMapping(value = "/order/accomplish", method = RequestMethod.GET)
	public String orderAccomplish(Model model, Order order) {
		return "";
	}


}
