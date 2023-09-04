$(function(){
$('#sdsid').keyup(function(){
        // 로그인 프로세스 호출
        $.ajax({
            type: 'post',			// 전송방식
            async: true,			// 비동신통신
            url:'sdsIdCheck.do',		// **** 요청
            contentType:'application/x-www-form-urlencoded;charset=UTF-8',  // 한글
            //data: sdsid="+$("#sdsid").val(),        // 클라이언트에서 보내는 데이타
            data : { sdsid : $("#sdsid").val() },
            success:function(sdsresult){				// 성공하면 함수연결
            	//alert("resultData = "+sdsresult)
    			$('#sdsidCheckResult').html(sdsresult);            	
    		}
        });
	})
	
$('#sdsnick').keyup(function(){
        // 닉네임 프로세스 호출
        $.ajax({
            type: 'post',			// 전송방식
            async: true,			// 비동신통신
            url:'sdsNickCheck.do',		// **** 요청
            contentType:'application/x-www-form-urlencoded;charset=UTF-8',  // 한글
            //data: sdsnick="+$("#sdsnick").val(),        // 클라이언트에서 보내는 데이타
            data : { sdsnick : $("#sdsnick").val() },
            success:function(sdsresult){				// 성공하면 함수연결
            	//alert("resultData = "+sdsresult)
    			$('#sdsnickCheckResult').html(sdsresult);            	
    		}
        });
	})	
	
	})