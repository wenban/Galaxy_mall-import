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
	private UserFavoritDAO userFavoritDAO;
	
	 
	public List<UserFavorit> selectFavorite(User user) {
		return  userFavoritDAO.selectFavoriteByUserId(user);
	}
	
	public List<UserFavorit> selectGoods() {
		return userFavoritDAO.selectGoodsModel();
		
	}

	public List<UserFavorit> selectStores() {
		return userFavoritDAO.selectStores();
	}
	
	public void deleteFavorites(Integer id,String favoritIds) {
		String[] favoriteIdsArray = favoritIds.split(",");
		for (String favoriteid : favoriteIdsArray) {
			userFavoritDAO.deletefavorit(Integer.parseInt(favoriteid));
		}
	}
	
	public void deletefavoritstore(Integer id,String favoritStoreIds) {
		String[] favoriteStoreIdsArray = favoritStoreIds.split(",");
		for (String favoritestoreid : favoriteStoreIdsArray) {
			userFavoritDAO.deletefavoritstore(Integer.parseInt(favoritestoreid));
		}
	}
	
	
	public String goodsImages(){
		return null;
	}
	
	public String storeImages(){
		return null; 
	}

}
