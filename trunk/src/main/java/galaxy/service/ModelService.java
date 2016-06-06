package galaxy.service;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import galaxy.dao.GoodsDAO;
import galaxy.dao.ModelDAO;
import galaxy.model.Goods;
import galaxy.model.GoodsModel;
import galaxy.model.GoodsModelImages;
import galaxy.model.Store;

@Service
public class ModelService {
	
	@Autowired
	private ModelDAO modelDAO;
	
	@Autowired
	private GoodsDAO goodsDAO;
	
	@Value("${upload.domain}")
	private String imagesDomain;

	/**
	 * 创建一个Model,将信息传入数据库
	 * 
	 * @param model
	 * @return
	 */
	public GoodsModel createModel(GoodsModel goodsModel) {
		modelDAO.insertIntoGoodsModel(goodsModel);
		Integer returnModelId = goodsModel.getId();
		String images_HTML = goodsModel.getModelImages();
		GoodsModelImages GMImg = new GoodsModelImages();
		GMImg.setModelId(returnModelId);

		if (images_HTML != null && !"".equals(images_HTML)) {
			Document doc = Jsoup.parse(images_HTML);
			Elements linksElements = doc.select("img");
			for (Element ele : linksElements) {
				String oneImg = ele.attr("src");
				String aString = oneImg.substring(oneImg.lastIndexOf("/") + 1);
				GMImg.setModelImage(aString);
				modelDAO.insertIntoModelImagesForModelId(GMImg);
			}
		}
		goodsModel.setId(returnModelId);
		return modelDAO.selectGoodsModelByModelId(goodsModel);
	}

	/**
	 * 查询完整商品信息
	 * 
	 * @param goodsModel
	 * @return CompleteGoodsInfo
	 */
	public GoodsModel selectCompleteGoodsInfo(GoodsModel goodsModel) {
		GoodsModel CompleteGoodsInfo = new GoodsModel();
		CompleteGoodsInfo = modelDAO.selectGoodsModelByModelId(goodsModel);

		Goods goods = new Goods();
		goods.setModelId(goodsModel.getId());
		CompleteGoodsInfo.setGoodsList(goodsDAO.selectGoodsListByModelId(goods));
		List<GoodsModelImages> tempList = modelDAO.selectModelImagesListByModelId(goodsModel);
		for (GoodsModelImages i : tempList) {
			i.setModelImage(imagesDomain + i.getModelImage());
		}
		CompleteGoodsInfo.setModelImagesList(tempList);
		return CompleteGoodsInfo;
	}

	/**
	 * 通过 StoreId 查询店铺的 modelList
	 * 
	 * @param store
	 * @return
	 */
	public List<GoodsModel> selectModelList(Store store) {
		List<GoodsModel> modelList = modelDAO.selectModelListByStoreId(store);
		Goods goods = new Goods();
		//初始化库存计数器
		Integer inventorySum = 0;
		//嵌套循环为每个GoosModel的总库存设值
		for(GoodsModel i :modelList ){
			goods.setModelId(i.getId());
			for(Goods j :goodsDAO.selectGoodsListByModelId(goods)){
				inventorySum += j.getGoodsInventory();
			}
			i.setInventorySum(inventorySum);
			//重置库存计数器
			inventorySum = 0;
		}
		return modelList;
	}

	public void updateModel(GoodsModel model) {

	}

	public void removeModel(GoodsModel model) {

	}

}
