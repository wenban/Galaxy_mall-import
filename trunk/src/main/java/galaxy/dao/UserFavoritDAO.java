package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.User;
import galaxy.model.UserFavorit;


@Repository
public interface UserFavoritDAO {
	 public List<UserFavorit> selectGoodsModel();
	 public List<UserFavorit> selectStores();
	 public void deletefavorit(Integer id);
	 public void deletefavoritstore(Integer id);
	 public List<UserFavorit> selectFavoriteByUserId(User user);
	 
}
