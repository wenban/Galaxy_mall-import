package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.StoreDAO;
import galaxy.dao.UserDAO;
import galaxy.model.Store;
import galaxy.model.User;

@Service
public class StoreService {
	@Autowired
	private StoreDAO StoreDAO;
	
	@Autowired
	private UserDAO UserDAO;

	public int selectStoreCount(Store store) {
		return StoreDAO.selectStoreCount(store);
	}
	
	public List<Store> selectStore(Store store) {
		return StoreDAO.selectStore(store);
	}
	
	public Store selectOneStore(Store store) {
		return StoreDAO.selectOneStoreById(store);
	}
	

	public void createStore(Store store) {
		StoreDAO.createStore(store);
		User user=new User();
		user.setId(store.getUserId());
		user.setStoreId(StoreDAO.selectStore(store).get(0).getId());
		UserDAO.setStoreId(user);
	}

	public void updateStore(Store store) {
		System.out.println(StoreDAO.updateStore(store));
	}

	public void removeStore(Store store) {
		StoreDAO.deleteStore(store);
	}
	
	public Integer selectExpressExpenses(Integer id) {
		return StoreDAO.selectExpressExpenses(id);
	}

}
