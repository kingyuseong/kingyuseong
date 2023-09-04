$("#id").blur(function(){
       var sm_id = $("#id").val();
       if(sm_id == "" || sm_id.length < 2){
          $(".insert").text("아이디는 2자 이상 8자 이하로 설정해주세요 :)");
         $(".insert").css("color", "red");
         $("#idCheckResult").val("false");
       }else{
          $.ajax({
            url : '${pageContext.request.contextPath}/nickcheck?sm_id='+ sm_id,
            type : 'post',
            cache : false,
            success : function(data) {
               if (data == 0) {
                  $(".insert").text("사용가능한 아이디입니다.");
                  $(".insert").css("color", "green");
                  $("#idCheckResult").val("true");
               } else {
                  $(".insert").text("사용중인 아이디입니다 :p");
                  $(".insert").css("color", "red");
                  $("#idCheckResult").val("false");
               }
            }, error : function() {
               console.log("실패");
            }
         });
       }
    });
    
   