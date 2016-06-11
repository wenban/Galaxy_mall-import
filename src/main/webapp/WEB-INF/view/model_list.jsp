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
<title>Store Detail</title>
<style>
table {
border-collapse: collapse;
border-spacing: 0;
}

table,
th,
td {
	border: 1px solid #ccc;
}

table th {
	background-color: #0088CC;
	color: #fff;
	font-weight: normal;
	padding: 15px 20px;
	font-size: 16px;
}

table td {
	padding: 12px 20px;
	text-align: center;
	color: #777;
}

table tr:hover {
	background-color: #eee;
}
</style>
</head>
<body>

	
	<h3>所有商品</h3>
	
	<div class="bd">
		<table class="list" style="border: 1px solid #ccc; ">
			<thead>
				<tr>
					<th>商品ID</th>
					<th>店铺ID</th>
					<th>商品分类</th>
					<th>商品名</th>
					<th>商品描述</th>
					<th>是否参与活动</th>
					<th>评论数</th>
					<th>成交量</th>
					<th>收藏量</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${modelList}" var="model">
					<tr>
						<td><a href="<%=serverPath%>/model/show/${model.id}">${model.id}</a></td>
						<td><a href="<%=serverPath%>/store/storeDetail/${model.storeId}">${model.storeId}</a></td>
						<td>${model.categoryId}</td>
						<td><a href="<%=serverPath%>/model/show/${model.id}">${model.modelName}</a></td>
						<td>${model.modelDescription}</td>
						<td>${model.modelIsDiscount}</td>
						<td>${model.commentCount}</td>
						<td>${model.dealCount}</td>
						<td>${model.collectionCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>