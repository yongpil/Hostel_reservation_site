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
		
		<h2>������ �ּż� ���� �մϴ�.</h2>

ȣ���� : ${hDto.hostelName}<br>
�ּ� : ${hDto.hostelAddr}<br>
����ó : ${hDto.hostelPhone}<br>
�̸��� : ${hDto.hostelEmail}<br>
���� ���̵� : ${RsvList.userId}<br>
�� ��� : ${RsvList.totalRate}<br>
</div>
</body>
</html>