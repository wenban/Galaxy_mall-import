package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class UserAssetHistory {
	private Integer id;
	private Integer userId;
	private Double userAsset;
	private Double assetChange;
	private Date createTime;
	private Date removeTime;
	private Integer assetHistoryEnable;
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
	public Double getUserAsset() {
		return userAsset;
	}
	public void setUserAsset(Double userAsset) {
		this.userAsset = userAsset;
	}
	public Double getAssetChange() {
		return assetChange;
	}
	public void setAssetChange(Double assetChange) {
		this.assetChange = assetChange;
	}
	
	public Date getCreateTime() {
		return createTime;
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
	public Integer getAssetHistoryEnable() {
		return assetHistoryEnable;
	}
	public void setAssetHistoryEnable(Integer assetHistoryEnable) {
		this.assetHistoryEnable = assetHistoryEnable;
	}
	
}
