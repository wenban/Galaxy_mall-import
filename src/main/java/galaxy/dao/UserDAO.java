package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.User_history;

@Repository
public interface UserDAO {
	public List<User> selectUser(User user);
	public Integer insertIntoUser(User user);
	public User selectUserToLogin(String loginId);
	public List<User_history> selectGoodsByHistory(User user);
	public int deleteHistoryById(User user);
	public User getUserInfo(User user);
	public int updateUserInfo(User user);
	public int updateUserAddInfo(UserAddress userAddress);
	public List<UserAddress> getUserAddrByUserId(User user);
	public int insertIntoUserAddr(UserAddress userAddress);
	public int updateSrcIntoUser(User user);
	public int setStoreId(User user);
}
