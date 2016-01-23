<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%
List schLocationDtos = (List) request.getAttribute("schLocationDtos");
List<String> schLocationList = new ArrayList<String>();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/Chart.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/hostels/hstAdmin.css">
<title>Insert title here</title>
</head>
	<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0"/>
<body>
 	<div id="main">
		<!--Header-->
		<jsp:include page="../header.jsp"></jsp:include>
			<!-- 컨텐츠 -->
			<div id="content">
		 	<h2>사용자 검색 순위</h2>
		        <div>
		            <canvas id="searchRank"></canvas>
		     	</div>		   
			 	<h2>지역별 성수기</h2>        
				<button id="serchBtn" type="button">Search</button>
			</div>
	</div>
<script>
var labelsArray = new Array();
<c:forEach items="${schLocationDtos}" var="schLct" varStatus="status">
index = parseInt("${status.index}");
labelsArray[index] = "${schLct.location}";
</c:forEach>

var dataArray = new Array();
<c:forEach items="${schLocationDtos}" var="schCnt" varStatus="status">
index = parseInt("${status.index}");
dataArray[index] = "${schCnt.searchCnt}";
</c:forEach>


var barData = {
	    labels: labelsArray,
	    datasets: [
	        {
	            label: '2010 customers #',
	            fillColor: '#4a8af4',
	            data: dataArray
	        }
	    ]
	};
 
var context = document.getElementById('searchRank').getContext('2d');
var clientsChart = new Chart(context).Bar(barData);


/* $('#serchBtn').click( function(){
	$.ajax({
			url:'',
			dataType:'json',
			type:'POST',
			data:'msg':$('#msg').val()},
			success:function(result)
			}
			)
}); */


</script>
</body>
</html>