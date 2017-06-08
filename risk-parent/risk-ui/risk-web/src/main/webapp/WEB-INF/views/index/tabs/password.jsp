<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
	 <script type="text/javascript" src="${ctx}/static/assets/plugins/jquery-entropizer/js/entropizer.js${timeStyle}"></script>
    <script type="text/javascript" src="${ctx}/static/assets/plugins/jquery-entropizer/js/jquery-entropizer.js${timeStyle}"></script>
        <link type="text/css" rel="stylesheet" href="${ctx}/static/assets/plugins/jquery-entropizer/css/jquery-entropizer.min.css" />
<div class="tab-pane" id="modifypassword">
	<form onsubmit="return false;"  class="form-inline form-label-auto" id="passwordForm"
		action="${ctx}/system/user/changePassowrd" method="post">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class=" col-sm-8">
					<div class="form-group input-group">
						<label for="oldpassword" class="label-head label-head-llg text-right"><span class="require">旧密码：</span></label>
						<input type="text" maxlength="20" class="form-control" id="oldpassword"	name="oldpassword">
					</div>
				</div>
				<div class=" col-sm-8">
					<div class="form-group input-group">
						<label for="password" class="label-head label-head-llg text-right">新密码：</label>
						<input type="text" maxlength="20" class="form-control col-sm-8" id="password"	name="password" style="width: 100%;">
						<div class="pwdStrength" id="passwords"></div>

					</div>

				</div>
				<div class=" col-sm-8">
					<div class="input-group form-group">
						<label for="passwordr" class="label-head label-head-llg text-right">确认密码：</label>
						<input type="text" maxlength="20" class="form-control" id="passwordr"	name="passwordr">
					</div>
				</div>
				<div class="col-sm-8 text-center">
					<input type="submit" class="btn btn-primary btn-primary-lg" value="修改密码"/>
				</div>
			</div>
		</div>
		
	</form>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/index/password.js${timeStyle}"></script>