<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tab-pane" id="operations">
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
					   <div class="form-group">
					   		<input type="hidden" id="bpDefId" name="bpDefId" value="${bpDefId}"/>
						   <div  id="btn_search" class="btn btn-block btn-warning">搜索</div>
					   </div>
				   </form>
			   </div>
			   <p class=" col-sm-2">
					   <button id="add_operations_btn" type="button" class="btn btn-block btn-info">新增表单操作</button>
			   </p>
		      </div>
              <table class="table  table-striped table-hover" id="operations_table" data-toggle="table"
				data-url="${ctx}/flow/forms/queryMetaOperationsTemplates"
				data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				data-query-params="requestData" data-query-params-type=""
				data-page-number=1 data-page-size=5
				data-response-handler="responseData" data-side-pagination="server"
				data-pagination="true" data-page-list="[5, 10, 20]">
					<thead>
						<tr>
							<th data-field="operationId">operationId</th>
							<th data-field="bpDefId">bpDefId</th>
							<th data-field="operKey">operKey</th>
							<th data-field="operName">operName</th>
							<th data-field="operDesc">operDesc</th>
							<th data-field="binding">binding</th>
							<th data-field="isBasic">isBasic</th>
							<th data-field="preCondition">preCondition</th>
							<th data-field="postCondition">postCondition</th>
							<th data-field="operType">operType</th>
							<th data-field="nodeKey">nodeKey</th>
						</tr>
					</thead>
				</table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
	
</div>
 
<script type="text/javascript">

 var  $table = $("#operations_table");
 $(function(){
	 $("#add_operations_btn").click(function(){
		 $("#addOperationsModal #bpDefId").val('${bpDefId}');
		 $("#addOperationsModal").showModal();
	 });
 });
 

 </script>
 <%@ include file="../modal/addOperations.jsp"%>