package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class Discount {
	private Integer id;
	private Integer storeId;
	private Integer discountWay;
	private Integer enoughMoney;
	private Integer reduceMoney;
	private Date createTime;
	private Date updateTime;
	private Date removeTime;
	private Integer discountEnable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getDiscountWay() {
		return discountWay;
	}
	public void setDiscountWay(Integer discountWay) {
		this.discountWay = discountWay;
	}
	public Integer getEnoughMoney() {
		return enoughMoney;
	}
	public void setEnoughMoney(Integer enoughMoney) {
		this.enoughMoney = enoughMoney;
	}
	public Integer getReduceMoney() {
		return reduceMoney;
	}
	public void setReduceMoney(Integer reduceMoney) {
		this.reduceMoney = reduceMoney;
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
	public Integer getDiscountEnable() {
		return discountEnable;
	}
	public void setDiscountEnable(Integer discountEnable) {
		this.discountEnable = discountEnable;
	}
	
}
