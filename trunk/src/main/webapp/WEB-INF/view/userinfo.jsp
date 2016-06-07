<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String serverPath = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" id="" href="<%=serverPath%>/css/WdatePicker.css" type="text/css" media="all">
 <script language="javascript" type="text/javascript" src="<%=serverPath%>/js/WdatePicker.js"></script>
<link rel="stylesheet" id="" href="<%=serverPath%>/js/jquery.js">
</head>
<body>
<div id="userinfopage">
用户详细信息页面
<ul id="userinfo">
<li><img src="${fulluser.userHeadImages}" height="40" width="40" /></li>
<li>你好，<span>${fulluser.loginId}</span>！</li>
<li>你是第<span>${fulluser.id}</span>名用户！</li>
<li>昵称：<span>${fulluser.userName}</span></li>
<li>邮箱：<span>${fulluser.userEmail}</span></li>
<li>性别：<span>${fulluser.userGender}</span></li>
<li>生日：<span>${fulluser.userBirthday}</span></li>
<li>手机：<span>${fulluser.userMobile}</span></li>
<li>资产：<span>${fulluser.userAsset}</span></li>
<li>支付宝账号：<span>${fulluser.userAlipay}</span></li>
<li>用户等级：<span>${fulluser.userLevel}</span></li>
</ul>

	<form method="get" action="userInfo/updateUser">
		<input value="修改个人信息" type="submit" />
	</form>
	<form method="get" action="userInfo/getUserAddr">
		<input value="完善地址信息" type="submit" />
	</form>
</div>
</body>
</html>