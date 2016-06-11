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
        		$("#loginId").blur(function() {
        			$.ajax({
        				url: '${webServerPath}/user/register/loginId_confirm?loginId='
        												+ $("#loginId").val(),
        										success : function(data) {
        											if (data == 1) {
        												alert("用户名已存在!");
        											}
        										},
        										error : function() {
        											alert("验证失败!");
        										}
        									});
        						});
        		$("#submitbutton").click(function() {
					if ($("#loginId").val() == "") {
        				alert("用户名不为空");
        				return false;
        			} else if ($("#loginPassWord").val() == "") {
        				alert("密码不能为空");
        				return false;
        			}
        			var loginPassWord = $("#loginPassWord").val();
        			var loginPassWordconfirm = $("#loginPassWordconfirm").val();
        			var warning = '<span>两次输入密码不一致</span>';
					//????
        			if ($("#agree").val() != "1") {
        				alert("请同意协议");
        				return false;
        			}
					
        			if (loginPassWord == loginPassWordconfirm) {
        				$("#loginform").submit();
        			} else {
        				$("#confirmpassword").append(warning);
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
					<form class="forms" id="loginform" action="${webServerPath}/user/insert/login_register" method="post">
						<input type="hidden" name="userEmail" id="userEmail" value="${userEmail}"/>
						<div class="form-item">
							<div class="form-entity">
								<div class="form-label">用 户 名</div>

								<div class="form-filed">
									<input type="text" class="form-part f-ipt" name="loginId" id="loginId" placeholder="请输入用户名"/>
								</div>
								<div class="form-status"></div>
							</div>
							<div class="form-tips"></div>
						</div>
						<div class="form-item">
							<div class="form-entity">
								<div class="form-label">密 码</div>
								<div class="form-filed">
								<input type="password" name="loginPassWord" id="loginPassWord" class="form-part f-ipt" placeholder="请输入密码"/>
								</div>
								<div class="form-status"></div>
							</div>
							<div class="form-tips"></div>
						</div>
						
						<div class="form-item">
							<div class="form-entity">
								<div class="form-label">确 认 密 码</div>
								<div class="form-filed">
								<div id="confirmpassword">
									<input type="password" name="loginPassWordconfirm" id="loginPassWordconfirm" class="form-part f-ipt" placeholder="请确认密码"/>
								</div>
									</div>
								<div class="form-status"></div>
							</div>
							<div class="form-tips"></div>
						</div>
						
						<div class="form-agreen" >
							<input id="agree" type="checkbox" class="f-cb" value="1"/>我已阅读并同意<a href="javascript:;">《用户注册协议》</a>
						</div>
						<div class="form-action">
							<a href="javascript:;" class="btn-block" id="submitbutton"><span class="txt">确定</span>
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