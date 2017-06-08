<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/import/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>乐位云风控系统-登录</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <%@ include file="/WEB-INF/import/head.jsp"%>
    <script src="${ctx}/static/pagejs/login.js${timeStyle}"></script>
    <style type="text/css">
        .login-checkbox-custom {
            cursor: pointer;
        }
        .login-checkbox-custom input {
            width: 14px !important;
            height: 14px !important;
            display: inline-block !important;
            padding: 0 !important;
            margin: 0 !important;
            vertical-align: middle;
            visibility: hidden;
        }
        .login-checkbox-custom .checkbox-icon {
            width: 14px;
            height: 14px;
            background: url("../../static/images/login-checkbox-icon.png");
            position: absolute;
            top: 0;
            bottom: 0;
            margin: auto;
        }
        .login-checkbox-custom input[type="checkbox"] + .checkbox-icon {
            background-position: -6px -2px;
        }
        .login-checkbox-custom input[type="checkbox"]:checked + .checkbox-icon {
            background-position: -66px -2px;
        }
        .login-checkbox-custom:hover input[type="checkbox"] + .checkbox-icon {
            background-position: -36px -2px;
        }
        .login-checkbox-custom:hover input[type="checkbox"]:checked + .checkbox-icon {
            background-position: -66px -2px;
        }
        .login-container{
            position: relative;
            background:url("../../static/images/bg-login-2.png") no-repeat;
            background-size:cover;
            background-position: center;
            height:100%;
            width: 100%;
            overflow: hidden;
        }
        .login-box{
            position: absolute;
            width:480px;
            height:500px;
            margin:auto;
            top:0;
            right:0;
            bottom:0;
            left:0;
            z-index: 99;
        }

        .login-box-bg{
            width: 100%;
            height:100%;
            position: absolute;
            z-index: 1;
            background: #4380ff;
            opacity: .51;
        }
        .login-box-container{
            position: absolute;
            width:100%;
            height:100%;
            top:0;
            left:0;
            z-index: 2;
        }
        .login-head{
            font-size:41px;
            color:#fff;
            font-weight: 600;
            width: 100%;
            margin-top:35px;
            text-align: center;
        }
        .login-body-content{
            width: 100%;
            padding:0 91px;
            margin-top:30px;
        }
        .login-item{
            width: 100%;
            margin-bottom:20px;
        }
        .login-item:last-child{
            margin-bottom:0;
        }
        .no-margin{
            margin-bottom:0;
        }
        .login-input,.login-sms-input,.login-sms-btn{
            border:1px solid #0844e2;
            background: #598dfa;
            font-size:16px;
            padding:10px;
            color:#fff;
        }
        .login-input{
            width: 100%;
        }
        .login-sms-input{
            width: 188px;
            float: left;
        }
        .login-sms-btn{
            width: 94px;
            overflow: hidden;
            white-space: nowrap;
            float: right;
            font-size: 14px;
            /* padding: 11px 10px; */
            line-height: 22px;
            text-align: center;
        }
        .login-input::-webkit-input-placeholder,.login-sms-input::-webkit-input-placeholder{
            color:#7fb3dd;
        }
        .login-input:-ms-input-placeholder,.login-sms-input:-ms-input-placeholder{
            color:#7fb3dd;
        }
        .login-input:-moz-placeholder,.login-sms-input:-moz-placeholder{
            color:#7fb3dd;
        }
        .login-input:focus,.login-sms-input:focus{
            color:#fff;
            outline: none;
            border:1px solid #0844e2;
        }
        .login-input:focus::-webkit-input-placeholder,.login-sms-input:focus::-webkit-input-placeholder{
            color:#fff;
        }
        .login-input:focus:-ms-input-placeholder,.login-sms-input:focus:-ms-input-placeholder{
            color:#fff;
        }
        .login-input:focus:-moz-placeholder,.login-sms-input:focus:-moz-placeholder{
            color:#fff;
        }
        .login-item-label{
            width: 100%;
            display: block;
            position: relative;
            color: #ffffff;
            font-size:14px;
        }
        #loginError{
            height:18px;
            font-size:14px;
            color: #FFF;
        }
        .login-btn{
            width: 100%;
            color:#fff;
            font-size:16px;
            height:40px;
            line-height: 40px;
            cursor: pointer;
            text-align: center;
            background: #4e7fff;
        }

        .curve_1{
            width:10000px;
            height:132px;
            background:url("../../static/images/curve-1.png");
            background-size: contain;
            position: absolute;
            left:0;
            top:12px;
            z-index: 20;
            animation:curve_1 24s linear infinite;
            -webkit-animation:curve_1 24s linear infinite;
            -moz-animation:curve_1 24s linear infinite;
        }
        .curve_2{
            width: 10000px;
            height:129px;
            background:url("../../static/images/curve-2.png") ;
            background-size: contain;
            position: absolute;
            top:68px;
            left:-400%;
            z-index: 20;
            animation:curve_2 22s cubic-bezier(0.41, 0.14, 0.71, 0.93) infinite;
            -webkit-animation:curve_2 22s cubic-bezier(0.41, 0.14, 0.71, 0.93) infinite;
            -moz-animation:curve_2 22s cubic-bezier(0.41, 0.14, 0.71, 0.93) infinite;
        }
        .curve_3{
            width: 10000px;
            height:132px;
            background:url("../../static/images/curve-3.png") ;
            background-size: contain;
            position: absolute;
            top:68px;
            left:0;
            z-index: 20;
            animation:curve_1 18s linear infinite;
            -webkit-animation:curve_1 18s linear infinite;
            -moz-animation:curve_1 18s linear infinite;
        }
        .sunshine,.sunshine-1{
            position: absolute;
            width: 1700px;
            height:730px;
            background:url("../../static/images/sunshine.png") no-repeat;
            background-size: contain;
            left: 0;
            right: 0;
            margin:auto;
            top:0px;
            /*background-position: top center;*/
            z-index: 10;

        }
        .sunshine{
            animation:sunshine 1.2s ease-in-out 1;
        }
        .sunshine-1{
            opacity:0;
            animation: sunshine-1 3s ease-in-out 1 forwards;
            -webkit-animation: sunshine-1 3s ease-in-out 1 forwards;
            -moz-animation: sunshine-1 3s ease-in-out 1 forwards;
        }
        .sunshine-curve-1{
            position: absolute;
            width: 100%;
            height:371px;
            background: url("../../static/images/sunshine-curve-1.png") no-repeat;
            bottom:0;
            z-index: 2;
        }
        .sunshine-curve-2{
            position: absolute;
            width: 100%;
            height:327px;
            background: url("../../static/images/sunshine-curve-2.png") no-repeat;
            background-size: cover;
            bottom:0;
            z-index:2;
        }
        .bottom-table{
            position: absolute;
            width: 100%;
            height:752px;
            bottom:0;
            left:0;
            background: url("../../static/images/bg-table.png") no-repeat;
            z-index: 1;
        }
        .electric{
            width: 100%;
            max-width: 1904px;
            height:564px;
            position: absolute;
            top:0;
            right:0;
            bottom:0;
            left: 0;
            margin:auto;
            background: url("../../static/images/electric.png") no-repeat;
            background-position: bottom;
        }
        .electric-dot{
            position: absolute;
            height:17px;
            width: 17px;
            top:0;
            left:0;
            background: url("../../static/images/electric-dot.png") no-repeat;
        }
        .electric-dot-1{
            top:198px;
            left:-640px;
            animation:electric-dot-1 3s linear 500ms infinite;
        }
        .electric-dot-1-1{
            top:198px;
            left:-640px;
            animation:electric-dot-1 3s linear 1.6s infinite;
        }
        .electric-dot-2{
            top:257px;
            left:-713px;
            animation:electric-dot-2 2.5s linear 300ms infinite;
        }
        .electric-dot-3{
            top:416px;
            left:-396px;
            animation:electric-dot-3 2s linear 400ms infinite;
        }
        .electric-dot-4{
            top:396px;
            left:-659px;
            animation:electric-dot-4 2.2s linear 200ms infinite;
        }
        .electric-dot-5{
            top:267px;
            left:815px;
            animation:electric-dot-5 2.2s linear 200ms infinite;
        }
        .electric-dot-6{
            top:270px;
            left:1183px;
            animation:electric-dot-6 2.2s linear 200ms infinite;
        }
        .electric-dot-6-1{
            top:270px;
            left:1183px;
            animation:electric-dot-6 2.2s linear 1s infinite;
        }
        .electric-dot-7{
            top:425px;
            left:996px;
            animation:electric-dot-7 2.2s linear 200ms infinite;
        }
        .electric-dot-8{
            top:441px;
            left:1146px;
            animation:electric-dot-8 2.2s linear 200ms infinite;
        }
        .electric-dot-8-1{
            top:441px;
            left:1146px;
            animation:electric-dot-8 2.2s linear 1s infinite;
        }
        .login-box-dot{
            width: 100%;
            height: 80px;
            background: url(../../static/images/login-box-dot.png) no-repeat;
            position: absolute;
            bottom: -35px;
            left: 0;
            right: 0;
            margin: auto;
            background-position: center;
            z-index: 99;
        }
        .login-error{
            height:20px;
        }
        /*动画*/
         @keyframes curve_1 {
             0%{
                left:0;
             }
             100%{
                 left:-400%;
             }
         }
        @-webkit-keyframes  curve_1 {
              0%{
                  left:0;
              }
              100%{
                  left:-400%;
              }
          }
        @-moz-keyframes  curve_1 {
            0%{
                left:0;
            }
            100%{
                left:-400%;
            }
        }
        @keyframes curve_2 {
            0%{
                left:-400%;
            }
            100%{
                left:0;
            }
        }
        @-webkit-keyframes curve_2 {
            0%{
                left:-400%;
            }
            100%{
                left:0;
            }
        }
        @-moz-keyframes curve_2 {
            0%{
                left:-400%;
            }
            100%{
                left:0;
            }
        }
        @keyframes sunshine {
            0%{
                opacity: .1;
            }
            40%{
                opacity: .5;
            }
            100%{
                opacity:1;
            }
        }
        @-webkit-keyframes sunshine {
            0%{
                opacity: .1;
            }
            40%{
                opacity: .5;
            }
            100%{
                opacity:1;
            }
        }
        @-moz-keyframes sunshine {
            0%{
                opacity: .1;
            }
            40%{
                opacity: .5;
            }
            100%{
                opacity:1;
            }
        }
        @keyframes sunshine-1 {
            0%{
                opacity:1;
                top:-20px;
                left:10px;
            }
            40%{
                top:0;
                left:0;
            }
            70%{
                top:-15px;
                left:15px;
            }
            100%{
                opacity:1;
                top:0;
                left:0;
            }
        }
        @-webkit-keyframes sunshine-1 {
            0%{
                opacity:1;
                top:-20px;
                left:10px;
            }
            40%{
                top:0;
                left:0;
            }
            70%{
                top:-15px;
                left:15px;
            }
            100%{
                opacity:1;
                top:0;
                left:0;
            }
        }
        @-moz-keyframes sunshine-1 {
            0%{
                opacity:1;
                top:-20px;
                left:10px;
            }
            40%{
                top:0;
                left:0;
            }
            70%{
                top:-15px;
                left:15px;
            }
            100%{
                opacity:1;
                top:0;
                left:0;
            }
        }
        @keyframes electric-dot-1 {
            0%{
                top: 198px;
                left: -640px;
            }
            40%{
                top:198px;
                left:-417px;
            }
            60%{
                top:154px;
                left:-310px;
            }
            100%{
                top: 154px;
                left: -14px;
            }
        }
        @-webkit-keyframes electric-dot-1 {
            0%{
                top: 198px;
                left: -640px;
            }
            40%{
                top:198px;
                left:-417px;
            }
            60%{
                top:154px;
                left:-310px;
            }
            100%{
                top: 154px;
                left: -14px;
            }
        }
        @-moz-keyframes electric-dot-1 {
            0%{
                top: 198px;
                left: -640px;
            }
            40%{
                top:198px;
                left:-417px;
            }
            60%{
                top:154px;
                left:-310px;
            }
            100%{
                top: 154px;
                left: -14px;
            }
        }
        @keyframes electric-dot-2 {
            0%{
                top: 257px;
                left: -713px;
            }
            40%{
                top:257px;
                left:-441px;
            }
            60%{
                top:290px;
                left:-349px;
            }
            100%{
                top: 290px;
                left: -209px;
            }
        }
        @-webkit-keyframes electric-dot-2 {
            0%{
                top: 257px;
                left: -713px;
            }
            40%{
                top:257px;
                left:-441px;
            }
            60%{
                top:290px;
                left:-349px;
            }
            100%{
                top: 290px;
                left: -209px;
            }
        }
        @-moz-keyframes electric-dot-2 {
            0%{
                top: 257px;
                left: -713px;
            }
            40%{
                top:257px;
                left:-441px;
            }
            60%{
                top:290px;
                left:-349px;
            }
            100%{
                top: 290px;
                left: -209px;
            }
        }
        @keyframes electric-dot-3 {
            0%{
                top: 416px;
                left: -396px;
            }
            40%{
                top:416px;
                left:-256px;
            }
            60%{
                top:448px;
                left:-182px;
            }
            100%{
                top: 448px;
                left: -14px;
            }
        }
        @-webkit-keyframes electric-dot-3 {
            0%{
                top: 416px;
                left: -396px;
            }
            40%{
                top:416px;
                left:-256px;
            }
            60%{
                top:448px;
                left:-182px;
            }
            100%{
                top: 448px;
                left: -14px;
            }
        }
        @-moz-keyframes electric-dot-3 {
            0%{
                top: 416px;
                left: -396px;
            }
            40%{
                top:416px;
                left:-256px;
            }
            60%{
                top:448px;
                left:-182px;
            }
            100%{
                top: 448px;
                left: -14px;
            }
        }
        @keyframes electric-dot-4 {
            0%{
                top: 396px;
                left: -659px;
            }
            40%{
                top:396px;
                left:-471px;
            }
            60%{
                top:359px;
                left:-379px;
            }
            100%{
                top: 359px;
                left: -182px;
            }
        }
        @-webkit-keyframes electric-dot-4 {
            0%{
                top: 396px;
                left: -659px;
            }
            40%{
                top:396px;
                left:-471px;
            }
            60%{
                top:359px;
                left:-379px;
            }
            100%{
                top: 359px;
                left: -182px;
            }
        }
        @-moz-keyframes electric-dot-4 {
            0%{
                top: 396px;
                left: -659px;
            }
            40%{
                top:396px;
                left:-471px;
            }
            60%{
                top:359px;
                left:-379px;
            }
            100%{
                top: 359px;
                left: -182px;
            }
        }
        @keyframes electric-dot-5 {
            0%{
                top: 267px;
                left: 815px;
            }
            40%{
                top:245px;
                left:765px;
            }
            100%{
                top: 245px;
                left: 470px;
            }
        }
        @-webkit-keyframes electric-dot-5 {
            0%{
                top: 267px;
                left: 815px;
            }
            40%{
                top:245px;
                left:765px;
            }
            100%{
                top: 245px;
                left: 470px;
            }
        }
        @-moz-keyframes electric-dot-5 {
            0%{
                top: 267px;
                left: 815px;
            }
            40%{
                top:245px;
                left:765px;
            }
            100%{
                top: 245px;
                left: 470px;
            }
        }
        @keyframes electric-dot-6 {
            0%{
                top: 270px;
                left: 1183px;
            }
            40%{
                top:270px;
                left:892px;
            }
            60%{
                top:304px;
                left:825px;
            }
            100%{
                top: 304px;
                left: 470px;
            }
        }
        @-webkit-keyframes electric-dot-6 {
            0%{
                top: 270px;
                left: 1183px;
            }
            40%{
                top:270px;
                left:892px;
            }
            60%{
                top:304px;
                left:825px;
            }
            100%{
                top: 304px;
                left: 470px;
            }
        }
        @-moz-keyframes electric-dot-6 {
            0%{
                top: 270px;
                left: 1183px;
            }
            40%{
                top:270px;
                left:892px;
            }
            60%{
                top:304px;
                left:825px;
            }
            100%{
                top: 304px;
                left: 470px;
            }
        }
        @keyframes electric-dot-7 {
            0%{
                top: 425px;
                left: 996px;
            }
            40%{
                top:425px;
                left:784px;
            }
            60%{
                top:398px;
                left:717px;
            }
            100%{
                top: 398px;
                left: 470px;
            }
        }
        @-webkit-keyframes electric-dot-7 {
            0%{
                top: 425px;
                left: 996px;
            }
            40%{
                top:425px;
                left:784px;
            }
            60%{
                top:398px;
                left:717px;
            }
            100%{
                top: 398px;
                left: 470px;
            }
        }
        @-moz-keyframes electric-dot-7 {
            0%{
                top: 425px;
                left: 996px;
            }
            40%{
                top:425px;
                left:784px;
            }
            60%{
                top:398px;
                left:717px;
            }
            100%{
                top: 398px;
                left: 470px;
            }
        }
        @keyframes electric-dot-8 {
            0%{
                top: 441px;
                left: 1146px;
            }
            40%{
                top:441px;
                left:850px;
            }
            60%{
                top:525px;
                left:694px;
            }
            90%{
                top:525px;
                left:231px;
            }
            100%{
                top: 490px;
                left: 231px;
            }
        }
        @-webkit-keyframes electric-dot-8 {
            0%{
                top: 441px;
                left: 1146px;
            }
            40%{
                top:441px;
                left:850px;
            }
            60%{
                top:525px;
                left:694px;
            }
            90%{
                top:525px;
                left:231px;
            }
            100%{
                top: 490px;
                left: 231px;
            }
        }
        @-moz-keyframes electric-dot-8 {
            0%{
                top: 441px;
                left: 1146px;
            }
            40%{
                top:441px;
                left:850px;
            }
            60%{
                top:525px;
                left:694px;
            }
            90%{
                top:525px;
                left:231px;
            }
            100%{
                top: 490px;
                left: 231px;
            }
        }
    </style>
