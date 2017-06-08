<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/import/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>P2P发标系统-登录</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <%@ include file="/WEB-INF/import/head.jsp"%>
    <script src="${ctx}/static/pagejs/login.js${timeStyle}"></script>
    <style type="text/css">
        .login_error{color: red}
    </style>
</head>
<body class="hold-transition" style="overflow: hidden">
<div class="login-page">
    <div class="login-box">
        <div class="login-system-name" style="left:11%;">P2P发标系统</div>
        <!--<div class="login-left-body">
            <img src="${ctx}/static/images/login-left.png" alt="">
        </div>-->
        <div class="login-box-body">
            <div class="login-head">
                用户登录
            </div>
            <div class="login-body-content">
                <div class="login-item">
                    <div class="login-item-left">账号名：</div>
                    <div class="login-item-right">
                        <input type="text"  placeholder="请输入账号" id="username" name="username" value="">
                    </div>
                </div>
                <div class="login-item">
                    <div class="login-item-left">密码：</div>
                    <div class="login-item-right">
                        <input type="password"  placeholder="请输入密码" name="password" id="password">
                    </div>
                </div>
                <div class="login-item">
                    <div class="login-item-left">机构代码：</div>
                    <div class="login-item-right">
                        <input type="text" placeholder="请输入机构代码" name="domain" id="domain" >
                    </div>
                </div>
                <div class="login-item">
                    <div class="login-item-left">验证码：</div>
                    <div class="login-item-right login-sms-input">
                        <input type="text"  placeholder="请输入验证码" id="smscode" name="smscode">
                    </div>
                    <input type="button" class="btn login-sms-btn" id="smsCodeBtn" value="获取验证码">
                </div>
                <div class="login-item">
                    <div class="login-item-left"></div>
                    <div class="login-item-right">
                        <label class="login-item-label checkbox-custom">
                            <input type="checkbox" id="userNameCheck">
                            <div class="checkbox-icon"></div>
                            <span>记住账号</span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="login-error" id="loginError">
            </div>
            <div  id="submitBtn" class="login-btn">登录</div>
        </div>
    </div>
    <div class="login-body-left">
    </div>
</div>
</body>
</html>

