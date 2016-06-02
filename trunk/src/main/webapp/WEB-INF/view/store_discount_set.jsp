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
<title>Insert title here</title>
</head>
<body>
	<form action="<%=serverPath%>/store/discount/set" method="post">
		折扣方式<input name=discountWay value="${discount.discountWay}"> 
		满足金额<input name="enoughMoney" value="${discount.enoughMoney}"> 
		减免金额<input name="reduceMoney" value="${discount.reduceMoney}">
		<button type="submit">确定</button>
	</form>
</body>
</html>