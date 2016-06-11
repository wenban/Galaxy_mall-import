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
		<div class="topbar">
			<div class="layout">
				<ul class="topbar-items col-l">
					<li class="item"><a href="${webServerPath}/userInfo">用户信息查询</a></li>
					<li class="split"></li>
					<li class="item"><a href="${webServerPath}/toUserfavorit">我的收藏</a></li>
					<li class="split"></li>
					<li class="item"><a href="${webServerPath}/user/toHistory">我的足迹</a></li>
					<li class="split"></li>
					<li class="item"><a href="${webServerPath}/model/show/1">测试商品</a></li>
					<li class="item"><a href="${webServerPath}/store/toCreate">创建店铺</a></li>
					<li class="item"><a href="${webServerPath}/store/select/self">查看我的店铺</a></li>
				</ul>
				<ul class="topbar-items col-r">
					<li class="item"><a href="${webServerPath}/login">登录</a></li>
					<li class="split"></li>
					<li class="item"><a href="${webServerPath}/user/toRegister">注册</a></li>
					<li class="item">
						<a href="">
							<span class="iconfont icon-ucenter"></span>个人中心
						</a>
					</li>
					<li class="item">
						<a href="">
							<span class="iconfont icon-order"></span>我的订单
						</a>
					</li>
					<li class="item">
						<a href="">
							<span class="iconfont icon-fav"></span>收藏夹
						</a>
					</li>
					<li class="item item-panel">
						<a href="" class="panel-hd">
							<span class="col-l iconfont icon-cart"></span>
							<span class="col-l title">购物车</span>
							<span class="col-l count">0</span>
						</a>
						<ul class="panel-bd"></ul>
					</li>
				</ul>
			</div>
		</div>
		<header id="header" class="header">
			<div class="layout">
				<a class="col-l logo" href="${staticServerPath}index.html">
					<img src="${webServerPath}/images/logo.png" alt="" />
				</a>