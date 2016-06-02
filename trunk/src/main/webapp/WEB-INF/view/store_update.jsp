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



	<form action="<%=serverPath%>/store/update" method="post">
		店名<input name="id" value="${store.id}"> 
		店名<input name="storeName" value="${store.storeName}"> 
		店铺声明<input name="statement" value="${store.statement}"> 
		店铺运费<input name="expressExpenses" value="${store.expressExpenses}">
		<button type="submit">确定</button>
	</form>
</body>
</html>