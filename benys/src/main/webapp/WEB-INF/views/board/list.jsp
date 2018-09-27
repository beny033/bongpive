<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/boardList.css" type="text/css" rel="stylesheet">
<script>
	var msg = '${msg}';
	
	if(msg === 'SUCCESS') {
		alert('정상적으로 처리되었습니다.');
	}
</script>
</head>

<body onload="setColor('board');">

	<jsp:include page="../include/header.jsp" />

	<form action="" method="post">
	  <select name="searchType">
		<option value="none">- - - - - - - -</option>
		<option value="writer">작성자</option>
		<option value="title">제 목</option>
		<option value="content">내 용</option>
		<option value="writerContent">제목 + 내용</option>
	  </select>
	  
	  <input type="text" name="searchText">
	  <input type="submit" value="검 색">
    </form>	
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
		  <td class="data">
		    <c:set var="ListTitle" value="${list.title}"></c:set>
			<c:choose>
		    <c:when test="${fn:length(ListTitle) > 20}">
				<script>
					var listTitle = '${list.title}'.substring(0,20) + ".....";
					document.write("<a href='read?seq=${list.seq}&curruntPage=${paging.curruntPage}'>" + listTitle + "...." + "</a>");
				</script>
		    </c:when>
		    <c:otherwise>
	 		  <a href="read?seq=${list.seq}&curruntPage=${paging.curruntPage}">${list.title}</a> 
		    </c:otherwise>
			</c:choose>
		  </td>
		  
		  <td class="data">${list.writer}</td>
		  <td class="data"><fmt:formatDate value="${list.regdate}" pattern="YYYY-MM-dd"/></td>
		  <td class="data">${list.views}</td>
		</tr>
	   </c:forEach> 
	  
		<tr>
		  <td class="last"><input type="button" value="글쓰기" id="writeBtn" onclick="location.href='register'"></td>
		</tr>
	
	    <tr>
	   <c:forEach begin="1" end="${paging.totalPages}" step="1" var="pagingNumber">
	     <td class="pages">
		   <div id="pagesBtn">
			 <button >>></button>
			 <button onclick="location.href='list?curruntPage=${pagingNumber}'">${pagingNumber}</button>
		   </div>
	 	 </td>
	   </c:forEach>
		</tr>
 
	</table>
</body>
</html>