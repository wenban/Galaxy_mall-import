package galaxy.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import galaxy.dao.GoodsDAO;
import galaxy.model.Goods;
import tool.MyMethod;

@Service
public class GoodsService {
	@Autowired
	private GoodsDAO goodsDAO;
	
	/**
	 * 查询goods的数量
	 * @param goods
	 * @return
	 */
	public Integer selectGoodsCount(Goods goods) {
		return goodsDAO.selectGoodsCountByModelId(goods);
	}
	
	/**
	 * 查询goods列表
	 * @param goods
	 * @return
	 */
	public List<Goods> selectGoodsList(Goods goods) {
		return goodsDAO.selectGoodsListByModelId(goods);
	}
	
	/**
	 * 点击第一属性,校验第二属性
	 * @param goods
	 * @param str
	 * @return
	 */
	public List<String> checkSecondAttribute(Goods goods,String str) {
		String[] strArray = str.replace(" ","").split(",",2);
		goods.setModelId(Integer.parseInt(strArray[0]));
		goods.setGoodsAttributeF(strArray[1]);
		
		List<String> secondAttributeList = new ArrayList<String>();
 		List<Goods> goodsList = goodsDAO.selectGoodsAttributeByAnotherOne(goods);
		for (Goods i: goodsList){
			secondAttributeList.add(i.getGoodsAttributeS());
		}
		secondAttributeList = MyMethod.removeDuplicate(secondAttributeList);
		return secondAttributeList;
	}
	
	
	/**
	 * 点击第二属性,校验第一属性
	 * @param goods
	 * @param str
	 * @return
	 */
	public List<String> checkFirstAttribute(Goods goods,String str) {
		String[] strArray = str.replace(" ","").split(",",2);
		goods.setModelId(Integer.parseInt(strArray[0]));
		goods.setGoodsAttributeS(strArray[1]);
		
		List<String> FirstAttributeList = new ArrayList<String>();
 		List<Goods> goodsList = goodsDAO.selectGoodsAttributeByAnotherOne(goods);
		for (Goods i: goodsList){
			FirstAttributeList.add(i.getGoodsAttributeF());
		}
		FirstAttributeList = MyMethod.removeDuplicate(FirstAttributeList);
		return FirstAttributeList;
	}
	
	
	
	
	/**
	 * 获得选中两条属性时,返回的具体goods 
	 * @param goods
	 * @return
	 */
	public Goods getClickGoodsInfo(Goods goods,String str) {
		String[] strArray = str.replace(" ","").split(",",3);
		goods.setModelId(Integer.parseInt(strArray[0]));
		goods.setGoodsAttributeF(strArray[1]);
		goods.setGoodsAttributeS(strArray[2]);
		
		Goods temp = goodsDAO.selectGoodsByTwoAttributeAndModelId(goods);
		
		String dateString = "0001-01-01";  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		temp.setRemoveTime(date);
		return temp;
	}
	
	
	public void createGoods(Goods goods) {
		goodsDAO.insertIntoGoods(goods);
	}

	public void updateGoods(Goods goods) {

	}

	public void removeGoods(Goods goods) {

	}
}
