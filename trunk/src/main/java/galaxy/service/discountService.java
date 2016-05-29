package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.discountDAO;
import galaxy.model.Discount;

@Service
public class discountService {
	@Autowired
	private discountDAO discountDAO;

	public Discount selectDiscount(Discount discount) {
		return discountDAO.selectDiscount(discount);
	}

	public void setDiscount(Discount discount) {
		if (discountDAO.selectDiscount(discount) == null) {
			discountDAO.setDiscount(discount);
			return;
		}
		discountDAO.changeDiscount(discount);
	}

	public void cancelUpdate(Discount discount) {
		discountDAO.cancelDiscount(discount);
	}

}
