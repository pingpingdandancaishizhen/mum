<%@ page contentType="text/html;charset=UTF-8"%>
<style>
.partnerDiv label {
	display: inline-block;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-left: 10px;
}
</style>
<div class="modal" id="addContractTemplateModal" tabindex="-1"
	role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">新增合同模板</h4>
			</div>
			<div class="modal-body">
				<form onsubmit="return false;" class="form-inline form-label-auto custom-form"
					  id="addContractTemplateForm"
					  action="${ctx}/contract/template/saveTemplate" method="post">
					<input type="hidden" id="id" name="id" value=""> <input
						type="hidden" id="status" name="status" value="1">
					<div class="panel-body">
						<div class="form-group col-md-12">
							<div class=" input-group">
								<label for="product" class="label-head label-head-top label-head-lg require">所属产品：</label>
								<select class="form-control" id="product" name="product"
										value="">
									<option value="">请选择</option>
									<c:forEach items="${productList}" var="product">
										<option value="${product.id}">${product.productName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label for="templateName" class="label-head label-head-top label-head-lg require">合同名称：</label>
								<input type="text" maxlength="40" class="form-control"
									   id="templateName" name="templateName" value="">
							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label for="fileResource" class="label-head label-head-top label-head-lg require">合同模板：</label>
								<div class="uploadFileDiv">
									<div class="input-group uploadFile">
										<input type="text" id="fileResource" class="hiddenInput" name="fileResource">
										<input type="text" id="fileName" class="hiddenInput" name="fileName">
										<div class="form-control">
											<div class="uploadFileName"></div>
											<div class="fileNote"></div>
										</div>
										<div class="input-group-btn">
											<div class="btn btn-upload deleteFileBtn">
												<i class="glyphicon glyphicon-trash"></i> <span>删除</span>
											</div>
											<!--<div class="btn btn-upload uploadFileBtn">
												<div>
													<i class="glyphicon glyphicon-upload"></i> <span>上传</span>
												</div>
											</div>-->
											<div class="btn btn-upload " id="pick-temp"></div>
										</div>
									</div>
								</div>
							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label for="templateDesc" class="label-head label-head-top label-head-lg">合同描述：</label>
								<textarea class="form-control" id="templateDesc"
										  name="templateDesc"></textarea>
							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label class="label-head label-head-lg " >主合同：</label>
								<div class="checkbox label-box">
									<label class="label-box-item">
										<input type="checkbox" id="mainFlag" name="mainFlag" value="1">是
									</label>

								</div>

							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label for="partnerIds" class="label-head label-head-top label-head-lg  require">参与方：</label>
								<div  class="col-sm-12 row partnerDiv has-feedback-border">
									<div class="checkbox label-box" id="partner">
									</div>
								</div>
							</div>

						</div>
					</div>

				</form>

			</div>
			<div class="modal-footer">
				<shiro:hasPermission name="temp:add">
					<button type="submit" class="btn btn-primary" id="saveTemplateBtn" data-loading-text="确定中...">确定</button>
				</shiro:hasPermission>
				<div  class="btn btn-default" data-dismiss="modal">取消</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/contract/template/template-add.js"></script>
