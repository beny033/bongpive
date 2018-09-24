<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/read.css" type="text/css" rel="stylesheet">
<script>
function checkSubmit() {
	var writer = document.getElementById('tbl_writer');
	var title = document.getElementById('tbl_title');
	var content = document.getElementById('tbl_content');
	
	
	if(writer.value == "" || title.value == "" || content.value == "") {
		alert('입력란을 확인하세요.');
	} else {
		document.form.action = "modify";
		document.form.submit();
	}
}
</script>
</head>
<body onload="setColor('board');">

	<jsp:include page="../include/header.jsp"></jsp:include>

	<form method="post" name="form">
		<table>
		  <caption>게시글 수정</caption>
			<tr>
			  <th><label for="tbl_seq">번 호</label></th>
			  <td><input type="text" name="seq" id="tbl_seq" value="${board.seq}" readonly></td> 
			</tr>
			<tr>
			  <th><label for="tbl_writer">작성자</label></th>
			  <td><input type="text" name="writer" id="tbl_writer" value="${board.writer}" maxlength="10"></td> 
			</tr>
			<tr>
			  <th><label for="tbl_title">제 목</label></th>
			  <td><input type="text" name="title" id="tbl_title" value="${board.title}" maxlength="48"></td>
			</tr>
			<tr>
			  <th><label for="tbl_content">내 용</label></th>
			  <td><textarea name="content" id="tbl_content" >${board.content}</textarea></td>
			</tr>
			
			<tr>
			  <td class="buttons"><input type="button" value="완 료" id="save" onclick="checkSubmit();"></td>
			  <td class="buttons"><input type="button" value="취 소" id="cancle" onclick="location.href='read?seq=${board.seq}'"></td>
			</tr>   
		</table>
	</form>
</body>
</html>