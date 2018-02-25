<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib/commons.jsp"%>

<%-- 
/**
 * @Class Name : main.jsp
 * @Description : common main
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 * Copyright (C) by botbinoo's All right reserved.
 */ 
 --%>
<
<c:choose>
	<c:when test="${empty isSection}">
		<!-- Main -->
		<!-- 이부분은 서정원이 담당할것임 -->
		<div id="main">
			<div class="inner">
				<header>
					<h1>
						간단한 회사소개/웹사이트 소개가 간략하게 들어갑니다.<br /> 간단한 회사소개/웹사이트 소개가 간략하게 들어갑니다.
					</h1>
					<p>내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.
					내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.
					내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.
					내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.내용이 들어갑니다.</p>
				</header>
				<section class="tiles">
					<article class="style1">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic01.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Magna</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style2">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic02.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Lorem</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style3">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic03.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Feugiat</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style4">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic04.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Tempus</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style5">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic05.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Aliquam</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style6">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic06.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Veroeros</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style2">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic07.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Ipsum</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style3">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic08.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Dolor</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style1">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic09.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Nullam</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style5">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic10.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Ultricies</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style6">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic11.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Dictum</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
					<article class="style4">
						<span class="image"> <img
							src="<c:url value='/resources/img/pic12.jpg'/>" alt="" />
						</span> <a href="generic.html">
							<h2>Pretium</h2>
							<div class="content">
								<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
									veroeros et feugiat.</p>
							</div>
						</a>
					</article>
				</section>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<!-- 컨텐츠 드라이븐은 별도 데이터가 생겨나면 해당 페이지를 포함하도록 정의해야함. -->
		<!-- 비워두기 아까워서 일단 아무거나 삽입. -->
		<div id="main">
			<div class="inner">
				<h1>Generic Page</h1>
				<span class="image main"><img
					src="<c:url value='/resources/img/pic13.jpg'/>" alt="" /></span>
				<p>Donec eget ex magna. Interdum et malesuada fames ac ante
					ipsum primis in faucibus. Pellentesque venenatis dolor imperdiet
					dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas enim
					auctor sit amet. Pellentesque leo mauris, consectetur id ipsum sit
					amet, fergiat. Pellentesque in mi eu massa lacinia malesuada et a
					elit. Donec urna ex, lacinia in purus ac, pretium pulvinar mauris.
					Curabitur sapien risus, commodo eget turpis at, elementum convallis
					elit. Pellentesque enim turpis, hendrerit tristique.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis
					dapibus rutrum facilisis. Class aptent taciti sociosqu ad litora
					torquent per conubia nostra, per inceptos himenaeos. Etiam
					tristique libero eu nibh porttitor fermentum. Nullam venenatis erat
					id vehicula viverra. Nunc ultrices eros ut ultricies condimentum.
					Mauris risus lacus, blandit sit amet venenatis non, bibendum vitae
					dolor. Nunc lorem mauris, fringilla in aliquam at, euismod in
					lectus. Pellentesque habitant morbi tristique senectus et netus et
					malesuada fames ac turpis egestas. In non lorem sit amet elit
					placerat maximus. Pellentesque aliquam maximus risus, vel venenatis
					mauris vehicula hendrerit.</p>
				<p>Interdum et malesuada fames ac ante ipsum primis in faucibus.
					Pellentesque venenatis dolor imperdiet dolor mattis sagittis.
					Praesent rutrum sem diam, vitae egestas enim auctor sit amet.
					Pellentesque leo mauris, consectetur id ipsum sit amet, fersapien
					risus, commodo eget turpis at, elementum convallis elit.
					Pellentesque enim turpis, hendrerit tristique lorem ipsum dolor.</p>
			</div>
		</div>
	</c:otherwise>
</c:choose>