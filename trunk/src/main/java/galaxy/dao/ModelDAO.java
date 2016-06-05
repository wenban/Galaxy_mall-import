package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.GoodsModel;
import galaxy.model.GoodsModelImages;

@Repository
public interface ModelDAO {
	
	public Integer insertIntoGoodsModel(GoodsModel goodsModel);
	
	public Integer insertIntoModelImagesForModelId(GoodsModelImages goodsModel_Images);
	
	public GoodsModel selectGoodsModelByModelId(GoodsModel goodsModel);

	public List<GoodsModelImages> selectModelImagesListByModelId(GoodsModel goodsModel);

}
