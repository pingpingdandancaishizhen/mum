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
       	流程节点管理
        <small></small>
      </h1> 
      <ol class="breadcrumb">
         <li><a href="${ctx}/flow/flow/loadFlowManager"><i class="fa fa-dashboard"></i> 流程定义管理</a></li>
        <li class="active"><a href="${ctx}/flow/nodes/loadNodeManager">流程节点管理</a></li>
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
           <div class="bs-example" id="searchbar">
			   <div class="col-sm-12">
				   <form onsubmit="return false;"  class="form-inline" role="form">
				   	<input type="hidden" name="bpDefId" value="${bpDefId}"/>
					   <div class="form-group">
						   <div  id="btn_search" class="btn btn-block btn-warning">搜索</div>
					   </div>
				   </form>
			   </div>
			   <p class=" col-sm-2">
			   </p>
		      </div>
              <table class="table  table-striped table-hover" id="node_table" data-toggle="table"
				data-url="${ctx}/flow/nodes/queryMetaNodesTemplates"
				data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				data-query-params="requestData" data-query-params-type=""
				data-page-number=1 data-page-size=20
				data-response-handler="responseData" data-side-pagination="server"
				data-pagination="true" data-page-list="[5, 10, 20]">
					<thead>
						<tr>
							<th data-field="nodeId">nodeId</th>
							<th data-field="nodeKey">nodeKey</th>
							<th data-field="nodeName">nodeName</th>
							<th data-field="nodeType">nodeType</th>
							<th data-field="formKey">formKey</th>
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
 var  $table = $("#node_table");
 function operateFormatter(value, row, index){
	 return '<lable ><a  id="o_operations">关联操作</a></lable>'+'<lable ><a id="o_forms">关联表单</a></lable>';
 }

 window.operateEvents = {
 		'click #o_forms' : function(e, value, row) {
 			//关联表单
 			$("#relateFormModal #bpDefId").val(row.bpDefId); 
 			$("#relateFormModal #nodeId").val(row.nodeId); 
 			worf.ajax({
 		 		url : web_root+'/flow/forms/queryMetaFormsTemplatesAll',
 		 		type : 'post',
 		 		data:{"bpDefId":'${bpDefId}'},
 		 		success : function(data) {
 		 			$("#relateFormModal #formKey").empty();
 		 			if(data.status==1){
 		 				$.each(data.data,function(i,value){
 		 					$("#relateFormModal #formKey").append("<option value='"+value.formKey+"'>"+value.formName+"</option>")
 		 				});
 		 				 
 		 			}
 		 		}
 		 	});
 		 $("#relateFormModal").showModal();
 		}, 
 	 		'click #o_operations' : function(e, value, row) {
 	 			//关联表单
 	 			$("#relateOperationModal #bpDefId").val(row.bpDefId); 
 	 			$("#relateOperationModal #nodeKey").val(row.nodeKey); 
 	 			worf.ajax({
 	 		 		url : web_root+'/flow/forms/queryMetaOperationsTemplatesAll',
 	 		 		type : 'post',
 	 		 		data:{"bpDefId":'${bpDefId}'},
 	 		 		success : function(data) {
 	 		 			$("#relateOperationModal #operationIds").empty();
 	 		 			if(data.status==1){
 	 		 				$.each(data.data,function(i,value){
 	 		 					$("#relateOperationModal #operationIds").append("<option value='"+value.operationId+"'>"+value.operName+'-'+value.operDesc+"</option>")
 	 		 				});
 	 		 			}
 	 		 		}
 	 		 	});
 	 		 $("#relateOperationModal").showModal();
 	 		}
 		
 };
 </script>
  <%@ include file="./modal/relateOperation.jsp"%>
 <%@ include file="./modal/relateForm.jsp"%>
</body>
</html>