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
import galaxy.model.User;
import galaxy.model.UserAddress;
import galaxy.model.User_history;
import tool.MyMethod;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDAO userDAO;

	@Value("${upload.file}")
	private String uploadDir;

	@Value("${upload.domain}")
	private String imagesDomain;

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
		// 获取文件名和随机数拼接
		String fileName = imgFile.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		String newName = sdf.format(new Date()) + new Random().nextInt() + suffix;
		File headImg = new File(uploadDir + newName);
		ImageIO.write(realImage, "jpg", headImg);
		// 把src写入到数据库
		user.setUserHeadImages(newName);
		userDAO.updateSrcIntoUser(user);

		return imagesDomain + newName;
	}

	public int deleteAddrInfo(UserAddress userAddress) {
		return userDAO.deleteUserAddrById(userAddress);
	}

}
