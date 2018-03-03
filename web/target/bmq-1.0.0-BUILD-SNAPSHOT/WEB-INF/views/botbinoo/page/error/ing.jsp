<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglib/commons.jsp"%>

<%-- 
/**
 * @Class Name : ing.jsp
 * @Description : ing page (공사중)
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 * Copyright (C) by botbinoo's All right reserved.
 */ 
 --%>
<!-- error -->
<div id="main">
	<div class="inner">
		<h1>ing Page</h1>
		<span class="image main"><img
			src="<c:url value='/resources/img/if_hourglass_1055043.svg'/>"
			alt="working(작업중)"></span>

		<p>더욱 좋은 화면과 서비스를 전해드리기 위해 작업중에 있습니다. </p>
		<p>점검기간 : <c:out value="${startTime} ~ ${endTime} }"/></p>
		<p></p>
		<p>We are working on delivering better screens and services.</p>
		<p>During : <c:out value="${startTime} ~ ${endTime} }"/></p>
	</div>
</div>
<script>
var gap = $('.image.main').width()-120;
$('.image.main>img').attr({"style":"margin-left:"+(gap/2)+"px; width:120px;"});
</script>