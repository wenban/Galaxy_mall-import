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

import galaxy.model.Discount;
import galaxy.model.Store;
import galaxy.security.ShiroTool;
import galaxy.service.DiscountService;
import galaxy.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	private StoreService StoreService;

	@Autowired
	private DiscountService discountService;

	/**
	 * 查询店铺
	 * 
	 * @param model
	 * @param store
	 * @return
	 */
	@RequestMapping(value = "/store/select", method = RequestMethod.GET)
	public String storeSelect(Model model, Store store) {
		StoreService.selectStore(store);
		return "";
	}

	/**
	 * 查询当前用户店铺，session获取当前用户Id
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/store/select/self", method = RequestMethod.GET)
	public String storeSelectSelf(Model model) {
		Store store = new Store();
		store.setUserId(ShiroTool.getUserId());
		model.addAttribute("store", StoreService.selectStore(store).get(0));
		return "store_info";
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
		if (StoreService.selectStoreCount(checkUserStore) != 0) {
			model.addAttribute("error", "你已经创建过店铺了");
			return "store_create";
		}
		// 创建店铺
		store.setUserId(ShiroTool.getUserId());
		StoreService.createStore(store);
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
		model.addAttribute("store", StoreService.selectStore(store).get(0));
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
		StoreService.updateStore(store);

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
		StoreService.removeStore(store);
		return "redirect:/store/select/self";
	}

	/**
	 * 前往更新店铺折扣信息页面，session获取当前用户的storeId
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
	 * 更新店铺折扣信息，如果已经存在，则删除之前，创建新的信息，session获取当前用户storeId
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
