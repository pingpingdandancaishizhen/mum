<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>风控SAAS</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.min.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.min.css${timeStyle}">
<link rel="stylesheet" href="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.print.css${timeStyle}"  media="print">

<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
</head>
<body  class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content content-padding">
			<div class="search-box" id="searchbar">
				<form onsubmit="return false;" id="form" class="form-inline form-label-auto" role="form">
					<div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right">渠道商名称</label>
                            <input type="text" class="form-control" id="channelName" name="channelName" placeholder="输入订单号搜索">
                        </div>
                    </div>
                    
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right" >申请日期</label>
	                        <input type="text" class="form-control" id="reservationtime" readonly="readonly">
	                        <input type="hidden" id="startDate" name="startDate">
	                        <input type="hidden" id="endDate" name="endDate">
                        </div>
                    </div>
                </form>
			</div>
			<div class="table-top-tool">
				<div class="btn btn-primary btn-primary-lg" id="btn_search">
					<i class="icon icon-search"></i>
					<span>查询</span>
				</div>
				<div class="btn btn-primary btn-primary-lg" id="btn_add">
					<i class="icon icon-plus"></i>
					<span>新增渠道商</span>
				</div>
				<!--<div class="btn btn-primary btn-primary-lg" id="btn_reset">
	                <span>重置</span>
	            </div>-->
			</div>

			<div id="toolbar">
				
                    <div class="btn btn-white" id="btn_modify">
                        <span>修改渠道商</span>
                    </div>
				
			</div>
			
            <table class="table table-bordered table-hover" id="channel_table" 
                    data-toggle="table"
                    data-url="${ctx}/channel/loadAllChannel"
                    data-method="post" 
                    data-cache="false" 
                    data-content-type="application/x-www-form-urlencoded"
                    data-query-params="requestData" 
                    data-query-params-type=""
                    data-click-to-select="true" 
                    data-single-select="true" 
                    data-select-item-name="channelId"
                    data-checkbox-header="true"
                    data-page-number=1 
                    data-page-size=10
                    data-response-handler="responseData" 
                    data-side-pagination="server"
                    data-pagination="true" 
                    data-page-list="[5, 10, 20]" 
                    data-toolbar="#toolbar">
                    <thead>
                        <tr>
                            <th data-field="state" data-checkbox="true"></th>
                            <th data-field="channelName">渠道商名称</th>
                            <th data-field="poundage">手续费</th>
                            <th data-field="interest">利息</th>
                            <th data-field="updateTime" data-formatter="timeFormatter">更新日期</th>
                        </tr>
                    </thead>
            </table>
	</section>
    <!-- /.content -->
</div>
</body>
<script type="text/javascript" src="${ctx}/static/pagejs/installment/channel.js${timeStyle}"></script>
</html>