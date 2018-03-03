<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglib/commons.jsp"%>

<%-- 
/**
 * @Class Name : error.jsp
 * @Description : error page
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 * Copyright (C) by botbinoo's All right reserved.
 */ 
 --%>
<!-- error -->
<div id="main">
	<div class="inner">
		<h1>Error Page</h1>
		<span class="image main"><img
			src="<c:url value='/resources/img/if_dialog-error_118938.svg'/>"
			alt="not found(오류)"></span>

		<p>죄송합니다. 오류 페이지입니다. 반복되는 오류가 발생할 경우, 아래 이름을 기재한 개발자들에게 연락 주시길 바랍니다.</p>
		<p>Sorry, This is error pages. If you see this page again, please send to error to developer who name in footer.</p>
	</div>
</div>
<script>
var gap = $('.image.main').width()-120;
$('.image.main>img').attr({"style":"margin-left:"+(gap/2)+"px; width:120px;"});
</script>