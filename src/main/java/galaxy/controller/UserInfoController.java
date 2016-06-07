package galaxy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String toUpdateUserInfo(Model model) {
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
	@RequestMapping(value = "/userInfo/getUserAddr", method = RequestMethod.GET)
	public String toUpdateAddrInfo(Model model) {
		List<UserAddress> userAddressList = UserService.getUserAddrByUserId(ShiroTool.getLoginUser());
		model.addAttribute("user", ShiroTool.getLoginUser());
		model.addAttribute("userAddressList", userAddressList);
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

	/**
	 * 请求更新用户的其中一个地址 跳转到修改地址页面
	 * 
	 * @param model
	 * @param userAddress
	 * @return
	 */
	@RequestMapping(value = "/userInfo/toUpdateOneUserAddr", method = RequestMethod.POST)
	public String toUpdateOneUserAddr(Model model, UserAddress userAddress) {
		UserAddress selectedAddr = UserService.selectUserAddrById(userAddress.getId());
		model.addAttribute("selectedAddr", selectedAddr);
		return "toUpdateUserAddr_branch";
	}

	/**
	 * 用户修改一条地址完成 重定向到显示地址页面
	 * 
	 * @param model
	 * @param userAddress
	 * @return
	 */
	@RequestMapping(value = "/userInfo/updateUserAddr/confirm", method = RequestMethod.POST)
	public String updateAddrInfo(Model model, UserAddress userAddress) {
		UserService.updateAddrInfo(userAddress);
		return "redirect:/userInfo/getUserAddr";
	}

	/**
	 * 删除其中一条地址
	 * 
	 * @param model
	 * @param userAddress
	 * @return
	 */
	@RequestMapping(value = "/userInfo/deleteUserAddr", method = RequestMethod.POST)
	public String deleteAddrInfo(Model model, UserAddress userAddress) {
		UserService.deleteAddrInfo(userAddress);
		return "redirect:/userInfo/getUserAddr";
	}

	/**
	 * 设置用户的默认地址
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/userInfo/toUpdateOneUserAddr/setDefaultAddr/{id}", method = RequestMethod.GET)
	public String setDefaultAddr(@PathVariable Integer id) {
		UserService.setDefaultAddr(id);
		return "redirect:/userInfo/getUserAddr";
	}

	/**
	 * 添加新的地址
	 * 
	 * @param model
	 * @param userAddress
	 * @return
	 */
	@RequestMapping(value = "/userInfo/insertIntoUserAddr/confirm", method = RequestMethod.POST)
	public String insertIntoUserAddr(Model model, UserAddress userAddress) {
		Integer addrCount = UserService.getAddrCount(userAddress.getUserId());
		if (addrCount >= 6){
			model.addAttribute("TooManyAddresses","太多地址了！");
			List<UserAddress> userAddressList = UserService.getUserAddrByUserId(ShiroTool.getLoginUser());
			model.addAttribute("user", ShiroTool.getLoginUser());
			model.addAttribute("userAddressList", userAddressList);
			return "toUpdateAddrInfo";
		}else{
			UserService.insertIntoUserAddr(userAddress);
			return "redirect:/userInfo/getUserAddr";
		}
	}

	/**
	 * 上传头像
	 * 
	 * @param imgFile
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/userInfo/updateUser/upload")
	@ResponseBody
	public String uploadHeadImage(@RequestParam MultipartFile[] imgFile) throws IOException {
		// 1.把图片放到本地 2.把src写入数据库
		String headImgSrc = UserService.putImgInLocal(imgFile[0], ShiroTool.getLoginUser());
		System.out.println(headImgSrc);
		return headImgSrc;
	}

	/**
	 * 实名认证卖家
	 */
	@RequestMapping(value = "/userInfo/sellerCertification", method = RequestMethod.GET)
	public String sellerCertification(Model model) {
			User user = ShiroTool.getLoginUser();
			model.addAttribute("seller", user);
			return "sellerCertification";
	}

	/**
	 * 实名认证卖家上传头像
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/userInfo/sellerCertification/upload", method = RequestMethod.POST )
	@ResponseBody
	public String sellerCertificationUpload(@RequestParam MultipartFile[] imgFile) throws IOException {
		/**
		 * 1.把图片放到本地 2.把src写入数据库
		 */
		String realImgSrc = UserService.putRealImgInLocal(imgFile[0], ShiroTool.getLoginUser());

		return realImgSrc;
	}

	@RequestMapping(value = "/userInfo/sellerCertification/confirm", method = RequestMethod.POST)
	public String sellerCertificationConfirm(User user) {
		UserService.setSellerCertification(user);
		return "index";
	}

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
