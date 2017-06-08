<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>P2P发标系统</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.min.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.min.css${timeStyle}">
<link rel="stylesheet" href="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.print.css${timeStyle}"  media="print">
</head>
<body  class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
                    	<shiro:hasPermission name="todo:list">
                        	<li><a href="#todoList" data-toggle="tab">待办事项</a></li>
                        </shiro:hasPermission>

                <!--
                <li><a href="#question" data-toggle="tab">我的消息</a></li>
                 -->
                <shiro:hasPermission name="index:action">
                    <li><a href="#action" data-toggle="tab">行动日程</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="index:notice">
                    <li><a href="#notice" data-toggle="tab">系统公告</a></li>
                </shiro:hasPermission>
                <!--
                <li><a href="#question" data-toggle="tab">常见问题</a></li>
                 -->
            </ul>
            <div class="tab-content content-padding ">
                        <shiro:hasPermission name="todo:list">
                            <%@ include file="./tabs/todoList.jsp"%>
                        </shiro:hasPermission>
                <shiro:hasPermission name="index:action">
                    <%@ include file="./tabs/action.jsp"%>
                </shiro:hasPermission>
                <shiro:hasPermission name="index:notice">
                    <%@ include file="./tabs/notice.jsp"%>
                </shiro:hasPermission>
            </div>
            <!-- /.tab-content -->
        </div>
        <!-- /.nav-tabs-custom -->
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
</body>
<script type="text/javascript">
$(function(){
		//默认选中第一个tab
	$(".nav-tabs li:first").addClass("active");
	$(".tab-content .tab-pane:first").addClass("active")
});

</script>
</html>