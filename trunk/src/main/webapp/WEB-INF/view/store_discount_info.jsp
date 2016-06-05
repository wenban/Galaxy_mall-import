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
<title>Insert title here</title>
<script type="text/javascript" src="<%=serverPath%>/js/jquery.js"></script>
<Script>
$(function() {
	
	
	$("#submit-button").click(function() {
		var discountNum = "";
			$.ajax({
				url: '<%=serverPath%>/store/discount/selectDiscountNum',
				async: false,
				success: function(data){
					discountNum = data;
					if(discountNum >= 5){
						alert("您的店铺已有5条折扣信息了,无法继续添加!");
					}else{
						$("#discount-form").submit();
					}
				},
				error: function(){alert("查询折扣信息条数 错误!!")}
			});
	});
	
	$("#deleteDiscounts").click(function(){
		var discountId="";
		$("input:checked").each(function(i){
			if(i==0)
				discountId = discountId + $(this).val();
			else
				discountId = discountId + "," +$(this).val();
		})
		location.href="<%=serverPath%>/store/discount/delete/"+discountId;
	});
	
});
</Script>
</head>
<body>
	<h1>请设置店铺总折扣方式</h1>
	
	<p>店铺ID:${storeId}</p>
	
	<h3>已有折扣:</h3>
	
	<c:forEach items="${discountList}" var="discount" varStatus="status">
	<div>
		<p><input type="checkbox" value="${discount.id}" />
			第 ${status.count} 条折扣</p>
		<p>折扣方式:
			<c:if test="${discount.discountWay == '0'}">仅包邮</c:if>
			<c:if test="${discount.discountWay == '1'}">满减不包邮</c:if>
			<c:if test="${discount.discountWay == '2'}">满减加包邮</c:if>
		</p>
		<p>满足金额:${discount.enoughMoney}</p>
		<p>减免金额:${discount.reduceMoney}</p>
		<p>创建时间:${discount.createTime}</p>
		<br>
		<p>*****************************************************<p>
	</div>
	</c:forEach>
	<p><input id="deleteDiscounts" type="button" value="删除折扣信息"></p>
	<h3>添加新折扣</h3>
	<form id="discount-form" action="<%=serverPath%>/store/discount/setDiscount" method="POST">
		
		<p>折扣方式: <select id="discountWay" name="discountWay" class="">
			<option value="">请选择折扣方式</option>
			<option value="0">仅包邮</option>
			<option value="1">满减不包邮</option>
			<option value="2">满减加包邮</option>
		</select></p>
		
		<p>满足金额: <input id="enoughMoney" name="enoughMoney" value="${discount.enoughMoney}"></p>
		
		<p>减免金额:<input name="reduceMoney" value="${discount.reduceMoney}"></p>
		
		<p><button id="submit-button" type="button">添加</button></p>
	
	</form>
	
</body>
</html>