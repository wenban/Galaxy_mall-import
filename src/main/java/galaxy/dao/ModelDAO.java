package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.GoodsModel;
import galaxy.model.GoodsModel_Images;

@Repository
public interface ModelDAO {
	
	public Integer insertIntoGoodsModel(GoodsModel goodsModel);
	
	public Integer insertIntoModelImagesForModelId(GoodsModel_Images goodsModel_Images);
	
	public GoodsModel selectGoodsModelByModelId(GoodsModel goodsModel);

	public List<GoodsModel_Images> selectModelImagesListByModelId(GoodsModel goodsModel);

}
