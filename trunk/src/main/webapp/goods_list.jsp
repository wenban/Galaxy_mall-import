<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String serverPath = "http://" + request.getServerName() + ":" + request.getServerPort()
						+ request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
<title>注册_邮箱验证</title>
<script type="text/javascript">
	$(function() {
		$("#add").click(function() {
			$.ajax({
				url: '<%=serverPath%>/shoppingtrolley/add?goodsId='+ $("#goodsId").val()
						+'&storeId='+$("#storeId").val()
						+'&goodsPrice='+$("#goodsPrice").val()
						+'&goodsCount='+$("#goodsCount").val(),
						success : function(data) {
							if(data==1){
								alert("添加至购物车成功");
								}
							
						},
						error : function() {
							alert("添加失败!");
						}
					});
				});
		
	});
</script>

</head>


<body>
	<div>
		<form action="<%=serverPath%>/order/create/direct" method="get">
			宝贝ID：<input id="goodsId" name="goodsId" type="text" value="1"/></br>
			店铺ID：<input id="storeId" name="storeId" type="text" value="14"/></br>
			宝贝价格：<input id="goodsPrice" name="goodsPrice" type="text" value="22"/></br>
			宝贝数量：<input id="goodsCount" name="goodsCount" type="text"/></br>
			<input type="submit" value="立即购买">
		</form>
			<button id="add">添加至购物车</button>
			<a href="<%=serverPath%>/shoppingtrolley/select"><button>查看我的购物车</button></button>
	</div>
</body>
</html>