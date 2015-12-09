<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/Chart.js"></script>
<title>Insert title here</title>
</head>
<body>
 
 	<h2>Admin Page</h2>
    <div style="width:30%">
        <div>
            <canvas id="clients" width="500" height="400"></canvas>
        </div>
    </div>
<script>

var barData = {
	    labels: ['Italy', 'UK', 'USA', 'Germany', 'France', 'Japan'],
	    datasets: [
	        {
	            label: '2010 customers #',
	            fillColor: '#382765',
	            data: [2500, 1902, 1041, 610, 1245, 952]
	        },
	        {
	            label: '2014 customers #',
	            fillColor: '#7BC225',
	            data: [3104, 1689, 1318, 589, 1199, 1436]
	        }
	    ]
	};
 
var context = document.getElementById('clients').getContext('2d');
var clientsChart = new Chart(context).Bar(barData);

</script>
</body>
</html>