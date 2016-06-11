<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<h1>测试所有商品</h1>
	
	<br>
	<br>
	
	<h3>商品列表</h3>
	
	<div class="bd">
		<table class="list" style="border: 1px solid #ccc; ">
			<thead>
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>商品详情</th>
					<th>库存</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${modelList}" var="i" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><a href="<%=serverPath%>/model/show/${i.id}">
							${i.modelName}</a></td>
						<td><a href="<%=serverPath%>/model/show/${i.id}">
							点击查看商品详情</a></td>
						<td>${i.inventorySum}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<br>
	<p><a href="<%=StaticPath%>/index.html">返回首页</a></p>
	
</body>
</html>