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
<title>登录页面</title>
<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
<script>
	$(function() {
		$("#loginbutton").click(function() {
			if ($("#loginid").val() == "") {
				alert("登录名不能为空");
				return false;
			} else if ($("#loginpassword").val() == "") {
				alert("密码不能为空");
				return false;
			} else {
				$("#loginlist").submit();
			}
		});
	})
</script>
</head>
<body>
	<form id="loginlist" action="login" method="post">
		<p>${error}</p>
		<div>
			<p>用户名：</p>
			<input id="loginid" type="text" name="username">
		</div>

		<div>
			<p>密码：</p>
			<input id="loginpassword" type="password" name="password">

		</div>

		<div>
			<input id="loginbutton" type="submit" value="登录">
		</div>
	</form>

</body>
</html>