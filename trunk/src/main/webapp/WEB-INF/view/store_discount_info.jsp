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
		店ID${discount.storeId}</br>
		折扣方式${discount.discountWay}</br>
		满足金额${discount.enoughMoney}</br> 
		减免金额${discount.reduceMoney}</br>
		创建时间${discount.createTime}</br>
		最近更新时间${discount.updateTime}</br>
		<a href="<%=serverPath%>/store/discount/cancel">取消折扣</a></br>
</body>
</html>