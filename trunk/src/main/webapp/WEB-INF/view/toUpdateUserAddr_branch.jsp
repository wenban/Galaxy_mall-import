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
<title>Insert title here</title>
</head>
<body>
	<div>
		<form method="post"	action="<%=serverPath%>/userInfo/updateUserAddr/confirm">
			<ul id="addressinfo">
				<li><input type="hidden" name="id" value="${selectedAddr.id}"/></li>
        		<li><span>${selectedAddr.userId}</span></li>
				<li>收件人姓名：<input type="text" name="receiveName" value="${selectedAddr.receiveName}" /></li>
				<li>收件人电话：<input type="text" name="receiveMobile" value="${selectedAddr.receiveMobile}" /></li>
				<li>邮编：<input type="text" name="receiveZipCode" value="${selectedAddr.receiveZipCode}" /></li>
				<li>收件人地址：<input type="text" name="receiveAddress" value="${selectedAddr.receiveAddress}" /></li>
				<li>详细地址：<input type="text" name="receiveAddressDetail" value="${selectedAddr.receiveAddressDetail}" /></li>
			</ul>
			<input value="确认" type="submit" />
		</form>
	</div>
</body>
</html>