package galaxy.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import galaxy.dao.UserFavoritDAO;
import galaxy.model.User;
import galaxy.model.UserFavorit;


@Service
public class UserFavoritService {
	
	@Autowired
	private UserFavoritDAO dao;
	
	 
	public List<UserFavorit> selectFavorite(Model model ,HttpSession session,User user) {
		List<UserFavorit> favoritstores= dao.selectFavoriteByUserId(user);
		return favoritstores;
	}
	
	public List<UserFavorit> selectGoods() {
		List<UserFavorit> favoritgoods= dao.selectGoodsModel();
		return favoritgoods;
	}

	public List<UserFavorit> selectStores() {
		List<UserFavorit> favoritstores= dao.selectStores();
		return favoritstores;
	}
	public void deleteFavorites(Integer id,String favoritIds) {
		String[] favoriteIdsArray = favoritIds.split(",");
		for (String favoriteid : favoriteIdsArray) {
			dao.deletefavorit(Integer.parseInt(favoriteid));
		}
	}
	
	public void deletefavoritstore(Integer id,String favoritStoreIds) {
		String[] favoriteStoreIdsArray = favoritStoreIds.split(",");
		for (String favoritestoreid : favoriteStoreIdsArray) {
			dao.deletefavoritstore(Integer.parseInt(favoritestoreid));
		}
	}
	
	
	public String goodsImages(){
		return null;
	}
	
	public String storeImages(){
		return null; 
	}

}
