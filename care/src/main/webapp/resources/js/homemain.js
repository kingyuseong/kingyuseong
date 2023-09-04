function fakeLoad(){
  
  var animate  = $(".animate").addClass("run");
  var distance = $(".content").offset().top;    
  var timer    = setTimeout(function(){
    $(".loader").fadeOut(250);
    /*Replace .loader with .intro to hide introduction. Be sure to make fadeOut time longer*/
    $('html,body').animate({
      scrollTop: distance
    }, 2300);
  }, 4000);
  
}

$(document).ready(function(){
  fakeLoad();
});