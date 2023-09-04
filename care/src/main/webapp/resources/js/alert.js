$(function(){
		
			$("#button").on("click", function(){
				if($("#name").val()==""){
					alert("이름을 입력해주세요.");
					$("#name").focus();
					return false;
				}
				if($("#id").val()==""){
					alert("아이디를 입력해주세요.");
					$("#id").focus();
					return false;
				}
				if($("#pw").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
				}
				if($("#passCheck").val()==""){
					alert("비밀번호 확인란을 입력해주세요.");
					$("#passCheck").focus();
					return false;
				}
				if($("#passCheck").val()!=$("#pw").val()){
					alert("비밀번호가 일치하지 않습니다.");
					$("#passCheck").focus();
					return false;
				}
				if($("#tel").val()==""){
					alert("전화번호를 입력해주세요.");
					$("#tel").focus();
					return false;
				}
				
				
					alert('가입을 축하합니다!');
			//		window.close();
					document.userinput.submit();
				
			});
				
	
			
		});