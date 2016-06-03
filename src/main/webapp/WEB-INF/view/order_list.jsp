<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String serverPath = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	买家视角查看订单
	<a href="<%=serverPath%>/order/list/all/forUser">查看所有订单</a>
	<a href="<%=serverPath%>/order/list/waitConfirm/forUser">待确认</a>
	<a href="<%=serverPath%>/order/list/waitPay/forUser">待支付</a>
	<a href="<%=serverPath%>/order/list/waitDeliver/forUser">待发货</a>
	<a href="<%=serverPath%>/order/list/waitAccomplish/forUser">待收货</a>
	<a href="<%=serverPath%>/order/list/accomplish/forUser">已完成</a>
	<a href="<%=serverPath%>/order/list/cancel/forUser">已取消</a>
	</br>
	卖家视角查看订单
	<a href="<%=serverPath%>/order/list/all/forStore">查看所有订单</a>
	<a href="<%=serverPath%>/order/list/waitConfirm/forStore">待确认</a>
	<a href="<%=serverPath%>/order/list/waitPay/forStore">待支付</a>
	<a href="<%=serverPath%>/order/list/waitDeliver/forStore">待发货</a>
	<a href="<%=serverPath%>/order/list/waitAccomplish/forStore">待收货</a>
	<a href="<%=serverPath%>/order/list/accomplish/forStore">已完成</a>
	<a href="<%=serverPath%>/order/list/cancel/forStore">已取消</a>
	</br>
	<c:forEach items="${orderList}" var="order">
	订单：</br><a href="<%=serverPath%>/order/detailInfo?id=${order.id}">查看订单详情</a>
	id:${order.id}</br>
	userId:${order.userId}</br>
	storeId:${order.storeId}</br>
	orderStatus:${order.orderStatus}</br>
	totalPrice:${order.totalPrice}</br>
	createTime:${order.createTime}</br>
	————订单类容：</br>
		<c:forEach items="${order.orderDetailList}" var="orderDetail">
			————————Detail</br>
			————————id:${orderDetail.id}</br>
			————————orderId:${orderDetail.orderId}</br>
			————————storeId:${orderDetail.storeId}</br>
			————————goodsId:${orderDetail.goodsId}</br>
			————————goodsPrice:${orderDetail.goodsPrice}</br>
			————————goodsCount:${orderDetail.goodsCount}</br>
			————————createTime:${orderDetail.createTime}</br>
		</c:forEach>
		<a href="<%=serverPath%>/order/cancel?id=${order.id}">取消订单</a>
	</br>
	*******************************************************************
	</br>
	</c:forEach>
	
</body>
</html>