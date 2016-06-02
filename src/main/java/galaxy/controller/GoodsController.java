package galaxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.Goods;
import galaxy.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	
	@RequestMapping(value = "/goods/create", method = RequestMethod.GET)
	public String goodsToCreate(Model model, Goods goods) {
		return "goods_create";
	}

	@RequestMapping(value = "/goods/create", method = RequestMethod.POST)
	public String goodsCreate(Model model, Goods goods) {
		goodsService.createGoods(goods);
		Integer temp = 0;
		List<Goods> tempList = goodsService.selectGoodsList(goods);
		for(Goods i : tempList){
			temp = i.getModelId();
		}
		
		model.addAttribute("modelId",temp);
		model.addAttribute("goodsCount",goodsService.selectGoodsCount(goods));
		model.addAttribute("goodsList",goodsService.selectGoodsList(goods));
		return "goods_create_tempList";
	}
	
	@RequestMapping(value = "/goods/select", method = RequestMethod.POST)
	public String goodsSelect(Model model, Goods goods) {
		return "";
	}
	

	@RequestMapping(value = "/goods/update", method = RequestMethod.POST)
	public String goodsUpdate(Model model, Goods goods) {
		goodsService.updateGoods(goods);
		return "";
	}

	@RequestMapping(value = "/goods/remove", method = RequestMethod.GET)
	public String goodsRemove(Model model, Goods goods) {
		goodsService.removeGoods(goods);
		return "";
	}
}
