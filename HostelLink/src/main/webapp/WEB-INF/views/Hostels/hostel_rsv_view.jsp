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

<c:forEach items="${rsvDatesList}" var="rsvDates" varStatus="sta">
		${roomList[sta.index].roomsName}
	<c:forEach items="${rsvDates}" var="rsvDate">
		${rsvDate}
	</c:forEach>	
	<br>	
</c:forEach>

 


<div id="main">
		<!--Header-->
		<jsp:include page="../header.jsp"></jsp:include>
 		 <!-- 컨텐츠 -->
			<div id="content">
			<!-- 호스텔 이름 -->
			<div id="hstName">
				<h2>${hostelDto.hostelName}</h2>
			</div>
			<!-- 호스텔 주소 -->
			<div id="hostelAddr">
				${hostelDto.hostelName}
			</div>
			<div class="container">
			
<%-- <form action="rsvConfirm.html" method="post">


 <input type="hidden" name=<%=rsvRoomNum[i]%> value=<%=rsvbean.getROOMNUM()%>>
 <input type="hidden" name=<%=rsvConfirmDataName[i][1]%> value=<%=rsvbean.getRESERVATIONDAYS()%>>
 <input type="hidden" name=<%=rsvRate[i]%> value=<%=rsvbean.getTOTALRATE() %>>  

		

 <!-- 객실예약 테이블 -->						       
 <table class="table table-bordered table-striped">
 <tr>
 <td><%=roombean.getROOMS_NAME() %></td>
 </tr>

 <%for(int j=0;j<dayCount;j++){%>
 <tr>
 <td>
 <%=dayList[j] %>
</td>
</tr>
<%} %>
<tr>
 <td>
 <%=totalRate %>
</td>
</tr>
 </table>	
 <%
 	}
 %>

<input type="hidden" name="listSize" value=<%=rsvConfirmList.size()%>>
<input type="hidden" name="hstNum" value=<%=hostelsNum%>>
<input type="hidden" name="userId" value=<%=userId%>>
<input type="submit" value="예약확정">
     
  예약확정</form> --%>
  </div> 
  </div>
  </div>
</body>
</html>