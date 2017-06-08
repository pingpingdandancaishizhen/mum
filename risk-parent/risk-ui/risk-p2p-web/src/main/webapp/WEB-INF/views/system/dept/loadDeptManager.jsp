<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>P2P发标系统</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/bootstrap-treeview/css/bootstrap-treeview.css${timeStyle}">
<script src="${ctx}/static/assets/plugins/bootstrap-treeview/js/bootstrap-treeview.js${timeStyle}"></script>

<link rel="stylesheet" href="${ctx}/static/assets/plugins/bootstrap-table/bootstrap-table-tree-column.css${timeStyle}">
<script src="${ctx}/static/assets/plugins/bootstrap-table/bootstrap-table-tree-column.js${timeStyle}"></script>

<link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/main.css${timeStyle}"/>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/css/city-picker.css${timeStyle}"/>
<script src="${ctx}/static/assets/plugins/city-picker/city-picker.js${timeStyle}"></script>

</head>
<body  class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content content-padding">
        <div class="table-box">
            <div class="table-top-tool">
                <shiro:hasPermission name="dept:add">
                    <div class="btn btn-primary btn-primary-lg" id="add_dept_btn">
                        <i class="icon icon-plus"></i>
                        <span>新增</span>
                    </div>
                    <!--<button  id="add_dept_btn" type="button" class="btn  btn-primary col-sm-2">新增</button>-->
                </shiro:hasPermission>
            </div>
            <div id="toolbar">
                <div class="btn-ground">
                    <shiro:hasPermission name="dept:modify">
                        <div class="btn btn-white" id="edit_dept_btn">
                            <span>修改</span>
                        </div>
                        <!--<button id="edit_dept_btn" type="button" class="btn  btn-primary col-sm-2">修改</button>-->
                    </shiro:hasPermission>
                    <shiro:hasPermission name="dept:status">
                        <div class="btn btn-white" id="enable_dept_btn">
                            <span>启用</span>
                        </div>
                        <!--<button id="enable_dept_btn" type="button" class="btn  btn-primary col-sm-2">启用</button>-->
                    </shiro:hasPermission>
                    <shiro:hasPermission name="dept:status">
                        <div class="btn btn-white" id="disable_dept_btn">
                            <span>停用</span>
                        </div>
                        <!--<button id="disable_dept_btn" type="button" class="btn  btn-primary col-sm-2">停用</button>-->
                    </shiro:hasPermission>
                    <shiro:hasPermission name="dept:delete">
                        <div class="btn btn-white" id="delete_dept_btn">
                            <span>删除</span>
                        </div>
                        <!--<button id="delete_dept_btn" type="button" class="btn  btn-primary col-sm-2">删除</button>-->
                    </shiro:hasPermission>
                </div>
            </div>
            <table class="table  table-striped table-hover" id="dept_table">
                <thead>
                <tr>
                    <th data-field="state" data-checkbox="true"></th>
                    <th data-field="deptCode">机构代码</th>
                    <th data-field="deptName" data-width="300">机构名称</th>
                    <th data-field="level">机构级别</th>
                    <th data-field="deptShortName">机构简称</th>
                    <th data-field="deptType"  data-formatter="deptTypeFormatter">机构类型</th>
                    <th data-field="createTime" data-formatter="timeFormatter" >机构创建日期</th>
                    <th data-field="status" data-formatter="forbiddenTimeFormatter">机构停用日期</th>
                    <th data-field="status" data-formatter="statusFormatter">状态</th>
                    <th data-field="deptHead">机构负责人</th>
                    <th data-field="deptPhone" data-formatter="phoneFormatter">机构联系电话</th>
                    <th data-formatter="addrFormatter">机构地址</th>
                </tr>
                </thead>
            </table>
        </div>
    </section>

    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <shiro:hasPermission name="dept:add">
  	<%@ include file="./modal/addCorpDept.jsp"%>
  </shiro:hasPermission>
  <shiro:hasPermission name="dept:modify">
  	<%@ include file="./modal/modifyCorpDept.jsp"%>
  </shiro:hasPermission>
 <script type="text/javascript">
 	var ctx = '${ctx}';
    function timeFormatter(value){
        if(value && value != ''){
            return tools.formatDate(value,'YYYY-MM-DD')
        }
    }
    function addrFormatter(v,o){
        var deptAddr=o.deptAddr||'-';
        var deptAddrDetail=o.deptAddrDetail||'-';
    	return deptAddr+'/'+deptAddrDetail;
    }
    function deptTypeFormatter(v,o){
    	if(v == null){
    		return '-';
    	}
    	var s ={'':'-','1':'营业门店','2':'审批机构','3':'管理机构'};
    	return s[v];
    }
    
    function phoneFormatter(v,o){
    	if(v != null && /^1(3|4|5|7|8)\d{9}$/.test(v)){
    		return v.substring(0,3) + "****" + v.substring(7,11);
    	} else {
    		return v;
    	}
    }
    
    function forbiddenTimeFormatter(v,o) {
    	if(v == "1"){
    		if(o.updateTime && o.updateTime != ''){
                return tools.formatDate(o.updateTime,'YYYY-MM-DD')
            } 
    	} else {
    		return '-';
    	}
    }
    
    function statusFormatter(v,o){
    	if(v == null){
    		return '-';
    	}
    	if(v == "0"){
    		return '启用';
    	}
    	if(v == "1"){
    		return '停用';
    	}
    }
 </script>
  <script type="text/javascript" src="${ctx}/static/pagejs/system/dept/dept.js"></script>
  <script type="text/javascript" src="${ctx}/static/pagejs/system/dept/dept-changestatus.js"></script>
  <shiro:hasPermission name="dept:modify">
  	<script type="text/javascript" src="${ctx}/static/pagejs/system/dept/dept-modify.js"></script>
  </shiro:hasPermission>
</body>
</html>