<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>P2P发标系统</title>
    <%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content content-padding ">
        <form onsubmit="return false;" class="form-inline form-label-auto table-box"
              id="corpForm" action="" method="post">
            <div>
            	<div class="panel panel-default">
                    <div class="panel-heading">
                       	发标产品
                    </div>
                    <div class="panel-body">
                    <input type="hidden" value="${assetId}" id="assetId">
                        <div class="form-group col-md-12">
                        
                            <div class="input-group">
                            <label class="label-head">
          							<span class="require">发标产品类型:</span>
          							</label>
                                <label class="label-box-item">


                                	<select class="form-control" id="productType" name="productType">
                                		<option value="">请选择贷款介质</option>
                                		<c:forEach items="${proList}" var="pro">
                                			<option value="${pro.id}">${pro.name}</option>
                                		</c:forEach>
                                	</select>
                                </label>
                            </div>
                        </div>
                    </div>

                </div>
              <div id="content-body">

                <div id="cfyd-body">
                <div class="panel panel-default">
                    <div class="panel-heading">
                    	资产方产品简要
                    </div>
                    <div class="panel-body">
                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head">
          						<span class="require"> 产品名称:</span>
                               </label>
                                <div class="checkbox label-box" id="repaymentTypes">
                                    <label class="label-box-item">
                                    	<%-- <select class="form-control" id="productName" name="productName">
	                                		<option value="">请选择产品名称</option>
	                                		<c:forEach items="${nameList}" var="n">
	                                			<option value="${n.id}">${n.name}</option>
	                                		</c:forEach>
	                                	</select> --%>
	                                	<input type="text" name="productName" id="productName" class="form-control"/>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head">
          								<span class="require"> 产品代码:</span>
                                </label>
                                <div class="checkbox label-box label-head-top">
                                    <label class="label-box-item">
                                    	<input type="text" name="productCode" id="productCode" class="form-control"/>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head label-head-top">
                                <span class="require"> 借款人还款方式：</span>
                              </label>
                                <div class="checkbox label-box label-head-top" >
                                    <label class="label-box-item"> <input class="repaymentType"  name="feeConfig.repaymentType" value="1" type="checkbox"><span>等额等息</span>
                                    </label>
                                    <label class="label-box-item"> <input class="repaymentType"  name="feeConfig.repaymentType" value="2" type="checkbox"><span>先息后本</span>
                                    </label>
                                    <label class="label-box-item"> <input class="repaymentType" name="feeConfig.repaymentType" value="3" type="checkbox"><span>一次性还款</span>
                                    </label>
                                    <label class="label-box-item"> <input class="repaymentType"  name="feeConfig.repaymentType" value="4" type="checkbox"><span>等额本金</span>
                                    </label>
                                    <label class="label-box-item"> <input class="repaymentType"  name="feeConfig.repaymentType" value="5" type="checkbox"><span>等额本息</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-12" id="nomal-repayment">
                            <div class="input-group">
                                <label class="label-head label-head-top">
                                <span class="require"> 借款期限：</span>
                               </label>
                                <div class="checkbox label-box label-head-top">
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M1" type="checkbox"><span>1个月</span>
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M2" type="checkbox"><span>2个月</span>
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M3" type="checkbox"><span>3个月</span>
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M4" type="checkbox"><span>4个月</span>
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M5" type="checkbox"><span>5个月</span>
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M6" type="checkbox"><span>6个月</span>
                                    </label>
                                     <label class="label-box-item"> <input name="feeConfig.term" value="M11" type="checkbox"><span>11个月</span>
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M12" type="checkbox"><span>12个月</span>
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M18" type="checkbox"><span>18个月</span>
                                    </label>
                                     <label class="label-box-item"> <input name="feeConfig.term" value="M23" type="checkbox"><span>23个月</span>
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M24" type="checkbox"><span>24个月</span>
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.term" value="M35" type="checkbox"><span>35个月</span>
                                    </label>
                                     <label class="label-box-item"> <input name="feeConfig.term" value="M36" type="checkbox"><span>36个月</span>
                                    </label>
                                     <label class="label-box-item"> <input name="feeConfig.term" value="D1,D60" type="checkbox"><span>按天（1-60天)</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-12" id="lump-sum-repayment" style="display:none">
                            <div class="input-group">
                                <label class="label-head">
                                <span class="require"> 借款期限：</span>
                               </label>
                                <div class="checkbox label-box label-head-top" >
                                    <label class="label-box-item"> <input name="feeConfig.lumpSumTerm" value="1-60" type="checkbox">1-60天
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head">第一期本息扣除方式：</label>
                                <div class="checkbox label-box" >
                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="1" type="radio">扣除第一期的本息
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="2" type="radio">扣除第一期的本金
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="3" type="radio">扣除第一期的利息
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="4" type="radio">不扣第一期的本或息
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head">支持的自动流程：</label>
                                <div class="checkbox label-box" >
                                    <label class="label-box-item"> <input name="feeConfig.autoType" value="1" type="checkbox">自动提交订单
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.autoType" value="2" type="checkbox">自动通过P2P审批
                                    </label>
                                    <label class="label-box-item"> <input name="feeConfig.autoType" value="3" type="checkbox">自动通过P2P影像审核
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head label-head-top">产品说明：</label>
                                <div class="checkbox label-box label-head-top" >
                                    <label class="label-box-item">
                                    	<textarea placeholder="500字" rows="5" cols="100" name="desc" id="desc" maxlength="500"></textarea>
                                    </label>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                       	资产方产品费率配置
                    </div>
                    <div class="panel-body">



                         <div class=" col-md-12">
                             <div class="sub-head"><span  class="require">综合月利率设置</span>
                             </div>
                             <div class="form-group col-md-12 ">

                                 <div class="bootstrap-table" >
                                     <div class="fixed-table-body">
                                         <table class="table  table-striped table-responsive" >
                                             <thead>
                                             <tr>
                                                 <th width="300px">还款方式</th>
                                                 <th>综合月利率</th>
                                             </tr>
                                             </thead>
                                             <tbody id="fee_month_add_table">

                                             </tbody>
                                         </table>
                                     </div>


                                 </div>

                             </div>
                       </div>

                         <div class="form-group col-md-12">
                             <div class="sub-head">综合日利率设置
                             </div>
                            <div class=" col-md-12">
                                <div class="bootstrap-table" >
                                    <div class="fixed-table-body">
                                        <table class="table  table-striped table-responsive" >
                                            <thead>
                                            <tr>
                                                <th width="300px">还款方式</th>
                                                <th>综合日利率</th>
                                            </tr>
                                            </thead>
                                            <tbody id="fee_day_add_table">

                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div>
                       </div>


                        <div class="form-group col-md-12">
                            <div class="sub-head">
                                <span class="require">违约金率设置</span>
                                <span class="btn btn-add"  id="wyl_fee_add"><span>添加</span></span>
                            </div>
                            <div class=" col-md-12 ">
                                <div class="bootstrap-table">
                                    <div class="fixed-table-body">
                                        <table class="table  table-striped table-responsive">
                                            <thead>
                                            <tr>
                                                <th>借款金额从(元)</th>
                                                <th>借款金额到(元)</th>
                                                <th>违约金率（%）</th>
                                                <th width="150">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="wyl_fee_add_table">
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                       </div>

                       <div class="form-group col-md-12">
                           <div class="sub-head">
                               <span class="require">滞纳金率设置</span>
                               <span class="btn btn-add" id="znjl_fee_add"><span>添加</span></span>
                           </div>
                            <div class="col-md-12">
                                <div class="form-group input-group ">
                                    <span class="label-head label-head-top label-head-lg text-right">配置方式：</span>
                                    <div class="label-box label-head-top">
                                        <label class="radio-inline"> <input name="feeConfig.znjCalType" value="1" type="radio" checked="checked">按借款金额配置
                                        </label>
                                        <label class="radio-inline"> <input name="feeConfig.znjCalType" value="2" type="radio">按借款期限配置
                                        </label>
                                    </div>
                                </div>
                                <div class="bootstrap-table" id="znjCalAmountType">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive">
                                                <thead>
                                                <tr>
                                                <th>借款金额从(元)</th>
                                                <th>借款金额到(元)</th>
                                                <th>滞纳金率（%）</th>
                                                <th width="150">操作</th>
                                                </tr>
                                                </thead>
                                                <tbody id="znjl_fee_add_table">
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                <div class="bootstrap-table" id="znjCalTermType" style="display:none;">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive">
                                                <thead>
                                                <tr>
                                                <th>借款期限</th>
                                                <th>滞纳金率（%）</th>
                                                </thead>
                                                <tbody id="znjl_fee_add_term_table">
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                            </div>
                       </div>


                        <div class="col-md-12">
                            <div class="sub-head"><span  class="require"> 咨询费设置</span></div>
                            <div class=" col-md-12 ">
                                <div class="form-group input-group">
                                    <div class="label-head label-head-top label-head-lg text-right">是否需要咨询费：</div>
                                    <div class="label-box label-head-top">
                                        <label class="radio-inline"> <input name="feeConfig.zxfType" value="1" type="radio" checked="checked">是
                                        </label>
                                        <label class="radio-inline"> <input name="feeConfig.zxfType" value="2" type="radio">否
                                        </label>
                                    </div>
                                </div>
                                <div id="zxfee">
                                    <div class="form-group input-group" >
                                        <div class="label-head label-head-top label-head-lg text-right">咨询费：</div>
                                        <div class="label-box" >
                                            <div class="form-inline">
                                                <div class="form-group">
                                                    <input   type="text" value="0" class="form-control">
                                                </div>
                                                <span class="line-span">-</span>
                                                <div class="form-group">
                                                    <input   type="text" value="10" class="form-control">
                                                </div>
                                                <span class="line-span">%</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                       </div>



                       <div class=" col-md-12">
                           <div class="sub-head">保证金率设置
                               <span class="btn btn-add" id="bzjl_fee_add"><span>添加</span></span>
                           </div>
                            <div class=" col-md-12">
                                <div class="form-group input-group ">
                                    <div class="label-head label-head-top label-head-lg text-right">是否有保证金：</div>
                                    <div class="label-box label-head-top">
                                        <label class="radio-inline"> <input name="feeConfig.bzjType" value="1" type="radio" checked="checked">是
                                        </label>
                                        <label class="radio-inline"> <input name="feeConfig.bzjType" value="2" type="radio">否
                                        </label>
                                    </div>
                                </div>
                                <div class="bootstrap-table" id="bzjCalType">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive">
                                                <thead>
                                                <tr>
                                                <th>借款金额从(元)</th>
                                                <th>借款金额到(元)</th>
                                                <th>保证金率（%）</th>
                                                <th width="150">操作</th>
                                                </tr>
                                                </thead>
                                                <tbody id="bzjl_fee_add_table">
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                            </div>
                       </div>

                       <div class=" col-md-12">
                           <div class="sub-head">其他费用设置
                               <span class="btn btn-add" id="other_fee_add"><span>添加</span></span>
                           </div>
                            <div class="col-md-12">
                                <div class="form-group input-group ">
                                    <div class="label-head label-head-top label-head-lg text-right">是否有其他费用：</div>
                                    <div class="label-box label-head-top">
                                        <label class="radio-inline"> <input name="feeConfig.otherType" value="1" type="radio" checked="checked">是
	                                    </label>
	                                    <label class="radio-inline"> <input name="feeConfig.otherType" value="2" type="radio">否
	                                    </label>
                                    </div>

                                </div>
                                <div class="bootstrap-table" id="otherCalType">
                                    <div class="fixed-table-body">
                                        <table class="table  table-striped table-responsive">
                                            <thead>
                                            <tr>
                                                <th>借款金额从(元)</th>
                                                <th>借款金额到(元)</th>
                                                <th>其他费用(元)</th>
                                                <th width="150">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="other_fee_add_table">
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                       </div>



                       <div class=" col-md-12">
                           <div class="sub-head">GPS费用设置
                           </div>
                            <div class=" col-md-12">
                                <div class="form-group input-group ">
                                    <div class="label-head label-head-top label-head-lg text-right">是否需要安装GPS：</div>
                                    <div class="label-box label-head-top">

                                        <label class="radio-inline"> <input name="feeConfig.gpsType" value="1" type="radio" checked="checked">是
	                                    </label>
	                                    <label class="radio-inline"> <input name="feeConfig.gpsType" value="2" type="radio">否
	                                    </label>
                                    </div>
                                </div>
                                <div id="gpsCalType">
                                    <div class="form-group input-group">
                                        <div class="label-head label-head-top label-head-lg text-right">GPS安装费：</div>
                                        <div class="label-box">
                                            <div class="form-inline">
                                                <span class="form-group">初次安装</span>
                                                <div class="form-group">
                                                    <input name="feeConfig.gpsFirstFee"  type="text" value="0" class="form-control">
                                                </div>
                                                <span class="line-span">-</span>
                                                <div class="form-group">
                                                    <input name="feeConfig.gpsFirstFee"  type="text" value="1000" class="form-control">
                                                </div>
                                                <span class="line-span">元</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group input-group">
                                        <div class="label-head label-head-top label-head-lg text-right">GPS服务费：</div>
                                        <div class="label-box">
                                            <div class="form-inline">
                                                <span class="form-group">按月支付</span>
                                                <div class="form-group">
                                                    <input name="feeConfig.gpsServiceFee"  type="text" value="0" class="form-control">
                                                </div>
                                                <span class="line-span">-</span>
                                                <div class="form-group">
                                                    <input name="feeConfig.gpsServiceFee"  type="text" value="1000" class="form-control">
                                                </div>
                                                <span class="line-span">元</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                       </div>

                       <div class=" col-md-12">
                           <div class="sub-head">停车费设置
                           </div>
                            <div class="col-md-12">
                                <div class="form-group input-group ">
                                    <div class="label-head label-head-top label-head-lg text-right">是否有停车费：</div>
                                    <div class="label-box label-head-top">
                                        <label class="radio-inline"> <input name="feeConfig.parkType" value="1" type="radio" checked="checked">是
	                                    </label>
	                                    <label class="radio-inline"> <input name="feeConfig.parkType" value="2" type="radio">否
	                                    </label>
                                    </div>
                                </div>
                                <div id="parkType">
                                    <div class="form-group input-group" >
                                        <div class="label-head label-head-top label-head-lg text-right">停车费：</div>
                                        <div class="label-box">
                                            <div class="form-inline">
                                                <span class="form-group">按月支付</span>
                                                <div class="form-group">
                                                    <input name="feeConfig.parkFee"  type="text" value="0" class="form-control">
                                                </div>
                                                <span class="line-span">-</span>
                                                <div class="form-group">
                                                    <input name="feeConfig.parkFee"  type="text" value="1000" class="form-control">
                                                </div>
                                                <span class="line-span">元</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                       </div>

                    </div>
                </div>
                </div>
                </div>
            </div>
            <!-- /.box -->
        </form>
        <div class="modal-footer btn-center">
            <button type="button" class="btn btn-primary btn-primary-lg"
                    id="savFeeConfigBtn" data-loading-text="确定...">保存
            </button>
            <button type="button" class="btn btn-cancel  btn-primary-lg"
                    id="cancelBtn">取消
            </button>
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script type="text/javascript">
    //返回数据处理
    var ctx = '${ctx}';
    $(function () {
        $.ajaxload();
    });

    var names = '${nameList}';
    if (names != 'null' && names != '') {
    	names = eval('(' + names + ')');
    } else {
    	names = null;
    }
