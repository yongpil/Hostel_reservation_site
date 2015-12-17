<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="javaScript/headerScript.js"></script>
<link rel="stylesheet" href="css/Template/headerStyle.css">

<script>
	$(document).ready(function()
	{
		$(".menuButton").click(function()
		{
			var submenu = $(".menuContent");
			if(submenu.css("margin-left")=='-300px')
			{
				submenu.stop().animate({'marginLeft':'0'},300);
			}
			else
			{
				submenu.stop().animate({'marginLeft':'-300px'},300);
			}
		})
	})
</script>
<div class="header">
	<div class="leftWrap">
		<div class="menuButton">
			<img src="resources/menuButton.png">
		</div>
	</div>
	<div class="centerWrap">
		<div class="logo">
			<a href="index.html"><img src="resources/logo.png" border="0" alt="Hostel Tonight"></a>
		</div>
	</div>
	<div class="rightWrap">
	</div>
	
	<div class="menuContent">
		<!-- Login State -->
		<s:authorize ifAnyGranted="ROLE_USER">
			<div class="navAccount">
				<p onclick="location.href='#'">내 계정</p>
			</div>
			<div class="navReservation">
				<p onclick="location.href='#'">내 예약사항</p>
			</div>
			<div class="navReview">
				<p onclick="location.href='#'">내 리뷰</p>
			</div>
			<div class="navWishlist">
				<p onclick="location.href='#'">위시리스트</p>
			</div>
			<div class="navWishlist">
				<a href="${pageContext.request.contextPath}/j_spring_security_logout">로그아웃</a>
			</div>
		</s:authorize>
		<!-- Logout State -->
		<s:authorize ifAnyGranted="ROLE_ADMIN">
			<div class="navLogin">
				<p onclick="location.href='hostelAdmin.html'">호스텔 관리자 페이지</p>
			</div>
			<div class="navWishlist">
				<a href="${pageContext.request.contextPath}/j_spring_security_logout">로그아웃</a>
			</div>
		</s:authorize>
	</div>
</div>