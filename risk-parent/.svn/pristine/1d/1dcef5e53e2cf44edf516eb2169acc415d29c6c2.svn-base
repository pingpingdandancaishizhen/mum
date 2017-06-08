<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>

<div class="tab-pane content-padding" id="processed">
    <div class="search-box" id="searchbar2">
        <form onsubmit="return false;" class="form-inline form-label-auto" role="form">
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">产品</label>
                    <select class="form-control" name="productType_processed" id="productType_processed">
                        <c:forEach items="${products}" var="product">
                            <option value="${product.id}">${product.productName}</option>
                        </c:forEach>
                    </select>
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">订单号</label>
                    <input type="text" class="form-control" name="bpNo_processed"
                           placeholder="输入订单号搜索">
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">客户名称</label>
                    <input type="text" class="form-control" name="custName_processed"
                           placeholder="输入客户名称搜索">
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">身份证号</label>
                    <input type="text" class="form-control" name="custLicenseNum_processed"
                           placeholder="输入身份证号搜索">
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">客户类型</label>
                    <select class="form-control" name="custType_processed">
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
                    <input type="text" class="form-control" name="loancarLicensePlate_processed"
                           placeholder="输入车牌号搜索">
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">单据状态</label>
                    <select class="form-control" name="currentTaskKey_processed" id="currentTaskKey_processed">
                        <option value="">请选择</option>
                        <!-- <c:forEach items="${bpMetaNodes}" var="node">
                            <option value="${node.nodeKey}">${node.nodeName}</option>
                        </c:forEach> -->
                    </select>
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">合同号</label>
                    <input type="text" class="form-control" name="contractNo_processed"
                           placeholder="输入合同号">
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">借款性质</label>
                    <select class="form-control" name="loanType_processed">
                        <option value="">请选择</option>
                    </select>
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">合同签署时间</label>
                    <input type="text" class="form-control" id="reservationtime_processed"
                           readonly="readonly" >
                    <input type="hidden" id="startDate_processed" name="startDate_processed">
                    <input type="hidden" id="endDate_processed" name="endDate_processed">
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">合同签署人</label>
                    <input type="text" class="form-control" name="contractSigner_processed"
                           placeholder="输入合同签署人">
                </div>

            </div>
            <div class="form-group col-md-3 row-left">
                <div class="input-group">
                    <label class="label-head text-right">所属门店</label>
                    <select class="form-control" name="deptId_processed">
                        <option value="">请选择</option>
                        <c:forEach items="${deptList}" var="dept">
                            <option value="${dept.id}">${dept.name}</option>
                        </c:forEach>
                    </select>
                </div>

            </div>
        </form>
    </div>
    <div class="table-top-tool">
        <div class="btn btn-primary btn-primary-lg" id="btn_search_processed">
            <i class="icon icon-search"></i>
            <span>查询</span>
        </div>
    </div>
    <div id="toolbar2">
        <div class="btn-group">
            <shiro:hasPermission name="contract:log">
                <div class="btn btn-white  contract_log">

                    <span>日志</span>
                </div>
            </shiro:hasPermission>
            <shiro:hasPermission name="contract:view">
                <div class="btn btn-white" id="view_contract">

                    <span>查看合同</span>
                </div>
            </shiro:hasPermission>
        </div>
    </div>
    <table class="table  table-striped table-hover" id="processed_table" data-toggle="table" style="width: 2500px"
           data-url="${ctx}/contract/manager/queryProcessedList"
           data-method="post" data-cache="false"
           data-content-type="application/x-www-form-urlencoded"
           data-query-params="requestData2" data-query-params-type=""
           data-click-to-select="true"
           data-single-select="true"
           data-select-item-name="id"
           data-checkbox-header="true"
           data-page-number=1 data-page-size=5
           data-response-handler="responseData" data-side-pagination="server"
           data-pagination="true" data-page-list="[5, 10, 20]" data-toolbar="#toolbar2">
        <thead>
        <tr>
            <th data-field="state" data-checkbox="true"></th>
            <th data-field="bpNo" data-width="260">订单号</th>
            <th data-field="contractNo" data-width="260">借款合同号</th>
            <th data-field="custName"
            <shiro:hasPermission name='loan:custdetail'>data-formatter="custNameFormatter"
            </shiro:hasPermission>
            >客户名称</th>
            <th data-field="custLicenseNum" data-width="188">身份证号</th>
            <th data-field="custTypeStr">客户类型</th>
            <th data-field="productName" data-width="188">产品</th>
            <th data-field="createTime" data-formatter="timeFormatter" data-width="200">申请时间</th>
            <th data-field="approvedAmount">合同金额</th>
            <th data-field="loanApprovalPeriodStr">借款期限</th>
            <th data-field="loanRepaymentMethodStr">申请还款方式</th>
            <th data-field="loanApprovalRepaymentMethodStr">审批还款方式</th>
            <th data-field="loancarLicensePlate">车牌号码</th>
            <!-- <th data-field="">借款性质</th> -->
            <th data-field="currentTaskName">单据状态</th>
            <th data-field="deptName">所属门店</th>
            <th data-field="userName">业务员</th>
            <th data-field="custName">合同签署人</th>
        </tr>
        </thead>
    </table>
    <shiro:hasPermission name="index:log">
        <%@ include file="./modal/viewContracts.jsp"%>
    </shiro:hasPermission>
</div>
<script type="text/javascript"
        src="${ctx}/static/pagejs/contract/manager/processedList.js${timeStyle}"></script>