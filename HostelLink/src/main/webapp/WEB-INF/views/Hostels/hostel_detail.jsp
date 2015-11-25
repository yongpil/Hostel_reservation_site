<%
/* =================================================================
 * 
 * �ۼ��� : 2015. 11. 20.
 *  
 * �ۼ��� : ������
 * 
 * �󼼼��� : ȣ������ Ŭ���ϸ� ȣ������ ���� �� ���� ������ �� �� �ְ� ���ִ� �������̴�.ȣ���� Ŭ���� �̷������ backend���� ȣ���� ������ �� ����,�˻��� ��¥�� ���� ����Ʈ�� �Ѱ� �ش�.
 * frontend �ʿ��� backend���� ���� ������ �����Ͽ� ����ڿ��� �����ش�.
 *   
 * =================================================================
 * ������         �ۼ���             ����     
 * -----------------------------------------------------------------------
 * 
 * =================================================================
 */ 
%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="com.NeoRomax.HostelTonight.HostelList.Dto.*"%>
<%@ page import="com.NeoRomax.HostelTonight.Rsv.Dto.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	HostelListHostelDto hostel = (HostelListHostelDto) request.getAttribute("hDto");
	RsvCheckDto rsvConfirmBean;
	List roomsList = (List) request.getAttribute("roomsDtos");
	List rsvsList = (List) request.getAttribute("RsvCheckDto"); //������� ���� ���� ����Ʈ
	String realFolder = "";
	realFolder = "./HostelsUpload/";
	int hostelNum = hostel.getHOSTELS_NUM();
%>

<html data-ng-app="myApp" data-ng-controller="checkBoxCtrl">
<head>

  <script src= "https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="dist/js/bootstrap.js"></script>
  <link rel="stylesheet" href="css/hostels/hstView.css">
  <link rel="stylesheet" href="dist/css/font-awesome.css">
  <link rel="stylesheet" href="dist/css/bootstrap.css">
   <script>
   var app = angular.module('myApp',[]);
   app.controller('checkBoxCtrl',function($scope){
		$scope.row = 10;
	});
   </script>
   
	
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 100%;
      margin: auto;
  }
  </style>
    
</head>

<body ng-init="appName = 'abc' ">

	<!-- ȣ���� ���� ��� -->
	<h1>{{appName}} </h1>
	<div id="main">
		<!--Header-->
		<jsp:include page="../header.jsp"></jsp:include>
			<!-- ������ -->
			<div id="content">
				<!-- ȣ����  ��� -->
				<div class="container">
				 	 <div id="hostelsPics" class="carousel slide" data-ride="carousel">
				    <!-- Wrapper for slides -->
				    <div class="carousel-inner" role="listbox">
					 		<c:forEach items="${hImgDtos}" var="hImg"  varStatus="hImgIndex">
					 			<c:choose>
								    <c:when test="${hImgIndex.index==0}">
								        <div class="item active">
					 						<img src="<%=realFolder%>${hImg.IMAGENAME}">
					 					</div>
								    </c:when>    
								    <c:otherwise>
								       <div class="item">
											<img src="<%=realFolder%>${hImg.IMAGENAME}">
									   </div>
								    </c:otherwise>
								</c:choose>
					 		</c:forEach>
				    </div>
				    
					{{row}}
				    <!-- Left and right controls -->
				    <a class="left carousel-control" href="#hostelsPics" role="button" data-slide="prev">
				      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				      <span class="sr-only">Previous</span>
				    </a>
				    <a class="right carousel-control" href="#hostelsPics" role="button" data-slide="next">
				      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				      <span class="sr-only">Next</span>
				    </a>
				  </div>
				</div>

						<!-- ȣ���� �̸� -->
						<div id="hstName">
							<h2><%=hostel.getHOSTELS_NAME()%></h2>
						</div>
						
						<!-- ȣ���� ���� -->
						<div id="hostelInfoList" class="container">
							<div  class="infoList" data-toggle="collapse" data-target="#hostelInfoView">ȣ���� ����  <i class="fa fa-h-square"></i></div>
								<div id="hostelInfoView" class="collapse"><br><p><%=hostel.getHOSTELS_INFO()%></p></div>		
						
		
						<!-- ���� ���� -->
						 	<div class="infoList" data-toggle="collapse" data-target="#roomInfoView">���� ����  <i class="fa fa-bed"></i></div>
						  		<div id="roomInfoView" class="collapse">
						  		 <div class="panel-group" id="accordion">
						  		<form action="rsvView.html" method="post">
						  			 <div class="panel-group" id="accordion">
						  			 	<c:forEach items="${roomsDtos}" var="roomDto" varStatus="roomIndex">
						  					<div class="panel panel-default">
							      				<div class="panel-heading">
								        			<h4 class="panel-title">
								        			 <a data-toggle="collapse" data-parent="#accordion" href="#Room${roomIndex.index}">${roomDto.ROOMS_NAME}</a>
								        			</h4>
							      				</div>
							      				<div id="Room${roomIndex.index}" class="panel-collapse collapse">
							      				 <div class="panel-body">${roomDto.ROOMS_INFO}<br><br>
							      				 	<!-- ���ǿ��� ���̺� -->						       
						        					<table class="table table-bordered table-striped" >						   
						        					</table>
							      				 </div>
							      				</div>
						      				</div>
						    			 </c:forEach>
						    			 </div>
						  			</form>
						  			</div>
						  			</div>		
						  		 </div> 
						 		</div> 
						 </div>
			<!-- �Խ��� ���� -->
			<a href="../HostelProject/hostelsModify.me?num=<%=hostel.getHOSTELS_NUM()%>">ȣ���� ����</a>
		<script>
		$('#roomPrice1').hide();
		$('#roomPrice2').hide();
		$('#roomPrice3').hide();
		$('#roomPrice4').hide();
		$('#roomPrice5').hide();
		</script>
		<!--Footer-->
						<%-- <jsp:include page="../Main/footer.jsp" /> --%>
		
</body>
</html> 