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
<title>注册</title>

<script type="text/javascript">
$(function() {
	$("#submit").click(function(){
		var buyId="";
		$("input:checked").each(function(i){
			if(i==0)
				buyId=buyId+$(this).val();
			else
				buyId=buyId+","+$(this).val();
		})
		location.href="<%=serverPath%>/order/creat/shoppingTrolley?shoppingTrolleyIdList="+buyId;
	});
});
</script>
</head>
<body>
<a href="<%=serverPath%>/shoppingtrolley/remove?id=-1">清空购物车</a></br>
<c:forEach items="${shoppingTrolleyList}" var="shoppingTrolley">
		<input name="deletId" type="checkbox" value="${shoppingTrolley.id}" />
		id:${shoppingTrolley.id}</br>
		用户ID：${shoppingTrolley.userId}</br>
		宝贝ID：${shoppingTrolley.goodsId}</br> 
		店铺ID：${shoppingTrolley.storeId}</br>
		宝贝价格：${shoppingTrolley.goodsPrice}
		<form action="<%=serverPath%>/shoppingtrolley/update" method="get">
			   <input type="hidden" name="id" value="${shoppingTrolley.id}"/>
		宝贝数量:<input type="text" name="goodsCount" value="${shoppingTrolley.goodsCount}"/>
		       <input type="submit" value="更改数量"/>
		</form>
		更新日期${shoppingTrolley.updateTime}</br>
		<a href="<%=serverPath%>/shoppingtrolley/remove?id=${shoppingTrolley.id}">移除购物车</a></br>

</c:forEach>
		<button id="submit">提交购物车</button></br>
		<a href="<%=serverPath%>/order/creat/shoppingTrolley?shoppingTrolleyIdList=-1"><button>全都要了</button></a></br>
		
</body>
</html>