fetch(`https://api.openweathermap.org/data/2.5/weather?lat=37.5833&lon=127&appid=bc3647e9404a2e56397943aaf57e3b3e`)
    .then(res => res.json()) // .json() 메서드는 JSON 응답을 JavaScript 객체 리터럴로 구문분석합니다.
    .then(data => {
        if (data.weather[0].main == 'Clouds') { // main : 기본 // description: 상세
            document.getElementById('weather').value = '구름';
        } else if (data.weather[0].main == 'Snow') {
            document.getElementById('weather').value = '눈';
        } else if (data.weather[0].main == 'Rain') {
            document.getElementById('weather').value = '비';
        } else if (data.weather[0].main == 'Drizzle') {
            document.getElementById('weather').value = '이슬비';
        } else if (data.weather[0].main == 'Clear') {
            document.getElementById('weather').value = '맑음';
        } else if (data.weather[0].main == 'Thunderstorm') {
            document.getElementById('weather').value = '뇌우';
        } else if (data.weather[0].main == 'Squall') {
            document.getElementById('weather').value = '돌풍';
        } else if (data.weather[0].main == 'Tornado') {
            document.getElementById('weather').value = '폭풍';
        } else if (data.weather[0].main == 'Dust' || data.weather[0].main == 'Sand') {
            document.getElementById('weather').value = '황사';
        } else if (data.weather[0].main == 'Smoke') {
            document.getElementById('weather').value = '연기'; // 화재로 인한 연기
        } else {
            document.getElementById('weather').value = "안개";
        }
    })
    .catch(err => {
        console.error(err);
        document.getElementById('weather').value = "날씨 정보를 가져오는 데 실패했습니다.";
    });
//https://api.openweathermap.org/data/2.5/weather?lat=37.5833&lon=127&appid=bc3647e9404a2e56397943aaf57e3b3e&lang=kr
//&lang=kr 추기하면 번역 제공되는데 description만 번역되고 이상하게 번역됨
// api : openweathermap

// 이거 날짜 가져오는거
function notedate() {
    var today = new Date();

    var year = today.getFullYear();
    var month = ('0' + (today.getMonth() + 1)).slice(-2);
    var day = ('0' + today.getDate()).slice(-2);

    var dateString = year + '년 ' + month + '월' + day +"일";

    document.getElementById('notedate').value=dateString;

} 

document.addEventListener('DOMContentLoaded', function () {
    notedate();
});