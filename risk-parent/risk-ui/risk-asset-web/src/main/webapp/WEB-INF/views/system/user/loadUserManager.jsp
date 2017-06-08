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
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right" >登录名</label>
						<input type="text" class="form-control" name="userAccount"  placeholder="输入登录名搜索">
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right" >姓名</label>
						<input type="text" class="form-control" name="userName" placeholder="输入姓名搜索">
					</div>

				</div>
			</form>
		</div>
		<div class="table-top-tool">
			<shiro:hasPermission name="user:add">
				<div class="btn btn-primary btn-primary-lg" id="add_user_btn">
					<i class="icon icon-plus"></i>
					<span>新增员工</span>
				</div>
			</shiro:hasPermission>
			<div class="btn btn-primary btn-primary-lg" id="btn_search">
				<i class="icon icon-search"></i>
				<span>查询</span>
			</div>
		</div>
		<table class="table  table-striped table-hover" id="corpUser_table" data-toggle="table"
			   data-url="${ctx}/system/user/queryUserList"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestData" data-query-params-type=""
			   data-page-number=1 data-page-size=5
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[5, 10, 20]" >
			<thead>
			<tr>
				<th data-field="userAccount">登录名</th>
				<th data-field="userName">真实姓名</th>
				<th data-field="deptName" data-width="300">所属机构</th>
				<th data-field="roleNames" data-width="400">角色</th>
				<th data-field="job">职称</th>
				<th data-field="telephone">手机号码</th>
				<th data-field="email">Email</th>
				<th data-field="idcard">身份证</th>
				<th data-field="statusStr">状态</th>
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
var $table = $("#corpUser_table");
$(function () { 
		$.ajaxload();
});
function operateFormatter(value, row, index) {
	var row_0 = '<shiro:hasPermission name="user:view"><div class="btn btn-white" id="o_view"><span>查看</span></div></shiro:hasPermission>';
	var row_1 = '<shiro:hasPermission name="user:modify"><div class="btn btn-white" id="o_modify"><span>修改</span></div></shiro:hasPermission>';
	var row_2,row_3,row_4;
	if(!row.admin){
		if(row.status==0){
			row_2 = '<shiro:hasPermission name="user:status"><div class="btn btn-white" id="o_status"><span>停用</span></div></shiro:hasPermission>';
		}else{
			row_2 = '<shiro:hasPermission name="user:status"><div class="btn btn-white" id="o_status"><span>启用</span></div></shiro:hasPermission>';
			row_3 = '<shiro:hasPermission name="user:delete"><div class="btn btn-white" id="o_delete"><span>删除</span></div></shiro:hasPermission>';
		}
	}
	row_4 = '<shiro:hasPermission name="user:password"><div class="btn btn-white" id="o_password"><span>重置密码</span></div></shiro:hasPermission>';

	return '<div class="btn-group-edit"  style="min-width: 288px;">'+ [row_0,row_1, row_2, row_3,row_4 ].join(' ')+'</div>';
}
 </script>
<script type="text/javascript" src="${ctx}/static/pagejs/system/user/user.js"></script>
 <shiro:hasPermission name="user:view">
 <%@ include file="./modal/viewCorpUser.jsp"%>
 </shiro:hasPermission>
 <shiro:hasPermission name="user:add">
 <%@ include file="./modal/addCorpUser.jsp"%>
 </shiro:hasPermission>
  <shiro:hasPermission name="user:modify">
 <%@ include file="./modal/modifyCorpUser.jsp"%>
 </shiro:hasPermission>
   <shiro:hasPermission name="user:password">
 <%@ include file="./modal/resetPassword.jsp"%>
 </shiro:hasPermission>
  <%@ include file="./modal/deptTree.jsp"%>
<shiro:hasPermission name="user:status">
     <script type="text/javascript" src="${ctx}/static/pagejs/system/user/user-changestatus.js"></script>
</shiro:hasPermission>
<shiro:hasPermission name="user:delete">
     <script type="text/javascript" src="${ctx}/static/pagejs/system/user/user-delete.js"></script>
</shiro:hasPermission>
</body>
</html>