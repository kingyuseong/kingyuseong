<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/juso.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script type="text/javascript" src="resources/js/memalert.js"></script>

</head>
<body>
<h2>상담사정보 수정</h2>
<c:forEach items="${ sdsmemUp }" var="sup">
<form action="updatesdsmem.do" id="updatesdsmember" method="post">
<button type="submit" id="button" >수정하기</button>
<input type="hidden" id="sdsid" name="sdsid" value="${ sup.sdsid }" />
이름 : <input type="text" id="sdsname" name="sdsname" value="${ sup.sdsname }" /><br/>
전화번호 : <input type="text" id="sdstel" name="sdstel" value="${ sup.sdstel }" /><br/>
주소 : <input type="text" id="sdsaddr" name="sdsaddr" value="${ sup.sdsaddr }" onclick="sample4_execDaumPostcode()" /><br/>
상세주소 : <input class="insert" id="sdsaddr" type="text" name="sdsaddr" /><br/>
비밀번호 : <input type="text" id="sdspw" name="sdspw" value="${ sup.sdspw }" /><br/>
닉네임 : <input type="text" id="sdsnick" name="sdsnick" value="${ sup.sdsnick }" /><br/>
</form>
</c:forEach>
</body>
</html>