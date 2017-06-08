<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="/WEB-INF/import/head.jsp"%>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.min.js${timeStyle}"></script>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.min.css${timeStyle}">
<link rel="stylesheet" href="${ctx}/static/assets/plugins/fullcalendar/fullcalendar.print.css${timeStyle}"  media="print">
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
      <%@ include file="/WEB-INF/import/loading.jsp"%>
<div class="tab-pane" id="loanDetail">
            <div class="box-body">
                <form onsubmit="return false;"  class="form-inline form-label-auto" id="viewContractPartnerForm" action="#">
                    <div class="sub-head">
                       还款明细：
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-sm-6 row-right">
		                        <div class="input-group form-group">
		                            <label class="label-head label-head-lg  text-right">借款人：</label>
		                            <div class="label-box label-box-sm">
		                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${owner.ownerName }">
		                                <!-- <label class="form-control label_view" >${owner.ownerName }</label> -->
		                            </div>
		                        </div>
		                    </div>
                            <div class="col-sm-6 row-right">
                                <div class="input-group form-group">
                                    <label class="label-head label-head-lg  text-right">借款金额：</label>
                                    <div class="label-box label-box-sm">
                                        <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${insurance.bBalance }">
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 row-right">
                                <div class="input-group form-group">
                                    <label class="label-head label-head-lg  text-right">借款期限：</label>
                                    <div class="label-box label-box-sm">
                                        <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${insurance.loanPeriodsNum }">
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 row-right">
                                <div class="input-group form-group">
                                    <label class="label-head label-head-lg  text-right">月利率：</label>
                                    <div class="label-box label-box-sm">
                                        <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${insurance.loanPeriodsNum }">
                                    </div>
                                </div>
                            </div>
	                        <div class="col-sm-6 row-right">
	                            <div class="input-group form-group">
	                                <label class="label-head label-head-lg  text-right">还款账户户名:</label>
	                                <div class="label-box label-box-sm">
	                                    <input readonly style="background:#FFFFFF" type="text" maxlength="18" class="form-control" value="${owner.ownerName }" >
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-sm-6 row-right">
	                            <div class="input-group form-group">
	                                <label class="label-head label-head-lg  text-right">还款银行账号:</label>
	                                <div class="label-box label-box-sm">
	                                    <input readonly style="background:#FFFFFF" type="text" maxlength="18" class="form-control" value="${owner.cardNo }" >
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-sm-6 row-right">
	                            <div class="input-group form-group">
	                                <label class="label-head label-head-lg  text-right">还款银行开户行:</label>
	                                <div class="label-box label-box-sm">
	                                    <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${owner.bankName }" >
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-sm-6 row-right">
	                            <div class="input-group form-group">
	                                <label class="label-head label-head-lg  text-right">还款银行支行:</label>
	                                <div class="label-box label-box-sm">
	                                    <input readonly style="background:#FFFFFF" type="text" class="form-control" value="" >
	                                </div>
	                            </div>
	                        </div>
		                    </div>
		                    <div class="sub-head">
		                        还款计划:
		                    </div>
		                    <div class="form-group  clearfix col-sm-12">
		                            <div class="bootstrap-table">
		                                <div class="fixed-table-container">
		                                    <div class="fixed-table-body">
		                                        <table class="table table-striped ">
		                                            <thead>
		                                            <tr>
		                                                <th>期次</th>
		                                                <th>应还款时间</th>
		                                                <!-- <th>月还款总额(元)</th> -->
		                                                <th>应还本金(元)</th>
		                                                <th>应还利息(元)</th>
		                                                <th>实际还款时间</th>
		                                                <th>实还本金(元)</th>
                                                        <th>应还利息(元)</th>
		                                            </tr>
		                                            </thead>
		
		                                            <tbody>
		                                            <c:forEach var="loan" items="${loanPeriods}" varStatus="status">
		                                                <tr>
		                                                    <td>${loan.periodNo }</td>
		                                                    <td>${loan.expireTime }</td>
		                                                    <td>${loan.amount }</td>
		                                                    <td>${loan.principle }</td>
		                                                    <td>${loan.interest }</td>
		                                                    <td>${loan.interest }</td>
		                                                    <td>${loan.interest }</td>
		                                                </tr>
		                                            </c:forEach>
		                                            <tr>
		                                                <td>总计</td>
		                                                <td>-</td>
		                                                <td>${insurance.amount }</td>
		                                                <td>${insurance.sumPrinciple }</td>
		                                                <td>${insurance.sumInterest }</td>
		                                            </tr>
		                                            </tbody>
		                                        </table>
		                                    </div>
		                                </div>
		                            </div>
                        </div>
                    </div>
                </form>
            </div>
       
</div>
