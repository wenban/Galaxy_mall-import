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
<body>${error}
		<form action="<%=serverPath%>/store/create" method="post">
			<input name="storeName">
			<input name="statement">
			<button type="submit">创建店铺</button>		
		</form>
</body>
</html>