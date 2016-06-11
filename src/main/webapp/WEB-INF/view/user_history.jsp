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
<title>我的足迹</title>
</head>


<body>
<a href="<%=serverPath%>/user/history/select">查询浏览记录</a>
<a href="<%=serverPath%>/user/history/delete">清空浏览记录</a>
<a href="<%=serverPath%>/user/history/update">用户点击一个model的标题</a>
	<c:forEach items="${historyList}" var="history">
		<div>
			<span style="font-family: Microsoft YaHei; font-size: 12px">${history.historyTime}</span>
		</div>
		<div>
			<img alt="" src="${history.modelImage}"> 
			<span>${history.minPrice}-${history.maxPrice}</span>
			<a>${history.modelName}</a></br>
			<a>${history.storeName}</a>
		</div>
	</c:forEach>
</body>
</html>