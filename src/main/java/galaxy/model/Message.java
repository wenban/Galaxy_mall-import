package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class Message {
	private Integer id;
	private Integer senderId;
	private Integer receiverId;
	private String massageContent;
	private Date createTime;
	private Date removeTime;
	private Integer massageEnable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public Integer getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}
	public String getMassageContent() {
		return massageContent;
	}
	public void setMassageContent(String massageContent) {
		this.massageContent = massageContent;
	}
	public String getCreateTime() {
		return MyMethod.date(createTime);
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemoveTime() {
		return MyMethod.date(removeTime);
	}
	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
	public Integer getMassageEnable() {
		return massageEnable;
	}
	public void setMassageEnable(Integer massageEnable) {
		this.massageEnable = massageEnable;
	}
	
}
