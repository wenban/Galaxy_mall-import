<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String serverPath = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script charset="utf-8" src="<%=serverPath%>/js/jquery.js"></script>
<script>

$(function() {
     $("#selectfirstcategory").change(function() {		
	     var options= '';
	     $.ajax({
		    url: '<%=serverPath%>/category/select/child?id='+ $("#selectfirstcategory").val(),
		    async: false,
		    success: function(data){
	 $.each(eval(data), function(i, SecondCategory){
				options = options + '<option value="'+ SecondCategory.id +'">'+ SecondCategory.categoryName +'</option>';
			});
	//		$("#categorySecond option:gt(0)").remove();
			$("#selectsecondcategory").html(options);
		},
		error: function(){
			alert("aaa");
		}
	    });	
    });


     $("#selectsecondcategory").change(function() {		
	     var options= '';
	     $.ajax({
		    url: '<%=serverPath%>/category/select/child?id='+ $("#selectsecondcategory").val(),
		    async: false,
		    success: function(data){
	 $.each(eval(data), function(i, thirdCategory){
				options = options + '<option value="'+ thirdCategory.id +'">'+ thirdCategory.categoryName +'</option>';
			});
	//		$("#categorySecond option:gt(0)").remove();
			$("#selectthirdcategory").html(options);
		},
		error: function(){}
	    });	
    });
})




</script>
</head>
<body>
     <select id="selectfirstcategory">
		<option>请选择一级分类</option>
		<c:forEach items="${firstCategoryList}" var="firstcategory">
			<option value="${firstcategory.id}">${firstcategory.categoryName}</option>
		</c:forEach>
	 </select>
	
	
	<select id="selectsecondcategory" >
		<option>请选择二级分类</option>
		
	</select>

   <select id="selectthirdcategory" >
		<option>请选择三级分类</option>
		
	</select>
	<ul>
	       
					<c:forEach items="${firstCategoryList}" var="firstcategory">
						<li >${firstcategory.categoryName}
						<a href="<%=serverPath%>/category/delete?id=${firstcategory.id}">删除</a>
							<ul>
							<c:forEach items="${firstcategory.childcategory}" var="secondcategory">
									<li>
									${secondcategory.categoryName}
									 <a href="<%=serverPath%>/category/delete?id=${secondcategory.id}">删除</a>
							      <ul>
							       <c:forEach items="${secondcategory.childcategory}" var="thirdcategory">
									<li>
									${thirdcategory.categoryName}</li>
									 <a href="<%=serverPath%>/category/delete?id=${thirdcategory.id}">删除</a>
							      </c:forEach>
							      </li> 
							      </ul>
							</c:forEach>
							</ul> 
						</li>
					</c:forEach>
			
				</ul>
</body>
</html>