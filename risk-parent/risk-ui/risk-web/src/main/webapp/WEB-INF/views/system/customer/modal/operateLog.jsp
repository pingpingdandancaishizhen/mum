<%@ page contentType="text/html;charset=UTF-8"%>
<!-- 时间范围控件引入 -->
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
<!-- 时间范围控件引入 -->

<div class="modal" id="customerLogModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">客户日志</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<div class="" id="searchLogbar">
					<form onsubmit="return false;"  class="form-inline form-label-auto" role="form">

						<div class="form-group col-md-5 row-left">
							<div class="input-group">
								<label class="label-head text-right">操作人</label>
								<input type="text" class="form-control" name="operaterName"  placeholder="输入操作人搜索">
							</div>

						</div>

						<div class="form-group col-md-5 row-left">
							<div class="input-group">
								<label class="label-head text-right">操作时间</label>
								<input type="text" class="form-control" id="reservationtime"  placeholder="选取操作时间搜索"  readonly="readonly" >
								<input type="hidden" name="startTime" id="startTime">
								<input type="hidden" name="endTime" id="endTime">
							</div>

						</div>
						<div class="form-group col-md-2 row-left">
							<div class="btn btn-primary btn-primary-lg" id="btn_log_search">
								<i class="icon icon-search"></i>
								<span>查询</span>
							</div>
						</div>
					</form>
				</div>
				
				<table class="table  table-striped table-hover" id="custlog_table" data-toggle="table"
				data-url="${ctx}/system/customer/customerLog"
				data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				data-query-params="requestLogData" data-query-params-type=""
				data-click-to-select="true" 
				data-single-select="true" 
				data-select-item-name="id"
				data-checkbox-header="true"
				data-page-number=1 data-page-size=5
				data-response-handler="responseData" data-side-pagination="server"
				data-pagination="true" data-page-list="[5, 10, 20]" >
					<thead>
						<tr>
							<th data-field="operTime" data-formatter="timeFormatter">操作时间</th>
							<th data-field="operDetail">内容</th>
							<th data-field="operaterName">操作人</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		<div class="modal-footer">
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/system/customer/customer-log.js${timeStyle}"></script>