<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>风控SAAS</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
<!-- 上传工具 -->
<link rel="stylesheet" href="${ctx}/static/assets/plugins/webuploader/webuploader.css"/>
<script src="${ctx}/static/assets/plugins/webuploader/webuploader.js"></script>
</head>
<body  class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Main content -->
    <section class="content content-padding">
					<div  class="search-box" id="searchbar"	>
						<form onsubmit="return false;"  class="form-inline form-label-auto" role="form" id="searchForm">
						<div  class="form-group col-md-4 row-left"	>
							<div class="input-group">
							   <label class="label-head label-head-lg text-right" >企业名称:</label>
							   <input type="text" class="form-control" name="corpName" placeholder="输入企业名称">
						   	</div>
					   	</div>
					   	<div  class="form-group col-md-4 row-left"	>
						<div class="input-group">
						   <label class="label-head label-head-lg text-right" >产品类型:</label>
						   <select type="text" class="form-control" name="product">
						   		<option value="">请选择</option>
                               <c:forEach items="${productTypes}" var="t">
                                   <option value="${t.id}"
                                   > ${t.name}</option>
                               </c:forEach>
						   </select>
					   	</div>
					 </div>
					<div  class="form-group col-md-4 row-left"	>
					 <div class="input-group">
                           <label class="label-head label-head-lg text-right" >资产方归属:</label>
                           <select type="text" class="form-control"  name="assetType">
                               <option value="">请选择</option>
                               <c:forEach items="${assetType}" var="type">
                                   <option value="${type.typeId}"
                                   <c:if test="${type.selected}">
                                       selected="selected"
                                   </c:if>
                                   > ${type.typeName}</option>
                               </c:forEach>
                           </select>
                       </div>
                         </div>
                        <div  class="form-group col-md-4 row-left"	>
                        <div class="input-group">
						   	<label class="label-head label-head-lg  text-right" >创建日期:</label>
						   	<input type="text" class="form-control" id="reservationtime" readonly="readonly" >
						   	<input id="createTimeFrom" name="createTimeFrom" type="hidden">
						   	<input id="createTimeTo" name="createTimeTo" type="hidden">
					   	</div>            
                        </div>
						
						</form>
					</div>
					
					<div class="table-top-tool">
						<div class="btn btn-primary btn-primary-lg" id="btn_search">
							<i class="icon icon-search"></i>
							<span>查询</span>
						</div>
						<div type="reset" class="btn btn-primary btn-primary-lg" id="btn_reset">
			               <span>重置</span> 
			            </div>
					</div>
		
		
		      
		      	<div id="toolbar">
		      		<div class="btn-group">
                   <shiro:hasPermission name="p2passet:add">
                        <div class="btn btn-white" id="add_btn">
                            <span>新增资产方</span>
                        </div>
                    </shiro:hasPermission>
                    </div>
                    <div class="btn-group">
                    <shiro:hasPermission name="p2passet:edit">
                        <div class="btn btn-white" id="edit_btn">
                            <span>修改资产方</span>
                        </div>
                    </shiro:hasPermission>
                    </div>
                    <div class="btn-group">
                    <shiro:hasPermission name="p2passet:configureProduct">
                        <div class="btn btn-white" id="configure_product_all_btn">
                            <span>配置产品</span>
                        </div>
                    </shiro:hasPermission>
                    </div>
                    <div class="btn-group">
                    <shiro:hasPermission name="p2passet:editProduct">
                        <div class="btn btn-white" id="edit_product_all_btn">
                            <span>修改产品</span>
                        </div>
                    </shiro:hasPermission>
                    </div>
                </div>
           		<table class="table table-hover" id="p2pAsset_table" data-toggle="table"
				data-url="${ctx}/asset/queryAsset"
				data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				data-query-params="requestData" data-query-params-type=""
				data-click-to-select="true" 
				data-single-select="true" 
				data-select-item-name="id"
				data-checkbox-header="true"
				data-page-number=1 data-page-size=10
				data-response-handler="responseData" data-side-pagination="server"
				data-pagination="true" data-page-list="[10, 15, 20]"  data-toolbar="#toolbar">
					<thead>
						<tr>
							<th data-field="state" data-checkbox="true"></th>
							<th data-field="id">ID</th>
							<th data-field="corpAbbreviation">企业简称</th>
							<th data-field="assetTypeName">资产方归属</th>
							<th data-field="">资金成本</th>
							<th data-field="assetProduct">产品类型</th>
							<th data-field="createTime" data-formatter="timeFormatter">创建时间</th>
							<th data-field="createrName">创建人</th>
						</tr>
					</thead>
				</table>
            
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	<script type="text/javascript" src="${ctx}/static/pagejs/system/partnerCorp/partnerCorpListManage.js${timeStyle}"></script>
</body>
</html>