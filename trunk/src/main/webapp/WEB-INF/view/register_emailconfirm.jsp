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
<title>注册_邮箱验证</title>
<script type="text/javascript">
	$(function() {
		$("#getcaptcha").click(function() {
			$.ajax({
				url: '<%=serverPath%>/user/register/email_confirm?userEmail='
												+ $("#userEmail").val(),
										success : function(data) {
											if (data == 0) {
												alert("验证码已发送至您的邮箱!");
											} else if (data == 1) {
												alert("该邮箱已被注册!");
											}

										},
										error : function() {
											alert("验证失败!");
										}
									});
						});

	});
</script>

</head>


<body>
	<form action="<%=serverPath%>/user/register/captcha_confirm"
		method="post">
		<div>
			邮箱：<input type="text" name="userEmail" id="userEmail" /> <input
				type="button" name="getcaptcha" id="getcaptcha" value="获取验证码" />
		</div>
		<div>
			验证码：<input type="text" name="captcha" id="captcha" /><span>${captchaError}</span>
		</div>
		<input type="submit" id="submitbutton" value="确定" />
	</form>
</body>
</html>