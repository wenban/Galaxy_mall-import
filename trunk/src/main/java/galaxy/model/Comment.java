package galaxy.model;

import java.util.Date;

import tool.MyMethod;


public class Comment {
	private Integer id;
	private Integer userId;
	private Integer modelId;
	private String commentProperty;
	private String commentContent;
	private String commentImages;
	private String commentContentAdd;
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
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	public String getCommentProperty() {
		return commentProperty;
	}
	public void setCommentProperty(String commentProperty) {
		this.commentProperty = commentProperty;
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
	
}
