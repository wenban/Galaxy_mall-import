package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.ShoppingTrolley;

@Repository
public interface ShoppingTrolleyDAO {
	public List<ShoppingTrolley> selectShoppingtrolley(Integer userId);
	public ShoppingTrolley selectShoppingtrolleyById(Integer Id);
	public List<ShoppingTrolley> judegGoodsExist(Integer userId);
	public int addShoppingtrolley(ShoppingTrolley shoppingTrolley);
	public int updateShoppingtrolley(ShoppingTrolley shoppingTrolley);
	public int removeShoppingtrolley(Integer id);
	
}
