<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/import/import.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>订单详情</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/jQuery-city/css/animate.min.css">
<link rel="stylesheet" href="${ctx}/static/assets/plugins/position/base.css"/>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/position/big-window.css"/>
<script src="${ctx}/static/assets/plugins/position/position.data.min.js" type="text/javascript"></script>
<script src="${ctx}/static/assets/plugins/position/jquery.position.select.js" type="text/javascript"></script>

<link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/main.css"/>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/css/city-picker.css"/>
<script src="${ctx}/static/assets/plugins/city-picker/city-picker.js"></script>

<link rel="stylesheet" href="${ctx}/static/assets/plugins/webuploader/webuploader.css"/>
<script src="${ctx}/static/assets/plugins/webuploader/webuploader.js"></script>
<script src="${ctx}/static/assets/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${ctx}/static/assets/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${ctx}/static/assets/plugins/input-mask/jquery.inputmask.extensions.js"></script>
</head>
<body class="hold-transition skin-#bfbfbf sidebar-mini">
<input type="hidden" id="model" value="${mode }">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<div class="content-wrapper">
  <section class="content">

  	<div id="save" class="box-tools pull-right" style="position: fixed;right:0;z-index: 999">
		<a class="btn btn-app">
	      <i class="fa fa-save"></i> 保存
	    </a>
    </div>
	  <form onsubmit="return false;"  class="custom-form form-label-auto" id="editOrderForm"  action="${ctx}/system/customer/modifyCustomer" method="post">
		  <input type="hidden" name="id" value="${info.id }">
		  <div class="nav-tabs-custom">
			  <ul class="nav nav-tabs">
				  <li class="active"><a href="#custInfo" data-toggle="tab">客户信息</a></li>
				  <li><a href="#loanInfo" data-toggle="tab">借款信息</a></li>
				  <!--<li class="active"><a href="#tab_1" data-toggle="tab" aria-expanded="true" onclick="switchTab(this);">客户信息</a></li>
				  <li class=""><a href="#tab_2" data-toggle="tab" aria-expanded="false" onclick="switchTab(this);">借款信息</a></li>-->
			  </ul>

			  <div class="tab-content content-padding ">
				  <div class="tab-pane active" id="custInfo">
					  <div class="col-md-12 pages-form">
						  <div>
							  <div class="sub-head">客户基本信息</div>
							  <div class="panel panel-default" id="cust">
								  <div class="panel-body">
									  <div id="customerType" class="col-sm-6 " >
										  <div class="form-group input-group">


										  <label class="label-head label-head-lg  text-right"  for="customerType"  ><span class="require">客户类型</span></label>
											  <div class="label-box label-box-sm form-group">
										  <select name="customerType" class="form-control">
											  <option value="">--请选择--</option>
											  <c:forEach items="${customerTypes }" var="custType">
												  <option value="${custType.typeName}" <c:if test="${info.customerType == custType.typeName}">selected="selected"</c:if>>${custType.typeName}</option>
											  </c:forEach>
										  </select>
												  </div>
										  </div>
									  </div>
									  <div id="customerName" class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="customerName"  ><span class="require">客户姓名</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="customerName"  value="${info.customerName }" maxlength="20" class="form-control" type="text">
												  </div>
										  </div>

									  </div>
									  <div id="gender" class="col-sm-6 " >
										  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="gender" class=""><span>性别</span></label>
											  <div class="label-box label-box-sm form-group">
										  <select name="gender" class="form-control">
											  <option value="">请选择性别</option>
											  <c:forEach items="${genders }" var="gender">
												  <option value="${gender.name}" <c:if test="${info.gender == gender.name}">selected="selected"</c:if>>${gender.name}</option>
											  </c:forEach>
										  </select>
												  </div>
											  </div>
									  </div>
									  <div id="idCard" class="col-sm-6 " >
										  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="idCard"  ><span class="require">身份证号</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="idCard" placeholder="" value="${info.idCard }" class="form-control" type="text" maxlength="20" />
												  </div>
										  </div>
									  </div>
									  <div id="marriage" class="col-sm-6 " >
										  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="marriage" class="">婚姻状况</label>
											  <div class="label-box label-box-sm form-group">
										  <select name="marriage" class="form-control">
											  <option value="">请选择婚姻状况</option>
											  <c:forEach items="${marital}" var="marry">
												  <option value="${marry.type}" <c:if test="${info.marriage == marry.type}">selected="selected"</c:if>>${marry.name}</option>
											  </c:forEach>

										  </select>
												  </div>
											  </div>
									  </div>
									  <div id="hasChild" class="col-sm-6 " >
										  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="hasChild" class=""><span>子女数目</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="hasChild" placeholder="" value="${info.hasChild }" maxlength="2" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div id="hightDegree" class="col-sm-6 " >
										  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="hightDegree" class=""><span>最高学历</span></label>
											  <div class="label-box label-box-sm form-group">
										  <select name="hightDegree" class="form-control">
											  <option value="">请选择最高学历</option>
											  <c:forEach items="${education}" var="education">
												  <option value="${education.name}"  <c:if test="${info.hightDegree == education.name}">selected="selected"</c:if>>${education.name}</option>
											  </c:forEach>
										  </select>
												  </div>
											  </div>
									  </div>
									  <div id="graduateInstitutions" class="col-sm-6 " >
										  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="graduateInstitutions" class=""><span>毕业院校</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="graduateInstitutions" placeholder="" value="${info.graduateInstitutions }" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="form-group col-sm-6">
										  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="schoolAddrJoin"><span>学校地址</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input type="text" class="form-control " id="schoolAddrJoin" name="schoolAddrJoin" value="${info.schoolAddrJoin}" readonly="readonly" >
										  </div>
											  <div class="label-box label-box-sm form-group">
											  <input type="text" maxlength="20" class="form-control " name="schoolAddress" value="${info.schoolAddress}" placeholder="请输入详细地址">
										  </div>
										  </div>
									  </div>
									  <div id="mobilePhone" class="col-sm-6 " >
										  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="mobilePhone"  ><span class="require">手机号</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="mobilePhone" maxlength="11" placeholder="" value="${info.mobilePhone}" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="form-group col-sm-6" >
										  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="houseHoldAddrJoin" ><span>户口所在地</span></label>
											  <div class="label-box label-box-sm">
												  <input type="text" class="form-control " id="houseHoldAddrJoin" name="houseHoldAddrJoin" value="${info.houseHoldAddrJoin}" readonly="readonly" >
											  </div>
											  <div class="label-box label-box-sm">
												  <input type="text" maxlength="20" class="form-control " name="houseHoldAddress" value="${info.houseHoldAddress}" placeholder="请输入详细地址">
											  </div>
										  </div>
									  </div>
								  </div>
							  </div>
						  </div>
						  <div>
							  <div class="sub-head">
								  客户影像资料
							  </div>
							  <div class="panel panel-default">

								  <shiro:hasPermission name="order:upload">
									  <div class="panel-heading">
										  <div class="btn-group">
											  <div id="yx_attach_upload_btn" class="btn btn-white" groupname="1">
												  <i class="fa fa-upload"></i>
												  <span>上传影像资料</span>
											  </div>
										  </div>
									  </div>
								  </shiro:hasPermission>
								  <div class="box-body">
									  <div class="panel-body">
										  <table class="table table-bordered table-hover">
											  <thead>
											  <tr>
												  <th width="20" class="text-center">ID</th>
												  <th width="20"> 身份资料</th>
											  </tr>
											  </thead>
											  <tbody>
											  <c:forEach var="attr" items="${info.attList}" varStatus="status">
												  <c:if test="${attr.attachGroup eq 1}">
													  <tr>
														  <td class="text-center">${attr.id}</td>
														  <td>
														<span>
															<span class="require" style="display: inline-block;align:left;">${attr.attachType}:</span>
															<span style="display: inline-block;"><a  target="_blank" href="${pathRoot}${attr.attachPath}">${attr.attachNewName}</a></span>
															<span class="glyphicon glyphicon-remove" style="margin-left:5px;cursor:pointer;" onclick="removeAttach(${attr.id})"></span>
														</span>
														  </td>
													  </tr>
												  </c:if>
											  </c:forEach>

											  </tbody>
										  </table>
									  </div>
								  </div>
							  </div>
						  </div>
						  <div>
							  <div class="sub-head">客户职业信息</div>
							  <div id="custjob" class="panel panel-default">

								  <div class="panel-body">
									  <div id="jobType" class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="jobType" class=""><span>职业类型</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="jobType" maxlength="20" value="${info.jobType}" placeholder="" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div id="jobTitle" class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="jobTitle" class=""><span>部门职位</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="jobTitle" maxlength="20" placeholder="" value="${info.jobTitle}" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div id="companyName" class="col-sm-6 " >
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="companyName" class=""><span>公司名称</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="companyName" placeholder="" value="${info.companyName}" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div id="companyTel" class="col-sm-6 " >
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="companyTel" class=""><span>公司电话</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="companyTel" maxlength="12" placeholder="" value="${info.companyTel}" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="form-group col-sm-6" >
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="companyAddrJoin" class=""><span>公司地址</span></label>
											  <div class="label-box label-box-sm">
												  <input type="text" class="form-control " id="companyAddrJoin" name="companyAddrJoin" value="${info.companyAddrJoin}" readonly="readonly" >
											  </div>
											  <div class="label-box label-box-sm">
												  <input type="text" maxlength="20" class="form-control " name="companyAddress" value="${info.companyAddress}" placeholder="请输入详细地址">
											  </div>
										  </div>
									  </div>
								  </div>
							  </div>
						  </div>
						  <div>
							  <div class="sub-head">
								  客户收入资料
							  </div>
							  <div class="panel panel-default">

								  <shiro:hasPermission name="order:upload">
									  <div class="panel-heading">
										  <div class="btn-group">
											  <div id="sr_attach_upload_btn" class="btn btn-white" groupname="2">
												  <i class="fa fa-upload"></i>
												  <span>上传收入资料</span>
											  </div>
										  </div>
									  </div>
								  </shiro:hasPermission>
								  <div class="box-body">
									  <div class="panel-body">
										  <table class="table table-bordered table-hover">
											  <thead>
											  <tr>
												  <th width="20" class="text-center">ID</th>
												  <th width="20"> 收入资料</th>
											  </tr>
											  </thead>
											  <tbody>
											  <c:forEach var="attr" items="${info.attList}" varStatus="status">
												  <c:if test="${attr.attachGroup eq 2}">
													  <tr>
														  <td class="text-center">${attr.id}</td>
														  <td>
														<span>
															<span class="require" style="display: inline-block;align:left;">${attr.attachType}:</span>
															<span style="display: inline-block;"><a  target="_blank" href="${pathRoot}${attr.attachPath}">${attr.attachNewName}</a></span>
															<span class="glyphicon glyphicon-remove" style="margin-left:5px;cursor:pointer;" onclick="removeAttach(${attr.id})"></span>
														</span>
														  </td>
													  </tr>
												  </c:if>
											  </c:forEach>
											  </tbody>
										  </table>
									  </div>
								  </div>
							  </div>
						  </div>
						 <div>
							 <div class="sub-head">客户家属朋友信息</div>
							 <div id="custfriend" class="panel panel-default">

								 <div class="panel-body">
									 <div class="col-sm-12">
										 <div id="urgenContact1" class="col-sm-6 " >
											 <div class="form-group input-group">
												 <label class="label-head label-head-lg  text-right"  for="urgenContact1"  ><span class="require">紧急联系人姓名1</span></label>
												 <div class="label-box label-box-sm form-group">
												 <input name="urgenContact1" maxlength="20" placeholder="" value="${info.urgenContact1}" class="form-control" type="text">
													 </div>
											 </div>
										 </div>
										 <div id="relation1" class="col-sm-6 ">
											 <div class="form-group input-group">
												 <label class="label-head label-head-lg  text-right"  for="relation1"  ><span class="require">关系</span></label>
												 <div class="label-box label-box-sm form-group">
												 <select name="relation1" class="form-control">
													 <option value="">--请选择--</option>
													 <c:forEach items="${relations}" var="relation">
														 <option value="${relation.name}"  <c:if test="${info.relation1 == relation.name}">selected="selected"</c:if>>${relation.name}</option>
													 </c:forEach>
												 </select>
													 </div>
											 </div>
										 </div>
										 <div id="urgenPhone1" class="col-sm-6 " >
											 <div class="form-group input-group">
												 <label class="label-head label-head-lg  text-right"  for="urgenPhone1"  ><span class="require">手机号码</span></label>
												 <div class="label-box label-box-sm form-group">
												 <input name="urgenPhone1" maxlength="11" placeholder="" value="${info.urgenPhone1}" class="form-control" type="text">
													 </div>
											 </div>
										 </div>
									 </div>
									 <div class="col-sm-12">
										 <div id="urgenContact2" class="col-sm-6 " >
											 <div class="form-group input-group">
												 <label class="label-head label-head-lg  text-right"  for="urgenContact2" class=""><span>紧急联系人姓名2</span></label>
												 <div class="label-box label-box-sm form-group">
												 <input name="urgenContact2" maxlength="20" placeholder="" value="${info.urgenContact2}" class="form-control" type="text">
													 </div>
											 </div>
										 </div>
										 <div id="relation2" class="col-sm-6 " >
											 <div class="form-group input-group">
												 <label class="label-head label-head-lg  text-right"  for="relation2" class=""><span>关系</span></label>
												 <div class="label-box label-box-sm form-group">
												 <select name="relation2" class="form-control">
													 <option value="">请选择关系</option>
													 <c:forEach items="${relations}" var="relation">
														 <option value="${relation.name}" <c:if test="${info.relation2 == relation.name}">selected="selected"</c:if>>${relation.name}</option>
													 </c:forEach>
												 </select>
													 </div>
											 </div>
										 </div>
										 <div id="urgenPhone2" class="col-sm-6 " >
											 <div class="form-group input-group">
												 <label class="label-head label-head-lg  text-right"  for="urgenPhone2" class=""><span>手机号码</span></label>
												 <div class="label-box label-box-sm form-group">
												 <input name="urgenPhone2" maxlength="11" placeholder="" value="${info.urgenPhone2}" class="form-control" type="text">
													 </div>
											 </div>
										 </div>
									 </div>
								 </div>
							 </div>
						 </div>

					  </div>
				  </div>
				  <div class="tab-pane" id="loanInfo">
					  <div>
						  <div class="sub-head">申请信息</div>
						  <div class="panel panel-default">

							  <div class="panel-body">
								  <div class="col-sm-6 ">
									  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="productType"  ><span class="require">产品</span></label>
										  <div class="label-box label-box-sm form-group">
											  <select name="productType" class="form-control" >
												  <option value="">--请选择--</option>
												  <c:forEach items="${productTypes}" var="productType">
													  <option value="${productType.status}" >${productType.label}</option>
												  </c:forEach>
											  </select>
										  </div>
										  <div class="label-box label-box-sm">
											  <select name="productCode" class="form-control">
												  <option value="">--请选择--</option>
												  <c:forEach items="${products}" var="product">
													  <option value="${product.id}" productType="${product.productType}" <c:if test="${info.productCode == product.id}">selected="selected"</c:if>>${product.productName}</option>
												  </c:forEach>
											  </select>
										  </div>
									  </div>
								  </div>
								  <div class="col-sm-6 ">
									  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="loanPurpose"  ><span class="require">借款用途</span></label>
										  <div class="label-box label-box-sm form-group">
										  <select name="loanPurpose" class="form-control">
											  <option value="">--请选择--</option>
											  <c:forEach items="${loanUsages}" var="loanUsage">
												  <option value="${loanUsage.typeName}" <c:if test="${info.loanPurpose == loanUsage.typeName}">selected="selected"</c:if>>${loanUsage.typeName}</option>
											  </c:forEach>
										  </select>
											  </div>
									  </div>
								  </div>
							  </div>
						  </div>
					  </div>
					  <div  >
						  <div class="sub-head">征信信息</div>
						  <div class="panel panel-default">

							  <div class="panel-body">
								  <div class="col-sm-6 ">
									  <div class="form-group input-group">
										  <label class="label-head label-head-lg  text-right"  for="zMCreditScore"  ><span class="require">芝麻信用分</span></label>
										  <div class="label-box label-box-sm form-group">
										  <input name="zMCreditScore" placeholder="" maxlength="3" value="${info.zMCreditScore}" class="form-control" type="text">
											  </div>
									  </div>
								  </div>
							  </div>
						  </div>
					  </div>
					  <div  >
						  <div class="sub-head">审批信息</div>
						  <div class="panel panel-default">

							  <div class="panel-body">
								  <table class="table table-bordered table-hover">
									  <tbody>
									  <tr>
										  <td class="text-center">
											  <label class="label-head label-head-lg  text-right"  for="loanMoney" class="require" style="display: none;"><span class="require">审批金额</span></label>
											  审批金额
										  </td>
										  <td>
											  <div class="input-group">
												  <input type="text" class="form-control" name="loanMoney" maxlength="8" value="${info.loanMoney}">
												  <span class="input-group-addon">元</span>
											  </div>
										  </td>
										  <td class="text-center">
											  <label class="label-head label-head-lg  text-right"  for="loanPeriod" class="require" style="display: none;"><span class="require">审批期限</span></label>
											  审批期限
										  </td>
										  <td>
											  <div class="input-group">
												  <input type="text" class="form-control" maxlength="2" name="loanPeriod" value="${info.loanPeriod}">
												  <span class="input-group-addon">月</span>
											  </div>
										  </td>
									  </tr>
									  <tr>
										  <td class="text-center">审批还款方式</td>
										  <td>
											  <div class="input-group">
												  <select name="repayType" class="form-control">
													  <option value="">--请选择--</option>
													  <c:forEach items="${loanRepayments}" var="loanRepayment">
														  <option value="${loanRepayment.typeName}" <c:if test="${info.repayType == loanRepayment.typeName}">selected="selected"</c:if>>${loanRepayment.typeName}</option>
													  </c:forEach>
												  </select>
											  </div>
										  </td>
										  <td class="text-center">年化率</td>
										  <td>
											  <div class="input-group">
												  <input type="text" class="form-control" maxlength="5" id="yearFee" disabled="disabled" value="">
												  <span class="input-group-addon">%</span>
											  </div>
										  </td>
									  </tr>
									  <tr>
										  <td class="text-center">利息/月</td>
										  <td>
											  <div class="input-group">
												  <input type="text" class="form-control" maxlength="5" id="loanDayRate" name="loanDayRate" disabled="disabled" value="${info.loanDayRate}">
												  <c:forEach items="${products}" var="product">
													  <c:if test="${info.productCode == product.id}">
														  <script type="text/javascript">
															  feeObj = ${product.feeConfig};
															  $("#loanDayRate").val(feeObj.monthlyFee[0].monthlyRate.toFixed(2));
														  </script>
													  </c:if>
												  </c:forEach>
												  <span class="input-group-addon">%</span>
											  </div>
										  </td>
										  <td class="text-center">管理费/月</td>
										  <td>
											  <div class="input-group">
												  <input type="text" class="form-control" maxlength="5" id="manageDayRate" name="manageDayRate" disabled="disabled" value="${info.manageDayRate}">
												  <c:forEach items="${products}" var="product">
													  <c:if test="${info.productCode == product.id}">
														  <script type="text/javascript">
															  feeObj = ${product.feeConfig};
															  $("#manageDayRate").val(feeObj.monthlyGLFee[0].monthlyGLRate.toFixed(2));
														  </script>
													  </c:if>
												  </c:forEach>
												  <span class="input-group-addon">%</span>
											  </div>
										  </td>
									  </tr>
									  <tr>
										  <td class="text-center">其他费用</td>
										  <td>
											  <div class="input-group">
												  <input type="text" class="form-control" maxlength="8" id="otherFee" name="otherFee"  disabled="disabled" value="${info.otherFee}">
												  <c:forEach items="${products}" var="product">
													  <c:if test="${info.productCode == product.id}">
														  <script type="text/javascript">
															  feeObj = ${product.feeConfig};
															  $("#otherFee").val(feeObj.otherFee[0].fee.toFixed(2));
														  </script>
													  </c:if>
												  </c:forEach>
												  <span class="input-group-addon">元</span>
											  </div>
										  </td>
										  <td class="text-center">提前还款违约率</td>
										  <td>
											  <div class="input-group">
												  <input type="text" class="form-control" disabled="disabled" id="wyFee" >
												  <c:forEach items="${products}" var="product">
													  <c:if test="${info.productCode == product.id}">
														  <script type="text/javascript">
															  feeObj = ${product.feeConfig};
															  $("#wyFee").val(feeObj.wyFee[0].fee.toFixed(2));
														  </script>
													  </c:if>
												  </c:forEach>
												  <span class="input-group-addon">%</span>
											  </div>
										  </td>
									  </tr>
									  <tr>
										  <td class="text-center">保证金率</td>
										  <td>
											  <div class="input-group">
												  <input type="text" class="form-control" disabled="disabled" id="bzjFee" >
												  <c:forEach items="${products}" var="product">
													  <c:if test="${info.productCode == product.id}">
														  <script type="text/javascript">
															  feeObj = ${product.feeConfig};
															  $("#bzjFee").val(feeObj.bzjFee[0].fee.toFixed(2));
														  </script>
													  </c:if>
												  </c:forEach>
												  <span class="input-group-addon">%</span>
											  </div>
										  </td>
										  <td class="text-center"></td>
										  <td></td>
									  </tr>
									  </tbody>
								  </table>
							  </div>
						  </div>
					  </div>
					  <div>
						  <div class="sub-head">借款人银行信息</div>
						  <div class="panel panel-default">

							  <div class="panel-body">
								  <div class="col-sm-12">
									  <div class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="receiversName"  ><span class="require">收款账户户名</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="receiversName" maxlength="20" value="${info.receiversName}" placeholder="请输入收款账户户名" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="receiversBankAccount"  ><span class="require">收款银行账号</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="receiversBankAccount" value="${info.receiversBankAccount}" placeholder="请输入收款银行账号" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="receiversBankName"  ><span class="require">收款银行开户行</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="receiversBankName" value="${info.receiversBankName}" placeholder="请输入收款银行开户行" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="col-sm-6 " >
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="receiversBankAddr"  ><span class="require">收款银行开户地</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input id="receiversBankAddr" value="${info.receiversBankAddr}" name="receiversBankAddr" placeholder="请输入收款银行开户地" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="receiversBankBranch"  ><span class="require">收款银行支行</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="receiversBankBranch" value="${info.receiversBankBranch}" placeholder="请输入收款银行支行" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
								  </div>
								  <div class="col-sm-12">
									  <div class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="repaymentName"  ><span class="require">还款账户户名</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="repaymentName" maxlength="20" value="${info.repaymentName}" placeholder="请输入还款账户户名" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="repaymentBankAccount"  ><span class="require">还款款银行账号</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="repaymentBankAccount" value="${info.repaymentBankAccount}" placeholder="请输入还款款银行账号" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="repaymentBankName"  ><span class="require">还款银行开户行</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="repaymentBankName" value="${info.repaymentBankName}" placeholder="请输入还款银行开户行" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="repaymentBankAddr"  ><span class="require">还款银行开户地</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input id="repaymentBankAddr" value="${info.repaymentBankAddr}" name="repaymentBankAddr" placeholder="请输入还款银行开户地" class="form-control" type="text">
												  </div>
										  </div>
									  </div>
									  <div class="col-sm-6 ">
										  <div class="form-group input-group">
											  <label class="label-head label-head-lg  text-right"  for="repaymentBankBranch"  ><span class="require">还款银行支行</span></label>
											  <div class="label-box label-box-sm form-group">
											  <input name="repaymentBankBranch" value="${info.repaymentBankBranch}" placeholder="请输入还款银行支行" class="form-control" type="text">
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
	  </form>
  </section>
</div>
  <shiro:hasPermission name="order:upload">
  		<%@ include file="./modal/uploadAttachment.jsp"%>
  </shiro:hasPermission>
<script type="text/javascript" src="${ctx}/static/pagejs/system/order/editOrder.js?${timeStyle}"></script>
</body>
</html>