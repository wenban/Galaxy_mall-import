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
	private Integer discountId;
	private Date createTime;
	private Date cancelTime;
	private Integer isProblem;
	private Integer isComment;
	private Integer orderEnable;
	private Date removeTime;
	private String goodsAttributeF;
	private String goodsAttributeS;
	private String modelName;

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

	public Integer getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
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

	

	public Integer getIsProblem() {
		return isProblem;
	}

	public void setIsProblem(Integer isProblem) {
		this.isProblem = isProblem;
	}

	public Integer getIsComment() {
		return isComment;
	}

	public void setIsComment(Integer isComment) {
		this.isComment = isComment;
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

	public String getGoodsAttributeF() {
		return goodsAttributeF;
	}

	public void setGoodsAttributeF(String goodsAttributeF) {
		this.goodsAttributeF = goodsAttributeF;
	}

	public String getGoodsAttributeS() {
		return goodsAttributeS;
	}

	public void setGoodsAttributeS(String goodsAttributeS) {
		this.goodsAttributeS = goodsAttributeS;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
}
