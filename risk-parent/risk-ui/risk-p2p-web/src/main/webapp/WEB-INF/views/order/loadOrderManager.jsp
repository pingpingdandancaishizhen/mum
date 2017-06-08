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

				<div class="form-group col-md-4 row-left">
					<div class="input-group">
						<label class="label-head text-right"  >产品类型:</label>
						<select type="text" class="form-control" name="productType">
							<option value="">请选择</option>
							<c:forEach items="${producttypes}" var="p">
								<option value="${p.id}">${p.name}</option>
							</c:forEach>
						</select>
					</div>

				</div>
				<div class="form-group col-md-4 row-left">
					<div class="input-group">
					<label class="label-head text-right" >订单号:</label>
					<input type="text" class="form-control" name="id" placeholder="输入订单号搜索">
						</div>
				</div>
				<div class="form-group col-md-4 row-left">
					<div class="input-group">
					<label class="label-head text-right" >客户名称:</label>
					<input type="text" class="form-control" name="customerName"  placeholder="输入客户姓名搜索">
						</div>
				</div>
				<div class="form-group col-md-4 row-left">
					<div class="input-group">
					<label class="label-head text-right" >身份证号:</label>
					<input type="text" class="form-control" name="idCard"  placeholder="输入身份证号搜索">
						</div>
				</div>
				
				
				<div class="form-group col-md-4 row-left">
					<div class="input-group">
					<label class="label-head text-right" >单据状态:</label>
					<select type="text" class="form-control" name="aproveStatus">
						<option value="">请选择</option>
					    <c:forEach var="s" items="${orderStatus}">
					    	<option value="${s.status}">${s.name}</option>
					    </c:forEach>
					</select>
						</div>
				</div>
				
				<div class="form-group col-md-4 row-left">
					<div class="input-group">
					<label class="label-head text-right" >新增日期:</label>
					<input type="text" class="form-control" id="reservationtime" readonly="readonly">
					<input id="createTimeFrom" name="createTimeFrom" type="hidden">
					<input id="createTimeTo" name="createTimeTo" type="hidden">
						</div>
				</div>
				
				<div class="form-group col-md-4 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">借款性质:</label>
                        <select class="form-control" name="loanHandleType" id="loanHandleType">
                        <option value="">请选择</option>
                                 <c:forEach var="s" items="${loanhandletypes}">
					    	<option value="${s.status}">${s.label}</option>
					    </c:forEach>
                        </select>
                    </div>

                </div>
                
                 <div class="form-group col-md-4 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">订单来源:</label>
                        <input type="text" class="form-control" name="loanSource"
                               placeholder="输入订单来源搜索">
                    </div>

                </div>
                
                  
                <div class="form-group col-md-4 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">客户类型:</label>
                            <select class="form-control" name="customerType">
                            <option value="">请选择</option>
                                   <c:forEach var="s" items="${customertypes}">
					    	<option value="${s.typeId}">${s.typeName}</option>
					    </c:forEach>
                        </select>
                    </div>

                </div>
                
                
                   <div class="form-group col-md-4 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">车牌号码:</label>
                        <input type="text" class="form-control" name="loancarLicensePlate"
                               placeholder="输入车牌号搜索">
                    </div>

                </div>
                
                  <div class="form-group col-md-4 row-left">
                    <div class="input-group">
                        <label class="label-head text-right text-right">房产证号:</label>
                        <input type="text" class="form-control" name="housePropertyNumber"
                               placeholder="输入房产证号搜索">
                    </div>

                </div>
                
               
                
              
                
                
                
                
				
			</form>
		</div>
		<div class="table-top-tool">
			<div class="btn btn-primary btn-primary-lg" id="btn_search">
				<i class="icon icon-search"></i>
				<span>查询</span>
			</div>
			<div class="btn btn-primary btn-primary-lg" id="btn_reset_order">
				<i class="icon"></i>
                <span>重置</span>
            </div>
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
					<input type="button" class="btn btn-white" id="submit_all_btn" value="批量提交"/>
				</shiro:hasPermission>
			</div>
		</div>
		<table class="table table-striped table-hover" id="p2pOrder_table" data-toggle="table" style="width: 2500px"
			   data-url="${ctx}/order/loadAllLoanManager"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestData" data-query-params-type=""
			   data-click-to-select="true"
			   data-single-select="false"
			   data-select-item-name="id"
			   data-checkbox-header="true"
			   data-id-field="id" data-unique-id="id"
			   data-page-number=1 data-page-size=10
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[10, 15, 20]"  data-toolbar="#toolbar">
			<thead>
			<tr>
				<th data-field="state" data-checkbox="true"></th>
				<th data-field="plusIdIcon" data-formatter="showAllOrder" data-events="operateEvents">订单号</th>
				<th data-field="customerName" >客户名称</th>
				<th data-field="gender">性别</th>
				<th data-field="eidCard">身份证号</th>
				<th data-field="mobilePhone">手机号</th>
				<th data-field="customerType">客户类型</th>
				<th data-field="productTypeName">产品类型</th>
				<th data-field="carNo" >车牌号</th>
				<th data-field="">房地产证号</th>
				<th data-field="createTime" data-formatter="timeFormatter">新增日期</th>
				<th data-field="loanMoneyStr">借款金额</th>
				<th data-field="bzjMoneyStr">保证金</th>
				<th data-field="loanApplyPeriodStr">借款期限</th>
				<th data-field="repayType">借款还款方式</th>
				<th data-field="loanHandleType">借款性质</th>
				<th data-field="aproveStatusStr">单据状态</th>
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
	<script type="text/javascript" src="${ctx}/static/pagejs/system/order/order-list.js${timeStyle}"></script>
</body>
</html>