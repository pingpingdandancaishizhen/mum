<%@ page contentType="text/html;charset=UTF-8"%>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/bootstrap-treeview/css/bootstrap-treeview.css">
<script src="${ctx}/static/assets/plugins/bootstrap-treeview/js/bootstrap-treeview.js"></script>

<div class="modal" id="addRoleModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增数据角色</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal form-label-auto" id="addRoleForm" action="${ctx}/system/dataRole/addDataRole" method="post">
				 <div class="box-body">
					 <div class="col-sm-12">
						 <div class="form-group input-group ">
							 <label for="roleName" class="label-head label-head-top text-right"><span class="require">角色名称：</span></label>
							 <input type="text" maxlength="20" class="form-control" id="roleName" name="roleName" >
						 </div>
						 <div class="form-group input-group">
							 <label for="desc" class="label-head label-head-top text-right"><span>角色描述：</span></label>
							 <textarea class="form-control" maxlength="60" rows="3" id="desc" name="desc"></textarea>
						 </div>
						 <div class="form-group input-group">
							 <input type="hidden" id="deptStr" name="deptStr"/>
							 <label class="label-head  text-right"><span class="require">权限分配：</span></label>
							 <div class="label-box ">
								 <label class="label-box-item "><input data-type="secmenu" id="selfOnly" name="selfOnly" value="1" type="checkbox"><span>仅自己</span></label>
								 <label class="label-box-item "><input data-type="secmenu" id="deptOnly" name="deptOnly" value="1" type="checkbox"><span>仅本部门</span></label>

							 </div>
						 </div>
						 <div class="form-group input-group">
							 <label class="label-head label-head-top text-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							 <div class="label-box tree-form" id="depts">
								 <div class="item-box-main label-box" id="treeTableHtml"></div>
							 </div>
							 <small id="validate_dept" style="display:none;color:#dd4b39 ;">请选择部门</small>
						 </div>
					 </div>

					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="saveRoleBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/system/dataRole/dataRole-add.js${timeStyle}"></script>