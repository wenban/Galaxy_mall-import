package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class GoodsReturnOrExchange {
	private Integer id;
	private Integer orderDetailId;
	private Integer status;
	private Integer returnMode;
	private Integer returnMoney;
	private Integer userExpressId;
	private Integer storeExpressId;
	private Date createTime;
	private Date agreeTime;
	private Date userDeliverTime;
	private Date storeDeliverTime;
	private Date accomplishTime;
	private Integer goodsReturnEnable;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getReturnMode() {
		return returnMode;
	}
	public void setReturnMode(Integer returnMode) {
		this.returnMode = returnMode;
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
	public String getAgreeTime() {
		return MyMethod.date(agreeTime);
	}
	public void setAgreeTime(Date agreeTime) {
		this.agreeTime = agreeTime;
	}
	public String getUserDeliverTime() {
		return MyMethod.date(userDeliverTime);
	}
	public void setUserDeliverTime(Date userDeliverTime) {
		this.userDeliverTime = userDeliverTime;
	}
	public String getStoreDeliverTime() {
		return MyMethod.date(storeDeliverTime);
	}
	public void setStoreDeliverTime(Date storeDeliverTime) {
		this.storeDeliverTime = storeDeliverTime;
	}
	public String getAccomplishTime() {
		return MyMethod.date(accomplishTime);
	}
	public void setAccomplishTime(Date accomplishTime) {
		this.accomplishTime = accomplishTime;
	}
	public Integer getGoodsReturnEnable() {
		return goodsReturnEnable;
	}
	public void setGoodsReturnEnable(Integer goodsReturnEnable) {
		this.goodsReturnEnable = goodsReturnEnable;
	}
	
}
