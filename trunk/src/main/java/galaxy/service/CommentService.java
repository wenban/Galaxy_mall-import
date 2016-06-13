package galaxy.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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
	 * 查询该orderDetailId是否已经被评价
	 * @param orderDetailId
	 */
	public Integer selectOrderDetailForCheck(Integer orderDetailId) {
		if(commentDAO.selectOrderDetailForCheck(orderDetailId) == null){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 买家评价卖家后更新卖家的level
	 * @param comment
	 */
	public void updateSellerLevel(Comment comment) {
		commentDAO.updateSellerLevel(comment);
	}
	
	/**
	 * 卖家评价买家后更新买家的level
	 * @param comment
	 */
	public void updateCustomerLevel(Comment comment) {
		commentDAO.updateCustomerLevel(comment);
	}
	
	/**
	 * 买家评价卖家后更新model被评价的次数
	 * @param comment
	 */
	public void updateModelCommentCount(Comment comment) {
		commentDAO.updateModelCommentCount(comment);
	}
	
	/**
	 * 用评论的id删除该条评论
	 * @param commentId
	 */
	public void deleteCommentById(Integer orderDetailId) {
		commentDAO.deleteCommentById(orderDetailId);
	}

	/**
	 * 用modelId查询该商品模型收到的的所有评价
	 * 
	 * @return
	 */
	public List<Comment> selectCommentByModelId(Integer modelId) {
		return commentDAO.selectCommentByModelId(modelId);
	}

	/**
	 * 用commentId查询该评论详情
	 * 
	 * @return
	 */
	public List<Comment> selectCommentByCommentId(Integer commentId) {
		return commentDAO.selectCommentByCommentId(commentId);
	}

	/**
	 * 用storeId查询该店铺收到的所有评价
	 * 
	 * @return
	 */
	public List<Comment> selectCommentByStoreId(Integer storeId) {
		return commentDAO.selectCommentByStoreId(storeId);
	}

	/**
	 * 根据用户id查找买家发出的所有评价
	 * 
	 * @return
	 */
	public List<Comment> selectCustomerCommentByUserId() {
		Integer userId = ShiroTool.getUserId();
		return commentDAO.selectCustomerCommentByUserId(userId);
	}

	/**
	 * 根据用户id查找买家收到的所有评价
	 * 
	 * @return
	 */
	public List<Comment> selectSellerCommentByUserId() {
		Integer userId = ShiroTool.getUserId();
		return commentDAO.selectSellerCommentByUserId(userId);
	}

	/**
	 * 更新追加评价
	 * 
	 * @param comment
	 */
	public void updateComment(Comment comment) {
		commentDAO.updateCommentByAdd(comment);
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
		// comment.setOrderDetailId(88);前面传过来orderDetailId
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
			String fileName = imgFile.getOriginalFilename();
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			String newName = new Random().nextInt() + suffix;
			imgFile.transferTo(new File(uploadDir + newName));
			commentImgs.append(newName).append("|");
		}
		return commentImgs.toString();
	}
}
