/**
 * Created by benrui on 2017/8/31.
 */

var sessionUserId;
var sessionNickName;
var sessionSex;
var sessionHeadImage;
var sessionPhoneNum;
var sessionEmail;
var sessionBirthday;
var sessionCompany;
var sessionIntroduction;
var sessionState;
var sessionAuthority;

$(function(){

    var hasUser = getUserSessionStorage();
    if(hasUser){
        $("#headimage").attr("src",sessionHeadImage);
        $('#login').fadeOut(0);
        $('#register').fadeOut(0);
        $('#exit').css({"visibility":"visible"});
        $('#headimage').click(function () {
            $(window).attr('location','personal.html');
        });
    }

    $("#searchinput").focus(function(){
        $("#searchinput").animate({width:"300px"},1000);
    });
    $("#searchinput").blur(function(){
        $("#searchinput").animate({width:"200px"},1000);
    });
    var unslider = $('.banner').unslider({
        speed: 500,               // 动画的滚动速度，数字越大越慢
        delay: 8000,              //  每个滑块的停留时间
        complete: function() {},  //  每个滑块动画完成时调用的方法
        keys: true,               //  是否支持键盘
        dots: true,               //  是否显示翻页圆点
        fluid: true              //  支持响应式设计（有可能会影响到响应式）
    });

    // banner箭头部分
    $('.unslider-arrow').click(function() {
        var fn = this.className.split(' ')[1];
        unslider.data('unslider')[fn]();
    });
    $('.banner').hover(function(){
            $(this).toggleClass('hover');
        }
    );

    var showSpeed= 1000;
    $('.personal').fadeOut(0);
    $('#logindiv').fadeOut(0);
    $('#registerdiv').fadeOut(0);
    $("#backhidden").fadeOut(0);
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
    //头像点击事件
    $('#headimage').click(function () {

    });
    //点击登录弹出登录框
    $('#login').click(function () {
        $('#logindiv').fadeIn(showSpeed);
        //ajax方式加载页面
        htmlobj=$.ajax({url:'login.html',async:false});
        $('#logindiv').html(htmlobj.responseText);
        $("#indexbody").css({"scroll":"no","overflow-x":"hidden","overflow-y":"hidden"});
        $("#backhidden").fadeIn(showSpeed);
    });
    //点击注册按钮
    $('#register').click(function(){
        $('#registerdiv').fadeIn(showSpeed);
        //ajax方式加载页面
        htmlobj=$.ajax({url:'register.html',async:false});
        $('#registerdiv').html(htmlobj.responseText);
        $("#indexbody").css({"scroll":"no","overflow-x":"hidden","overflow-y":"hidden"});
        $("#backhidden").fadeIn(showSpeed);
    });

    //退出登录按钮
    $('#exit').click(function () {
        $("#headimage").attr("src","/images/default_personal_image.png");
        $('#exit').css({"visibility":"hidden"});
        $('#login').fadeIn(0);
        $('#register').fadeIn(0);
        $.ajax({
            url:'/exit.do',
            type:'POST',
            async:true,
            success:function (data) {
                var result = eval(data);
                if(result.code == 200){
                    $("#headimage").attr("src","/images/default_personal_image.png");
                    $('#exit').css({"visibility":"hidden"});
                    $('#login').fadeIn(0);
                    $('#register').fadeIn(0);
                }
            }
        });
    });
});
//从本地读取用户信息
function getUserSessionStorage(){
    sessionUserId = sessionStorage.getItem("userid");
    if(sessionUserId == null){
        return false;
    }
    sessionHeadImage = sessionStorage.getItem("headimage");
    return true;
}