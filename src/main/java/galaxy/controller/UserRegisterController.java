package galaxy.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import galaxy.model.User;
import galaxy.service.UserRegisterService;

@Controller
public class UserRegisterController {
	@Autowired
	private UserRegisterService UserService;

	/**
	 * 访问邮箱注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/toRegister", method = RequestMethod.GET)
	public String userToRegister() {
		return "register_emailconfirm";
	}

	/**
	 * 判断邮箱是否已被注册并发送验证码
	 * 
	 * @param userEmail
	 * @param session
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping(value = "/user/register/email_confirm", method = RequestMethod.GET)
	@ResponseBody
	public Integer userRegisterEmailConfirm(String userEmail, HttpSession session) throws MessagingException {
		return UserService.emailIsExist(userEmail, session);
	}

	/**
	 * 判断验证码是否正确
	 * 
	 * @param model
	 * @param userEmail
	 * @param captcha
	 * @param session
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping(value = "/user/register/captcha_confirm", method = RequestMethod.POST)
	public String userRegisterCaptchaConfirm(Model model, String userEmail, String captcha, HttpSession session)
			throws MessagingException {
		if (UserService.captchaConfirm(userEmail, captcha, session) == 1) {
			model.addAttribute("userEmail", userEmail);
			return "register";
		} else if (UserService.captchaConfirm(userEmail, captcha, session) == 2) {
			model.addAttribute("captchaError", "邮箱输入错误！");
			return "register_emailconfirm";
		} else {
			model.addAttribute("captchaError", "验证码错误！");
			return "register_emailconfirm";
		}
	}

	/**
	 * 判断用户名是否已被注册
	 * 
	 * @param model
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/user/register/loginId_confirm", method = RequestMethod.GET)
	@ResponseBody
	public Integer userRegisterLoginIdConfirm(Model model, String loginId) {
		return UserService.loginIdIsExist(loginId);
	}

	/**
	 * 注册，将用户的邮箱，用户名，密码存入数据库
	 * 
	 * @param model
	 * @param user
	 */
	@RequestMapping(value = "/user/insert/login_register", method = RequestMethod.POST)
	public String userInsertLoginRegister(Model model, User user) {
		UserService.loginRegisterInsertUser(user);
		return "login";
	}

}