</head>
<body class="hold-transition" style="overflow: hidden">
<!--<div class="login-page">
    <div class="login-box">
        <div class="login-system-name">乐位云风控系统</div>
        &lt;!&ndash;<div class="login-left-body">
            <img src="${ctx}/static/images/login-left.png" alt="">
        </div>&ndash;&gt;
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
            <div class="login-error" id="loginError"></div>
            <div  id="submitBtn" class="login-btn">登录</div>
        </div>
    </div>
    <div class="login-body-left">
    </div>
</div>-->

<div class="login-container">
    <div class="curve_1"></div>
    <div class="curve_2"></div>
    <div class="curve_3"></div>
    <div class="sunshine"></div>
    <div class="sunshine sunshine-1"></div>
    <div class="electric"></div>
    <div class="login-box">
        <div class="login-box-container">
           <div class="login-head">
               乐位云风控
           </div>
           <div class="login-body-content">
               <div class="login-item">
                   <input type="text"  placeholder="请输入账号" id="username" name="username" value="" class="login-input">
               </div>
               <div class="login-item">
                   <input type="password"  placeholder="请输入密码" name="password" id="password" class="login-input">
               </div>
               <div class="login-item">
                   <input type="text" placeholder="请输入机构代码" name="domain" id="domain" class="login-input">
               </div>
               <div class="login-item clearfix">
                   <input type="text"  placeholder="请输入验证码" id="smscode" name="smscode" class="login-sms-input">
                   <input type="button" class="login-sms-btn" id="smsCodeBtn" value="获取验证码">
               </div>
               <div class="login-item no-margin">
                   <label class="login-item-label login-checkbox-custom">
                       <input type="checkbox" id="userNameCheck">
                       <div class="checkbox-icon"></div>
                       <span>记住账号</span>
                   </label>
               </div>
               <div class="login-error" id="loginError"></div>
               <div  id="submitBtn" class="login-btn">登录</div>
           </div>

       </div>
        <div class="login-box-dot"></div>
        <div class="login-box-bg"></div>
        <!--左边-->
        <div class="electric-dot electric-dot-1"></div>
        <div class="electric-dot electric-dot-1-1"></div>
        <div class="electric-dot electric-dot-2"></div>
        <div class="electric-dot electric-dot-3"></div>
        <div class="electric-dot electric-dot-4"></div>
        <!--右边-->
        <div class="electric-dot electric-dot-5"></div>
        <div class="electric-dot electric-dot-6"></div>
        <div class="electric-dot electric-dot-6-1"></div>
        <div class="electric-dot electric-dot-7"></div>
        <!--<div class="electric-dot electric-dot-7-1"></div>-->
        <div class="electric-dot electric-dot-8"></div>
        <div class="electric-dot electric-dot-8-1"></div>
    </div>
    <div class="sunshine-curve-1"></div>
    <div class="sunshine-curve-2"></div>
    <div class="bottom-table"></div>
</div>

</body>
</html>

