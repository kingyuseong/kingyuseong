$("#name").blur(function(){
    	var sm_name = $("#name").val();
    	if(sm_name == "" || sm_name.length < 2){
    		$(".successNameChk").text("이름은 2자 이상 8자 이하로 설정해주세요 :)");
			$(".successNameChk").css("color", "red");
			$("#nameDoubleChk").val("false");
    	}else{
    		$.ajax({
				url : '${pageContext.request.contextPath}/nameCheck?sm_name='+ sm_name,
				type : 'post',
				cache : false,
				success : function(data) {
					if (data == 0) {
						$(".successNameChk").text("사용가능한 이름입니다.");
						$(".successNameChk").css("color", "green");
						$("#nameDoubleChk").val("true");
					} else {
						$(".successNameChk").text("사용중인 이름입니다 :p");
						$(".successNameChk").css("color", "red");
						$("#nameDoubleChk").val("false");
					}
				}, error : function() {
					console.log("실패");
				}
			});
    	}
    });