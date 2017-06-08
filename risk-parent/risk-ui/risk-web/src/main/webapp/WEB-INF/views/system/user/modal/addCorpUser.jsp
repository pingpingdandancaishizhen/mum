<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="addCorpUserModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg " style="width: 600px;">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增员工</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-inline form-label-auto" id="addCorpUserForm" action="${ctx}/system/user/addUser" method="post">
				 <div class="box-body">
						<div class="col-md-8 ">
							<div class=" col-md-12 row-left">
								<div class="input-group form-group">
									<label for="userAccount" class="label-head label-head-top require text-right">登录名：</label>
									<input type="text" maxlength="20" class="form-control" id="userAccount" name="userAccount" >
								</div>

							</div>
							<div class=" col-md-12 row-left">
								<div class="input-group form-group">
									<label for="userName" class="label-head label-head-top text-right require">姓名：</label>
									<input type="text" maxlength="20" class="form-control" id="userName" name="userName" >
								</div>
							</div>
							<div class=" col-md-12 row-left">
								<div class="input-group form-group">
									<label for="password" class="label-head label-head-top text-right require">初始密码：</label>
									<input type="text" maxlength="20" class="form-control" id="password" name="password"  value="A123456">
								</div>
							</div>
							<div class=" col-md-12 row-left">
								<div class="input-group form-group">
									<label for="telephone" class="label-head label-head-top text-right require">手机号码：</label>
									<input type="text" maxlength="11" class="form-control" id="telephone" name="telephone">
								</div>
								
							</div>
							<div class=" col-md-12 row-left">
								<div class="input-group form-group">
									<label for="deptName" class="label-head label-head-top text-right"><span class="require">所属机构：</span></label>
									<input type="text" class="form-control" id="deptName" name="deptName" readonly>
									<input type="hidden" class="form-control" id="deptId" name="deptId" >
									<i class="fa fa-angle-down input-select-icon"></i>
								</div>
								
							</div>
						</div>
					 	<!--<div class=" col-md-4 ">
							<div class="photo-default">
								<img src="${ctx}/static/assets/dist/img/photo-default.png" alt="">
							</div>
							<div class="btn-center">
								<div class="btn btn-primary">上传图像</div>
							</div>
						</div>-->
						<div class=" col-md-12 ">
							<div class="input-group form-group">
								<label  class="label-head label-head-top text-right require" >功能角色：</label>
								<div class="label-box label-box-top "  id="roles" >
								</div>
							</div>


						</div>
						<div class=" col-md-12 ">
							<div class="input-group form-group">
								<label  class="label-head text-right label-head-top require">数据角色：</label>
								<div class="label-box label-box-top "  id="dataRoles" >
								</div>
							</div>

						</div>
						<div class=" col-md-12 ">
							<div class="input-group form-group">
								<label for="job" class="label-head label-head-top text-right">职称：</label>
								<input type="text" maxlength="20" class="form-control" id="job" name="job">
							</div>
						</div>
						<div class=" col-md-12 ">
							<div class="input-group form-group">
								<label for="email" class="label-head label-head-top text-right">Email：</label>
								<input type="text" class="form-control" id="email" name="email">
							</div>
						</div>
						<div class=" col-md-12 ">
							<div class="input-group form-group">
								<label for="idcard" class="label-head label-head-top text-right">身份证号：</label>
								<input type="text" maxlength="18" class="form-control" id="idcard" name="idcard">
							</div>
						</div>
						<div class=" col-md-12 ">
							<div class="input-group form-group">
								<label for="desc" class="label-head label-head-top text-right label-head-top">个人简介：</label>
								<textarea class="form-control" maxlength="100" rows="3" id="desc" name="desc"></textarea>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary" id="saveCorpUserBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/system/user/user-add.js?v=2"></script>