package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class OrderDetailReturnOrExchange {
	private Integer id;
	private Integer orderDetailId;
	private Integer status;
	private String returnReason;
	private Integer returnOrExchange;
	private Integer returnMoney;
	private Integer userExpressId;
	private Integer storeExpressId;
	private Date createTime;
	private Date agreeTime;
	private Date userDeliverTime;
	private Date storeReturnMoneyTime;
	private Date storeDeliverTime;
	private Date accomplishTime;
	private Date cancelTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public void setReturnOrExchange(Integer returnOrExchange) {
		this.returnOrExchange = returnOrExchange;
	}
	public Integer getReturnMoney() {
		return returnMoney;
	}
	public void setReturnMoney(Integer returnMoney) {
		this.returnMoney = returnMoney;
	}
	public Integer getUserExpressId() {
		return userExpressId;
	}
	public void setUserExpressId(Integer userExpressId) {
		this.userExpressId = userExpressId;
	}
	public Integer getStoreExpressId() {
		return storeExpressId;
	}
	public void setStoreExpressId(Integer storeExpressId) {
		this.storeExpressId = storeExpressId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getAgreeTime() {
		return agreeTime;
	}
	public void setAgreeTime(Date agreeTime) {
		this.agreeTime = agreeTime;
	}
	public Date getUserDeliverTime() {
		return userDeliverTime;
	}
	public void setUserDeliverTime(Date userDeliverTime) {
		this.userDeliverTime = userDeliverTime;
	}
	public Date getStoreReturnMoneyTime() {
		return storeReturnMoneyTime;
	}
	public void setStoreReturnMoneyTime(Date storeReturnMoneyTime) {
		this.storeReturnMoneyTime = storeReturnMoneyTime;
	}
	public Date getStoreDeliverTime() {
		return storeDeliverTime;
	}
	public void setStoreDeliverTime(Date storeDeliverTime) {
		this.storeDeliverTime = storeDeliverTime;
	}
	public Date getAccomplishTime() {
		return accomplishTime;
	}
	public void setAccomplishTime(Date accomplishTime) {
		this.accomplishTime = accomplishTime;
	}
	public Date getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getStatus() {
		if (status==-1) {
			return "已取消";
		}else if (status==0) {
			return "等待卖家同意";
		}else if (status==1) {
			return "等待买家发货";
		}else if (status==2) {
			return "等待卖家确认收货";
		}else if (status==3) {
			return "卖家已经退款";
		}else if (status==4) {
			return "卖家已发货";
		}else if (status==5) {
			return "退/换货已完成";
		}
		
		return null;
	}



	public String getReturnOrExchange() {
		if (returnOrExchange==1) {
			return "退货";
		}
		if (returnOrExchange==2) {
			return "换货";
		}
		return null;
	}
	
	
	
}
