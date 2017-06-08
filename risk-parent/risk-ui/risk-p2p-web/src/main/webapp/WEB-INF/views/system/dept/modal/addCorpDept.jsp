<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="addCorpDeptModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增机构</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="addCorpDeptForm" action="${ctx}/system/dept/addDept" method="post">
				 <div class="box-body">
						<div class="form-group">
							<label for="deptName" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>机构名称：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptName" name="deptName" maxlength="20">
							</div>
						</div>
						<div class="form-group">
							<label for="deptShortName" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>机构简称：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptShortName" name="deptShortName" maxlength="10">
							</div>
						</div>
						<div class="form-group">
							<label for="level" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>机构级别：</label>
							<div class="col-sm-8">
								<select  class="form-control" id="level" name="level">
									<option value="1">一级</option>
									<option value="2">二级</option>
									<option value="3">三级</option>
									<option value="4">四级</option>
									<option value="5">五级</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="parentCode" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>上级管理机构：</label>
							<div class="col-sm-8">
								<select  class="form-control" id="parentCode" name="parentCode">
									<option value="">请选择</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="dept" class="col-sm-2 control-label">机构性质：</label>
							<div class="col-sm-8">
								<select  class="form-control" id="deptType" name="deptType">
									<option value="">请选择</option>
									<option value="1">营业门店</option>
									<option value="2">审批机构</option>
									<option value="3">管理机构</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="roleId" class="col-sm-2 control-label">机构负责人：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptHead" name="deptHead"  maxlength="10">
							</div>
						</div>
						<div class="form-group">
							<label for="job" class="col-sm-2 control-label">机构联系电话：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptPhone" name="deptPhone" maxlength="12">
							</div>
						</div>
						<div class="form-group">
							<label for="deptAddr" class="col-sm-2 control-label">机构地址：</label>
							<div class="col-sm-8" id="deptAddrArea">
								<input type="text" maxlength="30" class="form-control" id="deptAddr" name="deptAddr" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label for="deptAddrDetail" class="col-sm-2 control-label">机构详细地址：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptAddrDetail" name="deptAddrDetail">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="saveCorpDeptBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" id="resetBtn" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/system/dept/dept-add.js"></script>
