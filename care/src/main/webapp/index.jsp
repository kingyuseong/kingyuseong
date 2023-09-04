<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="UTF-8">
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
								<div class="page_title">
									<h2></h2>
								</div>
							</div>
						</div>


						<!-- graph -->
						<div class="row column2 graph margin_bottom_30">
							<div class="col-md-l2 col-lg-12">
								<div class="white_shd full">

									<div class="full graph_revenue">
										<div class="row">
											<div class="col-md-12">
												<div class="content1">


													<section class="intro">

														<h2>
															삶은 언제나 우리에게<br />힘든 위기를 겪게 하고 나서야<br />그 자신의 가장 빛나는 모습을
															드러냅니다. <br /> 그러니, 우리 조금만 더 힘내 볼까요?<br />우리가 당신의 다리가
															되어드리겠습니다.<br />Youth-Bridge
														</h2>




														<!--Loader-->
														<div class="loader">
															<span class="bar"> <i class="animate"></i>
															</span>
														</div>

													</section>
													<section class="content">
														<article></article>
													</section>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- end graph -->
						<div class="row column3">
							<!-- testimonial -->
							<div class="col-md-6">
								<div class="dark_bg full margin_bottom_30">
									<div class="full graph_head">
										<div class="heading1 margin_0">
											<h2>상담사 한마디</h2>
										</div>
									</div>
									<div class="full graph_revenue">
										<div class="row">
											<div class="col-md-12">
												<div class="content testimonial" style="border-top: none;">
													<div id="testimonial_slider" class="carousel slide"
														data-ride="carousel">
														<!-- Wrapper for carousel items -->
														<div class="carousel-inner">
															<div class="item carousel-item active">
																<div class="img-box">
																	<img src="resources/images/sds/1.jpg" alt="">
																</div>
																<p class="testimonial f_size20_2">
																	"생면부지의 사람에게 자신의 이야기를 더구나 사적이고 내밀한 부분까지 드러낸다는 것은<br />무척
																	어려운 일입니다. 털어놓는다고 해서 해결이 될까하는 의구심도 생기기 마련입니다.<br />오히려
																	부당한 평가나 몰이 때문에 더 상처 받지는 않을지 두려운 마음도 따라옵니다."
																</p>
																<p class="overview">
																	<b class="f_size20_2">신민준</b>
																</p>
															</div>
															<div class="item carousel-item">
																<div class="img-box">
																	<img src="resources/images/sds/2.jpg" alt="">
																</div>
																<p class="testimonial f_size20_2">
																	"혼자 내 문제에 매몰되어 있는 것은 구덩이에 빠진채 삽질을 계속하는 것과 비슷합니다.<br />친구나
																	가족들에게 조언을 구하는 것은 때때로 살아온 관성 속에 거듭 가두어지는 결과를 초래하기도 합니다.
																	전문성과 인간성을 겸비하기 위해 오랜 기간 공부하며 훈련 받은 전문 상담사와 만나보시길 바랍니다."
																</p>
																<p class="overview">
																	<b class="f_size20_2">박다솜</b>
																</p>
															</div>
															<div class="item carousel-item">
																<div class="img-box">
																	<img src="resources/images/sds/5.jpg" alt="">
																</div>
																<p class="testimonial f_size20_2">"우리는 수많은 말속에 둘러싸여
																	있지만 나에게 집중하여 언어를 사용한 경험은 그리 많지 않을 것입니다. 지금 이 글을 보는 여러분의
																	마음은 나에 대해 이야기하고 싶고, 이해를 바라며, 변화를 꿈꾸고 있습니다. 밖으로 향했던 시선을
																	이제 여러분의 내면에 두실 시간입니다."</p>
																<p class="overview">
																	<b class="f_size20_2">이초롱</b>
																</p>
															</div>
														</div>
														<!-- Carousel controls -->
														<a class="carousel-control left carousel-control-prev"
															href="#testimonial_slider" data-slide="prev"> <i
															class="fa fa-angle-left"></i>
														</a> <a class="carousel-control right carousel-control-next"
															href="#testimonial_slider" data-slide="next"> <i
															class="fa fa-angle-right"></i>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- end testimonial -->
							<!-- progress bar -->
							<div class="col-md-6">
								<div class="white_shd full margin_bottom_30">
									<div class="full graph_head">
										<div class="heading1 margin_0">
											<h2>지원정책</h2>
										</div>
									</div>
									<div class="full progress_bar_inner">
										<div class="row">
											<div class="col-md-12">

												<div class="container" style="margin-top: 8px;">
													<div class="row row-cols-4">
														<div class="col">
															<a
																href="https://www.pie-edu.com/news-5/-%5B%EB%AC%B4%EB%A3%8C-%EC%8B%AC%EB%A6%AC%EC%83%81%EB%8B%B4%5D-%EC%9D%80%EB%91%94%EA%B3%A0%EB%A6%BD%EC%B2%AD%EB%85%84%EB%93%A4%EA%B3%BC-%EA%B7%B8-%EB%B6%80%EB%AA%A8%EB%93%A4%EC%9D%84-%EC%9C%84%ED%95%9C-%EB%AC%B4%EB%A3%8C-%EC%8B%AC%EB%A6%AC-%EC%83%81%EB%8B%B4-%EC%A7%80%EC%9B%90"
																target='_blank'><img
																src="resources/images/support_policy/1.jpg" width="300"
																height="230" class="card-img-top" alt="..."></a>
														</div>
														<div class="col">
															<a
																href="https://youth.seoul.go.kr/site/main/content/reclusion_youth_intro"
																target='_blank'><img
																src="resources/images/support_policy/2.jpg" width="300"
																height="230" class="card-img-top" alt="..."></a>
														</div>
														<div class="col">
															<a href="https://youth.seoul.go.kr/site/youthnet/home"
																target='_blank'><img
																src="resources/images/support_policy/3.jpg" width="300"
																height="230" class="card-img-top" alt="..."></a>
														</div>
														<div class="col">
															<a href="https://www.work.go.kr/youngChallenge/index.do"
																target='_blank'><img
																src="resources/images/support_policy/4.jpg" width="300"
																height="230" class="card-img-top" alt="..."></a>
														</div>
													</div>
												</div>
												<div class="container">
													<div class="row row-cols-4"
														style="margin-top: 8px; margin-bottom: 8px;">
														<div class="col">
															<a
																href="https://youth.seoul.go.kr/site/main/youth/politics/user/detail/40867"
																target='_blank'><img
																src="resources/images/support_policy/5.jpg" width="300"
																height="230" class="card-img-top" alt="..."></a>
														</div>
														<div class="col">
															<a
																href="https://youth.seoul.go.kr/site/main/content/mind_reliable_ask"
																target='_blank'><img
																src="resources/images/support_policy/6.jpg" width="300"
																height="230" class="card-img-top" alt="..."></a>
														</div>
														<div class="col">
															<a
																href="https://youth.seoul.go.kr/site/orang/youth/politics/program/detail/41013"
																target='_blank'><img
																src="resources/images/support_policy/7.png" width="300"
																height="230" class="card-img-top" alt="..."></a>
														</div>
														<div class="col">
															<a
																href="https://youth.seoul.go.kr/site/orang/youth/politics/program/detail/40385"
																target='_blank'><img
																src="resources/images/support_policy/8.png" width="300"
																height="230" class="card-img-top" alt="..."></a>
														</div>
													</div>
												</div>

											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- end progress bar -->
						</div>

						<div class="row column4 graph">
							<div class="col-md-6 margin_bottom_30">
								<div class="dash_blog">
									<div class="dash_blog_inner">
										<div class="dash_head">
											<h3>
												<span><i class="fa fa-calendar"></i> 박람회</span>
											</h3>
										</div>
										<div class="list_cont">
											<p>박람회 일정</p>
										</div>
										<div class="task_list_main">
											<ul class="task_list">
												<li><span class="name_user f_size20_3">2023 관광산업
														일자리박람회</span><br> <strong>START : 2023-09-18 <br />
														END : 2023-09-19
												</strong></li>
												<li><span class="name_user f_size20_3">2023 고졸성공
														취업·창업 페스타</span><br> <strong>START : 2023-09-07 <br />
														END : 2023-09-07
												</strong></li>
												<li><span class="name_user f_size20_3">제약ㆍ바이오ㆍ건강기능
														산업 전시회</span><br> <strong>START : 2023-08-30 <br />
														END : 2023-09-01
												</strong></li>
												<li><span class="name_user f_size20_3">서울 팝 컬처
														컨벤션세계</span><br> <strong>START : 2023-08-25 <br />
														END : 2023-08-27
												</strong></li>
												<li><span class="name_user f_size20_3">2023
														Global Talent Fair</span><br> <strong> START :
														2023-08-21 <br /> END : 2023-08-22
												</strong></li>
											</ul>
										</div>
										<div class="read_more">
											<div class="center" style="padding: 0.8% 0">
												<a class="main_bt read_bt" style="padding: 1.2% 3%;"
													href="fairList.do">박람회 더보기</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="dash_blog">
									<div class="dash_blog_inner">
										<div class="dash_head">
											<h3>
												<span><i class="fa fa-comments-o"></i> 쉼터</span>
											</h3>
										</div>
										<div class="list_cont">
											<p>고민하지 말고 연락해주세요</p>
										</div>
										<div class="msg_list_main">
											<ul class="msg_list">
												<li><span><img
														src="resources/images/layout_img/tel.png"
														class="img-responsive" alt="#" /></span> <span> <span
														class="name_user f_size20_2">자살예방상담전화</span> <span
														class="msg_user">1393</span>
												</span></li>
												<li><span><img
														src="resources/images/layout_img/tel1.png"
														class="img-responsive" alt="#" /></span> <span> <span
														class="name_user f_size20_2">생명의전화</span> <span
														class="msg_user">1588-9191</span>
												</span></li>
												<li><span><img
														src="resources/images/layout_img/tel3.png"
														class="img-responsive" alt="#" /></span> <span> <span
														class="name_user f_size20_2">보건복지상담센터</span> <span
														class="msg_user">129</span>
												</span></li>
												<li><span><img
														src="resources/images/layout_img/tel2.jpg"
														class="img-responsive" alt="#" /></span> <span> <span
														class="name_user f_size20_2">대한법률구조공단</span> <span
														class="msg_user">132</span>
												</span></li>
												<li><span><img
														src="resources/images/layout_img/tel4.png"
														class="img-responsive" alt="#" /></span> <span> <span
														class="name_user f_size20_2">온라인청년센터</span> <span
														class="msg_user">youthcenter.go.kr</span>
												</span></li>
												<li><span><img
														src="resources/images/layout_img/tel5.jpg"
														class="img-responsive" alt="#" /></span> <span> <span
														class="name_user f_size20_2">여성새로일하기센터</span> <span
														class="msg_user">1544-1199</span>
												</span></li>
											</ul>
										</div>
										<div class="read_more"></div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- footer -->
					<div class="container-fluid">
						<div class="footer">
							<p>
								Copyright © 2023 Designed by html.design. All rights reserved.<br>
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
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<!-- wow animation -->
	<script src="resources/js/animate.js"></script>
	<!-- select country -->
	<script src="resources/js/bootstrap-select.js"></script>
	<!-- owl carousel -->
	<script src="resources/js/owl.carousel.js"></script>
	<!-- chart js./respirces/ -->
	<script src="resources/js/Chart.min.js"></script>
	<link rel="stylesheet" href="resources/css/custom.css" />
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
	<script src="resources/js/mainair.js"></script>
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