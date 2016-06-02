package galaxy.model;

public class UserFavorit {
	private Integer id;
	private Integer modelId;
	private Integer userId;
	
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	private Integer categoryId;
	private String modelAttributeFName;
	private String modelAttributeSName;
	private String modelName;
	private String modelDescription;
	private String modelEnable;
	private String storeid;
	
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	
	public String getStoreid() {
		return storeid;
	}
	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	private String storeName;
	private String statement;
	private String storeImages;
	private String storesEnable;
	
	
	
	public String getStoresEnable() {
		return storesEnable;
	}
	public void setStoresEnable(String storesEnable) {
		this.storesEnable = storesEnable;
	}
	
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getModelAttributeFName() {
		return modelAttributeFName;
	}
	public void setModelAttributeFName(String modelAttributeFName) {
		this.modelAttributeFName = modelAttributeFName;
	}
	public String getModelAttributeSName() {
		return modelAttributeSName;
	}
	public void setModelAttributeSName(String modelAttributeSName) {
		this.modelAttributeSName = modelAttributeSName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelDescription() {
		return modelDescription;
	}
	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}
	public String getModelEnable() {
		return modelEnable;
	}
	public void setModelEnable(String modelEnable) {
		this.modelEnable = modelEnable;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getStoreImages() {
		return storeImages;
	}
	public void setStoreImages(String storeImages) {
		this.storeImages = storeImages;
	}
}
