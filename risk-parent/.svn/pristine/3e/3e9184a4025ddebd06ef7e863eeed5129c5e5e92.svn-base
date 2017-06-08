<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body  class="hold-transition ">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content content-padding">
		<div class="search-box" id="searchbar">
			<form onsubmit="return false;"  class="form-label-auto form-inline" role="form">
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">客户姓名</label>
						<input type="text" class="form-control" name="name"  placeholder="输入客户姓名搜索">
					</div>

				</div>
				<div class="form-group col-md-3  row-left">
					<div class="input-group">
						<label class="label-head text-right">客户类型</label>
						<select class="form-control" name="type">
							<option value="">请选择</option>
							<c:forEach items="${types}" var="type">
								<option value="${type.typeId}">${type.typeName}</option>
							</c:forEach>
						</select>
					</div>

				</div>

				<div class="form-group col-md-3  row-left">
					<div class="input-group">
						<label class="label-head text-right">性别</label>
						<select  class="form-control" name="gender">
							<option value="">请选择</option>
							<c:forEach items="${genders}" var="gender">
								<option value="${gender.type}">${gender.name}</option>
							</c:forEach>
						</select>
					</div>

				</div>
				<div class="form-group col-md-3  row-left">
					<div class="input-group">
						<label class="label-head text-right">手机号</label>
						<input type="text" class="form-control" name="mobile"  placeholder="输入手机号搜索">
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right">身份证号</label>
						<input type="text" class="form-control" name="licenseNum"  placeholder="输入身份证号搜索">
					</div>

				</div>
				<!--<div class="form-group">
					<div class="input-group">

					</div>
					<div  id="btn_search" class="btn btn-block btn-warning">搜索</div>
				</div>
				<div class="form-group">
					<button type="reset" id="btn_reset" class="btn btn-block btn-default">重置</button>
				</div>-->
			</form>
		</div>
		<div class="table-top-tool">
			<div class="btn btn-primary btn-primary-lg" id="btn_search">
				<i class="icon icon-search"></i>
				<span>查询</span>
			</div>
		</div>
		<div id="toolbar">
			<div>
				<shiro:hasPermission name="allCust:add">
					<div class="btn btn-white" id="add_blacklist_btn">
						<span>加入黑名单</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="allCust:log">
					<div class="btn btn-white" id="customer_log_btn">

						<span>日志</span>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="allCust:detail">
					<div class="btn btn-white" id="customer_detail_btn">
						<span>查看</span>
					</div>
				</shiro:hasPermission>
			</div>
		</div>
		<table class="table  table-striped table-hover" id="customer_table" data-toggle="table"
			   data-url="${ctx}/system/customer/queryAllCustomer"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestData" data-query-params-type=""
			   data-click-to-select="true"
			   data-single-select="true"
			   data-select-item-name="id"
			   data-checkbox-header="true"
			   data-page-number=1 data-page-size=5
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[5, 10, 20]"  data-toolbar="#toolbar">
			<thead>
			<tr>
				<th data-field="state" data-checkbox="true"></th>
				<th data-field="typeName">客户类型</th>
				<th data-field="name">客户姓名</th>
				<th data-field="genderName">性别</th>
				<th data-field="mobile">移动电话</th>
				<th data-field="maritalStatusName">婚姻</th>
				<th data-field="licenseNum">证件号码</th>
				<th data-field="liveAddr">现住地</th>
				<th data-field="registAddr">户口所在地</th>
				<th data-field="createTime" data-formatter="timeFormatter">创建时间</th>
				<th data-field="createrName">创建人</th>
			</tr>
			</thead>
		</table>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <shiro:hasPermission name="allCust:log">
  	<%@ include file="./modal/operateLog.jsp"%>
  </shiro:hasPermission>
  
 <script type="text/javascript" src="${ctx}/static/pagejs/system/allCustomer/allCustomer.js"></script>
 
</body>
</html>