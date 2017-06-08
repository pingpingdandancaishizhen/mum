<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>

<link rel="stylesheet" href="${ctx}/static/assets/plugins/jQuery-city/css/animate.min.css${timeStyle}">
<link rel="stylesheet" href="${ctx}/static/assets/plugins/position/base.css${timeStyle}"/>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/position/big-window.css${timeStyle}"/>
<script src="${ctx}/static/assets/plugins/position/position.data.min.js${timeStyle}" type="text/javascript"></script>
<script src="${ctx}/static/assets/plugins/position/jquery.position.select.js${timeStyle}" type="text/javascript"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/main.css${timeStyle}"/>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/css/city-picker.css${timeStyle}"/>
<script src="${ctx}/static/assets/plugins/city-picker/city-picker.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/webuploader/webuploader.css${timeStyle}"/>
<script src="${ctx}/static/assets/plugins/webuploader/webuploader.js${timeStyle}"></script>

</head>
<body  class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content content-padding">
		<div class="search-box" id="searchbar">
			<form class="form-inline form-label-auto" role="form">
				<shiro:hasPermission name="partner:search">
					<div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right" >参与方</label>
							<input type="text" class="form-control" name="name" placeholder="输入参与方名称搜索">
						</div>

					</div>
					<div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right" >机构代码</label>
							<input type="text" class="form-control" name="code" placeholder="输入机构代码搜索">
						</div>

					</div>
					<div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right" >参与方类别</label>
							<select  class="form-control" name="type">
								<option value="">请选择</option>
								<option value="1">个人</option>
								<option value="2">企业</option>
							</select>
						</div>

					</div>
				</shiro:hasPermission>
			</form>
		</div>
		<div class="table-top-tool">
			<shiro:hasPermission name="partner:add">
				<div class="btn btn-primary btn-primary-lg" id="add_partner_btn">
					<i class="icon icon-plus"></i>
					<span>新增</span>
				</div>
			</shiro:hasPermission>
			<div class="btn btn-primary btn-primary-lg" id="btn_search">
				<i class="icon icon-search"></i>
				<span>查询</span>
			</div>
		</div>
		<div id="toolbar">
			<div class="btn-group">
				<shiro:hasPermission name="partner:delete">
					<div class="btn btn-white" id="delete_partner_btn">
						<span>删除</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="partner:edit">
					<div class="btn btn-white" id="edit_partner_btn">
						<span>修改</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="partner:view">
					<div class="btn btn-white" id="view_partner_btn">
						<span>查看</span>
					</div>
				</shiro:hasPermission>
			</div>
		</div>
		<table class="table  table-striped table-hover" id="contractPartner_table" data-toggle="table" style="width:2000px "
			   data-url="${ctx}/system/partner/queryAllPartnerList"
			   data-method="get" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestData" data-query-params-type=""
			   data-click-to-select="true"
			   data-single-select="true"
			   data-select-item-name="id"
			   data-checkbox-header="true"
			   data-page-number=1 data-page-size=5
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[5, 10, 20]" data-toolbar="#toolbar">
			<thead>
			<tr>
				<th data-field="state" data-checkbox="true"></th>
				<th data-formatter="indexFormatter">ID</th>
				<th data-field="name">参与方企业/法人名称</th>
				<th data-field="roles" data-width="20%">参与方类型</th>
				<th data-field="type" data-formatter="typeFormatter">参与方类别</th>
				<th data-field="code" data-width="180">机构代码/身份证号</th>
				<th data-field="phone">联系电话</th>
				<th data-field="address">通讯地址</th>
				<th data-field="email">邮箱地址</th>
				<th data-field="fax">传真号</th>
				<th data-formatter="sealResourseFormatter">企业/法人公章</th>
				<th data-formatter="signResourseFormatter">法人签名</th>
				<th data-field="creator">创建人</th>
				<th data-field="createTime" data-formatter="timeFormatter" data-width="160">创建日期</th>

			</tr>
			</thead>
		</table>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
</body>
<shiro:hasPermission name="partner:add">
	<%@ include file="./modal/addPartner.jsp"%>
</shiro:hasPermission>
<shiro:hasPermission name="partner:view">
	<%@ include file="./modal/viewPartner.jsp"%>
</shiro:hasPermission>
<shiro:hasPermission name="partner:view">
	<%@ include file="./modal/viewSign.jsp"%>
</shiro:hasPermission>
<script type="text/javascript" src="${ctx}/static/pagejs/system/partner/contractPartner.js"></script>
</html>