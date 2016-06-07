package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.Store;

@Repository
public interface ManagerStoreDAO {
	public List<Store> selectStore(Store store);
	
	public void deleteStore(Integer id);

}
