package galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.AssetHistoryDAO;
import galaxy.model.User;
import galaxy.model.UserAssetHistory;
import galaxy.security.ShiroTool;


@Service
public class AssetHistoryService {
	
	@Autowired
	private AssetHistoryDAO assetHistoryDAO;
	
	
	public void selectAssetHistory(Integer userId) {
		assetHistoryDAO.selectAssetHistory(userId);
	}
	
	public void userAssetChange(Double assetChange,Integer userId) {
		UserAssetHistory uah=new UserAssetHistory();
		Integer userAsset=assetHistoryDAO.selectUserAsset(userId);
		uah.setAssetChange(assetChange);
		uah.setUserId(userId);
		uah.setUserAsset(userAsset+assetChange);
		assetHistoryDAO.createAssetHistory(uah);
		assetHistoryDAO.changeUserAsset(uah);
	}
	
	public void storeAssetChange(Double assetChange,Integer storeId) {
		UserAssetHistory uah=new UserAssetHistory();
		User user=assetHistoryDAO.selectUserByStoreId(storeId);
		uah.setAssetChange(assetChange);
		uah.setUserId(user.getId());
		uah.setUserAsset(user.getUserAsset()+assetChange);
		assetHistoryDAO.createAssetHistory(uah);
		assetHistoryDAO.changeUserAsset(uah);
	}
	
}
