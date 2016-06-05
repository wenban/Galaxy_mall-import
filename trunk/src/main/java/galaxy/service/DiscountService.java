package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.DiscountDAO;
import galaxy.model.Discount;

@Service
public class DiscountService {

	@Autowired
	private DiscountDAO discountDAO;

	public List<Discount> selectDiscountList(Integer StoreId) {
		return discountDAO.selectDiscountListByStoreId(StoreId);
	}

	public Discount selectDiscountById(Integer id) {
		return discountDAO.selectDiscountById(id);
	}
	
	/**
	 * 通过店铺ID查询Discount数量
	 * @param id
	 * @return
	 */
	public Integer selectDiscountNumByStoreId(Integer StoreId) {
		return discountDAO.selectDiscountNumByStoreId(StoreId);
	}
	
	public void setDiscount(Discount discount) {
		discountDAO.setDiscount(discount);
	}

	public void deleteDiscountByUpdate(List<Integer> discountIdList) {
		discountDAO.deleteDiscountByIds(discountIdList);
	}

}
