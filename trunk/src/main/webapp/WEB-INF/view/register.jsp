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
<title>注册</title>
<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#loginId").blur(function() {
			$.ajax({
				url: '<%=serverPath%>/user/register/loginId_confirm?loginId='
												+ $("#loginId").val(),
										success : function(data) {
											if (data == 1) {
												alert("用户名已存在!");
											}
										},
										error : function() {
											alert("验证失败!");
										}
									});
						});
		$("#submitbutton").click(function() {
			var loginPassWord = $("#loginPassWord").val();
			var loginPassWordconfirm = $("#loginPassWordconfirm").val();
			var warning = '<span>两次输入密码不一致</span>';
			if (loginPassWord == loginPassWordconfirm) {
				$("#loginform").submit();
			} else {
				$("#confirmpassword").append(warning);
			}
		});

	});
</script>

</head>


<body>
	<form id="loginform" action="<%=serverPath%>/user/insert/login_register" method="post">
		<div>
			<input type="hidden" name="userEmail" id="userEmail" value="${userEmail}"/>
		</div>
		<div>
			用户名：<input type="text" name="loginId" id="loginId" />
		</div>
		<div>
			密码：<input type="password" name="loginPassWord" id="loginPassWord" />
		</div>
		<div id="confirmpassword">
			确认密码：<input type="password" name="loginPassWordconfirm"
				id="loginPassWordconfirm" />
		</div>
		<div>
			<input type="button" name="submitbutton" id="submitbutton" value="提交" />
		</div>
	</form>

</body>
</html>