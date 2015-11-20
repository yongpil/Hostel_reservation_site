<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="com.NeoRomax.HostelTonight.HostelList.Dto.*"%>
<%@ page import="com.NeoRomax.HostelTonight.Rsv.Dto.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	HostelListHostelDto hostel = (HostelListHostelDto) request.getAttribute("hDto");
	RsvCheckDto rsvConfirmBean;
	List roomsList = (List) request.getAttribute("roomsDtos");
	List rsvsList = (List) request.getAttribute("RsvCheckDto"); //예약관련 객실 정보 리스트
	String realFolder = "";
	realFolder = "./HostelsUpload/";
	int hostelNum = hostel.getHOSTELS_NUM();
%>

<html>
<head>


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

<body>

	<div id="main">
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
							<h2><%=hostel.getHOSTELS_NAME()%></h2>
						</div>
						
						<!-- 호스텔 정보 -->
						<div id="hostelInfo" class="container">
						<div  class="infoList" data-toggle="collapse" data-target="#hstexp">호스텔 설명  <i class="fa fa-h-square"></i></div>
						  <div id="hstexp" class="collapse"><br>
						    <p><%=hostel.getHOSTELS_INFO()%></p>
						    </div> 
						    
						    
						    <!-- 객실 정보 -->
						  <div class="infoList" data-toggle="collapse" data-target="#demo1">객실 정보  <i class="fa fa-bed"></i></div>
						  	<div id="demo1" class="collapse">	
						  	
						  	<form action="rsvView" method="post">
							 	    
						    <div class="panel-group" id="accordion">
						     <%
						     	String Room[] = {"Room1" ,"Room2" ,"Room3" ,"Room4" ,"Room5"};
						     	String TotalLabelIds[] = { "TotalLabel1", "TotalLabel2", "TotalLabel3", "TotalLabel4", "TotalLabel5"};
						     	String TotalFunctions[] = { "TotalFunction1", "TotalFunction2", "TotalFunction3" , "TotalFunction4", "TotalFunction5"};
						     	String Price[] = {"Price1", "Price2", "Price3" , "Price4" , "Price5"};
						     	String Toggle[] = {"Toggle1","Toggle2","Toggle3","Toggle4","Toggle5"};	
						     	String checkBoxId[][]= new String[5][12];
							    String RoomName[]=new String[5];
							    
							       for(int x=0; x<5; x++)
							       {
							    	   for(int y=0; y<12; y++)
							    	   {
							    		  checkBoxId[x][y]= "checkBox"+String.valueOf(x*12+y+1);
							    	   }
							       }
						     							     	
						     	for(int i=0;i<roomsList.size();i++)
							    {
						     		HostelListRoomsDto roombean = (HostelListRoomsDto)roomsList.get(i); 
							    	RoomName[i]= roombean.getROOMS_NAME();
						     %>						    
						     <!-- 객실 패널 -->
						    <div class="panel panel-default">
						      <div class="panel-heading">
						        <h4 class="panel-title">
						        
						          <a data-toggle="collapse" data-parent="#accordion" href="#<%=Room[i] %>"><%=RoomName[i]%></a>
						        </h4>
						      </div>
						      <div id="<%=Room[i] %>" class="panel-collapse collapse">
						        <div class="panel-body"><%=roombean.getROOMS_INFO() %><br><br>
						        
						        <!-- 객실예약 테이블 -->						       
						        <table class="table table-bordered table-striped">
						       
						       <%   
						       ArrayList<String> rsvDateList = new ArrayList<String>(); //날짜 리스트
						       ArrayList<String> rsvRateList = new ArrayList<String>(); // 날짜와 객실에 따른 비용 리스트
						       
						        	   for(int j=0;j<rsvsList.size();j++) //예약관련 객실 정보 리스트 돌면서
						        	   {
						        		   if(((RsvCheckDto)rsvsList.get(j)).getRSVROOM()==i)//객실별로 예약 가능한 날짜를 분류 한다.
						        		   { 						        											        			
						        			   rsvDateList.add(((RsvCheckDto)rsvsList.get(j)).getRSVDATE().toString().substring(0, 10));		
						        			   rsvRateList.add(String.valueOf(((RsvCheckDto)rsvsList.get(j)).getRATE()));
						        		   }
						        	   }
										System.out.println(rsvDateList.size());						        	   
						       		   
 						        	   int row=0;//예약 날짜를 3열로 된 테이블에 담는다.
						        	   if(rsvDateList.size()%3==0)
						        		   row = rsvDateList.size()/3;
						        	   else 
						        		   row = rsvDateList.size()/3+1;
						        	   
						        	   for(int k=0;k<row;k++)
						        	   {
						        %>		  
										<tr>
										<%
										if(k*3<rsvDateList.size())
										{
										%>							        
								        <td>
								        <label class="rsvDate"><input type="checkbox" name=<%=checkBoxId[i][k*3] %> id=<%=checkBoxId[i][k*3] %> value="<%=rsvRateList.get(k*3)%>,<%=rsvDateList.get(k*3)%>" onclick=<%=TotalFunctions[i]%>(<%=rsvRateList.get(k*3)%>,"<%=checkBoxId[i][k*3] %>")><%=rsvDateList.get(k*3)%><br><%=rsvRateList.get(k*3)%></label>
								        </td>
								        <%
										}
								    
										if(k*3+1<rsvDateList.size())
										{
										%>							        
								        <td>
								        <label class="rsvDate"><input type="checkbox" name=<%=checkBoxId[i][k*3+1] %> id=<%=checkBoxId[i][k*3+1] %> value="<%=rsvRateList.get(k*3+1)%>,<%=rsvDateList.get(k*3+1)%>" onclick=<%=TotalFunctions[i]%>(<%=rsvRateList.get(k*3+1)%>,"<%=checkBoxId[i][k*3+1]%>")><%=rsvDateList.get(k*3+1)%><br><%=rsvRateList.get(k*3+1)%></label>
								        </td>
								        <%
										}								     
								        if(k*3+2<rsvDateList.size())
										{
										%>							        
								        <td>
								        <label class="rsvDate"><input type="checkbox" name=<%=checkBoxId[i][k*3+2] %> id=<%=checkBoxId[i][k*3+2] %> value="<%=rsvRateList.get(k*3+2)%>,<%=rsvDateList.get(k*3+2)%>" onclick=<%=TotalFunctions[i]%>(<%=rsvRateList.get(k*3+2)%>,"<%=checkBoxId[i][k*3+2]%>")><%=rsvDateList.get(k*3+2)%><br><%=rsvRateList.get(k*3+2)%></label>
								        </td>
								        <%
										}
								        %>								    
								      </tr>	
								      <%
								      }
						        	  %>		
								  </table>						 							
									</div>       
						        </div>
						      </div>
						      <%
							    }
						      %>
						    </div>
						    <%
						    String userId = (String)session.getAttribute("id");
						    %>
						    <script>
						   <%
						   for(int i=0;i<5;i++)
						   {
						    %>
							   var <%=Price[i]%>=0;  
							   var total=0;
							  function <%=TotalFunctions[i]%>(temp_price,checkBoxId){
								  var x = document.getElementById(checkBoxId);
								   if(x.checked==true)
									  	 <%=Price[i]%> = <%=Price[i]%> + parseInt(temp_price);
								   else 
									    <%=Price[i]%> = <%=Price[i]%> - parseInt(temp_price);      
								    
								   document.getElementById("<%=TotalLabelIds[i]%>").innerHTML = <%=Price[i]%>;
								   TotalCal(<%=Price[0]%>,<%=Price[1]%>,<%=Price[2]%>,<%=Price[3]%>,<%=Price[4]%>);
							 	 }
							  <%
							  }	
							  %>

						    function TotalCal(price0,price1,price2,price3,price4){
						    	document.getElementById("Total").innerHTML = price0+price1+price2+price3+price4;
						    }
						    
						   
						    </script>
						    
						    	<div id="roomPrice1">
						    	<%=RoomName[0]%>:<label id="<%=TotalLabelIds[0]%>">0</label>
						    	</div>
						    	<div id="roomPrice2">						    		 
						    	<%=RoomName[1]%>:<label id="<%=TotalLabelIds[1]%>">0</label>
						    	</div>
						    	<div id="roomPrice3">	 
						    	<%=RoomName[2]%>:<label id="<%=TotalLabelIds[2]%>">0</label>
						    	</div>
						    	<div id="roomPrice4">	 
						    	<%=RoomName[3]%>:<label id="<%=TotalLabelIds[3]%>">0</label>
						    	</div>
						    	<div id="roomPrice5">	 
						    	<%=RoomName[4]%>:<label id="<%=TotalLabelIds[4]%>">0</label>
						    	</div>	 
						    	  총 합계:<label id="Total">0</label>	  
						     
						      <input type="hidden" name="hostelNum" value=<%=hostel.getHOSTELS_NUM()%>>
						      <input type="hidden" name="userId" value=<%=userId %>>
							  <input type="submit" value="예약">				
							  </form>							  
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
						<div> <a href="../HostelProject/hostelsReviewListAction.re?num=<%=hostel.getHOSTELS_NUM()%>">이용 후기</a> <i class="fa fa-pencil"></i></div>
						  <div id="review" class="collapse"><br>	  
						    </div> 
						  </div>					 
						</div>
						
			<!-- 게시판 수정 -->
			<a href="../HostelProject/hostelsModify.me?num=<%=hostel.getHOSTELS_NUM()%>">호스텔 수정</a>
		</div>
		
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