<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/import/import.jsp"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <title>P2P发标系统</title>
    <%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	
	
	<section class="content">
        <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
            <c:forEach items="${products}" var="product" varStatus="status">
                <li  class="${status.index == 0 ?'active':'' }" onclick="getDivId('${product.productCode}')"	><a href="#${product.productCode}" data-toggle="tab">${product.productTypeStr}</a></li>
            </c:forEach>
            </ul>
            <div class="tab-content content-padding " id="$">
              	<c:forEach items="${products}" var="product" varStatus="ps">
              	<div class="tab-pane ${ps.index == 0 ?'active':'' }" id="${product.productCode}">
				    <!-- Main content -->
				    <section class="content content-padding ">
				        <form onsubmit="return false;" class="form-inline form-label-auto table-box"
				              id="corpForm" action="" method="post">
				            	<div class="panel panel-default">
				                    <div class="panel-heading">
				                       	发标产品
				                    </div>
				                    <div class="panel-body">
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                            <label class="label-head">
			          							<span class="require">发标产品类型:</span>     
			          							</label>
				                                <label class="label-box-item"> 
				                                	<input type="hidden" value="${product.id}" id="id">
				                                	<input type="hidden" value="${assetId}" id="assetId">
				                                	<select class="form-control" id="productType" name="productType">
				                                		<option>请选择贷款介质</option>
				                                		<c:forEach items="${proList}" var="pro">
				                                			<option value="${pro.id}"
				                                			<c:if test="${product.productType== pro.id}">
			                                                            selected="selected"
			                                                 </c:if>
				                                			>${pro.name}</option>
				                                		</c:forEach>
				                                	</select>
				                                </label>
				                            </div>
				                        </div>
				                    </div>
				
				                </div>
				                <div class="panel panel-default">
				                    <div class="panel-heading">
				                    	资产方产品简要
				                    </div>
				                    <div class="panel-body">
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head ">
				          <span class="require">产品名称:</span>                       
				                                </label>
				                                <div class="checkbox label-box" id="repaymentTypes">
				                                    <label class="label-box-item"> 
				                                    	<%-- <select class="form-control" id="productName" name="productName">
					                                		<option value="">请选择产品类型</option>
					                                		<c:forEach items="${nameList}" var="n">
					                                			<option value="${n.id}"
					                                			<c:if test="${product.productName== n.id}">
			                                                            selected="selected"
			                                                 	</c:if>
					                                			>${n.name}</option>
					                                		</c:forEach>
					                                	</select> --%>
					                                	<input type="text" name="productName" id="productName" class="form-control" value="${product.productName}"/>
				                                    </label>
				                                </div>
				                            </div>
				                        </div>
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head">
				          <span class="require"> 产品代码：</span>                       
				                               </label>
				                                <div class="checkbox label-box" >
				                                    <label class="label-box-item"> 
				                                    	<input type="text" name="productCode" id="productCode" class="form-control" value="${product.productCode}" readonly="true"/>
				                                    </label>
				                                </div>
				                            </div>
				                        </div>
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head label-head-top">
				                         <span class="require">借款人还款方式：</span>         
				                               </label>
				                                <div class="checkbox label-box label-head-top" >
				                                
				                                 <label class="label-box-item"> <input class="repaymentType" name="feeConfig.repaymentType" value="1" type="checkbox"
				                                 <c:forEach items="${product.cydfeeConfig.repaymentTypes}" var="repay">
				                                 <c:if test="${repay.repaymentType== 1}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach> 
				                                 ><span>等额等息</span>
				                                    </label>
				                                   
				                                    
				                                     
				                                    <label class="label-box-item"> <input class="repaymentType" name="feeConfig.repaymentType" value="2" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.repaymentTypes}" var="repay">
				                                     <c:if test="${repay.repaymentType== 2}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach> 
				                                    ><span>先息后本</span>
				                                    </label>
				                                    
				                                     
				                                    <label class="label-box-item"> <input class="repaymentType"  name="feeConfig.repaymentType" value="3" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.repaymentTypes}" var="repay">
				                                     <c:if test="${repay.repaymentType== 3}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach> 
				                                    ><span>一次性还款</span>
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input class="repaymentType" name="feeConfig.repaymentType" value="4" type="checkbox"
				                                     <c:forEach items="${product.cydfeeConfig.repaymentTypes}" var="repay">
				                                     <c:if test="${repay.repaymentType== 4}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach> 
				                                    ><span>等额本金</span>
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input class="repaymentType" name="feeConfig.repaymentType" value="5" type="checkbox"
				                                     <c:forEach items="${product.cydfeeConfig.repaymentTypes}" var="repay">
				                                     <c:if test="${repay.repaymentType== 5}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach> 
				                                    ><span>等额本息</span>
				                                    </label>
				                                    
				                               
				                                
				                                   
				                                </div>
				                            </div>
				                        </div>
				                        <div class="form-group col-md-12" id="nomal-repayment">
				                            <div class="input-group">
				                                <label class="label-head label-head-top">
				          <span class="require">借款期限：</span>                            
				                               </label>
				                                <div class="checkbox label-box label-head-top" >
				                                
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M1" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                    <c:if test="${te.term== 'M1'}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    ><span>1个月</span>
				                                    </label>	                                    
				                                 
				                                 
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M2" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M2'}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    ><span>2个月</span>
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M3" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M3'}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    ><span>3个月</span>
				                                    </label>
				                                    
				                                  
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M4" type="checkbox"
				                                      <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M4'}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    ><span>4个月</span>
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M5" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M5'}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    ><span>5个月</span>
				                                    </label>
				                                    
				                                   
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M6" type="checkbox"
				                                     <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M6'}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    ><span>6个月</span>
				                                    </label>
				                                    
				                                     <label class="label-box-item"> <input name="feeConfig.term" value="M11" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M11'}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    ><span>11个月</span>
				                                    </label>
				                                    
				                                   
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M12" type="checkbox"
				                                     <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M12'}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    ><span>12个月</span>
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M18" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M18'}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    ><span>18个月</span>
				                                    </label>
				                                    
				                                      <label class="label-box-item"> <input name="feeConfig.term" value=M23" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M23'}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    ><span>23个月</span>
				                                    </label>
				                                    
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M24" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M24'}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    ><span>24个月</span>
				                                    </label>	
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M35" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M35'}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    ><span>35个月</span>
				                                    </label>
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="M36" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'M36'}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    ><span>36个月</span>
				                                    </label>
				                                    
				                                      <label class="label-box-item"> <input name="feeConfig.term" value="D1,D60" type="checkbox"
				                                    <c:forEach items="${product.cydfeeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 'D1,D60'}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    ><span>按天（1-60天)</span>
				                                    </label>
				                                    
				                                </div>
				                            </div>
				                        </div>
				                        
				                        <div class="form-group col-md-12" id="lump-sum-repayment" style="display:none">
                            <div class="input-group">
                                <label class="label-head label-head-top">
                                <span class="require"> 借款期限：</span>      
                               </label>
                                <div class="checkbox label-box label-head-top" >
                                    <label class="label-box-item"> <input name="feeConfig.lumpSumTerm" value="1-60" type="checkbox">1-60天
                                    </label>
                                </div>
                            </div>
                        </div>
                        
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head label-head-top">第一期本息扣除方式：</label>
				                                <div class="checkbox label-box label-head-top" >
				                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="1" type="radio"
				                                    <c:if test="${product.cydfeeConfig.firstIssueType== 1}">
			                                                            checked="true"
			                                      </c:if>
				                                    >扣除第一期的本息
				                                    </label>
				                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="2" type="radio"
				                                    <c:if test="${product.cydfeeConfig.firstIssueType== 2}">
			                                                            checked="true"
			                                      </c:if>
				                                    >扣除第一期的本金
				                                    </label>
				                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="3" type="radio"
				                                    <c:if test="${product.cydfeeConfig.firstIssueType== 3}">
			                                                            checked="true"
			                                      </c:if>
				                                    >扣除第一期的利息
				                                    </label>
				                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="4" type="radio"
				                                    <c:if test="${product.cydfeeConfig.firstIssueType== 4}">
			                                                            checked="true"
			                                      </c:if>
				                                    >不扣第一期的本或息
				                                    </label>
				                                </div>
				                            </div>
				                        </div>
				                       
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head label-head-top">支持的自动流程：</label>
				                                <div class="checkbox label-box label-head-top" >
				                                
				                                    <label class="label-box-item"> <input name="feeConfig.autoType" value="1" type="checkbox"
				                                    <c:forEach items="${fn:split(product.cydfeeConfig.autoTypeCheck,',')}" var="auto">
				                                    <c:if test="${auto== 1}">
			                                                checked="true"
			                                     		 </c:if>
			                                       </c:forEach>
				                                    >自动提交订单
				                                    </label>
				                                   
				                                    
				                                   
				                                    <label class="label-box-item"> <input name="feeConfig.autoType" value="2" type="checkbox"
				                                    <c:forEach items="${fn:split(product.cydfeeConfig.autoTypeCheck,',')}" var="auto">
				                                    <c:if test="${auto== 2}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    >自动通过P2P审批
				                                    </label>
				                                     
				                                  
				                                    <label class="label-box-item"> <input name="feeConfig.autoType" value="3" type="checkbox"
				                                     <c:forEach items="${fn:split(product.cydfeeConfig.autoTypeCheck,',')}" var="auto">
				                                    <c:if test="${auto== 3}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    >自动通过P2P影像审核
				                                    </label>
				                                     
				                                </div>
				                            </div>
				                        </div>
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head label-head-top">产品说明：</label>
				                                <div class="checkbox label-box label-head-top" >
				                                    <label class="label-box-item"> 
				                                    	<textarea placeholder="500字" rows="5" cols="100" name="desc" id="desc"  maxlength="500">${product.desc}</textarea>
				                                    </label>
				                                </div>
				                            </div>
				                        </div>
				                        
				                    </div>
				
				                </div>
				                <div class="panel panel-default">
				                    <div class="panel-heading">
				                       	资产方产品费率配置
				                    </div>
				                    <div class="panel-body">
				                      			
				                         <div class=" col-md-12">
											 <div class="sub-head"><span  class="require">综合月利率设置</span></div>
				                            <div class=" col-md-12">
												<div class="bootstrap-table" >
													<div class="fixed-table-body">
														<table class="table  table-striped table-responsive" >
															<thead>
															<tr>
																<th width="300px">还款方式</th>
																<th>综合月利率</th>
															</tr>
															</thead>
															<tbody id="fee_month_add_table">
															<c:if test="${not empty  product.cydfeeConfig.monthlyFee}">
																<c:forEach items="${product.cydfeeConfig.monthlyFee}" var="month">
																	<tr id="fmt_month_${month.repaymentType }">
																		<td><span>${month.repaymentTypeName}</span></td>
																		<td>
																			<div class="form-inline">
																				<div class="form-group">
																					<input   type="text" value="${month.start}" class="form-control">
																				</div>
																				<span class="line-span">-</span>
																				<div class="form-group">
																					<input   type="text" value="${month.end}" class="form-control">
																				</div>
																				<span class="line-span">%</span>
																			</div>
																		</td>
																	</tr>
																</c:forEach>
															</c:if>
															</tbody>
														</table>
													</div>

												</div>
				                       		</div>
										 </div>
				                       
				                       
				                       <div class="col-md-12">
										   <div class="sub-head">综合日利率设置:
										   </div>
				                            <div class="form-group col-md-12">
				                                <div class="form-group col-md-12 ">
													<div class="bootstrap-table" >
														<div class="fixed-table-body">
															<table class="table  table-striped table-responsive" >
																<thead>
																<tr>
																	<th width="300px">还款方式</th>
																	<th>综合日利率</th>
																</tr>
																</thead>
																<tbody id="fee_day_add_table">
																<c:if test="${not empty  product.cydfeeConfig.daylyFee}">
																	<c:forEach items="${product.cydfeeConfig.daylyFee}" var="day">

																		<tr id="fmt_day_${day.repaymentType }">
																			<td><span>${day.repaymentTypeName}</span></td>
																			<td>
																				<div class="form-inline">
																					<div class="form-group">
																						<input   type="text" value="${day.start}" class="form-control">
																					</div>
																					<span class="line-span">-</span>
																					<div class="form-group">
																						<input   type="text" value="${day.end}" class="form-control">
																					</div>
																					<span class="line-span">%</span>
																				</div>
																			</td>
																		</tr>
																	</c:forEach>
																</c:if>
																<c:if test="${empty  product.cydfeeConfig.daylyFee}">
																	<c:forEach items="${product.cydfeeConfig.monthlyFee}" var="day">
																		<tr id="fmt_day_${day.repaymentType }">
																			<td><span>${day.repaymentTypeName}</span></td>
																			<td>
																				<div class="form-inline">
																					<div class="form-group">
																						<input   type="text" value="${day.start}" class="form-control">
																					</div>
																					<span class="line-span">-</span>
																					<div class="form-group">
																						<input   type="text" value="${day.end}" class="form-control">
																					</div>
																					<span class="line-span">%</span>
																				</div>
																			</td>
																		</tr>
																	</c:forEach>
																</c:if>
																</tbody>
															</table>
														</div>

													</div>
				                                    
				                                </div>
				                            </div>
				                       </div>
				                        
				                        
				                        
				                        <div class=" col-md-12">
											<div class="sub-head">
												<span  class="require">违约金率设置</span>
												<span class="btn btn-add"  id="wyl_fee_add"><span>添加</span></span>
											</div>
				                            <div class=" col-md-12">
				                                <div class="form-group col-md-12 ">
				                                    <div class="bootstrap-table">
				                                        <div class="fixed-table-body">
				                                            <table class="table  table-striped table-responsive">
				                                                <thead>
				                                                <tr>
				                                                <th>借款金额从(元)</th>
				                                                <th>借款金额到(元)</th>
				                                                <th>违约金率（%）</th>
				                                                <th width="150">操作</th>
				                                                </tr>
				                                                </thead>
				                                                <tbody id="wyl_fee_add_table">
	                                                <c:forEach items="${product.cydfeeConfig.wyFee}" var="wy">
                                                <tr><td>${wy.wylStart }</td><td>${wy.wylEnd }</td><td>${wy.wylFee }</td><td><div class="btn-a" onclick="removeRow(this)"><span>删除</span></div></td></tr>
	                                               </c:forEach>
	                                                </tbody>
				                                            </table>
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
				                       </div>     
				                       
				                       <div class=" col-md-12">
										   <div class="sub-head">
											   <span  class="require">滞纳金率设置</span>
											   <span class="btn btn-add" id="znjl_fee_add"><span>添加</span></span>
										   </div>
				                           <div class=" col-md-12">
				                                <div class="form-group input-group">
													<span class="label-head label-head-top label-head-lg text-right">配置方式：</span>
				                                    <div class="label-box label-head-top">
				                                        <label class="radio-inline"> <input name="feeConfig.znjCalType" value="1" type="radio"
				                                         <c:if test="${product.cydfeeConfig.znjCalType== 1}">
			                                                            checked="true"
			                                      </c:if>
				                                        >按借款金额配置
					                                    </label>
					                                    <label class="radio-inline"> <input name="feeConfig.znjCalType" value="2" type="radio"
					                                    <c:if test="${product.cydfeeConfig.znjCalType== 2}">
			                                                            checked="true"
			                                      </c:if>
					                                    >按借款期限配置
					                                    </label>
				                                    </div>
				                                    

				                                </div>
												<div class="bootstrap-table" id="znjCalAmountType" <c:if test="${product.cydfeeConfig.znjCalType != 1}">style="display:none;"</c:if> >
													<div class="fixed-table-body">
													<table class="table  table-striped table-responsive">
														<thead>
														<tr>
															<th>借款金额从(元)</th>
															<th>借款金额到(元)</th>
															<th>滞纳金率（%）</th>
															<th width="150">操作</th>
														</tr>
														</thead>
														<tbody id="znjl_fee_add_table">
														<c:if test="${product.cydfeeConfig.znjCalType == 1}">
															<c:forEach items="${product.cydfeeConfig.znFee}" var="zn">
																<tr>
																	<td>${zn.znlStart}</td><td>${zn.znlEnd}</td><td> ${zn.znlFee} </td>
																	<td><div class="btn-a" onclick="removeRow(this)"><span>删除</span></div></td></tr>
															</c:forEach>
														</c:if>
														</tbody>
													</table>
												</div>
												</div>
										   		<div class="bootstrap-table" id="znjCalTermType"<c:if test="${product.cydfeeConfig.znjCalType != 2}">style="display:none;"</c:if>>
										   			<div class="fixed-table-body">
											   <table class="table  table-striped table-responsive">
												   <thead>
												   	<tr>
													   <th>借款期限</th>
													   <th>滞纳金率（%）</th>
												   </tr>
												   </thead>
												   <tbody id="znjl_fee_add_term_table">
												   <c:if test="${product.cydfeeConfig.znjCalType != 2}">
													   <c:forEach items="${product.cydfeeConfig.terms}" var="m">

														   <tr id="zft_${m.term}">
															   <td>${m.termName}</td><td><input class="form-control" style="width: 100px" type="text" ></td></tr>
													   </c:forEach>
												   </c:if>


												   <c:if test="${product.cydfeeConfig.znjCalType == 2}">
													   <c:forEach items="${product.cydfeeConfig.znFee}" var="zn2">

														   <tr id="zft_${zn2.termVal}">
															   <td>${zn2.termText}</td><td><input class="form-control" style="width: 100px" type="text" value="${zn2.znlRate}"></td></tr>
													   </c:forEach>
												   </c:if>

												   </tbody>
											   </table>

										   </div>
									       		</div>
									       </div>
				                       </div>

				                       <div class=" col-md-12">
										   <div class="sub-head">
											   <span  class="require"> 咨询费设置</span>
				                            </div>
				                            <div class=" col-md-12">
				                                <div class="form-group input-group ">
													<span class="label-head label-head-top label-head-lg text-right">是否需要咨询费：</span>
				                                    <div class="label-box label-head-top">

				                                        <label class="radio-inline"> <input name="feeConfig.zxfType" value="1" type="radio"
				                                         <c:if test="${product.cydfeeConfig.zxfType== 1}">
			                                                            checked="true"
			                                      		</c:if>
			                                      		>是
					                                    </label>
					                                    <label class="radio-inline"> <input name="feeConfig.zxfType" value="2" type="radio"
					                                    <c:if test="${product.cydfeeConfig.zxfType== 2}">
			                                                            checked="true"
			                                      		</c:if>
					                                    >否
					                                    </label>
				                                    </div>
				                                </div>
												<div id="zxfee" <c:if test="${product.cydfeeConfig.zxfType == 2}">style="display:none;"</c:if>>
													<div class="form-group input-group">
														<div class="label-head label-head-top label-head-lg text-right">咨询费：</div>
														<div class="label-box" >
														<div class="form-inline">
															<div class="form-group">
																<input name="feeConfig.zxfee"  type="text" value="${product.cydfeeConfig.zxfee.start}" class="form-control">
															</div>
															<span class="line-span">-</span>
															<div class="form-group">
																<input name="feeConfig.zxfee"  type="text" value="${product.cydfeeConfig.zxfee.end}" class="form-control">
															</div>
															<span class="line-span">%</span>
														</div>
													</div>
													</div>
												</div>

				                            </div>
				                       </div>
                       
				                       
				                       <div class="form-group col-md-12">
										   <div class="sub-head">保证金率设置
											   <span class="btn btn-add" id="bzjl_fee_add"
											   <c:if test="${product.cydfeeConfig.bzjType== 2}">
												   style="display:none"
											   </c:if>
											   ><span>添加</span></span>
										   </div>
				                            <div class="col-md-12">
				                                <div class="form-group input-group ">
													<span class="label-head label-head-top label-head-lg text-right">是否有保证金：</span>
				                                    <div class="label-box label-head-top">
				                                        <label class="radio-inline"> <input name="feeConfig.bzjType" value="1" type="radio"
				                                        <c:if test="${product.cydfeeConfig.bzjType== 1}">
			                                                            checked="true"
			                                      		</c:if>
				                                        >是
					                                    </label>
					                                    <label class="radio-inline"> <input name="feeConfig.bzjType" value="2" type="radio"
					                                     <c:if test="${product.cydfeeConfig.bzjType== 2}">
			                                                            checked="true"
			                                      		</c:if>
					                                    >否
					                                    </label>
				                                    </div>
				                                    

				                                </div>
												<div class="bootstrap-table" id="bzjCalType"
												<c:if test="${product.cydfeeConfig.bzjType == 2}">
													style="display:none;"
												</c:if>
												>
												<div class="fixed-table-body">
													<table class="table  table-striped table-responsive">
														<thead>
														<tr>
															<th>借款金额从(元)</th>
															<th>借款金额到(元)</th>
															<th>保证金率（%）</th>
															<th width="150">操作</th>
														</tr>
														</thead>
														<tbody id="bzjl_fee_add_table">
														<c:forEach items="${product.cydfeeConfig.bzjFee}" var="bzj">
															<tr><td>${bzj.bzjStart}</td><td>${bzj.bzjEnd}</td><td>${bzj.bzjFee}</td><td><div class="btn-a" onclick="removeRow(this)"><span>删除</span></div></td></tr>
														</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
				                            </div>
				                       </div>
				                       
				                       <div class=" col-md-12">
										   <div class="sub-head">其他费用设置
											   <span class="btn btn-add" id="other_fee_add"
											   <c:if test="${product.cydfeeConfig.otherType== 2}">
												   style="display:none"
											   </c:if>
											   ><span>添加</span></span>
										   </div>
				                            <div class=" col-md-12">
				                                <div class="form-group input-group ">
													<span class="label-head label-head-top label-head-lg text-right">是否有其他费用:</span>
				                                    <div class="label-box label-head-top">

				                                        <label class="radio-inline"> <input name="feeConfig.otherType" value="1" type="radio"
				                                         
				                                         <c:if test="${product.cydfeeConfig.otherType == 1}">
			                                                            checked="true"
			                                      </c:if>
				                                         
				                                         >是
					                                    </label>
					                                    <label class="radio-inline"> <input name="feeConfig.otherType" value="2" type="radio"
					                                    <c:if test="${product.cydfeeConfig.otherType == 2}">
			                                                            checked="true"
			                                      </c:if>
					                                    >否
					                                    </label>
				                                    </div>
				                                </div>
												<div class="bootstrap-table" id="otherCalType"
												<c:if test="${product.cydfeeConfig.otherType == 2}">
													style="display:none;"
												</c:if>
												>
												<div class="fixed-table-body">
													<table class="table  table-striped table-responsive">
														<thead>
														<tr>
															<th>借款金额从(元)</th>
															<th>借款金额到(元)</th>
															<th>其他费用(元)</th>
															<th width="150">操作</th>
														</tr>
														</thead>
														<tbody id="other_fee_add_table">
														<c:forEach items="${product.cydfeeConfig.otherFee}" var="other">
															<tr><td>${other.otherStart}</td><td>${other.otherEnd}</td><td>${other.otherFee}</td><td><div class="btn-a" onclick="removeRow(this)"><span>删除</span></div></td></tr>
														</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
				                            </div>
				                       </div>
				                        
				                       
				                       
				                       <div class=" col-md-12">
										   <div class="sub-head">GPS费用设置
										   </div>
				                            <div class=" col-md-12">
				                                <div class="form-group input-group ">
													<div class="label-head label-head-top label-head-lg text-right">是否需要安装GPS：</div>
													<div class="label-box label-head-top">

				                                        <label class="radio-inline"> <input name="feeConfig.gpsType" value="1" type="radio"
				                                       
				                                        <c:if test="${product.cydfeeConfig.gpsType == 1}">
			                                                             checked="true"
			                                     		 </c:if>
				                                        >是
					                                    </label>
					                                    <label class="radio-inline"> <input name="feeConfig.gpsType" value="2" type="radio"
					                                      <c:if test="${product.cydfeeConfig.gpsType == 2}">
			                                                             checked="true"
			                                     		 </c:if>
					                                    >否
					                                    </label>
				                                    </div>
				                                </div>
												<div id="gpsCalType"
												<c:if test="${product.cydfeeConfig.gpsType == 2}">
													style="display:none;"
												</c:if>

												>
												<div class="form-group input-group">
													<div class="label-head label-head-top label-head-lg text-right">GPS安装费：</div>
													<div class="label-box">
														<div class="form-inline">
															<span class="form-group">初次安装</span>
															<div class="form-group">
																<input name="feeConfig.gpsFirstFee"  type="text" value="${product.cydfeeConfig.gpsFirstFee.start}" class="form-control">
															</div>
															<span class="line-span">-</span>
															<div class="form-group">
																<input name="feeConfig.gpsFirstFee"  type="text" value="${product.cydfeeConfig.gpsFirstFee.end }" class="form-control">
															</div>
															<span class="line-span">元</span>
														</div>
													</div>
												</div>
												<div class="form-group input-group">
													<div class="label-head label-head-top label-head-lg text-right">GPS服务费：</div>
													<div class="label-box">
														<div class="form-inline">
															<span class="form-group">按月支付</span>
															<div class="form-group">
																<input name="feeConfig.gpsServiceFee"  type="text" value="${product.cydfeeConfig.gpsServiceFee.start}" class="form-control">
															</div>
															<span class="line-span">-</span>
															<div class="form-group">
																<input name="feeConfig.gpsServiceFee"  type="text" value="${product.cydfeeConfig.gpsServiceFee.end }" class="form-control">
															</div>
															<span class="line-span">元</span>
														</div>
													</div>
												</div>
											</div>
				                            </div>
				                       </div>
				                       
				                       
				                       <div class=" col-md-12">
										   <div class="sub-head">停车费设置
										   </div>
				                            <div class=" col-md-12">
				                                <div class="form-group input-group ">
													<div class="label-head label-head-top label-head-lg text-right">是否有停车费：</div>
													<div class="label-box label-head-top">
				                                        <label class="radio-inline"> <input name="feeConfig.parkType" value="1" type="radio"
															 <c:if test="${product.cydfeeConfig.parkType == 1}">
			                                                             checked="true"
			                                     		 </c:if>
															>是
					                                    </label>
					                                    <label class="radio-inline"> <input name="feeConfig.parkType" value="2" type="radio"
					                                    <c:if test="${product.cydfeeConfig.parkType == 2}">
			                                                             checked="true"
			                                     		 </c:if>
					                                    >否
					                                    </label>
				                                    </div>

				                                </div>
												<div id="parkType">
													<div class="form-group input-group"  <c:if test="${product.cydfeeConfig.parkType == 2}">
													style="display:none;"
												</c:if>>
													<div class="label-head label-head-top label-head-lg text-right">停车费：</div>
													<div class="label-box">
														<div class="form-inline">
															<span class="form-group">按月支付</span>
															<div class="form-group">
																<input name="feeConfig.parkFee"  type="text" value="${product.cydfeeConfig.parkFee.start}"  class="form-control">
															</div>
															<span class="line-span">-</span>
															<div class="form-group">
																<input name="feeConfig.parkFee"  type="text" value="${product.cydfeeConfig.parkFee.end}"  class="form-control">
															</div>
															<span class="line-span">元</span>
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
				                <button type="button" class="btn btn-primary btn-primary-lg"
				                        id="savFeeConfigBtn" data-loading-text="保存...">保存
				                </button>
				            <button type="button" class="btn btn-cancel  btn-primary-lg"
				                    id="cancelBtn">取消
				            </button>
				        </div>
				        <!-- /.row -->
				    </section>
				    </div>
				</c:forEach>
            </div>
            <!-- /.tab-content -->
        </div>
        <!-- /.nav-tabs-custom -->
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
    
    var names = '${nameList}';
    if (names != 'null' && names != '') {
    	names = eval('(' + names + ')');
    } else {
    	names = null;
    }
