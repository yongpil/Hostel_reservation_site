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


<%
	String realFolder = "";
	realFolder = "./HostelsUpload/";
%>

<html>
<head>

  <script src= "https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="dist/js/bootstrap.js"></script>
  <link rel="stylesheet" href="css/hostels/hstView.css">
  <link rel="stylesheet" href="dist/css/font-awesome.css">
  <link rel="stylesheet" href="dist/css/bootstrap.css">
   
	
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 100%;
      margin: auto;
  }
  </style>

</head>

 <body data-ng-app="" >	
	<!-- ȣ���� ���� ��� -->
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
					 						<img src="<%=realFolder%>${hImg.imageName}">
					 					</div>
								    </c:when>    
								    <c:otherwise>
								       <div class="item">
											<img src="<%=realFolder%>${hImg.imageName}">
									   </div>
								    </c:otherwise>
								</c:choose>
					 		</c:forEach>
				    </div>
			    
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
							<h2>${hDto.hostelName}</h2>
						</div>
						
						<!-- ȣ���� ���� -->
						<div id="hostelInfoList" class="container">
							<div  class="infoList" data-toggle="collapse" data-target="#hostelInfoView">ȣ���� ����  <i class="fa fa-h-square"></i></div>
								<div id="hostelInfoView" class="collapse"><br><p>${hDto.hostelInfo}</p></div>		
						
		
						<!-- ���� ���� -->
						 	<div class="infoList" data-toggle="collapse" data-target="#roomInfoView">���� ����  <i class="fa fa-bed"></i></div>
						  		<div id="roomInfoView" class="collapse">
						  		 <div class="panel-group" id="accordion">
						  		<form action="rsvView.html" method="post">
						  			 <div class="panel-group" id="accordion">
						  			 		<c:forEach items="${rsvRoomListDtos}" var="rsvRoom" varStatus="roomIndex">
						  					<div class="panel panel-default">
							      				<div class="panel-heading">
								        			<h4 class="panel-title">
								        			 <a data-toggle="collapse" data-parent="#accordion" href="#Room${roomIndex.index}">${rsvRoom.roomsName}</a>
								        			</h4>
							      				</div>
							      				<div id="Room${roomIndex.index}" class="panel-collapse collapse">
							      				 <div class="panel-body">${rsvRoom.roomsInfo}<br><br>
							      				 	<!-- ���ǿ��� ���̺� -->	
							      				 		<table class="table table-bordered table-striped" >		
														 	<c:forEach items="${rsvRoom.tRsvAvailableDtos}" var="RsvAvailDto" varStatus="RsvADIndex" step="3">
														 		<tr>
														 		 <td data-ng-show="${rsvRoom.tRsvAvailableDtos[RsvADIndex.index]}">
														 		 <label class="rsvDate"><input type="checkbox" name="check${roomIndex.index}-${RsvADIndex.index}"
														 		  value="${rsvRoom.tRsvAvailableDtos[RsvADIndex.index].rsvDate},${rsvRoom.tRsvAvailableDtos[RsvADIndex.index].rsvRate}"
														 		  id = "check${roomIndex.index}-${RsvADIndex.index}"
														 		  onclick="priceCal(${RsvADIndex.index},${rsvRoom.tRsvAvailableDtos[RsvADIndex.index].rsvRate},${rsvRoom.roomsNum})"/>
														 		  ${rsvRoom.tRsvAvailableDtos[RsvADIndex.index].rsvDate},${rsvRoom.tRsvAvailableDtos[RsvADIndex.index].rsvRate}
														 		 </label>													 		 
								        						 </td>
																 <td data-ng-show="${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+1]}">
																 <label class="rsvDate"><input type="checkbox" name="check${roomIndex.index}-${RsvADIndex.index+1}"
														 		  value="${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+1].rsvDate},${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+1].rsvRate}"
														 		  id = "check${roomIndex.index}-${RsvADIndex.index+1}"
														 		  onclick="priceCal(${RsvADIndex.index+1},${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+1].rsvRate},${rsvRoom.roomsNum})"/>	  
														 		  ${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+1].rsvDate},${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+1].rsvRate}
														 		 </label> 
																 </td>
																 <td data-ng-show="${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+2]}">
																 <label class="rsvDate"><input type="checkbox" name="check${roomIndex.index}-${RsvADIndex.index+2}"
														 		  value="${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+2].rsvDate},${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+2].rsvRate}"
														 		  id = "check${roomIndex.index}-${RsvADIndex.index+2}"
														 		  onclick="priceCal(${RsvADIndex.index+2},${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+2].rsvRate},${rsvRoom.roomsNum})"/>
														 		  ${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+2].rsvDate},${rsvRoom.tRsvAvailableDtos[RsvADIndex.index+2].rsvRate}
														 		 </label> 
																 </td>
																</tr>
															</c:forEach>		
														</table>		       
							      				 </div>
							      				</div>
						      				</div>
						    			 </c:forEach>
						    			 </div>
						    		 <input type="hidden" name="hostelNum" value="${hDto.hostelNum}">	 
						    		 <input type="submit" value="����">	
						  			</form>
						  			</div>
						  			</div>
						  			
					 <!-- ���� �� �൵ -->
						<div class="infoList" data-toggle="collapse" data-target="#map">���� �� �൵  <i class="fa fa-map"></i></div>
						  <div id="map" class="collapse"><br>
						    </div> 						
						    
					 <!-- �ü� -->
						<div class="infoList" data-toggle="collapse" data-target="#facility">�ü�</div>
						  <div id="facility" class="collapse"><br>
						    </div> 
						    
					 <!-- �̿��ı� -->
						<div> <a href="../HostelProject/hostelsReviewListAction.re?num=${hDto.hostelNum}">�̿� �ı�</a> <i class="fa fa-pencil"></i></div>
						  <div id="review" class="collapse"><br>	  
						    </div> 	
					 </div> 
					</div> 
				 </div>
			<!-- �Խ��� ���� -->
			<c:forEach items="${rsvRoomListDtos}" var="roomRate" varStatus="rrIndex">
				<label>${roomRate.roomsName}</label> <label id="rate${rrIndex.index}"></label> <br>
			</c:forEach>
			<a href="../HostelProject/hostelsModify.me?num=${hDto.hostelNum}">ȣ���� ����</a>
			
			<br> �� �հ�:<label id="TotalRate">0</label>	  
			${hDto.hostelNum}
		<script>
		var rateArry = new Array(${roomsDtos.size()});
		
		for(var i=0;i<rateArry.length;i++)
		{
			rateArry[i]=0;
		}
		
		var priceCal = function (checkId,roomsRate,roomsNum){
			checkBoxId = "check"+roomsNum+"-"+checkId;
			rateId = "rate"+roomsNum;
			var x = document.getElementById(checkBoxId);
			var total = 0;
			if(x.checked==true)
			{
				rateArry[roomsNum]= rateArry[roomsNum] + roomsRate;
				console.log(rateArry[roomsNum]);
			}
			else if(x.checked==false)
			{
				rateArry[roomsNum]= rateArry[roomsNum] - roomsRate;	
				console.log(rateArry[roomsNum]);
			}
			document.getElementById(rateId).innerHTML = rateArry[roomsNum];
			
			for(var i=0;i<rateArry.length;i++)
			{
				total = total + rateArry[i];
			}
			
			document.getElementById("TotalRate").innerHTML = total;
		}
		
		</script>
		<!--Footer-->
		<%-- 				<jsp:include page="../Main/footer.jsp" />  --%>
		
</body>
</html> 