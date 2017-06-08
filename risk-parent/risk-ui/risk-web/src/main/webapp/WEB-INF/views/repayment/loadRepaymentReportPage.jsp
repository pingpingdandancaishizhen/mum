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
<body  class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content content-padding">
		<div class="search-box" id="searchbar">
			<form onsubmit="return false;"  class="form-inline form-label-auto" role="form" id="searchForm">

				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right" style="width: 120px;">计划还款日期</label>
						<input type="text" class="form-control" id="reservationtime" readonly="readonly" >
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
		<table class="table  table-striped table-hover" id="repaymentReport_table" data-toggle="table"
			   data-url="${ctx}/repayment/queryRepaymentReport"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="queryParams" data-query-params-type=""
			   data-click-to-select="true"
			   data-single-select="true"
			   data-select-item-name="id"
			   data-checkbox-header="true"
			   data-side-pagination="server"
			   data-page-number=1 data-page-size=5
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[5, 10, 20]"  data-toolbar="#toolbar">
			<thead>
			<tr>
				<th data-field="date">计划还款日期</th>
				<th data-field="planCount">应还订单数</th>
				<th data-field="planPrinciple">应还款本金</th>
				<th data-field="planInterest">应还款利息</th>
				<th data-field="planManageFee">应还款管理费</th>
				<th data-field="planOverdueFee">应还滞纳金</th>
				<th data-field="planTotal">应还款总额</th>
				<th data-field="payedCount">实际还款订单数</th>
				<th data-field="payedPrinciple">实际还款本金</th>
				<th data-field="payedInterest">实际还款利息</th>
				<th data-field="payedManageFee">实际还款管理费</th>
				<th data-field="payedTotal">实际还款总额</th>
				<th data-field="payedPenalty">实还违约金</th>
				<th data-field="payedOverdue">实还滞纳金</th>
				<th data-field="leftTotal">剩余还款总额</th>
				<th data-field="repaymentPerOrder">日均单笔实还金额</th>
			</tr>
			</thead>
		</table>

		<!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
	<script type="text/javascript" src="${ctx}/static/pagejs/repayment/repaymentReport.js"></script>
 
</body>
</html>