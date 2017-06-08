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
						<label class="label-head text-right">借款合同号</label>
						<input type="text" class="form-control" name="loanContractId"  placeholder="输入借款合同号搜索">
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">借款人</label>
						<input type="text" class="form-control" name="loanCustName"  placeholder="输入借款人搜索">
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">还款方式</label>
						<select  class="form-control" name="repaymentType">
							<option value="">请选择</option>
							<c:forEach items="${repaymentTypes}" var="repaymentType">
								<option value="${repaymentType.typeId}">${repaymentType.typeName}</option>
							</c:forEach>
						</select>
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">还款日期</label>
						<input type="text" class="form-control" id="reservationtime" readonly="readonly"  >
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
		<div id="toolbar">
			<div class="btn-group">
				<shiro:hasPermission name="loanhk:overdue">
					<div class="btn btn-white" id="overdue_record_btn">
						<span>逾期还款录入</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="overdue:export">
					<div class="btn btn-white" id="repayment_export_btn">
						<span>导出excel</span>
					</div>
				</shiro:hasPermission>
			</div>
		</div>
		<table class="table  table-striped table-hover" id="repayment_table" data-toggle="table" style="width: 2200px"
			   data-url="${ctx}/repayment/queryOverdueList"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestData" data-query-params-type=""
			   data-click-to-select="true"
			   data-single-select="true"
			   data-select-item-name="id"
			   data-checkbox-header="true"
			   data-page-number=1 data-page-size=5
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[5, 10, 20]"  data-toolbar="#toolbar">
			<thead>
			<tr>
				<th data-field="state" data-checkbox="true"></th>
				<th data-field="loanCustName">借款人</th>
				<th data-field="loanContractId" data-width="260">借款合同号</th>
				<th data-field="deptName">归属部门</th>
				<th data-field="loanApprovalRepayment">还款方式</th>
				<th data-field="productName">产品</th>
				<th data-field="loanTerm">借款期限</th>
				<th data-field="debitAmount">合同金额</th>
				<th data-field="leftAmount">剩余本金</th>
				<th data-field="payedIssue">已还期次</th>
				<th data-field="overdueDay">逾期天数</th>
				<th data-field="overdueZL">逾期账龄</th>
				<th data-field="overdueZnjFee" data-formatter="feeFormatter">罚息率（滞纳金率）</th>
				<th data-field="overdueZnj">逾期罚息（滞纳金）</th>
				<th data-field="overdueDerate">罚息减免金额</th>
				<th data-field="issueDay">还款日</th>
				<th data-field="status">状态</th>
			</tr>
			</thead>
		</table>

	</section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
	<script type="text/javascript" src="${ctx}/static/pagejs/repayment/overdue.js"></script>
 
</body>
</html>