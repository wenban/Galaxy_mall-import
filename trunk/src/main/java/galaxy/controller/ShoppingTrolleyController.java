package galaxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import galaxy.model.ShoppingTrolley;
import galaxy.service.ShoppingTrolleyService;

@Controller
public class ShoppingTrolleyController {
	@Autowired
	public ShoppingTrolleyService ShoppingTrolleyService;

	@RequestMapping(value = "/shoppingtrolley/select", method = RequestMethod.GET)
	public String shoppingtrolleySelect(Model model) {
// userId sessoin 获取
		int userId=1;
		List<ShoppingTrolley> shoppingTrolleyList=ShoppingTrolleyService.selectShoppingtrolley(userId);
		model.addAttribute("shoppingTrolleyList", shoppingTrolleyList);
		return "shoppingTrolley_info";
	}

	@RequestMapping(value = "/shoppingtrolley/add", method = RequestMethod.GET)
	@ResponseBody
	public Integer shoppingtrolleyAdd(Model model, ShoppingTrolley shoppingTrolley) {
		shoppingTrolley.setUserId(1);
		ShoppingTrolleyService.addShoppingtrolley(shoppingTrolley);
		return 1;
	}

	@RequestMapping(value = "/shoppingtrolley/update", method = RequestMethod.GET)
	public String shoppingtrolleyUpdate(Model model,ShoppingTrolley shoppingTrolley) {
		ShoppingTrolleyService.updateShoppingtrolley(shoppingTrolley);
		return "redirect:/shoppingtrolley/select";
	}

	@RequestMapping(value = "/shoppingtrolley/remove", method = RequestMethod.GET)
	public String shoppingtrolleyRemove(Model model, Integer id,HttpSession session) {
		ShoppingTrolleyService.removeShoppingtrolley(id,session);
		return "redirect:/shoppingtrolley/select";
	}
	
	
	
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
