package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.StoreDAO;
import galaxy.dao.UserInfoDAO;
import galaxy.model.Store;
import galaxy.model.User;

@Service
public class StoreService {

	@Autowired
	private StoreDAO storeDAO;

	@Autowired
	private UserInfoDAO userDAO;

	public int selectStoreCount(Store store) {
		return storeDAO.selectStoreCount(store);
	}

	public List<Store> selectStore(Store store) {
		return storeDAO.selectStore(store);
	}

	public Store selectOneStore(Store store) {
		return storeDAO.selectOneStoreById(store);
	}

	public void createStore(Store store) {
		storeDAO.createStore(store);
		User user = new User();
		user.setId(store.getUserId());
		user.setStoreId(store.getId());
		userDAO.setStoreIdToUserByUserId(user);
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
