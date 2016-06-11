package galaxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.UserHistoryDAO;
import galaxy.model.User;
import galaxy.model.UserHistory;
import galaxy.security.ShiroTool;

@Service
public class UserHistoryService {

	@Autowired
	private UserHistoryDAO userDAO;

	// 更新浏览记录
	public void updateHistoryByModelId(Integer modelId) {
		UserHistory history = userDAO.selectHistoryByModelId(modelId);
		if (history == null || "".equals(history)) {
			Integer userId=ShiroTool.getUserId();
			UserHistory newHistory = new UserHistory();
			newHistory.setUserId(userId);
			newHistory.setModelId(modelId);
			userDAO.insertIntoHistory(newHistory);
		} else {
			userDAO.updateHistoryByModelId(history.getModelId());
		}
	}

	// 查询用户浏览记录
	public List<UserHistory> selectUserHistory(User user) {
		List<UserHistory> history = userDAO.selectGoodsByHistory(user);
		return history;
	}

	// 清除用户浏览记录
	public void deleteUserHistory(User user) {
		userDAO.deleteHistoryById(user);
	}

}
