<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/read.css" type="text/css" rel="stylesheet">
<script>
	function actionLocation(location) {
		var thisForm = document.form;
		var id = document.getElementById(location).value;
		
		if(id == '수 정') {
			thisForm.action = "selfCheck?request=modify";
			thisForm.submit();
		} else if(id == '삭 제') {
			thisForm.action = "selfCheck?request=remove";
			thisForm.submit();
		} 
	}
</script>
</head>
<body onload="setColor('board');">

	<jsp:include page="../include/header.jsp"></jsp:include>

	<form  method="post" name="form">
		<input type="hidden" name="seq" value="${board.seq}">
		<input type="hidden" name="curruntPage" value="${curruntPage}">
		
		<table>
		  <caption>게시글 보기</caption>
			<tr>
			  <th><label for="tbl_writer">작성자</label></th>
			  <td><input type="text" name="writer" id="tbl_writer" value="${board.writer}" readonly></td> 
			</tr>
			<tr>
			  <th><label for="tbl_title">제 목</label></th>
			  <td><input type="text" name="title" id="tbl_title" value="${board.title}" readonly></td>
			</tr>
			<tr>
			  <th><label for="tbl_content">내 용</label></th>
			  <td><textarea name="content" id="tbl_content" readonly>${board.content}</textarea></td>
			</tr>
			<tr>
			  <td class="buttons"><input type="button" value="수 정" id="modify" onclick="actionLocation('modify');"></td>
			  <td class="buttons"><input type="button" value="삭 제" id="remove" onclick="actionLocation('remove');"></td>
			  <td class="buttons"><input type="button" value="이 전" id="back" onclick="location.href='list?curruntPage=${curruntPage}'" ></td>
			</tr>   
		</table>
	</form>
</body>
</html>