<%@ page contentType="text/html;charset=UTF-8"%>
<style>
.partnerDiv label{display: inline-block;margin: 10px;}
</style>
<div class="modal" id="viewContractTemplateModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><p id="title_view">查看合同模板</p></h4>
			</div>
			<div class="modal-body">
				<form onsubmit="return false;"  class="form-inline form-label-auto custom-form" id="viewContractTemplateForm" action="#">
					<div class="panel-body">
						<div class="form-group col-md-12">
							<div class="input-group">
								<label class="label-head label-head-top label-head-lg">所属产品：</label>
								<select class="form-control" id="product-view" disabled="disabled">
									<option value="">请选择</option>
									<c:forEach items="${productList}" var="product">
										<option value="${product.id}">${product.productName}</option>
									</c:forEach>
								</select>
							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label class="label-head label-head-top label-head-lg">合同名称：</label>
								<div class="form-control" id="templateName-view"></div>
							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label class="label-head label-head-top label-head-lg">合同模板：</label>
								<div class="form-control" id = "file-view"></div>
							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label class="label-head label-head-top label-head-lg">合同描述：</label>
								<div class="form-control" id="templateDesc-view"></div>
							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label class="label-head label-head-top label-head-lg">主合同：</label>
								<div id="mainFlag-view">

								</div>
							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label  class="label-head label-head-top label-head-lg ">参与方：</label>
								<div  class="col-sm-12 row partnerDiv has-feedback-border">
									<div class="checkbox label-box" id="partner-view">
									</div>
								</div>
							</div>

						</div>
						<div class="form-group col-md-12">
							<div class="input-group">
								<label class="label-head label-head-top label-head-lg">配置：</label>
								<div class="col-sm-12 bootstrap-table">
									<table class="table  table-striped " id="config-view"></table>
								</div>
							</div>

						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<div  class="btn btn-cancel" data-dismiss="modal">返回</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/contract/template/template-view.js"></script>
