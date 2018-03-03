<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib/commons.jsp"%>

<%-- 
/**
 * @Class Name : footer.jsp
 * @Description : common footer
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 * Copyright (C) by botbinoo's All right reserved.
 */ 
 --%>
<!-- Footer -->
<footer id="footer">
	<div class="inner">
		<section>
			<h2>Get in touch</h2>
			<form method="post" action="#">
				<div class="field half first">
					<input type="text" name="name" id="name" placeholder="Name" />
				</div>
				<div class="field half">
					<input type="email" name="email" id="email" placeholder="Email" />
				</div>
				<div class="field">
					<textarea name="message" id="message" placeholder="Message"></textarea>
				</div>
				<ul class="actions">
					<li><input type="submit" value="Send" class="special" /></li>
				</ul>
			</form>
		</section>
		<section>
			<h2>Follow</h2>
			<ul class="icons">
				<li><a href="#" class="icon style2 fa-twitter"><span
						class="label">Twitter</span></a></li>
				<li><a href="#" class="icon style2 fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon style2 fa-envelope-o"><span
						class="label">Email</span></a></li>
			</ul>
		</section>
		<ul class="copyright">
			<li>&copy; Untitled. All rights reserved</li>
			<li>Design: HTML5-UP</li>
			<li>Develop: botbinoo / jeungwon / byungjun / hyogod </li>
		</ul>
	</div>
</footer>