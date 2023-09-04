<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 추가</title>

<link rel="styleet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="resources/css/schedule.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css"
	integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="resources/js/schedule.js"></script>
<script src="resources/js/cate.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
	integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="resources/js/picker.js"></script>
<!-- datetimepicker plug -->
<link rel="stylesheet" type="text/css"
	href="resources/css/jquery.datetimepicker.css"/ >
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery.datetimepicker.full.min.js"></script>
<!-- datetimepicker 한국어 플러그인 -->
<script src="resources/js/datepicker-ko-KR.js"></script>
<!-- 빈칸이 있으면 그 칸에 대한 경고 및 입력시 확인시켜주는 경고창 -->
<script src="resources/js/reservePopupAlert.js"></script>
<!-- 일정 비동기로 체크해주는 js -->
<script src="resources/js/dateCheck.js"></script>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="resources/js/Sdsdeletealert.js"></script>
<script>
	$.datetimepicker.setLocale('kr');
</script>
<%
	String srcode = request.getParameter("srcode");
// 상담사 번호(sdsmemcode)을 이용하여 처리
int sdsmemcode = (Integer) session.getAttribute("sdsmemLogin");
%>
</head>
<body>

	<div class="group" id="popupGroup">
		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12"
			style="margin-left: 10%; flex: 12.5%; width: 80%;">

			<div class="table_price full margin_top20px"
				style="padding-bottom: 25px;">
				<%--  <c:forEach items="${ myList }" var="mem"> --%>
				<form style="padding: 3.5% 3.5% 0 3.5%;" id = "scheduleData" action="updateSdsReserve.do" method="POST">
					<div>
						<input type="hidden" name="srcode" value="<%=srcode %>" />
     					 <input type="hidden" name="sdsmemcode" value="${sdsmemLogin}" />
					</div>
					<br />

					<h1 style="margin-top: 8px;">일정 수정</h1>
					<div class="row mb-3">
						<div class="col-md-6">
							<label for="inputPassword4" class="form-label f_size20"></label>
							<textarea class="form-control subject" id="sctitle" name="sctitle"
								placeholder="내용을 입력해주세요(25자)" autocomplete="off" rows="2"></textarea>
						</div>
					</div>

					<div class="row mb-3" style="margin-bottom: 0rem !important;">
						<div class="col-md-6">
							<h1 style="margin: 10px 0px 4px 0px;">시작</h1>
							<input type="text" class="form-control existing-end-dates"
								id="datetimepicker" value="" autocomplete="off" name="sdsstartdate"
								type="text"> <span id="datetimepickerResult"
								style="width: 250px; height: 30px; color: red; z-index: 100;"></span>
						</div>
					</div>

					<div class="row mb-3" style="margin-bottom: 0rem !important;">
						<div class="col-md-6">
							<h1 style="margin: 4px 0;">종료</h1>
							<input type="text" class="form-control existing-end-dates"
								id="datetimepicker1" autocomplete="off" name="sdsenddate"
								type="text"> <span id="datetimepicker1Result"
								style="width: 250px; height: 30px; color: red; z-index: 100;"></span>
						</div>
					</div>



					<div class="right_alignment"
						style="width: 170px; margin-right: 0px;">
						<input
							class="btn detail_button" id="btn" onclick="alertClick()"
							type="submit" value="수정하기" data-bs-toggle="modal"
							data-bs-target="#exampleModal"
							style="float: left; margin-right: 10px"></input>
				</form>
				<%-- ReserveController참고하면 form에 대한 부분 이해 가능(삭제) --%>
				<form id="scheduleData1" action="deleteSdsReserve.do" method="POST">
					<input type="hidden" name="srcode" value="<%=srcode %>" />
					<input class="btn detail_button2" id="btn2" onclick="alertClick()"
						type="submit" value="삭제하기" data-bs-toggle="modal"
						data-bs-target="#exampleModal"></input>
				</form>
			</div>

		</div>
		<!-- end column price -->
	</div>
	</div>

</body>



</html>