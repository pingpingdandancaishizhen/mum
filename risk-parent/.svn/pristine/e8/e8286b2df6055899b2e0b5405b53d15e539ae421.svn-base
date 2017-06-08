<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal" id="selectProductModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg" style="width:80%;">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">选择产品</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="selectProductForm"  method="post">
				 <div class="box-body">
						<div class="form-group">
							<label for="productId" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>产品：</label>
							<div class="col-sm-8">
								<select class="form-control" id="productId" name="productId" >
								<c:forEach items="${productList}" var="product">
									<option value="${product.id}">${product.productName}(${product.productTypeStr})</option>
								</c:forEach>
								</select>
								<input type="hidden" name="customerId" id="customerId"  value="-1"/>
							</div>
						</div>
						<div class="form-group">
							<label for="productId" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>归属分公司：</label>
							<div class="col-sm-8">
								<select class="form-control" id="deptId" name="deptId" >
									<c:forEach items="${corpDeptList}" var="dept">
										<option value="${dept.id}">${dept.deptName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="productId" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>归属业务员：</label>
							<div class="col-sm-8">
								<c:forEach items="${corpUserMap}" var="userList" varStatus="index">
									<select class="form-control userCorpIdSelect" id="${userList.key}" 
									<c:if test="${index.count eq 0}">
									 name="userCorpId"</c:if>
									<c:if test="${index.count gt 1}">
									 style="display: none;"</c:if>>
										<c:forEach items="${userList.value}" var="user">
											<option value="${user.id}">${user.userName}</option>
										</c:forEach>
									</select>
								</c:forEach>
							</div>
						</div>
					</div>
				</form>
			</div>
			<hr/>
			<div class="panel-body">
					<div class="search-box" id="customerSearchbar" style="border-bottom: 0px;">
						<form onsubmit="return false;" class="form-label-auto form-inline" role="form">
							<input type="hidden" name="uid" id="uid"/>
							<div class="form-group col-md-3 row-left">
								<div class="input-group">
									<label class="label-head text-right">客户姓名</label> <input
										type="text" class="form-control" name="name"
										placeholder="输入客户姓名搜索">
								</div>
							</div>
							<div class="form-group col-md-3  row-left">
								<div class="input-group">
									<label class="label-head text-right">身份证号</label> <input
										type="text" class="form-control " name="licenseNum"
										placeholder="输入身份证号搜索">
								</div>

							</div>
						</form>
					</div>
					<div class="table-top-tool">
						<div class="btn btn-primary btn-primary-lg" id="btn_search_customer">
							<i class="icon icon-search"></i> <span>查询</span>
						</div>
					</div>
					<table class="table  table-striped table-hover" id="customer_table"
						data-toggle="table"
						data-url="${ctx}/system/customer/queryCustomer" data-method="post"
						data-cache="false"
						data-content-type="application/x-www-form-urlencoded"
						data-query-params="requestCustomerData" data-query-params-type=""
						data-click-to-select="true" data-single-select="true"
						data-select-item-name="id" data-checkbox-header="true"
						data-page-number=1 data-page-size=5
						data-response-handler="responseData" data-side-pagination="server"
						data-pagination="true" data-page-list="[5, 10, 20]">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th data-field="typeName">客户类型</th>
								<th data-field="name">客户姓名</th>
								<th data-field="genderName">性别</th>
								<th data-field="licenseNum">证件号码</th>
								<th data-field="mobile">移动电话</th>
								<th data-field="createTime" data-formatter="timeFormatter">创建时间</th>
							</tr>
						</thead>
					</table>
				</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="selectProductBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/index/todoList.js${timeStyle}"></script>