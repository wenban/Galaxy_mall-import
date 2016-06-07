<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/My97DatePicker/calendar.js"></script>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/jquery.js"></script>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
	<div id="userinfopage">
		用户收货地址信息页面
			<c:choose>
				<c:when test="${userAddressList==null}">
       				您目前没有任何收货地址，快去添加吧！
    			</c:when>
				<c:otherwise>
					<c:forEach items="${userAddressList}" var="userAddress" >
					<form class="UserAddr" method="post" action="<%=serverPath%>/userInfo/toUpdateOneUserAddr">
						<ul id="addressinfo-${userAddress.id}">
						<li><input type="hidden" name="id" value="${userAddress.id}"/></li>
        				<li><span>${userAddress.userId}</span></li>
						<li>收件人姓名:<span>${userAddress.receiveName}</span></li>
						<li>收件人电话:<span>${userAddress.receiveMobile}</span></li>
						<li>邮编:<span>${userAddress.receiveZipCode}</span></li>
						<li>收件人地址:<span>${userAddress.receiveAddress}</span></li>
						<li>详细地址:<span>${userAddress.receiveAddressDetail}</span></li>
						<c:if test="${userAddress.isDefaultAddress==1}"><p>这是默认地址</p></c:if>
						<c:if test="${userAddress.isDefaultAddress==0}"><a href="<%=serverPath%>/userInfo/toUpdateOneUserAddr/setDefaultAddr/${userAddress.id}">设为默认地址</a></c:if>
						<li><input type="submit" class="toUpdateAddr" value="修改" /></li>
						</ul>
					</form>
					<form class="UserAddr" method="post" action="<%=serverPath%>/userInfo/deleteUserAddr">
						<ul class="addressinfo">
						<input type="hidden" class="addressId" name="id" value="${userAddress.id}"/>
						<li><input type="submit" value="删除"  /></li>
						</ul>
					</form>
					</c:forEach>
    			</c:otherwise>
			</c:choose>
		</div>
		<div id="addNewAddr">
		<form method="post" action="<%=serverPath%>/userInfo/insertIntoUserAddr/confirm">
		<ul id="addressinfo">
			<li><input type="text" name="userId" value="${user.id}"/></li>
			<li>收件人姓名：<input type="text" name="receiveName" value="" /></li>
			<li>收件人电话：<input type="text" name="receiveMobile" value="" /></li>
			<li>邮编：<input type="text" name="receiveZipCode" value="" /></li>
			<li>收件人地址：<input type="text" name="receiveAddress" value="" /></li>
			<li>详细地址：<input type="text" name="receiveAddressDetail" value="" /></li>
		</ul>
		
			<input value="确认" type="submit" />
			<span>${TooManyAddresses}</span>
		</form>
		</div>
</body>
</html>