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
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content content-padding">

		<div class="search-box" id="searchbar">
			<form onsubmit="return false;"  class="form-inline form-label-auto" role="form">
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">产品类型</label>
						<select  class="form-control" name="product">
							<option value="">请选择</option>
							<c:forEach items="${productList}" var="product">
								<option value="${product.id}">${product.productName}</option>
							</c:forEach>
						</select>
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">合同名称</label>
						<input type="text" class="form-control" name="templateName" placeholder="输入合同名称搜索">
					</div>

				</div>

				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">状态</label>
						<select  class="form-control" name="status">
							<option value="">请选择</option>
							<option value="0">停用</option>
							<option value="1">启用</option>
						</select>
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">创建日期</label>
						<input type="text" class="form-control" id="createTime" readonly="readonly"  >
						<input type="hidden" id="startTime" name="startTime">
						<input type="hidden" id="endTime" name="endTime">
					</div>

				</div>
			</form>
		</div>
		<div class="table-top-tool">
			<shiro:hasPermission name="temp:add">
				<div class="btn btn-primary btn-primary-lg" id="add_temp_btn">
					<i class="icon icon-plus"></i>
					<span>新增</span>
				</div>
			</shiro:hasPermission>
			<div class="btn btn-primary btn-primary-lg" id="btn_search">
				<i class="icon icon-search"></i>
				<span>查询</span>
			</div>
		</div>
		<div id="toolbar">
			<div class="btn-group">

				<shiro:hasPermission name="temp:download">
					<div class="btn btn-white" id="download_temp_btn">

						<span>下载</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="temp:disable">
					<div class="btn btn-white" id="disable_temp_btn">

						<span>停用</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="temp:edit">
					<div class="btn btn-white" id="modify_temp_btn">

						<span>修改</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="temp:config">
					<div class="btn btn-white" id="cfg_temp_btn">

						<span>配置</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="temp:view">
					<div class="btn btn-white" id="view_temp_btn">

						<span>查看</span>
					</div>
				</shiro:hasPermission>
			</div>
		</div>
		<table class="table  table-striped table-hover" id="contractTemplate_table" data-toggle="table" style="width:2000px;"
			   data-url="${ctx}/contract/template/queryList"
			   data-method="get" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
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
				<th data-field="state" data-formatter="checkBoxFormatter"></th>
				<th data-formatter="indexFormatter">ID</th>
				<th data-field="product" data-width="200">所属产品</th>
				<th data-field="templateName">合同名称</th>
				<th data-field="templateDesc">合同描述</th>
				<th data-field="partnerNames" data-width="500">参与方</th>
				<th data-formatter="contractViewFormatter">合同范例</th>
				<th data-field="status" data-formatter="statusFormatter">状态</th>
				<th data-field="createTime" data-formatter="timeFormatter" data-width="180">创建日期</th>
				<th data-field="invalidTime" data-formatter="timeFormatter" data-width="180">停用日期</th>

			</tr>
			</thead>
		</table>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
</body>
<shiro:hasPermission name="temp:add">
	<%@ include file="./modal/addContractTemplate.jsp"%>
</shiro:hasPermission>
<shiro:hasPermission name="temp:config">
	<%@ include file="./modal/cfgContractTemplate.jsp"%>
</shiro:hasPermission>
<shiro:hasPermission name="temp:view">
	<%@ include file="./modal/viewContractTemplate.jsp"%>
</shiro:hasPermission>
<script type="text/javascript" src="${ctx}/static/pagejs/contract/template/contractTemplate.js"></script>
</html>