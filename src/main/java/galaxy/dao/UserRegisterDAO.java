package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.UserHistory;

@Repository
public interface UserRegisterDAO {
	
	public List<User> selectUser(User user);

	public Integer insertIntoUser(User user);

}
