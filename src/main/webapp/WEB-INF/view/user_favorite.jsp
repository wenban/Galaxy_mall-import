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
<title>收藏宝贝页</title>
<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
<script type="text/javascript">
$(function() {
	$("#deletegoods").click(function(){
		var deletegoodsId="";
		$("input:checked").each(function(i){
			if(i==0)
				deletegoodsId=deletegoodsId+$(this).val();
			else
				deletegoodsId=deletegoodsId+","+$(this).val();
		})
		location.href="<%=serverPath%>/userfavorit/remove/favorites?favoriteIds=" + deletegoodsId;
	});
});


</script>
</head>
<body>
    <div>
   <ul>
   <span id="selectgoods"><a href="<%=serverPath%>/userfavorit/select/goods" >收藏宝贝</a>
   <a href="<%=serverPath%>/userfavorit/select/stores" >收藏店铺</a>
   <c:forEach items="${favoritgoodmodelList}" var="favoritgoodsmodel">
		<li>
		 <input type="checkbox" value="${favoritgoodsmodel.id}" />
		 <p>名称：${favoritgoodsmodel.modelName}</p>
		 <p>颜色：${favoritgoodsmodel.modelAttributeFName}</p>
		 <p>尺码：${favoritgoodsmodel.modelAttributeSName}</p>
		 <p>描述：${favoritgoodsmodel.modelDescription}</p>
		</li>
	</c:forEach>
	<input id="deletegoods" type="button" value="删除">
   </span>
   </ul>
   </div>
</body>
</html>