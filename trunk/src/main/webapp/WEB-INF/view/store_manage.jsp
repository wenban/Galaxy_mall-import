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
<title>Store Info</title>
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

	<p>店主名称:${user.userName}</p>
	
	<p>店名:${store.storeName}</p>
	
	<p>店铺声明:${store.statement}</p>
	
	<p>店铺等级:${store.storeLevel}</p>
	
	<p>店铺运费:${store.expressExpenses}</p>
	
	<p>店铺创建时间:${store.creatTime}</p>
	
	<p>被收藏次数:</p>
	
	<p>
		<a href="<%=serverPath%>/store/discount/toInfo">查看/设置折扣信息</a>
	</p>
	<p>
		<a href="<%=serverPath%>/model/toCreate">添加商品</a>
	</p>
	<p>
		<a href="<%=serverPath%>/order/select/all/forStore">查看所有订单</a>
	</p>
	<p>
		<a href="<%=serverPath%>/store/remove?id=${store.id}">关闭店铺</a>
	</p>
	<p>
		<a href="<%=serverPath%>/store/toUpdate?id=${store.id}">信息修改</a>
	
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
					<th>修改商品信息</th>
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
						<td><a href="javaScript:;">
							修改</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>
