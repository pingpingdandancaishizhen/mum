<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>乐位云风控--放款计划</title>
    <%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content body-box">
       <!-- <div class="body-header">
            <div class="closed" data-close="closed">&times;<span>关闭</span></div>
            <div class="body-title">放款计划</div>
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

        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

</body>
</html>