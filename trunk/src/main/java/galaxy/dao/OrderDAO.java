package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.Order;

@Repository
public interface OrderDAO {
	public int createOrderDirect(Order order); 
	public int createOrderShoppingTrolley(Order order); 
	public Order selectOrderById(Integer id); 
	public List<Order> selectNewOrder(Order order); 
	public List<Order> selectConfirmOrderOrder(Order order); 
	public List<Order> selectPayOrder(Order order); 
	public List<Order> selectDeliverOrder(Order order); 
	public List<Order> selectAccomplishOrder(Order order); 
	public List<Order> selectCancelOrder(Order order); 
	public int confirmOrder(Integer orderId); 
	public int payOrder(Integer orderId); 
	public int deliverOrder(Order order); 
	public int accomplishOrder(Integer orderId); 
	public int cancelOrder(Integer orderId); 
	public int setOrderTotalPrice(Order order); 
		
	
}
