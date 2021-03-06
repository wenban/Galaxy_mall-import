package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.Store;

@Repository
public interface StoreDAO {
	public int createStore(Store store);
	
	public Store selectOneStoreById(Store store);

	public Integer selectStoreCount(Store store);
	
	public List<Store> selectStoreList(Store store);

	public int updateStore(Store store);

	public int deleteStore(Store store);

	public Integer selectExpressExpenses(Integer id);

}
