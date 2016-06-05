package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.UserFavoritDAO;
import galaxy.model.User;
import galaxy.model.UserFavorit;


@Service
public class UserFavoritService {
	
	@Autowired
	private UserFavoritDAO dao;
	
	 
	public List<UserFavorit> selectFavorite(User user) {
		return  dao.selectFavoriteByUserId(user);
		
	}
	
	public List<UserFavorit> selectGoods() {
		return dao.selectGoodsModel();
		
	}

	public List<UserFavorit> selectStores() {
		return dao.selectStores();
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
