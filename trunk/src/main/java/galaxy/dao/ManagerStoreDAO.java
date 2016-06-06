package galaxy.dao;

import java.util.List;

import galaxy.model.Store;

public interface ManagerStoreDAO {
	public List<Store> selectStore(Store store);
	
	public void deleteStore(Integer id);

}
