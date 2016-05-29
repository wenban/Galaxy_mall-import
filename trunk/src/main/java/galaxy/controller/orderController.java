package galaxy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.Order;
import galaxy.model.OrderDetail;
import galaxy.service.orderService;

@Controller
public class orderController {
	@Autowired
	private orderService orderService;

	@RequestMapping(value = "/order/create/direct", method = RequestMethod.GET)
	public String orderCreateDirect(Model model, OrderDetail orderDetail,HttpSession session) {
		model.addAttribute("order",orderService.createDirectOrder(orderDetail,1));
		return "order_new";
	}
	
	@RequestMapping(value = "/order/creat/shoppingTrolley", method = RequestMethod.GET)
	public String orderCreateShoppingTrolley(Model model, HttpSession session) {
		//不需要userId，session获取
		model.addAttribute("order",orderService.createShoppingTrolleyOrder(1));
		
		return "order_new";
	}

	@RequestMapping(value = "/order/confirm", method = RequestMethod.GET)
	public String orderConfirm(Model model, Order order) {
		return "";
	}

	@RequestMapping(value = "/order/pay", method = RequestMethod.GET)
	public String orderPay(Model model, Order order) {
		return "";
	}

	@RequestMapping(value = "/order/deliver", method = RequestMethod.POST)
	public String orderDeliver(Model model, Order order) {
		return "";
	}

	@RequestMapping(value = "/order/accomplish", method = RequestMethod.GET)
	public String orderAccomplish(Model model, Order order) {
		return "";
	}


}
