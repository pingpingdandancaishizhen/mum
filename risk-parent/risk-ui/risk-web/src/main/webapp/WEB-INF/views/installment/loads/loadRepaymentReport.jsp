<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
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
       <div class="row">
        <div class="col-xs-12">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs" >
             	<li><a href="#loadLoans_ins" data-toggle="tab">日放款统计-保险公司</a></li>
              	<li><a href="#loadLoans_source" data-toggle="tab">日放款统计-渠道来源</a></li>
            </ul>
            <div class="tab-content content-padding">
            	<%@ include file="./tabs/loadLoans_ins.jsp"%>
            	<%@ include file="./tabs/loadLoans_source.jsp"%>
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
      </div>
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
	$(".tab-content .tab-pane:first").addClass("active");
	/* $("#mydTab a").click(function() {
		debugger
        $("#mydTab a").removeClass("active");
        $(this).addClass("active");
    }); */
});

</script>
</html>