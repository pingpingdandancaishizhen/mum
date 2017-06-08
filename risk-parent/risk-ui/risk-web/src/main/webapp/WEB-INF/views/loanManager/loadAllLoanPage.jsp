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
						<label class="label-head text-right">手机号</label>
						<input type="text" class="form-control" name="loanCustMobile"  placeholder="输入手机号搜索">
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">放款日期</label>
						<input type="text" class="form-control" id="reservationtime" readonly="readonly" >
						<input type="hidden" id="startDate" name="startDate">
						<input type="hidden" id="endDate" name="endDate">
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
						<label class="label-head text-right">所属门店</label>
						<select  class="form-control" name="deptId">
							<option value="">请选择</option>
							<c:forEach items="${depts}" var="dept">
								<option value="${dept.id}">${dept.deptName}</option>
							</c:forEach>
						</select>
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
				<shiro:hasPermission name="loanfk:plan">
					<div class="btn btn-white" id="allLoan_plan_btn">
						<span>放款计划</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="loanfk:record">
					<div class="btn btn-white" id="allLoan_record_btn">
						<span>放款录入</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="loanfk:export">
					<div class="btn btn-white" id="allLoan_export_btn">

						<span>导出excel</span>
					</div>
				</shiro:hasPermission>
			</div>
		</div>
		<table class="table  table-striped table-hover" id="allLoan_table" data-toggle="table" STYLE="width: 2500px;"
			   data-url="${ctx}/loanManager/queryAllLoan"
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
				<th data-field="loanCustMobile">手机号</th>
				<th data-field="loanContractId" data-width="260">借款合同号</th>
				<th data-field="approvedAmount">合同金额</th>
				<th data-field="loanConsultFee">咨询费</th>
				<th data-field="loanManageFee">管理费</th>
				<th data-field="loanGuaranteeFee">保证金</th>
				<th data-field="loanGPSFee">GPS安装费</th>
				<th data-field="loanGPSServiceFee">GPS服务费</th>
				<th data-field="loanParkFee">停车费</th>
				<th data-field="deptName">归属门店</th>
				<th data-field="loanApprovalRepayment">还款方式</th>
				<th data-field="supportFirstPay">支付方式</th>
				<th data-field="loanStatus">放款状态</th>
				<th data-field="loanAmount">实际放款金额</th>
				<th data-field="loanTime" data-formatter="timeFormatter">放款时间</th>
				<th data-field="loanLender">放款人</th>
			</tr>
			</thead>
		</table>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
	<script type="text/javascript" src="${ctx}/static/pagejs/loanManage/allLoan.js"></script>
 
</body>
</html>