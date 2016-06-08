<html>  
  <head>  
  		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>freemarker测试</title>  
    </head>  
    <body>  
					hahaha
					<#list firstCategoryList as firstcategory> 
							<a href="#">${firstcategory.categoryName}</a>
							<#list firstcategory.childcategory as secondcategory> 
								<a href="#">${secondcategory.categoryName}</a></dt>
								<#list secondcategory.childcategory as thirdcategory> 											
									<a href="#">${thirdcategory.categoryName}</a>
								</#list> 
							</#list> 
					</#list> 
					<h2><a href="${webServerPath}/store/toCreate">111</a></h2>
					<h2><a href="${staticServerPath}/images/1118203873_771n.jpg">222</a></h2>
    </body>  
</html> 