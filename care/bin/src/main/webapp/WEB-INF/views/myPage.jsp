<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script type="text/javascript" src="resources/js/memupdate.js"></script>
    <!-- 회원 탈퇴 경고창 -->
    <script type="text/javascript" src="resources/js/mdalert.js"></script>
    
    
  </head>
  <body>
  <h3>회원 마이페이지</h3>
    <div class="accordion accordion-flush" id="accordionFlushExample">
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
        	회원정보
      </button>
    </h2>
    <c:forEach items="${ myList }" var="mem">
    닉네임 : <input type="text" name="nick" value="${ mem.nick }" disabled />
    <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body"><form action="memupdate.do"><input type="hidden" name="id" onclick="popup()" value="${ mem.id }" /><input type="submit" value="정보수정" /></form></div>
      <div class="accordion-body">회원번호 : <input type="text" name="memcode" value="${ mem.memcode }" disabled /></div>
      <div class="accordion-body">이름 : <input type="text" name="name" value="${ mem.name }" disabled /></div>
      <div class="accordion-body">가입날짜 : <input type="text" name="memdate" value="${ mem.memdate }" disabled /></div>
      <div class="accordion-body">전화번호 : <input type="text" name="tel" value="${ mem.tel }" disabled /></div>
      <div class="accordion-body">주소 : <input type="text" name="addr" value="${ mem.addr }" disabled /></div>
      <div class="accordion-body">아이디 : <input type="text" name="id" value="${ mem.id }" disabled /></div>
      <div class="accordion-body">비밀번호 : <input type="password" name="pw" value="${ mem.pw }" disabled /></div>
      <div class="accordion-body">성별 : <input type="text" name="sex" value="${ mem.sex }" disabled /></div>
      <div class="accordion-body">등급 : <input type="text" name="grade" value="${ mem.grade }" disabled /></div>
      <div class="accordion-body">닉네임 : <input type="text" name="nick" value="${ mem.nick }" disabled /></div>
      </c:forEach>      
    </div>
  	<div class="btn-group-vertical" role="group" aria-label="Vertical button group">
  		<a href="#"><button type="button" class="btn btn-primary">상담 예약 일정</button></a>
  		<a href="#"><button type="button" class="btn btn-primary">나의 일기장</button></a>
  		<a href="#"><button type="button" class="btn btn-primary">버킷리스트</button></a>
  		<a href="#"><button type="button" class="btn btn-primary">내가 쓴 글 보기</button></a>
	</div>
	<!-- Button trigger modal -->
<button type="button" id="btn1" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  회원탈퇴
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">회원탈퇴창</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="memberDelete.do"><input type="text" id="id" name="id" onclick="" placeholder="아이디를 입력해주세요" value="" /><br/>
        <input type="text" id="pw" name="pw" onclick="" placeholder="패스워드를 입력해주세요" value="" />
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-danger" id="btn2" value="회원탈퇴" /></form>
      </div>
    </div>
  </div>
</div>
    
  </body>
</html>