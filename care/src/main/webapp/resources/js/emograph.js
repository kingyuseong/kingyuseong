$(function () { 	// 오류 메세지 : $ is not defined
    $.ajax({	// function오류떔에 jquery.min.js 연결하면 뜨는 오류 메세지 : $.ajax is not a function
        url: "https://www.naver.com/"
    })
})