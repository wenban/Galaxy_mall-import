<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include_area/kindeditor_head.jsp"%>
<title>Release GoodsModel </title>
<script type="text/javascript">

function ajaxFileUpload(){
	$.ajaxFileUpload({
		url:'<%=serverPath%>/userInfo/updateUser/upload',
		secureuri:false,                        //是否启用安全提交,默认为false 
		fileElementId:'fileField',              //文件选择框的id属性
		dataType:'text',                        //服务器返回的格式,可以是json或xml等
		success:function(data, status){         //服务器响应成功时的处理函数
			$("#show-img-by-id").attr("src",data);
		},
		error:function(data, status, e){        //服务器响应失败时的处理函数
			alert("上传失败！");
		}
	});
}

$(function() {
	//动态切换选中图片
	$("#show-img-by-id").attr("src",$(".click-img").children().attr("src"));
	$(".click-img").click(function() {
		var temp_img = $(this).children().attr("src");
		$("#show-img-by-id").attr("src",temp_img);
	});
	
});

</script>
<style>

#show-img-by-id {
	width:200px;
	height:200px;
}
.show-img-small {
	width:30px;
	height:30px;
}

</style>
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
		
		<!-- ************************************************* -->
		
		<div class="headimage">
			<p>商品图片:</p>
				<img id="show-img-by-id" class="show-img-big" src=""  alt="">
			<p>
				<c:forEach items="${completeGoodsInfo.modelImagesList}" var="img" varStatus="status">
				<a class="click-img" href="javascript:;">
				<img id="show-img-id-${img.id}" class="show-img-small" src="${img.modelImage}"  alt=""></a>
				</c:forEach>
			</p>
			<p>
				<input type="file" id="fileField" name="imgFile"/>
				<input type="button" id="uploadbutton" name="button" value="上传" onclick="ajaxFileUpload()"/>
			</p>
		</div>
		<!-- ************************************************* -->
		
		<div class="headimage">
		<img id="headimage" src="http://localhost:8088/images/${fulluser.userHeadImages}" height="40" width="40" />
		<input type="file" id="fileField" name="imgFile"/>
		<input type="button" id="uploadbutton" name="button" value="上传" onclick="ajaxFileUpload()"/>
		</div>
		
		
		<br>商品描述:<br>
		<br><textarea id="modelDescription" name="modelDescription"></textarea><br>
		
		<!-- hidden -->
		<input class="" id="" name="categoryId" type="hidden" value="1">
		
		<br><input type="submit" class="" value="发布商品">
		</form>

	</div>
</body>
</html>