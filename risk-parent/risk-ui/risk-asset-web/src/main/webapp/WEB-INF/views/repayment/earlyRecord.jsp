<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <section class="content body-box pages-form clearfix">
       <!-- <div class="body-header">
            <div class="closed" data-close="closed">&times;<span>关闭</span></div>
            <div class="body-title">提前结清录入</div>
        </div>-->
        <div class="col-md-12 new-box">
            <div class="panel panel-my">
                <div class="panel-body form-label-auto">
                    <div class="col-sm-12 ">
                        <div class="border-dotted">
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">借款人：</div>
                                    <div class="label-box label-name">${attr.custName}</div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">借款合同号：</div>
                                    <div class="label-box label-name">${attr.contractId}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <div class="border-dotted">
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">合同金额：</div>
                                    <div class="label-box label-name">
                                        ${attr.amount}
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <div class="label-head text-right">借款期次：</div>
                                    <div class="label-box label-name">
                                        ${attr.issueCount}
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <c:choose>
                                        <c:when test="${attr.repaymentType eq '3'}">
                                            <div class="label-head text-right">日利率：</div>
                                            <div class="label-box label-name">
                                                <fmt:formatNumber value="${attr.daylyRate}"
                                                                  pattern="#0.00#"/>
                                                %
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="label-head text-right">期利率：</div>
                                            <div class="label-box label-name">
                                                <fmt:formatNumber value="${attr.monthlyRate}"
                                                                  pattern="#0.00#"/>
                                                %
                                            </div>

                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="col-sm-3 form-group form-margin">
                                <div class="input-group">
                                    <c:choose>
                                        <c:when test="${attr.repaymentType eq '3'}">
                                            <div class="label-head text-right">日管理费率：</div>
                                            <div class="label-box label-name">
                                                <fmt:formatNumber value="${attr.daylyGLFee}"
                                                                  pattern="#0.00#"/>
                                                %
                                            </div>

                                        </c:when>
                                        <c:otherwise>
                                            <div class="label-head text-right">期管理费率：</div>
                                            <div class="label-box label-name">
                                                <fmt:formatNumber value="${attr.monthlyGLFee}"
                                                                  pattern="#0.00#"/>
                                                %
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-sm-12">
                        <div class="col-sm-3 form-group form-margin">
                            <div class="input-group ">
                                <div class="label-head text-right">还款账户户名：</div>
                                <div class="label-box label-name">
                                    ${attr.accountName}
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3 form-group form-margin">
                            <div class="input-group">
                                <div class="label-head text-right">还款银行开户行：</div>
                                <div class="label-box label-name">
                                    ${attr.bank}
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3 form-group form-margin">
                            <div class="input-group">
                                <div class="label-head text-right">还款银行账号：</div>
                                <div class="label-box label-name">
                                    ${attr.accountNo}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group col-md-12">
            <div class="sub-head">
                还款信息
            </div>
        </div>
        <div class="form-group col-md-12" >
            <div class="bootstrap-table">
                <div class="fixed-table-body">
                    <table class="table  table-striped">
                        <thead>
                        <tr>
                            <th>期次</th>
                            <th style="width: 200px">计划还款时间</th>
                            <th>期还款总额</th>
                            <th>期还款本金</th>
                            <th>期还款利息</th>
                            <th>期还款管理费</th>
                            <th>期GPS服务费</th>
                            <th>停车费</th>
                            <th style="width: 300px">实际还款日期</th>
                            <th style="width: 300px">实还期本金</th>
                            <th style="width: 300px">实还期利息</th>
                            <th style="width: 300px">实还期管理费</th>
                            <th style="width: 300px">实还期GPS服务费</th>
                            <th style="width: 300px">实还停车费</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestDetails}" var="detail" varStatus="status">
                            <tr>
                                <td>${detail.issue}
                                </td>
                                <td>
                                    <fmt:formatDate value="${detail.issueDate}"
                                                    pattern="yyyy-MM-dd"/>
                                </td>
                                <td>
                                    <fmt:formatNumber
                                            value="${detail.payment + detail.manageFee + detail.extraFee + detail.extraFee2}"
                                            pattern="#,##0.00#"/>
                                </td>
                                <td>
                                    <fmt:formatNumber value="${detail.principle}"
                                                      pattern="#,##0.00#"/>
                                </td>
                                <td>
                                    <fmt:formatNumber value="${detail.interest}"
                                                      pattern="#,##0.00#"/>
                                </td>
                                <td>
                                    <fmt:formatNumber value="${detail.manageFee}"
                                                      pattern="#,##0.00#"/>
                                </td>
                                <td>
                                    <fmt:formatNumber value="${detail.extraFee}"
                                                      pattern="#,##0.00#"/>
                                </td>
                                <td>
                                    <fmt:formatNumber value="${detail.extraFee2}"
                                                      pattern="#,##0.00#"/>
                                </td>
                                <td  class="table-no-padding">
                                    <div class="inner-form">
                                        <c:forEach items="${detail.records}" var="record">
                                            <span>
                                                 <fmt:formatDate value="${record.repaymentTime}" pattern="yyyy-MM-dd"/>
                                            </span>

                                        </c:forEach>

                                        <c:if test="${detail.current}">
                                            <c:set value="${detail.leftPrinciple}" var="leftPrinciple"/>
                                        </c:if>
                                    </div>

                                </td>
                                <td  class="table-no-padding">
                                    <div class="inner-form">
                                        <c:forEach items="${detail.records}" var="record">
                                            <span>
                                                <fmt:formatNumber value="${record.repaymentPrinciple}" pattern="#,##0.00#"/>
                                            </span>

                                        </c:forEach>
                                    </div>

                                </td>
                                <td  class="table-no-padding">
                                    <div class="inner-form">
                                        <c:forEach items="${detail.records}" var="record">
                                            <span>
                                                 <fmt:formatNumber value="${record.repaymentInterest}" pattern="#,##0.00#"/>
                                            </span>

                                        </c:forEach>
                                    </div>

                                </td>
                                <td  class="table-no-padding">
                                    <div class="inner-form">
                                        <c:forEach items="${detail.records}" var="record">
                                            <span>
                                                <fmt:formatNumber value="${record.repaymentManageFee}" pattern="#,##0.00#"/>
                                            </span>
                                        </c:forEach>
                                    </div>

                                </td>
                                <td  class="table-no-padding">
                                    <div class="inner-form">
                                        <c:forEach items="${detail.records}" var="record">
                                            <span>
                                                <fmt:formatNumber value="${record.repaymentExtraFee}" pattern="#,##0.00#"/>
                                            </span>

                                        </c:forEach>
                                    </div>

                                </td>
                                <td  class="table-no-padding">
                                    <div class="inner-form">
                                        <c:forEach items="${detail.records}" var="record">
                                            <span>
                                                <fmt:formatNumber value="${record.repaymentExtraFee2}" pattern="#,##0.00#"/>
                                            </span>

                                        </c:forEach>
                                    </div>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="form-group col-md-12">
            <div class="sub-head">
                提前还款录入
            </div>
        </div>
        <div class="form-group col-md-12" id="repaymentRecordForm">
            <form onsubmit="return false;" class="form-inline form-label-auto" action="${ctx}/repayment/saveSettlementRecord" method="post">
                <div class="col-sm-12">
                    <div class="form-group col-sm-3 ">
                        <div class="input-group">
                            <div class="label-head text-right">提前还款天数：</div>
                            <div class="label-box label-name">${settlement.settlementCount}天</div>
                        </div>
                    </div>
                    <div class="form-group col-sm-3 ">
                        <div class="input-group">
                            <div class="label-head text-right">提前还款违约率：</div>
                            <div class="label-box label-name"><fmt:formatNumber value="${rate.wyFee}" pattern="#0.00#"/>%</div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="form-group col-sm-3 ">
                        <div class="input-group">
                            <label  class="label-head text-right" >提前还款日期：</label>
                            <input type="hidden" value="${settlement.bpId}" name="bpId">
                            <input type="text" class="form-control" id="settlementDate"
                                   value="<fmt:formatDate value="${settlement.settlementDate}" pattern="yyyy-MM-dd"/>"
                            name="settlementDate" readonly="readonly">
                        </div>

                    </div>
                    <div class="form-group col-sm-3 ">
                        <div class="input-group">
                            <label  class="label-head text-right" >提前结清原因：</label>
                            <select class="form-control" name="settlementReason"
                                    id="settlementReason">
                                <option value="">请选择</option>
                                <option value="0">客户主动</option>
                                <option value="1">强制结清</option>
                            </select>
                        </div>

                    </div>
                    <div class="form-group col-sm-3 ">
                        <div class="input-group">
                            <label  class="label-head text-right" >剩余本金：</label>
                            <input type="text" class="form-control" id="settlementPrinciple"
                                   name="settlementPrinciple"
                                   value='<fmt:formatNumber value="${settlement.settlementPrinciple}" pattern="#0.00#"/>'
                                   readonly="readonly">
                        </div>

                    </div>
                    <div class="form-group col-sm-3 ">
                        <div class="input-group">
                            <label  class="label-head text-right" >剩余利息(本期已产生的)：</label>
                            <input type="text" class="form-control" id="settlementInterest"
                                   name="settlementInterest"
                                   value='<fmt:formatNumber value="${settlement.settlementInterest}" pattern="#0.00#"/>'
                                   readonly="readonly">
                        </div>

                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="form-group col-sm-3 ">
                        <div class="input-group">
                            <label  class="label-head text-right" >剩余管理费：</label>
                            <input type="text" class="form-control" id="settlementManageFee"
                                   name="settlementManageFee"
                                   value='<fmt:formatNumber value="${settlement.settlementManageFee}" pattern="#0.00#"/>'
                                   readonly="readonly">
                        </div>

                    </div>
                    <div class="form-group col-sm-3 ">
                        <div class="input-group">
                            <label  class="label-head text-right" >提前还款罚息(违约金)：</label>
                            <input type="text" class="form-control" id="settlementPenalty"
                                   name="settlementPenalty"
                                   value='<fmt:formatNumber value="${settlement.settlementPenalty}" pattern="#0.00#"/>'
                                   readonly="readonly">
                        </div>

                    </div>
                    <div class="form-group col-sm-3 ">
                        <div class="input-group">
                            <label  class="label-head text-right" >拖车费：</label>
                            <input type="text" class="form-control" id="towingFee"
                                   name="towingFee">
                        </div>

                    </div>
                    <div class="form-group col-sm-3 clearfix">

                    </div>
                    <div class="form-group col-sm-3 clearfix">
                        <div class="input-group">
                            <label  class="label-head text-right" >停车费：</label>
                            <input type="text" class="form-control" id="parkingFee"
                                   name="parkingFee">
                        </div>

                    </div>

                </div>
            </form>
        </div>
        <div class="form-group col-sm-12 btn-center table-bottom-tool">
            <div  class="btn btn-primary btn-primary-lg"
                    id="saveRepaymentRecordBtn" data-loading-text="确定...">确定
            </div>
            <div  class="btn btn-cancel btn-primary-lg" data-close="closed">取消
            </div>
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script type="text/javascript" src="${ctx}/static/pagejs/repayment/earlyRecord.js"></script>
</body>
</html>