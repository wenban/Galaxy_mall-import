<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include_area/kindeditor_head.jsp"%>
<title>Create Goods</title>
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
	padding: 10px;
	font-size: 16px;
}

table td {
	padding: 6px;
	text-align: center;
	color: #777;
}

table tr:hover {
	background-color: #eee;
}
</style>
</head>
<body>
	<h1>Goods添加成功!</h1>
	<h3>当前已添加 ${goodsCount} 件Goods！ ---modelId=${modelId}</h3>
	
	<div class="bd">
		<table class="list" style="border: 1px solid #ccc; ">
			<thead>
				<tr>
					<th>ModelId</th>
					<th>属性一</th>
					<th>属性二</th>
					<th>单价</th>
					<th>库存</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${goodsList}" var="one" varStatus="status">
					<tr>
						<td>${one.modelId}</td>
						<td>${one.goodsAttributeF}</td>
						<td>${one.goodsAttributeS}</td>
						<td>${one.goodsNewPrice}</td>
						<td>${one.goodsInventory}</td>
						<td><a class=" " href="JavaScript:;">修改</a></td>
						<td><a class=" " href="JavaScript:;">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<p><a class=" " href="<%=serverPath%>/goods/create">继续添加</a></p>
	<p><a class=" " href="<%=serverPath%>/model/show/${modelId}">商品展示</a></p>

</body>
</html>