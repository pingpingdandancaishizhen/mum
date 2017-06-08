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
    <section class="content content-padding">
        <div class="search-box" id="searchbar">
            <form onsubmit="return false;"  class="form-inline form-label-auto" >
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right"  >角色名</label>
                        <input type="text" class="form-control" name="roleName"  placeholder="输入角色名搜索">
                    </div>

                </div>
            </form>
        </div>
        <div class="table-top-tool">
            <shiro:hasPermission name="role:add">
                <div class="btn btn-primary btn-primary-lg" id="add_role_btn">
                    <i class="icon icon-plus"></i>
                    <span>新增功能角色</span>
                </div>
            </shiro:hasPermission>
            <div class="btn btn-primary btn-primary-lg" id="btn_search">
                <i class="icon icon-search"></i>
                <span>查询</span>
            </div>
        </div>
        <table class="table  table-striped table-hover" id="role_table" data-toggle="table"
               data-url="${ctx}/system/role/queryRoleList"
               data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
               data-query-params="requestData" data-query-params-type=""
               data-page-number=1 data-page-size=5
               data-response-handler="responseData" data-side-pagination="server"
               data-pagination="true" data-page-list="[5, 10, 20]" >
            <thead>
            <tr>
                <th data-field="roleName">角色名</th>
                <th data-field="menus">功能权限分配</th>
                <th data-field="desc">角色描述</th>
                <th data-formatter="operateFormatter" data-events="operateEvents" class="l_cz2" data-width="250">操作</th>
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
var $table = $("#role_table");
function operateFormatter(value, row, index) {
	if(row.isCanModify=='0' || row.isAdmin == '1'){
		return '-';
	}
	var row_1 = '<shiro:hasPermission name="role:modify"><div class="btn btn-white" id="o_modify"><span>修改</span></div></shiro:hasPermission>';
	var row_2,row_3;
	if(row.status==0){
		row_2 = '<shiro:hasPermission name="role:status"><div class="btn btn-white" id="o_status"><span>停用</span></div></shiro:hasPermission>';
	}else{
        row_2 = '<shiro:hasPermission name="role:status"><div class="btn btn-white" id="o_status"><span>启用</span></div></shiro:hasPermission>';
        row_3 = '<shiro:hasPermission name="role:delete"><div class="btn btn-white" id="o_delete"><span>删除</span></div></shiro:hasPermission>';
	}
	return '<div class="btn-group-edit">'+ [row_1, row_2, row_3 ].join(' ')+'</div>';
}
 </script>
  <script type="text/javascript" src="${ctx}/static/pagejs/system/role/role.js${timeStyle}"></script>
 <shiro:hasPermission name="role:add">
 <%@ include file="./modal/addRole.jsp"%>
 </shiro:hasPermission>
 <shiro:hasPermission name="role:modify">
 <%@ include file="./modal/modifyRole.jsp"%>
 </shiro:hasPermission>
<shiro:hasPermission name="role:status">
 <script type="text/javascript" src="${ctx}/static/pagejs/system/role/role-changestatus.js${timeStyle}"></script>
 </shiro:hasPermission>
 <shiro:hasPermission name="role:delete">
 <script type="text/javascript" src="${ctx}/static/pagejs/system/role/role-delete.js${timeStyle}"></script>
 </shiro:hasPermission>
</body>
</html>