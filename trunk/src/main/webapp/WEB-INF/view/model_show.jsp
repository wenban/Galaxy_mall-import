<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include_area/kindeditor_head.jsp"%>
<script type="text/javascript" src="<%=serverPath%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=serverPath%>/js/jsrender.min.js"></script>
<script type="text/javascript">
$(function() {
	//动态切换选中图片
	$("#show-img-by-id").attr("src",$(".click-img").children().attr("src"));
	$(".click-img").click(function() {
		var temp_img = $(this).children().attr("src");
		$("#show-img-by-id").attr("src",temp_img);
	});
	
	//处理goods属性
	var temp_attr_f = "";
	var temp_attr_s = "";
	var click_attr_f_id = "";
	var click_attr_s_id = "";
	var modelId = $("#modelId").val();
	
	//点击第一个属性,check第二个属性列表
	$(".attr-f a").click(function() {
		$("li a").removeClass("a-color");
		click_attr_f_id = $(this).parent().attr("id");
		$(this).addClass("a-color");
		temp_attr_f = $(this).html();
		if(temp_attr_f!=""){
			var firstAttributeList;
			$.ajax({
				url: '<%=serverPath%>/model/show/firstAttribute/'+modelId+','+temp_attr_f,
				async: false,
				success: function(data){
					firstAttributeList = data;
					$.each(eval(firstAttributeList), function(i, info){
						if($("#attr-s-desc-"+info)){
							$("#attr-s-desc-"+info+" a").addClass("a-color");
						}
					});
				},
				error: function(){alert("点击第一个属性,check第二个属性列表事件,ajax取值失败!!")}
			});
		}
	});

	
	//点击第二个属性,check第一个属性列表
	$(".attr-s a").click(function() {
		$("li a").removeClass("a-color");
		click_attr_s_id = $(this).parent().attr("id");
		$(this).addClass("a-color");
		temp_attr_s = $(this).html();
		if(temp_attr_s!=""){
			var firstAttributeList;
			$.ajax({
				url: '<%=serverPath%>/model/show/secondAttribute/'+modelId+','+temp_attr_s,
				async: false,
				success: function(data){
					secondAttributeList = data;
					$.each(eval(secondAttributeList), function(i, info){
						if($("#attr-f-desc-"+info)){
							$("#attr-f-desc-"+info+" a").addClass("a-color");
						}
					});
				},
				error: function(){alert("点击第二个属性,check第一个属性列表事件,ajax取值失败!!")}
			});
		}
	});
		
	//点击两个属性事件
	var mapKey = "";
	$(".click-attr a").click(function() {
		if(temp_attr_f!="" && temp_attr_s!=""){
			var clickGoods;
			$.ajax({
				url: '<%=serverPath%>/model/show/condition/'+modelId+','+temp_attr_f+','+temp_attr_s,
				async: false,
				success: function(data){
					clickGoods = data;
					$("#goods-inventory").html("商品库存:"+clickGoods.goodsInventory);
					$("#goods-old-price").html("单价(旧):"+clickGoods.goodsOldPrice);
					$("#goods-new-price").html("单价(新):"+clickGoods.goodsNewPrice);
					$("#buy-now-price").val(clickGoods.goodsNewPrice);
					$("#goods-id").val(clickGoods.id);
					//初始化参数
					$("li a").removeClass("a-color");
					$("#"+click_attr_f_id).children().addClass("a-color");
					$("#"+click_attr_s_id).children().addClass("a-color");
					temp_attr_f = "";
					temp_attr_s = "";
				},
				error: function(){alert("点击两个属性事件,ajax取值失败!!")}
			});
		}
	});
	
	//添加至购物车
	$("#add-to-shoppingtrolley").click(function() {
		if($("#goods-count").val()!=""){
		$.ajax({
			url: '<%=serverPath%>/shoppingtrolley/add?goodsId='+ $("#goods-id").val()
					+'&storeId='+$("#store-id").val()
					+'&goodsPrice='+$("#goods-new-price").val()
					+'&goodsCount='+$("#goods-count").val(),
					success : function(data) {
						if(data==1){
							alert("已经成功添加至购物车!");
							}
						if(data==2){
							alert("亲,您还没有登录,无法添加至购物车!");
						}
					},
					error : function() {
						alert("添加失败!");
					}
				});
		}
		else{
			alert("您没有填写购物数量,无法生成订单!请正确填写购买数量!");
		}
	});
	//立即购买
	$("#buy-now").click(function() {
		if($("#goods-count").val()!=""){
			$("#buy-now-form").submit();
		}
		else{
			alert("您没有填写购物数量,无法生成订单!请正确填写购买数量!");
		}
	});
	
});
</script>

