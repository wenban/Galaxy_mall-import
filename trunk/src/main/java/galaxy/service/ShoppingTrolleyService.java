package galaxy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.ShoppingTrolleyDAO;
import galaxy.model.ShoppingTrolley;

@Service
public class ShoppingTrolleyService {
	@Autowired
	private ShoppingTrolleyDAO ShoppingTrolleyDAO;

	public List<ShoppingTrolley> selectShoppingtrolley(Integer userId) {
		return ShoppingTrolleyDAO.selectShoppingtrolley(userId);
	}

	public void addShoppingtrolley(ShoppingTrolley shoppingTrolley) {
		List<ShoppingTrolley> shoppingTrolleyList = selectShoppingtrolley(shoppingTrolley.getUserId());
		for (ShoppingTrolley sT : shoppingTrolleyList) {
			if (sT.getGoodsId() == shoppingTrolley.getGoodsId()) {
				sT.setGoodsCount(shoppingTrolley.getGoodsCount() + sT.getGoodsCount());
				updateShoppingtrolley(sT);
				return;
			}
		}
		ShoppingTrolleyDAO.addShoppingtrolley(shoppingTrolley);
	}

	public void updateShoppingtrolley(ShoppingTrolley shoppingTrolley) {
		ShoppingTrolleyDAO.updateShoppingtrolley(shoppingTrolley);
		

	}

	public void removeShoppingtrolley(Integer id, HttpSession session) {

		if (id == -1) {
			List<ShoppingTrolley> shoppingTrolleyList = ShoppingTrolleyDAO.selectShoppingtrolley(1);// Session
																									// 获取userID
			for (ShoppingTrolley shoppingTrolley : shoppingTrolleyList) {
				ShoppingTrolleyDAO.removeShoppingtrolley(shoppingTrolley.getId());
			}
			return;
		}
		ShoppingTrolleyDAO.removeShoppingtrolley(id);
	}

}
