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
<a href="<%=serverPath%>/comment/select/send">发出的评价</a>
<a href="<%=serverPath%>/comment/select/receive">收到的评价</a>


<c:forEach items="${customerCommentList}" var="customerComment">
		<span>
			<p>${customerComment.commentCustomerNumber}   </p>
			<span>${customerComment.commentContent}   </span>
			<c:forEach items="${customerComment.commentImages}" var="commentImage">
			<img src="${commentImage}"/>
			</c:forEach>
			<a>${customerComment.modelName}    </a>
			<a>${customerComment.storeName}    </a>
			<a href="<%=serverPath%>/comment/add?orderDetailId=${customerComment.orderDetailId}">追加评价</a>
		</span>
	</c:forEach>
	
	<c:forEach items="${sellerCommentList}" var="sellerComment">
	<span>
	<p>${customerComment.commentSellerNumber}   </p>
	<a>${customerComment.storeName}    </a>
	</span>
	</c:forEach>
</body>
</html>