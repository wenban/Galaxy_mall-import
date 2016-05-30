package galaxy.model;

import java.util.Date;


import tool.MyMethod;

public class GoodsModel {
	private Integer id;
	private Integer categoryId;
	private String modelName;
	private String modelImages;
	private String modelDescription;
	private Integer storeId;
	private Integer modelIsDiscount;
	private Date createTime;
	private Date updateTime;
	private Date cancelTime;
	private Integer commentCount;
	private Integer dealCount;
	private Integer collectionCount;
	private Date removeTime;
	private Integer modelEnable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelImages() {
		return modelImages;
	}
	public void setModelImages(String modelImages) {
		this.modelImages = modelImages;
	}
	public String getModelDescription() {
		return modelDescription;
	}
	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	public Integer getModelIsDiscount() {
		return modelIsDiscount;
	}
	public void setModelIsDiscount(Integer modelIsDiscount) {
		this.modelIsDiscount = modelIsDiscount;
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
	public String getCancelTime() {
		return MyMethod.date(cancelTime);
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getDealCount() {
		return dealCount;
	}
	public void setDealCount(Integer dealCount) {
		this.dealCount = dealCount;
	}
	public Integer getCollectionCount() {
		return collectionCount;
	}
	public void setCollectionCount(Integer collectionCount) {
		this.collectionCount = collectionCount;
	}
	public String getRemoveTime() {
		return MyMethod.date(removeTime);
	}
	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
	public Integer getModelEnable() {
		return modelEnable;
	}
	public void setModelEnable(Integer modelEnable) {
		this.modelEnable = modelEnable;
	}
	
	
}
