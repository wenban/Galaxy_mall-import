package galaxy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.ManagerVipAdvertisementDAO;
import galaxy.model.GoodsModel;
import galaxy.model.GoodsVipAdvertising;
import galaxy.model.User;

@Service
public class ManagerVipAdvertisementService {

	@Autowired
	private ManagerVipAdvertisementDAO managerVipAdvertisementDAO;

	/**
	 * select所有的model用于设置VIP广告
	 * 
	 * @param user
	 * @return
	 */
	public List<GoodsModel> getAllModel(User user) {

		return managerVipAdvertisementDAO.getAllModel(user);

	}

	/**
	 * 设置VIP广告，分为insert（原来没有）和update（原来就有）两种
	 * 
	 * @param goodsVipAdvertising
	 * @return
	 */
	public int setVipAdvertisement(GoodsVipAdvertising goodsVipAdvertising) {

		// 检测model是否存在
		GoodsVipAdvertising vip = managerVipAdvertisementDAO.isVipExist(goodsVipAdvertising);

		if (vip != null) {
			
			return managerVipAdvertisementDAO.updateVipAdvertisement(goodsVipAdvertising);

		} else {

			return managerVipAdvertisementDAO.addNewVipAdvertisement(goodsVipAdvertising);
		}

	}
	
	/**
	 * 查询所有等级的VIP广告
	 */
	public Map<String, List<GoodsVipAdvertising>> showVIPAdvertisementByLevel(){
		
		List<GoodsVipAdvertising> vipList = managerVipAdvertisementDAO.selectAllAdvertisement();
		
		Map<String, List<GoodsVipAdvertising>> hashmap = new HashMap<>();
		
		hashmap.put("VipAdvertisementLevel1", new ArrayList<GoodsVipAdvertising>());
		
		hashmap.put("VipAdvertisementLevel2", new ArrayList<GoodsVipAdvertising>());
		
		hashmap.put("VipAdvertisementLevel3", new ArrayList<GoodsVipAdvertising>());
		
		hashmap.put("VipAdvertisementLevel4", new ArrayList<GoodsVipAdvertising>());
		
		for(GoodsVipAdvertising goodVipAdvertising : vipList){
			
			Integer level = goodVipAdvertising.getVipLevel();
			
			hashmap.get("VipAdvertisementLevel"+level).add(goodVipAdvertising);
			
		}
		
		return hashmap;
	}

	public int deleteVipAdvertisement(GoodsVipAdvertising goodsVipAdvertising) {

		return managerVipAdvertisementDAO.deleteVipAdvertisement(goodsVipAdvertising);
		
	} 
}
