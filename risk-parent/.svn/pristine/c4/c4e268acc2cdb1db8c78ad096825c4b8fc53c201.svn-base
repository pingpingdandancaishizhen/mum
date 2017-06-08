<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>乐位云风控</title>
    <%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content body-box" id="loanPlanRecordForm">
        <!--<div class="body-header">
            <div class="closed" data-close="closed">&times;<span>关闭</span></div>
            <div class="body-title">放款录入</div>
        </div>-->
        <div class="col-md-12 new-box">
            <div class="panel panel-my">
                <div class="panel-body form-label-auto">
                    <div class="col-sm-12 ">
                        <div class="border-dotted">
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">借款人：</div>
                                    <div class="label-box label-name">${detail.custName}</div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">借款合同号：</div>
                                    <div class="label-box label-name">${detail.loanContractId}</div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">合同金额：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00"
                                                          value="${detail.approvedAmount + detail.loanGuaranteeFee}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">总放款金额：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00"
                                                          value="${detail.approvedAmount + detail.loanGuaranteeFee}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <div class="border-dotted">
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">借款人实收金额：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00" value="${detail.approvedAmount + detail.loanGuaranteeFee -
						  detail.loanConsultFee - detail.interest - detail.loanManageFee - detail.principle -
						  detail.loanGuaranteeFee - detail.loanGPSFee - detail.loanGPSServiceFee - detail.loanParkFee}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">咨询费：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00"
                                                          value="${detail.loanConsultFee}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group ">
                                    <div class="label-head text-right">期本金：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00"
                                                          value="${detail.principle}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">期利息：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00"
                                                          value="${detail.interest}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 ">
                        <div class="border-dotted">
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">期管理费：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00"
                                                          value="${detail.loanManageFee}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">保证金：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00"
                                                          value="${detail.loanGuaranteeFee}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">GPS安装费：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00"
                                                          value="${detail.loanGPSFee}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">GPS服务费：</div>
                                    <div class="label-box label-name">
                                        <fmt:formatNumber pattern="#,##0.00"
                                                          value="${detail.loanGPSServiceFee}"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-sm-12">
                        <div class="col-sm-3 form-group form-margin">
                            <div class="input-group">
                                <div class="label-head text-right">停车费：</div>
                                <div class="label-box label-name">
                                    <fmt:formatNumber pattern="#,##0.00"
                                                      value="${detail.loanParkFee}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group col-md-12">
            <div class="sub-head">
                借款信息
            </div>
        </div>
        <div class="form-group col-md-12">
            <form onsubmit="return false;" class="custom-form"
                  action="${ctx}/loanManager/saveLoanRecord" method="post">
                <input type="hidden" name="bpId" value="${detail.bpId}" id="bpId">
                <div class="bootstrap-table">
                    <div class="fixed-table-body">
                        <table class="table  table-striped" style="width: 1800px">
                            <thead>
                            <tr>
                                <th style="width: 150px">费用名称</th>
                                <th>收款人</th>
                                <th>待放款金额</th>
                                <th>收款人银行户名</th>
                                <th>收款人银行</th>
                                <th>收款人银行账号</th>
                                <th style="width: 200px">放款金额</th>
                                <th style="width: 200px">放款平台</th>
                                <th style="width: 200px">放款人</th>
                                <th style="width: 200px">放款时间</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="form-group no-margin clearfix">
                                        借款人实收金额
                                    </div>
                                </td>
                                <td id="loanCustName">
                                    <div class="form-group no-margin clearfix">
                                        ${detail.loanbankAccountName}
                                    </div>
                                </td>
                                <td id="loan">
                                    <div class="form-group no-margin clearfix">
                                        <fmt:formatNumber pattern="#,##0.00" value="${detail.approvedAmount + detail.loanGuaranteeFee -
									  detail.loanConsultFee - detail.interest - detail.loanManageFee - detail.principle -
									  detail.loanGuaranteeFee - detail.loanGPSFee - detail.loanGPSServiceFee - detail.loanParkFee}"/>
                                    </div>
                                </td>
                                <td id="loanMoney">
                                    <div class="form-group no-margin clearfix">
                                        ${detail.loanbankAccountName}
                                    </div>
                                </td>
                                <td id="loanBank">
                                    <div class="form-group no-margin clearfix">
                                        ${detail.loanbankBank}
                                    </div>
                                </td>
                                <td id="loanAccount">
                                    <div class="form-group no-margin clearfix">
                                        ${detail.loanbankAccountNo}
                                    </div>
                                </td>
                                <td>
                                    <input type="hidden" value="${detail.approvedAmount + detail.loanGuaranteeFee -
							  detail.loanConsultFee - detail.interest - detail.loanManageFee - detail.principle -
							  detail.loanGuaranteeFee - detail.loanGPSFee - detail.loanGPSServiceFee - detail.loanParkFee}"
                                           id="maxloanAmount">

                                    <input type="hidden" value="${detail.approvedAmount}"
                                           name="approvedAmount">
                                    <div class="form-group no-margin clearfix">
                                        <input type="text" class="form-control" id="loanAmount"
                                               name="loanAmount">
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group no-margin clearfix">
                                        <select class="form-control" id="loanPlatform"
                                                name="loanPlatform">
                                            <option value="">请选择</option>
                                            <c:forEach items="${partner}" var="partnerNode">
                                                <option value="${partnerNode.id}">
                                                    ${partnerNode.name}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group no-margin clearfix">
                                        <input type="text" class="form-control" id="loanLender"
                                               name="loanLender">
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group no-margin clearfix">
                                        <input type="text" class="form-control" id="loanTime"
                                               name="loanTime" readonly="readonly">
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                </div>

            </form>
        </div>
        <div class="form-group col-md-12 btn-center">
            <div  class="btn btn-primary btn-primary-lg" id="saveLoanRecordBtn" data-loading-text="确定...">确定</div>
            <div  class="btn btn-cancel btn-primary-lg" data-close="closed">取消</div>
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script type="text/javascript"
        src="${ctx}/static/pagejs/loanManage/loanRecord.js${timeStyle}"></script>
</body>
</html>