package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class GoodsVipAdvertising {
	private Integer id;
	private Integer goodsId;
	private Integer vipLevel;
	private Date createTime;
	private Date updateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
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
	
}
