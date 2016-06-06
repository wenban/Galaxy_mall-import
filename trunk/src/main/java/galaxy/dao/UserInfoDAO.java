package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.UserHistory;

@Repository
public interface UserInfoDAO {
	
	public User getUserInfo(User user);

	public int updateUserInfo(User user);

	public int updateUserAddInfo(UserAddress userAddress);

	public List<UserAddress> getUserAddrByUserId(User user);

	public int insertIntoUserAddr(UserAddress userAddress);

	public int updateSrcIntoUser(User user);

	public int setStoreIdToUserByUserId(User user);
	
	public int deleteUserAddrById(UserAddress userAddress);
}
