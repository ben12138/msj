
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

$(function () {

    getUserSessionStorage();
    $("#birthday").attr("max",new Date());
    if(sessionPhoneNum == "null"){
        $('#phone_num').val("");
    }else{
        $('#phone_num').val(sessionPhoneNum);
    }
    $('#email').val(sessionEmail);
    $("#headimage").attr("src",sessionHeadImage);
    $("#showimage").attr("src",sessionHeadImage);
    $("#nickname").val(sessionNickName);
    $('#introduction').val(sessionIntroduction);
    $('#company').val(sessionCompany);
    $("#birthday").val(sessionBirthday);
    //给birthday设置时间限制
    var nowTime = new Date();
    var nowYear = nowTime.getFullYear();
    var nowMonth = nowTime.getMonth()+1;
    var nowDay = nowTime.getDate();
    var maxTime = nowYear+"-"+nowMonth+"-"+nowDay;
    document.getElementById("birthday").max = maxTime;
    //给email赋值
    $("#email").val(sessionEmail);
    var userId = sessionStorage.getItem("userid");
    //点击回到顶部
    $('.totop').click(function () {

        $('html,body').animate({scrollTop: '0px'}, 800);
    });
    $("#next").click(function () {
        $(window).attr('location','index.html');
    });
    $("#post").click(function () {
        $(".nicknameerror").text("");
        var nickname = $("#nickname").val();
        var sex = $("input[name='sex']:checked").val();
        var headimage = sessionHeadImage;
        alert(headimage);
        var phoneNum = $("#phone_num").val();
        var email = $("#email").val();
        var birthday = $("#birthday").val();
        var birth = new Date(birthday);
        var company = $("#company").val();
        var introduction = $("#introduction").val();
        var state = sessionState;
        var authority = sessionAuthority;
        if(nickname == ""){
            $(".nicknameerror").text("用户名不不能为空");
            return ;
        }
        /**
         * http://localhost:8080/updateUserInf.do?userId=111&nickName=saa&sex=1
         * &headImage=http://106.15.194.192:8080/KitchenServer/headimage/13151567657@163.com.png
         * &phoneNum=1111&email=111&company&introduction=111&state=1&authorityId=1
         */
        $.ajax({
            url:'/updateUserInf.do',
            dataType:'json',
            type:'POST',
            async:true,
            data:{userId:userId,nickName:nickname,sex:sex,headImage:headimage,email:email,company:company,phoneNum:phoneNum,
                introduction:introduction,state:state,authorityId:authority,year:birth.getYear(),month:birth.getMonth(),day:birth.getDate()},
            success:function (data) {
                var result = eval(data);
                if(result.code == 200){
                    saveUserSessionStorage(sessionUserId,nickname,sex,headimage,phoneNum,email,birthday,company,introduction,state,authority);
                    $(window).attr('location','index.html');
                }else{
                    alert("更新失败，请稍后重试");
                }
            },error:function (data) {

            }
        });
    });

    //给更换头像增加点击事件
    $("#headimageurl").change(function () {
        // var selectedFile = document.getElementById("headimageurl").files[0];
        // alert($("#headimageurl").files[0].getAsDataURL());

        var path,clip = $("#showimage"),FileReader = window.FileReader;
            if (FileReader) {//chrome浏览器处理
                var reader = new FileReader(), file = this.files[0];
                reader.onload = function (e) {
                    clip.attr("src", e.target.result);//这里是把图片转成64位数据存入<img>中的src里
                };
                reader.readAsDataURL(file);
                var formData = new FormData();
                formData.append("file", file);
                $.ajax({
                    url: '/upload.do',
                    dataType: 'json',
                    type: 'POST',
                    async: true,
                    contentType: false,
                    processData: false,
                    data: formData,
                    success: function (data) {
                        sessionHeadImage="http://localhost:8080/headimage/"+sessionUserId+".png";
                        $("#headimage").attr("src",sessionHeadImage);
                        saveUserSessionStorage(sessionUserId,sessionNickName,sessionSex,sessionHeadImage,sessionPhoneNum,sessionEmail,sessionBirthday,sessionCompany,sessionIntroduction,sessionState,sessionAuthority);
                    }, error: function (data) {
                        sessionHeadImage="http://localhost:8080/headimage/"+sessionUserId+".png";
                        $("#headimage").attr("src",sessionHeadImage);
                        saveUserSessionStorage(sessionUserId,sessionNickName,sessionSex,sessionHeadImage,sessionPhoneNum,sessionEmail,sessionBirthday,sessionCompany,sessionIntroduction,sessionState,sessionAuthority);
                    }
                    //这里需要延迟一下，否则无法放入文本框内
                    //setTimeout("showchange()",1000);
                })
            }
            else {//其他浏览器处理，火狐在这里就不写出来了，网上资料很多
                path = $(this).val();
                if (/"\w\W"/.test(path)) {
                    path = path.slice(1,-1);
                }
                clip.attr("src",path);
            }


        // var selectedFile = $("#headimageurl").get(0).files[0];
        // var formData = new FormData();
        // formData.append("file", document.getElementById("headimageurl").files[0]);
        // $.ajax({
        //     url:'/upload/headimage',
        //     dataType:'json',
        //     type:'POST',
        //     async:true,
        //     contentType: false,
        //     processData: false,
        //     data:formData,
        //     success:function(data){
        //         var result = eval(data);
        //         alert(result.code);
        //     },error:function(data){
        //
        //     }
        // });
        // $("#showimage").attr("src",$("#headimageurl").val());
    });
});
//从本地读取用户信息
function getUserSessionStorage(){
    sessionUserId = sessionStorage.getItem("userid");
    sessionEmail = sessionStorage.getItem("email");
    sessionAuthority = sessionStorage.getItem("authority");
    sessionState = sessionStorage.getItem("state");
    sessionEmail = sessionStorage.getItem("email");
    sessionPhoneNum = sessionStorage.getItem("phone_num");
    sessionIntroduction = sessionStorage.getItem("introduction");
    sessionCompany = sessionStorage.getItem("company");
    sessionHeadImage = sessionStorage.getItem("headimage");
    sessionNickName = sessionStorage.getItem("nickname");
    sessionSex = sessionStorage.getItem("sex");
    sessionBirthday = sessionStorage.getItem("birthday");
}
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