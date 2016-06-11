package galaxy.model;

import java.util.Date;
import java.util.List;

import tool.MyMethod;

public class Category {	
	private Integer id;
	private String categoryName;
	private List<Category> childcategory;
	private Integer parentId;
	private Date createTime;
	private Integer createUserId;
	private Date removeTime;
	private Integer categoryEnable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public List<Category> getChildcategory() {
		return childcategory;
	}
	public void setChildcategory(List<Category> childcategory) {
		this.childcategory = childcategory;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getCreateTime() {
		return MyMethod.date(createTime);
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	
	public Integer getCategoryEnable() {
		return categoryEnable;
	}
	public void setCategoryEnable(Integer categoryEnable) {
		this.categoryEnable = categoryEnable;
	}
	public String getRemoveTime() {
		return MyMethod.date(removeTime);
	}
	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
	
	
}
