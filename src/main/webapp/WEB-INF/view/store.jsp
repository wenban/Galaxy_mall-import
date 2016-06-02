<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String serverPath = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏店铺页</title>
<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
<script type="text/javascript">
$(function() {
	$("#deletestores").click(function(){
		var deltestoresId="";
		$("input:checked").each(function(i){
			if(i==0)
				deltestoresId=deltestoresId+$(this).val();
			else
				deltestoresId=deltestoresId+","+$(this).val();
		})
		location.href="<%=serverPath%>/userfavorit/remove/favoritestores?favoritStoreIds=" + deltestoresId;
	});
});
</script>
</head>
<body>
<div>
   <ul>
   <span id="selectstores"> 
   <a href="<%=serverPath%>/userfavorit/select/stores" >收藏店铺</a>
   <c:forEach items="${favoritstoresList}" var="favoritstores">
		<li>
		<input type="checkbox"  value="${favoritstores.storeid}" />
		 <p>店铺名称：${favoritstores.storeName}</p>
		 <p>店铺描述：${favoritstores.statement}</p>
		</li>
  </c:forEach>
  <input id="deletestores" type="submit" value="删除"/>
   </span>
   </ul>
   </div>

</body>
</html>