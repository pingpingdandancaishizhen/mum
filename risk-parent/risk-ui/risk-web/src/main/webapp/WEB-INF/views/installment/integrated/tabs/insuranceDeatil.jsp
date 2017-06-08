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
<div class="tab-pane " id="insuranceDetail">
    <div class="box-body">
        <form onsubmit="return false;"  class="form-inline form-label-auto" id="viewContractPartnerForm" action="#">
            <div class="sub-head">
                保险信息
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right"><span style="color: #FF0000;">*</span>保险公司:</label>
                            <div class="label-box label-box-sm">
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.insurerName }" >
                                <!-- <label class="form-control label_view" id="name_view">${insurance.insurerName }</label> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right"><span style="color: #FF0000;">*</span>投保省市:</label>
                            <div class="label-box label-box-sm">
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.provinceName }${insurance.cityName }" >
                                <!-- <label class="form-control label_view" id="name_view">${insurance.provinceName }${insurance.cityName }</label> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right"><span style="color: #FF0000;">*</span>保费总额:</label>
                            <div class="label-box label-box-sm">
                                <%-- <div class="form-control label_view" id="name_view">${insurance.totalPrice }</div> --%>
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.totalPrice }" >
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right"><span style="color: #FF0000;">*</span>投保日期:</label>
                            <div class="label-box label-box-sm">
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.createTime }" >
                                <!-- <label class="form-control label_view" id="name_view">${insurance.createTime }</label> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">强制险起止日期:</label>
                            <div class="label-box ">
                                <input readonly style="background:#FFFFFF" type="text" maxlength="18" class="form-control" value="${insurance.ciBeginDate }至${insurance.ciEndDate }" data-bv-field="licenseNum">

                                <!-- <label class="form-control label_view" id="name_view">${insurance.ciBeginDate }至${insurance.ciEndDate }</label> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">商业险起止日期:</label>
                            <div class="label-box">
                                <input readonly style="background:#FFFFFF" type="text" maxlength="18" class="form-control" value="${insurance.biBeginDate }至${insurance.biEndDate }" data-bv-field="licenseNum">

                                <!-- <label class="form-control label_view" id="name_view">${insurance.biBeginDate }至${insurance.biEndDate }</label> -->
                            </div>
                        </div>
                    </div>
                    <div class="form-group  clearfix col-sm-12">
                        <div class="bootstrap-table">
                            <div class="fixed-table-container">
                                <div class="fixed-table-body">
                                    <table class="table table-striped" >
                                        <thead>
                                        <tr >
                                            <th>保险类别</th>
                                            <th>保费总额</th>
                                            <th>保单号</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <tr>
                                            <td>强制保险</td>
                                            <td>${insurance.enforcementAmount }</td>
                                            <td>${insurance.ciProposalNo }</td>
                                        </tr>
                                        <tr>
                                            <td>商业保险</td>
                                            <td>${insurance.biPremium }</td>
                                            <td>${insurance.biProposalNo }</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="form-group  clearfix col-sm-12">
                        <div class="bootstrap-table">
                            <div class="fixed-table-container">
                                <div class="fixed-table-body">
                                    <table class="table table-striped" >
                                        <thead>
                                        <tr >
                                            <th>险种类别</th>
                                            <th>险种名称</th>
                                            <th>保额</th>
                                            <th>保费</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <tr>
                                            <td rowspan="2" style="border-right:#ddd 1px solid;">强制保险</td>
                                            <td>交强险</td>
                                            <td></td>
                                            <td>${insurance.ciPremium }</td>
                                        </tr>
                                        <tr>
                                            <td>车船税</td>
                                            <td></td>
                                            <td>${insurance.carshipTax }</td>
                                        </tr>
                                        <c:forEach var="coverage" items="${coverageList}" varStatus="status">
                                        <c:if test="${status.index == 0}">
                                            <c:if test="${coverage.coverageCode ne 'FORCEPREMIUM' }">
                                                <tr>
                                                    <td rowspan="20" style="border-right:#ddd 1px solid;border-top:#ddd 1px solid;">商业保险</td>
                                                    <td>${coverage.coverageName }</td>
                                                    <td>${coverage.insuredAmount }</td>
                                                    <td>${coverage.insuredPremium }</td>
                                                </tr>
                                            </c:if>
                                            </c:if>
                                            <c:if test="${status.index != 0}">
                                            <c:if test="${coverage.coverageCode ne 'FORCEPREMIUM' }">
                                                <tr>
                                                    <td>${coverage.coverageName }</td>
                                                    <td>${coverage.insuredAmount }</td>
                                                    <td>${coverage.insuredPremium }</td>
                                                </tr>
                                            </c:if>
                                            </c:if>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- /.panel-body -->
            </div>
        </form>
    </div>
</div>
