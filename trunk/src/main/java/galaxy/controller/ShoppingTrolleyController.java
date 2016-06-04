package galaxy.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import galaxy.model.ShoppingTrolley;
import galaxy.security.ShiroTool;
import galaxy.service.ShoppingTrolleyService;

@Controller
public class ShoppingTrolleyController {

	@Autowired
	public ShoppingTrolleyService shoppingTrolleyService;

	/**
	 * 查询当前用户购物车
	 */
	@RequestMapping(value = "/shoppingtrolley/list", method = RequestMethod.GET)
	public String shoppingtrolleySelect(Model model) {
		model.addAttribute("shoppingTrolleyList", shoppingTrolleyService.selectShoppingtrolley());
		return "shoppingTrolley_info";
	}

	/**
	 * 添加宝贝到购物车，如果购物车存在userId与这个goodsId的记录，就直接在之前的count上添加
	 */
	@RequestMapping(value = "/shoppingtrolley/add", method = RequestMethod.GET)
	@ResponseBody
	public Integer shoppingtrolleyAdd(ShoppingTrolley shoppingTrolley) {
		if (StringUtils.isBlank(ShiroTool.getLoginId())) {
			return 2;
		}
		shoppingTrolleyService.addShoppingtrolley(shoppingTrolley);
		return 1;
	}

	/**
	 * 更新购物车宝贝的数量
	 */
	@RequestMapping(value = "/shoppingtrolley/update", method = RequestMethod.GET)
	public String shoppingtrolleyUpdate(ShoppingTrolley shoppingTrolley) {
		shoppingTrolleyService.updateShoppingtrolley(shoppingTrolley);
		return "redirect:/shoppingtrolley/select";
	}

	/**
	 * 移出购物车
	 */
	@RequestMapping(value = "/shoppingtrolley/remove", method = RequestMethod.GET)
	public String shoppingtrolleyRemove(Integer id) {
		if (id == -1) {
			shoppingTrolleyService.cleanAllShoppingtrolley();
		}
		shoppingTrolleyService.cleanShoppingtrolley(id);
		return "redirect:/shoppingtrolley/list";
	}

	// 购物车显示优化
	// Map<Integer, List<ShoppingTrolley>> StoreMap=new HashMap<Integer,
	// List<ShoppingTrolley>>();
	// for (int i = 0; i < shoppingTrolleyList.size(); i++) {
	// if
	// (i==0||shoppingTrolleyList.get(i).getGoodsStoreId()!=shoppingTrolleyList.get(i+1).getGoodsStoreId())
	// {
	// List<ShoppingTrolley> storeSTlist=new ArrayList<ShoppingTrolley>();
	// storeSTlist.add(shoppingTrolleyList.get(i));
	// StoreMap.put(shoppingTrolleyList.get(i).getGoodsStoreId(), storeSTlist);
	// }
	// else {
	// System.out.println(i);
	// StoreMap.get(shoppingTrolleyList.get(i).getGoodsStoreId()).add(shoppingTrolleyList.get(i));
	// }
	// }
	// model.addAttribute("StoreMap", StoreMap);

}
