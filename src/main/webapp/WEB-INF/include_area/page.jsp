<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${page.totalPage > 1}">
	<input type="hidden" id="cp" name="currentPage" value="${page.currentPage}" />
	<input type="hidden" id="ttp" value="${page.totalPage}" />
	<div class="pagenavi">
		<span class="page-numbers">${page.currentPage} / ${page.totalPage} </span> 
		<c:choose>
			<c:when test="${page.currentPage - 1 > 2}">
				<a class="page-numbers" href="javascript:;">1</a>
				<span class="page-numbers">...</span>
			</c:when>
			<c:when test="${page.currentPage - 1 == 2}">
				<a class="page-numbers" href="javascript:;">1</a>
			</c:when>
		</c:choose>
		<c:forEach items="${page.pageList}" var="page0">
			<c:choose>
				<c:when test="${page.currentPage == page0}">
					<span id="" class="page-numbers current">${page0}</span>
				</c:when>
				<c:otherwise>
					<a class="page-numbers" href="javascript:;">${page0}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${page.currentPage + 2 < page.totalPage}">
				<span class="page-numbers">...</span>
				<a class="page-numbers" href="javascript:;">${page.totalPage}</a>
			</c:when>
			<c:when test="${page.currentPage + 2 == page.totalPage}">
				<a class="page-numbers" href="javascript:;">${page.totalPage}</a>
			</c:when>
		</c:choose>
		<a class="page-numbers next" href="javascript:;" title="下一页">下一页</a>
	</div>

	<script type="text/javascript">
		$(function() {

			// 分页
			$(".pagenavi a").click(function() {
				if ($(this).hasClass("prev")) {
					$("#cp").val($("#cp").val() * 1 - 1);
				} else if ($(this).hasClass("next")) {
					if($("#cp").val()==$("#ttp").val()){
						$("#cp").val($("#cp").val());
					}
					else {
						$("#cp").val($("#cp").val() * 1 + 1);
						}
				} else {
					$("#cp").val($(this).html());
				}
				$(".page-form").submit();
			});
		});
	</script>

</c:if>