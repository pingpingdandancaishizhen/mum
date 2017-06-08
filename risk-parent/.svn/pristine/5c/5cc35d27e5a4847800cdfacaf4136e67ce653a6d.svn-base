<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>风控SAAS</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.min.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.min.css${timeStyle}">
<link rel="stylesheet" href="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.print.css${timeStyle}"  media="print">

<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
</head>
<body  class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Main content -->
		<section class="content content-padding">
			<div class="search-box" id="searchbar">
				<form onsubmit="return false;" id="form" class="form-inline form-label-auto" role="form">
					<div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">产品</label>
							<select  class="form-control" name="productType">
								<option value="">请选择</option>
								<option value="">融金分期宝</option>
							</select>
						</div>
					</div>
					<div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">订单号</label>
                            <input type="text" class="form-control" id="insuranceId" name="insuranceId" placeholder="输入订单号搜索">
                        </div>
                    </div>
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">客户名称</label>
                            <input type="text" class="form-control" id="ownerName" name="ownerName" placeholder="输入客户名称搜索">
                        </div>
                    </div>
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">身份证号</label>
                            <input type="text" class="form-control" id="ownerIdNo" name="ownerIdNo" placeholder="输入身份证号搜索">
                        </div>
                    </div>
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">客户类型</label>
	                        <select  class="form-control" name="custType">
	                            <option value="">请选择</option>
	                            <option value="">个人</option>
	                        </select>
                        </div>
                    </div>
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">车牌号</label>
                            <input type="text" class="form-control" id="licenseNo" name="licenseNo" placeholder="输入车牌号搜索">
                        </div>
                    </div>
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">单据状态</label>
	                        <select  class="form-control" id="status" name="status">
	                            <option value="">请选择</option>
	                            <option value="1">新增订单</option>
	                            <option value="2">已缴纳首付</option>
	                            <option value="3">成功投保</option>
	                        </select>
                         </div>
                    </div>
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right" >申请日期</label>
	                        <input type="text" class="form-control" id="reservationtime" readonly="readonly">
	                        <input type="hidden" id="startDate" name="startDate">
	                        <input type="hidden" id="endDate" name="endDate">
                        </div>
                    </div>
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">借款性质</label>
	                        <select  class="form-control" id="loanProperty" name="loanProperty">
	                            <option value="">请选择</option>
	                            <option value="新增">新增</option>
	                            <option value="结清再贷">结清再贷</option>
	                        </select>
                        </div>
                    </div>
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">业务员</label>
                            <input type="text" class="form-control" id="salesman" name="salesman" placeholder="输入业务员搜索">
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
                	<shiro:hasPermission name="loan:export">
                    <div class="btn-group">
                        <div class="btn btn-white" id="btn_export">
                            <i class="fa fa-plus"></i>
                            <span>下载excel表格</span>
                        </div>
                    </div>
                    </shiro:hasPermission>
                </div>
                <table class="table table-bordered table-hover" id="all_installment_table" 
                    data-toggle="table"
                    data-url="${ctx}/loans/queryAllLoansNew"
                    data-method="post" 
                    data-cache="false" 
                    data-content-type="application/x-www-form-urlencoded"
                    data-query-params="requestData" 
                    data-query-params-type=""
                    data-click-to-select="true" 
                    data-single-select="true" 
                    data-select-item-name="id"
                    data-checkbox-header="true"
                    data-page-number=1 
                    data-page-size=10
                    data-response-handler="responseData" 
                    data-side-pagination="server"
                    data-pagination="true" 
                    data-page-list="[5, 10, 20]" 
                    data-toolbar="#toolbar">
                    <thead>
                        <tr>
                            <th data-field="insuranceIcon">订单号</th>
                            <th data-field="ownerName">客户名称</th>
                            <th data-field="productName">产品</th>
                            <th data-field="licenseNo">车牌号码</th>
                            <th data-field="createTime">投保日期</th>
                            <th data-field="totalPrice">保费总额</th>
                            <th data-field="insurerName">保险公司</th>
                            
                            <th data-field="insuranceBank">保险公司收款银行</th>
                            <th data-field="insuranceAccount">保险公司收款银行账号</th>
                            <th data-field="insuranceBankSub">保险公司收款银行支行</th>
                            <th data-field="status">单据状态</th>
                            <th data-field="loanProperty">借款性质</th>
                            <th data-field="orderSource">订单来源</th>
                            <th data-field="payLink" data-formatter="custAFormatter">付款链接</th>
                        </tr>
                    </thead>
                </table>
	</section>
    <!-- /.content -->
</div>
</body>
<script type="text/javascript">

$(function(){
		//默认选中第一个tab
	$(".nav-tabs li:first").addClass("active");
	$(".tab-content .tab-pane:first").addClass("active");
    
    $('#btn_export').bind("click",function(){
    	var insuranceId = $('#insuranceId').val();
    	var ownerName = encodeURI($('#ownerName').val(),"UTF-8");
    	var ownerIdNo = $('#ownerIdNo').val();
    	var licenseNo = encodeURI($('#licenseNo').val(),"UTF-8");
    	var startDate = $('#startDate').val();
    	var endDate = $('#endDate').val();
    	var salesman = encodeURI($('#salesman').val(),"UTF-8");
    	var status = $('#status').val();
    	var loanProperty = encodeURI($('#loanProperty').val(),"UTF-8");
        window.location.href = "${ctx}/loans/exportAllLoans" + 
        	"?insuranceId=" + insuranceId + 
        	"&ownerName=" + ownerName + 
        	"&ownerIdNo=" + ownerIdNo + 
        	"&licenseNo=" + licenseNo + 
        	"&startDate=" + startDate + 
        	"&endDate=" + endDate + 
        	"&status=" + status + 
        	"&loanProperty=" + loanProperty + 
        	"&salesman=" + salesman;
    });
});

</script>
<script type="text/javascript" src="${ctx}/static/pagejs/installment/loans.js${timeStyle}"></script>
</html>