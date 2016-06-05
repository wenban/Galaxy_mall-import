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
	退/换货详情：<br>
	id:${OrderDetailReturnOrExchange.id}<br>
	订单详情id:${OrderDetailReturnOrExchange.orderDetailId}<br>
	状态:${OrderDetailReturnOrExchange.status}<br>
	退货理由:${OrderDetailReturnOrExchange.returnReason}<br>
	方式:${OrderDetailReturnOrExchange.returnOrExchange}<br>
	退款金额:${OrderDetailReturnOrExchange.returnMoney}<br>
	创建时间:${OrderDetailReturnOrExchange.createTime}<br>
	卖家同意时间:${OrderDetailReturnOrExchange.agreeTime}<br>
	买家发货快递单号:${OrderDetailReturnOrExchange.userExpressId}<br>
	买家发货时间:${OrderDetailReturnOrExchange.userDeliverTime}<br>
	卖家退款时间:${OrderDetailReturnOrExchange.storeReturnMoneyTime}<br>
	卖家发货快递单号:${OrderDetailReturnOrExchange.storeExpressId}<br>
	卖家发货时间:${OrderDetailReturnOrExchange.storeDeliverTime}<br>
	完成时间:${OrderDetailReturnOrExchange.accomplishTime}<br>
	取消时间:${OrderDetailReturnOrExchange.cancelTime}<br>
	<a href="<%=serverPath%>/returnOrchange/agree?id=${OrderDetailReturnOrExchange.id}"><button>同意买家退/换货申请</button></a>
	<form action="<%=serverPath%>/returnOrchange/userDeliver" method="post">
			------买家发货快递单号号<input name="userExpressId" type="text"></br>
			------<input name="id" type="hidden" value="${OrderDetailReturnOrExchange.id}">
			------<input type="submit" value="发货">
	</form>
	<a href="<%=serverPath%>/returnOrchange/storeReturnMoney?id=${OrderDetailReturnOrExchange.id}"><button>退款</button></a>
	<form action="<%=serverPath%>/returnOrchange/storeDeliver" method="post">
			------卖家发货快递单号号<input name="storeExpressId" type="text"></br>
			------<input name="id" type="hidden" value="${OrderDetailReturnOrExchange.id}">
			------<input type="submit" value="发货">
	</form>
	<a href="<%=serverPath%>/returnOrchange/accomplish?id=${OrderDetailReturnOrExchange.id}"><button>确认退/换货完成</button></a>
	<a href="<%=serverPath%>/returnOrchange/cancel?id=${OrderDetailReturnOrExchange.id}"><button>取消本次退换货</button></a>
	
</body>
</html>