<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 
 * Member Join Form
 * @version 1.0
 * @author Yang Jin Seung 
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	$(function() {
	    $( "#birth" ).datepicker({
	    	dateFormat: "yy-mm-dd",
	    	changeMonth: true,
	    	changeYear: true,
	    	yearRange: "-100:+0",
	    	onClose: function() {
	    		
	          }
	    });
	  });
</script>
<!--Header-->
<jsp:include page="header.jsp"></jsp:include>

<br><h1>회원가입</h1><br>
	<form action="join.html" method="post">
		ID : <input type="text" name="id" id="id" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false"><br />
		Password : <input type="password" name="pwd" id="pwd" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false"><br />
		Confirm Password : <input type="password" name="confirmPwd" id="confirmPwd" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false"><br />
		FirstName : <input type="text" name="firstName" id="firstName" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false"><br />
		LastName : <input type="text" name="lastName" id="lastName" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false"><br />
		BirthDay : <input type="text" name="birth" id="birth" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" readonly="readonly"><br />
		<input type="submit" value="SIGNUP"> <br />
	</form>
</body>
</html>