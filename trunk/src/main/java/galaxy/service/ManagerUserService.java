package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.ManagerUserDAO;
import galaxy.model.User;

@Service
public class ManagerUserService {
	
	@Autowired
	private ManagerUserDAO dao;
	
	public List<User> selectUser(User user) {
		return  dao.selectUser(user);
	}
	
	public void deleteUser(Integer id,String userIds){
		String[] userIdsArray = userIds.split(",");
		for (String userId : userIdsArray) {
			dao.deleteUser(Integer.parseInt(userId));
		}
	}
}
