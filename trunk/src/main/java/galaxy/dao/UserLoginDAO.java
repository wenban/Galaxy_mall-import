package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.UserHistory;

@Repository
public interface UserLoginDAO {
	
	public User selectUserToLogin(String loginId);

}
