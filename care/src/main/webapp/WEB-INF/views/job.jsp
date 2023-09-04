<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>Youth-Bridge</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- site icon -->
<link rel="icon" href="resources/images/fevicon.png" type="image/png" />
<!-- bootstrap css -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
<!-- site css -->
<link rel="stylesheet" href="resources/css/style.css" />
<!-- responsive css -->
<link rel="stylesheet" href="resources/css/responsive.css" />
<!-- color css -->
<link rel="stylesheet" href="resources/css/colors.css" />
<!-- select bootstrap -->
<link rel="stylesheet" href="resources/css/bootstrap-select.css" />
<!-- scrollbar css -->
<link rel="stylesheet" href="resources/css/perfect-scrollbar.css" />
<!-- custom css -->
<link rel="stylesheet" href="resources/css/custom.css" />
<link rel="stylesheet" href="resources/css/mainair.css" />
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
<%
	String id = (String) session.getAttribute("IdLogin");
int memcode = (Integer) session.getAttribute("MemLogin");
String sdsid = (String) session.getAttribute("SdsLogin");
int sdsmemcode = (Integer) session.getAttribute("sdsmemLogin");
%>
</head>
<body class="dashboard dashboard_1"
	style="-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none">
	<div class="full_container">
		<div class="inner_container">
			<!-- sidebar 메뉴  -->
			<nav id="sidebar" name="sidebar">
				<div class="sidebar_blog_1">
					<div class="sidebar-header">
						<div class="logo_section">
							<a href="index.jsp"><img class="logo_icon img-responsive"
								src="resources/images/logo/logo_icon.png" alt="#" /></a>
						</div>
					</div>
					<div class="sidebar_user_info">
						<div class="icon_setting"></div>
						<div class="user_profle_side">
							<div class="user_info"></div>
						</div>
					</div>
				</div>
				<div class="sidebar_blog_2">
					<ul class="list-unstyled components">
						<li class="active"><a href="#advice" data-toggle="collapse"
							aria-expanded="false" class="dropdown-toggle"><i><img
									src="resources/images/icon/counselling-icon.png"
									style="width: 30px;"></i><span>상담</span></a>
							<ul class="collapse list-unstyled" id="advice">
								<li><a href="counseling_center1.do">> <span>상담소
											찾기</span></a></li>
								<li><c:if test="${Login eq null && SdsLogin eq null}">
										<a style="cursor: pointer" onclick="service4()">> <span>예약하기</span></a>
									</c:if> <c:if test="${Login ne null && SdsLogin eq null}">
										<a href="reservationList.do">> <span>예약하기</span></a>
									</c:if> <c:if test="${SdsLogin ne null && Login eq null}">
										<a href="javascript:void(0);"
											onclick="sdspopup('${sdsmemLogin}')">> <span>일정등록하기</span></a>
									</c:if></li>
								<li><c:if test="${Login eq null && SdsLogin eq null}">
										<a style="cursor: pointer" onclick="service4()">> <span>상담하기</span></a>
									</c:if> <c:if test="${Login ne null && SdsLogin eq null}">
										<a style="cursor: pointer" href="chat.do">> <span>상담하기</span></a>
									</c:if> <c:if test="${SdsLogin ne null && Login eq null}">
										<a style="cursor: pointer" href="chat2.do">> <span>상담하기</span></a>
									</c:if></li>
							</ul></li>

						<li><c:if test="${Login eq null && SdsLogin eq null}">
								<a href="#diary" data-toggle="collapse" aria-expanded="false"
									class="dropdown-toggle"><i><img
										src="resources/images/icon/diary-icon.png"
										style="width: 30px;"></i><span>일기장</span></a>
							</c:if> <c:if test="${Login ne null && SdsLogin eq null}">
								<a href="#diary" data-toggle="collapse" aria-expanded="false"
									class="dropdown-toggle"><i><img
										src="resources/images/icon/diary-icon.png"
										style="width: 30px;"></i><span>일기장</span></a>
							</c:if>
							<ul class="collapse list-unstyled" id="diary">
								<li><a onclick="service()" style="cursor: pointer">> <span>일기</span></a>
								</li>
								<li><a onclick="service2()" style="cursor: pointer">> <span>감정그래프</span></a>
								</li>
							</ul></li>
						<c:if test="${Login eq null && SdsLogin eq null}">
							<li><a onclick="service3()" style="cursor: pointer"><i><img
										src="resources/images/icon/bucketList-icon.png"
										style="width: 30px"></i> <span>버킷리스트</span></a></li>
						</c:if>
						<c:if test="${Login ne null && SdsLogin eq null}">
							<li><a onclick="service3()" style="cursor: pointer"><i><img
										src="resources/images/icon/bucketList-icon.png"
										style="width: 30px"></i> <span>버킷리스트</span></a></li>
						</c:if>
						<li><a href="training.do"><i><img
									src="resources/images/icon/narration-icon.png"
									style="width: 30px;"></i> <span>대화하기</span></a></li>
						<li><a href="getAllFreeBoards.do"><i><img
									src="resources/images/icon/board-icon.png" style="width: 30px;"></i>
								<span>이용후기게시판</span></a></li>
						<li><a href="#apps" data-toggle="collapse"
							aria-expanded="false" class="dropdown-toggle"><i><img
									src="resources/images/icon/information-icon.png"
									style="width: 30px;"></i> <span>정보게시판</span></a>
							<ul class="collapse list-unstyled" id="apps">
								<li><a href="advocacy.do">> <span>지원정책</span></a></li>
								<li><a href="jobList.do">> <span>일자리</span></a></li>
								<li><a href="fairList.do">> <span>박람회</span></a></li>
							</ul></li>
						<li><a href="faq.do"><i><img
									src="resources/images/icon/support-icon.png"
									style="width: 30px;"></i> <span>FAQ</span></a></li>
					</ul>
				</div>
			</nav>
			<!-- end sidebar 메뉴 끝 -->
			<!-- right content -->
			<div id="content">
				<!-- topbar -->
				<div class="topbar">
					<nav class="navbar navbar-expand-lg navbar-light">
						<div class="full">
							<button type="button" id="sidebarCollapse" class="sidebar_toggle"
								style="height: 76px; padding: 15px 26px 15px;">
								<i class="fa fa-bars"></i>
							</button>
							<div class="logo_section">
								<a href="index.jsp"><img class="img-responsive"
									src="resources/images/logo/logo.png" /></a>
							</div>
							<div class="right_topbar">
								<div class="icon_info">
									<ul class="user_profile_dd">
										<li>
											<%-- choose는 확실히 구분될때, if는 조건으로 구분해야할 때 사용 --%> <%-- 회원, 상담사 모두 null이면 로그인하러가기가 뜸 --%>
											<c:if test="${Login eq null && SdsLogin eq null}">
												<a class="dropdown-toggle" href="login.do"><span
													class="name_user">로그인</span></a>
											</c:if> <%-- 회원 닉네임 나오게 하는 부분(null이면 로그인 하러가기 나오고, 로그인하면 마이페이지, 로그아웃 나오게함) --%>
											<c:if test="${Login ne null && SdsLogin eq null}">
												<a class="dropdown-toggle" data-toggle="dropdown"><span
													class="name_user login_name">${ Login }&nbsp님 </span></a>
												<div class="dropdown-menu">
													<form action="myPage.do" class="dropdown-item"
														style="padding: 4px 15px;">
														<input type="hidden" name="id" value="${ IdLogin }" /> <input
															class="" type="submit" name="member" value="마이페이지"
															style="padding: 0rem 0rem;" />
													</form>
													<!-- <a class="dropdown-item" name="member" href="myPage.do">마이페이지</a> -->
													<a class="dropdown-item" href="logout.do"><span>로그아웃&nbsp;</span><i
														class="fa fa-sign-out"></i></a>
												</div>
											</c:if> <%-- 상담사 닉네임 나오게 하는 부분(null이면 로그인 하러가기 나오고, 로그인하면 마이페이지, 로그아웃 나오게함) --%>
											<c:if test="${SdsLogin ne null && Login eq null}">
												<a class="dropdown-toggle" data-toggle="dropdown"><span
													class="name_user login_name">${ NickLogin }&nbsp상담사</span></a>
												<div class="dropdown-menu">
													<form action="sdsMyPage.do" class="dropdown-item"
														style="padding: 4px 15px;">
														<input type="hidden" name="sdsid" value="${ SdsLogin }" />
														<input class="dropdown-item" type="submit"
															name="sdsmember" value="마이페이지"
															style="padding: 0rem 0rem;" />
													</form>
													<!-- <a class="dropdown-item" name="sdsmember" href="sdsMyPage.do">마이페이지</a> -->
													<a class="dropdown-item" href="sdslogout.do"><span>로그아웃</span></a>
												</div>
											</c:if> <%-- 상담사 닉네임 나오게 하는 부분(null이면 로그인 하러가기 나오고, 로그인하면 마이페이지, 로그아웃 나오게함) + 상담사 권한이 'N'이면 로그아웃만 나옴(마이페이지 이용 불가) --%>
											<%-- <c:if test="${SdsLogin ne null && SdsCheck eq 'N' && Login eq null}"><a class="dropdown-toggle" data-toggle="dropdown"><span class="name_user"><%= sdsnick %></span></a>
                           <div class="dropdown-menu">
                           <a class="dropdown-item" href="sdslogout.do"><span>로그아웃</span> <i class="fa fa-sign-out"></i></a>
                           </div></c:if>               --%>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</nav>
				</div>
				<!-- end topbar -->
				<!-- dashboard inner -->
				<div class="midde_cont">
					<div class="container-fluid">
						<div class="row column_title">
							<div class="col-md-12">
								<div class="page_title"></div>
							</div>
						</div>
						<!-- row -->
						<div class="midde_cont">
							<div class="container-fluid">
								<div class="row column1">
									<div class="col-md-12">
										<div class="white_shd full margin_bottom_30">
											<div class="full graph_head">
												<div class="heading1 margin_0">
													<h2>일자리</h2>
												</div>
											</div>
											<div class="full price_table padding_infor_info">
												<div class="row">
													<!-- column contact -->
													<!-- JSTL 반복문 카드 형태 리스트 -->
													<c:forEach items="${jobList }" var="job">
														<div
															class="col-lg-4 col-md-6 col-sm-6 col-xs-12 profile_details margin_bottom_30">
															<div class="contact_blog">
																<h4 class="brief">
																	<br>
																</h4>
																<div class="contact_inner">
																	<div class="left" style="width: 100%; position: relative;">
																		<h3 style="z-index: 100;">${job.jobtitle }</h3>
																		<p style="font-size: 17px;">
																			<strong>${job.jobname }</strong>
																		</p>
																		<ul class="list-unstyled">
																			<li><img class="img-job"
																				src="resources/images/icon/location.png" /><span
																				class="span_bold"></span> : ${job.jobloc }</li>
																			<!-- 지역 -->
																			<li><img class="img-job"
																				src="resources/images/icon/time.png" /><span
																				class="span_bold"></span> : ${job.jobend }</li>
																			<!-- 마감일 -->
																			<li><img class="img-job"
																				src="resources/images/icon/briefcase.png" /><span
																				class="span_bold"></span> : ${job.jobexper }</li>
																			<!-- 경력 -->
																			<li><img class="img-job"
																				src="resources/images/icon/mortarboard.png" /><span
																				class="span_bold"></span> : ${job.jobreq }</li>
																			<!-- 학력 -->
																			<li><img class="img-job"
																				src="resources/images/icon/company.png" /><span
																				class="span_bold"></span> : ${job.jobtype }</li>
																			<!-- 계약유형 -->
																		</ul>
																		<img src="resources/images/layout_img/nunny.png" class="bwink-image" />
																	</div>
																	<div class="bottom_list">
																		<div class="right_button">
																			<button type="button"
																				class="btn btn-xs detail_button"
																				onclick="window.open('${job.joburl }') ">
																				<i class="fa fa-user"> </i> 상세보기
																			</button>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</c:forEach>
													<!-- end column contact blog -->
													<!-- column contact -->

												</div>
											</div>
										</div>
									</div>
									<!-- end row -->
								</div>
								<div class="container-fluid">
									<div class="footer">
										<p>
											Copyright ©2023 Designed by html.design. All rights
											reserved.<br>
											<br> Distributed By: <a href="https://themewagon.com/">ThemeWagon</a>
										</p>
									</div>
								</div>
							</div>
							<!-- end dashboard inner -->
						</div>
					</div>
				</div>
				<!-- jQuery -->
				<script src="resources/js/jquery.min.js"></script>
				<script src="resources/js/popper.min.js"></script>
				<script src="resources/js/bootstrap.min.js"></script>
				<!-- wow animation -->
				<script src="resources/js/animate.js"></script>
				<!-- select country -->
				<script src="resources/js/bootstrap-select.js"></script>
				<!-- owl carousel -->
				<script src="resources/js/owl.carousel.js"></script>
				<!-- chart js -->
				<script src="resources/js/Chart.min.js"></script>
				<script src="resources/js/Chart.bundle.min.js"></script>
				<script src="resources/js/utils.js"></script>
				<script src="resources/js/analyser.js"></script>
				<!-- nice scrollbar -->
				<script src="resources/js/perfect-scrollbar.min.js"></script>
				<script>
					var ps = new PerfectScrollbar('#sidebar');
				</script>
				<!-- custom js -->
				<script src="resources/js/custom.js"></script>
				<script src="resources/js/chart_custom_style1.js"></script>
				<script src="resources/js/Service.js"></script>
				<script>
					function service() {
						let logIn = "${IdLogin}";
						if (logIn == "") {
							alert("서비스 페이지는 회원만 사용할 수 있습니다.");
							location.href = "login.do";
						} else {
							location.href = "diary.do?memcode=${MemLogin}";
						}
					}
					function service2() {
						let logIn = "${IdLogin}";
						if (logIn == "") {
							alert("서비스 페이지는 회원만 사용할 수 있습니다.");
							location.href = "login.do";
						} else {
							location.href = "emotions.do?memcode=${MemLogin}";
						}
					}
					function service3() {
						let logIn = "${IdLogin}";
						if (logIn == "") {
							alert("서비스 페이지는 회원만 사용할 수 있습니다.");
							location.href = "login.do";
						} else {
							location.href = "bucket_list.do?memcode=${MemLogin}";
						}
					}
					function service4() {
						let logIn = "${IdLogin}";
						if (logIn == "") {
							alert("서비스 페이지는 회원만 사용할 수 있습니다.");
							location.href = "login.do";
						}
					}
				</script>
</body>
</html>