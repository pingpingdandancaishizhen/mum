<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
  <title>风控SAAS</title>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
	<!-- Content Wrapper. Contains page content -->
	<div class="tab-pane " id="loadLoans_ins">
		<!-- Main content -->
		<section class="content content-padding">
			<div class="search-box" id="searchbar">
				<form onsubmit="return false;" id="form" class="form-inline form-label-auto" role="form">
                    
                    
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right" >日期</label>
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
			<!--<div class="btn btn-primary btn-primary-lg" id="btn_reset">
                <span>重置</span>
            </div>-->
		</div>

                <!-- <div id="toolbar">
                	<shiro:hasPermission name="loan:export">
                    <div class="btn-group">
                        <div class="btn btn-white" id="btn_export">
                            <i class="fa fa-plus"></i>
                            <span>下载excel表格</span>
                        </div>
                    </div>
                    </shiro:hasPermission>
                </div> -->
                <table class="table table-bordered table-hover" id="all_installment_table" 
                    data-toggle="table"
                    data-url="${ctx}/loans/queryAllInstallmentReport"
                    data-method="post" 
                    data-cache="false" 
                    data-content-type="application/x-www-form-urlencoded"
                    data-query-params="requestData" 
                    data-query-params-type=""
                    data-click-to-select="true" 
                    data-single-select="true" 
                    data-select-item-name="id"
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
                            <th data-field="insurerCode" data-width="300px">保险公司</th>
                            <th data-field="payTime">日期</th>
                            <th data-field="firstPaidCount">已付首付款订单数</th>
                            <th data-field="payAll">计划放款保费总额</th>
                            <th data-field="paidCount">实付订单数</th>
                            <th data-field="payAllAmount">实付保费总额</th>
                            <th data-field="notPayCount">未付订单数</th>
                            <th data-field="notPayAmount">未付保费总额</th>
                        </tr>
                    </thead>
                </table>
	</section>
    <!-- /.content -->
</div>
<script type="text/javascript">
var $table = $("#all_installment_table");
$(function(){
	$("#btn_search").bind("click",function() {
        $table.bootstrapTable('refresh');
    });
		//默认选中第一个tab
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
        $("#searchbar #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
        $("#searchbar #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
    });
    $reservationtime.on('cancel.daterangepicker',function () {
        $(this).val('');
        $("#searchbar #startDate").val('');
        $("#searchbar #endDate").val('');
    });
    $reservationtime.on('apply.daterangepicker',function (el,daterangepicker) {
        var start=daterangepicker.startDate;
        var end=daterangepicker.endDate;
        $("#searchbar #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
        $("#searchbar #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
    });
    //双选时间插件使用方法
    var $reservationtime1=$('#reservationtime1');
    $reservationtime1.daterangepicker({
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
        $("#searchbar1 #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
        $("#searchbar1 #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
    });
    $reservationtime1.on('cancel.daterangepicker',function () {
        $(this).val('');
        $("#searchbar1 #startDate").val('');
        $("#searchbar1 #endDate").val('');
    });
    $reservationtime1.on('apply.daterangepicker',function (el,daterangepicker) {
        var start=daterangepicker.startDate;
        var end=daterangepicker.endDate;
        $("#searchbar1 #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
        $("#searchbar1 #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
    });
    $('#reservationtime').val("");
    $('#reservationtime1').val("");
    
    $('#btn_export').bind("click",function(){
    	var insuranceId = $('#insuranceId').val();
    	var ownerName = encodeURI($('#ownerName').val(),"UTF-8");
    	var ownerIdNo = $('#ownerIdNo').val();
    	var licenseNo = encodeURI($('#licenseNo').val(),"UTF-8");
    	var startDate = $('#startDate').val();
    	var endDate = $('#endDate').val();
    	var salesman = encodeURI($('#salesman').val(),"UTF-8");
    	var status = $('#status').val();
    	var loanProperty = encodeURI($('#loanProperty').val(),"UTF-8");
        window.location.href = "${ctx}/loans/exportAllLoans" + 
        	"?insuranceId=" + insuranceId + 
        	"&ownerName=" + ownerName + 
        	"&ownerIdNo=" + ownerIdNo + 
        	"&licenseNo=" + licenseNo + 
        	"&startDate=" + startDate + 
        	"&endDate=" + endDate + 
        	"&status=" + status + 
        	"&loanProperty=" + loanProperty + 
        	"&salesman=" + salesman;
    });
});

//展开历史订单
function showMoreOrder(obj,insuranceId,expireTime){ 
    if($(obj).hasClass("fa-plus-square-o")){
        var _tdP=$(obj).parent().parent();
        $.post({
            url : web_root+'/loans/queryInstallmentDetail',
            type : 'post',
            dataType:'json',
            async:true,
            cache :false,
            data : {
                'expireTime':expireTime
            },
            success : function(data) {
                if(data.length>0){
                    var _obj=data;
                    var _subOrder="";
                    $.each(_obj, function (n, map) { 
                         _subOrder +="<tr data-pid='"+"' data-index='"+"' name='subCustomer' class=''  cusid='"+map.payTime+"'>"
                            +"<td style=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+map.insurerName+"</td>"
                            +"<td style=''>"+map.payTime+"</td>"
                            +"<td style=''>"+map.firstPaidCount+"</td>"
                            +"<td style=''>"+map.payAll+"</td>"
                            +"<td style=''>"+map.paidCount+"</td>"
                            +"<td style=''>"+map.payAllAmount+"</td>"
                            +"<td style=''>"+map.notPayCount+"</td>"
                            +"<td style=''>"+map.notPayAmount+"</td>"
                            +"</tr>";
                    });
                    
                    _tdP.after(_subOrder);
                }else{
                    $.showPop(data.message,"",1000);
                }
            
            },
            error : function(){
                $.showPop('网络错误','',1000);
            },
        });
        
        $(obj).removeClass("fa-plus-square-o").addClass("fa-minus-square-o");
    }else{
        $(obj).removeClass("fa-minus-square-o").addClass("fa-plus-square-o");
        $(obj).parent().parent().siblings("tr").each(function(){
            if($(this).attr("cusid")==expireTime){
                $(this).remove();
            }
        });
    }
}

</script>
