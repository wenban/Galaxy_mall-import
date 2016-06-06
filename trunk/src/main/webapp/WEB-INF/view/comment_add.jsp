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
<title>追加评价</title>
<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/ajaxfileupload.js"></script>
<script type="text/javascript">
function ajaxFileUpload(){
	$.ajaxFileUpload({
		url:'<%=serverPath%>/comment/upload',
			type : 'POST',
			secureuri : false, //是否启用安全提交,默认为false 
			fileElementId : 'fileField', //文件选择框的id属性
			dataType : 'String', //服务器返回的格式,可以是json或xml等
			success : function(data) { //服务器响应成功时的处理函数
				$("#commentForm").prepend('<input type="text" name="commentImagesAdd" value="'+ data +'"/>');
				var str = new Array();
				str = data.split("|");
				for (i = 0; i < str.length - 1; i++) {
					var imags = '<img src="/GalaxyMallImages/'+ str[i] +'"/>';
					$("#commentImages").append(imags);
				}
			},
			error : function(data, status, e) { //服务器响应失败时的处理函数
				alert("上传失败！");
			}
		});
	}
</script>
</head>
<body>
	<form action="<%=serverPath%>/comment/add/update" method="post">
	<div id="commentForm">
	<input type="hidden" name="orderDetailId" value="${orderDetailId}"/>
	追加评价：
	<textarea name="commentContentAdd" weight="600px" height="200px"></textarea></br>
	<input type="submit" value="提交追加评价"/>
	</div>
	</form>
	追加图片：
	<div id="commentImages">
		<input type="file" id="fileField" name="imgFiles" multiple="multiple">
		<input type="button" value="上传" onclick="ajaxFileUpload()" />
	</div>
</body>
</html>