<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal" id="addNoticeModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增系统公告</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body" id="addNoticeForm">
				<form onsubmit="return false;"  class="form-horizontal"  action="${ctx}/system/notice/addNotice" method="post">
				 <div class="box-body">
						<div class="form-group">
							<label class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>公告内容：</label>
							<div class="col-sm-8">
								<textarea class="form-control" rows="3" placeholder="请输入公告内容..." name="artContent"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="typeId" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>公告分类：</label>
							<div class="col-sm-8">
								<select  class="form-control" id="typeId" name="typeId">
									<option value="">请选择</option>
						   		<c:forEach items="${types}" var="type">
						   			<option value="${type.typeId}">${type.typeTitle}</option>
						   		</c:forEach>
								</select>
							</div>
						</div>
						
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary btn-primary-lg" id="saveNoticeBtn" data-loading-text="确定中...">确定</button>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
