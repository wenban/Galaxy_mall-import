<div class="col-l bn-categorys">
	<div class="bn-category-hd">
			<a href="#">全部商品分类</a>
	</div>
	<div class="bn-category-bd">
			<ul class="bn-category-items">
				<#list firstCategoryList as firstcategory> 
				<li>
					<div class="bc-item" href="javascript:;">
						<div class="bc-item-main">
							<a href="#">${firstcategory.categoryName}</a>
								<i class="iconfont icon-arr-right"></i>
						</div>
						<div class="bc-item-sub">
							<div class="bc-sub-wrap">
								<dl class="clearfix">
								<#list firstcategory.childcategory as secondcategory> 
									<dt><a href="#">${secondcategory.categoryName}</a></dt>
									<dd>
										<#list secondcategory.childcategory as thirdcategory> 											
										<a href="#">${thirdcategory.categoryName}</a>
										</#list> 
									</dd>
								</#list> 
								</dl>								
							</div>
						</div>
					</div>
				</li>
				</#list> 
			</ul>
	</div>
<div>