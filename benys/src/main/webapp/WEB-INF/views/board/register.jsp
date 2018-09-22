<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/register.css" type="text/css" rel="stylesheet">
</head>
<body onload="setColor('board');">

	<jsp:include page="../include/header.jsp"></jsp:include>

	<form action="register" method="post">
		<table>
		  <caption>게시글 작성</caption>
			<tr>
			  <th><label for="tbl_writer">작성자</label></th>
			  <td><input type="text" name="writer" id="tbl_writer" autofocus required></td> 
			</tr>
			<tr>
			  <th><label for="tbl_password">비밀번호</label></th>
			  <td><input type="password" name="password" id="tbl_password" required></td>
			</tr>
			<tr>
			  <th><label for="tbl_title">제 목</label></th>
			  <td><input type="text" name="title" id="tbl_title" required></td>
			</tr>
			<tr>
			  <th><label for="tbl_content">내 용</label></th>
			  <td><textarea name="content" id="tbl_content" required></textarea></td>
			</tr>
			<tr>
			  <td class="submit"><input type="submit" value="작 성" id="save"></td>
			  <td class="submit"><input type="button" value="취 소" id="cancle" onclick="history.back();"></td>
			</tr>
		</table>
	</form>

</body>
</html>