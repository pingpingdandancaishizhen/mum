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
</head>
<body  class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
       <!-- Main content -->
    <section class="content content-padding">
		<div class="search-box" id="searchbar">
			<form onsubmit="return false;"  class="form-inline form-label-auto" role="form">
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">日期</label>
						<input type="text" class="form-control" id="reservationtime" readonly="readonly">
						<input type="hidden" id="startDate" name="startDate">
						<input type="hidden" id="endDate" name="endDate">
					</div>

				</div>
			</form>
		</div>
		<div class="table-top-tool">
			<div class="btn btn-primary btn-primary-lg" id="btn_search">
				<i class="icon icon-search"></i>
				<span>查询</span>
			</div>
		</div>
		<div class="bootstrap-table">
			<div class="fixed-table-container">
				<div class="fixed-table-body">
					<div class="fixed-table-loading" style="top: 46px; display: none;">正在努力地加载数据中，请稍候……</div>
					<table class="table  table-striped" >
						<thead>
						<tr>
							<th >日期</th>
							<th>进入审核订单数</th>
							<th>已审核订单数</th>
							<th>单笔花费时间</th>
						</tr>
						</thead>
						<tbody id="day_audit_table">

						</tbody>
					</table>
				</div>
			</div>


		</div>

      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <script type="text/javascript" src="${ctx}/static/pagejs/loanaudit/dayloanaudit.js${timeStyle}"></script>
</body>
</html>