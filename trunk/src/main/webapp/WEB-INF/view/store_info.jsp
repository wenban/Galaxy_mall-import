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
	
	店主名称:${user.userName}</br>
	店名:${store.storeName}</br>
	店铺声明:${store.statement}</br>
	店铺等级:${store.storeLevel}</br>
	店铺优惠信息:${store.discountId}</br>
	店铺运费:${store.expressExpenses}</br>
	店铺创建时间:${store.creatTime}</br>
	<a href="<%=serverPath%>/store/discount/toSet">设置折扣</a></br>
	<a href="">添加宝贝</a></br>
	<a href="<%=serverPath%>/store/remove?id=${store.id}">关闭店铺</a></br>
	<a href="<%=serverPath%>/store/toUpdate?id=${store.id}">信息修改</a>
</body>
</html>