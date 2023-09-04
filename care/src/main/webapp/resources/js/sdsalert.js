$(function(){
		
			$("#button").on("click", function(){
				if($("#sdsname").val()==""){
					alert("이름을 입력해주세요.");
					$("#sdsname").focus();
					return false;
				}
				if($("#sdsid").val()==""){
					alert("아이디를 입력해주세요.");
					$("#sdsid").focus();
					return false;
				}
				if($("#sdspw").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#sdspw").focus();
					return false;
				}
				if($("#sdspassCheck").val()==""){
					alert("비밀번호 확인란을 입력해주세요.");
					$("#sdspassCheck").focus();
					return false;
				}
				if($("#sdspassCheck").val()!=$("#sdspw").val()){
					alert("비밀번호가 일치하지 않습니다.");
					$("#sdspassCheck").focus();
					return false;
				}
				if($("#sdstel").val()==""){
					alert("전화번호를 입력해주세요.");
					$("#sdstel").focus();
					return false;
				}
				
				
					alert('가입을 축하합니다!');
			//		window.close();
					document.sdsuserinput.submit();
				
			});
				
	
			
		});