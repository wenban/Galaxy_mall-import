package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.OrderDetailDAO;
import galaxy.model.OrderDetail;

@Service
public class OrderDetailService {
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;

	public List<OrderDetail> selectOrderDetail(Integer orderId) {
		return orderDetailDAO.selectOrderDetail(orderId);
	}
	
	public void addOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.addOrderDetail(orderDetail);
	}
	
	
	public void returnGoods(OrderDetail orderDetail) {

	}
	
	public void exchangeGoods(OrderDetail orderDetail) {

	}
	
	public int judgeDiscount(Integer goodsId) {
		System.out.println(goodsId);
		return orderDetailDAO.judgeDiscount(goodsId);
	}

	

}
