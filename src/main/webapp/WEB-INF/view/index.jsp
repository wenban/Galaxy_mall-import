<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
	String serverPath = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
<p>这是主页</p>
<a href="<%=serverPath%>/userInfo">用户信息查询</a>
<a href="<%=serverPath%>/toUserfavorit">我的收藏</a>
<a href="<%=serverPath%>/user/toHistory">我的足迹</a>
<a href="<%=serverPath%>/model/show/1">测试商品</a>
</body>
</html>