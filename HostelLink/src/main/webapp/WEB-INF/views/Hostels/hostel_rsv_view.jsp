<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="com.NeoRomax.HostelTonight.HostelList.Dto.*"%>
<%@ page import="com.NeoRomax.HostelTonight.Rsv.Dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String userId = (String)session.getAttribute("id");
%>
<%
/* =================================================================
 * 
 * 작성일 : 2015. 11. 20.
 *  
 * 작성자 : 문용필
 * 
 * 상세설명 : 
 *   
 * =================================================================
 * 수정일         작성자             내용     
 * -----------------------------------------------------------------------
 * 
 * =================================================================
 */ 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="dist/js/bootstrap.js"></script>
  <link rel="stylesheet" href="hostels/hstGalleryCss/hstView.css">
  <link rel="stylesheet" href="dist/css/font-awesome.css">
  <link rel="stylesheet" href="dist/css/bootstrap.css">
</head>
<body>   



<div id="main">
		<!--Header-->
		<jsp:include page="../header.jsp"></jsp:include>
 		 <!-- 컨텐츠 -->
 		 <div class="container">
			<div id="content">
			<!-- 호스텔 이름 -->
			<div id="hstName">
				<h2>${sessionDto.hostelDto.hostelName}</h2>
			</div>
			<!-- 호스텔 주소 -->
			<div id="hostelAddr">
				${sessionDto.hostelDto.hostelAddr}
			</div>
			<br>
			<br>
			 <form action="rsvConfirm.html" method="post">
			 <!-- 객실예약 테이블 -->						       
						<table>
							<c:forEach items="${sessionDto.rsvDatesList}" var="rsvDates" varStatus="sta1">
								<tr>
								<th>${sessionDto.roomList[sta1.index].roomsName}</th>
								<c:forEach items="${rsvDates}" var="rsvDate" varStatus="sta2">
									<td>${rsvDate}&nbsp</td>
									<td>${sessionDto.rsvRatesList[sta1.index].get(sta2.index)}&nbsp</td>
								</c:forEach>
								</tr>
							</c:forEach>
						</table>
						total : ${sessionDto.totalRate}<br> 
<%-- 						<table>
							<c:forEach items="${sessionDto.rsvRatesList}" var="rsvRates" varStatus="sta1">
								<tr>
								<c:forEach items="${rsvRates}" var="rsvRate" varStatus="sta2">
									<td>${rsvRate}&nbsp</td>
								</c:forEach>
								</tr>
							</c:forEach>
						</table> --%>
						
				<input type="submit" value="예약확정">
			  </form> 
  		</div> 
  	</div>
  </div>
</body>
</html>