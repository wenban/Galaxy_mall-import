package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.Goods;

@Repository
public interface GoodsDAO {
	
	public void insertIntoGoods(Goods goods);
	
	public List<Goods> selectGoodsListByModelId(Goods goods);
	
	public List<Goods> selectGoodsAttributeByAnotherOne(Goods goods);
	
	public Goods selectGoodsByTwoAttributeAndModelId(Goods goods);
	
	public Integer selectGoodsCountByModelId(Goods goods);

	public Integer reduceGoodsInventory(Integer id, Integer count);
}
