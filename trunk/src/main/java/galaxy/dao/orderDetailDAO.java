package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.OrderDetail;

@Repository
public interface orderDetailDAO {
	public Integer addOrderDetail(OrderDetail orderDetail);
	public Integer judegeDiscount(Integer goodsId);
	public List<OrderDetail> selectOrderDetail(Integer orderId);
		

}
