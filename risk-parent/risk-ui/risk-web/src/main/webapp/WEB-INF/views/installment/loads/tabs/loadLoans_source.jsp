<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
	<!-- Content Wrapper. Contains page content -->
	<div class="tab-pane " id="loadLoans_source">
		<!-- Main content -->
		<section class="content content-padding">
			<div class="search-box" id="searchbar1">
				<form onsubmit="return false;" id="form" class="form-inline form-label-auto" role="form">
                    
                    
                    <div class="form-group col-md-3 row-left">
						<div class="input-group">
							<label class="label-head text-right" >日期</label>
	                        <input type="text" class="form-control" id="reservationtime1" readonly="readonly">
	                        <input type="hidden" id="startDate" name="startDate">
	                        <input type="hidden" id="endDate" name="endDate">
                        </div>
                    </div>
                </form>
		   </div>
		<div class="table-top-tool">
			<div class="btn btn-primary btn-primary-lg" id="btn_search1">
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
                        <div class="btn btn-white" id="btn_export1">
                            <i class="fa fa-plus"></i>
                            <span>下载excel表格</span>
                        </div>
                    </div>
                    </shiro:hasPermission>
                </div> -->
                <table class="table table-bordered table-hover" id="all_source_table" 
                    data-toggle="table"
                    data-url="${ctx}/loans/queryAllReportBySource"
                    data-method="post" 
                    data-cache="false" 
                    data-content-type="application/x-www-form-urlencoded"
                    data-query-params="requestData1" 
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
                            <th data-field="sourceIcon">渠道来源</th>
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

var $table1 = $("#all_source_table");
$(function(){
    $("#btn_search1").bind("click",function() {
        $table1.bootstrapTable('refresh');
    });
    
    $('#btn_export1').bind("click",function(){
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

function requestData1(params) {
    var params = {
        paseSize : params.pageSize,
        currentPage : params.pageNumber
    };
    $('#searchbar1').find('input[name]').each(function() {
        params[$(this).attr('name')] = $(this).val();
    });
    $('#searchbar1').find('select[name]').each(function() {
        params[$(this).attr('name')] = $(this).val();
    });
    return params;
}

function showMoreOrder1(obj,insuranceId,expireTime){ 
    if($(obj).hasClass("fa-plus-square-o")){
        var _tdP=$(obj).parent().parent();
        $.post({
            url : web_root+'/loans/queryReportBySourceDetail',
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
                            +"<td style=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+map.source+"</td>"
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
