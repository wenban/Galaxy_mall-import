<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${webServerPath}/css/common.css" />
		<link rel="stylesheet" type="text/css" href="${webServerPath}/css/login.css" />
		<script charset="utf-8" src="${webServerPath}/js/jquery.js"></script>
		<script>
        	$(function() {
        		$("#loginbutton").click(function() {
        			if ($("#loginid").val() == "") {
        				alert("登录名不能为空");
        				return false;
        			} else if ($("#loginpassword").val() == "") {
        				alert("密码不能为空");
        				return false;
        			} else {
        				$("#loginlist").submit();
        			}
        		});
        	})
        </script>
	</head>
	<body>
		 <#include "top.ftl"/>
			</div>
		</header>

		<div class="login-wrapper">
			<div class="login-pos layout">
				<div class="login-box login-wth-code">
					<div class="login-bd login-opa60">
						<h3 class="login-title">登录GalaxyMall</h3>
						
						<form id="loginlist" action="${webServerPath}/login" method="post">
		
	
						
						
						<dl class="login-item">
							<dt>
							<span class="iconfont icon-acc-user"></span>
						</dt>
							<dd>
								<input id="loginid" type="text" name="username" placeholder="请输入用户名"/>
							</dd>
						</dl>
						<dl class="login-item">
							<dt>
							<span class="iconfont icon-acc-pwd"></span>
						</dt>
							<dd>
								<input id="loginpassword" type="password" name="password" placeholder="请输入密码"/>
							</dd>
						</dl>
						<p class="login-help">
							<a href="${webServerPath}/user/toRegister" class="register" target="_blank">立即注册</a>
							<a href="#" class="forget-pwd" target="_blank">忘记密码?</a>
						</p>
						<div class="login-code clearfix">
							<dl class="login-item ">
								<dt>
								<span class="iconfont icon-acc-kaptcha"></span>
							</dt>
								<dd>
									<input type="text" placeholder="验证码" />
								</dd>
							</dl>
							<a href="javascript:;" class="login-captcha">
								<img src="images/code.jpg" alt="点击刷新" />
							</a>
						</div>
						<a id="loginbutton" class="btn-block login-btn">
							<span class="txt">登录</span>
							<span class="iconfont icon-btn-go"></span>
						</a>
						
						
						</form>
						<#if error> 
							<div class="login-error">
								<span class="iconfont icon-wrong"></span>
								<p>${error}</p>
							</div>
						</#if>
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