package galaxy.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import galaxy.dao.UserInfoDAO;
import galaxy.dao.UserRegisterDAO;
import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.User_history;
import tool.MyMethod;

@Service
public class UserRegisterService {
	@Autowired
	private UserRegisterDAO userDAO;

	/**
	 * 判断用户名是否被注册
	 * 
	 * @param loginId
	 * @return
	 */
	public Integer loginIdIsExist(String loginId) {
		User user = new User();
		user.setLoginId(loginId);
		List<User> userList = userDAO.selectUser(user);
		if (userList.size() > 0) {
			return 1;// 用户名已在数据库中，无法再次注册
		} else {
			return 0;// 该用户名可被注册
		}
	}

	/**
	 * 将用户注册的邮箱，用户名，密码添加至数据库
	 * 
	 * @param user
	 * @return
	 */
	public Integer loginRegisterInsertUser(User user) {
		return userDAO.insertIntoUser(user);
	}

	/**
	 * 判断邮箱是否被注册
	 * 
	 * @param userEmail
	 * @param session
	 * @return
	 * @throws MessagingException
	 */
	public Integer emailIsExist(String userEmail, HttpSession session) throws MessagingException {
		User user = new User();
		user.setUserEmail(userEmail);
		List<User> userList = userDAO.selectUser(user);
		if (userList.size() > 0) {
			return 1;// 邮箱已在数据库中，无法再次注册
		} else {
			session.setAttribute(userEmail, emailConfirm(userEmail));// 发送验证码邮件
			return 0;// 该邮箱可被注册
		}
	}

	/**
	 * 生成随机数发送邮件
	 * 
	 * @param userEmail
	 * @return
	 * @throws MessagingException
	 */
	public String emailConfirm(String userEmail) throws MessagingException {
		// 获取随机数验证码
		String captcha = String.valueOf((int) (Math.random() * 9000 + 1000));
		System.out.println(captcha);
		MyMethod.sendEmail(userEmail, String.valueOf(captcha));

		return captcha;
	}

	/**
	 * 判断验证码是否正确
	 * 
	 * @param userEmail
	 * @param captcha
	 * @param session
	 * @return
	 */
	public int captchaConfirm(String userEmail, String captcha, HttpSession session) {
		if ((String) session.getAttribute(userEmail) == null) {
			return 2;
		}
		String code = (String) session.getAttribute(userEmail);
		if (code.equals(captcha)) {
			return 1;
		} else {
			return 0;
		}
	}

}
