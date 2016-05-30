package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.DiscountDAO;
import galaxy.model.Discount;

@Service
public class DiscountService {
	@Autowired
	private DiscountDAO DiscountDAO;

	public Discount selectDiscountByStore(Integer StoreId) {
		return DiscountDAO.selectDiscountByStore(StoreId);
	}
	
	public Discount selectDiscountById(Integer id) {
		return DiscountDAO.selectDiscountById(id);
	}

	public void setDiscount(Discount discount) {
		if (DiscountDAO.selectDiscountByStore(discount.getStoreId()) != null) {
			DiscountDAO.cancelDiscount(discount);
		}
		DiscountDAO.setDiscount(discount);
	}

	public void cancelUpdate(Discount discount) {
		DiscountDAO.cancelDiscount(discount);
	}

}
