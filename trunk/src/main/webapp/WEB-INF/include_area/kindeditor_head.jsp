<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String serverPath = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath();
%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<%=serverPath%>/js/jquery.js"></script>
		<link rel="stylesheet" href="<%=serverPath%>/js/themes/default/default.css" />
		<link rel="stylesheet" href="<%=serverPath%>/js/plugins/code/prettify.css" />
		<script charset="utf-8" src="<%=serverPath%>/js/kindeditor-all-min.js"></script>
		<script charset="utf-8" src="<%=serverPath%>/js/lang/zh-CN.js"></script>
		<script charset="utf-8" src="<%=serverPath%>/js/plugins/code/prettify.js"></script>

		<script type="text/javascript">
			KindEditor.ready(function(K) {
				var editor1 = K.create('#modelImages', {
					uploadJson : '<%=serverPath%>/KindED'
				});
			});
		</script>
		
		<script type="text/javascript">
			KindEditor.ready(function(K) {
				var editor1 = K.create('#modelDescription', {
					uploadJson : '<%=serverPath%>/KindED'
				});
			});
		</script>
		
		
