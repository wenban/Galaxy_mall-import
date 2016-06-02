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
<title>Insert title here</title>
<link rel="stylesheet" id="" href="<%=serverPath%>/css/WdatePicker.css" type="text/css" media="all">
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/My97DatePicker/calendar.js"></script>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/jquery.js"></script>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/ajaxfileupload.js"></script>
<script charset="UTF-8" type="text/javascript" src="<%=serverPath%>/js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
function ajaxFileUpload(){
	//开始上传文件时显示一个图片,文件上传完成将图片隐藏
	//$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});
	//执行上传文件操作的函数
	$.ajaxFileUpload({
		//处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
		url:'<%=serverPath%>/userInfo/updateUser/upload',
		secureuri:false,                       //是否启用安全提交,默认为false 
		fileElementId:'fileField',           //文件选择框的id属性
		dataType:'text',                       //服务器返回的格式,可以是json或xml等
		success:function(data, status){        //服务器响应成功时的处理函数
			$("#headimage").attr("src",data);
		},
		error:function(data, status, e){ //服务器响应失败时的处理函数
			alert("上传失败！");
		}
	});
}

</script>

</head>
<body>
	<div id="userinfopage">
		用户详细信息页面
		<div class="headimage">
		<img id="headimage" src="http://localhost:8088/images/${fulluser.userHeadImages}" height="40" width="40" />
		<!--  <input type="file"	name="fileField" class="file" id="fileField"/> -->
		 <input type="file" id="fileField" name="imgFile"/>
		<input type="button" id="uploadbutton" name="button" class="btn" value="上传" onclick="ajaxFileUpload()"/>
		</div>
			
		<form method="post" action="<%=serverPath%>/userInfo/updateUser/confirm">
		<ul id="userinfo">
			<li>你是第<span>${fulluser.id}</span>名用户！
			<input type="hidden"  name="id" value="${fulluser.id}" />
			</li>
			<li>用户名：<input type="text"  name="userName" value="${fulluser.userName}" /></li>
			<li>邮箱：<input type="text" name="userEmail" value="${fulluser.userEmail}" /></li>
			<li>性别：<select id="gender" name="userGender">
					<option value="男">男</option>
					<option value="女">女</option>
			</select>
			</li>
			<li>生日：<input id="d12" type="text" class="Wdate" onFocus="WdatePicker({onpicking:function(dp){if(!confirm('日期框原来的值为: '+dp.cal.getDateStr()+', 要用新选择的值:' + dp.cal.getNewDateStr() + '覆盖吗?')) return true;}})" name="userBirthday" value="${fulluser.userBirthday}"/></li>
			<li>手机：<input type="text" name="userMobile" value="${fulluser.userMobile}" /></li>
			<li>身份证：<input type="text" name="ID_card" value="${fulluser.ID_card}" /></li>
			<li>真实姓名：<input type="text" name="realName" value="${fulluser.realName}" /></li>
			<li>支付宝账号：<input type="text" name="userAlipay" value="${fulluser.userAlipay}" /></li>
		</ul>
			<input value="确认" type="submit" />
		</form>
	</div>
</body>
</html>