<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include_area/kindeditor_head.jsp"%>
<title>Create Goods</title>
</head>
<body>
	<form action="<%=serverPath%>/goods/create" method="POST">
		<h1>GoodsModel添加成功! 请完善Goods</h1>

		<br>ModelId:${fullOfInfoModel.id}<br>
		<br>modelAttributeFName:${fullOfInfoModel.modelAttributeFName}<br>
		<br>modelAttributeSName:${fullOfInfoModel.modelAttributeSName}<br>

		<div class="goodCreateOnce">
			<br>属性 - ${fullOfInfoModel.modelAttributeFName}:
			<input class="" id="" name="goodsAttributeF" type="text" value=""  placeholder="请输入具体属性"><br>
			<br>属性 - ${fullOfInfoModel.modelAttributeSName}:
			<input class="" id="" name="goodsAttributeS" type="text" value=""  placeholder="请输入具体属性"><br>
			<br>单价:
			<input class="" id="" name="goodsNewPrice" type="text" value=""  placeholder="请输入单价"><br>
			<br>库存:
			<input class="" id="" name="goodsInventory" type="text" value=""  placeholder="请输入单价"><br>
			<!-- hidden -->
			<input class="" id="" name="modelId" type="hidden" value="${fullOfInfoModel.id}" >
			<br><input type="submit" class="" value="提交">
		</div>
		
	</form>

</body>
</html>