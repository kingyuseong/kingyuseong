<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>업무 대화 퀴즈</title>
    <link type='text/css' rel='stylesheet' href='stylesheet.css'/>
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open Sans"/>
     <link rel="stylesheet" href="resources/css/daily.css" />
  </head>
  <body>
   <!-- Main page -->
        <div class="main">
          <!-- Number of Question  -->
          <div class="wrapper" id="pages">
            <span id="quizNumber">1</span><span>/10</span>
          </div>

          <!-- Quiz Question -->
          <div class="quiz-questions" id="display-area">
            <p id="question"></p>
            <ul id="answer">
            </ul>

            <div id="quiz-results">
              <button type="button" name="button" class="submit" id="submit">제출</button>
            </div>
          </div>

        </div>

        <canvas id="canvas"></canvas>

    <script type='text/javascript' src='https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
    <script type="text/javascript" src='questions.json'></script>
    <script type='text/javascript' src='jsquiz.js'></script>
    <script src="resources/js/daily.js"></script>
  </body>
</html>