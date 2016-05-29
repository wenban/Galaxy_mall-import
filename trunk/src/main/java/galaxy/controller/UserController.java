package galaxy.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import galaxy.model.User;
import galaxy.service.UserService;
import tool.MyMethod;

@Controller
public class UserController {
	@Autowired
	private UserService UserService;

	@Autowired
	private FreeMarkerConfigurer config;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String freemarkerModel(Model model) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, TemplateException, IOException {
		User user = new User();
		user.setUserName("gblwss");
		System.out.println(user.getUserName());
		model.addAttribute("user", user);
		StringWriter out = new StringWriter();
		config.getConfiguration().getTemplate("test.ftl").process(model, out);
		MyMethod.buildHTML("test", out.toString());
		return "test";
	}

	// 访问邮箱注册页面
	@RequestMapping(value = "/user/toRegister", method = RequestMethod.GET)
	public String userToRegister() {
		return "register_emailconfirm";
	}

	// 判断邮箱是否已被注册并发送
	@RequestMapping("/user/register/emailConfirm")
	@ResponseBody
	public Integer userRegisterEmailConfirm(String userEmail, HttpSession session) throws MessagingException {
		return UserService.emailIsExist(userEmail, session);
	}

	// 判断验证码是否正确
	@RequestMapping("/user/register/captchaConfirm")
	public String userRegisterCaptchaConfirm(Model model, String userEmail, String captcha, HttpSession session)
			throws MessagingException {
		if (UserService.captchaConfirm(userEmail, captcha, session) == 1) {
			return "register";
		} else if (UserService.captchaConfirm(userEmail, captcha, session) == 2) {
			model.addAttribute("captchaError", "邮箱输入错误！");
			return "register_emailconfirm";
		} else {
			model.addAttribute("captchaError", "验证码错误！");
			return "register_emailconfirm";
		}
	}

	// 跳转至用户名密码注册页面，还没写完
	@RequestMapping("/user/register")
	public String userRegister(Model model, String userEmail, String captcha) {
		model.addAttribute("userEmail", userEmail);
		return "register";
	}

}
