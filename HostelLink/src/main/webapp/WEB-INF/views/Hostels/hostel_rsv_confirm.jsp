<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0"/>
<title>Insert title here</title>
</head>
<body>
<div id="main">
		<!--Header-->
		<jsp:include page="../header.jsp"></jsp:include>
		
		<h2>예약해 주셔서 감사 합니다.</h2>

호스텔 : ${hDto.hostelName}<br>
주소 : ${hDto.hostelAddr}<br>
연락처 : ${hDto.hostelPhone}<br>
이메일 : ${hDto.hostelEmail}<br>
예약 아이디 : ${RsvList.userId}<br>
총 비용 : ${RsvList.totalRate}<br>
</div>
</body>
</html>