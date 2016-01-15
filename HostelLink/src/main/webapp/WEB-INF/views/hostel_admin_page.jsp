<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%
List schLocationDtos = (List) request.getAttribute("schLocationDtos");
List<String> schLocationList = new ArrayList<String>();
for(int i=0;i<schLocationDtos.size();i++)
{
	schLocationList.add(schLocationDtos.get(i))
}
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

<body>
 	<div id="main">
		<!--Header-->
		<jsp:include page="header.jsp"></jsp:include>
			<!-- 컨텐츠 -->
			<div id="content">
		 	<h2>사용자 검색 순위</h2>
		        <div>
		            <canvas id="searchRank"></canvas>
		     	</div>
		    <div class="container">
			  <h2>지역별 성수기</h2>        
			  <table class="table table-bordered">
			    <thead>
			      <tr>
			        <th>지역</th>
			        <th>the most day</th>
			        <th>횟수</th>
			        <th>the most month</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>seoul</td>
			        <td>2015-08-10</td>
			        <td>111</td>
			         <td>August</td>
			      </tr>
			      <tr>
			        <td>london</td>
			        <td>2015-08-13</td>
			        <td>87</td>
			        <td>March</td>
			      </tr>
			      <tr>
			        <td>osaka</td>
			        <td>2015-08-10</td>
			        <td>65</td>
			        <td>August</td>
			      </tr>
			        <tr>
			        <td>paris</td>
			        <td>2015-08-10</td>
			        <td>50</td>
			         <td>July</td>
			      </tr>
			    </tbody>
			  </table>
			</div>
		     	
			</div>	
	</div>


<script>
var schLocation = new Array(${schLocationDtos.size()});

for(var i=0;i<schLocation.length;i++)
	{
		schLocation[i]='${schLocationDtos[0].location}';
	}

console.log(schLocation[0]);

var barData = {
	    labels: ['seoul', 'london', 'osaka', 'paris', 'barcelona', 'berlin', 'madrid', 'gwangju', 'prague', 'tokyo'],
	    datasets: [
	        {
	            label: '2010 customers #',
	            fillColor: '#4a8af4',
	            data: [100, 95, 90, 85, 80, 75, 70, 50, 45, 20]
	        }
	    ]
	};
 
var context = document.getElementById('searchRank').getContext('2d');
var clientsChart = new Chart(context).Bar(barData);

</script>
</body>
</html>