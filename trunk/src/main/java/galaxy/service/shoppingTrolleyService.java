package galaxy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.shoppingTrolleyDAO;
import galaxy.model.ShoppingTrolley;

@Service
public class shoppingTrolleyService {
	@Autowired
	private shoppingTrolleyDAO shoppingTrolleyDAO;

	public List<ShoppingTrolley> selectShoppingtrolley(Integer userId) {
		return shoppingTrolleyDAO.selectShoppingtrolley(userId);
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
		shoppingTrolleyDAO.addShoppingtrolley(shoppingTrolley);
	}

	public void updateShoppingtrolley(ShoppingTrolley shoppingTrolley) {
		shoppingTrolleyDAO.updateShoppingtrolley(shoppingTrolley);
		

	}

	public void removeShoppingtrolley(Integer id, HttpSession session) {

		if (id == -1) {
			List<ShoppingTrolley> shoppingTrolleyList = shoppingTrolleyDAO.selectShoppingtrolley(1);// Session
																									// 获取userID
			for (ShoppingTrolley shoppingTrolley : shoppingTrolleyList) {
				shoppingTrolleyDAO.removeShoppingtrolley(shoppingTrolley.getId());
			}
			return;
		}
		shoppingTrolleyDAO.removeShoppingtrolley(id);
	}

}
