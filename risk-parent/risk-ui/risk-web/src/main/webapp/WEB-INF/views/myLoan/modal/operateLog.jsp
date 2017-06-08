<%@ page contentType="text/html;charset=UTF-8"%>
<!-- 时间范围控件引入 -->
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
<!-- 时间范围控件引入 -->

<div class="modal" id="BPLogModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">日志</h4>
		</div>
		<div class="modal-body ">
			<div class="nav-tabs-custom">
	            <ul class="nav nav-tabs row">
	              <li class="active"><a href="#operLog" data-toggle="tab">操作日志</a></li>
	              <li><a href="#reviewLog" data-toggle="tab">审核日志</a></li>
	            </ul>
	            <div class="tab-content">
	            	<div class="tab-pane active" id="operLog">
	            		<div class="panel-body">
							<div class="" id="searchLogbar">
								<form onsubmit="return false;"  class="form-inline form-label-auto" role="form">

									<div class="form-group col-sm-5 row-left">
										<div class="input-group">
											<label class="label-head text-right">操作人</label>
											<input type="text" class="form-control" name="operUserName"  placeholder="输入操作人搜索">
										</div>

									</div>

									<div class="form-group col-sm-5 row-left">
										<div class="input-group">
											<label class="label-head text-right">操作时间</label>
											<input type="text" class="form-control" id="reservationtime"  placeholder="选取操作时间搜索"  readonly="readonly" >
											<input type="hidden" name="start" id="start">
											<input type="hidden" name="end" id="end">
										</div>

									</div>
									<div class="form-group col-sm-2 row-left">
										<div class="btn btn-primary btn-primary-lg" id="btn_log_search">
											<i class="icon icon-search"></i>
											<span>查询</span>
										</div>
									</div>
								</form>
							</div>
							<table class="table  table-striped table-hover" id="BP_Operlog_table" data-toggle="table"
							data-url="${ctx}/loan/queryOperLog"
							data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
							data-query-params="requestOperLogData" data-query-params-type=""
							data-click-to-select="true" 
							data-single-select="true" 
							data-select-item-name="id"
							data-checkbox-header="true"
							data-page-number=1 data-page-size=5
							data-response-handler="responseData" data-side-pagination="server"
							data-pagination="true" data-page-list="[5, 10, 20]" >
								<thead>
									<tr>
										<th data-field="operUserName">操作人</th>
										<th data-field="logTime">操作时间</th>
										<th data-field="content">内容</th>
									</tr>
								</thead>
							</table>
						</div>
	            	</div>
	              	<div class="tab-pane" id="reviewLog">
	              		<div class="panel-body">
							<div class="" id="searchLogbar">
								<form onsubmit="return false;"  class="form-inline form-label-auto" role="form">
									<div class="form-group col-sm-5 row-left">
										<div class="input-group">
											<label class="label-head text-right">操作人</label>
											<input type="text" class="form-control" name="operUserName"  placeholder="输入操作人搜索">
										</div>

									</div>
									<div class="form-group col-sm-5 row-left">
										<div class="input-group">
											<label class="label-head text-right">操作时间</label>
											<input type="text" class="form-control" id="reservationtime"  placeholder="选取操作时间搜索"  readonly="readonly" >
											<input type="hidden" name="start" id="start">
											<input type="hidden" name="end" id="end">
										</div>

									</div>
									<div class="form-group col-sm-2 row-left">
										<div class="btn btn-primary btn-primary-lg" id="btn_log_search">
											<i class="icon icon-search"></i>
											<span>查询</span>
										</div>
									</div>
								</form>
							</div>
							
							<table class="table  table-striped table-hover" id="BP_Reviewlog_table" data-toggle="table"
							data-url="${ctx}/loan/queryOperReviewLog"
							data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
							data-query-params="requestReviewLogData" data-query-params-type=""
							data-click-to-select="true" 
							data-single-select="true" 
							data-select-item-name="id"
							data-checkbox-header="true"
							data-page-number=1 data-page-size=5
							data-response-handler="responseData" data-side-pagination="server"
							data-pagination="true" data-page-list="[5, 10, 20]" >
								<thead>
									<tr>
										<th data-field="operUserName">操作人</th>
										<th data-field="logTime">操作时间</th>
										<th data-field="content" data-formatter="contentFormatter">内容</th>
									</tr>
								</thead>
							</table>
						</div>
	            	</div>
	            </div>
	            <!-- /.tab-content -->
	          </div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/loanApply/myLoan/myLoan-log.js"></script>