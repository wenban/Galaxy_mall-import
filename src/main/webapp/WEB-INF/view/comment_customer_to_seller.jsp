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
<title>买家评价卖家页</title>

<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
<script charset="UTF-8" type="text/javascript"
	src="<%=serverPath%>/js/ajaxfileupload.js"></script>
<script type="text/javascript">
function ajaxFileUpload(){
	$.ajaxFileUpload({
		url:'<%=serverPath%>/comment/upload',
			type : 'POST',
			secureuri : false, //是否启用安全提交,默认为false 
			fileElementId : 'fileField', //文件选择框的id属性
			dataType : 'String', //服务器返回的格式,可以是json或xml等
			success : function(data) { //服务器响应成功时的处理函数
				$("#commentForm").prepend('<input type="hidden" name="commentImages" value="'+ data +'"/>');
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
	<form action="<%=serverPath%>/comment/from/customer" method="post">
		<div id="commentForm">
			您给该卖家的评价为： 
			<select name="commentCustomerNumber">
				<option value="5">非常好</option>
				<option value="3">好</option>
				<option value="0">一般</option>
				<option value="-3">中</option>
				<option value="-5">差</option>
			</select></br> 
			评价：
			<textarea name="commentContent" weight="400px" height="200px"></textarea></br>
			<input type="text" name="commentImages" value="${commentImages}"/>
			<input type="hidden" name="orderDetailId" value="${orderDetailId}"/>
			<input type="hidden" name="goodsId" value="${goodsId}"/> 
			<input id="commentSubmitButton" type="submit" value="提交评价" />
		</div>
	</form>
	上传图片：
	<div id="commentImages">
		<input type="file" id="fileField" name="imgFiles" multiple="multiple">
		<input type="button" value="上传" onclick="ajaxFileUpload()" />
	</div>
</body>
</html>