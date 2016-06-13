package galaxy.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.Comment;

@Repository
public interface CommentDAO {
	public Integer insertIntoCommentByCustomer(Comment comment);
	public Integer insertIntoCommentBySeller(Comment comment);
	public Integer updateCommentByAdd(Comment comment);
	public Integer updateCommentBySeller(Comment comment);
	public List<Comment> selectCustomerCommentByUserId(Integer userId);
	public List<Comment> selectSellerCommentByUserId(Integer userId);
	public List<Comment> selectCommentByModelId(Integer modelId);
	public List<Comment> selectCommentByCommentId(Integer commentId);
	public List<Comment> selectCommentByStoreId(Integer storeId);
	public Integer selectOrderDetailForCheck(Integer orderDetailId);
	public Integer deleteCommentById(Integer orderDetailId);
	public Integer updateSellerLevel(Comment comment);
	public Integer updateCustomerLevel(Comment comment);
	public Integer updateModelCommentCount(Comment comment);
	
}
