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
    <!-- Content Header (Page header) -->

    <!-- Main content -->
    <section class="content content-padding">
		<div class="panel panel-default"  id="searchbar"  style="display:none">
			<div class="panel-heading">搜索条件</div>
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-inline" role="form">
					<div class="form-group">
						<input type="hidden" name="bpDefId" value="${bpDefId}"/>
					</div>
				</form>
			</div>
		</div>
		<div class="table-box">
			<table class="table  table-striped  table-responsive" id="workflow_node_form_table" data-toggle="table"
				   data-url="${ctx}/solution/workflow/queryNodeList4Form"
				   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				   data-query-params="requestData" data-query-params-type=""
				   data-page-number=1 data-page-size=20
				   data-response-handler="responseData" data-side-pagination="server"
				   data-pagination="true" data-page-list="[5, 10, 20]">
				<thead>
				<tr>
					<th data-field="bpName">流程名称</th>
					<th data-field="nodeKey">节点KEY</th>
					<th data-field="nodeName">节点名称</th>
					<th data-field="nodeType">节点类型</th>
					<th data-field="formName">节点表单</th>
					<th data-field="queryFormName">节点查询表单</th>
					<th data-formatter="operateFormatter" data-events="operateEvents" class="l_cz2" >操作</th>
				</tr>
				</thead>
			</table>
		</div>

      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <%@ include file="./modal/relateForm.jsp"%>
 <script type="text/javascript">
//返回数据处理
var ctx = '${ctx}';
var $table = $("#workflow_node_form_table");
$(function () { 
		$.ajaxload();
});
function operateFormatter(value, row, index) {
	var row1 = '<shiro:hasPermission name="workflow:relateForm"><div class="btn btn-white" id="o_form"><i class="fa fa-ban"></i><span>关联表单</span></div></shiro:hasPermission>';
	return '<div class="btn-group" >'+[row1].join(' ')+'</div>';
}
 </script>
 <shiro:hasPermission name="workflow:relateForm">
 <script type="text/javascript" src="${ctx}/static/pagejs/solution/workflow/workflow-form-list.js"></script>
 </shiro:hasPermission>
</body>
</html>