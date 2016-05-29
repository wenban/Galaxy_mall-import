package galaxy.dao;

import org.springframework.stereotype.Repository;

import galaxy.model.Discount;

@Repository
public interface discountDAO {
	public Discount selectDiscount(Discount discount);
	public int setDiscount(Discount discount);
	public int changeDiscount(Discount discount);
	public int cancelDiscount(Discount discount);
}
