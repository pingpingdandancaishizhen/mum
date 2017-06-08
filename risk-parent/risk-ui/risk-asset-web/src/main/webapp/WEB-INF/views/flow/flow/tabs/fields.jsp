<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tab-pane" id="fields">
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
					   <button id="add_fields_btn" type="button" class="btn btn-block btn-info">新增表单字段</button>
			   </p>
		      </div>
              <table class="table  table-striped table-hover" id="fields_table" data-toggle="table"
				data-url="${ctx}/flow/forms/queryMetaFieldsTemplates"
				data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				data-query-params="requestData" data-query-params-type=""
				data-page-number=1 data-page-size=20
				data-response-handler="responseData" data-side-pagination="server"
				data-pagination="true" data-page-list="[5, 10, 20]">
					<thead>
						<tr>
							<th data-field="fieldId">fieldId</th>
							<th data-field="bpDefId">bpDefId</th>
							<th data-field="fieldKey">fieldKey</th>
							<th data-field="fieldName">fieldName</th>
							<th data-field="fieldDesc">fieldDesc</th>
							<th data-field="datatype">datatype</th>
							<th data-field="fieldTable">fieldTable</th>
							<th data-field="isAttr">isAttr</th>
							<th data-field="checkRule">checkRule</th>
							<th data-field="category">category</th>
							<th data-field="defaultOrder">defaultOrder</th>
							<th data-field="dataProvider">dataProvider</th>
							<th data-field="defaultValue">defaultValue</th>
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

 var  $table = $("#fields_table");
 $(function(){
	 $("#add_fields_btn").click(function(){
		 $("#addFieldsModal #bpDefId").val('${bpDefId}');
			worf.ajax({
		 		url : web_root+'/flow/forms/queryMetaCategoryTemplatesAll',
		 		type : 'post',
		 		data:{"bpDefId":'${bpDefId}'},
		 		success : function(data) {
		 			$("#addFieldsModal #category").empty();
		 			if(data.status==1){
		 				$.each(data.data,function(i,value){
		 					$("#addFieldsModal #category").append("<option value='"+value.categoryKey+"'>"+value.name+"</option>")
		 				});
		 				 
		 			}
		 		}
		 	});
		 $("#addFieldsModal").showModal();
	 });
 });
 

 </script>
 <%@ include file="../modal/addFields.jsp"%>