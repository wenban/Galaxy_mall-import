package galaxy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import galaxy.model.Discount;
import galaxy.model.Goods;
import galaxy.model.Store;
import galaxy.security.ShiroTool;
import galaxy.service.DiscountService;
import galaxy.service.ModelService;
import galaxy.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;

	@Autowired
	private DiscountService discountService;

	@Autowired
	private ModelService modelService;

	/**
	 * 通过店铺ID,查看一个店铺
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/store/storeDetail/{id}", method = RequestMethod.GET)
	public String toStoreDetail(Model model, @PathVariable Integer id) {
		Store store = new Store();
		store.setId(id);
		model.addAttribute("modelList", modelService.selectModelList(store));
		model.addAttribute("store", storeService.selectOneStoreById(store));
		return "store_detail";
	}
	
	
	@RequestMapping(value = "/store/select/toSelf", method = RequestMethod.GET)
	@ResponseBody
	public boolean toStoreSelectSelf(Goods goods) {
		String temp = String.valueOf(ShiroTool.getStoreId());
		if (StringUtils.isBlank(temp)) {
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 查询当前用户的店铺，session获取当前用户Id
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/store/select/self", method = RequestMethod.GET)
	public String storeSelectSelf(Model model) {
		Store store = new Store();
		String temp = String.valueOf(ShiroTool.getStoreId());
		if (StringUtils.isBlank(temp)) {
			store.setUserId(ShiroTool.getUserId());
			model.addAttribute("modelList", modelService.selectModelList(store));
			model.addAttribute("store", storeService.selectOneStoreById(store));
			return "store_manage";
		} else {
			return "store_error";
		}
	}

	/**
	 * 前往创建店铺页面，可以做成html
	 * 
	 * @param model
	 * @param store
	 * @return
	 */
	@RequestMapping(value = "/store/toCreate", method = RequestMethod.GET)
	public String storeToCreate(Model model, Store store) {
		return "store_create";
	}

	/**
	 * 创建店铺，如果已经创建过店铺返回提示，没有就创建店铺，session获取当前用户Id
	 * 
	 * @param model
	 * @param store
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/store/create", method = RequestMethod.POST)
	public String createStore(Model model, Store store, HttpSession session) {
		// 校验是否已创建过店铺
		Store checkUserStore = new Store();
		checkUserStore.setUserId(ShiroTool.getUserId());
		if (storeService.selectStoreCount(checkUserStore) != 0) {
			model.addAttribute("error", "你已经创建过店铺了");
			return "store_create";
		}
		// 创建店铺
		store.setUserId(ShiroTool.getUserId());
		storeService.createStore(store);
		model.addAttribute("store", store);
		return "redirect:/store/select/self";
	}

	/**
	 * 前往更新店铺基本信息页面
	 * 
	 * @param model
	 * @param store
	 * @return
	 */
	@RequestMapping(value = "/store/toUpdate", method = RequestMethod.GET)
	public String toUpdateStore(Model model, Store store) {
		model.addAttribute("store", storeService.selectStore(store).get(0));
		return "store_update";
	}

	/**
	 * 更新店铺基本信息，session获取当前用户Id
	 * 
	 * @param model
	 * @param store
	 * @return
	 */
	@RequestMapping(value = "/store/update", method = RequestMethod.POST)
	public String updateStore(Model model, Store store) {
		store.setUserId(ShiroTool.getUserId());
		storeService.updateStore(store);

		return "redirect:/store/select/self";
	}

	/**
	 * 关闭店铺
	 * 
	 * @param model
	 * @param store
	 * @return
	 */
	@RequestMapping(value = "/store/remove", method = RequestMethod.GET)
	public String removeStore(Model model, Store store) {
		storeService.removeStore(store);
		return "redirect:/store/select/self";
	}

	/**
	 * 跳转到 设置折扣 信息页面，session获取当前用户的storeId
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/store/discount/toInfo", method = RequestMethod.GET)
	public String toSetDiscount(Model model) {
		model.addAttribute("storeId", ShiroTool.getStoreId());
		model.addAttribute("discountList", discountService.selectDiscountList(ShiroTool.getStoreId()));
		return "store_discount_info";
	}

	/**
	 * 通过店铺Id 查询Discount数量
	 * 
	 * @param model
	 * @param store
	 * @return
	 */
	@RequestMapping(value = "/store/discount/selectDiscountNum", method = RequestMethod.GET)
	@ResponseBody
	public Integer selectDiscountNum(Model model) {
		return discountService.selectDiscountNumByStoreId(ShiroTool.getStoreId());
	}

	/**
	 * 创建折扣信息，session获取当前用户storeId
	 * 
	 * @param model
	 * @param discount
	 * @return
	 */
	@RequestMapping(value = "/store/discount/setDiscount", method = RequestMethod.POST)
	public String setDiscountForStore(Model model, Discount discount) {
		discount.setStoreId(ShiroTool.getStoreId());
		discountService.setDiscount(discount);
		return "redirect:/store/discount/toInfo";
	}

	/**
	 * 取消店铺折扣，session获取当前用户的storeId
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/store/discount/delete/{discountIds}", method = RequestMethod.GET)
	public String cancelStoreDiscount(Model model, @PathVariable String discountIds) {
		System.out.println("前台传过来的IDs: " + discountIds);
		String[] discountIdArray = discountIds.replace(" ", "").split(",");

		List<Integer> list = new ArrayList<Integer>();
		for (String s : discountIdArray) {
			list.add(Integer.valueOf(s));
		}
		discountService.deleteDiscountByUpdate(list);
		return "redirect:/store/discount/toInfo";
	}

}
