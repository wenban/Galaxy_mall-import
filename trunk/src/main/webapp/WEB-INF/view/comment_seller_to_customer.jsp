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
<title>卖家评价买家页</title>

<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
</head>

<body>
	<form action="<%=serverPath%>/comment/from/seller" method="post">
		<div id="commentForm">
			您给该买家的评价为： 
			<select name="commentSellerNumber">
				<option value="5">非常好</option>
				<option value="3">好</option>
				<option value="0">一般</option>
				<option value="-3">中</option>
				<option value="-5">差</option>
			</select></br> 
			<input type="hidden" name="orderDetailId" value="${orderDetailId}">
			<input type="hidden" name="goodsId" value="${goodsId}"> 
			<input id="commentSubmitButton" type="submit" value="提交评价" />
		</div>
	</form>
</body>
</html>