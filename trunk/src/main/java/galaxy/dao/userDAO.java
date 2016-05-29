package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.User;

@Repository
public interface userDAO {
	public List<User> selectUser(User user);
	public Integer insertUser(User user);
	public int setStoreId(User user);

}
