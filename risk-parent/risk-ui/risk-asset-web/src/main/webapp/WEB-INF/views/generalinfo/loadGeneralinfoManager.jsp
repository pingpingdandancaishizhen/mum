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
    <div class="content-wrapper">
    <section class="content content-padding">
    <div class="box-body">
        <div class="search-box" id="searchbar">
            <form onsubmit="return false;" class="form-inline form-label-auto" role="form" id="searchForm" style="height: 135px;overflow: hidden">
            	<div class="form-group col-md-3 row-left" id="sproductType">
	                <div class="input-group">
	                    <label class="label-head text-right">产品</label>
	                    <select class="form-control" name="productType" id="productType">
	                        <c:forEach items="${products}" var="product">
	                            <option value="${product.id}">${product.productName}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
                <div class="form-group col-md-3 row-left" id="sbpNo">
                    <div class="input-group">
                        <label class="label-head text-right text-right">订单号</label>
                        <input type="text" class="form-control" id="bpNo" name="bpNo" placeholder="输入订单号搜索">
                    </div>
                </div>
                <div class="form-group col-md-3 row-left" id="scustName">
                    <div class="input-group">
                        <label class="label-head text-right text-right">客户名称</label>
                        <input type="text" class="form-control" id="custName" name="custName" placeholder="输入客户名称">
                    </div>
                </div>
                <div class="form-group col-md-3 row-left" id="slicenseNo">
                    <div class="input-group">
                        <label class="label-head text-right text-right">身份证号</label>
                        <input type="text" class="form-control" id="licenseNo" name="licenseNo" placeholder="输入身份证号">
                    </div>
                </div>
                <div class="form-group col-md-3 row-left" id="scustType">
	                <div class="input-group">
	                    <label class="label-head text-right">客户类型</label>
	                    <select class="form-control" name="custType" id="custType">
	                        <option value="">请选择</option>
	                        <c:forEach items="${customerTypes}" var="type">
	                            <option value="${type.typeId}">${type.typeName}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="scarNo">
                    <div class="input-group">
                        <label class="label-head text-right text-right">车牌号码</label>
                        <input type="text" class="form-control" id="carNo" name="carNo" placeholder="输入车牌号码">
                    </div>
                </div>
                <div class="form-group col-md-3 row-left" id="scurrTaskKey">
	                <div class="input-group">
	                    <label class="label-head text-right">单据状态</label>
	                    <select class="form-control" name="currTaskKey" id="currTaskKey">
	                        <option value="">请选择</option>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="scontractNo">
                    <div class="input-group">
                        <label class="label-head text-right text-right">主合同号</label>
                        <input type="text" class="form-control" id="contractNo" name="contractNo" placeholder="输入主合同号">
                    </div>
                </div>
                <div class="form-group col-md-3 row-left" id="sloanType">
	                <div class="input-group">
	                    <label class="label-head text-right">借款性质</label>
	                    <select class="form-control" name="loanType" id="loanType">
	                        <option value="">请选择</option>
	                        <option value="1">新增</option>
	                        <option value="2">展期</option>
	                        <option value="3">结清再贷</option>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="sapplytime">
	                <div class="input-group">
	                    <label class="label-head text-right">申请日期</label>
	                    <input type="text" class="form-control" id="applytime" readonly="readonly" >
	                    <input type="hidden" id="applyStartDate" name="applyStartDate">
	                    <input type="hidden" id="applyEndDate" name="applyEndDate">
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="sauditStatus">
	                <div class="input-group">
	                    <label class="label-head text-right">审核状态</label>
	                    <select class="form-control" name="auditStatus" id="auditStatus">
	                        <option value="">请选择</option>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="sloanShare">
	                <div class="input-group">
	                    <label class="label-head text-right">共同借款</label>
	                    <select class="form-control" name="loanShare" id="loanShare">
	                        <option value="">请选择</option>
	                        <option value="1">是</option>
	                        <option value="0">否</option>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="slendtime">
	                <div class="input-group">
	                    <label class="label-head text-right">放款时间</label>
	                    <input type="text" class="form-control" id="lendtime" readonly="readonly" >
	                    <input type="hidden" id="lendStartDate" name="lendStartDate">
	                    <input type="hidden" id="lendEndDate" name="lendEndDate">
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="sowenStore">
	                <div class="input-group">
	                    <label class="label-head text-right">所属门店</label>
	                    <select class="form-control" name="owenStore" id="owenStore">
	                        <option value="">请选择</option>
	                        <c:forEach items="${deptList}" var="dept">
	                            <option value="${dept.id}">${dept.name}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="sapproveLine">
                    <div class="input-group">
                        <label class="label-head text-right">审批期限</label>
                        <select class="form-control" name="approveLine" id="approveLine">
	                        <option value="">请选择</option>
	                    </select>
                    </div>
                </div>
                <div class="form-group col-md-3 row-left" id="srepayStatus">
	                <div class="input-group">
	                    <label class="label-head text-right">还款状态</label>
	                    <select class="form-control" name="repayStatus" id="repayStatus">
	                        <option value="">请选择</option>
	                        <c:forEach items="${repayStatus}" var="status">
	                            <option value="${status.status}">${status.statusName}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="srepayedTerm">
                    <div class="input-group">
                        <label class="label-head text-right text-right">已还期次</label>
                        <input type="text" class="form-control" id="repayedTerm" name="repayedTerm" placeholder="输入已还期次">
                    </div>
                </div>
                <div class="form-group col-md-3 row-left" id="stenderStatus">
	                <div class="input-group">
	                    <label class="label-head text-right">标的状态</label>
	                    <select class="form-control" name="tenderStatus" id="tenderStatus">
	                        <option value="">请选择</option>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="srepaymentMethod">
	                <div class="input-group">
	                    <label class="label-head text-right">还款方式</label>
	                    <select class="form-control" name="repaymentMethod" id="repaymentMethod">
	                        <option value="">请选择</option>
	                        <c:forEach items="${repayType}" var="type">
	                            <option value="${type.typeId}">${type.typeName}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="stendertime">
	                <div class="input-group">
	                    <label class="label-head text-right">满标时间</label>
	                    <input type="text" class="form-control" id="tendertime" readonly="readonly" >
	                    <input type="hidden" id="tenderStartDate" name="tenderStartDate">
	                    <input type="hidden" id="tenderEndDate" name="tenderEndDate">
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="sorderSource">
	                <div class="input-group">
	                    <label class="label-head text-right">订单来源</label>
	                    <select class="form-control" name="orderSource" id="orderSource">
	                        <option value="">请选择</option>
	                        <c:forEach items="${channels}" var="channel">
	                            <option value="${channel.status}">${channel.statusName}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div class="form-group col-md-3 row-left" id="sloanPlatform">
	                <div class="input-group">
	                    <label class="label-head text-right">放款平台</label>
	                    <select class="form-control" name="loanPlatform" id="loanPlatform">
	                        <option value="">请选择</option>
	                    </select>
	                </div>
	            </div>
				<div class="clearfix"></div>
            </form>
			<div class="searchBox-tools text-right">
				<div class="tools-box">
					<span class="fa fa-angle-double-down"></span>
				</div>

			</div>
        </div>
        <div class="table-top-tool">
        	<shiro:hasPermission name="generalinfo:viewset">
	        	<div class="btn btn-primary btn-primary-lg" id="btn_viewconfig">
	                <i class="icon icon-search"></i>
	                <span>显示设置</span>
	            </div>
            </shiro:hasPermission>
            <shiro:hasPermission name="generalinfo:search">
	            <div class="btn btn-primary btn-primary-lg" id="btn_search">
	                <i class="icon icon-search"></i>
	                <span>查询</span>
	            </div>
            </shiro:hasPermission>
            <div class="btn btn-default btn-primary-lg" id="btn_reset">
                <i class="icon"></i>
                <span>重置</span>
            </div>
        </div>
        <div id="toolbar">
            <div class="btn-group">
            	<shiro:hasPermission name="generalinfo:export">
                    <div class="btn btn-white" id="btn_export">
                        <span>导出EXCEL</span>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="generalinfo:log">
                    <div class="btn btn-white" id="myLoan_log_btn">
                        <span>日志</span>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="generalinfo:view">
                    <div class="btn btn-white" id="btn_view">
                        <span>查看</span>
                    </div>
                </shiro:hasPermission>
            </div>
        </div>
        <table class="table  table-striped table-hover" id="generalinfo_table" data-toggle="table" style="width: 3800px"
               data-url="${ctx}/generalinfo/queryNewList"
               data-method="post" data-cache="false"
               data-content-type="application/x-www-form-urlencoded"
               data-query-params="requestData" data-query-params-type=""
               data-click-to-select="true"
               data-single-select="true"
               data-select-item-name="id"
               data-checkbox-header="true" data-unique-id="bpNo"
               data-page-number=1 data-page-size=5
               data-response-handler="responseData" data-side-pagination="server"
               data-pagination="true" data-page-list="[5, 10, 20]" data-toolbar="#toolbar">
            <thead>
            <tr>
                <th data-field="state" data-checkbox="true"></th>
                <th data-field="plusIcon" data-width="300">订单号</th>
                <th data-field="orderSource">订单来源</th>
                <th data-field="loanPlatform">放款平台</th>
                <th data-field="product" data-width="200">产品</th>
                <th data-field="custName" data-width="150">客户名称</th>
                <th data-field="contractNo" data-width="300">主合同号</th>
                <th data-field="custLicenseNo" data-width="170">身份证号</th>
                <th data-field="custType">客户类型</th>
                <th data-field="applyDate" data-formatter="timeFormatter" data-width="250">申请日期</th>
                <th data-field="loanShare">是否共同借款</th>
                <th data-field="applyAmount">申请金额</th>
                <th data-field="applyPeriodStr">申请期限</th>
                <th data-field="applyRepaymentMethodStr">申请还款方式</th>
                <th data-field="loanApprovalAmount">审批金额</th>
                <th data-field="approvalPeriodStr">审批期限</th>
                <th data-field="loanApprovalBzjAmount">保证金</th>
                <th data-field="contractAmount">合同金额</th>
                <th data-field="approvalRepaymentTypeStr">审批还款方式</th>
                <th data-field="carNo" data-width="200">车牌号码</th>
                <th data-field="owenStore">所属门店</th>
                <th data-field="loanType">借款性质</th>
                <th data-field="orderStatus">订单状态</th>
                <th data-field="auditStatus">审核状态</th>
                <th data-field="lendDate" data-formatter="dateFormatter" data-width="200">放款时间</th>
                <th data-field="repayStatus">还款状态</th>
                <th data-field="repayedTerm">已还期次</th>
                <th data-field="tenderStatus">标的状态</th>
                <th data-field="tenderDate" data-width="250">满标时间</th>
                <th data-field="tenderRepayType">标的还款方式</th>
            </tr>
            </thead>
        </table>
    </div>
    </section>
    <shiro:hasPermission name="index:log">
        <%@ include file="./modal/operateLog.jsp"%>
    </shiro:hasPermission>
    <shiro:hasPermission name="index:log">
        <%@ include file="./modal/columConfig.jsp"%>
    </shiro:hasPermission>
  </div>
</body>
<script type="text/javascript" src="${ctx}/static/pagejs/generalinfo/generalinfo-manager.js${timeStyle}"></script>
</html>