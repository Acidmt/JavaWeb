 window.onload=function(){
    var left = $('#wrapper')[0].offsetLeft;
    if (left == 0) {
       $('#wrapper').offset({
          'left': 220
       });
       $(this).css('transform', 'rotate(450deg)');
       $('.headSculpture img').addClass('img');
       $('.headSculpture p').addClass('opacity');
       setTimeout(function () {
          $('.option ul>li').addClass('li');
       }, 600)

   }
   console.log("hello")
}

$(function () {
   // 侧边栏弹出
   $('button').click(function () {
      var left = $('#wrapper')[0].offsetLeft;
      if (left == 0) {
         $('#wrapper').offset({
            'left': 220
         });
         $(this).css('transform', 'rotate(450deg)');
         $('.headSculpture img').addClass('img');
         $('.headSculpture p').addClass('opacity');
         setTimeout(function () {
            $('.option ul>li').addClass('li');
         }, 600)
      } else {
         $('#wrapper').offset({
            'left': 0
         });
         $(this).css('transform', 'rotate(0deg)');
         setTimeout(function () {
            $('.headSculpture img').removeClass('img');
            $('.headSculpture p').removeClass('opacity');
            $('.option ul>li').removeClass('li');
         }, 300)
      }
   })


})