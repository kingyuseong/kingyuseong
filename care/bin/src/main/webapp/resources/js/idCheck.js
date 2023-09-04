$(function(){
$('#id').keyup(function(){
        // 로그인 프로세스 호출
        $.ajax({
            type: 'post',			// 전송방식
            async: true,			// 비동신통신
            url:'idCheck.do',		// **** 요청
            contentType:'application/x-www-form-urlencoded;charset=UTF-8',  // 한글
            //data: id="+$("#id").val(),        // 클라이언트에서 보내는 데이타
            data : { id : $("#id").val() },
            success:function(result){				// 성공하면 함수연결
            	//alert("resultData = "+result)
    			$('#idCheckResult').html(result);            	
    		}
        });
	})
	
$('#nick').keyup(function(){
        // 닉네임 프로세스 호출
        $.ajax({
            type: 'post',			// 전송방식
            async: true,			// 비동신통신
            url:'nickCheck.do',		// **** 요청
            contentType:'application/x-www-form-urlencoded;charset=UTF-8',  // 한글
            //data: nick="+$("#nick").val(),        // 클라이언트에서 보내는 데이타
            data : { nick : $("#nick").val() },
            success:function(result){				// 성공하면 함수연결
            	//alert("resultData = "+result)
    			$('#nickCheckResult').html(result);            	
    		}
        });
	})	
	
	})