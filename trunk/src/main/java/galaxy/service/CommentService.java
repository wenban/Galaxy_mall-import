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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import galaxy.dao.CommentDAO;
import galaxy.model.Comment;
import galaxy.security.ShiroTool;

@Service
public class CommentService {

	@Value("${upload.file}")
	private String uploadDir;

	@Value("${upload.domain}")
	private String imagesDomain;

	@Autowired
	private CommentDAO commentDAO;
	
	/**
	 * 更新追加评价
	 * @param comment
	 */
	public void updateComment(Comment comment) {
		commentDAO.updateCommentByAdd(comment);
	}
	
	
	/**
	 * 根据用户id查找买家发出的所有评价
	 * @return
	 */
	public List<Comment> selectCustomerCommentByUserId() {
		Integer userId = ShiroTool.getUserId();
		return commentDAO.selectCustomerCommentByUserId(userId);
	}
	
	/**
	 * 根据用户id查找买家收到的所有评价
	 * @return
	 */
	public List<Comment> selectSellerCommentByUserId() {
		Integer userId = ShiroTool.getUserId();
		return commentDAO.selectSellerCommentByUserId(userId);
	}
	
	/**
	 * 上传买家对卖家的评价
	 * 
	 * @param comment
	 */
	public void insertIntoCommentFromCustomer(Comment comment) {
		// 用shiro获取当前登录的用户id
		comment.setUserId(ShiroTool.getUserId());
		commentDAO.insertIntoCommentByCustomer(comment);
	}

	/**
	 * 上传卖家对买家的评价
	 * 
	 * @param comment
	 */
	public void updateCommentFromSeller(Comment comment) {
		// 用shiro获取当前登录的用户id
		//comment.setOrderDetailId(88);前面传过来orderDetailId
		commentDAO.updateCommentBySeller(comment);
	}

	/**
	 * 上传图片至本地并返回图片名称字符串
	 * 
	 * @param imgFiles
	 * @return
	 * @throws IOException
	 */
	public String commentImageUpload(MultipartFile[] imgFiles) throws IOException {
		StringBuffer commentImgs = new StringBuffer();
		for (MultipartFile imgFile : imgFiles) {
			// 读取上传的图片
			InputStream inputImage = imgFile.getInputStream();
			BufferedImage bufferImage = ImageIO.read(inputImage);
			BufferedImage realImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
			realImage.getGraphics().drawImage(bufferImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH), 0, 0, null);

			// 获取文件名和随机数拼接
			String fileName = imgFile.getOriginalFilename();
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			String newName = sdf.format(new Date()) + new Random().nextInt() + suffix;
			commentImgs.append(newName).append("|");

			// 将图片存入本地
			File commentImg = new File(uploadDir + newName);
			ImageIO.write(realImage, "jpg", commentImg);
		}
		return commentImgs.toString();
	}
}
