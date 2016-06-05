<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String serverPath = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" id="" href="<%=serverPath%>/css/WdatePicker.css" type="text/css" media="all">
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/My97DatePicker/calendar.js"></script>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/jquery.js"></script>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/My97DatePicker/WdatePicker.js"></script>
<!--  
<script type="text/javascript">
$(function() {

	$("#toUpdateAddr").click(function(){
		var options="<option>請選擇二級分類</option>";
		$.ajax({
			url: "<%=serverPath%>/userInfo/toUpdateUserAddr",
			success: function(data){
				data = data1;
			},
			error: function(){
		}
		})
		$.each(eval(data), function(i, category){
			$("#childCate").empty();
			options = options + '<option value="'+ category.cateId +'">'+ category.cateName +'</option>';
		});

		$("#childCate").append(options);
	});
})
</script>
-->

<script>
	function test(){
		alert($("#selectFirstCate").val());
	}
</script>
</head>
<body>
	<div id="userinfopage">
		用户收货地址信息页面
			<c:choose>
				<c:when test="${userAddressList==null}">
       				您目前没有任何收货地址，快去添加吧！
    			</c:when>
				<c:otherwise>
					<c:forEach items="${userAddressList}" var="userAddress" >
					<form class="UserAddr" >
						<ul class="addressinfo">
						<li><span class="addressId">${userAddress.id}</span></li>
        				<li><span>${userAddress.userId}</span></li>
						<li>收件人姓名:<span>${userAddress.receiveName}</span></li>
						<li>收件人电话:<span>${userAddress.receiveMobile}</span></li>
						<li>邮编:<span>${userAddress.receiveZipCode}</span></li>
						<li>收件人地址:<span>${userAddress.receiveAddress}</span></li>
						<li>详细地址:<span>${userAddress.receiveAddressDetail}</span></li>
						<li><input type="button" class="toUpdateAddr" value="修改"  /></li>
						<li><input type="button" name="test" value="test" onclick="test()"  /></li>
						</ul>
					</form>
					<form class="UserAddr" method="post" action="<%=serverPath%>/userInfo/deleteUserAddr">
						<ul class="addressinfo">
						<input type="hidden" class="addressId" name="id" value="${userAddress.id}"/>
						<li><input type="submit" value="删除"  /></li>
						</ul>
					</form>
					</c:forEach>
    			</c:otherwise>
			</c:choose>
		
		
		<form method="post" action="<%=serverPath%>/userInfo/insertIntoUserAddr/confirm">
		<ul id="addressinfo">
			<li><input type="text" name="userId" value="${user.id}"/></li>
			<li>收件人姓名：<input type="text" name="receiveName" value="" /></li>
			<li>收件人电话：<input type="text" name="receiveMobile" value="" /></li>
			<li>邮编：<input type="text" name="receiveZipCode" value="" /></li>
			<li>收件人地址：<input type="text" name="receiveAddress" value="" /></li>
			<li>详细地址：<input type="text" name="receiveAddressDetail" value="" /></li>
		</ul>
		
			<input value="确认" type="submit" />
		</form>
	</div>
</body>
</html>