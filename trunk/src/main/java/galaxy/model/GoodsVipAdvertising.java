package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class GoodsVipAdvertising {
	private Integer id;
	private String[] modelIdArray;
	private Integer modelId;
	private String modelName;
	private Integer vipLevel;
	private Integer createUserId;
	private Date createTime;
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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



	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}


	public String[] getModelIdArray() {
		return modelIdArray;
	}

	public void setModelIdArray(String[] modelIdArray) {
		this.modelIdArray = modelIdArray;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}
