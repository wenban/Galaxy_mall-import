<script type="text/javascript">
	$(function() {      
			//校验当前用户是否有店铺
			$("#myStore").click(function() {
				$.ajax({
					url: '${webServerPath}/store/select/toSelf',
					async: false,
					success: function(data){
						if(data==flase){
							alert("您还没有创建过店铺,无法查看店铺信息!");
						}else{
							location.href="${webServerPath}/store/select/self";
						}
					},
					error: function(){
						alert("校验 myStore 失败!");
						}
				});
			});
	});
</script>
		<div class="topbar">
			<div class="layout">
				<ul class="topbar-items col-l">
					<li class="item"><a href="${webServerPath}/userInfo">用户信息查询</a></li>
					<li class="split"></li>
					<li class="item"><a href="${webServerPath}/toUserfavorit">我的收藏</a></li>
					<li class="split"></li>
					<li class="item"><a href="${webServerPath}/user/toHistory">我的足迹</a></li>
					<li class="split"></li>
					<li class="item"><a href="${webServerPath}/model/list/all">测试商品</a></li>
					<li class="item"><a href="${webServerPath}/store/toCreate">创建店铺</a></li>
					<li class="item" id="myStore"><a href="javaScript:;">查看我的店铺</a></li>
				</ul>
				<ul class="topbar-items col-r">
					<li class="item"><a href="${webServerPath}/login">登录</a></li>
					<li class="split"></li>
					<li class="item"><a href="${webServerPath}/user/toRegister">注册</a></li>
					<li class="item">
						<a href="${webServerPath}/userInfo">
							<span class="iconfont icon-ucenter"></span>个人中心
						</a>
					</li>
					<li class="item">
						<a href="${webServerPath}/order/list/all/forUser">
							<span class="iconfont icon-order"></span>我的订单
						</a>
					</li>
					<li class="item">
						<a href="${webServerPath}/shoppingtrolley/list">
							<span class="iconfont icon-fav"></span>收藏夹
						</a>
					</li>
					<li class="item item-panel">
						<a href="${webServerPath}/shoppingtrolley/list" class="panel-hd">
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