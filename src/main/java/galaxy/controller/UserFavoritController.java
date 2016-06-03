package galaxy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.User;
import galaxy.model.UserFavorit;
import galaxy.security.ShiroTool;
import galaxy.service.UserFavoritService;

@Controller
public class UserFavoritController {
	
	@Autowired
	private UserFavoritService service;
	
	@RequestMapping(value = "/toUserfavorit", method = RequestMethod.GET)
	public String toUserfavorit () {
		return "user_favorite";
	}
	
	@RequestMapping(value = "/favorite/select", method = RequestMethod.GET)
	public String selectFavorit(Model model) {
		User user = ShiroTool.getLoginUser();
		List<UserFavorit> selectfavorite=service.selectFavorite(user);
		model.addAttribute("favoritlist",selectfavorite);
		return "redirect:userfavorit/select/goods";
	}
	
	@RequestMapping(value = "/userfavorit/select/goods", method = RequestMethod.GET)
	public String goodsSelect (Model model) {
		List<UserFavorit> favoritgoodmodel= service.selectGoods();
		model.addAttribute("favoritgoodmodelList", favoritgoodmodel);
		return "user_favorite";
	}
	
	@RequestMapping(value = "/userfavorit/select/stores", method = RequestMethod.GET)
	public String storesSelect (Model model) {
		List<UserFavorit> favoritstores= service.selectStores();
		model.addAttribute("favoritstoresList", favoritstores);
		return "store";
	}
	
	@RequestMapping(value = "/userfavorit/remove/favorites", method = RequestMethod.GET)
	public String favoritsDelete(String favoriteIds,Integer id){
		service.deleteFavorites(id, favoriteIds);
		return "redirect:/userfavorit/select/goods";
	
	}
	
	@RequestMapping(value = "/userfavorit/remove/favoritestores", method = RequestMethod.GET)
	public String favoritsDeleteStore(String favoritStoreIds,Integer id){
		service.deletefavoritstore(id, favoritStoreIds);
		return "redirect:/userfavorit/select/stores";
	
	}
	@RequestMapping(value = "/userfavorit/select/goodsimages", method = RequestMethod.GET)
	public String goodsImagesSelect(){
		return null;
	}
	
	@RequestMapping(value = "/userfavorit/select/storesimages", method = RequestMethod.GET)
	public String storesImagesSelect(){
		return null;
	}

}