</script>

<script type="text/javascript" src="${ctx}/static/pagejs/system/partnerCorp/editProduct.js?${timeStyle}"></script>

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
                                        class="require">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="wylStart" name="wylStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="wylEnd" name="wylEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>违约金率：</label>
                                <div class="col-sm-8">
                                    <input type="text"  class="form-control"
                                           id="wylFee" name="wylFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-primary-lg" id="addWylFeeBtn"
                        data-loading-text="确定中...">确定
                </button>
                <button type="button" class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</button>
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
                                        class="require">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="bzjlStart" name="bzjlStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="bzjlEnd" name="bzjlEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>保证金率：</label>
                                <div class="col-sm-8">
                                    <input type="text"  class="form-control"
                                           id="bzjlFee" name="bzjlFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-primary-lg" id="addBzjlFeeBtn"
                        data-loading-text="确定中...">确定
                </button>
                <button type="button" class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</button>
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
                                        class="require">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="znjlStart" name="znjlStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="znjlEnd" name="znjlEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>滞纳金率：</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control"
                                           id="znjlFee" name="znjlFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-primary-lg" id="addZnjlFeeBtn"
                        data-loading-text="确定中...">确定
                </button>
                <button type="button" class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="otherFeeModal" tabindex="-1" role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加其他费用配置</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form id="otherFeeForm" class="form-horizontal">
                        <div class="box-body">
                        	<div class="form-group">
                            	<label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="otherStart" name="otherStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="otherEnd" name="otherEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        class="require">*</span>其他费用(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text"  class="form-control"
                                           id="otherFee" name="otherFee">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-primary-lg" id="addOtherFeeBtn"
                        data-loading-text="确定中...">确定
                </button>
                <button type="button" class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>