<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>风控SAAS</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
<!-- 上传工具 -->
<link rel="stylesheet" href="${ctx}/static/assets/plugins/webuploader/webuploader.css"/>
<script src="${ctx}/static/assets/plugins/webuploader/webuploader.js"></script>
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
						<label class="label-head text-right"  >产品：</label>
						<select type="text" class="form-control" name="productName">
							<option value="">请选择</option>
							<option value="XJD">现金贷</option>
						</select>
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
					<label class="label-head text-right" >订单号：</label>
					<input type="text" class="form-control" name="id" placeholder="输入订单号搜索">
						</div>
				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
					<label class="label-head text-right" >客户名称：</label>
					<input type="text" class="form-control" name="customerName"  placeholder="输入客户姓名搜索">
						</div>
				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
					<label class="label-head text-right" >身份证号：</label>
					<input type="text" class="form-control" name="idCard"  placeholder="输入身份证号搜索">
						</div>
				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
					<label class="label-head text-right" >新增日期：</label>
					<input type="text" class="form-control" id="reservationtime" readonly="readonly">
					<input id="createTimeFrom" name="createTimeFrom" type="hidden">
					<input id="createTimeTo" name="createTimeTo" type="hidden">
						</div>
				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
					<label class="label-head text-right" >单据状态：</label>
					<select type="text" class="form-control" name="aproveStatus">
						<option value="">请选择</option>
						<option value="1">新增订单</option>
						<option value="2">P2P审核</option>
						<option value="3">P2P影像审核</option>
						<option value="4">已放款</option>
						<option value="5">还款中</option>
						<option value="6">逾期</option>
						<option value="7">还款完成-提前结清</option>
						<option value="8">还款完成</option>
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
			<!--<div class="btn btn-primary btn-primary-lg" id="btn_reset">
                <span>重置</span>
            </div>-->
		</div>
		<div id="toolbar">
			<div class="btn-group">
				<shiro:hasPermission name="order:log">
					<div class="btn btn-white" id="myLoan_log_btn">
						<span>日志</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="order:import">
					<div class="btn btn-white" id="batch_import_btn">
						<span>导入excel</span>
					</div>
				</shiro:hasPermission>
			</div>
			<div class="btn-group">
				<shiro:hasPermission name="order:edit">
					<div class="btn btn-white" id="edit_btn">
						<span>编辑</span>
					</div>
				</shiro:hasPermission>
			</div>
			<div class="btn-group">
				<shiro:hasPermission name="order:view">
					<div class="btn btn-white" id="view_btn">
						<span>查看</span>
					</div>
				</shiro:hasPermission>
			</div>
			<div class="btn-group">
				<shiro:hasPermission name="order:submit">
					<div class="btn btn-white" id="submit_all_btn">
						<span>批量提交</span>
					</div>
				</shiro:hasPermission>
			</div>
		</div>
		<table class="table table-striped table-hover" id="p2pOrder_table" data-toggle="table"
			   data-url="${ctx}/order/loadAllLoanManager"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestData" data-query-params-type=""
			   data-click-to-select="true"
			   data-single-select="false"
			   data-select-item-name="id"
			   data-checkbox-header="true"
			   data-page-number=1 data-page-size=10
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[10, 15, 20]"  data-toolbar="#toolbar">
			<thead>
			<tr>
				<th data-field="state" data-checkbox="true"></th>
				<th data-field="plusIdIcon">订单号</th>
				<th data-field="customerName">客户名称</th>
				<th data-field="gender">性别</th>
				<th data-field="idCard">身份证号</th>
				<th data-field="mobilePhone">手机号</th>
				<th data-field="customerType">客户类型</th>
				<th data-field="productName">产品</th>
				<th data-field="createTime">新增日期</th>
				<th data-field="loanMoney">借款金额</th>
				<th data-field="loanPeriod">借款期限</th>
				<th data-field="repayType">借款还款方式</th>
				<th data-field="loanHandleType">借款性质</th>
				<th data-field="aproveStatus">单据状态</th>
				<th data-field="corporation">订单来源</th>
				<th data-field="importWay">订单新增方式</th>
				<th data-field="createUser">录单人员</th>
			</tr>
			</thead>
		</table>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
    <shiro:hasPermission name="order:log">
  		<%@ include file="./modal/operateLog.jsp"%>
  	</shiro:hasPermission>
	<shiro:hasPermission name="order:import">
		<%@ include file="./modal/batchImport.jsp"%>
	</shiro:hasPermission>
	<script type="text/javascript" src="${ctx}/static/pagejs/system/order/orderListManage.js${timeStyle}"></script>
</body>
</html>