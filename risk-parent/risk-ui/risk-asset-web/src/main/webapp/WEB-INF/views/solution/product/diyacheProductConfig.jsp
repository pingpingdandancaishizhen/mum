<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>乐位云风控</title>
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
            <input name="productId" id="productId" type="hidden" value="${vo.productKey}"/>
            <div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        支持还款的计算方式
                    </div>
                    <div class="panel-body">
                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head">还款方式:</label>
                                <div class="checkbox label-box" id="repaymentTypes">
                                    <c:forEach items="${loanrepaymenttype}" var="retype">
                                        <label class="label-box-item"> <input type="checkbox"
                                                                              name="feeConfig.repaymentType"
                                                                              value="${retype.typeId}"/>${retype.typeName}
                                        </label>
                                    </c:forEach>
                                </div>
                            </div>

                            <!-- /.input group -->
                        </div>
                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head">每期时长:</label>
                                <div class="checkbox label-box" id="eachtimes">
                                    <c:forEach items="${loaneachtime}" var="eatype">
                                        <c:if test="${!eatype.disabled}">
                                            <label class="label-box-item"> <input type="checkbox"
                                                                                  name="feeConfig.eachtimes"
                                                                                  value="${eatype.status}"/>${eatype.label}
                                            </label>
                                        </c:if>

                                    </c:forEach>
                                </div>
                            </div>

                            <!-- /.input group -->
                        </div>
                        <div class="form-group col-md-12">
                            <div class="sub-head">首还款支付方式</div>
                        </div>
                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head">期初支付:</label>
                                <div class="checkbox label-box" id="startPays">
                                </div>
                            </div>
                        </div>

                        <div class="form-group col-md-12">
                            <div class="input-group">
                                <label class="label-head">期末支付:</label>
                                <div class="checkbox label-box " id="endPays">
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        费用关联方
                    </div>
                    <div class="panel-body no-padding">
                        <div class="bootstrap-table">
                            <table class="table table-condensed">
                                <thead>
                                <th>序号</th>
                                <th>费用名称</th>
                                <th>计算方式</th>
                                <th>费用关联方</th>
                                </thead>
                                <tbody id="feerelated">

                                <c:forEach items="${feetype}" varStatus="st" var="feet">
                                    <tr>
                                        <td>${st.count}.<input type="hidden"
                                                               value="${feet.status}"
                                                               name="feeKey"/></td>
                                        <td>${feet.label}</td>
                                        <td></td>
                                        <td>
                                            <c:if test="${feet.related}">
                                                <div class="col-sm-4">
                                                    <select class="form-control" name="partner">
                                                        <c:forEach items="${partnerList}"
                                                                   var="partner">
                                                            <option value="${partner.roleId}-${partner.id}">
                                                                ${partner.roleName}-${partner.name}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        费率设置
                    </div>
                    <div class="panel-body">
                        <div class="col-md-12 form-group">
                            <p>费率设置前请先了解如下规则</p>
                            <p>
                                1、如果设置支持日标，那么利率都是按日利率计算的；
                            </p>
                            <p>
                                2、如果设置支持月标，那么利率是按年化率计算的，月利率的取值为年化率除以12四舍五入的结果，为防止除不尽导致费用有误差的情况，还款的最后一期为总应还款减去已还金额。
                            </p>
                            <p class="panel-info">说明：主要是因为P2P平台只支持年化率和日利率这两种设置方式，故费用设置需要支持这两种方式。</p>
                        </div>
                        <div class="form-group col-md-12">
                            <div class="form-group col-md-12">
                                <div class="sub-head">P2P发标费率设置 <span class="panel-info">(固定值，说明：如果支持天标按天标计算，如果支持月标按月标计算)：</span>
                                </div>
                            </div>
                            <div class="form-group col-md-12">
                                <div class="form-group col-md-12">
                                    <div class="input-group">
                                        <label class="label-head">年月日率:</label>
                                        <div class="checkbox label-box">
                                            <label class="label-box-item"> <input type="radio"
                                                                                  name="feeConfig.monthlyFeeCal"
                                                                                  value="1"/>年化率=日利率*365，月利率=年化率/12</label>
                                            <label class="label-box-item"> <input type="radio"
                                                                                  name="feeConfig.monthlyFeeCal"
                                                                                  value="2"/>年化率=日利率*360，月利率=年化率/12</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <div class="input-group">
                                        <label class="label-head">固定利率:</label>
                                        <div class="checkbox label-box">
                                            <label class="label-box-item"> <input type="radio"
                                                                                  name="feeConfig.feeCaType"
                                                                                  value="1"/>固定月综合利率</label>
                                            <label class="label-box-item"> <input type="radio"
                                                                                  name="feeConfig.feeCaType"
                                                                                  value="2"/>固定月管理费</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <div class="input-group">
                                        <label class="label-head">滞纳金:</label>
                                        <div class="checkbox label-box">
                                            <label class="label-box-item"> <input type="radio"
                                                                                  name="feeConfig.znjFeeCal"
                                                                                  value="1"/>剩余本金*逾期天数*滞纳金率</label>
                                            <label class="label-box-item"> <input type="radio"
                                                                                  name="feeConfig.znjFeeCal"
                                                                                  value="2"/>合同金额*逾期天数*滞纳金率</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group col-md-12">
                            <div class="form-group col-md-12">
                                <div class="sub-head">日标相关设置</div>
                            </div>
                            <div class="form-group col-md-12">
                                <div class="form-group col-md-12 ">
                                    <div class="table-head">
                                        <span class="table-head-title">日标(一次性还款):</span>
                                        <span class="btn btn-add"
                                              id="fee_day_add"><span>添加</span></span>
                                    </div>
                                    <div class="bootstrap-table">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive ">
                                                <thead>
                                                <tr>
                                                    <th>借款期限从（天）</th>
                                                    <th>借款期限到（天）</th>
                                                    <th>日利率（%）</th>
                                                    <th width="150">操作</th>
                                                </tr>
                                                </thead>
                                                <tbody id="fee_day_add_table">

                                                </tbody>
                                            </table>
                                        </div>


                                    </div>
                                </div>
                                <div class="form-group col-md-12 msscz">
                                    <div class="table-head">
                                        <span class="table-head-title">日综合利率:</span>
                                        <span class="btn btn-add"
                                              id="fee_z_day_add"><span>添加</span></span>
                                    </div>
                                    <div class="bootstrap-table">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive ">
                                                <thead>
                                                <tr>
                                                    <th>机构名称</th>
                                                    <th>日综合利率（%）</th>
                                                    <th width="150">操作</th>
                                                </tr>
                                                </thead>
                                                <tbody id="fee_z_day_add_table">

                                                </tbody>
                                            </table>
                                        </div>


                                    </div>
                                </div>
                                <div class="form-group col-md-12 msscg">
                                    <div class="table-head">
                                        <span class="table-head-title">日管理费率:</span>
                                        <span class="btn btn-add"
                                              id="fee_g_day_add"><span>添加</span></span>
                                    </div>
                                    <div class="bootstrap-table">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive ">
                                                <thead>
                                                <tr>
                                                    <th>日管理费率（%）</th>
                                                    <th width="150">操作</th>
                                                </tr>
                                                </thead>
                                                <tbody id="fee_g_day_add_table">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-12">
                            <div class="form-group col-md-12">
                                <div class="sub-head">月标相关设置</div>
                            </div>
                           <div class="form-group col-md-12">
                               <div class="form-group col-md-12 ">
                                   <div class="table-head">
                                       <span class="table-head-title">月标:</span>
                                       <span class="btn btn-add"
                                             id="fee_month_add"><span>添加</span></span>
                                   </div>
                                   <div class="bootstrap-table">
                                       <div class="fixed-table-body">
                                           <table class="table  table-striped table-responsive ">
                                               <thead>
                                               <tr>
                                                   <th>借款期限</th>
                                                   <th>年化率（%）</th>
                                                   <th>月利率（%）</th>
                                                   <th width="150">操作</th>
                                               </tr>
                                               </thead>
                                               <tbody id="fee_month_add_table">

                                               </tbody>
                                           </table>
                                       </div>

                                   </div>
                               </div>
                               <div class="form-group col-md-12 msscz">
                                   <div class="table-head">
                                       <span class="table-head-title">月综合利率:</span>
                                       <span class="btn btn-add"
                                             id="fee_z_month_add"><span>添加</span></span>
                                   </div>
                                   <div class="bootstrap-table">
                                       <div class="fixed-table-body">
                                           <table class="table  table-striped table-responsive ">
                                               <thead>
                                               <tr>
                                                   <th>机构名称</th>
                                                   <th>月综合利率（%）</th>
                                                   <th width="150">操作</th>
                                               </tr>
                                               </thead>
                                               <tbody id="fee_z_month_add_table">

                                               </tbody>
                                           </table>
                                       </div>


                                   </div>
                               </div>
                               <div class="form-group col-md-12 msscg">
                                   <div class="table-head">
                                       <span class="table-head-title">月管理费率:</span>
                                       <span class="btn btn-add"
                                             id="fee_g_month_add"><span>添加</span></span>
                                   </div>
                                   <div class="bootstrap-table">
                                       <div class="fixed-table-body">
                                           <table class="table  table-striped table-responsive ">
                                               <thead>
                                               <tr>
                                                   <th>月管理费率（%）</th>
                                                   <th width="150">操作</th>
                                               </tr>
                                               </thead>
                                               <tbody id="fee_g_month_add_table">

                                               </tbody>
                                           </table>
                                       </div>
                                   </div>
                               </div>
                           </div>
                        </div>
                        <div class="form-group col-md-12">
                            <div class="form-group col-md-12">
                                <div class="sub-head">GPS费用设置</div>
                            </div>
                            <div class="form-group col-md-12">
                                <div class="form-group col-md-12 ">
                                    <div class="table-head">
                                        <span class="table-head-title">安装费用:</span>
                                        <span class="btn btn-add"
                                              id="gps_fee_add"><span>添加</span></span>
                                    </div>
                                    <div class="bootstrap-table">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive">
                                                <thead>
                                                <th>GPS安装费（元/次）</th>
                                                <th width="150">操作</th>
                                                </thead>
                                                <tbody id="gps_fee_add_table">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <div class="table-head">
                                        <span class="table-head-title">服务费:</span>
                                        <span class="btn btn-add"
                                              id="gpsser_fee_add"><span>添加</span></span>
                                    </div>
                                    <div class="bootstrap-table">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive">
                                                <thead>
                                                <th>GPS服务费</th>
                                                <th width="150">操作</th>
                                                </thead>
                                                <tbody id="gpsser_fee_add_table">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-md-12">
                            <div class="form-group col-md-12">
                                <div class="sub-head">其他费用设置</div>
                            </div>
                            <div class="form-group col-md-12">
                                <div class="form-group col-md-12 ">
                                    <div class="table-head">
                                        <span class="table-head-title">违约金率设置:</span>
                                        <span class="btn btn-add"
                                              id="wyl_fee_add"><span>添加</span></span>
                                    </div>
                                    <div class="bootstrap-table">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive">
                                                <thead>
                                                <th>违约金率（%）</th>
                                                <th width="150">操作</th>
                                                </thead>
                                                <tbody id="wyl_fee_add_table">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <div class="table-head">
                                        <span class="table-head-title">保证金率设置:</span>
                                        <span class="btn btn-add" id="bzjl_fee_add"><span>添加</span></span>
                                    </div>
                                    <div class="bootstrap-table">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive">
                                                <thead>
                                                    <th>保证金率（%）</th>
                                                    <th width="150">操作</th>
                                                </thead>
                                                <tbody id="bzjl_fee_add_table">

                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <div class="table-head">
                                        <span class="table-head-title">滞纳金率设置:</span>
                                        <span class="btn btn-add" id="znjl_fee_add"><span>添加</span></span>
                                    </div>
                                    <div class="bootstrap-table">
                                        <div class="fixed-table-body">
                                            <table class="table  table-striped table-responsive">
                                                <thead>
                                                <th>滞纳金率（%）</th>
                                                <th width="150">操作</th>
                                                </thead>
                                                <tbody id="znjl_fee_add_table">

                                                </tbody>
                                            </table>
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
            <shiro:hasPermission name="product:feeconfig">
                <div  class="btn btn-primary btn-primary-lg"
                        id="savFeeConfigBtn" data-loading-text="确定...">确定
                </div>
            </shiro:hasPermission>
            <div  class="btn btn-cancel  btn-primary-lg"
                    id="cancelBtn">返回
            </div>
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
    var feeConfig = '${feeConfig}';
    if (feeConfig != 'null' && feeConfig != '') {
        feeConfig = eval('(' + feeConfig + ')');
    } else {
        feeConfig = null;
    }

