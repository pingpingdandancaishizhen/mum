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
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
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
                        <label class="label-head text-right" >产品</label>
                        <select  class="form-control" name="productType">
                            <option value="">请选择</option>
                            <option value="">融金分期宝</option>
                        </select>
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">订单号</label>
                        <input type="text" class="form-control" id="insuranceId" name="insuranceId" placeholder="输入订单号搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">客户名称</label>
                        <input type="text" class="form-control" id="ownerName" name="ownerName" placeholder="输入客户名称搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">身份证号</label>
                        <input type="text" class="form-control" id="ownerIdNo" name="ownerIdNo" placeholder="输入身份证号搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">客户类型</label>
                        <select  class="form-control" name="custType">
                            <option value="">请选择</option>
                            <option value="">个人</option>
                        </select>
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">车牌号</label>
                        <input type="text" class="form-control" id="licenseNo" name="licenseNo" placeholder="输入车牌号搜索">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">单据状态</label>
                        <select  class="form-control" id="status" name="status">
                            <option value="">请选择</option>
                            <option value="1">新增订单</option>
                            <option value="2">已缴纳首付</option>
                            <option value="3">成功投保</option>
                        </select>
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">投保日期</label>
                        <input type="text" class="form-control" id="reservationtime" readonly="readonly"  >
                        <input type="hidden" id="startDate" name="startDate">
                        <input type="hidden" id="endDate" name="endDate">
                    </div>

                </div>
                <div class="form-group col-md-3 row-left">
                    <div class="input-group">
                        <label class="label-head text-right">订单来源</label>
                        <select  class="form-control" name="source">
                            <option value="">请选择</option>
                            <option value="0">享发金融</option>
                            <option value="1">融金所</option>
                        </select>
                    </div>

                </div>
                <!--<div class="form-group">
                    <div  id="btn_search" class="btn btn-block btn-warning">搜索</div>
                </div>
                <div class="form-group">
                    <button type="reset" id="btn_reset" class="btn btn-block btn-default">重置</button>
                </div>-->

            </form>
        </div>
        <div class="table-top-tool">
            <div class="btn btn-primary btn-primary-lg" id="btn_search">
                <i class="icon icon-search"></i>
                <span>查询</span>
            </div>
        </div>
        <div id="toolbar">
            <div class="btn-group">
                <shiro:hasPermission name="insurance:detail">
                    <div class="btn btn-white" id="btn_detail">

                        <span>查看</span>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="insurance:export">
                    <div class="btn btn-white" id="btn_export">

                        <span>下载excel表格</span>
                    </div>
                </shiro:hasPermission>
            </div>
        </div>

        <table class="table  table-striped table-hover" id="all_installment_table" data-toggle="table" style="width:3000px"
               data-url="${ctx}/installment/queryAllInstallmentNew"
               data-method="post" data-content-type="application/x-www-form-urlencoded"
               data-query-params="requestData" data-query-params-type=""
               data-click-to-select="true"
               data-single-select="true"
               data-select-item-name="id"
               data-checkbox-header="true"
               data-page-number=1 data-page-size=10
               data-response-handler="responseData" data-side-pagination="server"
               data-pagination="true" data-page-list="[5, 10, 20]" data-toolbar="#toolbar">
            <thead>
            <tr>
                <th data-field="" data-checkbox="true"></th>
                <th data-field="insuranceIcon">订单号</th>
                <th data-field="ownerName">客户名称</th>
                <th data-field="ownerIdNoStr">身份证号</th>
                <th data-field="productName" data-width="120px">&nbsp;&nbsp;&nbsp;产品&nbsp;&nbsp;&nbsp;
                </th>
                <th data-field="createTime">&nbsp;&nbsp;投保日期&nbsp;
                    &nbsp;</th>
                <th data-field="totalPrice">保费金额</th>
                <th data-field="insurerName">保险公司</th>
                <th data-field="ciProposalNo">交强险保单号</th>
                <th data-field="biProposalNo">商业保险单号</th>
                <th data-field="bBalance">借款金额</th>
                <th data-field="amount">首付款</th>
                <th data-field="loanPeriodsNum">借款期限</th>
                <th data-field="payMethod">借款还款方式</th>
                <th data-field="licenseNo">&nbsp;&nbsp;车牌号码&nbsp;
                    &nbsp;</th>
                <th data-field="loanProperty">借款性质</th>
                <th data-field="status">&nbsp;&nbsp;单据状态&nbsp;&nbsp;</th>
                <th data-field="orderSource">订单来源</th>
                <th data-field="issuePlat">发标平台</th>
                <th data-field="issueNo">标的号</th>
                <th data-field="issueStatus">标的状态</th>
            </tr>
            </thead>
        </table>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
</body>
<script type="text/javascript">

$(function(){
		//默认选中第一个tab
	$(".nav-tabs li:first").addClass("active");
	$(".tab-content .tab-pane:first").addClass("active");
	
	$('#btn_detail').bind("click",function(){
        var selected = $table.bootstrapTable('getSelections');
        if($table.find("input:checked").length === 0 ){
            $.alert("请选择要查看的订单");
        }else if($table.find("input:checked").length > 1 ){
        	$.alert("请选择一条要查看的订单");
        }else{
        	if(selected.length==0)
        		tools.addParentTab("${ctx}/installment/queryInstallmentDeatil?insuranceId="+$table.find("input:checked").parent().next().html(),$table.find("input:checked").parent().next().next().html()+"-查看信息");
        	else
        		tools.addParentTab("${ctx}/installment/queryInstallmentDeatil?insuranceId="+selected[0]['insuranceId'],$table.find("input:checked").parent().next().next().html()+"-查看信息");
            //window.location.href="${ctx}/installment/queryInstallmentDeatil?insuranceId="+selected[0]['insuranceId'];
        }
    });
    
    $('#btn_export').bind("click",function(){
    	var insuranceId = $('#insuranceId').val();
    	var ownerName = encodeURI($('#ownerName').val(),"UTF-8");
    	var ownerIdNo = $('#ownerIdNo').val();
    	var licenseNo = encodeURI($('#licenseNo').val(),"UTF-8");
    	var startDate = $('#startDate').val();
    	var endDate = $('#endDate').val();
    	var status = $('#status').val();
        window.location.href = "${ctx}/installment/exportInstallment?insuranceId="+insuranceId+"&ownerName="+ownerName+"&ownerIdNo="+ownerIdNo+"&licenseNo="+licenseNo+"&startDate="+startDate+"&endDate="+endDate+"&status="+status;
    });
});



</script>
<script type="text/javascript" src="${ctx}/static/pagejs/installment/installment.js${timeStyle}"></script>
</html>