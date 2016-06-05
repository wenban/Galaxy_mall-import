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

import galaxy.dao.UserDAO;
import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.User_history;
import tool.MyMethod;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	

	@Value("${upload.file}")
	private String uploadDir;

	@Value("${upload.domain}")
	private String imagesDomain;
	
	/**
	 * 查询用户浏览记录
	 * @param model
	 * @param session
	 * @param user
	 * @return
	 */
	public List<User_history> selectUserHistory(User user) {
		List<User_history> history = userDAO.selectGoodsByHistory(user);
		return history;
	}
	
	public void deleteUserHistory(User user) {
		userDAO.deleteHistoryById(user);
	}

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

	public User getUserInfo(User user) {
		return userDAO.getUserInfo(user);
	}



	public void updateUserInfo(User user) {
		userDAO.updateUserInfo(user);
		return;
	}

	public void updateAddrInfo(UserAddress userAddress) {
		userDAO.updateUserAddInfo(userAddress);
		return;
	}

	public List<UserAddress> getUserAddrByUserId(User user) {
		
		return userDAO.getUserAddrByUserId(user);
	}



	public int insertIntoUserAddr(UserAddress userAddress) {
		return userDAO.insertIntoUserAddr(userAddress);
		
	}

	public String putImgInLocal(MultipartFile imgFile, User user) throws IOException {
		InputStream inputImage = imgFile.getInputStream();
		BufferedImage bufferImage = ImageIO.read(inputImage);
		BufferedImage realImage = new BufferedImage(40, 40, BufferedImage.TYPE_INT_RGB);
		realImage.getGraphics().drawImage(bufferImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH), 0, 0, null);
		//获取文件名和随机数拼接
		String fileName = imgFile.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		String newName = sdf.format(new Date())+new Random().nextInt() + suffix;
		File headImg = new File(uploadDir+newName);
		ImageIO.write(realImage, "jpg", headImg);
		//把src写入到数据库
		user.setUserHeadImages(newName);
		userDAO.updateSrcIntoUser(user);
		
		return imagesDomain+newName;
	}

	public int deleteAddrInfo(UserAddress userAddress) {
		return userDAO.deleteUserAddrById(userAddress);
	}

	

}
