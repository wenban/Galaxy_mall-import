package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.User;
import galaxy.model.UserHistory;

@Repository
public interface UserHistoryDAO {
	
	public List<UserHistory> selectGoodsByHistory(User user);
	public int insertIntoHistory(UserHistory newHistory);
	public int updateHistoryByModelId(Integer modelId);
	public UserHistory selectHistoryByModelId(Integer modelId);
	public int deleteHistoryById(User user);

}
