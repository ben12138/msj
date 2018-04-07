$(function () {

    $('.close').click(function () {
        $('#logindiv').fadeOut(1000);
        $("#backhidden").fadeOut(1000);
        $("#indexbody").css({"scroll":"yes","overflow-x":"visible","overflow-y":"visible"});
    });
    $('.loginbutton').click(function(){
        var username = $('#username').val();
        var password = $('#password').val();
        //对电子邮件的验证
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if(!myreg.test(username)){
            $("#usernameerror").html("请输入正确的邮箱格式");
            return ;
        }else{
            $("#usernameerror").html("&nbsp;&nbsp;&nbsp;");
        }
        if(password == null||password==""){
            $("#passworderror").html("请输入密码");
            return ;
        }else{
            $("#passworderror").html("&nbsp;&nbsp;&nbsp;");
        }
        $.ajax({
            url: '/login.do',
            type: 'POST',
            async: false,
            data:{userName:username,password:password},
            success: function (data) {
                var result = eval(data);
                var code = result.code;
                if(code==200){
                    //正确
                    var user = result.data;
                    $.ajax({
                        url:'/getUserInf.do/'+user.userId,
                        type:'POST',
                        async:true,
                        success:function (data) {
                            $('#logindiv').fadeOut(1000);
                            $("#backhidden").fadeOut(1000);
                            var uresult = eval(data);
                            var userInf = uresult.data;
                            $("#headimage").attr("src",userInf.headImage);
                            $("#headimage").click(function(){
                                $(window).attr('location','personal.html');
                            });
                            $("#indexbody").css({"scroll":"yes","overflow-x":"visible","overflow-y":"visible"});
                            $('#login').fadeOut(0);
                            $('#register').fadeOut(0);
                            $('#exit').css({"visibility":"visible"});
                            saveUserSessionStorage(userInf.userId,userInf.nickName,userInf.sex,userInf.headImage,
                                userInf.phoneNum,userInf.email,userInf.birthday,userInf.company,userInf.introduction,
                                userInf.state,userInf.authorityId);
                        }
                    });
                }else if(code==201){
                    //用户名错误
                    $("#usernameerror").html("该用户名不存在");
                }else if(code==202){
                    //密码错误
                    $("#passworderror").html("密码错误");
                }
            }
        });
    });
});

function saveUserSessionStorage(userid,nickname,sex,headimage,phone_num,email,birthday,company,introduction,state,authority) {
    sessionStorage.setItem("userid",userid);
    sessionStorage.setItem("nickname",nickname);
    sessionStorage.setItem("sex",sex);
    sessionStorage.setItem("headimage",headimage);
    sessionStorage.setItem("phone_num",phone_num);
    sessionStorage.setItem("email",email);
    sessionStorage.setItem("birthday",birthday);
    // var date = new Date(birthday);
    // alert(date.getFullYear()+":"+date.getMonth()+":"+date.getDate());
    sessionStorage.setItem("company",company);
    sessionStorage.setItem("introduction",introduction);
    sessionStorage.setItem("state",state);
    sessionStorage.setItem("authority",authority);
}