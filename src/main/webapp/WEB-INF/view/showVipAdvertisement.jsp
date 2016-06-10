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
<title>所有等级的广告</title>
<link rel="stylesheet" id="" href="<%=serverPath%>/css/WdatePicker.css"
	type="text/css" media="all">
<script language="javascript" type="text/javascript"
	src="<%=serverPath%>/js/WdatePicker.js"></script>
<link rel="stylesheet" id="" href="<%=serverPath%>/js/jquery.js">
</head>
<body>
你好，${user.loginId}！
<input type="hidden" name="createUserId" value=" ${user.id}" />
<form id="batchdelete" action="<%=serverPath%>/VipAdervertisement/delete" method="post">
	<div id="level1">
		第一級廣告：
		<table border="1">
			<tr>
				<th></th>
				<th>model id</th>
				<th>model name</th>
			</tr>
			<c:forEach items="${hashmap['VipAdvertisementLevel1']}" var="GoodsVipAdvertising">
				<tr>
					<td><input type="checkbox" name="modelIdArray" value="${GoodsVipAdvertising.modelId}" /></td>
					<td>${GoodsVipAdvertising.modelId}</td>
					<td>${GoodsVipAdvertising.modelName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
		<div id="level2">
		第二級廣告：
		<table border="1">
			<tr>
				<th></th>
				<th>model id</th>
				<th>model name</th>
			</tr>
			<c:forEach items="${hashmap['VipAdvertisementLevel2']}"
				var="GoodsVipAdvertising">
				<tr>
					<td><input type="checkbox" name="modelIdArray" value="${GoodsVipAdvertising.modelId}" /></td>
					<td>${GoodsVipAdvertising.modelId}</td>
					<td>${GoodsVipAdvertising.modelName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
		<div id="level3">
		第三級廣告：
		<table border="1">
			<tr>
				<th></th>
				<th>model id</th>
				<th>model name</th>
			</tr>
			<c:forEach items="${hashmap['VipAdvertisementLevel3']}"
				var="GoodsVipAdvertising">
				<tr>
					<td><input type="checkbox" name="modelIdArray" value="${GoodsVipAdvertising.modelId}" /></td>
					<td>${GoodsVipAdvertising.modelId}</td>
					<td>${GoodsVipAdvertising.modelName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
		<div id="level4">
		第四級廣告：
		<table border="1">
			<tr>
				<th></th>
				<th>model id</th>
				<th>model name</th>
			</tr>
			<c:forEach items="${hashmap['VipAdvertisementLevel4']}"
				var="GoodsVipAdvertising">
				<tr>
					<td><input type="checkbox" name="modelIdArray" value="${GoodsVipAdvertising.modelId}" /></td>
					<td>${GoodsVipAdvertising.modelId}</td>
					<td>${GoodsVipAdvertising.modelName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<input type="submit" class="submit" value="删除" />
</form>
</body>
</html>