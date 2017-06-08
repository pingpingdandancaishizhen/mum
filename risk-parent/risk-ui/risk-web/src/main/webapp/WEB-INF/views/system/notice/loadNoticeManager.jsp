<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
</head>
<body  class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content content-padding">
		<div class="search-box" id="searchbar">
			<form onsubmit="return false;"  class="form-inline form-label-auto" role="form">
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right" >公告内容</label>
						<input type="text" class="form-control" name="artContent"  placeholder="输入公告内容搜索">
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right" >公告分类</label>
						<select  class="form-control" name="typeId">
							<option value="">请选择</option>
							<c:forEach items="${types}" var="type">
								<option value="${type.typeId}">${type.typeTitle}</option>
							</c:forEach>
						</select>
					</div>

				</div>

				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right" >状态</label>
						<select  class="form-control" name="status">
							<option value="">请选择</option>
							<c:forEach items="${status}" var="stat">
								<option value="${stat.status}">${stat.statusName}</option>
							</c:forEach>
						</select>
					</div>


				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right" >发布人</label>
						<input type="text" class="form-control" name="artWriter" placeholder="输入姓名搜索">
					</div>

				</div>
				<div class="form-group col-md-3 row-left">
					<div class="input-group">
						<label class="label-head text-right" >发布时间</label>
						<input type="text" class="form-control" id="reservationtime" readonly="readonly"  >
						<input type="hidden" id="startTime" name="startTime">
						<input type="hidden" id="endTime" name="endTime">
					</div>

				</div>
			</form>
		</div>
		<div class="table-top-tool">
			<shiro:hasPermission name="notice:add">
				<div class="btn btn-primary btn-primary-lg" id="add_notice_btn">
					<i class="icon icon-plus"></i>
					<span>新增</span>
				</div>
				<!--<button id="add_notice_btn" type="button" class="btn btn-block btn-primary">新增</button>-->
			</shiro:hasPermission>
			<div class="btn btn-primary btn-primary-lg" id="btn_search">
				<i class="icon icon-search"></i>
				<span>查询</span>
			</div>
		</div>
		<div id="toolbar">
			<div class="btn-group">
				<shiro:hasPermission name="notice:delete">
					<div class="btn btn-white" id="delete_notice_btn">

						<span>删除</span>
					</div>
					<!--<button id="delete_notice_btn" type="button" class="btn btn-block btn-primary">删除</button>-->
				</shiro:hasPermission>
				<shiro:hasPermission name="notice:modify">
					<div class="btn btn-white" id="edit_notice_btn">

						<span>修改</span>
					</div>
					<!--<button id="edit_notice_btn" type="button" class="btn btn-block btn-primary">修改</button>-->
				</shiro:hasPermission>
				<shiro:hasPermission name="notice:disable">
					<div class="btn btn-white" id="disable_notice_btn">

						<span>下架</span>
					</div>
					<!--<button id="disable_notice_btn" type="button" class="btn btn-block btn-primary">下架</button>-->
				</shiro:hasPermission>
				<shiro:hasPermission name="notice:enable">
					<div class="btn btn-white" id="enable_notice_btn">
						<span>发布</span>
					</div>
					<!--<button id="enable_notice_btn" type="button" class="btn btn-block btn-primary">发布</button>-->
				</shiro:hasPermission>
			</div>

		</div>
		<table class="table  table-striped table-hover" id="notice_table" data-toggle="table"
			   data-url="${ctx}/system/notice/queryCorpNotice"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestData" data-query-params-type=""
			   data-click-to-select="true"
			   data-single-select="true"
			   data-select-item-name="id"
			   data-checkbox-header="true"
			   data-page-number=1 data-page-size=5
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[5, 10, 20]" data-toolbar="#toolbar">
			<thead>
			<tr>
				<th data-field="state" data-checkbox="true"></th>
				<th data-field="artContent">公告内容</th>
				<th data-field="typeName">公告分类</th>
				<th data-field="artWriterName">创建人</th>
				<th data-field="artTime" data-formatter="timeFormatter">创建时间</th>
				<th data-field="statusName">状态</th>
				<th data-field="artReviewerName">发布人</th>
				<th data-field="reviewTime" data-formatter="timeFormatter">发布时间</th>
			</tr>
			</thead>
		</table>
    </section>
    <shiro:hasPermission name="notice:add">
  		<%@ include file="./modal/addNotice.jsp"%>
  </shiro:hasPermission>
  <shiro:hasPermission name="notice:add">
  		<%@ include file="./modal/modifyNotice.jsp"%>
  </shiro:hasPermission>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
 <script type="text/javascript">
 	var ctx = '${ctx}';
 	
 	var $table = $("#notice_table");
 	
 	function timeFormatter(value){
 		if(value && value != ''){
 			return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
 		}
 	}
	//双选时间插件使用方法
	var $reservationtime=$('#reservationtime');
	$reservationtime.daterangepicker({
		ranges : {
			//'最近1小时': [moment().subtract('hours',1), moment()],
			'今日': [moment().startOf('day'), moment()],
			'昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
			'最近7日': [moment().subtract(6,'days'), moment()],
			'最近30日': [moment().subtract(29,'days'), moment()]
		},
		"alwaysShowCalendars": true,
		"opens": "right",
		locale : {
			format : 'YYYY-MM-DD',
			applyLabel : '确定',
			cancelLabel : '取消',
			fromLabel : '起始时间',
			toLabel : '结束时间',
			customRangeLabel : '自定义',
			daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
			monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
				'七月', '八月', '九月', '十月', '十一月', '十二月' ],
			firstDay : 1
		}
	}, function (start, end) {
		$("#startTime").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#endTime").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	$reservationtime.on('cancel.daterangepicker',function () {
		$(this).val('');
		$("#startTime").val('');
		$("#endTime").val('');
	});
	$reservationtime.on('apply.daterangepicker',function (el,daterangepicker) {
		var start=daterangepicker.startDate;
		var end=daterangepicker.endDate;
		$("#startTime").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#endTime").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
 	
 	function clearTime(){
 		$('#reservationtime').val("");
 		$("#startTime").val("");
		$("#endTime").val("");
 	}

 	$(function(){
 		$('#reservationtime').val("");
 		$("#btn_search").bind("click",function() {
 			$table.bootstrapTable('refresh');
 		});
 	});
 </script>
 <shiro:hasPermission name="notice:add">
  	<script type="text/javascript" src="${ctx}/static/pagejs/system/notice/notice-add.js"></script>
  </shiro:hasPermission>
  <shiro:hasPermission name="notice:enable">
  	<script type="text/javascript" src="${ctx}/static/pagejs/system/notice/notice-enable.js"></script>
  </shiro:hasPermission>
  <shiro:hasPermission name="notice:disable">
  	<script type="text/javascript" src="${ctx}/static/pagejs/system/notice/notice-disable.js"></script>
  </shiro:hasPermission>
  <shiro:hasPermission name="notice:delete">
  	<script type="text/javascript" src="${ctx}/static/pagejs/system/notice/notice-delete.js"></script>
  </shiro:hasPermission>
  <shiro:hasPermission name="notice:modify">
  	<script type="text/javascript" src="${ctx}/static/pagejs/system/notice/notice-edit.js"></script>
  </shiro:hasPermission>
</body>
</html>