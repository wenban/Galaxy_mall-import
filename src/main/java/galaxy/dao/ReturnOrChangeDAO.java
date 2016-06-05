package galaxy.dao;

import org.springframework.stereotype.Repository;

import galaxy.model.OrderDetailReturnOrExchange;


@Repository
public interface ReturnOrChangeDAO {
	public Integer createReturn(OrderDetailReturnOrExchange o);
	public Integer createChange(OrderDetailReturnOrExchange o);
	public Integer agree(Integer id);
	public Integer userDeliver(OrderDetailReturnOrExchange o);
	public Integer storeReturnMoney(Integer id);
	public Integer storeDeliver(OrderDetailReturnOrExchange o);
	public Integer accomplish(Integer id);
	public Integer cancel(Integer id);
	public OrderDetailReturnOrExchange selectById(Integer id);
	public Integer judgeExist(Integer orderDetailId);
}
