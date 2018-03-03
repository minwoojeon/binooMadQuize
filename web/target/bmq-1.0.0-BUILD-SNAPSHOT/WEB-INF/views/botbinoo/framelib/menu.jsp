<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib/commons.jsp"%>

<%-- 
/**
 * @Class Name : menu.jsp
 * @Description : common menu
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 * Copyright (C) by botbinoo's All right reserved.
 */ 
 --%>
<!-- Menu -->
<nav id="menu">
	<h2>Menu</h2>
	<ul>
		<!-- <li><a href="/bmq/">Home</a></li> -->
		<c:forEach var="menu" items="${menuList}" varStatus="status">
			<li><a href="${menu.menuURL}">${menu.menuTitle}</a></li>
		</c:forEach>
	</ul>
</nav>