<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body  class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
        <!-- Main content -->
    <section class="content content-padding">
		<div class="search-box" id="searchbar">
			<form onsubmit="return false;"  class="form-inline form-label-auto" role="form">
				<div class="form-group col-md-3 row-left ">
					<div class="input-group">
						<label class="label-head text-right">产品</label>
						<select name="productId" class="form-control">
							<option value="">请选择</option>

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
		<table class="table  table-striped table-hover table-responsive" id="workflow_table" data-toggle="table"
			   data-url="${ctx}/solution/p2pworkflow/queryWorkFlowList"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestData" data-query-params-type=""
			   data-page-number=1 data-page-size=5
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[5, 10, 20]" >
			<thead>
			<tr>
				<th data-field="bpDefKey">流程定义KEY</th>
				<th data-field="version">版本</th>
				<th data-field="bpName">流程名称</th>
				<th data-field="bpDesc">流程介绍</th>
				<th data-field="productName">产品名称</th>
				<th data-field="productTypeStr">产品类型</th>
				<th data-field="corpName">公司名称</th>
				<th data-formatter="operateFormatter" data-events="operateEvents" class="l_cz2" >操作</th>
			</tr>
			</thead>
		</table>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
 <script type="text/javascript">
//返回数据处理
var ctx = '${ctx}';
var $table = $("#workflow_table");
$(function () { 
		$.ajaxload();
});
function operateFormatter(value, row, index) {
	var row1= '<shiro:hasPermission name="workflow:assign"><div class="btn btn-white" id="o_manager"><span>审批分配</span></div></shiro:hasPermission>';
	var row2 = '<shiro:hasPermission name="workflow:form"><div class="btn btn-white" id="o_form"><span>表单配置</span></div></shiro:hasPermission>';
	var row3 = '<shiro:hasPermission name="workflow:deploy"><div class="btn btn-white" id="o_deploy"><span>流程部署</span></div></shiro:hasPermission>';
	return '<div class="btn-group-edit" >'+[row1,row2,row3].join(' ')+'</div>';
}
 </script>
<script type="text/javascript" src="${ctx}/static/pagejs/solution/workflow/workflow.js"></script>
<shiro:hasPermission name="workflow:assign">
<script type="text/javascript" src="${ctx}/static/pagejs/solution/p2pworkflow/workflow-assign.js"></script>
</shiro:hasPermission>
<shiro:hasPermission name="workflow:form">
<script type="text/javascript" src="${ctx}/static/pagejs/solution/p2pworkflow/workflow-form.js"></script>
</shiro:hasPermission>
<shiro:hasPermission name="workflow:deploy">
<script type="text/javascript" src="${ctx}/static/pagejs/solution/p2pworkflow/workflow-deploy.js"></script>
</shiro:hasPermission>
</body>
</html>