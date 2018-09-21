<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/boardList.css" type="text/css" rel="stylesheet">
</head>

<body onload="setColor('board');">

	<jsp:include page="../include/header.jsp" />

	<table>
		<tr>
		  <th>번호</th>
		  <th>제목</th>
		  <th>작성자</th>
		  <th>등록일</th>
		  <th>조회수</th>
		</tr>

	   <c:forEach var="list" items="${list}"> 
		<tr>
		  <td class="data">${list.seq}</td>
		  <td class="data"><a href="">${list.title}</a></td>
		  <td class="data">${list.writer}</td>
		  <td class="data"><fmt:formatDate value="${list.regdate}" pattern="YYYY-MM-dd"/></td>
		  <td class="data">${list.views}</td>
		</tr>
	   </c:forEach> 
	  
		<tr>
		  <td class="last"><input type="button" value="글쓰기" id="writeBtn" onclick="location.href='register'"></td>
		</tr>
	</table>

</body>
</html>