<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal" id="modifyProductModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">修改产品基本信息</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="modifyProductForm" action="${ctx}/solution/product/modifyProduct" method="post">
				 <div class="box-body">
						<div class="form-group">
							<label for="productName" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>产品名称：</label>
							<div class="col-sm-8">
								<input type="text" maxlength="20" class="form-control" id="productName" name="productName" >
							</div>
						</div>
						<div class="form-group">
							<label for="desc" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>产品定义：</label>
							<div class="col-sm-8">
								<input type="hidden" id="id" name="id" >
								<textarea class="form-control" maxlength="200" rows="3" id="desc" name="desc"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="requirements" class="col-sm-2 control-label">产品要求：</label>
							<div class="col-sm-8">
								<textarea class="form-control" maxlength="1000" rows="10" id="requirements" name="requirements"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="productType" class="col-sm-2 control-label">产品类型：</label>
							<div class="col-sm-4">
								 <select id="productType" disabled="disabled" class="form-control">
								 	<c:forEach items="${productTypeEnum}" var="t">
								 		<option value="${t.status}">${t.label}</option>
								 	</c:forEach>
								 </select> 
								 </div>
								 <div class="col-sm-4">
								 <select id="medium" disabled="disabled" class="form-control">
								 	<c:forEach items="${productMediumEnum}" var="t">
								 		<option value="${t.status}">${t.label}</option>
								 	</c:forEach>
								 </select>
								 </div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary" id="modifyProductBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/solution/product/product-modify.js${timeStyle}"></script>