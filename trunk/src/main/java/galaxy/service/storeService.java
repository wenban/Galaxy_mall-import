package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.storeDAO;
import galaxy.dao.userDAO;
import galaxy.model.Store;
import galaxy.model.User;

@Service
public class storeService {
	@Autowired
	private storeDAO storeDAO;
	
	@Autowired
	private userDAO userDAO;

	public int selectStoreCount(Store store) {
		return storeDAO.selectStoreCount(store);
	}
	
	public List<Store> selectStore(Store store) {
		return storeDAO.selectStore(store);
	}

	public void createStore(Store store) {
		storeDAO.createStore(store);
		User user=new User();
		user.setId(store.getUserId());
		user.setStoreId(storeDAO.selectStore(store).get(0).getId());
		userDAO.setStoreId(user);
	}

	public void updateStore(Store store) {
		System.out.println(storeDAO.updateStore(store));
	}

	public void removeStore(Store store) {
		storeDAO.deleteStore(store);
	}
	
	public Integer selectExpressExpenses(Integer id) {
		return storeDAO.selectExpressExpenses(id);
	}

}
