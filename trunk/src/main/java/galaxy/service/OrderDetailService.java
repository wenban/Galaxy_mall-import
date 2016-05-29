package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.OrderDetailDAO;
import galaxy.model.Discount;
import galaxy.model.OrderDetail;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailDAO OrderDetailDAO;

	public List<OrderDetail> selectOrderDetail(Integer orderId) {
		return OrderDetailDAO.selectOrderDetail(orderId);
	}
	
	public void addOrderDetail(OrderDetail orderDetail) {
		OrderDetailDAO.addOrderDetail(orderDetail);
	}
	
	public void removeOrderDetail(Integer orderDetailId) {

	}
	
	public void returnGoods(OrderDetail orderDetail) {

	}
	
	public void exchangeGoods(OrderDetail orderDetail) {

	}
	
	public int judegeDiscount(Integer goodsId) {
		
		return OrderDetailDAO.judegeDiscount(goodsId);
	}

	

}
