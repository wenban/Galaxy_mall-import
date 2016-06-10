package galaxy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.GoodsModel;
import galaxy.model.GoodsVipAdvertising;
import galaxy.model.User;
import galaxy.security.ShiroTool;
import galaxy.service.ManagerVipAdvertisementService;

@Controller
public class ManagerVipAdvertisementController {

	@Autowired
	private ManagerVipAdvertisementService managerVipAdvertisementService;

	/**
	 * 请求设置VIP广告，跳转到设置页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toSetVIPAdvertisement", method = RequestMethod.GET)

	public String getAllModel(Model model) {

		List<GoodsModel> modelList = managerVipAdvertisementService.getAllModel(ShiroTool.getLoginUser());

		model.addAttribute("modelList", modelList);

		model.addAttribute("user", ShiroTool.getLoginUser());

		return "toSetVipAdvertisement";

	}

	/**
	 * 设置VIP广告
	 * 
	 * @param vipList
	 * @return
	 */
	@RequestMapping(value = "/VipAdervertisement/set", method = RequestMethod.POST)

	public String setVipAdvertisement(GoodsVipAdvertising goodsVipAdvertising) {

		for (int i = 0; i < goodsVipAdvertising.getModelIdArray().length; i++) {

			int modelId = Integer.valueOf(goodsVipAdvertising.getModelIdArray()[i]);

			goodsVipAdvertising.setModelId(modelId);

			managerVipAdvertisementService.setVipAdvertisement(goodsVipAdvertising);

		}

		return "redirect:/toSetVIPAdvertisement";
	}

	/**
	 * 显示所有等级的VIP广告
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/VIPAdvertisement/show", method = RequestMethod.GET)

	public String showVIPAdvertisement(Model model) {

		Map<String, List<GoodsVipAdvertising>> hashmap = managerVipAdvertisementService.showVIPAdvertisementByLevel();

		model.addAttribute("hashmap", hashmap);

		model.addAttribute("user", ShiroTool.getLoginUser());

		return "showVipAdvertisement";

	}

	/**
	 * 批量删除VIP广告
	 * 
	 * @param goodsVipAdvertising
	 * @return
	 */
	@RequestMapping(value = "/VipAdervertisement/delete", method = RequestMethod.POST)

	public String deleteVipAdvertisement(GoodsVipAdvertising goodsVipAdvertising) {

		for (int i = 0; i < goodsVipAdvertising.getModelIdArray().length; i++) {

			int modelId = Integer.valueOf(goodsVipAdvertising.getModelIdArray()[i]);

			goodsVipAdvertising.setModelId(modelId);

			managerVipAdvertisementService.deleteVipAdvertisement(goodsVipAdvertising);

		}

		return "redirect:/VIPAdvertisement/show";
	}
}
