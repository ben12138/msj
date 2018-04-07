$(function(){

    //是否能注册的标志
    var usernameflag = false;
    var passwordflag = false;
    var confirmflag = false;
    var vertifyflag = true;

    $('.close').click(function () {
        $('#registerdiv').fadeOut(1000);
        $("#backhidden").fadeOut(1000);
        $("#indexbody").css({"scroll":"yes","overflow-x":"visible","overflow-y":"visible"});
    });

    $("#username").focus(function () {
        $("#usernameerror").html("&nbsp;&nbsp;&nbsp;");
    });
    $('#username').blur(function(){
        //当username文本框失去焦点的时候，发起对输入的用户名是否可用的判断
        var username = $('#username').val();
        //对电子邮件的验证
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if(username == null||username==""){
            $("#usernameerror").html("邮箱不能为空");
            usernameflag = false;
            return ;
        }else{
            $("#usernameerror").html("&nbsp;&nbsp;&nbsp;");
        }
        if(!myreg.test(username)) {
            $("#usernameerror").html("请输入正确的邮箱格式");
            usernameflag = false;
            return ;
        }else{
            $("#usernameerror").html("&nbsp;&nbsp;&nbsp;");
        }
        //使用ajax判断是否可用
        $.ajax({
            url:'/register.do/1/'+username.replace(/\./,"!"),
            type:'POST',
            async:false,
            success:function (data) {
                var result = eval(data);
                if(result.code == 200){
                    usernameflag = true;
                }else if(result.code == 230){
                    $("#usernameerror").html("用户名已被占用");
                    usernameflag = false;
                }
            }
        });
    });

    $('#password').focus(function () {
        $('#passworderror').html("&nbsp;&nbsp;&nbsp;");
    });
    $('#password').blur(function () {
        var password = $('#password').val();
        if(password == null || password == ""){
            $('#passworderror').html("密码不能为空");
            passwordflag = false;
            return;
        }else{
            $('#passworderror').html("&nbsp;&nbsp;&nbsp;");
            passwordflag = true;
        }
    });

    $('#confpassword').focus(function () {
        $('#confpassworderror').html("&nbsp;&nbsp;&nbsp;");
    });
    $('#confpassword').blur(function () {
        var confpassword = $('#confpassword').val();
        var password = $('#password').val();
        if(confpassword != password){
            $('#confpassworderror').html("两次输入的密码不一致");
            confirmflag = false;
            return ;
        }else{
            confirmflag = true;
            $('#confpassworderror').html("&nbsp;&nbsp;&nbsp;");
        }
    });

    $('#vertification').click(function getVerfication() {
        if (usernameflag && passwordflag && confirmflag) {
            $.ajax({
                url: '/register.do/2/' + $('#username').val().replace(/\./, "!"),
                type: 'POST',
                async: false,
                success: function (data) {
                    var result = eval(data);
                    if (result.code == 200) {
                        alert("验证码已发送至邮箱，二十分钟内有效");
                        $('#vertification').removeAttr("readOnly");
                        $('#vertification').css({"cursor": "auto"});
                        $('#vertification').attr("placeholder=\"验证码\"");
                        $('#vertification').unbind("click");
                        $('#vertify').css({"background": "rgb(229,102,78)"});
                        $('#vertify').hover(function () {
                            $('#vertify').css({"cursor": "pointer", "background": "rgb(240,102,100)"});
                        }, function () {
                            $('#vertify').css({"background": "rgb(229,102,78)"});
                        });
                        $('#vertify').click(function () {
                            $.ajax({
                                url:'/register.do/3/'+ $('#username').val().replace(/\./, "!")+'/'+$('#vertification').val(),
                                type:'POST',
                                async:false,
                                success:function (data) {
                                    var vresult = eval(data);
                                    if(vresult.code == 260){
                                        //验证失败
                                        $('#vertifyerror').html("验证失败");
                                        $('#vertification').attr("readOnly");
                                        $('#vertification').css({"cursor":"pointer"});
                                        $('#vertification').attr("placeholder=\"验证码获取\"");
                                        $('#vertification').onclick(getVerfication());
                                    }else if(vresult.code == 200){
                                        //验证成功
                                        $('#vertifyerror').html("&nbsp;&nbsp;&nbsp;");
                                        $('#vertify').css({"background": "gray"});
                                        $('#registerlogin').css({"background": "rgb(229,102,78)"});
                                        $('#vertify').removeAttr("click");
                                        $('#vertify').hover(function () {
                                            $('#vertify').css({"cursor": "auto", "background": "gray"});
                                        }, function () {
                                            $('#vertify').css({"background": "gray"});
                                        });
                                        $('#vertify').css({"cursor": "auto"});
                                        $('#registerlogin').hover(function () {
                                            $('#registerlogin').css({"cursor": "pointer", "background": "rgb(240,102,100)"});
                                        }, function () {
                                            $('#registerlogin').css({"background": "rgb(229,102,78)"});
                                        });
                                        $('#registerlogin').click(function(){
                                            $.ajax({
                                               url:'/register.do/4/'+$('#username').val().replace(/\./, "!")+'/'+$('#password').val(),
                                               type:'POST',
                                               async:false,
                                               success:function (data) {
                                                   var userResult = eval(data);
                                                   if(userResult.code == 200){
                                                       $(window).attr('location','personal.html');
                                                   }else{
                                                       alert("哎呀呀，出错了，请稍后重试");
                                                   }
                                               }
                                            });
                                        });
                                    }
                                }
                            });
                        });
                    } else {
                        alert("邮箱发送失败，请重试");
                    }
                }
            });
        }
    });
})
