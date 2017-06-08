<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="relateFormModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">关联表单</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="relateFormForm" action="${ctx}/solution/workflow/relateForm" method="post">
				 <div class="box-body">
						<div class="form-group">
							<label for="userAccount" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>表单：</label>
							<input type="hidden" name="bpDefId" id="bpDefId"/>
							<input type="hidden" name="nodeId" id="nodeId" />
							<div class="col-sm-8">
								 <select id="formKey" name="formKey" class="form-control">
								 </select>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="relateFormBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
 <script type="text/javascript" src="${ctx}/static/pagejs/solution/workflow/workflow-form-related.js"></script>