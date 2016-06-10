<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String serverPath = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
<title>我的评价</title>
</head>

<body>
	<a href="<%=serverPath%>/comment/customer/to/seller">买家评价卖家</a>
	<a href="<%=serverPath%>/comment/seller/to/customer">卖家评价买家</a>
	<a href="<%=serverPath%>/comment/select/send">我发出的评价</a>
	<a href="<%=serverPath%>/comment/select/receive">我收到的评价</a>
	<a href="<%=serverPath%>/comment/select/modelId?modelId=">modelId查询评价</a>
	<a href="<%=serverPath%>/comment/select/commentId?commentId=">commentId查询评价</a>
	<a href="<%=serverPath%>/comment/select/storeId?storeId=">storeId查询评价</a> 
	</br>
	发出的评价：
	<table>
		<thead>
			<tr>
				<td>评价ID</td>
				<td>评价等级</td>
				<td>评价内容</td>
				<td>评价图片</td>
				<td>商品模型名</td>
				<td>店铺名</td>
				<td>追加评价内容</td>
				<td>追加评价图片</td>
				<td>追加评价</td>
				<td>删除评价</td>
			</tr>
		</thead>
		<c:forEach items="${customerCommentList}" var="customerComment">
			<tbody>
				<tr>
					<td>${customerComment.id}</td>
					<td>${customerComment.commentCustomerNumberStr}</td>
					<td>${customerComment.commentContent}</td>
					<td><c:if test="${customerComment.commentImagesList!=null}">
					<c:forEach items="${customerComment.commentImagesList}" var="commentImage">
							<img src="http://localhost:8088/images/${commentImage}" style="width:120px;height:80px;"/>
						</c:forEach>
						</c:if>
					</td>
					<td><a>${customerComment.modelName}</a></td>
					<td><a>${customerComment.storeName}</a></td>
					<td><a>${customerComment.commentContentAdd}</a></td>
					<td><c:if test="${customerComment.commentImagesAddList!=null}">
					<c:forEach items="${customerComment.commentImagesAddList}" var="acommentImagesAdd">
							<img src="http://localhost:8088/images/${acommentImagesAdd}" style="width:120px;height:80px;"/>
						</c:forEach>
						</c:if>
					</td>
					<td><a href="<%=serverPath%>/comment/add?orderDetailId=${customerComment.orderDetailId}">追加评价</a></td>
					<td><a href="<%=serverPath%>/comment/delete?orderDetailId=${customerComment.orderDetailId}">删除评价</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

	收到的评价：
	<table>
		<thead>
			<tr>
				<td>评价ID</td>
				<td>评价等级</td>
				<td>商品模型名</td>
				<td>店铺名</td>
			</tr>
		</thead>
		<c:forEach items="${sellerCommentList}" var="sellerComment">
			<tbody>
				<tr>
					<td>${sellerComment.id}</td>
					<td>${sellerComment.commentSellerNumberStr}</td>
					<td><a>${sellerComment.modelName} </a></td>
					<td><a>${sellerComment.storeName}</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	modelId查询评价:
	<table>
		<thead>
			<tr>
				<td>评价ID</td>
				<td>用户名</td>
				<td>评价等级</td>
				<td>评价给用户的等级</td>
				<td>评价内容</td>
				<td>评价图片</td>
				<td>追加内容</td>
				<td>追加图片</td>
				<td>商品模型名</td>
				<td>店铺名</td>
				<td>商品属性1</td>
				<td>商品属性2</td>
				<td>评价创建时间</td>
				<td>评价更新时间</td>
			</tr>
		</thead>
		<c:forEach items="${CommentListByModelId}" var="modelIdComment">
			<tbody>
				<tr>
					<td>${modelIdComment.id}</td>
					<td>${modelIdComment.userName}</td>
					<td>${modelIdComment.commentCustomerNumberStr}</td>
					<td>${modelIdComment.commentSellerNumberStr}</td>
					<td>${modelIdComment.commentContent}</td>
					<td><c:if test="${modelIdComment.commentImagesList!=null}">
					<c:forEach items="${modelIdComment.commentImagesList}" var="commentImage">
							<img src="http://localhost:8088/images/${commentImage}" style="width:120px;height:80px;"/>
						</c:forEach>
						</c:if>
					</td>
					<td>${modelIdComment.commentContentAdd}</td>
					<td><c:if test="${modelIdComment.commentImagesAddList!=null}">
					<c:forEach items="${modelIdComment.commentImagesAddList}" var="acommentImageAdd">
							<img src="http://localhost:8088/images/${acommentImageAdd}" style="width:120px;height:80px;"/>
						</c:forEach>
						</c:if>
					</td>
					<td>${modelIdComment.modelName}</td>
					<td>${modelIdComment.storeName}</td>
					<td>${modelIdComment.modelAttributeFName}:${modelIdComment.goodsAttributeF}</td>
					<td>${modelIdComment.modelAttributeSName}:${modelIdComment.goodsAttributeS}</td>
					<td>${modelIdComment.createTime}</td>
					<td>${modelIdComment.updateTime}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	commentId查询评价:
	<table>
		<thead>
			<tr>
				<td>评价ID</td>
				<td>用户名</td>
				<td>评价等级</td>
				<td>评价给用户的等级</td>
				<td>评价内容</td>
				<td>评价图片</td>
				<td>追加内容</td>
				<td>追加图片</td>
				<td>商品模型名</td>
				<td>店铺名</td>
				<td>商品属性1</td>
				<td>商品属性2</td>
				<td>评价创建时间</td>
				<td>评价更新时间</td>
			</tr>
		</thead>
		<c:forEach items="${CommentListByCommentId}" var="commentIdComment">
			<tbody>
				<tr>
					<td>${commentIdComment.id}</td>
					<td>${commentIdComment.userName}</td>
					<td>${commentIdComment.commentCustomerNumberStr}</td>
					<td>${commentIdComment.commentSellerNumberStr}</td>
					<td>${commentIdComment.commentContent}</td>
					<td>
						<c:if test="${commentIdComment.commentImagesList!=null}">
						<c:forEach items="${commentIdComment.commentImagesList}" var="commentImage">
							<img src="http://localhost:8088/images/${commentImage}" style="width:120px;height:80px;"/>
						</c:forEach>
						</c:if>
					</td>
					<td>${commentIdComment.commentContentAdd}</td>
					<td><c:if test="${commentIdComment.commentImagesAddList!=null}">
					<c:forEach items="${commentIdComment.commentImagesAddList}" var="acommentImageAdd">
							<img src="http://localhost:8088/images/${acommentImageAdd}" style="width:120px;height:80px;"/>
						</c:forEach>
						</c:if>
					</td>
					<td>${commentIdComment.modelName}</td>
					<td>${commentIdComment.storeName}</td>
					<td>${commentIdComment.modelAttributeFName}:${commentIdComment.goodsAttributeF}</td>
					<td>${commentIdComment.modelAttributeSName}:${commentIdComment.goodsAttributeS}</td>
					<td>${commentIdComment.createTime}</td>
					<td>${commentIdComment.updateTime}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	storeId查询评价:
	<table>
		<thead>
			<tr>
				<td>评价ID</td>
				<td>用户名</td>
				<td>评价等级</td>
				<td>评价给用户的等级</td>
				<td>评价内容</td>
				<td>评价图片</td>
				<td>追加内容</td>
				<td>追加图片</td>
				<td>商品模型名</td>
				<td>店铺名</td>
				<td>商品属性1</td>
				<td>商品属性2</td>
				<td>评价创建时间</td>
				<td>评价更新时间</td>
			</tr>
		</thead>
		<c:forEach items="${CommentListByStoreId}" var="storeIdComment">
			<tbody>
				<tr>
					<td>${storeIdComment.id}</td>
					<td>${storeIdComment.userName}</td>
					<td>${storeIdComment.commentCustomerNumberStr}</td>
					<td>${storeIdComment.commentSellerNumberStr}</td>
					<td>${storeIdComment.commentContent}</td>
					<td><c:if test="${storeIdComment.commentImagesList!=null}">
					<c:forEach items="${storeIdComment.commentImagesList}" var="commentImage">
							<img src="http://localhost:8088/images/${commentImage}" style="width:120px;height:80px;"/>
						</c:forEach>
						</c:if>
					</td>
					<td>${storeIdComment.commentContentAdd}</td>
					<td><c:if test="${storeIdComment.commentImagesAddList!=null}">
					<c:forEach items="${storeIdComment.commentImagesAddList}" var="acommentImageAdd">
							<img src="http://localhost:8088/images/${acommentImageAdd}" style="width:120px;height:80px;"/>
						</c:forEach>
						</c:if>
					</td>
					<td>${storeIdComment.modelName}</td>
					<td>${storeIdComment.storeName}</td>
					<td>${storeIdComment.modelAttributeFName}:${storeIdComment.goodsAttributeF}</td>
					<td>${storeIdComment.modelAttributeSName}:${storeIdComment.goodsAttributeS}</td>
					<td>${storeIdComment.createTime}</td>
					<td>${storeIdComment.updateTime}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	
	
</body>
</html>
