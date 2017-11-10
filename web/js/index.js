$(function () {
    var $registerBox = $('#registerBox');
    var $loginBox = $('#loginBox');
    //切换到注册面板
    $loginBox.find('a').on('click', function(){
        $registerBox.show();
        $loginBox.hide();
    });
    //切换到登录面板
    $registerBox.find('a').on('click', function () {
        $loginBox.show();
        $registerBox.hide();
    });

    $loginBox.find('button').on('click', function () {
        $.ajax({
            type : "post",
            url : "/blog/login/login",
            dataType : "json",
            data : {
                username:$loginBox.find('[name = "username"]').val(),
                password:$loginBox.find('[name = "password"]').val()
            },
            success : function (result) {

                $("#error2").html(result.Message.message);
                if (result.Message.success){
                    setTimeout(function () {
                        window.location.reload();
                    },2000);
                }
            }
        });
    });
    $registerBox.find('button').on('click', function () {
        $.ajax({
            type : "post",
            url : "/blog/login/register",
            dataType : "json",
            data : {
                username:$registerBox.find('[name = "username"]').val(),
                password:$registerBox.find('[name = "password"]').val(),
                repassword:$registerBox.find('[name = "repassword"]').val()
            },
            success : function (result) {

                $("#error1").html(result.Message.message);
                if (result.Message.success){
                    setTimeout(function () {
                        $loginBox.show();
                        $registerBox.hide();
                    },1000);
                }
            }
        })
    });

    $("#logout").click(function () {
        $.ajax({
            url : "/blog/login/logout",
            type : 'get',
            success : function (result) {
                if(result.Message.success){
                    window.location.reload();
                }
            }
        });
    });
})