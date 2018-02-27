<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglib/commons.jsp"%>

<%-- 
/**
 * @Class Name : normalList.jsp
 * @Description : bbs list view
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 * Copyright (C) by botbinoo's All right reserved.
 */ 
 --%>
<!-- bbs list view -->
<div id="main">
	<div class="inner">
		<h1>자유 게시판</h1>
		<span class="image main"> <%-- <img
			src="<c:url value='/resources/img/if_dialog-error_118938.svg'/>"
			alt="not found(오류)"> --%>
		</span>

		<p>자유 게시판입니당.</p>
		<form:form commandName="dataVO" name="searchFrm" id="searchFrm"
			method="post">
			<form:hidden path="searchKeyword" id="searchKeyword" />
			<form:hidden path="currentPage" id="currentPage" />
			<form:hidden path="searchKeycode" id="searchKeycode" />
		</form:form>

		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목(조회수)</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${boardList}" varStatus="status">
						<tr>
							<td scope="row"><c:out
									value="${paginationInfo.totalRecordCount+1 - ((dataVO.pageIndex-1) * dataVO.pageSize + status.count)}" /></td>
							<td scope="row"><a
								href="javascript:board.detail('view', <c:out value="${item.seq}" />);">
								<c:out value="${item.title}" /> (<c:out value="${item.hits}" />)
							</a></td>
							<td scope="row"><c:out value="${item.userid}" /></td>
							<td scope="row"><c:out value="${item.regdt}" /></td>
						</tr>
					</c:forEach>
				</tbody>
				<!-- <tfoot>
					<tr>
						<td colspan="2"></td>
						<td>100.00</td>
					</tr>
				</tfoot> -->
			</table>
		</div>

	</div>
</div>
<script type="text/javascript">
<!--
var board = {
	list : function( pageNo ){
		$('#currentPage').attr('value',pageNo);
		$('#searchFrm').attr({'method':'post','action':'list'}).submit();
	},
	detail : function( mode, no ){
		if( mode == 'create' ){
			no = '';
		}
		$('#searchFrm').attr({'method':'post','action':'detail/'+mode+'Board/'+no}).submit();
	}
};
//-->
</script>
