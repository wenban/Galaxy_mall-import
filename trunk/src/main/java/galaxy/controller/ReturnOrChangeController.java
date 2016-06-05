package galaxy.controller;

import java.io.IOException;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import galaxy.model.Category;
import galaxy.model.OrderDetailReturnOrExchange;
import galaxy.service.ReturnOrChangeService;

@Controller
public class ReturnOrChangeController {

	@Autowired
	public ReturnOrChangeService returnOrChangeService;
	
	@Autowired
	public FreeMarkerConfigurer freeMarkerConfigurer;
	
	
	
	
	@RequestMapping(value = "/returnOrchange/show", method = RequestMethod.GET)
	public String returnOrchangeShow(Model model, Integer id) {
		model.addAttribute("OrderDetailReturnOrExchange", returnOrChangeService.showInfo(id));
		return "return_or_change_info";
	}

	@RequestMapping(value = "/returnOrchange", method = RequestMethod.GET)
	public String toReturnOrChange(Model model, Integer orderDetailId) {
		Integer resultId=returnOrChangeService.judgeExist(orderDetailId);
		if (resultId==null) {
			model.addAttribute("orderDetailId", orderDetailId);
			return "orderDetail_return_or_change";
		}
		return "redirect:/returnOrchange/show?id="+resultId;
		
	}

	@RequestMapping(value = "/returnOrchange", method = RequestMethod.POST)
	public String returnOrChange(OrderDetailReturnOrExchange o) {
		return "redirect:/returnOrchange/show?id="+returnOrChangeService.returnOrChange(o);
	}

	@RequestMapping(value = "/returnOrchange/agree", method = RequestMethod.GET)
	public String returnOrChangeAgree(Integer id) {
		returnOrChangeService.agree(id);
		return "redirect:/returnOrchange/show?id="+id;
	}

	@RequestMapping(value = "/returnOrchange/userDeliver", method = RequestMethod.POST)
	public String returnOrChangeUserDeliver(OrderDetailReturnOrExchange o) {
		returnOrChangeService.userDeliver(o);
		return "redirect:/returnOrchange/show?id="+o.getId();
	}

	@RequestMapping(value = "/returnOrchange/storeReturnMoney", method = RequestMethod.GET)
	public String returnOrChangeStoreReturnMoney(Integer id) {
		returnOrChangeService.storeReturnMoney(id);
		return "redirect:/returnOrchange/show?id="+id;
	}

	@RequestMapping(value = "/returnOrchange/storeDeliver", method = RequestMethod.POST)
	public String returnOrChangeStoreDeliver(OrderDetailReturnOrExchange o) {
		returnOrChangeService.storeDeliver(o);
		return "redirect:/returnOrchange/show?id="+o.getId();
	}

	@RequestMapping(value = "/returnOrchange/accomplish", method = RequestMethod.GET)
	public String returnOrChangeAccomplish(Integer id) {
		returnOrChangeService.accomplish(id);
		return "redirect:/returnOrchange/show?id="+id;
	}

	@RequestMapping(value = "/returnOrchange/cancel", method = RequestMethod.GET)
	public String returnOrChangeCancel(Integer id) {
		returnOrChangeService.cancel(id);
		return "redirect:/returnOrchange/show?id="+id;
	}

}
