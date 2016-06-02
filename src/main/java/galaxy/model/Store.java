package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class Store {
	private Integer id;
	private Integer userId;
	private String storeName;
	private Integer discountId;
	private Integer storeLevel;
	private String statement;
	private Integer expressExpenses;
	private Date creatTime;
	private Date removeTime;
	private Integer storeEnable;

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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	public Integer getStoreLevel() {
		return storeLevel;
	}

	public void setStoreLevel(Integer storeLevel) {
		this.storeLevel = storeLevel;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Integer getExpressExpenses() {
		return expressExpenses;
	}

	public void setExpressExpenses(Integer expressExpenses) {
		this.expressExpenses = expressExpenses;
	}

	public String getCreatTime() {
		return MyMethod.date(creatTime);
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getRemoveTime() {
		return MyMethod.date(removeTime);
	}

	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}

	public Integer getStoreEnable() {
		return storeEnable;
	}

	public void setStoreEnable(Integer storeEnable) {
		this.storeEnable = storeEnable;
	}

}
