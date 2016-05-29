package galaxy.model;

import java.util.Date;
import java.util.List;

import tool.MyMethod;

public class Order {
	private List<OrderDetail> orderDetailList;
	private Integer id;
	private Integer userId;
	private Integer storeId;
	private Integer orderStatus;
	private Double totalPrice;
	private Integer addressId;
	private String expressCompany;
	private Integer expressId;
	private Integer expressExpenses;
	private Date createTime;
	private Date cancelTime;
	private Date payTime;
	private Date deliverTime;
	private Date accomplishTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getExpressCompany() {
		return expressCompany;
	}
	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}
	public Integer getExpressId() {
		return expressId;
	}
	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}
	public Integer getExpressExpenses() {
		return expressExpenses;
	}
	public void setExpressExpenses(Integer expressExpenses) {
		this.expressExpenses = expressExpenses;
	}
	public String getCreateTime() {
		return MyMethod.date(createTime);
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCancelTime() {
		return MyMethod.date(cancelTime);
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	public String getPayTime() {
		return MyMethod.date(payTime);
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public String getDeliverTime() {
		return MyMethod.date(deliverTime);
	}
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getAccomplishTime() {
		return MyMethod.date(accomplishTime);
	}
	public void setAccomplishTime(Date accomplishTime) {
		this.accomplishTime = accomplishTime;
	}
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
}
