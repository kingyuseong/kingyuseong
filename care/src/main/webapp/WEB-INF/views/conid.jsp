<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</head>
<body>
<h2>당신의 아이디는 </h2>
<c:forEach items="${ conid }" var="f">
<div>
<input type="text" name="id" value="${ f.id }" disabled />입니다.
</c:forEach>
</div>
<a href="login.do">로그인하기</a>
</body>
</html>