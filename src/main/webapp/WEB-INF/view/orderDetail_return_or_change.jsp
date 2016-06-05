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
		<form action="<%=serverPath%>/returnOrchange" method="post">
			订单详情ID: <input type="text" name="orderDetailId" readonly="readonly" value="${orderDetailId}"><br>
			退/换货理由:<input type="text" name="returnReason" value=""><br>
			<select name="returnOrExchange">
				<option value="1">退货</option>
				<option value="2">换货</option>
			</select><br>  
			退货金额:<input type="text" name="returnMoney" value=""><br> 
			<input type="submit" value="提交">
		</form>
</body>
</html>