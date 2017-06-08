<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="dayEventModal" tabindex="-1" role="dialog" aria-expanded="true" >
	<div class="modal-dialog modal-lg" style="width: 600px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">行程事件</h4>
			</div>
			<div class="modal-body">
				<div class="panel-body">
					<div class="box-body ">
						<div class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-3 control-label">行程说明：</label>
								<div class="col-sm-9">
									<textArea class="form-control" name="eventContent"></textArea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">行程时间：</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" readonly name="eventTime">
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div  class="btn btn-default delBtn" data-loading-text="删除中" autocomplete="off">删除</div>
				<div  class="btn btn-default confirmBtn" data-loading-text="确定中" autocomplete="off">确定</div>
				<div  class="btn btn-default" data-dismiss="modal" >取消</div>
			</div>
		</div>
	</div>
</div>
