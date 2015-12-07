<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="css/Template/Search_Styles.css">

<script>
$(function() {
    $( "#from" ).datepicker({
    	dateFormat: "yy-mm-dd",
    	defaultDate: "+1w",
    	changeMonth: true,
    	onClose: function( selectedDate ) {
            $( "#to" ).datepicker( "option", "minDate", selectedDate );
          }
    });
    $( "#to" ).datepicker({
    	dateFormat: "yy-mm-dd",
        defaultDate: "+1w",
        changeMonth: true,
        onClose: function( selectedDate ) {
          $( "#from" ).datepicker( "option", "maxDate", selectedDate );
        }
      });
  });
  
 var dayDefaultFunction = function(){
	 var dayFrom = document.getElementById("from").value
	 
	 if(dayFrom=="")
		 document.getElementById("from").value="testDay";
	 

	 searchForm.submit();
 };
</script>

<div id='search'>
	<form name="searchForm" action ="index.html" method='post'>
		<div id='destination'>
			<p>Destination</p>
			<input type="search" name="lctSearch" 
			autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false">
		</div>
		<div id='check_In'>
			<p>Check In</p>
			<input type="text" name="dayFrom" id="from" >
		</div>
		<div id='check_Out'>
			<p>Check Out</p>
			<input type="text" name="dayTo" id="to">			
		</div>
		<div id='submit'>
        	<input type="button" value="Search" class="button" onclick="dayDefaultFunction()">		
    	</div>	
	</form>
</div>