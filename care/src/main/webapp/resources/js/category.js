$("#goo").blur(function () {
    var goo = $("#goo").val();

    // 동을 초기화
    $("#dong").empty();
    $("#dong").append("<option value='선택' selected>선택하세요</option>");

    $.ajax({
        url: 'counseling_center.do?reggooname=' + goo,
        type: "GET",
        cache: false,
        success: function (data) {
            $("#dong").empty(); // 기존 코드에서 이동한 위치
            $("#dong").append("<option value='선택' selected>선택하세요</option>");

            for (var i = 0; i < data.length; i++) {
                $("#dong").append("<option>" + data[i].regname + "</option>");
            }
        },
        error: function (data) {
            alert("에러 !");
        }
    });
});

function searchStores() {
    var regname = $("#dong").val();

    // 매장 정보 초기화
    $("#store_info").empty();

    $.ajax({
        url: 'counseling_centerC.do?regname=' + regname,
        type: "GET",
        cache: false,
        success: function (data) {
            $("#store_info").empty(); // 기존 코드에서 이동한 위치

            for (var i = 0; i < data.length; i++) {
                var storeInfo = `
                    <div class="full padding_infor_info" style="padding: 15px 35px 35px 35px">
                        <div class="mail-box">
                            <aside class="sm-side" style="width: 30%;">
                                <div class="user-head">
                                    <div id="testimonial_slider" class="carousel slide" data-ride="carousel">
                                        <div class="item carousel-item active">
                                            <div class="img-box" style="width: 400px; height: 400px;">
                                                <img src="${data[i].clinicimg}" alt="Store Image">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </aside>
                            <aside class="lg-side" style="background: #f6f6f6; position: relative;">
                                <div class="inbox-head">
                                    <h3></h3>
                                    <div class="bottom_list">
                                        <ul>
                                            <li><h1>매장명 : ${data[i].clinicname}</h1></li>
                                            <li><h1>전화번호 : ${data[i].clinictel}</h1></li>
                                            <li>
                                               <h1>주소 : ${data[i].clinicaddr}
                                                  <button type="button" class="btn btn-xs detail_button sdmap-button" style="margin-bottom: 5px;">지도</button>
                                               </h1>
                                            </li>
                                            <div>
                                            
                                            </div>
                                            <div class="right_button float-left">
                                                <div class="map-container" style="width: 800px; height: 250px; display: none;"></div>
                                            </div>
                                            
                                        </div>
                                    </div>
                                    <img src="resources/images/flower.png" class="flower-image"/>
                                </div>
                            </aside>
                        </div>
                    </div>`;

                $("#store_info").append(storeInfo);
            }
        },
        error: function (data) {
            alert("에러 !");
        }
    });
}

$(document).ready(function () {
    $(document).on("click", ".sdmap-button", function () {
        var storeAddress = $(this).closest(".bottom_list").find("h1:contains('주소')").text().replace("주소 :", "").trim();

        if (!storeAddress) {
            return;
        }

        var mapContainer = $(this).closest(".bottom_list").find(".map-container")[0];
        var mapOption = {
            center: new kakao.maps.LatLng(37.566826, 126.9786567),
            level: 3
        };

        var map = new kakao.maps.Map(mapContainer, mapOption);

        var geocoder = new kakao.maps.services.Geocoder();

        geocoder.addressSearch(storeAddress, function (result, status) {
            if (status === kakao.maps.services.Status.OK) {
                var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: coords
                });

                map.setCenter(coords);
                mapContainer.style.display = 'block';
            }
        });
    });
});