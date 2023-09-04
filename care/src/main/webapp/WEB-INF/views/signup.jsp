<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%-- <script src="../js/check.js"></script>   --%>
<link rel="stylesheet" href="resources/css/signup.css">
<%-- <script type="text/javascript" src="././resources/js/signup.js"></script> --%>
<!-- 동의하기를 누르면 약관을 팝업으로 띄워줌(+약관 전부 체크하면 disabled체크박스 체크되게 하는것도 추가) -->
<script type="text/javascript" src="resources/js/signupp.js"></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<!-- 주소api -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/juso.js"></script>
<!-- 경고창 -->
<script type="text/javascript" src="resources/js/alert.js"></script>
<!-- 아이디 중복 알림 -->
<script type="text/javascript" src="resources/js/idCheck.js"></script>
<!-- 라디오 버튼 성별 가져오기 -->
<script type="text/javascript" src="resources/js/radio.js"></script>
<%
	
%>
</head>
<body>


	<h2 class="signup_h2">
		회원가입을 위해<br>정보를 입력해주세요.
	</h2>
	<div class="container">

		<form method="post" action="saveMember.do" name="userinput"
			id="userinput">
			<div class="sign-up">
				<div class="info">
					<p class="label">이름</p>
					<input type="text" class="insert" id="name" name="name" autocomplete="off"
						maxlength="8" title="8자 까지 입력" />
				</div>
				<div class="info">
					<p class="label">전화번호</p>
					<input class="insert" type="text" name="tel" id="tel" autocomplete="off"
						placeholder="'―' 를 포함시켜주세요" />
				</div>
				<div class="info">
					<p class="label">주소</p>
					<!-- <input type="button" name="button" id="juso" value="주소"  onclick="sample4_execDaumPostcode()" /> -->
					<input class="insert" type="text" name="addr" id="addr" autocomplete="off"
						onclick="sample4_execDaumPostcode()" />
					<p class="label">상세주소</p>
					<input class="insert" type="text" name="addr" id="addr" autocomplete="off" />
				</div>
				<div class="info">
					<p class="label">아이디</p>
					<input class="insert" type="text" name="id" id="id" autocomplete="off" /><br /> <span
						id="idCheckResult" style="width: 150px; color: red"></span>
				</div>
				<div class="info">
					<p class="label">비밀번호</p>
					<input class="insert" type="password" name="pw" id="pw" autocomplete="off" />
				</div>
				<div class="info">
					<p class="label">비밀번호 확인</p>
					<input class="insert" type="password" name="passCheck"
						id="passCheck" autocomplete="off" />
				</div>
				<div id="ss" class="info">
					<p class="label">성별</p>
					<input class="insert" type="hidden" name="sex" id="sex" />
					<input id="sex" type="radio" name="gender" value="남자" class="radio" onclick="getGender(event);" /><label for="남자">남자</label>
					<input id="sex" type="radio" name="gender" value="여자" class="radio" onclick="getGender(event);" /><label for="여자">여자</label>
					<hr/>
				</div>
				<div class="info">
					<p class="label">닉네임</p>
					<input class="insert" type="text" name="nick" id="nick" autocomplete="off" /><br /> <span
						id="nickCheckResult" style="width: 150px; color: red"></span>
				</div>
				<br>
				<br>
				<div>
				<input type="checkbox" id="check" class="agree" disabled>&nbsp
				이용약관 개인정보 수집 및 정보이용에 동의합니다.
				<a onclick="pop()" class="Hpop">[약관보기]</a>
				</div>
				<div class="btns">
					<button type="submit" id="button" class="confirm">회원가입</button>
				</div>
				<!-- 기능자체는 input의 타입을 button으로 하면 사용은 가능하지만, 굳이 button 태그를 사용하는 이유는 -->
				<!-- 커스터마이징이 button 태그가 더 용이하기 때문이다. -->
				<!-- <input type="button" value="가입하기"> -->
			</div>
		</form>

	</div>



</body>
</html>