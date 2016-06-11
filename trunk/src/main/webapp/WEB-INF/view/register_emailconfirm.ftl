<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${webServerPath}/css/common.css" />
		<link rel="stylesheet" type="text/css" href="${webServerPath}/css/na.css" />
		<script charset="utf-8" src="${webServerPath}/js/jquery.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#getcaptcha").click(function() {
					$.ajax({
						url: '${webServerPath}/user/register/email_confirm?userEmail='
														+ $("#userEmail").val(),
												success : function(data) {
													if (data == 0) {
														alert("验证码已发送至您的邮箱!");
													} else if (data == 1) {
														alert("该邮箱已被注册!");
													}
		
												},
												error : function() {
													alert("验证失败!");
												}
											});
								});
				$("#sure").click(function() {
        			if ($("#userEmail").val() == "") {
        				alert("邮箱不为空");
        				return false;
        			} else if ($("#captcha").val() == "") {
        				alert("验证码不能为空");
        				return false;
        			} else {
        				$("#emailform").submit();
        			}
        		});
		
			});
		</script>
		
		
		
		
		
	</head>

	<body>
		<#include "top.ftl"/>
			</div>
		</header>
		
		
		<div class="page na-page">
			<div class="layout">
				<div class="col-l na-form">
					<form class="forms" id="emailform" action="${webServerPath}/user/register/captcha_confirm" method="post">
						<div class="form-item">
							<div class="form-entity">
								<div class="form-label">邮 箱</div>

								<div class="form-filed">
									<input type="text" class="form-part f-ipt" name="userEmail" id="userEmail" placeholder="请输入注册邮箱" />
									
								</div>
								<input type="button" name="getcaptcha" id="getcaptcha" value="获取验证码" />
								<div class="form-status"></div>
							</div>
							<div class="form-tips"></div>
						</div>
						<div class="form-item">
							<div class="form-entity">
								<div class="form-label">验 证 码</div>

								<div class="form-filed">
									<input type="text" name="captcha" id="captcha" class="form-part f-ipt" placeholder="请输入验证码"/><span>${captchaError}</span>
								</div>
								<div class="form-status"></div>
							</div>
							<div class="form-tips"></div>
						</div>
						
						
						<!--<div class="form-agreen">
							<input type="checkbox" class="f-cb" />我已阅读并同意<a href="javascript:;">《用户注册协议》</a>
						</div>-->
						<div class="form-action">
							<a href="javascript:;" class="btn-block" id="sure"><span class="txt">确定</span>
							<span class="iconfont icon-btn-go"></span>
						</a>
						</div>
					</form>
				</div>
				<div class="col-l na-other">
					<div class="to">
						已有GalaxyMall商城账号 <a href="${webServerPath}/Galaxy_mall/login">立即登录</a>
					</div>
					<div class="bg"></div>
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