<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page session="false" %>
<%
	String realFolder="";
	realFolder="./HostelsUpload/";
	String dayfrom = ((String)request.getAttribute("dayfrom"));
	String dayto = ((String)request.getAttribute("dayto"));
	System.out.println(dayfrom);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" href="css/hostels/hstList.css">
<title>Insert title here</title>
</head>
<body>
	<div id="main">
		<!--Header-->
		<jsp:include page="../header.jsp"></jsp:include>
			<!-- 컨텐츠 -->
			<div id="content">
				<!--검색내용란  -->
				<div id=searchContent1>
<%-- 				<%=dayfrom %>~<%=dayto %> --%>
				</div>
				<div id=searchContent2>
				검색결과2
				</div>
				<!-- 버튼 -->
				<div id="buttonGroup">
				<a id="filterBtn" class="myButton">필터</a>
				<a id="DetailSearchBtn" class="myButton">상세검색</a>
				<a class="myButton">지도</a>
				</div>

				<div id="filter">안녕하세요</div> 
				<div id="DetailSearch">반갑습니다</div> 
				<!-- 이미지 게시판 -->
 			
				<div id="hostelsGallery">
				<c:forEach items="${hDtos}" var="hDto">
					<li>
						<%-- <a href="./hostelsDetailAction.me?num=${dto.HostelCode}&dayfrom=<%=dayfrom%>&dayto=<%=dayto%>"> --%>
					    <a href="./hostel_detail.html?num=${hDto.HOSTELS_NUM}&dayfrom=<%=dayfrom%>&dayto=<%=dayto%>"> 
						 <div  id="HostelsPic" style="background:url(<%=realFolder%>${hDto.IMAGENAME}) no-repeat; background-size:100%">
						<div id=price>13,000 Won</div>
						</div> 
						<div id="HostelsName">${hDto.HOSTELS_NAME}</div>
						<span class="text">
						  <%-- <span class="title"><%=hos.getHostelsName()%></span> --%>
						</span>	
						</a>
					</li>
					<!--Footer-->
						<%-- <jsp:include page="../Main/footer.jsp" /> --%>
				</c:forEach> 
				</div>
			</div>
			<a href="addHostel_view">호스텔 추가</a>
		</div>	
		
<script>
 $('#filter').hide();
  $('#filterBtn').click(function(){
	   if($("#DetailSearch").css("display")=="block") 
	  $("#DetailSearch").slideUp("fast");
	  $("#filter").slideToggle("fast"); 
 }); 
  
 $('#DetailSearch').hide();
  $('#DetailSearchBtn').click(function(){
	  if($("#filter").css("display")=="block") 
	$("#filter").slideUp("fast");
	 $("#DetailSearch").slideToggle("fast");
 }); 
  

 var today = new Date();
 var year = today.getFullYear();
 var month = today.getMonth()+1;
 var today = today.getDate();
 var tomorrow = today + 1;
 
 if(<%=dayfrom%>==year-month-today && <%=dayto%>==year-month-today )
		{
			$('#searchContent1').hide();
			$('#searchContent2').show();
		}
		else if(<%=dayfrom%>==year-month-tomorrow || <%=dayto%>==year-month-tomorrow)
			{
				$('#searchContent1').hide();
				$('#searchContent2').show();
			}
		else
			{
				$('#searchContent1').show();
				$('#searchContent2').hide();
			} 
</script>
</body>
</html>