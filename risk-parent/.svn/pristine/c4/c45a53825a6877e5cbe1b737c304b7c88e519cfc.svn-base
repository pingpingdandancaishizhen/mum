<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>

<link rel="stylesheet" href="${ctx}/static/assets/plugins/webuploader/webuploader.css"/>
<script src="${ctx}/static/assets/plugins/webuploader/webuploader.js"></script>
</head>
<body  class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <shiro:hasPermission name="contract:processing">
             	<li class="processing"><a href="#processing" data-toggle="tab">办理中的合同</a></li>
              </shiro:hasPermission>
              <shiro:hasPermission name="contract:processed">
              	<li class="processed"><a href="#processed" data-toggle="tab">已归档的合同</a></li>
              </shiro:hasPermission>
            </ul>
            <div class="tab-content">
            <shiro:hasPermission name="todo:list">
            	<%@ include file="./tabs/processingList.jsp"%>
            </shiro:hasPermission>
            <shiro:hasPermission name="todo:list">
            	<%@ include file="./tabs/processedList.jsp"%>
            </shiro:hasPermission>
            </div>
            <!-- /.tab-content -->
          </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <shiro:hasPermission name="index:log">
	  	<%@ include file="./tabs/modal/operateLog.jsp"%>
	</shiro:hasPermission>
</body>
<script type="text/javascript">
var $table;
$(function(){
	//默认选中第一个tab
	$(".nav-tabs li:first").addClass("active");
	$(".tab-content .tab-pane:first").addClass("active");
	$table = $("#processing_table");
	
	$("li").click(function(){
		if('processing'===$(this).attr("class")){
			$table = $("#processing_table");
		}else{
			$table = $("#processed_table");
		}
	});
});
</script>
</html>