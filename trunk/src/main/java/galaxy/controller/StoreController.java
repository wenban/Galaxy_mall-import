package galaxy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.Discount;
import galaxy.model.Store;
import galaxy.model.User;
import galaxy.service.DiscountService;
import galaxy.service.StoreService;

@Controller
public class StoreController {
	@Autowired
	private StoreService StoreService;

	@Autowired
	private DiscountService DiscountService;

	@RequestMapping(value = "/store/select", method = RequestMethod.GET)
	public String storeSelect(Model model, Store store) {
		StoreService.selectStore(store);
		return "";
	}

	@RequestMapping(value = "/store/select/self", method = RequestMethod.GET)
	public String storeSelectSelf(Model model, Store store) {
		// User user = (User) session.getAttribute("loginUser");
		// if (user==null) {
		// return "";
		// }
		// model.addAttribute("user", user);
		// store.setUserId(user.getId());
		store.setUserId(1);
		model.addAttribute("store", StoreService.selectStore(store).get(0));
		return "store_info";
	}

	@RequestMapping(value = "/store/toCreate", method = RequestMethod.GET)
	public String storeToCreate(Model model, Store store) {
		return "store_create";
	}

	@RequestMapping(value = "/store/create", method = RequestMethod.POST)
	public String storeCreate(Model model, Store store, HttpSession session) {
		// User user = (User) session.getAttribute("loginUser");
		// if (user==null) {
		// return "";
		// }
		// model.addAttribute("user", user);
		// store.setUserId(user.getId());
		store.setUserId(1);
		Store judgeUserStore = new Store();
		judgeUserStore.setUserId(1);
		if (StoreService.selectStoreCount(judgeUserStore) != 0) {
			model.addAttribute("error", "你已经创建过店铺了");
			return "store_create";
		}
		StoreService.createStore(store);
		model.addAttribute("store", store);

		return "redirect:/store/select/self";
	}

	@RequestMapping(value = "/store/toUpdate", method = RequestMethod.GET)
	public String storeToUpdate(Model model, Store store) {
		model.addAttribute("store", StoreService.selectStore(store).get(0));
		return "store_update";
	}

	@RequestMapping(value = "/store/update", method = RequestMethod.POST)
	public String storeUpdate(Model model, Store store) {
		// User user = (User) session.getAttribute("loginUser");
		// if (user==null) {
		// return "";
		// }
		// model.addAttribute("user", user);
		// store.setUserId(user.getId());
		store.setUserId(1);
		StoreService.updateStore(store);

		return "redirect:/store/select/self";
	}

	@RequestMapping(value = "/store/remove", method = RequestMethod.GET)
	public String storeRemove(Model model, Store store) {
		StoreService.removeStore(store);
		return "redirect:/store/select/self";
	}

	@RequestMapping(value = "/store/discount/select", method = RequestMethod.GET)
	public String storeDiscountSelect(Model model) {
		// User user = (User) session.getAttribute("loginUser");
		// if (user==null) {
		// return "";
		// }
		Discount discount = new Discount();
		discount.setStoreId(14);
		// discount.setUserId(user.getStoreId());
		discount=DiscountService.selectDiscount(discount);
		model.addAttribute("discount", discount);
		return "store_discount_info";
	}

	@RequestMapping(value = "/store/discount/toSet", method = RequestMethod.GET)
	public String storeDiscountToSetDiscount(Model model) {
		// User user = (User) session.getAttribute("loginUser");
		// if (user==null) {
		// return "";
		// }
		Discount discount = new Discount();
		discount.setStoreId(14);
		// discount.setUserId(user.getStoreId());
		model.addAttribute("discount", DiscountService.selectDiscount(discount));
		return "store_discount_set";
	}

	@RequestMapping(value = "/store/discount/set", method = RequestMethod.POST)
	public String storeDiscountSet(Model model, Discount discount) {
		// User user = (User) session.getAttribute("loginUser");
		// if (user==null) {
		// return "";
		// }
		discount.setStoreId(14);
		// discount.setUserId(user.getStoreId());
		DiscountService.setDiscount(discount);
		return "redirect:/store/discount/select";
	}

	@RequestMapping(value = "/store/discount/cancel", method = RequestMethod.GET)
	public String storeDiscountCancel(Model model) {
		// User user = (User) session.getAttribute("loginUser");
		// if (user==null) {
		// return "";
		// }
		Discount discount = new Discount();
		discount.setStoreId(14);
		// discount.setUserId(user.getStoreId());
		DiscountService.cancelUpdate(discount);
		return "redirect:/store/select/self";
	}
	
	public int isLogin(HttpSession session) {
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			return 0;
		}
		return 1;
	}

}
