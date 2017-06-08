<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>P2P发标系统</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body  class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-body">
                <div id="toolbar">
                    <shiro:hasPermission name="role:add">
                        <div class="btn btn-white" id="yxzl_attach_up_table">
                            <i class="icon icon-plus"></i>
                            <span>影像资料</span>
                        </div>
                    </shiro:hasPermission>
               </div>
				<div class="bootstrap-table">
					<div class="fixed-table-container" style="padding-bottom: 0px;">
						
						<div class="fixed-table-body">
							<table class="table  table-striped table-hover">
							<thead>
							<tr>
								<th>ID</th>
								<th>附件名称</th>
								<th>状态</th>
								<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${atts}" var="att">
									<c:if test="${att.paramGroup==1}">
										<tr>
											<td>${att.id }</td>
											<td><input type="text" value="${att.paramValue}" name="paramValue"/></td>
											<td>
												<select name="status">
													<option value="1" >启用</option>
													<option value="0" >停用</option>
												</select>
											</td>
											<td>
											<div class="btn btn-white" onclick="saveRow(this,1,'attach')"><i class="fa fa-save"></i><span>保存</span></div>
											<div class="btn btn-white" onclick="removeRow(this)"><i class="fa fa-trash-o"></i><span>删除</span></div>
											</td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<div class="box-body">
                <div id="toolbar">
                    <shiro:hasPermission name="role:add">
                        <div class="btn btn-white" id="srzl_attach_up_table">
                            <i class="icon icon-plus"></i>
                            <span>收入资料</span>
                        </div>
                    </shiro:hasPermission>
               </div>
				<div class="bootstrap-table">
					<div class="fixed-table-container" style="padding-bottom: 0px;">
						
						<div class="fixed-table-body">
							<table class="table  table-striped table-hover">
							<thead>
							<tr>
								<th>ID</th>
								<th>附件名称</th>
								<th>状态</th>
								<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${atts}" var="att">
									<c:if test="${att.paramGroup==2}">
										<tr>
											<td>${att.id }</td>
											<td><input type="text" value="${att.paramValue}" name="paramValue"/></td>
											<td>
												<select name="status">
													<option value="1" >启用</option>
													<option value="0" >停用</option>
												</select>
											</td>
											<td>
											<div class="btn btn-white" onclick="saveRow(this,2,'attach')"><i class="fa fa-save"></i><span>保存</span></div>
											<div class="btn btn-white" onclick="removeRow(this)"><i class="fa fa-trash-o"></i><span>删除</span></div>
											</td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
							</table>
						</div>
					</div>
				</div>
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
$(function(){
	var _tr="<tr><td></td><td><input type='text' value='' name='paramValue'/></td>"+
	"<td><select name='status'><option value='1'>启用</option><option value='0'>停用</option></select>"+
	"</td><td><div class='btn btn-white' onclick='saveRow(this)'><i class='fa fa-save'></i><span>保存</span></div>"+
	"<div class='btn btn-white' onclick='removeRow(this)'><i class='fa fa-trash-o'></i><span>删除</span></div>"+
	"</td></tr>";
	$(".btn-white").bind("click",function(){
		$(this).parent().next().find("tbody").append(_tr);
	});
	
});
function removeRow(obj){
	$(obj).parent().parent().remove();
}
function saveRow(obj,_group,_type){
	var _id=$(obj).parent().siblings("td:first").text();
	var _paramName=$(obj).parent().siblings("td").find("input").val();
	var _status=$(obj).prev().find("select").val();
	$.post({
		url : web_root+'/system/param/saveAttachParam',
		type : 'post',
		dataType:'json',
		async:true,
		cache :false,
		data : {
			'id':_id,
			'paramName':_paramName,
			'paramGroup':_group,
			'status':_status,
			'paramType':_type
		},
		success : function(data) {
			if(data.status==1){
				$.showPop(data.message,"",1000);
				window.location.reload();
			}else{
				$.showPop(data.message,"",1000);
			}
		},
		error : function(){
			$.showPop('网络错误','',1000);
		},
	});
}
</script>
</body>
</html>