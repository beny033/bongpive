<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" rel="stylesheet">
<script src="/resources/js/header.js"></script>
</head>
<body>
	<div id='header'>
    	<h1 id='me'>Beny's</h1>

    <ul>
      <li><a href="/" id="home">홈</a></li>
      <li><a href="intro" id="intro">소개</a></li>
      <li><a href="portfolio" id="portfolio">포트폴리오</a></li>
      <li><a href="list" id="board">게시판</a></li>
      <li><a href="offer" id="offer">제의</a></li>
    </ul>

    <div id="member">
      <span class="login"><a href="">로그인</a></span>
      <span class="join"><a href="">회원가입</a></span>
    </div>
  </div>
</body>
</html>