<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<link rel="stylesheet" href="imgboard/imgBoardCss/imgBoardStyle.css">
<link rel="stylesheet" href="commonBoardStyle/commonBoardStyle.css">
<link rel="stylesheet" href="./jgsc_v4/css/template.css">

<title>호스텔 추가</title>
<script language="javascript">
var imgcount = 1;
	function addImgFunction(){
		imgcount++;
		var tr = document .createElement('tr');
		tr.id = 'imgInputDiv'+ imgcount;
		var str ="";
		str += "<td>";
		str += "<input type='file' id=img"+imgcount+" name=img"+imgcount+" />";
		str += "<td onclick=removeImgFunction("+imgcount+")>";
		str += "Remove";
		str += "</td>";
		str += "</tr>";
		tr.innerHTML=str;
		document.getElementById('imgUpload').appendChild(tr);
	}
	function removeImgFunction(num){
		var tr = document.getElementById("imgInputDiv" + num);
		tr.parentNode.removeChild(tr);
		imgcount--;
	} 
	
	function getImgCount(){
		document.getElementById("imgcount").value=imgcount;
	}
	function submit(){
		var form = document.getElementById("addHostel");
		form.submit();
	}

</script>
</head>
<body>

	<div id="main">
			<!-- 컨텐츠 -->
			<div id="content">
					<!-- 게시판 등록 -->
					<form id="addHostel" action="addHostel.html" method="post"
						enctype="multipart/form-data" name="hostelsform">
						<table cellpadding="0" cellspacing="0">
							<tr align="center" valign="middle">
								<td colspan="5">호스텔 등록</td>
							</tr>
							<tr>
								<td style="font-family: 돋음; font-size: 12" height="16">
									<div align="center">호스텔 이름</div>
								</td>
								<td><input name="hostelsName" type="text" size="30"
									maxlength="30" value="" /></td>
							</tr>
							<tr>
								<td style="font-family: 돋음; font-size: 12" height="16">
									<div align="center">국가</div>
								</td>
								<td><input name="hostelsNation" type="text" size="30"
									maxlength="30" value="" /></td>
							</tr>
							<tr>
								<td style="font-family: 돋음; font-size: 12" height="16">
									<div align="center">도시</div>
								</td>
								<td><input name="hostelsCity" type="text" size="30"
									maxlength="30" value="" /></td>
							</tr>
							<tr>
								<td style="font-family: 돋음; font-size: 12" height="16">
									<div align="center">주소</div>
								</td>
								<td><input name="hostelsAddr" type="text" size="30"
									maxlength="30" value="" /></td>
							</tr>
							<tr>
								<td style="font-family: 돋음; font-size: 12" height="16">
									<div align="center">전화번호</div>
								</td>
								<td><input name="hostelsPhone" type="text" size="30"
									maxlength="30" value="" /></td>
							</tr>
							<tr>
								<td style="font-family: 돋음; font-size: 12" height="16">
									<div align="center">이 메일</div>
								</td>
								<td><input name="hostelsEmail" type="text" size="30"
									maxlength="30" value="" /></td>
							</tr>
							<tr>
								<td style="font-family: 돋음; font-size: 12">
									<div align="center">호스텔 정보</div>
								</td>
								<td><textarea name="hostelsInfo" cols="67" rows="15"></textarea>
								</td>
							</tr>
							
	<%-- 						<%
								String fileName[] = {"HOSTELSIMAGE0","HOSTELSIMAGE1","HOSTELSIMAGE2","HOSTELSIMAGE3","HOSTELSIMAGE4"};
								String fileInfo[] = {"파일 첨부0","파일 첨부1","파일 첨부2","파일 첨부3","파일 첨부4"};	
							
							for(int i=0; i<5;i++)
							{
							%>
							 <tr>
								<td style="font-family: 돋음; font-size: 12">
									<div align="center"><%=fileInfo[i]%></div>
								</td>
								<td><input name="<%=fileName[i]%>" type="file" /></td>
							</tr>
							<%
							}
							%>
							
							<%
								String roomName[] = {"FIR_ROOM_IMAGE0","FIR_ROOM_IMAGE1","FIR_ROOM_IMAGE2","SEC_ROOM_IMAGE0","SEC_ROOM_IMAGE1"
									,"SEC_ROOM_IMAGE2","THI_ROOM_IMAGE0","THI_ROOM_IMAGE1","THI_ROOM_IMAGE2","FOR_ROOM_IMAGE0"
									,"FOR_ROOM_IMAGE1","FOR_ROOM_IMAGE2","FIV_ROOM_IMAGE2","SEC_ROOM_IMAGE2","SEC_ROOM_IMAGE2"};
								
							
							for(int i=0; i<5;i++)
							{
							%>
							 <tr>
								<td style="font-family: 돋음; font-size: 12">
									<div align="center"><%=fileInfo[i]%></div>
								</td>
								<td><input name="<%=fileName[i]%>" type="file" /></td>
							</tr>
							<%
							}
							%> --%>
							

							
							<tr bgcolor="cccccc">
								<td colspan="2" style="height: 1px;"></td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr align="center" valign="middle">
								<td colspan="5"><a href="javascript:addboard()">[등록]</a>&nbsp;&nbsp;
									<a href="javascript:history.go(-1)">[뒤로]</a></td>
							</tr>
						</table>
						
						<table id=imgUpload>
						<tr>
						<td><input id="img1" name="img1" type="file"/></td>
						</tr>
						</table>
						<p onclick="addImgFunction()">
								Click here to add more imgs
						</p>	
						
						<input type="hidden" name=imgcount id="imgcount" />
						<input type="button" value="Submit" onclick="getImgCount();submit()"/>
					</form> 
					<!-- 게시판 등록 -->
				</div>
			</div>
</body>
</html>