<style>

#show-img-by-id {
	width:200px;
	height:200px;
}
.show-img-small {
	width:30px;
	height:30px;
}
ul {
	width:100%;
	height:30px;
}
li {
	list-style: none;
	float: left;
	margin: 0;
	padding: 0;
}
ul li .a-color{
	color:red;
}
.click-attr a{
	font-size:23px;
	color: #0088cc;
	text-decoration: none;
	padding-right: 5px;
}
#purchaseQuantity{
	width:50px;
}
</style>

<title>Model / Goods Show</title>
</head>
<body>
	<div>
		<h1>Model / Goods Show</h1>
		<br>
		
		
		<p>店铺ID:${completeGoodsInfo.storeId}</p>
		<p>商品ID:${storeInfo.id}</p>
		<input id="modelId" name="modelId" type="hidden" value="${completeGoodsInfo.id}">
		<p>店铺名:${storeInfo.storeName}</p>
		
		<p>商品分类ID:${completeGoodsInfo.categoryId}</p>
		
		<p>商品标题:${completeGoodsInfo.modelName}</p>
		
		<p>商品图片:</p>
			<img id="show-img-by-id" class="show-img-big" src=""  alt="">
		
		<p>
			<c:forEach items="${completeGoodsInfo.modelImagesList}" var="img" varStatus="status">
			<a class="click-img" href="javascript:;">
			<img id="show-img-id-${img.id}" class="show-img-small" src="${img.modelImage}"  alt=""></a>
			</c:forEach>
		</p>
		
		<p>商品销量:${completeGoodsInfo.dealCount}</p>
		
				<p>有无折扣:
			<c:choose>
				<c:when test="${completeGoodsInfo.modelIsDiscount == 0}">
					不享受折扣
   				</c:when>
	   			<c:otherwise>
					享受折扣!
    			</c:otherwise>
			</c:choose>
		</p>

<!-- *************************************************** -->
		<p>******************************************************************************<p>
	<form id="buy-now-form" action="<%=serverPath%>/order/create/direct" method="get">
		<p id="goods-inventory">商品库存:${one.GOODS_INVENTORY}</p>
		<p id="goods-old-price">单价(旧):${one.GOODS_OLD_PRICE}</p>
		<p id="goods-new-price">单价(新):${one.GOODS_NEW_PRICE}</p>
		<ul>
		<li>属性-${completeGoodsInfo.modelAttributeFName}:</li>
			<c:forEach items="${FirstAttributeList}" var="FAttribute" varStatus="status">
			<li id="attr-f-desc-${FAttribute}" class="click-attr attr-f"> 
			|<a href="javascript:;" >${FAttribute}</a>
			</li>
			</c:forEach>
		</ul>
		<ul>
		<li>属性-${completeGoodsInfo.modelAttributeSName}:</li>
			<c:forEach items="${SecondAttributeList}" var="SAttribute" varStatus="status">
			<li id="attr-s-desc-${SAttribute}" class="click-attr attr-s"> 
			|<a href="javascript:;">${SAttribute}</a>
			</li>
			</c:forEach>
		</ul>
		<p>购买数量:<input type="text" id="goods-count" name="goodsCount" value=""></p>
		<!-- 商品ID -->
		<input id="goods-id" type="hidden" name="goodsId" value="">
		<!-- 商品价格 -->
		<input id="buy-now-price" type="hidden" name="goodsPrice" value="">
		<!-- 店铺ID -->
		<input id="store-id" type="hidden" name="storeId" value="${completeGoodsInfo.storeId}">
		<p><input id="buy-now" type="button" value="立即购买"><p>
	</form>
		<button id="add-to-shoppingtrolley">添加至购物车</button>
		<a href="<%=serverPath%>/shoppingtrolley/list"><button>查看我的购物车</button></a>
		
		<p>******************************************************************************<p>
<!-- *************************************************** -->
		
		<p>被收藏数:${completeGoodsInfo.collectionCount}</p>
		
		<p>商品详情:</p>
		<p>******************************************************************************<p>
		<br>${completeGoodsInfo.modelDescription}<br>
		<p>******************************************************************************<p>
		<p>商品评论( ${completeGoodsInfo.commentCount} ):</p>
		<p>******************************************************************************<p>
			<br>匿名:真好用啊哈哈哈哈哈<br>
			<br>匿名:真好用啊哈哈哈哈哈<br>
			<br>匿名:真好用啊哈哈哈哈哈<br>
			<br>匿名:真好用啊哈哈哈哈哈<br>
			<br><br>
			<br><br>
			<br><br>
		<p>******************************************************************************<p>
	</div>
	
</body>
</html>