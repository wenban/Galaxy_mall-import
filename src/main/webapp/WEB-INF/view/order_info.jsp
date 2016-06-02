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
	订单：</br>
	订单:${order.id}</br>
	用户:${order.userId}</br>
	店铺:${order.storeId}</br>
	订单状态:${order.orderStatus}</br>
	总价:${order.totalPrice}</br>
	创建时间:${order.createTime}</br>
	---收货信息</br>
	-----收货人:${order.receiveName}</br>
	-----收货电话:${order.receiveMobile}</br>
	-----邮编:${order.receiveZipCode}</br>
	-----收货地址:${order.receiveAddress}</br>
	-----收货地址详情:${order.receiveAddressDetail}</br>
	---支付时间:${order.payTime}</br>
	---发货信息</br>
	-----发货时间:${order.deliverTime}</br>
	-----快递公司:${order.expressCompany}</br>
	-----快递单号:${order.expressId}</br>
	-----快递费:${order.expressExpenses}</br>
	---取消时间时间:${order.cancelTime}</br>
	---完成时间:${order.accomplishTime}</br>
	————订单详情：</br>
		<c:forEach items="${order.orderDetailList}" var="orderDetail">
			————————Detail</br>
			————————id:${orderDetail.id}</br>
			————————orderId:${orderDetail.orderId}</br>
			————————storeId:${orderDetail.storeId}</br>
			————————goodsId:${orderDetail.goodsId}</br>
			————————单价:${orderDetail.goodsPrice}</br>
			————————数量:${orderDetail.goodsCount}</br>
			————————创建时间:${orderDetail.createTime}</br>
		</c:forEach>
		<a href="<%=serverPath%>/order/cancel?id=${order.id}">取消订单</a>
		<a href="">选择您的收货地址(点击之后进入address选择当前用户地址)</a>
		<form action="<%=serverPath%>/order/confirm" method="get">
			收货信息:</br>
			------收货人<input name="receiveName" type="text"></br>
			------收货电话<input name="receiveMobile" type="text"></br>
			------邮编<input name="receiveZipCode" type="text"></br>
			------收货地址<input name="receiveAddress" type="text"></br>
			------收货详细地址<input name="receiveAddressDetail" type="text"></br>
			------<input name="id" type="hidden" value="${order.id}">
			------<input type="submit" value="确认">
		</form>
		<a href="<%=serverPath%>/order/pay?id=${order.id}"><button>支付</button></a>
		<form action="<%=serverPath%>/order/deliver" method="post">
			发货信息:</br>
			------快递公司<input name="expressCompany" type="text"></br>
			------快递单号<input name="expressId" type="text"></br>
			------快递费<input name="expressExpenses" type="text"></br>
			------<input name="id" type="hidden" value="${order.id}">
			------<input type="submit" value="发货">
		</form>
		<a href="<%=serverPath%>/order/accomplish?id=${order.id}"><button>确认收货</button></a>
	
</body>
</html>