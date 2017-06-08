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

<div class="tab-pane" id="todoList">
    <div class="box-body">
        <div class="search-box" id="searchbar">
            <form onsubmit="return false;" class="form-inline form-label-auto" role="form">
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">产品类型</label>
                        <select class="form-control" name="productType" id="productType">
                                <option value="">请选择</option>
							<c:forEach items="${producttypes}" var="p">
								<option value="${p.id}">${p.name}</option>
							</c:forEach>
                        </select>
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">订单号</label>
                        <input type="text" class="form-control" name="id" placeholder="输入订单号搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">客户名称</label>
                        <input type="text" class="form-control" name="customerName" placeholder="输入客户名称搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">身份证号</label>
                        <input type="text" class="form-control" name="idCard"
                               placeholder="输入身份证号搜索">
                    </div>

                </div>
                
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">单据状态</label>
                        <select type="text" class="form-control" name="aproveStatus">
						<option value="">请选择</option>
					    <c:forEach var="s" items="${orderStatus}">
					    	<option value="${s.status}">${s.name}</option>
					    </c:forEach>
					</select>
                    </div>
                </div> 
                
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">新增日期</label>
                        <input type="text" class="form-control" id="reservationtime" readonly="readonly">
                        <input type="hidden" id="startDate" name="startDate">
                        <input type="hidden" id="endDate" name="endDate">
                    </div>

                </div>
                   <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">借款性质</label>
                        <select class="form-control" name="loanHandleType" id="loanHandleType">
                        <option value="">请选择</option>
                                 <c:forEach var="s" items="${loanhandletypes}">
					    	<option value="${s.status}">${s.label}</option>
					    </c:forEach>
                        </select>
                    </div>

                </div>
                
                
                
                  <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">车牌号码</label>
                        <input type="text" class="form-control" name="loancarLicensePlate"
                               placeholder="输入车牌号搜索">
                    </div>

                </div>
                
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">订单来源</label>
                        <input type="text" class="form-control" name="loanSource"
                               placeholder="输入订单来源搜索">
                    </div>

                </div>
                
                
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">客户类型</label>
                            <select class="form-control" name="customerType">
                            <option value="">请选择</option>
                                   <c:forEach var="s" items="${customertypes}">
					    	<option value="${s.typeId}">${s.typeName}</option>
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
            <div class="btn btn-primary btn-primary-lg" id="btn_reset_todo">
                <i class="icon"></i>
                <span>重置</span>
            </div>
        </div>
        <div id="toolbar">
            <div class="btn-group">
                <shiro:hasPermission name="index:log">
                    <div class="btn btn-white" id="myLoan_log_btn">
                        <span>日志</span>
                    </div>
                </shiro:hasPermission>
                
                 <shiro:hasPermission name="index:handle">
                <input type="button" class="btn btn-white" id="todo_handle_btn" value="处理"/>
                </shiro:hasPermission>
                
                 <shiro:hasPermission name="index:cancel">
                 <input type="button" class="btn btn-white" id="todo_cancle_btn" value="作废"/>
                </shiro:hasPermission>
                
            </div>

        </div>
        <table class="table  table-striped table-hover" id="todo_table" data-toggle="table"
               data-url="${ctx}/index/queryTodoList"
               data-method="post" data-cache="false"
               data-content-type="application/x-www-form-urlencoded"
               data-query-params="requestData" data-query-params-type=""
               data-click-to-select="true"
               data-single-select="false"
               data-select-item-name="id"
               data-checkbox-header="true"
               data-page-number=1 data-page-size=5
               data-response-handler="responseData" data-side-pagination="server"
               data-pagination="true" data-page-list="[5, 10, 20]" data-toolbar="#toolbar" style="width: 3000px">
            <thead>
            <tr>
                <th data-field="state" data-checkbox="true"></th>
                <th data-field="taskName">待办任务名称</th>
                <th data-field="corporation">订单来源</th>
                <th data-field="productTypeName">产品类型</th>
                <th data-field="custTypeStr">客户类型</th>
                 <th data-field="loanInfoId">订单号</th>
                <th data-field="custName">客户名称</th>
                <th data-field="custLicenseNum">身份证号</th>
                <th data-field="orderAddTime" data-formatter="timeFormatter">新增日期</th>
                <th data-field="loanApplyPeriodStr">借款期限</th>
                <th data-field="loanMoney">借款金额</th>
                <th data-field="loancarLicensePlate">车牌号</th>
                <th data-field="aproveStatusStr">单据状态</th>
                <th data-field="preOperUserName">提交人</th>
                <th data-field="preOperTime" data-formatter="timeFormatter">提交时间</th>
                <th data-field="processUser">待操作人</th>             
            </tr>
            </thead>
        </table>
        <!-- /.box-body -->
        <!-- /.box -->
    </div>
    <shiro:hasPermission name="index:log">
        <%@ include file="./modal/operateLog.jsp"%>
    </shiro:hasPermission>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/index/todoList.js${timeStyle}"></script>