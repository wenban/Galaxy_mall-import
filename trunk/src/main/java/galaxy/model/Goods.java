package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class Goods {
	private Integer id;
	private Integer goodsModelId;
	private String goodsAttributeF;
	private String goodsAttributeS;
	private double goodsNewPrice;
	private double goodsOldPrice;
	private Integer goodsInventory;
	private Date createTime;
	private Date updateTime;
	private Date removeTime;
	private Integer goodsEnable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsModelId() {
		return goodsModelId;
	}
	public void setGoodsModelId(Integer goodsModelId) {
		this.goodsModelId = goodsModelId;
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
	public double getGoodsNewPrice() {
		return goodsNewPrice;
	}
	public void setGoodsNewPrice(double goodsNewPrice) {
		this.goodsNewPrice = goodsNewPrice;
	}
	public double getGoodsOldPrice() {
		return goodsOldPrice;
	}
	public void setGoodsOldPrice(double goodsOldPrice) {
		this.goodsOldPrice = goodsOldPrice;
	}
	public Integer getGoodsInventory() {
		return goodsInventory;
	}
	public void setGoodsInventory(Integer goodsInventory) {
		this.goodsInventory = goodsInventory;
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
	public Integer getGoodsEnable() {
		return goodsEnable;
	}
	public void setGoodsEnable(Integer goodsEnable) {
		this.goodsEnable = goodsEnable;
	}
	

}
