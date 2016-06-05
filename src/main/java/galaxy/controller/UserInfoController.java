package galaxy.controller;

import java.io.IOException;
import java.util.List;

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
import galaxy.security.ShiroTool;
import galaxy.service.UserInfoService;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService UserService;

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String getUser(Model model, HttpSession session) {
		// User user = (User)session.getAttribute("loginuser");
		// if(user==null){
		// return "login";
		// }
		User fulluser = UserService.getUserInfo(ShiroTool.getLoginUser());
		model.addAttribute("fulluser", fulluser);
		return "userinfo";
	}

	/**
	 * 请求更新用户个人信息
	 * 
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/userInfo/updateUser", method = RequestMethod.GET)
	public String toUpdateUserInfo(Model model, HttpSession session) {
		// User user = (User)session.getAttribute("loginuser");
		// if(user==null){
		// return "login";
		// }
		User fulluser = UserService.getUserInfo(ShiroTool.getLoginUser());
		model.addAttribute("fulluser", fulluser);
		return "toUpdateUserInfo";
	}

	/**
	 * 显示现有的所有收货地址，可以请求添加或者删除或者修改
	 * 
	 * @param model
	 * @param userAddress
	 * @return
	 */
	@RequestMapping(value = "/userInfo/updateUserAddr", method = RequestMethod.GET)
	public String toUpdateAddrInfo(Model model) {
		List<UserAddress> userAddressList = UserService.getUserAddrByUserId(ShiroTool.getLoginUser());
		model.addAttribute("user", ShiroTool.getLoginUser());
		model.addAttribute("userAddressList", userAddressList);
		System.out.println("*");
		return "toUpdateAddrInfo";
	}

	/**
	 * 提交更改个人信息页面
	 * 
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

	@RequestMapping(value = "userInfo/deleteUserAddr", method = RequestMethod.POST)
	public String deleteAddrInfo(Model model, UserAddress userAddress) {
		UserService.deleteAddrInfo(userAddress);
		return "redirect:/userInfo/updateUserAddr";
	}

	@RequestMapping(value = "/userInfo/insertIntoUserAddr/confirm", method = RequestMethod.POST)
	public String insertIntoUserAddr(Model model, UserAddress userAddress) {
		UserService.insertIntoUserAddr(userAddress);
		return "redirect:/userInfo/updateUserAddr";
	}

	@RequestMapping(value = "/userInfo/updateUser/upload")
	@ResponseBody
	public String uploadHeadImage(@RequestParam MultipartFile[] imgFile, HttpSession session) throws IOException {
		// User user = (User)session.getAttribute("loginuser");
		// if(user==null){
		// return "login";
		// }
		/**
		 * 1.把图片放到本地 2.把src写入数据库
		 */
		String headImgSrc = UserService.putImgInLocal(imgFile[0], ShiroTool.getLoginUser());
		System.out.println(headImgSrc);

		return headImgSrc;

	}

	// @RequestMapping(value = "/fileupload")
	// @ResponseBody
	// public String fileupload(@RequestParam("uname") String uname,
	// @RequestParam MultipartFile[] myfiles)
	// throws IOException {
	// System.out.println(uname);
	// String filePath = "D:/";
	// String imagePath = "http://localhost:8080/uploadImages/";
	// String fileName = (int) (Math.random() * 10000) + ".png";
	// System.out.println(fileName);
	//
	// myfiles[0].transferTo(new File(filePath, fileName));
	//
	// System.out.println(imagePath + fileName);
	//
	// return imagePath + fileName;
	// }

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
