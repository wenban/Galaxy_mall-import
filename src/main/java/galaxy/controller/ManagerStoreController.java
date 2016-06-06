package galaxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.Store;
import galaxy.model.UserFavorit;
import galaxy.service.ManagerStoreService;

@Controller
public class ManagerStoreController {
	
	@Autowired
	private ManagerStoreService service;
	
	@RequestMapping(value = "/backgroundStore/select", method = RequestMethod.GET)
	public String selectBackgroundStore (Model model,Store store) {
		List<Store> selectstore=service.selectStore(store);
		model.addAttribute("storelist",selectstore); 
		return "storebackground";
	}
	
	@RequestMapping(value = "/backgroundStore/remove", method = RequestMethod.GET)
	public String storeDelete(Integer id,String storeIds){
		service.deleteStore(id, storeIds);
		return "redirect:/backgroundStore/select";
	
	}

}
