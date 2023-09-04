$(function(){
$("#btn1").on("click", function() {
	alert("탈퇴창입니다. 정말로 진행할지 고민하고 진행해주시기 바랍니다.");
});

$("#btn2").on("click", function() {
	if($("#id").val()==""){
					alert("아이디를 입력해주세요.");
					$("#id").focus();
					return false;
				}
	
	if($("#pw").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#pw").focus();
					return false;
				}

	alert("탈퇴가 완료되었습니다. 이용해주셔서 감사합니다!");
});

});