<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tab-pane" id="forms">
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
					   <button id="add_forms_btn" type="button" class="btn btn-block btn-info">新增表单</button>
			   </p>
		      </div>
              <table class="table  table-striped table-hover" id="forms_table" data-toggle="table"
				data-url="${ctx}/flow/forms/queryMetaFormsTemplates"
				data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				data-query-params="requestData" data-query-params-type=""
				data-page-number=1 data-page-size=5
				data-response-handler="responseData" data-side-pagination="server"
				data-pagination="true" data-page-list="[5, 10, 20]">
					<thead>
						<tr>
							<th data-field="formId">formId</th>
							<th data-field="bpDefId">bpDefId</th>
							<th data-field="formKey">formKey</th>
							<th data-field="formName">formName</th>
							<th data-field="formDesc">formDesc</th>
						<!-- 	<th data-field="operations">operations</th> -->
							<!-- <th data-field="layout">layout</th> -->
							<th data-field="isOutside">isOutside</th>
						<!-- 	<th data-field="formId">formHtml</th> -->
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

 var  $table = $("#forms_table");
 $(function(){
	 $("#add_forms_btn").click(function(){
		 $("#addFormsModal #bpDefId").val('${bpDefId}');
		 $("#addFormsModal").showModal();
	 });
 });
 

 </script>
 <%@ include file="../modal/addForms.jsp"%>