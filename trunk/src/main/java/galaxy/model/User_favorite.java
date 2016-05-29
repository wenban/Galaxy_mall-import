package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class User_favorite {
	private Integer id;
	private Integer userId;
	private Integer goodsId;
	private Integer storeId;
	private Date createTime;
	private Date removeTime;
	private Integer favoriteEnable;
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
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
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
	public Integer getFavoriteEnable() {
		return favoriteEnable;
	}
	public void setFavoriteEnable(Integer favoriteEnable) {
		this.favoriteEnable = favoriteEnable;
	}
	
	


}
