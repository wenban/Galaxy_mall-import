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
import galaxy.model.GoodsModel_Images;



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
	 * @param model
	 * @return
	 */
	public GoodsModel createModel(GoodsModel goodsModel) {
		modelDAO.insertIntoGoodsModel(goodsModel);
		Integer returnModelId = goodsModel.getId();
		String images_HTML = goodsModel.getModelImages();
		GoodsModel_Images GMImg = new GoodsModel_Images();
		GMImg.setModelId(returnModelId);
		
		if (images_HTML != null && !"".equals(images_HTML)) {
			Document doc = Jsoup.parse(images_HTML);
			Elements linksElements = doc.select("img");
			for (Element ele : linksElements) {
				String oneImg = ele.attr("src");
				String aString=oneImg.substring(oneImg.lastIndexOf("/")+1);
				GMImg.setModelImage(aString);
				modelDAO.insertIntoModelImagesForModelId(GMImg);
			}
		}
		goodsModel.setId(returnModelId);
		return modelDAO.selectGoodsModelByModelId(goodsModel);
	}
	
	/**
	 * 查询完整商品信息
	 * @param goodsModel
	 * @return CompleteGoodsInfo
	 */
	public GoodsModel selectCompleteGoodsInfo(GoodsModel goodsModel) {
		GoodsModel CompleteGoodsInfo = new GoodsModel();
		CompleteGoodsInfo = modelDAO.selectGoodsModelByModelId(goodsModel);
		
		Goods goods = new Goods();
		goods.setModelId(goodsModel.getId());
		CompleteGoodsInfo.setGoodsList(goodsDAO.selectGoodsListByModelId(goods));
		List<GoodsModel_Images> tempList = modelDAO.selectModelImagesListByModelId(goodsModel);
		for(GoodsModel_Images i:tempList){
			i.setModelImage(imagesDomain+i.getModelImage());
		}
		CompleteGoodsInfo.setModelImagesList(tempList);
		return CompleteGoodsInfo;
	}
	

	public void updateModel(GoodsModel model) {

	}

	public void removeModel(GoodsModel model) {

	}
	
}
