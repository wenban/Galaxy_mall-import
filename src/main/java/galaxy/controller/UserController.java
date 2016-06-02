package galaxy.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.User_history;
import galaxy.security.ShiroTool;
import galaxy.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService UserService;
	
	@RequestMapping(value = "/user/toHistory", method = RequestMethod.GET)
	public String userToHistory(HttpSession session) {
//		User user = (User) session.getAttribute("loginuser");
//		if (user == null) {
//			return "login";
//		}
		return "user_history";
	}
	
	/**
	 * 查询浏览记录
	 * @param model
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value = "/user/history/select", method = RequestMethod.GET)
	public String userHistorySelect(Model model, HttpSession session) {
//		User user = (User) session.getAttribute("loginuser");
//		if (user == null) {
//			return "login";
//		}
//		List<User_history> historyList = UserService.selectUserHistory(model, session, user);
		List<User_history> historyList = UserService.selectUserHistory(ShiroTool.getLoginUser());
		model.addAttribute("historyList", historyList);
		return "user_history";
	}
	
	/**
	 * 清空浏览记录
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/user/history/delete", method = RequestMethod.GET)
	public String userHistoryDelete(Model model, HttpSession session) {
//		User user = (User) session.getAttribute("loginuser");
//		if (user == null) {
//			return "login";
//		}
//		UserService.deleteUserHistory(model, session, user);
		UserService.deleteUserHistory(ShiroTool.getLoginUser());
		return "user_history";
	}

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
	//登录失败
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session, User user) {
//		System.out.println(user.getLoginId());
//		System.out.println(user.getLoginPassWord());
//		User loginuser = UserService.login(model, session, user);
//		if (loginuser == null) {
//			model.addAttribute("error", "该用户不存在");
//			return "login";
//		}
//		if (!user.getLoginPassWord().equals(loginuser.getLoginPassWord())) {
//			model.addAttribute("error", "用户密码错误");
//			return "login";
//		}
//		session.setAttribute("loginuser", loginuser);
//		return "index";
		model.addAttribute("error", "登录失败");
		return "login";
	}
	
	//登录成功
	@RequestMapping(value = "/login/success", method = RequestMethod.GET)
	public String main(Model model) {
		System.out.println(ShiroTool.getLoginId());
		System.out.println(ShiroTool.getUserName());
		System.out.println(ShiroTool.getUserId());
		System.out.println(ShiroTool.getStoreId());
		return "index";
	}

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
	 * 判断邮箱是否已被注册并发送
	 * 
	 * @param userEmail
	 * @param session
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping(value = "/user/register/emailConfirm", method = RequestMethod.GET)
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
	@RequestMapping(value = "/user/register/captchaConfirm", method = RequestMethod.POST)
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
	@RequestMapping(value = "/user/register/loginIdConfirm", method = RequestMethod.GET)
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
	@RequestMapping(value = "/user/insert/loginRegister", method = RequestMethod.POST)
	public String userInsertLoginRegister(Model model, User user) {
		UserService.loginRegisterInsertUser(user);
		return "login";
	}


	/**
	 * 根据session里的loginuser属性判断是否登录，访问用户个人详细信息页面
	 * @param model
	 * @param session
	 * @return
	 */
		@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
		public String getUser(Model model, HttpSession session) {
//			User user = (User)session.getAttribute("loginuser");
//			if(user==null){
//				return "login";
//			}
			User fulluser = UserService.getUserInfo(ShiroTool.getLoginUser());
			model.addAttribute("fulluser", fulluser);
			return "userinfo";
		}
		
		/**
		 * 请求更新用户个人信息
		 * @param model
		 * @param user
		 * @return
		 */
		@RequestMapping(value = "/userInfo/updateUser", method = RequestMethod.GET)
		public String toUpdateUserInfo(Model model,  HttpSession session) {
//			User user = (User)session.getAttribute("loginuser");
//			if(user==null){
//				return "login";
//			}
			User fulluser = UserService.getUserInfo(ShiroTool.getLoginUser());
			model.addAttribute("fulluser", fulluser);
			return "toUpdateUserInfo";
		}
		
		/**
		 * 显示现有的所有收货地址，可以请求添加或者删除或者修改
		 * @param model
		 * @param userAddress
		 * @return
		 */
		@RequestMapping(value = "/userInfo/updateUserAddr", method = RequestMethod.GET)
		public String toUpdateAddrInfo(Model model,HttpSession session) {
//			User user = (User)session.getAttribute("loginuser");
//			if(user==null){
//				return "login";
//			}
			List<UserAddress> userAddressList = UserService.getUserAddrByUserId(ShiroTool.getLoginUser());
//			if(userAddressList.size()==0){
//				userService.createFirstAddrByUserId(user);
//				userAddressList = userService.getUserAddrByUserId(user);//再取一次
//			}
			model.addAttribute("user", ShiroTool.getLoginUser());
			model.addAttribute("userAddressList", userAddressList);
			System.out.println("*");
			return "toUpdateAddrInfo";
		}
		
		/**
		 * 提交更改个人信息页面
		 * @param model
		 * @param user
		 * @return
		 */
		@RequestMapping(value = "/userInfo/updateUser/confirm", method = RequestMethod.POST)
		public String updateUserInfo(Model model, User user) {
			UserService.updateUserInfo(user);
			return "redirect:/userInfo";
		}
		
		@RequestMapping(value = "/userInfo/updateUserAddr/confirm", method = RequestMethod.POST)
		public String updateAddrInfo(Model model, UserAddress userAddress) {
			UserService.updateAddrInfo(userAddress);
			return "redirect:/userInfo";
		}
		
		@RequestMapping(value = "/userInfo/insertIntoUserAddr/confirm", method = RequestMethod.POST)
		public String insertIntoUserAddr(Model model, UserAddress userAddress) {
			UserService.insertIntoUserAddr(userAddress);
			return "redirect:/userInfo/updateUserAddr";
		}
		
		@RequestMapping(value = "/userInfo/updateUser/upload")
		@ResponseBody
		public String uploadHeadImage(@RequestParam MultipartFile[] imgFile,HttpSession session) throws IOException {
//				User user = (User)session.getAttribute("loginuser");
//				if(user==null){
//					return "login";
//				}
			/**
			 * 1.把图片放到本地
			 * 2.把src写入数据库
			 */
			String headImgSrc = UserService.putImgInLocal(imgFile[0] , ShiroTool.getLoginUser());
			System.out.println(headImgSrc);

			return headImgSrc;
			
		}

//		@RequestMapping(value = "/fileupload")
//		@ResponseBody
//		public String fileupload(@RequestParam("uname") String uname, @RequestParam MultipartFile[] myfiles)
//				throws IOException {
//			System.out.println(uname);
//			String filePath = "D:/";
//			String imagePath = "http://localhost:8080/uploadImages/";
//			String fileName = (int) (Math.random() * 10000) + ".png";
//			System.out.println(fileName);
//
//			myfiles[0].transferTo(new File(filePath, fileName));
//
//			System.out.println(imagePath + fileName);
//
//			return imagePath + fileName;
//		}


	// @RequestMapping(value = "/test", method = RequestMethod.GET)
	// public ModelAndView test(Model model) {
	// ModelAndView mv = new ModelAndView("test");
	// User user = new User();
	// user.setUserName("gblw");
	// System.out.println(user.getUserName());
	// mv.addObject("user", user);
	// return mv;
	// }
}
