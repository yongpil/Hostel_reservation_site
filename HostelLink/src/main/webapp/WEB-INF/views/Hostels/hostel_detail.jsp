<%
/* =================================================================
 * 
 * 작성일 : 2015. 11. 20.
 *  
 * 작성자 : 문용필
 * 
 * 상세설명 : 호스텔을 클릭하면 호스텔의 정보 및 객실 정보를 볼 수 있게 해주는 페이지이다.호스텔 클릭이 이루어지면 backend에서 호스텔 정보와 방 정보,검색한 날짜의 개실 리스트를 넘겨 준다.
 * frontend 쪽에서 backend에서 받은 정보를 가공하여 사용자에게 보여준다.
 *   
 * =================================================================
 * 수정일         작성자             내용     
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
	<!-- 호스텔 사진 배너 -->
	<div id="main">
		<!--Header-->
		<jsp:include page="../header.jsp"></jsp:include>
			<!-- 컨텐츠 -->
			<div id="content">
				<!-- 호스텔  배너 -->
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

						<!-- 호스텔 이름 -->
						<div id="hstName">
							<h2>${hDto.hostelName}</h2>
						</div>
						
						<!-- 호스텔 정보 -->
						<div id="hostelInfoList" class="container">
							<div  class="infoList" data-toggle="collapse" data-target="#hostelInfoView">호스텔 설명  <i class="fa fa-h-square"></i></div>
								<div id="hostelInfoView" class="collapse"><br><p>${hDto.hostelInfo}</p></div>		
						
		
						<!-- 객실 정보 -->
						 	<div class="infoList" data-toggle="collapse" data-target="#roomInfoView">객실 정보  <i class="fa fa-bed"></i></div>
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
							      				 	<!-- 객실예약 테이블 -->	
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
						    		 <input type="submit" value="예약">	
						  			</form>
						  			</div>
						  			</div>
						  			
					 <!-- 지도 및 약도 -->
						<div class="infoList" data-toggle="collapse" data-target="#map">지도 및 약도  <i class="fa fa-map"></i></div>
						  <div id="map" class="collapse"><br>
						    </div> 						
						    
					 <!-- 시설 -->
						<div class="infoList" data-toggle="collapse" data-target="#facility">시설</div>
						  <div id="facility" class="collapse"><br>
						    </div> 
						    
					 <!-- 이용후기 -->
						<div> <a href="../HostelProject/hostelsReviewListAction.re?num=${hDto.hostelNum}">이용 후기</a> <i class="fa fa-pencil"></i></div>
						  <div id="review" class="collapse"><br>	  
						    </div> 	
					 </div> 
					</div> 
				 </div>
			<!-- 게시판 수정 -->
			<c:forEach items="${rsvRoomListDtos}" var="roomRate" varStatus="rrIndex">
				<label>${roomRate.roomsName}</label> <label id="rate${rrIndex.index}"></label> <br>
			</c:forEach>
			<a href="../HostelProject/hostelsModify.me?num=${hDto.hostelNum}">호스텔 수정</a>
			
			<br> 총 합계:<label id="TotalRate">0</label>	  
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