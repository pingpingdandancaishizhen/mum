<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/jQuery-city/css/animate.min.css${timeStyle}">
<link rel="stylesheet" href="${ctx}/static/assets/plugins/position/base.css${timeStyle}"/>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/position/big-window.css${timeStyle}"/>
<script src="${ctx}/static/assets/plugins/position/position.data.min.js${timeStyle}" type="text/javascript"></script>
<script src="${ctx}/static/assets/plugins/position/jquery.position.select.js${timeStyle}" type="text/javascript"></script>

<link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/main.css${timeStyle}"/>
<link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/css/city-picker.css${timeStyle}"/>
<script src="${ctx}/static/assets/plugins/city-picker/city-picker.js${timeStyle}"></script>

<link rel="stylesheet" href="${ctx}/static/assets/plugins/webuploader/webuploader.css${timeStyle}"/>
<script src="${ctx}/static/assets/plugins/webuploader/webuploader.js${timeStyle}"></script>
</head>
<body  class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper ">
    <!-- Main content -->
    <section class="content no-padding" id="modifyCustomerForm">
		<form onsubmit="return false;"  class="form-label-auto"   action="${ctx}/system/customer/modifyCustomer" method="post">
			<div class="col-md-12 pages-form">
				<div class="sub-head">
					客户基本信息
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="col-sm-6 row-right">
							<div class="form-group input-group" >
								<label for="type" class="label-head label-head-lg  text-right"> <span class="require">客户类型：</span></label>
								<div class="label-box label-box-sm">
									<input type="hidden" name="id" value="${customer.id}">
									<select class="form-control" name="type" id="type">
										<option value="">请选择</option>
										<c:forEach items="${types}" var="type">
											<option value="${type.typeId}" <c:if test="${customer.type == type.typeId}">selected="selected"</c:if> >${type.typeName}</option>
										</c:forEach>
									</select>
								</div>

							</div>

						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group" >
								<label for="gender" class="label-head label-head-lg  text-right"><span class="require">客户姓名：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control" id="name" name="name" value="${customer.name}">
								</div>

							</div>

						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group" >
								<label for="gender" class="label-head label-head-lg  text-right"><span class="require">身份证号码：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="22" class="form-control" id="licenseNum" name="licenseNum" value="${customer.licenseNum}" data-format-account=" " oninput="tools.format(event,'IDAccount')" >
									<script>
										(function () {
											$('[name="licenseNum"]').trigger('input');
										})()
									</script>
								</div>

							</div>

						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group" >
								<label for="gender" class="label-head label-head-lg  text-right"> <span class="require">性别：</span></label>
								<div class="label-box label-box-sm">
									<select  class="form-control" name="gender" id="gender" readonly="readonly">
										<option value="">请选择</option>
										<c:forEach items="${genders}" var="gender">
											<option value="${gender.type}" <c:if test="${customer.gender == gender.type}">selected="selected"</c:if>>${gender.name}</option>
										</c:forEach>
									</select>
								</div>

							</div>

						</div>
						
						<div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="age" class="label-head label-head-lg  text-right"> <span class="require">年龄：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="3" class="form-control" id="age" name="age" value="${customer.age}" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="birthday" class="label-head label-head-lg  text-right"> <span class="require">生日：</span></label>
                                <div class="label-box label-box-sm">
                                	<input type="text" maxlength="20" class="form-control" id="birthday" name="birthday" value="<fmt:formatDate value="${customer.birthday}" pattern="yyyy-MM-dd"/>" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="idCardVaild" class="label-head label-head-lg  text-right"> 身份证有效期：</label>
                                <div class="label-box label-box-sm">
                                	<input type="text" maxlength="20" class="form-control" id="idCardVaild" name="idCardVaild" value="<fmt:formatDate value="${customer.idCardVaild}" pattern="yyyy-MM-dd"/>" readonly="readonly">
                                </div>
                            </div>
                        </div>

						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right" for="maritalStatus"><span>婚姻状况：</span></label>
								<div class="label-box label-box-sm">
									<select  class="form-control" name="maritalStatus" id="maritalStatus">
										<option value="">请选择</option>
										<c:forEach items="${marital}" var="marry">
											<option value="${marry.type}" <c:if test="${customer.maritalStatus == marry.type}">selected="selected"</c:if>>${marry.name}</option>
										</c:forEach>
									</select>
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right" for="childCount"><span>子女数目： </span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="3" class="form-control" id="childCount" name="childCount" value="${customer.childCount}">
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right" for="supportNum"><span>供养人数</span>：</label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="3" class="form-control" id="supportNum" name="supportNum" value="${customer.supportNum}">
								</div>

							</div>
						</div>

						<div class="col-sm-6 row-right">
							<div class="form-group input-group ">
								<label class="label-head label-head-lg  text-right"  for="houseSpending"><span>每月家庭支出：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control" id="houseSpending" name="houseSpending" value="${customer.houseSpending}" data-format-account="," oninput="tools.format(event,'amount')">
									<script>
										(function () {
											$('[name="houseSpending"]').trigger('input');
										})()
									</script>
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="education"><span>最高学历：</span></label>
								<div class="label-box label-box-sm">
									<select  class="form-control" name="education" id="education">
										<option value="">请选择</option>
										<c:forEach items="${education}" var="education">
											<option value="${education.type}"  <c:if test="${customer.education == education.type}">selected="selected"</c:if>>${education.name}</option>
										</c:forEach>
									</select>
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="gender" ><span class="require">移动电话1：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="13" class="form-control" id="mobile" name="mobile" value="${customer.mobile}" data-format-account=" " oninput="tools.format(event,'mobile')">
									<script>
										(function () {
											$('[name="mobile"]').trigger('input');
										})()
									</script>
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="mobile2"><span>移动电话2：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="13" class="form-control" id="mobile2" name="mobile2" value="${customer.mobile2}" data-format-account=" " oninput="tools.format(event,'mobile')">
									<script>
										(function () {
											$('[name="mobile2"]').trigger('input');
										})()
									</script>
								</div>

							</div>
						</div>

						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="email"><span>邮箱：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="32" class="form-control" id="email" name="email" value="${customer.email}">
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="qq"><span>QQ：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="15" class="form-control" id="qq" name="qq" value="${customer.qq}">
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="wechat"><span>微信：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control" id="wechat" name="wechat"  value="${customer.wechat}">
								</div>

							</div>
						</div>

						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="phone"><span>住宅电话：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="13" class="form-control" id="phone" name="phone" value="${customer.phone}">
								</div>

							</div>
						</div>

						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="houseTime"><span>现住址入住时间：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control" id="houseTime" name="houseTime" value='<fmt:formatDate value="${customer.houseTime}" pattern="yyyy-MM-dd"/>'  readonly="readonly">
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="houseType"><span>现住址类别：</span></label>
								<div class="label-box label-box-sm">
									<select  class="form-control" name="houseType" id="houseType">
										<option value="">请选择</option>
										<c:forEach items="${houseTypes}" var="houseType">
											<option value="${houseType.typeId}" <c:if test="${customer.houseType == houseType.typeId}">selected="selected"</c:if>>${houseType.typeName}</option>
										</c:forEach>
									</select>
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  ><span>来本市时间：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control" id="comeTime" name="comeTime" value="<fmt:formatDate value="${customer.comeTime}" pattern="yyyy-MM-dd"/>" readonly="readonly">
								</div>

							</div>
						</div>

						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right" ><span>户口所在地：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" class="form-control " id="registAddr" name="registAddr" value="${customer.registAddr}" readonly="readonly" >
								</div>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control " id="registAddrDetail" name="registAddrDetail" value="${customer.registAddrDetail}" placeholder="请输入详细地址">
								</div>

							</div>
						</div>

						<div class="col-sm-6 row-right">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="liveAddr"><span>现住址：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" class="form-control " id="liveAddr" name="liveAddr" value="${customer.liveAddr}"  readonly="readonly">
								</div>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control " id="liveAddrDetail" name="liveAddrDetail" value="${customer.liveAddrDetail}" placeholder="请输入详细地址">
								</div>

							</div>
						</div>

					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel panel-default -->
				<div class="sub-head">
					客户影像资料
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="panel-body">
							<div class="bootstrap-table table-inner-inline">
								<div class="fixed-table-container">
									<div class="fixed-table-body">
										<table class="table  table-striped">
											<thead>
											<tr>
												<th width="20" class="text-center">ID</th>
												<th width="20"> 身份资料</th>
											</tr>
											</thead>
											<tbody>
											<tr>
												<td class="text-center">1</td>
												<td>
													<div class="form-inline uploadFile form-group">
														<div class=" col-sm-12">
															<div class="input-group uploadFileDiv">
      												            <span class="input-group-addon input-group-addon-small">
      													<span class="require"
															  style="display: inline-block;">身份证照正面</span>
      												</span>
																<input type="text" id="idCardFront" class="hiddenInput"
																	   name="idCardFront" value="${idCardFront.resourceId}">
																<div class="form-control">
																	<div class="uploadFileName">
																		<c:if test="${not empty idCardFront}">
																			<div title="${idCardFront.fileName}" class="file-caption-name">
																				<i class="glyphicon glyphicon-file"></i>
																				<span><a href="${ctx}/getResourceById?resourceId=${idCardFront.resourceId}" target="_blank">${idCardFront.fileName}</a></span>
																			</div>
																		</c:if>
																	</div>
																	<div class="fileNote">
																	</div>
																</div>
																<div class="input-group-btn">
																	<div class="btn btn-upload deleteFileBtn">
																		<i class="glyphicon glyphicon-trash"></i>
																		<span>删除</span>
																	</div>
																	<!--<div class="btn btn-upload uploadFileBtn">
                                                                        <div>
                                                                            <i class="glyphicon glyphicon-upload"></i>
                                                                            <span>上传</span>
                                                                        </div>
                                                                    </div>-->
																	<div class="btn btn-upload " id="pick-custimg_idcard1">
																	</div>
																</div>
															</div>
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<td class="text-center">2</td>
												<td>
													<div class="form-inline uploadFile form-group">
														<div class=" col-sm-12">
															<div class="input-group uploadFileDiv">
      												<span class="input-group-addon input-group-addon-small">
      													<span class="require"
															  style="display: inline-block;">身份证照反面</span>
      												</span>
																<input type="text" id="idCardBack" name="idCardBack" class="hiddenInput" value="${idCardBack.resourceId}">
																<div class="form-control ">
																	<div class="uploadFileName">
																		<c:if test="${not empty idCardBack}">
																			<div title="${idCardBack.fileName}" class="file-caption-name">
																				<i class="glyphicon glyphicon-file"></i>
																				<span><a href="${ctx}/getResourceById?resourceId=${idCardBack.resourceId}" target="_blank">${idCardBack.fileName}</a></span>
																			</div>
																		</c:if>
																	</div>
																	<div class="fileNote">

																	</div>
																</div>
																<div class="input-group-btn">
																	<div class="btn btn-upload deleteFileBtn" >
																		<i class="glyphicon glyphicon-trash"></i>
																		<span>删除</span>
																	</div>
																	<!--<div class="btn btn-upload uploadFileBtn">
                                                                        <div>
                                                                            <i class="glyphicon glyphicon-upload"></i>
                                                                            <span>上传</span>
                                                                        </div>
                                                                    </div>-->
																	<div class="btn btn-upload" id="pick-custimg_idcard2">
																	</div>
																</div>
															</div>
														</div>
													</div>
												</td>
											</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>

						</div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
				<div class="sub-head">
					客户职业信息
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
                    	<div class="col-sm-6 row-right ">
	                        <div class="form-group input-group">
	                            <label class="label-head label-head-lg  text-right"  for="jobType"><span>职业身份：</span></label>
	                            <div class="label-box">
	                            	<c:forEach items="${jobType}" var="jobType" >
	                            	<label class="inline-radio">
                                        <input type="radio" value="${jobType.type}" name="jobType" <c:if test="${customer.jobType == jobType.type}">checked="checked"</c:if>/>${jobType.name}
	                            	</label>
                                    </c:forEach>
	                            </div>
	                        </div>
	                    </div>
	                </div>
					
					<div class="panel-body" id="jobTypeDiv">
						<div class="col-sm-6 row-right" 
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:block;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						for="SXRS,QYGD,ZGRS">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="industry"><span>所属行业：</span></label>
								<div class="label-box label-box-sm">
									<input type="text"  class="form-control" id="industry" name="industry" value="${customer.industry}"  readonly="readonly" data-industry-job="${customer.industry},${customer.job}">
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right"
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:none;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:block;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						 for="SXRS,QYGD">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="job"><span>职位：</span></label>
								<div class="label-box label-box-sm">
									<input type="text"  class="form-control" id="job" name="job" value="${customer.job}" readonly="readonly">
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right" 
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:none;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:block;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						for="SXRS,QYGD" >
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="companyType"><span>
									公司性质：
								</span></label>
								<div class="label-box label-box-sm">
									<select  class="form-control" name="companyType" id="companyType">
										<option value="">请选择</option>
										<c:forEach items="${companyType}" var="companyType">
											<option value="${companyType.type}" <c:if test="${customer.companyType == companyType.type}">selected="selected"</c:if>>${companyType.name}</option>
										</c:forEach>
									</select>
								</div>

							</div>
						</div>


						<div class="col-sm-6 row-right"
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:block;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						 for="SXRS,QYGD,ZGRS">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="companyName"><span>
									<c:choose>
										<c:when test="${customer.jobType eq '1'}">
											单位名称：
										</c:when>
										<c:when test="${customer.jobType eq '2'}">
											收入来源：
										</c:when>
										<c:when test="${customer.jobType eq '3'}">
											单位名称：
										</c:when>
									</c:choose>
								</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control" id="companyName" name="companyName"  value="${customer.companyName}" >
								</div>

							</div>
						</div>

						<div class="col-sm-6 row-right" 
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:none;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:none;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						 for="SXRS">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="deptName"><span>
									所在部门/科室：
								</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="15" class="form-control" id="deptName" name="deptName" value="${customer.deptName}">
								</div>

							</div>
						</div>
						
						<div class="col-sm-6 row-right " 
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:none;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:none;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>						
						 for="SXRS">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="jobTitle"><span>职称：</span></label>
                                <div class="label-box label-box-sm">
                                    <select class="form-control" name="jobTitle"
                                            id="jobTitle">
                                        <option value="">请选择</option>
                                        <c:forEach items="${jobTitle}" var="jobTitle">
                                            <option value="${jobTitle.type}" <c:if test="${customer.jobTitle == jobTitle.type}">selected="selected"</c:if>>
                                                ${jobTitle.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                    
                                </div>
                            </div>
                        </div>
                        
						<div class="col-sm-6 row-right" 
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:none;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:block;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						 for="SXRS,QYGD">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  ><span>
									<c:choose>
										<c:when test="${customer.jobType eq '1'}">
											入职时间：
										</c:when>
										<c:when test="${customer.jobType eq '3'}">
											注册日期：
										</c:when>
									</c:choose>
								</span></label>
								<div class="label-box label-box-sm">
									<input type="text"  class="form-control" id="entryTime" name="entryTime" value="<fmt:formatDate value="${customer.entryTime}" pattern="yyyy-MM-dd"/>" readonly="readonly">
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right" 
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:block;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						 for="SXRS,ZGRS,QYGD">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="salary"><span>
									<c:choose>
										<c:when test="${customer.jobType eq '1'}">
											月均工资：
										</c:when>
										<c:when test="${customer.jobType eq '2'}">
											每月收入：
										</c:when>
										<c:when test="${customer.jobType eq '3'}">
											月营业额：
										</c:when>
									</c:choose>
								</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control" id="salary" name="salary" value="${customer.salary}" data-format-account="," oninput="tools.format(event,'amount')">
									<script>
										(function () {
											$('[name="salary"]').trigger('input');
										})()
									</script>
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right" 
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:none;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:none;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						 for="SXRS">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="salaryDate"><span>每月发薪日：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="20" class="form-control" id="salaryDate" name="salaryDate" value="${customer.salaryDate}">
								</div>

							</div>
						</div>

						<div class="col-sm-6 row-right" 
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:none;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:none;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						 for="SXRS">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="salaryType"><span>工资发放形式：</span></label>
								<div class="label-box label-box-sm">
									<select  class="form-control" name="salaryType" id="salaryType">
										<option value="">请选择</option>
										<c:forEach items="${salaryType}" var="salaryType">
											<option value="${salaryType.type}" <c:if test="${customer.salaryType == salaryType.type}">selected="selected"</c:if>>${salaryType.name}</option>
										</c:forEach>
									</select>
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right" 
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:none;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:block;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						for="SXRS,QYGD">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"  for="companyPhone"><span>单位电话：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" maxlength="13" class="form-control" id="companyPhone" name="companyPhone" value="${customer.companyPhone}">
								</div>

							</div>
						</div>
						<div class="col-sm-6 row-right"
						<c:choose>
							<c:when test="${customer.jobType eq '1'}">
								style="display:block;"
							</c:when>
							<c:when test="${customer.jobType eq '2'}">
								style="display:none;"
							</c:when>
							<c:when test="${customer.jobType eq '3'}">
								style="display:block;"
							</c:when>
							<c:otherwise>
								style="display:none;"
							</c:otherwise>
						</c:choose>
						 for="SXRS,QYGD">
							<div class="form-group input-group">
								<label class="label-head label-head-lg  text-right"><span>单位地址：</span></label>
								<div class="label-box label-box-sm">
									<input type="text" class="form-control " id="companyAddr" name="companyAddr" value="${customer.companyAddr}" readonly="readonly">
								</div>
								<div class="label-box label-box-sm">
									<input type="text"  class="form-control " id="companyAddrDetail" name="companyAddrDetail" value="${customer.companyAddrDetail}" placeholder="请输入详细地址">
								</div>
							</div>
						</div>
					</div>
					
					<div class="panel-body" <c:if test="${not empty customer.jobType}">
								style="display:none;"
							</c:if> id="resourceDiv">
                            <div class="bootstrap-table table-inner-inline">
                                <div class="fixed-table-container">
                                    <div class="fixed-table-body">
                                        <table class="table  table-striped">
                                            <thead>
	                                            <tr>
	                                                <th width="20" class="text-center">ID</th>
	                                                <th width="20"> 身份资料</th>
	                                            </tr>
                                            </thead>
                                            <tbody>
                                            	<tr>
                                                <td class="text-center">1</td>
                                                <td>
                                                    <div class="form-inline uploadFile form-group">
                                                        <div class=" col-sm-12">
                                                            <div class="input-group uploadFileDiv">
      												            <span class="input-group-addon input-group-addon-small">
			      													<span style="display: inline-block;">征信报告</span>
			      												</span>
                                                                <input type="text" id="creditReport" class="hiddenInput"
                                                                       name="creditReport">
                                                                <div class="form-control">
                                                                    <div class="uploadFileName">
																		<c:if test="${not empty creditReport}">
																			<div title="${creditReport.fileName}" class="file-caption-name">
																				<i class="glyphicon glyphicon-file"></i>
																				<span><a href="${ctx}/getResourceById?resourceId=${creditReport.resourceId}" target="_blank">${creditReport.fileName}</a></span>
																			</div>
																		</c:if>
                                                                    </div>
                                                                    <div class="fileNote">
                                                                    </div>
                                                                </div>
                                                                <div class="input-group-btn">
                                                                    <div class="btn btn-upload deleteFileBtn">
                                                                        <i class="glyphicon glyphicon-trash"></i>
                                                                        <span>删除</span>
                                                                    </div>
                                                                    <!--<div class="btn btn-upload uploadFileBtn">
                                                                        <div>
                                                                            <i class="glyphicon glyphicon-upload"></i>
                                                                            <span>上传</span>
                                                                        </div>
                                                                    </div>-->
                                                                    <div class="btn btn-upload " id="pick-custimg_creditReport">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div> <!---->
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="text-center">2</td>
                                                <td>
                                                    <div class="form-inline uploadFile form-group">
                                                        <div class=" col-sm-12">
                                                            <div class="input-group uploadFileDiv">
      														<span class="input-group-addon input-group-addon-small" >
		      													<span id="resourceText" style="display: inline-block;">
		      													<c:choose>
																	<c:when test="${customer.jobType eq '1'}">
																		社保/公积金流水
																	</c:when>
																	<c:when test="${customer.jobType eq '2'}">
																		社保/公积金流水
																	</c:when>
																	<c:when test="${customer.jobType eq '3'}">
																		营业执照
																	</c:when>
																</c:choose>
		      													</span>
		      												</span>
                                                                <input type="text" id="resourceId" name="resourceId" class="hiddenInput" >
                                                                <div class="form-control ">
                                                                    <div class="uploadFileName">
                                                                    	<c:if test="${not empty resource}">
																			<div title="${resource.fileName}" class="file-caption-name">
																				<i class="glyphicon glyphicon-file"></i>
																				<span><a href="${ctx}/getResourceById?resourceId=${resource.resourceId}" target="_blank">${resource.fileName}</a></span>
																			</div>
																		</c:if>
                                                                    </div>
                                                                    <div class="fileNote">

                                                                    </div>
                                                                </div>
                                                                <div class="input-group-btn">
                                                                    <div class="btn btn-upload deleteFileBtn" >
                                                                        <i class="glyphicon glyphicon-trash"></i>
                                                                        <span>删除</span>
                                                                    </div>
                                                                    <!--<div class="btn btn-upload uploadFileBtn">
                                                                        <div>
                                                                            <i class="glyphicon glyphicon-upload"></i>
                                                                            <span>上传</span>
                                                                        </div>
                                                                    </div>-->
                                                                    <div class="btn btn-upload" id="pick-custimg_resourceId">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div> <!---->
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                        
				</div>
				
				<div class="sub-head">
                    	紧急联系人信息 
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                    	<div class="bootstrap-table table-inner-inline">
                                <div class="fixed-table-container">
                                    <div class="fixed-table-body">
                                        <table class="table  table-striped">
                                            <thead>
	                                            <tr>
	                                                <th width="20">关系</th>
	                                                <th width="20">姓名</th>
	                                                <th width="20">是否知晓</th>
	                                                <th width="20">移动电话</th>
	                                                <th width="20">单位名称</th>
	                                            </tr>
                                            </thead>
                                            <tbody id="contact_tab">
                                            	<tr>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	<select class="form-control" name="custContacts[0].relation"/>
			                                                	<option value="">请选择</option>
						                                        <c:forEach items="${custCustomerType}" var="custCustomerType">
						                                            <option value="${custCustomerType.type}"  <c:if test="${custContacts[0].relation == custCustomerType.type}">selected="selected"</c:if>>
						                                                ${custCustomerType.name}
						                                            </option>
						                                        </c:forEach>
					                                        </select>
				                                        </div>
													</td>
	                                                <td>
	                                                	<input type="hidden" name="custContacts[0].index" value="1"/>
	                                                	<div class="label-box label-box-sm">
	                                                	<input class="form-control" name="custContacts[0].name" value="${custContacts[0].name}"/>
	                                                	</div>
													</td>
	                                                <td>
	                                                	<div class="label-box label-box-sm">
	                                                	是<input type="radio" value="1" name="custContacts[0].isknow"  <c:if test="${custContacts[0].isknow}">checked="checked"</c:if>>
                                       					否<input type="radio" value="0" name="custContacts[0].isknow" <c:if test="${!custContacts[0].isknow}">checked="checked"</c:if>>
														</div>
													</td>
	                                                <td>
	                                                	<div class="label-box label-box-sm">
	                                                	<input class="form-control" name="custContacts[0].mobile" value="${custContacts[0].mobile}" data-format-account=" " oninput="tools.format(event,'mobile')">
															<script>
																(function () {
																	$('[name="custContacts[0].mobile"]').trigger('input');
																})()
															</script>
	                                                	</div>
													</td>
	                                                <td>
	                                                	<div class="label-box label-box-sm">
	                                                	<input class="form-control" name="custContacts[0].company" value="${custContacts[0].company}"/>
	                                                	</div>
													</td>
	                                            </tr>
	                                            <tr>
	                                                <td>
	                                                	<div class="label-box label-box-sm">
	                                                	<select class="form-control" name="custContacts[1].relation"/>
		                                                	<option value="">请选择</option>
					                                        <c:forEach items="${custCustomerType}" var="custCustomerType">
					                                            <option value="${custCustomerType.type}"  <c:if test="${custContacts[1].relation == custCustomerType.type}">selected="selected"</c:if>>
					                                                ${custCustomerType.name}
					                                            </option>
					                                        </c:forEach>
				                                        </select>
				                                        </div>
													</td>
	                                                <td>
	                                                	<input type="hidden" name="custContacts[1].index" value="2"/>
	                                                	<div class="label-box label-box-sm">
	                                                	<input class="form-control" name="custContacts[1].name" value="${custContacts[1].name}"/>
	                                                	</div>
													</td>
	                                                <td>
	                                                <div class="label-box label-box-sm">
	                                                	是<input type="radio" value="1" name="custContacts[1].isknow"  <c:if test="${custContacts[1].isknow}">checked="checked"</c:if>>
                                       					否<input type="radio" value="0" name="custContacts[1].isknow" <c:if test="${!custContacts[1].isknow}">checked="checked"</c:if>>
                                       					</div>
													</td>
	                                                <td>
	                                                <div class="label-box label-box-sm">
	                                                	<input class="form-control" name="custContacts[1].mobile" value="${custContacts[1].mobile}" data-format-account=" " oninput="tools.format(event,'mobile')">
														<script>
															(function () {
																$('[name="custContacts[1].mobile"]').trigger('input');
															})()
														</script>
	                                                	</div>
													</td>
	                                                <td>
	                                                <div class="label-box label-box-sm">
	                                                	<input class="form-control" name="custContacts[1].company" value="${custContacts[1].company}"/>
	                                                	</div>
													</td>
	                                            </tr>
	                                            <tr>
	                                                <td>
	                                                <div class="label-box label-box-sm">
	                                                	<select class="form-control" name="custContacts[2].relation"/>
		                                                	<option value="">请选择</option>
					                                        <c:forEach items="${custCustomerType}" var="custCustomerType">
					                                            <option value="${custCustomerType.type}"  <c:if test="${custContacts[2].relation == custCustomerType.type}">selected="selected"</c:if>>
					                                                ${custCustomerType.name}
					                                            </option>
					                                        </c:forEach>
				                                        </select>
				                                        </div>
													</td>
	                                                <td>
	                                                	<input type="hidden" name="custContacts[2].index" value="3"/>
	                                                	<div class="label-box label-box-sm">
	                                                	<input class="form-control" name="custContacts[2].name" value="${custContacts[2].name}"/>
	                                                	</div>
													</td>
	                                                <td>
	                                                <div class="label-box label-box-sm">
	                                                	是<input type="radio" value="1" name="custContacts[2].isknow"  <c:if test="${custContacts[2].isknow}">checked="checked"</c:if>>
                                       					否<input type="radio" value="0" name="custContacts[2].isknow" <c:if test="${!custContacts[2].isknow}">checked="checked"</c:if>>
                                       					</div>
													</td>
	                                                <td>
	                                                <div class="label-box label-box-sm">
	                                                	<input class="form-control" name="custContacts[2].mobile" value="${custContacts[2].mobile}" data-format-account=" " oninput="tools.format(event,'mobile')">
														<script>
															(function () {
																$('[name="custContacts[2].mobile"]').trigger('input');
															})()
														</script>
	                                                	</div>
													</td>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	<input class="form-control" name="custContacts[2].company" value="${custContacts[2].company}"/>
	                                                	</div>
													</td>
	                                            </tr>
	                                            <tr>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	<select class="form-control" name="custContacts[3].relation"/>
			                                                	<option value="">请选择</option>
						                                        <c:forEach items="${custCustomerType}" var="custCustomerType">
						                                            <option value="${custCustomerType.type}"  <c:if test="${custContacts[3].relation == custCustomerType.type}">selected="selected"</c:if>>
						                                                ${custCustomerType.name}
						                                            </option>
						                                        </c:forEach>
					                                        </select>
				                                        </div>
													</td>
	                                                <td>
	                                                	<input type="hidden" name="custContacts[3].index" value="4"/>
	                                                	<div class="label-box label-box-sm">
	                                                		<input class="form-control" name="custContacts[3].name" value="${custContacts[3].name}"/>
	                                                	</div>
													</td>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	是<input type="radio" value="1" name="custContacts[3].isknow"  <c:if test="${custContacts[3].isknow}">checked="checked"</c:if>>
	                                       					否<input type="radio" value="0" name="custContacts[3].isknow" <c:if test="${!custContacts[3].isknow}">checked="checked"</c:if>>
                                       					</div>
													</td>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	<input class="form-control" name="custContacts[3].mobile" value="${custContacts[3].mobile}" data-format-account=" " oninput="tools.format(event,'mobile')">
															<script>
																(function () {
																	$('[name="custContacts[3].mobile"]').trigger('input');
																})()
															</script>
	                                                	</div>
													</td>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	<input class="form-control" name="custContacts[3].company" value="${custContacts[3].company}"/>
	                                                	</div>
													</td>
	                                            </tr>
	                                            <tr>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	<select class="form-control" name="custContacts[4].relation"/>
			                                                	<option value="">请选择</option>
						                                        <c:forEach items="${custCustomerType}" var="custCustomerType">
						                                            <option value="${custCustomerType.type}"  <c:if test="${custContacts[4].relation == custCustomerType.type}">selected="selected"</c:if>>
						                                                ${custCustomerType.name}
						                                            </option>
						                                        </c:forEach>
					                                        </select>
				                                        </div>
													</td>
	                                                <td>
	                                                	<input type="hidden" name="custContacts[4].index" value="5"/>
	                                                	<div class="label-box label-box-sm">
	                                                		<input class="form-control" name="custContacts[4].name" value="${custContacts[4].name}"/>
	                                                	</div>
													</td>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	是<input type="radio" value="1" name="custContacts[4].isknow"  <c:if test="${custContacts[4].isknow}">checked="checked"</c:if>>
	                                       					否<input type="radio" value="0" name="custContacts[4].isknow" <c:if test="${!custContacts[4].isknow}">checked="checked"</c:if>>
                                       					</div>
													</td>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	<input class="form-control" name="custContacts[4].mobile" value="${custContacts[4].mobile}" data-format-account=" " oninput="tools.format(event,'mobile')">
															<script>
																(function () {
																	$('[name="custContacts[4].mobile"]').trigger('input');
																})()
															</script>
	                                                	</div>
													</td>
	                                                <td>
		                                                <div class="label-box label-box-sm">
		                                                	<input class="form-control" name="custContacts[4].company" value="${custContacts[4].company}"/>
	                                                	</div>
													</td>
	                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                    </div>
                </div>
				<!-- /.panel panel-default -->
				<div class="modal-footer btn-center">
					<div  class="btn btn-primary btn-primary-lg" id="modifyCustomerBtn" btn btn-primary>确定</div>
					<div  class="btn btn-cancel btn-primary-lg" id="cancelBtn">取消</div>
				</div>
			</div>
		</form>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <script type="text/javascript" src="${ctx}/static/pagejs/system/customer/customer-modify.js"></script>
</body>
</html>