</script>

<script type="text/javascript" src="${ctx}/static/pagejs/system/partnerCorp/product-feeconfig-dyc.js${timeStyle}"></script>





<div class="modal" id="wylFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加违约金率配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="wylFeeForm" class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                            	<label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="wylStart" name="wylStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="wylEnd" name="wylEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>违约金率：</label>
                                <div class="col-sm-8">
                                    <input type="text"  class="form-control"
                                           id="wylFee" name="wylFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-primary-lg" id="addWylFeeBtn"
                        data-loading-text="确定中...">确定
                </button>
                <button type="button" class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>


<div class="modal" id="bzjlFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加保证金率配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="bzjlFeeForm" class="form-horizontal">
                        <div class="box-body">
                        	<div class="form-group">
                            	<label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="bzjlStart" name="bzjlStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="bzjlEnd" name="bzjlEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>保证金率：</label>
                                <div class="col-sm-8">
                                    <input type="text"  class="form-control"
                                           id="bzjlFee" name="bzjlFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-primary-lg" id="addBzjlFeeBtn"
                        data-loading-text="确定中...">确定
                </button>
                <button type="button" class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>


<div class="modal" id="znjlFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加滞纳金率配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="znjlFeeForm" class="form-horizontal">
                        <div class="box-body">
                        	<div class="form-group">
                            	<label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="znjlStart" name="znjlStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="znjlEnd" name="znjlEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>滞纳金率：</label>
                                <div class="col-sm-8">
                                    <input type="text"  class="form-control"
                                           id="znjlFee" name="znjlFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-primary-lg" id="addZnjlFeeBtn"
                        data-loading-text="确定中...">确定
                </button>
                <button type="button" class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="otherFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加其他费用配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="otherFeeForm" class="form-horizontal">
                        <div class="box-body">
                        	<div class="form-group">
                            	<label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="otherStart" name="otherStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="otherEnd" name="otherEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>其他费用(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text"  class="form-control"
                                           id="otherFee" name="otherFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-primary-lg" id="addOtherFeeBtn"
                        data-loading-text="确定中...">确定
                </button>
                <button type="button" class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>