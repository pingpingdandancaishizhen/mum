<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal" id="selectProductModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
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
								<input type="hidden" name="customerId" id="customerId"/>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="selectProductBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/system/customer/applay-loan.js"></script>