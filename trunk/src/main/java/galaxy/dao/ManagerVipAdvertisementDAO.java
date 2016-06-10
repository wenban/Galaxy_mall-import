package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.GoodsModel;
import galaxy.model.GoodsVipAdvertising;
import galaxy.model.User;

@Repository
public interface ManagerVipAdvertisementDAO {

	public List<GoodsModel> getAllModel(User user);

	public GoodsVipAdvertising isVipExist(GoodsVipAdvertising goodsVipAdvertising);

	public int addNewVipAdvertisement(GoodsVipAdvertising goodsVipAdvertising);

	public int updateVipAdvertisement(GoodsVipAdvertising goodsVipAdvertising);
	
	public List<GoodsVipAdvertising> selectAllAdvertisement();

	public int deleteVipAdvertisement(GoodsVipAdvertising goodsVipAdvertising);

	
}
