package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.User;
import galaxy.model.UserHistory;

@Repository
public interface UserHistoryDAO {
	
	public List<UserHistory> selectGoodsByHistory(User user);

	public int deleteHistoryById(User user);

}
