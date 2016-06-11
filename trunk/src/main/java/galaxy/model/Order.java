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
	private Integer discountId;
	private String receiveName;
	private String receiveMobile;
	private String receiveZipCode;
	private String receiveAddress;
	private String receiveAddressDetail;
	private String expressCompany;
	private Integer expressId;
	private Integer expressExpenses;
	private Date createTime;
	private Date cancelTime;
	private Date payTime;
	private Date deliverTime;
	private Date accomplishTime;
	private Integer discountWay;
	private Integer enoughMoney;
	private Integer reduceMoney;

	public Integer getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

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

	public String getOrderStatus() {
		if (orderStatus == -1) {
			return "已取消";
		} else if (orderStatus == 0) {
			return "等待确认";
		} else if (orderStatus == 1) {
			return "等待支付";
		} else if (orderStatus == 2) {
			return "等待发货";
		} else if (orderStatus == 3) {
			return "等待收货";
		} else if (orderStatus == 4) {
			return "已完成";
		}
		return null;
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

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getReceiveMobile() {
		return receiveMobile;
	}

	public void setReceiveMobile(String receiveMobile) {
		this.receiveMobile = receiveMobile;
	}

	public String getReceiveZipCode() {
		return receiveZipCode;
	}

	public void setReceiveZipCode(String receiveZipCode) {
		this.receiveZipCode = receiveZipCode;
	}

	public String getReceiveAddress() {
		return receiveAddress;
	}

	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	public String getReceiveAddressDetail() {
		return receiveAddressDetail;
	}

	public void setReceiveAddressDetail(String receiveAddressDetail) {
		this.receiveAddressDetail = receiveAddressDetail;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}

	public Date getAccomplishTime() {
		return accomplishTime;
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

	public String getDiscountWay() {
		if (discountWay==null) {
			return "不参与活动";
		}
		if (discountWay==0) {
			return "包邮";
		}else if (discountWay==1) {
			return "满减";
		}else if (discountWay==2) {
			return "满减 加 包邮";
		}
		return "不参与活动";
	}

	public void setDiscountWay(Integer discountWay) {
		this.discountWay = discountWay;
	}

	public Integer getEnoughMoney() {
		return enoughMoney;
	}

	public void setEnoughMoney(Integer enoughMoney) {
		this.enoughMoney = enoughMoney;
	}

	public Integer getReduceMoney() {
		return reduceMoney;
	}

	public void setReduceMoney(Integer reduceMoney) {
		this.reduceMoney = reduceMoney;
	}
	
	
}
