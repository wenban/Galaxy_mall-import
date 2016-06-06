package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class Comment {
	private Integer id;
	private Integer orderDetailId;
	private Integer userId;
	private Integer goodsId;
	private Integer commentSellerNumber;
	private Integer commentCustomerNumber;
	private String commentContent;
	private String commentImages;
	private String commentContentAdd;
	private String commentImagesAdd;
	private String modelName;
	private String storeName;
	private Date createTime;
	private Date updateTime;
	private Date removeTime;
	private Integer commentEnable;

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

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentImages() {
		return commentImages;
	}

	public void setCommentImages(String commentImages) {
		this.commentImages = commentImages;
	}

	public String getCommentContentAdd() {
		return commentContentAdd;
	}

	public void setCommentContentAdd(String commentContentAdd) {
		this.commentContentAdd = commentContentAdd;
	}

	public String getCreateTime() {
		return MyMethod.date(createTime);
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return MyMethod.date(updateTime);
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemoveTime() {
		return MyMethod.date(removeTime);
	}

	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}

	public Integer getCommentEnable() {
		return commentEnable;
	}

	public void setCommentEnable(Integer commentEnable) {
		this.commentEnable = commentEnable;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getCommentImagesAdd() {
		return commentImagesAdd;
	}

	public void setCommentImagesAdd(String commentImagesAdd) {
		this.commentImagesAdd = commentImagesAdd;
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getCommentSellerNumber() {
		return commentSellerNumber;
	}

	public void setCommentSellerNumber(Integer commentSellerNumber) {
		this.commentSellerNumber = commentSellerNumber;
	}

	public Integer getCommentCustomerNumber() {
		return commentCustomerNumber;
	}

	public void setCommentCustomerNumber(Integer commentCustomerNumber) {
		this.commentCustomerNumber = commentCustomerNumber;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
