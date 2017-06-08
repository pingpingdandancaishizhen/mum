<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="modifyRoleModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">编辑功能角色</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-inline form-label-auto" id="modifyRoleForm" action="${ctx}/system/role/modifyRole" method="post" >
					<div class="box-body">
						<div class="form-group input-group">
							<input type="hidden" name="id" id="id"/>
							<label for="roleName" class="label-head label-head-top text-right require">角色名称：</label>
							<input type="text"  class="form-control" id="roleName" name="roleName" >
						</div>
						<div class="form-group input-group">
							<label for="desc" class="label-head label-head-top text-right">角色描述：</label>
							<textarea class="form-control" maxlength="60" rows="3" id="desc" name="desc"></textarea>
						</div>
						<div class="form-group input-group">
							<input type="hidden" id="menuStr" name="menuStr" value=""/>
							<input type="hidden" id="funcStr" name="funcStr" value=""/>
							<label for="menus" class="label-head label-head-top text-right require">权限分配：</label>
							<div class="label-box" id="menus">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="modifyRoleBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/system/role/role-modify.js${timeStyle}"></script>