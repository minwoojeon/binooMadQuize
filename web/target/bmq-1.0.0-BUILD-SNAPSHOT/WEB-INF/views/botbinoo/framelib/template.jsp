<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib/commons.jsp"%>

<%-- 
/**
 * @Class Name : template.jsp
 * @Description : common template
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 * Copyright (C) by botbinoo's All right reserved.
 */ 
 --%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title></title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	
	<%@include file="../taglib/includecss.jsp"%>

</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<%@include file="../framelib/header.jsp"%>

		<!-- Menu -->
		<%@include file="../framelib/menu.jsp"%>

		<!-- Main -->
		<%@include file="../framelib/main.jsp"%>

		<!-- Footer -->
		<%@include file="../framelib/footer.jsp"%>

	</div>

	<!-- Scripts -->
	<%@include file="../taglib/includejs.jsp"%>

</body>
</html>