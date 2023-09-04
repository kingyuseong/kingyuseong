<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
<h2>당신의 비밀번호는 </h2>
<c:forEach items="${ sdsconpw }" var="f">
<div>
<input type="text" name="sdspw" value="${ f.sdspw }" disabled />입니다.
</c:forEach>
</div>
<a href="login.do">로그인하기</a>
</body>
</html>