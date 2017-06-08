<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body  class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
      <div class="nav-tabs-custom">
        <ul class="nav nav-tabs">
          <shiro:hasPermission name="index:userinfo">
            <li><a href="#userinfo" data-toggle="tab">个人资料</a></li>
          </shiro:hasPermission>
          <shiro:hasPermission name="index:history">
            <li><a href="#loginhistory" data-toggle="tab">登录历史</a></li>
          </shiro:hasPermission>
          <shiro:hasPermission name="index:password">
            <li><a href="#modifypassword" data-toggle="tab">修改密码</a></li>
          </shiro:hasPermission>
        </ul>
        <div class="tab-content content-padding table-box">
          <shiro:hasPermission name="index:userinfo">
            <%@ include file="./tabs/userinfo.jsp"%>
          </shiro:hasPermission>
          <shiro:hasPermission name="index:history">
            <%@ include file="./tabs/history.jsp"%>
          </shiro:hasPermission>
          <shiro:hasPermission name="index:password">
            <%@ include file="./tabs/password.jsp"%>
          </shiro:hasPermission>
        </div>
        <!-- /.tab-content -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <script type="text/javascript">
  	$(function(){
  		var href= location.hash;
  		$('a[href="'+href+'"]').tab('show');
  	});
  </script>
</body>
</html>