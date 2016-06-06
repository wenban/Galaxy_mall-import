package galaxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import galaxy.model.Comment;

@Repository
public interface CommentDAO {
	public Integer insertIntoCommentByCustomer(Comment comment);
	public Integer insertIntoCommentBySeller(Comment comment);
	public Integer updateCommentByAdd(Comment comment);
	public List<Comment> selectCustomerCommentByUserId(Integer userId);
	public List<Comment> selectSellerCommentByUserId(Integer userId);
	public Integer updateCommentBySeller(Comment comment);
}
