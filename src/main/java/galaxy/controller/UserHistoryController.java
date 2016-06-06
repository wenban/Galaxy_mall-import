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

	@RequestMapping(value = "/user/toHistory", method = RequestMethod.GET)
	public String userToHistory(HttpSession session) {
		// User user = (User) session.getAttribute("loginuser");
		// if (user == null) {
		// return "login";
		// }
		return "user_history";
	}

	/**
	 * 查询浏览记录
	 * 
	 * @param model
	 * @param session
	 * @return
	 */

	@RequestMapping(value = "/user/history/select", method = RequestMethod.GET)
	public String userHistorySelect(Model model, HttpSession session) {
		// User user = (User) session.getAttribute("loginuser");
		// if (user == null) {
		// return "login";
		// }
		// List<User_history> historyList = UserService.selectUserHistory(model,
		// session, user);
		List<UserHistory> historyList = UserService.selectUserHistory(ShiroTool.getLoginUser());
		model.addAttribute("historyList", historyList);
		return "user_history";
	}

	/**
	 * 清空浏览记录
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/user/history/delete", method = RequestMethod.GET)
	public String userHistoryDelete(Model model) {
		// User user = (User) session.getAttribute("loginuser");
		// if (user == null) {
		// return "login";
		// },,
		// UserService.deleteUserHistory(model, session, user);
		UserService.deleteUserHistory(ShiroTool.getLoginUser());
		return "user_history";
	}

}
