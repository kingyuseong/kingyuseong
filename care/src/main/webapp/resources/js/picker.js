  $(function(){
    jQuery('#datetimepicker').datetimepicker();
    jQuery('#datetimepicker1').datetimepicker();

  })
$(function() {
$( "#datetimepicker" ).datetimepicker({ minDate: 0});
$( "#datetimepicker1" ).datetimepicker({ minDate: 0});
});

$(function() {
   // datetimepicker 설정
    $('#datetimepicker').datetimepicker({
        format: 'Y-m-d H:i',
        onChangeDateTime: function(selected) {
            $('#datetimepicker1').datetimepicker('setOptions', {
                minDate: selected, // 시작날짜 이후의 날짜만 선택 가능
                value: selected,   // 선택한 날짜로 설정
            });
        }
    });

    $('#datetimepicker1').datetimepicker({
        format: 'Y-m-d H:i',
    });



});