$(function () {
    if (window != top)
        top.location.href = location.href;
    if ($.cookie("riskUser") == "true") {
        $('#userNameCheck').prop('checked','checked');
        $("#username").val($.cookie("riskname"));
    }
    $("#smsCodeBtn").on('click',smsSend);
    $('#submitBtn').on('click',submitLogin);
});

//记住用户名
function save() {
    if ($("#userNameCheck").is(':checked')) {
        var username = $("#username").val();
        $.cookie("riskUser", "true", {expires: 365});
        $.cookie("riskname", username, {expires: 365});
    }
    else {
        $.cookie("riskUser", "false", {expire: -1});
        $.cookie("username", "", {expires: -1});
    }
};

function submitLogin() {
	$.cookie("www_root", web_root, {expires: 365});
    isSuccess = true;
    clearLogin();
    validLogin()
    if (isSuccess) {
        save();
        var username = $("input[name='username']").val();

        var password = $("input[name='password']").val();
        var smscode = $("input[name='smscode']").val();
        var domain = $("input[name='domain']").val();
        worf.ajax({
            url: web_root + '/login',
            data: {
                'username': username,
                'password': password,
                'domain': domain,
                'smsCode': smscode
            },
            success: function (data) {
                if (data.status == "1") {
                    window.location = web_root + "/index";
                } else {
                    $('#smscode-error-msg').html(data.message);
                }
            },
            beforeSend:function () {
                $('#submitBtn').attr('disabled','disabled');
                $('#submitBtn').html('登录中...')
            },
            complete:function () {
                $('#submitBtn').removeAttr('disabled');
                $('#submitBtn').html('登录')
            }
        },function (message) {
            $('#loginError').html(message?message:"登录失败");
            return false;
        })
    }
}

function smsSend() {
    var currentDom = this;
    isSuccess = true;
    clearLogin();
    validSms();
    if (!isSuccess) {
        return;
    }

    var username = $("#username").val().trim();
    $(currentDom).prop("disabled", true);
    $(currentDom).val("请稍后(60秒)");
    var remainNum = 59;

    function runInterval() {
        remainNum--;
        if (remainNum <= 0) {
            if (timer) {
                window.clearInterval(timer);
            }
            $(currentDom).attr("disabled", false);
            $(currentDom).val("获取验证码");
        } else {
            $(currentDom).val("请稍后(" + remainNum + "秒)");
        }
    }

    var username = $("input[name='username']").val();
    var password = $("input[name='password']").val();
    var domain = $("input[name='domain']").val();
    worf.ajax({
        url: web_root + '/loginSendSmsCode',
        data: {'username': username, 'password': password, 'domain': domain},
        success: function (data) {
            timer = window.setInterval(runInterval, 1000);
            $("#smscode").val(data.data);
        },
        error: function () {
            $('#loginError').html("发送验证码失败");
            resetTimer(currentDom);
            return false;
        },
        beforeSend:function () {
            $(currentDom).val('验证码获取中...');
            $(currentDom).attr('disabled','disabled')
        }
    },function (message) {
        $('#loginError').html(message?message:"发送验证码失败");
        resetTimer(currentDom);
        return false;
    })

}
var timer;
function resetTimer(currentDom) {
    if (timer) {
        window.clearInterval(timer);
    }
    $(currentDom).val("获取验证码");
    $(currentDom).prop("disabled", false);
}

var isSuccess;
function validSms() {
    if ($("#username").val() == null || $("#username").val() == '' || $("#username").val().trim() == '') {
        $('#loginError').html("请输入用户名");
        $('#username').focus();
        isSuccess = false;
        return;
    }
    if ($("#password").val() == null || $("#password").val() == '' || $("#password").val().trim() == '') {
        $('#loginError').html("请输入密码！");
        $("#password").focus();
        isSuccess = false;
        return;
    }
    var length = $("#password").val().length;
    if (!/^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\(\)])+$)([^(0-9a-zA-Z)]|[\(\)]|[a-zA-Z]|[0-9]){6,20}$/.test($("#password").val())) {
        $('#loginError').html("请输入6-20位字母/数字/符号的任意组合密码");
        $("#password").focus();
        isSuccess = false;
        return;
    }
    var domain = $("#domain").val();
    if ($("#domain").val() == null || $("#domain").val() == '' || $("#domain").val().trim() == '') {
        $('#loginError').html("请输入机构代码");
        $("#domain").focus();
        isSuccess = false;
        return;
    }
    return true;
}
function validLogin() {
    if(validSms()){
        var smscode = $("#smscode").val();
        if (!/^[0-9]{6}$/.test(smscode)) {
            isSuccess = false;
            $('#loginError').html("请输入六位短信验证码");
            return;
        }
    }

}
function clearLogin() {
    $(".login_error").html("");
}
