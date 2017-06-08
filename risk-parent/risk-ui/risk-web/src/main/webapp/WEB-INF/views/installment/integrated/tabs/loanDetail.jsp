<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
<div class="tab-pane" id="loanDetail">
            <div class="box-body">
                <form onsubmit="return false;"  class="form-inline form-label-auto" id="viewContractPartnerForm" action="#">
                    <div class="sub-head">
                        借款信息
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-sm-6 row-left">
                                <div class="input-group form-group">
                                    <label class="label-head  text-right">产品:</label>
                                    <div class="label-box label-box-sm">
                                        <input readonly style="background:#FFFFFF" type="text" class="form-control" value="车贷 融金分期宝" >
                                        <!-- <label class="form-control label_view" >车贷 融金分期宝</label> -->
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 row-right">
                                <div class="input-group form-group">
                                    <label class="label-head  text-right">借款用途:</label>
                                    <div class="label-box label-box-sm">
                                        <input readonly style="background:#FFFFFF" type="text" class="form-control" value="购买保险" >
                                        <!-- <label class="form-control label_view" >购买保险</label> -->
                                    </div>
                                </div>
                            </div>

                            <div class="form-group  clearfix col-sm-12">
                                    <div class="bootstrap-table">
                                        <div class="fixed-table-container">
                                            <div class="fixed-table-body">
				                                <table class="table table-striped" >
				                                    <tbody>
				                                    <tr>
				                                        <td>借款金额</td>
				                                        <td>${insurance.bBalance }元</td>
				                                        <td>借款期限</td>
				                                        <td>${insurance.loanPeriodsNum }月</td>
				                                    </tr>
				                                    <tr>
				                                        <td>借款还款方式</td>
				                                        <td>${insurance.payMethod }</td>
				                                        <td>手续费</td>
				                                        <td>${insurance.sumPoundage }元</td>
				                                    </tr>
				                                    <tr>
				                                        <td>利息/月</td>
				                                        <td>0%</td>
				                                        <td></td>
				                                        <td></td>
				                                    </tr>
				                                    </tbody>
				                                </table>
				                            </div>
				                        </div>
				                   </div>
                            </div>
                        </div>
                    </div>
                    <div class="sub-head">
                        借款人银行信息:
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="sub-head">
                                还款银行资料:
                            </div>
                            <div class="form-group">
                                <div class="col-sm-6 row-right">
                                    <div class="input-group form-group">
                                        <label class="label-head label-head-lg  text-right">还款账户户名:</label>
                                        <div class="label-box label-box-sm">
                                            <%-- <div class="form-control label_view" >${owner.ownerName }</div> --%>
                                            <input readonly style="background:#FFFFFF" type="text" maxlength="18" class="form-control" value="${owner.ownerName }" >
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 row-right">
                                    <div class="input-group form-group">
                                        <label class="label-head label-head-lg  text-right">还款银行账号:</label>
                                        <div class="label-box label-box-sm">
                                            <input readonly style="background:#FFFFFF" type="text" maxlength="18" class="form-control" value="${owner.cardNo }" >

                                            <!-- <label class="form-control label_view" >${owner.cardNo }</label> -->
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 row-right">
                                    <div class="input-group form-group">
                                        <label class="label-head label-head-lg  text-right">还款银行开户行:</label>
                                        <div class="label-box label-box-sm">
                                            <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${owner.bankName }" >
                                            <!-- <label class="form-control label_view" >${owner.bankName }</label> -->
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 row-right">
                                    <div class="input-group form-group">
                                        <label class="label-head label-head-lg  text-right">还款银行开户地:</label>
                                        <div class="label-box label-box-sm">
                                            <input readonly style="background:#FFFFFF" type="text" class="form-control" value="" >
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
                            <div class="col-sm-6 row-right">
                                <div class="input-group form-group">
                                    <label class="label-head label-head-lg  text-right">还款日:</label>
                                    <div class="label-box label-box-sm">
                                        <%-- <label class="form-control label_view" >每月的${loanPeriods[0].day }号</label> --%>
                                        <input readonly style="background:#FFFFFF" type="text" maxlength="18" class="form-control" value="每月的${loanPeriods[0].day }号" >
                                    </div>
                                </div>
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
                                                        <th>月还款总额(元)</th>
                                                        <th>月还款本金(元)</th>
                                                        <th>月还款利息(元)</th>
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
                    </div>
                </form>
            </div>
       
</div>
