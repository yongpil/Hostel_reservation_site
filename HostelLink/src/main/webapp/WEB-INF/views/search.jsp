<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script>
$(function(){
	$( "#autoComplete" ).autocomplete({
		source : function( request, response ) {
	        $.ajax({
	        	type:"get",
	            url: "autoComplete.html",
	            dataType: "json",
	            data: {
	              //request.term = Text Box inut Value
	              searchValue: request.term
	            },
	            success: function( result ) {
	            	alert("OK");
	                response( 
	                	$.map( result, function( item ) {
	                			return {
	                				//label : 화면에 보여지는 텍스트
	                				//value : 실제 text태그에 들어갈 값
	                  				label: item.data,
	                  				value: item.data
	                			}
	              		})
	              	);
	            },
	            error: function(){
	            	alert("Error");
	            }
	          });
	    },
	    //통신 가능 최소 글자 수
		minLength: 2,
		//자동완성 목록에서 특정 값 선택시 처리하는 동작 구현
		select: function( event, ui ) {}
	});
})
</script>
<div class="search">
	<input type="text" name="search" id="autoComplete" />
	<h1 id="text"></h1>
</div>