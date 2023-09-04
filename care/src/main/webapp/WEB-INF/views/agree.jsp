<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>약관보기</title>
<!-- agree로 바꾸어서 적용하려 했으나 적용되지 않아 부득이하게 test그대로 파일명을 잡음 -->
<link rel="stylesheet" href="resources/css/test.css">
<script type="text/javascript" src="resources/js/test.js"></script>
</head>
<body>
	<form action="" id="form">
		<h4>이용약관 동의(필수)</h4>
		<div class="ag" style="overflow: auto" id="div" onscroll="fc()">
			여러분을 환영합니다.<br /> YOUTH-BRIDGE 서비스(이하 ‘서비스’)을 이용해 주셔서 감사합니다.<br /> 본
			약관은 다양한 YOUTH-BRIDGE 서비스의 이용과 관련하여 YOUTH-BRIDGE 서비스를 제공하는 할수있조(이하
			‘할수있조’)와 이를 이용하는 YOUTH-BRIDGE 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러
			여러분의 YOUTH-BRIDGE 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.<br />
		</div>
		<div class="div_g">
		<input type="checkbox" class="chk" id="ag" disabled><label
			for="ag">동의</label>
		</div>
		<h4>개인정보 수집 및 이용에 대한 안내(필수)</h4>
		<div class="bg" style="overflow: auto" id="div" onscroll="ac()">
			여러분을 환영합니다.<br /> YOUTH-BRIDGE 서비스(이하 ‘서비스’)을 이용해 주셔서 감사합니다.<br /> 본
			약관은 다양한 YOUTH-BRIDGE 서비스의 이용과 관련하여 YOUTH-BRIDGE 서비스를 제공하는 할수있조(이하
			‘할수있조’)와 이를 이용하는 YOUTH-BRIDGE 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러
			여러분의 YOUTH-BRIDGE 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.<br />
		</div>
		<div class="div_g">
		<input type="checkbox" class="chk" id="bg" disabled><label
			for="bg">동의</label>
		</div>
		<h4>위치정보 이용약관 동의(필수)</h4>
		
		<div class="cg" style="overflow: auto" id="div" onscroll="bc()">
			여러분을 환영합니다.<br /> YOUTH-BRIDGE 서비스(이하 ‘서비스’)을 이용해 주셔서 감사합니다.<br /> 본
			약관은 다양한 YOUTH-BRIDGE 서비스의 이용과 관련하여 YOUTH-BRIDGE 서비스를 제공하는 할수있조(이하
			‘할수있조’)와 이를 이용하는 YOUTH-BRIDGE 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러
			여러분의 YOUTH-BRIDGE 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.<br />
		</div>
		<div class="div_g">
		<input type="checkbox" class="chk" id="cg" disabled><label
			for="cg">동의</label>
		</div>
		<div>
			<input type="button" id="button" onclick="turn()" value="동의하기">
		</div>
	</form>
</body>
</html>