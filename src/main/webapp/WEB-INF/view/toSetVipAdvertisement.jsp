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
<title>设置广告</title>
<link rel="stylesheet" id="" href="<%=serverPath%>/css/WdatePicker.css"
	type="text/css" media="all">
<script language="javascript" type="text/javascript"
	src="<%=serverPath%>/js/WdatePicker.js"></script>
<link rel="stylesheet" id="" href="<%=serverPath%>/js/jquery.js">
</head>
<body>
	<form id="setAdvertisement" action="<%=serverPath%>/VipAdervertisement/set" method="post">
	<span>你好！ ${user.loginId}</span>
	<input type="hidden" name="createUserId" value=" ${user.id}" />
		<table border="1">
			<tr>
				<th></th>
				<th>model id</th>
				<th>store id</th>
				<th>model name</th>
			</tr>
			<c:forEach items="${modelList}" var="goodsModel">
				<tr>
					<td><input type="checkbox" name="modelIdArray" value="${goodsModel.id}" /></td>
					<td>${goodsModel.id}</td>
					<td>${goodsModel.storeId}</td>
					<td>${goodsModel.modelName}</td>
				</tr>
			</c:forEach>
		</table>
		<select id="vipLevel" name="vipLevel">
			<option value="0" selected="selected">请选择VIP等级</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
		</select> 
		<input type="submit" class="submit" value="确定" />
	</form>
</body>
</html>