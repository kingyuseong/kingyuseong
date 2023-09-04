$(function(){
		
			$("#btn2").on("click", function(){
								
			alert('상담일정이 삭제되었습니다!');
								
         $('#scheduleData1').submit();
         
         setTimeout(function() {
             window.opener.location.href = "redirect:/SdsReserve.do";
             window.close();
          }, 5);

      });				
			});