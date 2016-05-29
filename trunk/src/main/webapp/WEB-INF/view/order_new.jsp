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
	
	id:${order.id}</br>
	userId:${order.userId}</br>
	storeId:${order.storeId}</br>
	orderStatus:${order.orderStatus}</br>
	totalPrice:${order.totalPrice}</br>
	createTime:${order.createTime}</br>
	<c:forEach items="${order.orderDetailList}" var="orderDetail">
	Detail</br>
	id:${orderDetail.id}
	orderId:${orderDetail.orderId}</br>
	storeId:${orderDetail.storeId}</br>
	goodsId:${orderDetail.goodsId}</br>
	goodsPrice:${orderDetail.goodsPrice}</br>
	goodsCount:${orderDetail.goodsCount}</br>
	createTime:${orderDetail.createTime}</br>
	</c:forEach>
</body>
</html>