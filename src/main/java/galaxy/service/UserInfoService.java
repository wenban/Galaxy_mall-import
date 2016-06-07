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
import galaxy.model.UserHistory;
import tool.MyMethod;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDAO userDAO;

	@Value("${upload.file}")
	private String uploadDir;

	@Value("${upload.domain}")
	private String imagesDomain;

	/**
	 * 获取用户个人信息
	 * 
	 * @param user
	 * @return
	 */
	public User getUserInfo(User user) {
		return userDAO.getUserInfo(user);
	}

	/**
	 * 获取用户地址信息
	 * 
	 * @param user
	 * @return
	 */
	public List<UserAddress> getUserAddrByUserId(User user) {
		return userDAO.getUserAddrByUserId(user);
	}

	/**
	 * 更改用户个人信息
	 * 
	 * @param user
	 */
	public void updateUserInfo(User user) {
		userDAO.updateUserInfo(user);
		return;
	}

	/**
	 * 更高用户地址信息
	 * 
	 * @param userAddress
	 */
	public void updateAddrInfo(UserAddress userAddress) {
		userDAO.updateUserAddInfo(userAddress);
		return;
	}

	/**
	 * 添加新的地址
	 * 
	 * @param userAddress
	 * @return
	 */
	public int insertIntoUserAddr(UserAddress userAddress) {
		return userDAO.insertIntoUserAddr(userAddress);

	}

	/**
	 * 上传用户头像
	 * 
	 * @param imgFile
	 * @param user
	 * @return
	 * @throws IOException
	 */
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
		user.setUserHeadImages(imagesDomain + newName);
		userDAO.updateSrcIntoUser(user);

		return imagesDomain + newName;
	}

	/**
	 * 上传真实照片
	 * @param multipartFile
	 * @param loginUser
	 * @return
	 * @throws IOException 
	 */
	public String putRealImgInLocal(MultipartFile imgFile, User user) throws IOException {
		InputStream inputImage = imgFile.getInputStream();
		BufferedImage bufferImage = ImageIO.read(inputImage);
		BufferedImage realImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		realImage.getGraphics().drawImage(bufferImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH), 0, 0, null);
		// 获取文件名和随机数拼接
		String fileName = imgFile.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		String newName = sdf.format(new Date()) + new Random().nextInt() + suffix;
		File headImg = new File(uploadDir + newName);
		ImageIO.write(realImage, "jpg", headImg);
		// 把src写入到数据库
		user.setRealPhoto(imagesDomain + newName);
		userDAO.updateRealSrcIntoUser(user);

		return imagesDomain + newName;
	}

	/**
	 * 删除用户地址
	 * 
	 * @param userAddress
	 * @return
	 */
	public int deleteAddrInfo(UserAddress userAddress) {
		return userDAO.deleteUserAddrById(userAddress);
	}

	/**
	 * 根据Address的id获取用户地址，用于地址修改
	 * 
	 * @param id
	 * @return
	 */
	public UserAddress selectUserAddrById(Integer id) {
		return userDAO.selectUserAddrById(id);
	}

	/**
	 * 设置默认地址，先清空再设置
	 * 
	 * @param id
	 * @return
	 */
	public int setDefaultAddr(Integer id) {
		userDAO.clearDefaultAddr();
		return userDAO.setDefaultAddr(id);
	}

	/**
	 * 卖家实名认证
	 * @param user
	 * @return
	 */
	public int setSellerCertification(User user) {
		return userDAO.setSellerCertification(user);
	}

	public Integer getAddrCount(Integer userId) {
		return userDAO.getAddrCount(userId);
	}

}
