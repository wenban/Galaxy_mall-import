<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${webServerPath}/css/common.css" />
		<link rel="stylesheet" type="text/css" href="${webServerPath}/css/login.css" />
		<script charset="utf-8" src="${webServerPath}/js/jquery.js"></script>
		
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
					<li class="item"><a href="">登录</a></li>
					<li class="split"></li>
					<li class="item"><a href="">注册</a></li>
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
				<a class="col-l logo" href="#">
					<img src="${webServerPath}/images/logo.png" alt="" />
				</a>
			</div>
		</header>
		<div class="login-wrapper">
			<div class="login-pos layout">
				<div class="login-box logined-box">
					<div class="login-bd login-opa60">
						<h3 class="login-title">欢迎光临GalaxyMall商城</h3>
						<div class="login-tip">
							<h4 class="acc-tip">你当前正在使用的XXX商城账户是:</h4>
							<p class="acc-info">${loginId}</p>
						</div><a href="javascript:;" class="btn-block login-btn">
							<span>点击进入会员中心</span>
						</a>
						<p class="login-help">
							<a href="#" class="get-audit" target="_blank">使用另一账户登录(注销，没写)</a>
						</p>
					</div>
				</div>
			</div>
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