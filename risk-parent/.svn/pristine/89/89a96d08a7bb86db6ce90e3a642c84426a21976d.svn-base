<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="org.apache.commons.codec.digest.Md5Crypt"%>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>P2P发标系统</title>
    <%@ include file="/WEB-INF/import/head.jsp"%>
    <link rel="stylesheet" href="${ctx}/static/pagecss/index.css${timeStyle}">
</head>
<body class="hold-transition my-theme" style="overflow:hidden;background: #f7f8fd;">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<div class=" wrapper">
    <!--头部信息-->
    <header class="main-header">
        <a href="#" class="logo">
            <span class="logo-mini"><img src="${ctx}/static/assets/dist/img/login.png${timeStyle}"
                                         alt=""></span>
            <span class="logo-lg">P2P发标系统</strong></span>
        </a>
        <nav class="navbar navbar-static-top">
            <div class="sidebar-toggle icon-content toggle-sidebar-menu">
                <div class="icon icon-nav-toggle" id="nav-toggle"></div>
            </div>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li>
                        <span><img src="./static/assets/dist/img/user2-160x160.jpg" alt=""></span>
                        <span>你好，${shiro_login_user.userName}</span>
                    </li>
                    <li class="icon-content" id="userSetting">
                        <i class="icon icon-setting"></i>

               <shiro:hasPermission name="index:userinfo">
                  <c:set var="hasanyperm" value="1"/>
                   <span data-url="${ctx}/index/settings#userinfo">
                       设置
                   </span>
               </shiro:hasPermission>
                <c:if test="${'1' ne hasanyperm}">
            		<shiro:hasPermission name="index:history">
                        <span data-url="${ctx}/index/settings#loginhistory">设置</span>
                        <c:set var="hasanyperm" value="1"/>
                    </shiro:hasPermission>
                </c:if>
                <c:if test="${'1' ne hasanyperm}">
                    <shiro:hasPermission name="index:password">
                        <span data-url="${ctx}/index/settings#modifypassword">
                             设置
                        </span>
                        <c:set var="hasanyperm" value="1"/>
                    </shiro:hasPermission>
                </c:if>
                    </li>
                    <li class="icon-content">
                        <i class="icon icon-logout"></i>
                        <span><a href="${ctx}/logout">退出</a></span>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!--左边导航-->
    <div class="left-sidebar">
        <div class="main-sidebar">
            <div class="sidebar">
                <ul class="sidebar-menu" id="sideBarMenu">
                </ul>
            </div>
            <div class="bottom-sideBar toggle-sidebar-menu" id="bottomSideBar">
                <i class="icon icon-bottom-sideBar "></i>
            </div>
        </div>
        <div class="sidebar-min-menu" id="sideBarMinMenu">
            <ul>

            </ul>
            <div class="sidebar-btn" id="sidebarBtn">
                <span class="fa fa-angle-left"></span>
            </div>
        </div>
    </div>
    <!--tab标签-->
    <div class="content-tabs">
        <nav class="page-tabs ">
            <div class="page-tabs-content" id="menuTabs">
            </div>
        </nav>
    </div>
    <!--中间内容-->
    <div  id="content-wrapper" style="overflow: hidden">
        <div class="mainContent content-wrapper" id="content-iframe">

        </div>
    </div>

</div>
<script src="${ctx}/static/assets/dist/js/fullScreen.js${timeStyle}"></script>
<script src="${ctx}/static/assets/dist/js/treeView.js${timeStyle}"></script>
<script src="${ctx}/static/pagejs/index.js${timeStyle}"></script>
</body>
</html>
