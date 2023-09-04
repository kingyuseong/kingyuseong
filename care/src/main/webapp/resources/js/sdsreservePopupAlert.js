$(function(){
		
			$("#btn").on("click", function(){
				if($("#memcode").val()==""){
					alert("회원번호를 입력해주세요.");
					$("#memcode").focus();
					return false;
				}
				if($("#cate").val()==""){
					alert("상담분류를 선택해주세요.");
					$("#cate").focus();
					return false;
				}
				if($("#title").val()==""){
					alert("일정을 입력해주세요.");
					$("#title").focus();
					return false;
				}
				if($("#datetimepicker").val()==""){
					alert("시작날짜를 선택해주세요.");
					$("#datetimepicker").focus();
					return false;
				}
				if($("#datetimepicker1").val()==""){
					alert("종료날짜를 선택해주세요.");
					$("#datetimepicker1").focus();
					return false;
				}
				
			alert('상담일정이 입력 또는 수정되었습니다!');
			
			
		
         $('#scheduleData').submit();
         
         setTimeout(function() {
             window.opener.location.href = "redirect:/SdsReserve.do";
             window.close();
          }, 5);

      });				
			});
				
	
			
	
		
		