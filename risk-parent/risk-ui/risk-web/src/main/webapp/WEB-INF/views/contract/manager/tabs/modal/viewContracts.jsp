<%@ page contentType="text/html;charset=UTF-8"%>

<div class="modal" id="viewContractsModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">所有合同</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<div class="form-group  clearfix">
					<div class="col-sm-5">
						<label class="control-label col-sm-5">客户姓名：</label>
						<p class="col-sm-7" id="cust_name_view"></p>
					</div>
					<div class="col-sm-7">
						<label class="control-label col-sm-3">订单号：</label>
						<p class="col-sm-9" id="contract_no_view"></p>
					</div>
				</div>
				<div class="bootstrap-table">
					<table id="contracts_table" class="table  table-striped"></table>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<div class="btn btn-default" data-dismiss="modal">返回</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/contract/manager/contracts-view.js${timeStyle}"></script>
