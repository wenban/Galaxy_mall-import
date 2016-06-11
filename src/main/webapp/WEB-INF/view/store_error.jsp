<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String serverPath = "http://" + request.getServerName() + ":" + request.getServerPort()
						+ request.getContextPath();
%>
<%
	String StaticPath = "http://" + request.getServerName() + ":8088/html" ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>您还没有店铺,无法查看店铺信息</h1>
<p><a href="<%=serverPath%>/store/toCreate">创建店铺</a></p>
<p><a href="<%=StaticPath%>/index.html">返回首页</a></p>
</body>
</html>