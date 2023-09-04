<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <script src="../js/check.js"></script>   --%>      
<link rel="stylesheet" href="resources/css/signup.css">
<%-- <script type="text/javascript" src="././resources/js/signup.js"></script> --%>
<script type="text/javascript" src="resources/js/signupp.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 주소api -->
<script type="text/javascript" src="resources/js/sdsjuso.js"></script>
<!-- 경고창 -->
<script type="text/javascript" src="resources/js/sdsalert.js"></script>
<!-- 아이디 중복 알림 -->
<script type="text/javascript" src="resources/js/sdsidCheck.js"></script>
<!-- 라디오 버튼 성별 가져오기 -->
<script type="text/javascript" src="resources/js/sdsradio.js"></script>
<script type="text/javascript">
//1번 첨부파일 미리보기
  function readURL1(obj) {
      let reader = new FileReader();
      if(!obj.files.length) {   
          return;
      }
      reader.readAsDataURL(obj.files[0]);
      reader.onload = function (e) {
          let img = $('<img class="previewImg" />');
          $(img).attr('src', e.target.result);
          $('#previewDiv1').append(img);
      }
  }
</script>
</head>
<body>
<h2>상담사가입을 위해<br>정보를 입력해주세요.</h2>
    <div class="container">
            
          <form method="post" action="sdssaveMember.do" name="sdsuserinput" id="sdsuserinput" enctype="multipart/form-data">
   <div class="sign-up">
   <div class="info">
                <p class="label">이름</p>
                    <input type="text" class="insert" id="sdsname" name="sdsname" maxlength="8" title="8자 까지 입력"/>
               </div>
                <div class="info">
        <p class="label">전화번호</p>
        <input class="insert" type="text" placeholder="'-'를 포함시켜주세요" name="sdstel" id="sdstel" />
    </div>
    <div class="info">
        <p class="label" >주소</p>
        <!-- <input type="button" name="button" id="juso" value="주소"  onclick="sample4_execDaumPostcode()" /> -->
        <input class="insert" type="text" name="sdsaddr" id="sdsaddr" onclick="sample4_execDaumPostcode()" />
        <p class="label" >상세주소</p>
        <input class="insert" type="text" name="sdsaddr" id="sdsaddr" />
    </div>
    <div class="info">
       <p class="label">자격증</p>
       <input class="insert" type="text" name="sdscard" id="sdscard"/>
   </div>                  
   <div class="info">
       <p class="label">아이디</p>
       <input class="sdsinsert" type="text" name="sdsid" id="sdsid"/>
       <span id="sdsidCheckResult" style="width:150px;color:red"></span>
   </div>            
   <div class="info">
      <p class="label">비밀번호</p>
      <input class="insert" type="password" name="sdspw" id="sdspw"/>
   </div>
   <div class="info">
      <p class="label">비밀번호 확인</p>
      <input class="insert" type="password" name="sdspassCheck" id="sdspassCheck"/>
   </div>
   <div id="ss" class="info">
      <p class="label" >성별</p>
      <input class="insert" type="hidden" name="sdssex" id="sdssex"  />
      <input id="sdssex" type="radio" name="gender" value="남자" class="radio" onclick="getGender(event);" /><label for="남자">남자</label><br/>
      <input id="sdssex" type="radio" name="gender" value="여자" class="radio" onclick="getGender(event);" /><label for="여자">여자</label>
   </div>
   <div class="info">
      <p class="label">닉네임</p>
      <input class="insert" type="text" name="sdsnick" id="sdsnick"/>
      <span id="sdsnickCheckResult" style="width:150px;color:red"></span>
   </div>         
   <div class="info">
      <p class="label">프로필사진</p>
      <input class="insert" type="file" name="file" id="file" onchange="readURL1(this)" />
                  <div id="previewDiv1"></div>
   </div>         
                <br><br>
                <input type="checkbox" id="check" class="agree" disabled>&nbsp 이용약관 개인정보 수집 및 정보이용에 동의합니다.
                    <br/><a onclick="pop()">동의하기</a>
                <div class="btns">
      <button type="submit" id="button" class="confirm" >회원가입</button>
    </div>
                <!-- 기능자체는 input의 타입을 button으로 하면 사용은 가능하지만, 굳이 button 태그를 사용하는 이유는 -->
                <!-- 커스터마이징이 button 태그가 더 용이하기 때문이다. -->
                <!-- <input type="button" value="가입하기"> -->
                </div>
                </form>
               
            </div>
</body>
</html>