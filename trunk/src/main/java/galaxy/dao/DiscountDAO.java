package galaxy.dao;

import org.springframework.stereotype.Repository;

import galaxy.model.Discount;

@Repository
public interface DiscountDAO {
	public Discount selectDiscountByStore(Integer storeId);
	public Discount selectDiscountById(Integer id);
	public int setDiscount(Discount discount);
	public int changeDiscount(Discount discount);
	public int cancelDiscount(Discount discount);
}
