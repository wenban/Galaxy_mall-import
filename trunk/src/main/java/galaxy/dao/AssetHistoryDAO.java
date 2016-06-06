package galaxy.dao;

import org.springframework.stereotype.Repository;

import galaxy.model.User;
import galaxy.model.UserAssetHistory;

@Repository
public interface AssetHistoryDAO {
	
	public Integer createAssetHistory(UserAssetHistory uas);
	
	public UserAssetHistory selectAssetHistory(Integer userId);
		
	public Integer selectUserAsset(Integer userId);
	
	public User selectUserByStoreId(Integer storeId);
	
	public Integer changeUserAsset(UserAssetHistory uas);
		
	
}
