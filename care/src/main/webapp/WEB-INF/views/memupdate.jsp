<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<!-- 주소 api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/juso.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script type="text/javascript" src="resources/js/memalert.js"></script>

</head>
<body>
<h2>회원정보 수정</h2>
<c:forEach items="${ memUp }" var="up">
<form action="updatemem.do" id="updatemember" method="post">
<button type="submit" id="button" >수정하기</button>
<input type="hidden" id="id" name="id" value="${ up.id }" />
이름 : <input type="text" id="name" name="name" value="${ up.name }" /><br/>
전화번호 : <input type="text" id="tel" name="tel" value="${ up.tel }" /><br/>
주소 : <input type="text" id="addr" name="addr" value="${ up.addr }" onclick="sample4_execDaumPostcode()" /><br/>
상세주소 : <input class="insert" id="addr" type="text" name="addr" /><br/>
비밀번호 : <input type="text" id="pw" name="pw" value="${ up.pw }" /><br/>
닉네임 : <input type="text" id="nick" name="nick" value="${ up.nick }" /><br/>
</form>
</c:forEach>
</body>
</html>