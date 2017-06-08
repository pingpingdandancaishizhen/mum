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
				<div class="form-group col-md-3 row-left ">
					<div class="input-group">
						<label class="label-head text-right">产品名称</label>
						<input type="text" class="form-control" name="productName"  placeholder="输入产品名称搜索">
					</div>

				</div>
			</form>
		</div>
		<div class="table-top-tool">
			<div class="btn btn-primary btn-primary-lg" id="btn_search">
				<i class="icon icon-search"></i>
				<span>查询</span>
			</div>
		</div>
		<table class="table  table-striped table-hover table-responsive" id="product_table" data-toggle="table"
			   data-url="${ctx}/solution/product/queryProductListCorp"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestData" data-query-params-type=""
			   data-page-number=1 data-page-size=5
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[5, 10, 20]">
			<thead>
			<tr>
				<th data-field="productName">产品名称</th>
				<th data-field="productTypeStr">产品类型</th>
				<th data-field="mediumStr">贷款介质</th>
				<th data-field="desc">产品定义</th>
				<!-- <th data-field="statusStr">状态</th> -->
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
var $table = $("#product_table");
$(function () { 
		$.ajaxload();
});
function operateFormatter(value, row, index) {
	var row1,row2,row3;

	row1='<shiro:hasPermission name="product:modify"><div class="btn btn-white" id="o_modify"><span>修改基本信息</span></div></shiro:hasPermission>';


	row2='<shiro:hasPermission name="product:feeconfig"><div class="btn btn-white" id="o_fee_config"><span>费用配置</span></div></shiro:hasPermission>';

	row3='<shiro:hasPermission name="product:partnerconfig"><div class="btn btn-white" id="o_partner_config"><span>参与方配置</span></div></shiro:hasPermission>';

	return '<div class="btn-group-edit" >'+[row1,row2,row3].join('')+'</div>';
}
 </script>
 <%@ include file="./modal/modifyProduct.jsp"%>
<script type="text/javascript" src="${ctx}/static/pagejs/solution/product/product.js"></script>
</body>
</html>