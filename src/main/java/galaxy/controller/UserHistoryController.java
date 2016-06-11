package galaxy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import galaxy.model.UserHistory;
import galaxy.security.ShiroTool;
import galaxy.service.UserHistoryService;

@Controller
public class UserHistoryController {

	@Autowired
	private UserHistoryService UserService;

	// 更新浏览记录
	@RequestMapping(value = "/user/history/update", method = RequestMethod.GET)
	public String userHistoryUpdate(Integer modelId) {
		modelId=15;
		UserService.updateHistoryByModelId(modelId);
		return "user_history";
	}
	
	// 跳到浏览记录页
	@RequestMapping(value = "/user/toHistory", method = RequestMethod.GET)
	public String userToHistory() {
		return "user_history";
	}

	// 查询浏览记录
	@RequestMapping(value = "/user/history/select", method = RequestMethod.GET)
	public String userHistorySelect(Model model) {
		List<UserHistory> historyList = UserService.selectUserHistory(ShiroTool.getLoginUser());
		model.addAttribute("historyList", historyList);
		return "user_history";
	}

	// 清空浏览记录
	@RequestMapping(value = "/user/history/delete", method = RequestMethod.GET)
	public String userHistoryDelete(Model model) {
		UserService.deleteUserHistory(ShiroTool.getLoginUser());
		return "user_history";
	}

}
