$(function(){
    //回到顶部的滚动效果
    $(window).scroll(function () {
        if ($(window).scrollTop() >= 100) {
            $('.totop').fadeIn(300);

        } else {
            $('.totop').fadeOut(300);
        }
    });
    //点击回到顶部
    $('.totop').click(function () {
        $('html,body').animate({scrollTop: '0px'}, 800);
    });
    $("#searchinput").focus(function(){
        $("#searchinput").animate({width:"300px"},1000);
    });
    $("#searchinput").blur(function(){
        $("#searchinput").animate({width:"200px"},1000);
    });
});