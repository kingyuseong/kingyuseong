<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
        <title>로그인</title>  
        
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/login.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../js_file/js.js"></script>    
       <!-- <link rel="stylesheet" href="style.css">-->

       
    </head>
    <body>
   
        <div class="wrap">
            <div class="form-wrap">
                <div class="button-wrap">
                    <div id="btn"></div>
                    <button type="button" class="togglebtn" onclick="login()">회원</button>
                    <button type="button" class="togglebtn" onclick="register()">상담사</button>
                </div>
                <form id="getLogin" action="login.do" class="input-group" method="post">
                    <input type="text" name="id" class="input-field" placeholder="ID" value="" required="">
                    <input type="password" name="pw" class="input-field" placeholder="PASSWORD" value="" required="">
                    <button class="submit">Login</button>
                    <span class="find"><a href="fid.do">아이디찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="fpw.do">비밀번호찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="signup.do">회원가입</a></span>                 
                </form>
                <form id="register" action="sdslogin.do" class="input-group" method="post">
                    <input type="text" name="sdsid" class="input-field" placeholder="ID" required="">
                    <input type="password" name="sdspw" class="input-field" placeholder="PASSWORD" required="">
                    <button class="submit">Login</button>
                    <span class="find"><a href="sdsfid.do">아이디찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="sdsfpw.do">비밀번호찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="sdssignup.do">회원가입</a></span> 
                </form>
            </div>
       </div>
        <script>
            var x = document.getElementById("getLogin");
            var y = document.getElementById("register");
            var z = document.getElementById("btn");
            function login(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }
            function register(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
            }
        </script>
    
 </body></html>