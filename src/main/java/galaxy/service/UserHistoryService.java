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

import galaxy.dao.UserHistoryDAO;
import galaxy.dao.UserInfoDAO;
import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.UserHistory;
import tool.MyMethod;

@Service
public class UserHistoryService {

	@Autowired
	private UserHistoryDAO userDAO;

	@Value("${upload.file}")
	private String uploadDir;

	@Value("${upload.domain}")
	private String imagesDomain;

	/**
	 * 查询用户浏览记录
	 * 
	 * @param model
	 * @param session
	 * @param user
	 * @return
	 */
	public List<UserHistory> selectUserHistory(User user) {
		List<UserHistory> history = userDAO.selectGoodsByHistory(user);
		return history;
	}

	public void deleteUserHistory(User user) {
		userDAO.deleteHistoryById(user);
	}

}
