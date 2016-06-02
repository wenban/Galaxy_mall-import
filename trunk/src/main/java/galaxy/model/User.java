package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class User {
	private Integer id;
	private String loginId;
	private Integer storeId;
	private String loginPassWord;
	private String userName;
	private String userEmail;
	private String userHeadImages;
	private String userMobile;
	private String userGender;
	private String userBirthday;
	private String ID_card;
	private String realName;
	private String realPhoto;
	private Integer userAsset;
	private String userAlipay;
	private Integer userLevel;
	private Integer userAuthority;
	private Date registerTime;
	private Date removeTime;
	private Integer userEnable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassWord() {
		return loginPassWord;
	}
	public void setLoginPassWord(String loginPassWord) {
		this.loginPassWord = loginPassWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserHeadImages() {
		return userHeadImages;
	}
	public void setUserHeadImages(String userHeadImages) {
		this.userHeadImages = userHeadImages;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	

	public String getID_card() {
		return ID_card;
	}
	public void setID_card(String iD_card) {
		ID_card = iD_card;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getRealPhoto() {
		return realPhoto;
	}
	public void setRealPhoto(String realPhoto) {
		this.realPhoto = realPhoto;
	}
	public Integer getUserAsset() {
		return userAsset;
	}
	public void setUserAsset(Integer userAsset) {
		this.userAsset = userAsset;
	}
	public String getUserAlipay() {
		return userAlipay;
	}
	public void setUserAlipay(String userAlipay) {
		this.userAlipay = userAlipay;
	}
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public Integer getUserAuthority() {
		return userAuthority;
	}
	public void setUserAuthority(Integer userAuthority) {
		this.userAuthority = userAuthority;
	}
	public String getRegisterTime() {
		return MyMethod.date(registerTime);
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getRemoveTime() {
		return MyMethod.date(removeTime);
	}
	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
	public Integer getUserEnable() {
		return userEnable;
	}
	public void setUserEnable(Integer userEnable) {
		this.userEnable = userEnable;
	}
	
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	
}
