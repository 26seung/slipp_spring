<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navber-inner">
		<div class="container">

			<button type="button" class="btn btn_navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>

			<a class="brand" href="/"> 지속가능한 삶, 프로그래밍, 프로그래머</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li><a href="/">Home</a></li>
					<c:if test="${empty sessionScope.userId}">
					<li><a href="/users/login/form">로그인</a></li>
					<li><a href="/users/form">회원가입</a></li>
					</c:if>
					<c:if test="${not empty sessionScope.userId}">
					<li><a href="">로그아웃</a></li>
					<li><a href="">개인정보수정</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>

