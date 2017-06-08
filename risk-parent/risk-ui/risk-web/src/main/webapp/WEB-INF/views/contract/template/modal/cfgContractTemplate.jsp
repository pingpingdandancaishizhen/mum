<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="cfgContractTemplateModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">合同模板字段配置</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="custom-form" id="cfgContractTemplateForm" action="${ctx}/contract/template/saveTemplateConfig" method="post">
					<input type="hidden" id="tempId" name="tempId">
					<div class="panel panel-default">
						<div class="panel-heading">
							字段配置
						</div>
						<div class="panel-body no-padding bootstrap-table">
							<table id="field_table" class="table  table-striped"></table>
						</div>
						<!-- /.panel-body -->
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<shiro:hasPermission name="temp:config">
				<button type="submit" class="btn btn-primary" id="saveFieldBtn" data-loading-text="确定中...">确定</button>
			</shiro:hasPermission>
			<div  class="btn btn-cancel" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/contract/template/template-cfg.js"></script>
