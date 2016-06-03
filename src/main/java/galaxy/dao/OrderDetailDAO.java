package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.OrderDetail;

@Repository
public interface OrderDetailDAO {
	public Integer addOrderDetail(OrderDetail orderDetail);
	public Integer judgeDiscount(Integer goodsId);
	public List<OrderDetail> selectOrderDetail(Integer orderId);
		

}
