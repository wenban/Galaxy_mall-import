package galaxy.model;

import java.util.Date;

public class UserAddress {

	private Integer userId;

	private String receiveName;

	private String receiveMobile;

	private String receiveZipCode;
	
	private String receiveAddress;

	private String receiveAddressDetail;

	private Date createTime;

	private Date updateTime;




	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public String getReceiveMobile() {
		return receiveMobile;
	}

	public void setReceiveMobile(String receiveMobile) {
		this.receiveMobile = receiveMobile;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}




}
