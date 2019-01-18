$(function() {
      $('.banner').hide();
      $(window).scroll(function() {
            var scroll = $(window).scrollTop();
            if (scroll == 0) {
                  $('.banner').hide();
                } else {
                  $('.banner').show();
                }
          });
});

$(function() {
    $('#div-social-nav-footer').show();
    $(window).scroll(function() {
        var scroll = $(window).scrollTop();
        if (scroll == 0) {
            $('#div-social-nav-footer').show();
        } else {
            $('#div-social-nav-footer').hide();
        }
    });
});

$(function() {
    $(window).scroll(function() {
        var scrollTop = $(window).scrollTop();
        if (scrollTop != 0) {
            $('#div-banner').stop().animate({'opacity': '0.9'}, 400);
        }
        else{
            $('#div-banner').stop().animate({'opacity': '1'}, 400);
        }
    });

    $('#div-banner').hover(
        function (e) {
            var scrollTop = $(window).scrollTop();
            if(scrollTop != 0){
                $('#div-banner').stop().animate({'opacity':'0.9'},400);
            }
            else
                $('#div-banner').stop().animate({'opacity':'1'},400);
        //         // $('#div-banner').hide();
        }
    );
});


