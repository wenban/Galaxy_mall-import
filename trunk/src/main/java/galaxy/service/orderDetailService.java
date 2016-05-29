package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.orderDetailDAO;
import galaxy.model.Discount;
import galaxy.model.OrderDetail;

@Service
public class orderDetailService {
	@Autowired
	private orderDetailDAO orderDetailDAO;

	public List<OrderDetail> selectOrderDetail(Integer orderId) {
		return orderDetailDAO.selectOrderDetail(orderId);
	}
	
	public void addOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.addOrderDetail(orderDetail);
	}
	
	public void removeOrderDetail(Integer orderDetailId) {

	}
	
	public void returnGoods(OrderDetail orderDetail) {

	}
	
	public void exchangeGoods(OrderDetail orderDetail) {

	}
	
	public int judegeDiscount(Integer goodsId) {
		
		return orderDetailDAO.judegeDiscount(goodsId);
	}

	

}
