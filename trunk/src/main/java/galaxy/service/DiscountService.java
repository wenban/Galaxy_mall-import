package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.DiscountDAO;
import galaxy.model.Discount;

@Service
public class DiscountService {
	@Autowired
	private DiscountDAO DiscountDAO;

	public Discount selectDiscount(Discount discount) {
		return DiscountDAO.selectDiscount(discount);
	}

	public void setDiscount(Discount discount) {
		if (DiscountDAO.selectDiscount(discount) == null) {
			DiscountDAO.setDiscount(discount);
			return;
		}
		DiscountDAO.changeDiscount(discount);
	}

	public void cancelUpdate(Discount discount) {
		DiscountDAO.cancelDiscount(discount);
	}

}
