<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<style>
#check {
	text-align: center;
	position: relative;
	top: 150px;	
}
</style>
<script src="resources/js/selfCheck.js"></script>
</head>
<body onload="setColor('board');">

	<jsp:include page="../include/header.jsp"></jsp:include>

	<div id="check">
	  <h2>비밀번호 입력</h2>
		<form  action="compare" method="post" name="form">
			<input type="hidden" name="seq" value="${param.seq}">
			<input type="hidden" name="request" value="${param.request}">
			<input type="hidden" name="curruntPage" value="${param.curruntPage}">
			<input type="password" name="password" id="pw" onkeyup="check();" maxlength="4" autofocus>
			<input type="button" value="확 인" onclick="goSubmit();">
		</form>
	</div>
</body>
</html>