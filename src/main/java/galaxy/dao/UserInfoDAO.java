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
	
	public UserAddress selectUserDefaultAddrById(Integer userId);

	public int insertIntoUserAddr(UserAddress userAddress);

	public int updateSrcIntoUser(User user);

	public int setStoreIdToUserByUserId(User user);
	
	public int deleteUserAddrById(UserAddress userAddress);

	public UserAddress selectUserAddrById(Integer id);

	public int clearDefaultAddr();

	public int setDefaultAddr(Integer id);

	public int setSellerCertification(User user);

	public int updateRealSrcIntoUser(User user);

	public Integer getAddrCount(Integer userId);
}
