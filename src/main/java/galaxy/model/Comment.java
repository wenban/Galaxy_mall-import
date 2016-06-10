package galaxy.model;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import tool.MyMethod;

public class Comment {
	private Integer id;
	private Integer orderDetailId;
	private Integer userId;
	private Integer goodsId;
	private Integer modelId;
	private Integer commentSellerNumber;
	private String commentSellerNumberStr;
	private Integer commentCustomerNumber;
	private String commentCustomerNumberStr;
	private String commentContent;
	private String commentImages;
	private String[] commentImagesList;
	private String commentContentAdd;
	private String commentImagesAdd;
	private String[] commentImagesAddList;
	private String userName;
	private String modelName;
	private String goodsAttributeF;
	private String goodsAttributeS;
	private String modelAttributeFName;
	private String modelAttributeSName;
	private String storeName;
	private Date createTime;
	private Date updateTime;
	private Date removeTime;
	private Integer commentEnable;

	public String getModelAttributeFName() {
		return modelAttributeFName;
	}

	public void setModelAttributeFName(String modelAttributeFName) {
		this.modelAttributeFName = modelAttributeFName;
	}

	public String getModelAttributeSName() {
		return modelAttributeSName;
	}

	public void setModelAttributeSName(String modelAttributeSName) {
		this.modelAttributeSName = modelAttributeSName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String[] getCommentImagesList() {
		if (StringUtils.isEmpty(commentImages)) {
			return null;
		}
		return commentImages.split("\\|");
	}

	public void setCommentImagesList(String[] commentImagesList) {
		this.commentImagesList = commentImagesList;
	}

	public String[] getCommentImagesAddList() {
		if (StringUtils.isEmpty(commentImagesAdd)) {
			return null;
		}
		return commentImagesAdd.split("\\|");
	}

	public void setCommentImagesAddList(String[] commentImagesAddList) {
		this.commentImagesAddList = commentImagesAddList;
	}

	public String getCommentSellerNumberStr() {
		if (commentSellerNumber == -5) {
			return "差";
		} else if (commentSellerNumber == -3) {
			return "中";
		} else if (commentSellerNumber == 0) {
			return "一般";
		} else if (commentSellerNumber == 3) {
			return "好";
		} else {
			return "非常好";
		}
	}

	public void setCommentSellerNumberStr(String commentSellerNumberStr) {
		this.commentSellerNumberStr = commentSellerNumberStr;
	}

	public String getCommentCustomerNumberStr() {
		if (commentCustomerNumber == -5) {
			return "差";
		} else if (commentCustomerNumber == -3) {
			return "中";
		} else if (commentCustomerNumber == 0) {
			return "一般";
		} else if (commentCustomerNumber == 3) {
			return "好";
		} else {
			return "非常好";
		}
	}

	public void setCommentCustomerNumberStr(String commentCustomerNumberStr) {
		this.commentCustomerNumberStr = commentCustomerNumberStr;
	}

}
