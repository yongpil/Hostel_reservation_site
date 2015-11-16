<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<script type="text/javascript">
	function blindID()
	{
		var ph = document.getElementById("placeholderID");
		ph.style.display="none";

	}
	function showID()
	{
		var obj = document.getElementById("uid");
		var ph = document.getElementById("placeholderID");
		if(obj.value=="")
		{
			ph.style.display="block";
		}
	}
	function blindPWD()
	{
		var ph = document.getElementById("placeholderPWD");
		ph.style.display="none";

	}
	function showPWD()
	{
		var obj = document.getElementById("upwd");
		var ph = document.getElementById("placeholderPWD");
		if(obj.value=="")
		{
			ph.style.display="block";
		}
	}
	function sendit()
	{
		var form = document.login_Form;
		var alertID=document.getElementById("alertID");
		var alertPWD=document.getElementById("alertPWD");
		
		if(form.id.value!="")
		{
			alertID.style.display="none";
		}
		if(form.pwd.value!="")
		{
			alertPWD.style.display="none";
		}
		
		if(form.id.value=="")
		{
			alertID.style.display="block";
			form.id.focus();
		}
		else if(form.pwd.value=="")
		{
			alertPWD.style.display="block";
			form.pwd.focus();
		}
		else
		{
			form.submit();
		}
	}
</script>
</head>
<body>
	<div id="main">
		<div id="login">
			<form name="login_Form" action="#" method=post>
				<div id="login_logo"> 
					<img src="../login/img/login_logo.png" border="0" alt="login">
				</div>
				<div id="id_area_form">
					<input type="text" name="id" id="uid" value="" onfocus="blindID()" onblur="showID()" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" maxlength="8">
					<span id="placeholderID" style="display:block;">ID</span>
					<p id="alertID" style="display:none;">Please enter your ID</p>
				</div>
				<div id="pwd_area_form">
					<input type="password" name="pwd" id="upwd" value="" onfocus="blindPWD()" onblur="showPWD()" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" maxlength="8">
					<span id="placeholderPWD" style="display:block;">PASSWORD</span>
					<p id="alertPWD" style="display:none;">Please enter your PASSWORD</p>
				</div>
				<input id="button" type="button" value="LOGIN" onclick="sendit()">
				<input id="country" type="hidden" value="korea">
				<input id="dayfrom" type="hidden" value="2015-09-10">
				<input id="dayto" type="hidden" value="2015-09-20">
			</form>
		</div>
	</div>

</body>
</html>
<%
	request.setCharacterEncoding("utf-8"); 
	String id = request.getParameter("id");            
	String pwd = request.getParameter("pwd");
	String resultID;
	String resultPWD;
	int count=0;
			
	if(id!=null)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hostel?useUnicode=true&characterEncoding=utf-8";
			Connection con = DriverManager.getConnection(url,"root","1234");
			Statement stat = con.createStatement();
			ResultSet rs = null;
			String query = "SELECT USERID, USERPSW FROM user_information";
			rs = stat.executeQuery(query);
			
			while(rs.next()) 
			{
				resultID=rs.getString("USERID");
				resultPWD=rs.getString("USERPSW");
				if(resultID.equals(id) && resultPWD.equals(pwd))
				{
					count=1;
				}
			}
			stat.close();
			con.close();
		}
		catch(Exception e)
		{
			out.println( e );
		}
		if(count==1)
		{
			session.setAttribute("id", request.getParameter("id"));
			session.setAttribute("pwd", request.getParameter("pwd"));
			response.sendRedirect("list");
		}
		else
		{
			%><p>로그인 실패</p><% 
		}
	}
%>