</script>

<script type="text/javascript"
        src="${ctx}/static/pagejs/solution/product/product-feeconfig-dyc.js"></script>

<div class="modal" id="monthFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加月标配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="monthFeeForm" class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="term" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>借款期限：</label>
                                <div class="col-sm-8">
                                    <select class="form-control" id="term" name="term">
                                        <c:forEach var="term" items="${loantermtype}">
                                            <c:if test="${!term.disabled}">
                                                <option value="${term.status}">${term.label}
                                                </option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="year" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>年化率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="yearlyRate" name="yearlyRate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="year" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>月化率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" readonly="readonly"
                                           class="form-control" id="monthlyRate" name="monthlyRate">
                                </div>
                            </div>
                            <div class="form-group" style="display: none">
                                <label for="day" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>日化率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" readonly="readonly"
                                           class="form-control" id="daylyRate" name="daylyRate">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addMonthFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>
<div class="modal" id="dayFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加日标配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="dayFeeForm" class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="termStart" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>借款期限从：</label>
                                <div class="col-sm-8">
                                    <input class="form-control" id="termStart" name="termStart"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="termEnd" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>到借款期限：</label>
                                <div class="col-sm-8">
                                    <input class="form-control" id="termEnd" name="termEnd"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="day" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>日化率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="daylyRate" name="daylyRate">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addDayFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="dayZFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加日综合利率配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="dayZFeeForm" class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="term" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>组织结构：</label>
                                <div class="col-sm-8">
                                    <select id="deptId" name="deptId" class="form-control">
                                        <option selected="selected" value="">默认</option>
                                        <c:forEach items="${deptList}" var="dept">
                                            <option value="${dept.id}">${dept.deptName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="daylyZRate" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>日综合利率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="daylyZRate" name="daylyZRate">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addDayZFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="dayGFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加日管理费率配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="dayGFeeForm" class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="year" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>日管理费率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="daylyGRate" name="daylyGRate">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addDayGFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>


<div class="modal" id="monthZFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加月综合利率配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="monthZFeeForm" class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="term" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>组织结构：</label>
                                <div class="col-sm-8">
                                    <select id="deptId" name="deptId" class="form-control">
                                        <option selected="selected" value="">默认</option>
                                        <c:forEach items="${deptList}" var="dept">
                                            <option value="${dept.id}">${dept.deptName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="year" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>月综合利率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="monthlyZRate" name="monthlyZRate">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addMonthZFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="monthGFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加月管理费率配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="monthGFeeForm" class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="year" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>月管理费率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="monthlyGRate" name="monthlyGRate">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addMonthGFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="gpsFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加GPS安装费用配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="gpsFeeForm" class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>GPS安装费：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="gpsFee" name="gpsFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addGpsFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>
<div class="modal" id="gpsserFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加GPS服务费配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="gpsserFeeForm" class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>GPS服务费：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="gpsserFee" name="gpsserFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addGpsserFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>
<!-- <div class="modal" id="parkFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">添加停车费用配置</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form id="parkFeeForm"  class="form-horizontal" >
				 <div class="box-body">
					    <div class="form-group">
							<label for="fee" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>停车费：</label>
							<div class="col-sm-8">
								<input type="text" maxlength="6"  class="form-control" id="parkFee" name="parkFee" >
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-default" id="addParkFeeBtn">确定</div>
			<div  class="btn btn-default" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div> -->
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
                                        style="color: #FF0000;">*</span>违约金率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="wylFee" name="wylFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addWylFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
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
                                        style="color: #FF0000;">*</span>保证金率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="bzjlFee" name="bzjlFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addBzjlFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
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
                                        style="color: #FF0000;">*</span>滞纳金率：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="6" class="form-control"
                                           id="znjlFee" name="znjlFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary btn-primary-lg" id="addZnjlFeeBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>