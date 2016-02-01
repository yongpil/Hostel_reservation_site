<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="com.NeoRomax.HostelTonight.Dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
/* =================================================================
 * 
 * �ۼ��� : 2015. 11. 20.
 *  
 * �ۼ��� : ������
 * 
 * �󼼼��� : ������ ���� �� ������ �����ִ� ������
 *   
 */ 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0"/>
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
 		 <!-- ������ -->
 		 <div class="container">
			<div id="content">
			<!-- ȣ���� �̸� -->
			<div id="hstName">
				<h2>${sessionDto.hostelDto.hostelName}</h2>
			</div>
			<!-- ȣ���� �ּ� -->
			<div id="hostelAddr">
				${sessionDto.hostelDto.hostelAddr}
			</div>
			<br>
			<br>
			 <form action="rsvConfirm.html" method="post">
			 <!-- ���ǿ��� ���̺� -->						       
						<table class="table table-bordered">
							<c:forEach items="${sessionDto.rsvDatesList}" var="rsvDates" varStatus="sta1">
								<tr>
								<th>${sessionDto.roomList[sta1.index].roomsName}</th>
								<c:forEach items="${rsvDates}" var="rsvDate" varStatus="sta2">
									<td>${rsvDate} ${sessionDto.rsvRatesList[sta1.index].get(sta2.index)}</td>
								</c:forEach>
								</tr>
							</c:forEach>
						</table>
						total : ${sessionDto.totalRate}<br> 

						
				<input type="submit" value="����Ȯ��">
			  </form> 
  		</div> 
  	</div>
  </div>
</body>
</html>