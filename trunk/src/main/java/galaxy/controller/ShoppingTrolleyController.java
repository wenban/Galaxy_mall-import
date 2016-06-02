package galaxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	public ShoppingTrolleyService ShoppingTrolleyService;
	
	
	/**查询当前用户购物车，session获取当前用户Id
	 */
	@RequestMapping(value = "/shoppingtrolley/select", method = RequestMethod.GET)
	public String shoppingtrolleySelect(Model model) {
		List<ShoppingTrolley> shoppingTrolleyList=ShoppingTrolleyService.selectShoppingtrolley(ShiroTool.getUserId());
		model.addAttribute("shoppingTrolleyList", shoppingTrolleyList);
		return "shoppingTrolley_info";
	}
	
	
	/**添加宝贝到购物车，如果购物车存在userId与这个goodsId的记录，就直接在之前的count上添加 ，session获取当前用户Id
	 */
	@RequestMapping(value = "/shoppingtrolley/add", method = RequestMethod.GET)
	@ResponseBody
	public Integer shoppingtrolleyAdd(Model model, ShoppingTrolley shoppingTrolley) {
		shoppingTrolley.setUserId(ShiroTool.getUserId());
		ShoppingTrolleyService.addShoppingtrolley(shoppingTrolley);
		return 1;
	}
	
	
	/**更新购物车宝贝的数量
	 */
	@RequestMapping(value = "/shoppingtrolley/update", method = RequestMethod.GET)
	public String shoppingtrolleyUpdate(Model model,ShoppingTrolley shoppingTrolley) {
		ShoppingTrolleyService.updateShoppingtrolley(shoppingTrolley);
		return "redirect:/shoppingtrolley/select";
	}
	
	/**移出购物车session获取userId
	 */
	@RequestMapping(value = "/shoppingtrolley/remove", method = RequestMethod.GET)
	public String shoppingtrolleyRemove(Model model, Integer id,HttpSession session) {
		
		ShoppingTrolleyService.cleanShoppingtrolley(id,ShiroTool.getUserId());
		return "redirect:/shoppingtrolley/select";
	}
	
	
//  购物车显示优化
//	Map<Integer, List<ShoppingTrolley>> StoreMap=new HashMap<Integer, List<ShoppingTrolley>>();
//	for (int i = 0; i < shoppingTrolleyList.size(); i++) {
//		if (i==0||shoppingTrolleyList.get(i).getGoodsStoreId()!=shoppingTrolleyList.get(i+1).getGoodsStoreId()) {
//			List<ShoppingTrolley> storeSTlist=new ArrayList<ShoppingTrolley>();
//			storeSTlist.add(shoppingTrolleyList.get(i));
//			StoreMap.put(shoppingTrolleyList.get(i).getGoodsStoreId(), storeSTlist);
//		}
//		else {
//			System.out.println(i);
//			StoreMap.get(shoppingTrolleyList.get(i).getGoodsStoreId()).add(shoppingTrolleyList.get(i));
//		}
//	}
//	model.addAttribute("StoreMap", StoreMap);

}
