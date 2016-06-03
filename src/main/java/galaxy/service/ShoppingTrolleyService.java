package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.ShoppingTrolleyDAO;
import galaxy.model.ShoppingTrolley;
import galaxy.security.ShiroTool;

@Service
public class ShoppingTrolleyService {
	@Autowired
	private ShoppingTrolleyDAO shoppingTrolleyDAO;

	public List<ShoppingTrolley> selectShoppingtrolley() {
		return shoppingTrolleyDAO.selectShoppingtrolley(ShiroTool.getUserId());
	}

	public ShoppingTrolley selectShoppingtrolleyById(Integer Id) {
		return shoppingTrolleyDAO.selectShoppingtrolleyById(Id);
	}

	public void addShoppingtrolley(ShoppingTrolley shoppingTrolley) {
		shoppingTrolley.setUserId(ShiroTool.getUserId());
		ShoppingTrolley sT = shoppingTrolleyDAO.judgeGoodsExist(shoppingTrolley);
		if (sT != null) {
			sT.setGoodsCount(shoppingTrolley.getGoodsCount() + sT.getGoodsCount());
			updateShoppingtrolley(sT);
			return;
		}

		shoppingTrolleyDAO.addShoppingtrolley(shoppingTrolley);
	}

	public void updateShoppingtrolley(ShoppingTrolley shoppingTrolley) {
		shoppingTrolleyDAO.updateShoppingtrolley(shoppingTrolley);

	}

	public void cleanAllShoppingtrolley() {
		shoppingTrolleyDAO.removeAllShoppingtrolley(ShiroTool.getUserId());
	}

	public void cleanShoppingtrolley(Integer id) {
		shoppingTrolleyDAO.removeShoppingtrolley(id);
	}

}
