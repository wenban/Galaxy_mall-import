 <#include "manager_model_top.ftl"/>
<div class="table-responsive">
		<table id="sample-table-2" class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th class="center">
					<label>
						<input type="checkbox" class="ace" />
						<span class="lbl"></span>
					</label>
				</th>
				<th>ID</th>
				<th>分类名称</th>
				<th class="hidden-480">创建时间</th>

				<th>
					<i class="icon-time bigger-110 hidden-480"></i>
					创建人
				</th>
				<th class="hidden-480">删除时间</th>

				<th>是否可用</th>
			</tr>
		</thead>

		<tbody>
			<#list categoryList as category> 
			<tr>
				<td class="center">
					<label>
						<input type="checkbox" class="ace" />
						<span class="lbl"></span>
					</label>
				</td>

				<td>
					${category.id}
				</td>
				<td>${category.categoryName}</td>
				<td class="hidden-480">${category.createTime}</td>
				<td>${category.createUserId}</td>
				<td>category.removeTime</td>

				<td class="hidden-480">
					<span class="label label-sm label-warning">${category.categoryEnable}</span>
				</td>

				<td>
					<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
						<a class="blue" href="${webServerPath}/category/select?id=${category.id}">
							<i class="icon-zoom-in bigger-130"></i>
						</a>

						<a class="green" href="#">
							<i class="icon-pencil bigger-130"></i>
						</a>

						<a class="red" href="#">
							<i class="icon-trash bigger-130"></i>
						</a>
					</div>

					
				</td>
			</tr>		
			</#list>								
		</tbody>
	</table>
</div>
<#include "manager_model_bottom.ftl"/>