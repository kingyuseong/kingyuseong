<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
</head>
<body>
<input id="datetimepicker" type="text" >
<input type="date" />
<input type="time">
</body>
<!-- this should go after your </body> -->
<link rel="stylesheet" type="text/css" href="/jquery.datetimepicker.css"/ >
<script src="/jquery.js"></script>
<script src="/build/jquery.datetimepicker.full.min.js"></script>
<script type="text/javascript">
jQuery('#datetimepicker').datetimepicker();
</script>
</html>