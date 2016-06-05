package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.Discount;

@Repository
public interface DiscountDAO {
	
	public List<Discount> selectDiscountListByStoreId(Integer storeId);

	public Discount selectDiscountById(Integer id);

	public Integer setDiscount(Discount discount);

	public Integer changeDiscount(Discount discount);

	public void deleteDiscountByIds(List<Integer> discountIdList);
	
	public Integer selectDiscountNumByStoreId(Integer storeId);
	
}
