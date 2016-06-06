package galaxy.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import galaxy.model.Comment;
import galaxy.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService CommentService;

	// 点击买家评价卖家按钮后跳转到JSP
	@RequestMapping(value = "/comment/customer/to/seller", method = RequestMethod.GET)
	public String commentCustomerToSeller(Model model,Integer orderDetailId,Integer goodsId) {
		model.addAttribute("orderDetailId", orderDetailId);
		model.addAttribute("goodsId", goodsId);
		return "comment_customer_to_seller";
	}

	// 点击卖家评价买家按钮后跳转到JSP
	@RequestMapping(value = "/comment/seller/to/customer", method = RequestMethod.GET)
	public String commentSellerToCustomer() {
		return "comment_seller_to_customer";
	}

	// 上传买家评价的图片
	@RequestMapping(value = "/comment/upload", method = RequestMethod.POST)
	@ResponseBody
	public String commentUpload(@RequestParam MultipartFile[] imgFiles, Model model) throws IOException {
		String src = CommentService.commentImageUpload(imgFiles);
		model.addAttribute("commentImages", src);
		return src;
	}

	// 接收买家上传的评价数据并存入数据库中
	@RequestMapping(value = "/comment/from/customer", method = RequestMethod.POST)
	public String commentFromCustomer(Comment comment) {
		CommentService.insertIntoCommentFromCustomer(comment);
		return "index";
	}
	
	// 接收卖家上传的评价数据并更新至数据库中
	@RequestMapping(value = "/comment/from/seller", method = RequestMethod.POST)
	public String commentFromSeller(Comment comment) {
		CommentService.updateCommentFromSeller(comment);
		return "user_comment";
	}
	
	// 查找我发出的评价
	@RequestMapping(value = "/comment/select/send", method = RequestMethod.GET)
	public String commentSelectSend(Model model){
		model.addAttribute("customerCommentList", CommentService.selectCustomerCommentByUserId());
		return "user_comment";
	}
	
	// 查找我收到的评价
	@RequestMapping(value = "/comment/select/receive", method = RequestMethod.GET)
	public String commentSelectReceive(Model model){
		model.addAttribute("sellerCommentList", CommentService.selectSellerCommentByUserId());
		return "user_comment";
	}
	
	// 跳转到追加评价的页面
	@RequestMapping(value = "/comment/add", method = RequestMethod.GET)
	public String commentAdd(Model model, Integer orderDetailId){
		model.addAttribute("orderDetailId", orderDetailId);
		return "comment_add";
	}
	
	// 更新追加的评价到数据库中
	@RequestMapping(value = "/comment/add/update", method = RequestMethod.POST)
	public String commentAddUpdate(Comment comment){
		CommentService.updateComment(comment);
		return "user_comment";
	}
}
