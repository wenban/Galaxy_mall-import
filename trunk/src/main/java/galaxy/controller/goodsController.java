package galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.Goods;
import galaxy.service.goodsService;

@Controller
public class goodsController {
	@Autowired
	private goodsService goodsService;

	@RequestMapping(value = "/goods/select", method = RequestMethod.POST)
	public String modelSelect(Model model, Goods goods) {
		goodsService.selectGoods(goods);
		return "";
	}

	@RequestMapping(value = "/goods/create", method = RequestMethod.POST)
	public String modelCreate(Model model, Goods goods) {
		goodsService.createGoods(goods);
		return "";
	}

	@RequestMapping(value = "/goods/update", method = RequestMethod.POST)
	public String modelUpdate(Model model, Goods goods) {
		goodsService.updateGoods(goods);
		return "";
	}

	@RequestMapping(value = "/goods/remove", method = RequestMethod.GET)
	public String modelRemove(Model model, Goods goods) {
		goodsService.removeGoods(goods);
		return "";
	}
}
