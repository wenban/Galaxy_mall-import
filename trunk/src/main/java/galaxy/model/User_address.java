package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class User_address {
	private Integer id;
	private Integer userId;
	private String receiveName;
	private String receiveMobile;
	private String receiveZipCode;
	private String receiveAddress;
	private String receiveAddressDetail;
	private Date createTime;
	private Date updateTime;
	private Date removeTime;
	private Integer addressEnable;
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
	public Integer getAddressEnable() {
		return addressEnable;
	}
	public void setAddressEnable(Integer addressEnable) {
		this.addressEnable = addressEnable;
	}
}
