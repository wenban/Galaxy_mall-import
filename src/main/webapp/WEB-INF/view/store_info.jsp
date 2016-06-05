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
<title>Store Info</title>
</head>
<body>

	<p>店主名称:${user.userName}</p>
	
	<p>店名:${store.storeName}</p>
	
	<p>店铺声明:${store.statement}</p>
	
	<p>店铺等级:${store.storeLevel}</p>
	
	<p>店铺运费:${store.expressExpenses}</p>
	
	<p>店铺创建时间:${store.creatTime}</p>
	
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
</body>
</html>