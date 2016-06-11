package galaxy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import galaxy.model.Goods;
import galaxy.model.GoodsModel;
import galaxy.model.Store;
import galaxy.security.ShiroTool;
import galaxy.service.GoodsService;
import galaxy.service.ModelService;
import galaxy.service.StoreService;
import tool.MyMethod;

@Controller
public class ModelController {
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private StoreService storeService;

	/**
	 * 跳转到ModelCreate页面
	 * 
	 * @param model
	 * @param goodsModel
	 * @return
	 */
	@RequestMapping(value = "/model/toCreate", method = RequestMethod.GET)
	public String modeltoCreate(Model model, GoodsModel goodsModel) {
//		return "model_create";
		return "model_create_new";
	}

	/**
	 * 处理 ModelCreate 业务逻辑的方法
	 * 
	 * @param model
	 * @param session
	 * @param goodsModel
	 * @return
	 */
	@RequestMapping(value = "/model/create", method = RequestMethod.POST)
	public String modelCreate(Model model, HttpSession session, GoodsModel goodsModel) {
		goodsModel.setStoreId(ShiroTool.getStoreId());
		GoodsModel fullOfInfoModel = modelService.createModel(goodsModel);
		session.setAttribute("fullOfInfoModel", fullOfInfoModel);
		return "goods_create";
	}

	/**
	 * 获得详细信息页的model
	 * 
	 * @param model
	 * @param goodsModel
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/model/show/{id}", method = RequestMethod.GET)
	public String modelToShow(Model model, GoodsModel goodsModel, @PathVariable Integer id) {
		goodsModel.setId(id);
		// 处理2个属性列表,去掉重复数据
		List<String> FirstAttributeList = new ArrayList<String>();
		List<String> SecondAttributeList = new ArrayList<String>();
		GoodsModel completeGoodsInfo = modelService.selectCompleteGoodsInfo(goodsModel);
		Store store = new Store();
		store.setId(completeGoodsInfo.getStoreId());

		for (Goods GM : completeGoodsInfo.getGoodsList()) {
			FirstAttributeList.add(GM.getGoodsAttributeF());
			SecondAttributeList.add(GM.getGoodsAttributeS());
		}

		model.addAttribute("storeInfo", storeService.selectOneStoreById(store));
		model.addAttribute("FirstAttributeList", MyMethod.removeDuplicate(FirstAttributeList));
		model.addAttribute("SecondAttributeList", MyMethod.removeDuplicate(SecondAttributeList));
		model.addAttribute("completeGoodsInfo", completeGoodsInfo);
		return "model_show";
	}

	/**
	 * ajax处理 点击第一个属性 check第二属性列表
	 * 
	 * @param goods
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "/model/show/firstAttribute/{str}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> clickGoodsFirstAttribute(Goods goods, @PathVariable String str) {
		return goodsService.checkSecondAttribute(goods, str);
	}

	/**
	 * ajax处理 点击第二个属性 check第一属性列表
	 * 
	 * @param goods
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "/model/show/secondAttribute/{str}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> clickGoodsSecondAttribute(Goods goods, @PathVariable String str) {
		return goodsService.checkFirstAttribute(goods, str);
	}

	/**
	 * ajax处理 点击2个属性事件,返回选中的具体 goods
	 * 
	 * @param goods
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "/model/show/condition/{str}", method = RequestMethod.GET)
	@ResponseBody
	public Goods clickGoodsDoubleInfo(Goods goods, @PathVariable String str) {
		return goodsService.getClickGoodsInfo(goods, str);
	}
	
	@RequestMapping(value = "/model/show/all", method = RequestMethod.GET)
	public String showAllModel(Model model) {
		Store store = new Store();
		store.setId(0);
		model.addAttribute("modelList", modelService.selectModelList(store));
		return "test_all_model";
	}

	@RequestMapping(value = "/model/update", method = RequestMethod.POST)
	public String modelUpdate(Model model, GoodsModel goodsModel) {
		modelService.updateModel(goodsModel);
		return "";
	}

	@RequestMapping(value = "/model/remove", method = RequestMethod.GET)
	public String modelRemove(Model model, GoodsModel goodsModel) {
		modelService.removeModel(goodsModel);
		return "";
	}

}
