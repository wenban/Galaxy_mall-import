package galaxy.dao;

import java.util.List;

import galaxy.model.User;

public interface ManagerUserDAO {
     public List<User> selectUser(User user);
	
	public void deleteUser(Integer id);


}
