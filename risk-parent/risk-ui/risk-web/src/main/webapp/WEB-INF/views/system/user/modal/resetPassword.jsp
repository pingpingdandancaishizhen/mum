<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="resetPasswordModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg" style="width: 600px;">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">重置密码</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-inline form-label-auto" id="resetpasswordForm" action="${ctx}/system/user/resetPassword" method="post">
				 <div class="box-body">
						<div class="form-group input-group">
							<label for="password" class="label-head label-head-top require text-left">新密码：</label>
							<input type="hidden" id="id" name="id" >
							<input type="text" maxlength="20" class="form-control" id="password" name="password" >
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="savepasswordBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/system/user/user-resetpassword.js"></script>