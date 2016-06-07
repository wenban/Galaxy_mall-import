<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String serverPath = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户实名认证</title>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/jquery.js"></script>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/ajaxfileupload.js"></script>
<script type="text/javascript">
function ajaxFileUpload(){
	//开始上传文件时显示一个图片,文件上传完成将图片隐藏
	//执行上传文件操作的函数
	$.ajaxFileUpload({
		//处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
		url:'<%=serverPath%>/userInfo/sellerCertification/upload',
		type: 'POST',
		secureuri:false,                     //是否启用安全提交,默认为false 
		fileElementId:'fileField',           //文件选择框的id属性
		dataType:'text',                       //服务器返回的格式,可以是json或xml等
		success:function(data, status){        //服务器响应成功时的处理函数
			$("#realimage").attr("src",data);
		},
		error:function(data, status, e){ //服务器响应失败时的处理函数
			alert("上传失败！");
		}
	});
}

</script>
</head>
<body>
	<div id="sellerCertification">
		<img id="realimage" src="http://localhost:8088/Images/seller_default.jpg" height="100" width="100" />
		<input type="file" id="fileField" name="imgFile" /> 
		<input type="button" id="uploadbutton" name="button" class="btn" value="上传" onclick="ajaxFileUpload()" />
		<form method="post" action="<%=serverPath%>/userInfo/sellerCertification/confirm">
		<input type="hidden"  name="id" value="${seller.id}" />
		身份证：<input type="text" name="ID_card" value="" /> 
		真实姓名：<input type="text" name="realName" value="" /> 
		<input type="submit" value="提交"/>
		</form>
	</div>
</body>
</html>