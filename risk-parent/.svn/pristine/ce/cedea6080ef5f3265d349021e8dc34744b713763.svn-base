<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal" id="assignModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">分配</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="assignForm"  method="post">
				 <div class="box-body">
						<div class="form-group">
							<label for="assignId" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>分配人员：</label>
							<div class="col-sm-8">
								<select class="form-control" id="assignId" name="assignId" >
								</select>
								<input type="hidden" name="bpId" id="bpId"/>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="assignBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/loanApply/myLoan/myLoan-assign.js"></script>