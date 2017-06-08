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
<div class="tab-pane " id="insuranceDetail">
    <div class="box-body">
        <form onsubmit="return false;"  class="form-inline form-label-auto" id="viewContractPartnerForm" action="#">
            <div class="sub-head">
                投保资料
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">借款人：</label>
                            <div class="label-box label-box-sm">
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${owner.ownerName }">
                                <!-- <label class="form-control label_view" >${owner.ownerName }</label> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">订单号：</label>
                            <div class="label-box label-box-sm">
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.insuranceId }">
                                <!-- <label class="form-control label_view" >${owner.ownerName }</label> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">逾期天数：</label>
                            <div class="label-box label-box-sm">
                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${insurance.insuranceId }">
                                <!-- <label class="form-control label_view" >${owner.ownerName }</label> -->
                            </div>
                        </div>
                    </div>
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
                            <label class="label-head label-head-lg  text-right"><span style="color: #FF0000;">*</span>保费总额:</label>
                            <div class="label-box label-box-sm">
                                <%-- <div class="form-control label_view" id="name_view">${insurance.totalPrice }</div> --%>
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.totalPrice }" >
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right"><span style="color: #FF0000;">*</span>商业险保费金额:</label>
                            <div class="label-box label-box-sm">
                                <%-- <div class="form-control label_view" id="name_view">${insurance.totalPrice }</div> --%>
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.biPremium }" >
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right"><span style="color: #FF0000;">*</span>已还本金:</label>
                            <div class="label-box label-box-sm">
                                <%-- <div class="form-control label_view" id="name_view">${insurance.totalPrice }</div> --%>
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.biPremium }" >
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right"><span style="color: #FF0000;">*</span>未还本金:</label>
                            <div class="label-box label-box-sm">
                                <%-- <div class="form-control label_view" id="name_view">${insurance.totalPrice }</div> --%>
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.biPremium }" >
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right"><span style="color: #FF0000;">*</span>投保城市:</label>
                            <div class="label-box label-box-sm">
                                <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${insurance.cityName }" >
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
                                            <th>险种名称</th>
                                            <th>保额</th>
                                            <th>保费</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <tr>
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
	                                           <tr>
	                                               <td>${coverage.coverageName }</td>
	                                               <td>${coverage.insuredAmount }</td>
	                                               <td>${coverage.insuredPremium }</td>
	                                           </tr>
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
