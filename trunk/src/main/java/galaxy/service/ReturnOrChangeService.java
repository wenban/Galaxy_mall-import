package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.OrderDetailDAO;
import galaxy.dao.ReturnOrChangeDAO;
import galaxy.model.OrderDetail;
import galaxy.model.OrderDetailReturnOrExchange;

@Service
public class ReturnOrChangeService {

	@Autowired
	private ReturnOrChangeDAO returnOrChangeDAO;

	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	public Integer judgeExist(Integer orderDetaolId) {
		return returnOrChangeDAO.judgeExist(orderDetaolId);
	}

	public OrderDetailReturnOrExchange showInfo(Integer id) {

		return returnOrChangeDAO.selectById(id);

	}

	public Integer returnOrChange(OrderDetailReturnOrExchange o) {
		if ("退货".equals(o.getReturnOrExchange())) {
			return returnGoods(o);
		} else if ("换货".equals(o.getReturnOrExchange())) {
			return exchangeGoods(o);
		}
		return null;
	}

	

	public Integer returnGoods(OrderDetailReturnOrExchange o) {
		returnOrChangeDAO.createReturn(o);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setId(o.getOrderDetailId());
		orderDetail.setIsProblem(1);
		orderDetailDAO.setProblem(orderDetail);
		return o.getId();
	}

	public Integer exchangeGoods(OrderDetailReturnOrExchange o) {
		returnOrChangeDAO.createChange(o);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setId(o.getOrderDetailId());
		orderDetail.setIsProblem(2);
		orderDetailDAO.setProblem(orderDetail);
		return o.getId();
	}

	public void agree(Integer id) {
		returnOrChangeDAO.agree(id);
	}

	public void userDeliver(OrderDetailReturnOrExchange o) {
		returnOrChangeDAO.userDeliver(o);
	}

	public void storeReturnMoney(Integer id) {
		returnOrChangeDAO.storeReturnMoney(id);
	}

	public void storeDeliver(OrderDetailReturnOrExchange o) {
		returnOrChangeDAO.storeDeliver(o);
	}

	public void accomplish(Integer id) {
		returnOrChangeDAO.accomplish(id);
	}

	public void cancel(Integer id) {
		returnOrChangeDAO.cancel(id);
	}
}
