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
import galaxy.dao.UserLoginDAO;
import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.UserHistory;
import tool.MyMethod;

@Service
public class UserLoginService {
	@Autowired
	private UserLoginDAO userDAO;

	/**
	 * 根据用户名判断用户是否存在；若存在，判断输入的密码是否等于该用户的密码；并把 用户的登录信息放到session里
	 * 
	 * @param model
	 * @param session
	 * @param user
	 * @return
	 */
	public User login(String loginId) {
		return userDAO.selectUserToLogin(loginId);
	}

}
