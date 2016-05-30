package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.GoodsDAO;
import galaxy.model.Goods;
import galaxy.model.Store;

@Service
public class GoodsService {
	@Autowired
	private GoodsDAO GoodsDAO;
	
	public void selectGoods(Goods goods) {

	}
	
	public void createGoods(Goods goods) {

	}

	public void updateGoods(Goods goods) {

	}

	public void removeGoods(Goods goods) {

	}
}
