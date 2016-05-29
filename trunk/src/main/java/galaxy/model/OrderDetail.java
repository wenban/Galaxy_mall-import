package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class OrderDetail {
	private Integer id;
	private Integer orderId;
	private Integer storeId;
	private Integer goodsId;
	private Double goodsPrice;
	private Integer goodsCount;
	private Integer isDiscount;
	private Date createTime;
	private Date cancelTime;
	private Integer isReturn;
	private Integer orderEnable;
	private Date removeTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double double1) {
		this.goodsPrice = double1;
	}
	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	
	public Integer getIsDiscount() {
		return isDiscount;
	}
	public void setIsDiscount(Integer isDiscount) {
		this.isDiscount = isDiscount;
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
	public Integer getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(Integer isReturn) {
		this.isReturn = isReturn;
	}
	public Integer getOrderEnable() {
		return orderEnable;
	}
	public void setOrderEnable(Integer orderEnable) {
		this.orderEnable = orderEnable;
	}
	public String getRemoveTime() {
		return MyMethod.date(removeTime);
	}
	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
	
}
