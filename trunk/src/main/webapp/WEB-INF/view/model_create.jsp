<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include_area/kindeditor_head.jsp"%>
<title>Release GoodsModel </title>
</head>
<body>
	<div id="goods-info">
		<form action="<%=serverPath%>/model/create" method="POST" >
		
		<h3>商品基本信息</h3>
		
		<br>商品标题:<input class="" id="" name="modelName" type="text" value=""  placeholder="请输入商品标题"><br>
		<br>商品属性<br>
		<br>属性一:<input class="" id="" name="modelAttributeFName" type="text" value=""  placeholder="请输入第一个属性的名字"><br>
		<br>属性二:<input class="" id="" name="modelAttributeSName" type="text" value=""  placeholder="请输入第二个属性的名字"><br>
		<br>商品图片:<br>
		<br><textarea id="modelImages" name="modelImages"></textarea><br>
		
		<br>商品描述:<br>
		<br><textarea id="modelDescription" name="modelDescription"></textarea><br>
		
		<!-- hidden -->
		<input class="" id="" name="categoryId" type="hidden" value="1">
		
		<br><input type="submit" class="" value="发布商品">
		</form>

	</div>
</body>
</html>