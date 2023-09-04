fc=()=>{
  if( (document.querySelector(".ag").scrollHeight - document.querySelector(".ag").scrollTop) === document.querySelector(".ag").clientHeight ){
    // 스크롤 영역의 높이 - 현재 스크롤 위치 = div의 높이
    // 약관을 맨 아래까지 내렸다.. 라고 인정
    // checkbox에 있는 disabled 제거
    document.getElementById("ag").disabled=false;
  }
}

ac=()=>{
  if( (document.querySelector(".bg").scrollHeight - document.querySelector(".bg").scrollTop) === document.querySelector(".bg").clientHeight ){
    // 스크롤 영역의 높이 - 현재 스크롤 위치 = div의 높이
    // 약관을 맨 아래까지 내렸다.. 라고 인정
    // checkbox에 있는 disabled 제거
    document.getElementById("bg").disabled=false;
  }
}

bc=()=>{
  if( (document.querySelector(".cg").scrollHeight - document.querySelector(".cg").scrollTop) === document.querySelector(".cg").clientHeight ){
    // 스크롤 영역의 높이 - 현재 스크롤 위치 = div의 높이
    // 약관을 맨 아래까지 내렸다.. 라고 인정
    // checkbox에 있는 disabled 제거
    document.getElementById("cg").disabled=false;
  }
}

function turn() {
	
	window.opener.setAgreementStatus(true);
    window.close();
	
}


$('#chooseFile').bind('change', function () {
  var filename = $("#chooseFile").val();
  if (/^\s*$/.test(filename)) {
    $(".file-upload").removeClass('active');
    $("#noFile").text("No file chosen..."); 
  }
  else {
    $(".file-upload").addClass('active');
    $("#noFile").text(filename.replace("C:\\fakepath\\", "")); 
  }
});

