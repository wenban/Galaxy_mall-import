package galaxy.model;

import java.util.Date;

import tool.MyMethod;

public class GoodsModelImages {
	private Integer id;
	private Integer modelId;
	private String modelImage;
	private Date createTime;
	private Date updateTime;
	private Date removeTime;
	private Integer ImageEnable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getModelImage() {
		return modelImage;
	}

	public void setModelImage(String modelImage) {
		this.modelImage = modelImage;
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

	public Integer getImageEnable() {
		return ImageEnable;
	}

	public void setImageEnable(Integer imageEnable) {
		ImageEnable = imageEnable;
	}
	
}
