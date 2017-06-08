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
    <link rel="stylesheet"
          href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
    <link rel="stylesheet"
          href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content content-padding">
        <div class="search-box" id="searchbar">
            <form onsubmit="return false;" class="form-inline form-label-auto" role="form">
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">产品</label>
                        <select class="form-control" name="productType" id="productType">
                            <c:forEach items="${products}" var="product">
                                <option value="${product.id}">${product.productName}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">订单号</label>
                        <input type="text" class="form-control" name="bpNo" placeholder="输入订单号搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">客户名称</label>
                        <input type="text" class="form-control" name="custName" placeholder="输入客户名称搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">身份证号</label>
                        <input type="text" class="form-control" name="custLicenseNum"
                               placeholder="输入身份证号搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">客户类型</label>
                        <select class="form-control" name="custType">
                            <option value="">请选择</option>
                            <c:forEach items="${customerTypes}" var="type">
                                <option value="${type.typeId}">${type.typeName}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">车牌号</label>
                        <input type="text" class="form-control" name="loancarLicensePlate"
                               placeholder="输入车牌号搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">审核节点</label>
                        <select class="form-control" name="currentTaskKey" id="currentTaskKey">
                            <option value="">请选择</option>
                            <!--<c:forEach items="${bpMetaNodes}" var="node">
                                <option value="${node.nodeKey}">${node.nodeName}</option>
                            </c:forEach>-->
                        </select>
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">申请日期</label>
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
        <div id="toolbar">
            <div class="btn-group">
                <shiro:hasPermission name="auditmy:log">
                    <div class="btn btn-white" id="myLoan_log_btn">
                        <span>日志</span>
                    </div>
                </shiro:hasPermission>
            </div>
        </div>
        <table class="table  table-striped table-hover" id="my_audit_table" data-toggle="table" style="width: 2500px;"
               data-url="${ctx}/loanaudit/queryMyAuditManager"
               data-method="post" data-cache="false"
               data-content-type="application/x-www-form-urlencoded"
               data-query-params="requestData" data-query-params-type=""
               data-click-to-select="true"
               data-single-select="true"
               data-select-item-name="id"
               data-checkbox-header="true"
               data-page-number=1 data-page-size=5
               data-response-handler="responseData" data-side-pagination="server"
               data-pagination="true" data-page-list="[5, 10, 20]" data-toolbar="#toolbar">
            <thead>
            <tr>
                <th data-field="state" data-checkbox="true"></th>
                <th data-field="bpNo" data-width="260">订单号</th>
                <th data-field="custName"
                <shiro:hasPermission name='loan:custdetail'>data-formatter="custNameFormatter"
                </shiro:hasPermission>
                >客户名称</th>
                <th data-field="custLicenseNum" data-width="188">身份证号</th>
                <!-- <th data-field="custMobile">手机号</th> -->
                <th data-field="custTypeStr">客户类型</th>
                <th data-field="loancarLicensePlate">车牌号码</th>
                <th data-field="productName">产品</th>
                <th data-field="createTime" data-formatter="timeFormatter" data-width="200">申请时间</th>
                <th data-field="applyAmount">申请金额</th>
                <th data-field="loanApplyPeriodStr">申请期限</th>
                <th data-field="loanRepaymentMethodStr">申请还款方式</th>
                <th data-field="loanApprovalRepaymentMethodStr">审批还款方式</th>
                <th data-field="deptName">所属门店</th>
                <th data-field="currentTaskName">单据状态</th>
                <th data-field="handlerName">审核处理人</th>
                <th data-field="handlerTaskName">审核节点</th>
                <th data-field="handlerTaskDurationStr">审核时间</th>
                <th data-field="handlerTaskOperationStr" data-width="200">审核操作</th>
            </tr>
            </thead>
        </table>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script type="text/javascript"
        src="${ctx}/static/pagejs/loanaudit/myloanaudit.js${timeStyle}"></script>
<%@ include file="./tabs/modal/operateLog.jsp"%>
</body>
</html>