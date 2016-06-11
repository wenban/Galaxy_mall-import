<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${webServerPath}/css/common.css" />
		<link rel="stylesheet" type="text/css" href="${webServerPath}/css/index.css" />
		<script charset="utf-8" src="${webServerPath}/js/jquery.js"></script>
		<script type="text/javascript">
        	$(function() {       
        			$.ajax({
        				url: '${webServerPath}/getLoginId',
        				success : function(data) {
        					//alert(11);	
        						if (data != "0") {
        							alert(data);
        						}
        				},
        				error : function() {//alert(22);}
        			});       			  
        	});
        </script>
	</head>
	<body>
		<!--#include file="top.html"-->	
				<div class="col-r">
					<div class="search clearfix">
						<input type="text" class="search-ipt" />
						<a href="javascript:;" class="search-btn search-btn-goods">搜索宝贝</a>
						<a href="javascript:;" class="search-btn search-btn-shop">搜索店铺</a>
					</div>
					<ul class="keyword">
						<li><a href="#">玩转3C</a></li>
					</ul>
				</div>
			</div>
		</header>
		<div id="banner" class="banner">
			<div class="layout clearfix banner-wrap">
			
				<!--#include file="index_category.html"-->
				
				<div class="col-l bn-main">
					<div class="bn-main-hd">
						<ul class="bn-rapid-nav">
							<li><a href="#">导航一</a></li>
							<li class="r"><a href="#">热卖商品</a></li>
						</ul>
					</div>
					<div class="bn-main-bd">
					
						<!--#include file="index_vip_ad.html"-->
						
						<!--#include file="index_hot_discount.html"-->
						
					</div>

				</div>
			</div>
		</div>
		<div class="layout">
			

			<div class="section clearfix">
				<div class="mainbar">
				
					<!--#include file="index_hot_brand.html"-->
					
					<!--#include file="index_hot_category.html"-->
					
				</div>
				
					<!--#include file="index_right_ad.html"-->
			<div>
			
			<!--#include file="index_hot_model.html"-->
			
			<!--#include file="index_new_model.html"-->
			
			<!--#include file="index_guess_model.html"-->
			
		</div>
		<div id="footer" class="footer">
			<p class="links">
				<a href="#">关于本站</a>|
				<a href="#">关于我们</a>|
				<a href="#">团队成员</a>|
				<a href="#">联系我们</a>|
				<a href="#">意见反馈</a>
			</p>
			<p class="coryright">
				Copyright © 2016 Lanqiao-Jlu Java 版权所有
			</p>
		</div>
	</body>

</html>