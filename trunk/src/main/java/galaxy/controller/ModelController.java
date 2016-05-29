package galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.GoodsModel;
import galaxy.service.ModelService;

@Controller
public class ModelController {
	@Autowired
	private ModelService ModelService;

	@RequestMapping(value = "/model/select", method = RequestMethod.GET)
	public String modelSelect(Model model, GoodsModel goodsModel) {
		ModelService.selectModel(goodsModel);
		return "";
	}

	@RequestMapping(value = "/model/create", method = RequestMethod.POST)
	public String modelCreate(Model model, GoodsModel goodsModel) {
		ModelService.createModel(goodsModel);
		return "";
	}

	@RequestMapping(value = "/model/update", method = RequestMethod.POST)
	public String modelUpdate(Model model, GoodsModel goodsModel) {
		ModelService.updateModel(goodsModel);
		return "";
	}

	@RequestMapping(value = "/model/remove", method = RequestMethod.GET)
	public String modelRemove(Model model, GoodsModel goodsModel) {
		ModelService.removeModel(goodsModel);
		return "";
	}
}
