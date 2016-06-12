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
		 <#include "top.ftl"/>
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
							<a href="${webServerPath}/logout" class="get-audit" target="_blank">使用另一账户登录</a>
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