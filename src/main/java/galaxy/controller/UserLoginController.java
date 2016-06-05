package galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import galaxy.model.User;
import galaxy.security.ShiroTool;
import galaxy.service.UserLoginService;

@Controller
public class UserLoginController {

	/**
	 * 处理查询用户登录信息，跳转到login.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginUser() {
		return "login";
	}

	/**
	 * 处理提交用户登录的信息
	 * 
	 * @param model
	 * @param session
	 * @param user
	 * @return
	 */
	// 登录失败
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, User user) {
		model.addAttribute("error", "登录失败");
		return "login";
	}

	// 登录成功
	@RequestMapping(value = "/login/success", method = RequestMethod.GET)
	public String main(Model model) {
		ShiroTool.getLoginId();
		ShiroTool.getUserName();
		ShiroTool.getUserId();
		ShiroTool.getStoreId();
		return "index";
	}

	
}
