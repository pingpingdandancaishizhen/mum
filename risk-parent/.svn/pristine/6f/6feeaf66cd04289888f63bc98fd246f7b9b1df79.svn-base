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
    <section class="content-header">
  	 <h1>
        流程模板管理
        <small></small>
      </h1> 
      <ol class="breadcrumb">
        <li class="active"><a href="${ctx}/flow/flow/loadFlowManager">流程模板管理</a></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <!-- <h3 class="box-title">Hover Data Table</h3> -->
            </div>
            <!-- /.box-header -->
            <div class="box-body">
           <div class="bs-example" id="toolbar">
			   <div class="col-sm-12">
				   <form onsubmit="return false;"  class="form-inline" role="form">
					   <div class="form-group">
						   <div  id="btn_search" class="btn btn-block btn-warning">搜索</div>
					   </div>
				   </form>
			   </div>
			   <p class=" col-sm-2">
					   <button id="add_flow_btn" type="button" class="btn btn-block btn-info">新增流程</button>
			   </p>
		      </div>
              <table class="table  table-striped table-hover" id="flow_table" data-toggle="table"
				data-url="${ctx}/flow/flow/queryMetaTemplates"
				data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				data-query-params="requestData" data-query-params-type=""
				data-page-number=1 data-page-size=5
				data-response-handler="responseData" data-side-pagination="server"
				data-pagination="true" data-page-list="[5, 10, 20]">
					<thead>
						<tr>
							<th data-field="bpName">流程定义名</th>
							<th data-field="version">版本</th>
							<th data-field="loanType">贷款类型</th>
							<th data-field="productKey">产品ID</th>
							<th data-formatter="operateFormatter" data-events="operateEvents" class="l_cz2">操作</th>
						</tr>
					</thead>
				</table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
 <script type="text/javascript">
 var  $table = $("#flow_table");
 $(function(){
	 $("#add_flow_btn").click(function(){
		 $("#addFlowModal").showModal();
	 });
 });
 function operateFormatter(value, row, index){
	 return '<lable ><a  id="o_nodes">节点配置</a></lable><lable ><a  id="o_forms">表单配置</a></lable><lable ><a  id="o_copy">拷贝流程到公司</a></lable>';
 }
 

 window.operateEvents = {
 		'click #o_nodes' : function(e, value, row) {
 			window.location.href="${ctx}/flow/nodes/loadNodeManager?bpDefId="+row.bpDefId;
 		},
 		'click #o_forms' : function(e, value, row) {
 			window.location.href="${ctx}/flow/forms/loadFormsManager?bpDefId="+row.bpDefId;
 		},
 		'click #o_copy' : function(e, value, row) {
 			worf.ajax({
		 		url : web_root+'/flow/flow/copy',
		 		type : 'post',
		 		data:{"bpDefId":row.bpDefId},
		 		success : function(data) {
		 			alert("拷贝完毕")
		 		}
		 	});
 		}
 		
 };
 </script>
 <%@ include file="./modal/addFlow.jsp"%>
</body>
</html>