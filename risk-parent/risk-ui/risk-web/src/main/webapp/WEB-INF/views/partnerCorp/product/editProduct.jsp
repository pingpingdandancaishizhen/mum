<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/import/import.jsp"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <title>乐位云风控</title>
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
				              
				            <div>
				            
				            	<div class="panel panel-default">
				                    <div class="panel-heading">
				                       	新增发标产品
				                    </div>
				                    <div class="panel-body">
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
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
				                                <label class="label-head">
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
				                                <div class="checkbox label-box" id="eachtimes">
				                                    <label class="label-box-item"> 
				                                    	<input type="text" name="productCode" id="productCode" class="form-control" value="${product.productCode}"/>
				                                    </label>
				                                </div>
				                            </div>
				                        </div>
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head">
				                         <span class="require">借款期限：</span>         
				                                借款人还款方式：</label>
				                                <div class="checkbox label-box" id="eachtimes">
				                                
				                                 <label class="label-box-item"> <input class="repaymentType" name="feeConfig.repaymentType" value="1" type="checkbox"
				                                 <c:forEach items="${product.feeConfig.repaymentTypes}" var="repay">
				                                 <c:if test="${repay.repaymentType== 1}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach> 
				                                 >等额等息
				                                    </label>
				                                   
				                                    
				                                     
				                                    <label class="label-box-item"> <input class="repaymentType" name="feeConfig.repaymentType" value="2" type="checkbox"
				                                    <c:forEach items="${product.feeConfig.repaymentTypes}" var="repay">
				                                     <c:if test="${repay.repaymentType== 2}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach> 
				                                    >先息后本
				                                    </label>
				                                    
				                                     
				                                    <label class="label-box-item"> <input class="repaymentType" id="lumpSumRepayment" name="feeConfig.repaymentType" value="3" type="checkbox"
				                                    <c:forEach items="${product.feeConfig.repaymentTypes}" var="repay">
				                                     <c:if test="${repay.repaymentType== 3}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach> 
				                                    >一次性还款
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input class="repaymentType" name="feeConfig.repaymentType" value="4" type="checkbox"
				                                     <c:forEach items="${product.feeConfig.repaymentTypes}" var="repay">
				                                     <c:if test="${repay.repaymentType== 4}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach> 
				                                    >等额本金
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input class="repaymentType" name="feeConfig.repaymentType" value="5" type="checkbox"
				                                     <c:forEach items="${product.feeConfig.repaymentTypes}" var="repay">
				                                     <c:if test="${repay.repaymentType== 5}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach> 
				                                    >等额本息
				                                    </label>
				                                    
				                               
				                                
				                                   
				                                </div>
				                            </div>
				                        </div>
				                        <div class="form-group col-md-12" id="nomal-repayment">
				                            <div class="input-group">
				                                <label class="label-head">
				          <span class="require">借款期限：</span>                            
				                               </label>
				                                <div class="checkbox label-box" id="eachtimes">
				                                
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="1" type="checkbox"
				                                    <c:forEach items="${product.feeConfig.terms}" var="te">
				                                    <c:if test="${te.term== 1}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    >1个月
				                                    </label>	                                    
				                                 
				                                 
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="2" type="checkbox"
				                                    <c:forEach items="${product.feeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 2}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    >2个月
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="3" type="checkbox"
				                                    <c:forEach items="${product.feeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 3}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    >3个月
				                                    </label>
				                                    
				                                  
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="4" type="checkbox"
				                                      <c:forEach items="${product.feeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 4}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    >4个月
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="5" type="checkbox"
				                                    <c:forEach items="${product.feeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 5}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    >5个月
				                                    </label>
				                                    
				                                   
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="6" type="checkbox"
				                                     <c:forEach items="${product.feeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 6}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    >6个月
				                                    </label>
				                                    
				                                   
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="12" type="checkbox"
				                                     <c:forEach items="${product.feeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 12}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    >12个月
				                                    </label>
				                                     
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="18" type="checkbox"
				                                    <c:forEach items="${product.feeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 18}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    >18个月
				                                    </label>
				                                    
				                                    
				                                    <label class="label-box-item"> <input name="feeConfig.term" value="24" type="checkbox"
				                                    <c:forEach items="${product.feeConfig.terms}" var="te">
				                                     <c:if test="${te.term== 24}">
			                                                            checked="true"
			                                      </c:if>
			                                       </c:forEach>
				                                    >24个月
				                                    </label>
				                                    
				                                </div>
				                            </div>
				                        </div>
				                        
				                        <div class="form-group col-md-12" id="lump-sum-repayment" style="display:none">
                            <div class="input-group">
                                <label class="label-head">
                                <span class="require"> 借款期限：</span>      
                               </label>
                                <div class="checkbox label-box" id="eachtimes">
                                    <label class="label-box-item"> <input name="feeConfig.lumpSumTerm" value="1-60" type="checkbox">1-60天
                                    </label>
                                </div>
                            </div>
                        </div>
                        
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head">第一期本息扣除方式：</label>
				                                <div class="checkbox label-box" id="eachtimes">
				                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="1" type="radio"
				                                    <c:if test="${product.feeConfig.firstIssueType== 1}">
			                                                            checked="true"
			                                      </c:if>
				                                    >扣除第一期的本息
				                                    </label>
				                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="2" type="radio"
				                                    <c:if test="${product.feeConfig.firstIssueType== 2}">
			                                                            checked="true"
			                                      </c:if>
				                                    >扣除第一期的本金
				                                    </label>
				                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="3" type="radio"
				                                    <c:if test="${product.feeConfig.firstIssueType== 3}">
			                                                            checked="true"
			                                      </c:if>
				                                    >扣除第一期的利息
				                                    </label>
				                                    <label class="label-box-item"> <input name="feeConfig.firstIssueType" value="4" type="radio"
				                                    <c:if test="${product.feeConfig.firstIssueType== 4}">
			                                                            checked="true"
			                                      </c:if>
				                                    >不扣第一期的本或息
				                                    </label>
				                                </div>
				                            </div>
				                        </div>
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head">借款人实收金额：</label>
				                                <div class="checkbox label-box" id="eachtimes">
				                                    <label class="label-box-item"> <input name="feeConfig.loanType" value="1" type="radio"
				                                    <c:if test="${product.feeConfig.loanType== 1}">
			                                                            checked="true"
			                                      </c:if>
				                                    >借款人实收金额=借款金额-（第一期的利息+第一期的管理费）-其他费用
				                                    </label>
				                                </div>
				                                <div class="checkbox label-box" id="eachtimes">
				                                    <label class="label-box-item"> <input name="feeConfig.loanType" value="2" type="radio"
				                                    <c:if test="${product.feeConfig.loanType== 2}">
			                                                            checked="true"
			                                      </c:if>
				                                    >借款人实收金额=借款金额-（第一期的利息+第一期的管理费）-第一期的本金-GPS费用
				                                    </label>
				                                </div>
				                            </div>
				                        </div>
				                        <div class="form-group col-md-12">
				                            <div class="input-group">
				                                <label class="label-head">支持的自动流程：</label>
				                                <div class="checkbox label-box" id="eachtimes">
				                                
				                                    <label class="label-box-item"> <input name="feeConfig.autoType" value="1" type="checkbox"
				                                    <c:forEach items="${fn:split(product.feeConfig.autoTypeCheck,',')}" var="auto">
				                                    <c:if test="${auto== 1}">
			                                                checked="true"
			                                     		 </c:if>
			                                       </c:forEach>
				                                    >自动提交订单
				                                    </label>
				                                   
				                                    
				                                   
				                                    <label class="label-box-item"> <input name="feeConfig.autoType" value="2" type="checkbox"
				                                    <c:forEach items="${fn:split(product.feeConfig.autoTypeCheck,',')}" var="auto">
				                                    <c:if test="${auto== 2}">
			                                                            checked="true"
			                                      </c:if>
			                                      </c:forEach>
				                                    >自动通过P2P审批
				                                    </label>
				                                     
				                                  
				                                    <label class="label-box-item"> <input name="feeConfig.autoType" value="3" type="checkbox"
				                                     <c:forEach items="${fn:split(product.feeConfig.autoTypeCheck,',')}" var="auto">
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
				                                <label class="label-head">产品说明：</label>
				                                <div class="checkbox label-box" id="eachtimes">
				                                    <label class="label-box-item"> 
				                                    	<textarea rows="5" cols="100" name="desc" id="desc">${product.desc}</textarea>
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
				                        <div class="form-group col-md-12">
				                            <div class="form-group col-md-12">
				                                <div class="sub-head">综合月利率设置</div>
				                            </div>
				                            <div class="form-group col-md-12">
				                                <div class="form-group col-md-12">
				                                    <div class="input-group">
				                                        	<span class="table-head-title">综合月利率=月利率+月管理费率</span>
				                                    </div>
				                                </div>
				                            </div>
				                        </div>
				
				                        <div class="form-group col-md-12">
				                            <div class="form-group col-md-12">
				                                <div class="sub-head">月利率/月管理费率设置</div>
				                            </div>
				                            <div class="form-group col-md-12">
				                                <div class="form-group col-md-12 ">
				                                    <div class="bootstrap-table">
				                                        <div class="fixed-table-body">
				                                            <table class="table  table-striped table-responsive ">
				                                                <thead>
				                                                <tr>
				                                                    <th>借款期限</th>
				                                                    <th>月利率（%）</th>
				                                                    <th>月管理费率（%）</th>
				                                                </tr>
				                                                </thead>
																<tbody id="fee_month_add_table">
				 										<c:forEach items="${product.feeConfig.monthlyFee}" var="month">
				 										<c:if test="${fn:substring(month.termText, 0, 4)=='1-60'}">
				 										<tr id="fmt_1-60">
				 										</c:if>
				 										<c:if test="${fn:substring(month.termText, 0, 4)!='1-60'}">
				 										 <tr id="fmt_${fn:substring(month.termText, 0, 1)}">
				 										</c:if>
			                                                <td>${month.termText}</td>
			                                                <td><input class="form-control" style="width: 100px" type="text" value="${month.monthlyRate }"></td>
			                                                <td><input class="form-control" style="width: 100px" type="text" value="${month.monthlyGLRate }"></td></tr>
			                                                </c:forEach>
			                                                
			                                               
				                                                </tbody>
				                                            </table>
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
				                        </div>
				                        <div class="form-group col-md-12">
				                            <div class="form-group col-md-12">
				                                <div class="sub-head">日利率/日管理费率设置</div>
				                            </div>
				                            <div class="form-group col-md-12">
				                                <div class="form-group col-md-12 ">
				                                    <div class="bootstrap-table">
				                                        <div class="fixed-table-body">
				                                            <table class="table  table-striped table-responsive ">
				                                                <thead>
				                                                <tr>
				                                                    <th>借款期限</th>
				                                                    <th>日利率（%）</th>
				                                                    <th>日管理费率（%）</th>
				                                                </tr>
				                                                </thead>
				                                                <tbody id="fee_day_add_table">
				                                                <c:if test="${not empty  product.feeConfig.daylyFee}">
									                                                <c:forEach items="${product.feeConfig.daylyFee}" var="day">
									                                                <c:if test="${fn:substring(day.termText, 0, 4)=='1-60'}">
											 										<tr id="fdt_1-60">
											 										</c:if>
											 										<c:if test="${fn:substring(day.termText, 0, 4)!='1-60'}">
					                                                <tr id="fdt_${fn:substring(day.termText, 0, 1)}">
					                                                </c:if>
					                                                
					                                                <td>${day.termText}</td>
					                                                <td><input class="form-control" style="width: 100px" type="text" value="${day.daylyRate }"></td>
					                                                <td><input class="form-control" style="width: 100px" type="text" value="${day.daylyGLRate }"></td></tr>
						                                               
					                                                </c:forEach>
				                                                </c:if>
				                                                <c:if test="${empty product.feeConfig.daylyFee}">
				                                                <c:forEach items="${product.feeConfig.monthlyFee}" var="month">
				                                                <c:if test="${fn:substring(month.termText, 0, 4)=='1-60'}">
				 										<tr id="fdt_1-60">
				 										</c:if>
				 										<c:if test="${fn:substring(month.termText, 0, 4)!='1-60'}">
				                                                 <tr id="fdt_${fn:substring(month.termText, 0, 1)}">
				                                                 </c:if>
				                                                 
				                                                 <td>${month.termText}</td>
			                                                <td><input class="form-control" style="width: 100px" type="text" ></td>
			                                                <td><input class="form-control" style="width: 100px" type="text" ></td></tr>
				                                                </c:forEach>
				                                                </c:if> 
				                                                
										   
	                                                </tbody>
				                                            </table>
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
				                        </div>
				                        
				                        <div class="form-group col-md-12">
				                            <div class="form-group col-md-12">
				                                <div class="sub-head">违约金率设置:
				                                	<span class="btn btn-add"  id="wyl_fee_add"><span>添加</span></span>
				                                </div>
				                            </div>
				                            <div class="form-group col-md-12">
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
	                                                <c:forEach items="${product.feeConfig.wyFee}" var="wy">
                                                <tr><td>${wy.wylStart }</td><td>${wy.wylEnd }</td><td>${wy.wylFee }</td><td><div class="btn-a" onclick="removeRow(this)"><span>删除</span></div></td></tr>
	                                               </c:forEach>
	                                                </tbody>
				                                            </table>
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
				                       </div>     
				                       
				                       <div class="form-group col-md-12">
				                            <div class="form-group col-md-12">
				                                <div class="sub-head">滞纳金率设置:
				                                	<span class="btn btn-add" id="znjl_fee_add"><span>添加</span></span>
				                                </div>
				                            </div>
				                            <div class="form-group col-md-12">
				                                <div class="form-group col-md-12 ">
				                                    <div class="table-head">
				                                        <span class="table-head-title">配置方式:</span>
				                                        <label class="label-box-item"> <input name="feeConfig.znjCalType" value="1" type="radio" 
				                                         <c:if test="${product.feeConfig.znjCalType== 1}">
			                                                            checked="true"
			                                      </c:if>
				                                        >按借款金额配置
					                                    </label>
					                                    <label class="label-box-item"> <input name="feeConfig.znjCalType" value="2" type="radio"
					                                    <c:if test="${product.feeConfig.znjCalType== 2}">
			                                                            checked="true"
			                                      </c:if>
					                                    >按借款期限配置
					                                    </label>
				                                    </div>
				                                    
				                                    <div class="bootstrap-table" id="znjCalAmountType"
				                                    <c:if test="${product.feeConfig.znjCalType != 1}">
			                                                            style="display:none;"
			                                      </c:if>
				                                    >
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
				                                                <c:if test="${product.feeConfig.znjCalType == 1}">
				                                                <c:forEach items="${product.feeConfig.znFee}" var="zn">
				                                                <tr>
				                                                <td>${zn.znlStart}</td><td>${zn.znlEnd}</td><td> ${zn.znlFee} </td>
				                                                <td><div class="btn-a" onclick="removeRow(this)"><span>删除</span></div></td></tr>
				                                                </c:forEach>
				                                                </c:if>
				                                                </tbody>
				                                            </table>
				                                        </div>
				                                    </div>
				                                    <div class="bootstrap-table" id="znjCalTermType" 
				                                    <c:if test="${product.feeConfig.znjCalType != 2}">
			                                                            style="display:none;"
				                                      </c:if>
					                                    >
				                                        <div class="fixed-table-body">
				                                            <table class="table  table-striped table-responsive">
				                                                <thead>
				                                                <tr>
				                                                <th>借款期限</th>
				                                                <th>滞纳金率（%）</th>
				                                                </thead>
				                                                <tbody id="znjl_fee_add_term_table">
				                                                <c:if test="${product.feeConfig.znjCalType != 2}">
			                                                           <c:forEach items="${product.feeConfig.monthlyFee}" var="m">
			                                        <c:if test="${fn:substring(m.termText, 0, 4)=='1-60'}">
				 										<tr id="zft_1-60">
				 										</c:if>
				 										<c:if test="${fn:substring(m.termText, 0, 4)!='1-60'}">                   
	                                                <tr id="zft_${fn:substring(m.termText, 0, 1)}">
	                                                </c:if>
	                                                <td>${m.termText}</td><td><input class="form-control" style="width: 100px" type="text" ></td></tr>
					                                                </c:forEach>
				                                      			</c:if>
				                                      			 <c:if test="${product.feeConfig.znjCalType == 2}">
			                                                            <c:forEach items="${product.feeConfig.znFee}" var="zn2">
			                                                            <c:if test="${fn:substring(zn2.termText, 0, 4)=='1-60'}">
				 										<tr id="zft_1-60">
				 										</c:if>
				 										<c:if test="${fn:substring(zn2.termText, 0, 4)!='1-60'}">
                                                <tr id="zft_${fn:substring(zn2.termText, 0, 1)}">
                                                </c:if>
                                                <td>${zn2.termText}</td><td><input class="form-control" style="width: 100px" type="text" value="${zn2.znlRate}"></td></tr>
				                                                </c:forEach>
				                                      			</c:if>
				                                                
				                                                </tbody>
				                                            </table>
				                                            
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
				                       </div>
				                       
				                       
				                       <div class="form-group col-md-12">
				                            <div class="form-group col-md-12">
				                                <div class="sub-head">保证金率设置:
				                                	<span class="btn btn-add" id="bzjl_fee_add"><span>添加</span></span>
				                                </div>
				                            </div>
				                            <div class="form-group col-md-12">
				                                <div class="form-group col-md-12 ">
				                                    <div class="table-head">
				                                        <span class="table-head-title">是否有保证金:</span>
				                                        
				                                        <label class="label-box-item"> <input name="feeConfig.bzjType" value="1" type="radio" 
				                                        <c:if test="${product.feeConfig.bzjType== 1}">
			                                                            checked="true"
			                                      		</c:if>
				                                        >是
					                                    </label>
					                                    <label class="label-box-item"> <input name="feeConfig.bzjType" value="2" type="radio"
					                                     <c:if test="${product.feeConfig.bzjType== 2}">
			                                                            checked="true"
			                                      		</c:if>
					                                    >否
					                                    </label>
				                                    </div>
				                                    
				                                    <div class="bootstrap-table" id="bzjCalType"
				                                    <c:if test="${product.feeConfig.bzjType == 2}">
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
				                                                <c:forEach items="${product.feeConfig.bzjFee}" var="bzj">
				                                                <tr><td>${bzj.bzjStart}</td><td>${bzj.bzjEnd}</td><td>${bzj.bzjFee}</td><td><div class="btn-a" onclick="removeRow(this)"><span>删除</span></div></td></tr>
				                                                </c:forEach>
				                                                </tbody>
				                                            </table>
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
				                       </div>
				                       
				                       <div class="form-group col-md-12">
				                            <div class="form-group col-md-12">
				                                <div class="sub-head">其他费用设置:
				                                	<span class="btn btn-add" id="other_fee_add"><span>添加</span></span>
				                                </div>
				                            </div>
				                            <div class="form-group col-md-12">
				                                <div class="form-group col-md-12 ">
				                                    <div class="table-head">
				                                        <span class="table-head-title">是否有其他费用:</span>
				                                        <label class="label-box-item"> <input name="feeConfig.otherType" value="1" type="radio"
				                                         
				                                         <c:if test="${product.feeConfig.otherType == 1}">
			                                                            checked="true"
			                                      </c:if>
				                                         
				                                         >是
					                                    </label>
					                                    <label class="label-box-item"> <input name="feeConfig.otherType" value="2" type="radio"
					                                    <c:if test="${product.feeConfig.otherType == 2}">
			                                                            checked="true"
			                                      </c:if>
					                                    >否
					                                    </label>
				                                    </div>
				                                    
				                                    <div class="bootstrap-table" id="otherCalType"
				                                    <c:if test="${product.feeConfig.otherType == 2}">
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
				                                                <c:forEach items="${product.feeConfig.otherFee}" var="other">
                                                			<tr><td>${other.otherStart}</td><td>${other.otherEnd}</td><td>${other.otherFee}</td><td><div class="btn-a" onclick="removeRow(this)"><span>删除</span></div></td></tr>
				                                                </c:forEach>
				                                                </tbody>
				                                            </table>
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
				                       </div>
				                        
				                       
				                       
				                       <div class="form-group col-md-12">
				                            <div class="form-group col-md-12">
				                                <div class="sub-head">GPS费用设置:
				                                </div>
				                            </div>
				                            <div class="form-group col-md-12">
				                                <div class="form-group col-md-12 ">
				                                    <div class="table-head">
				                                        <span class="table-head-title">是否需要安装GPS:</span>
				                                        <label class="label-box-item"> <input name="feeConfig.gpsType" value="1" type="radio" 
				                                       
				                                        <c:if test="${product.feeConfig.gpsType == 1}">
			                                                             checked="true"
			                                     		 </c:if>
				                                        >是
					                                    </label>
					                                    <label class="label-box-item"> <input name="feeConfig.gpsType" value="2" type="radio"
					                                      <c:if test="${product.feeConfig.gpsType == 2}">
			                                                             checked="true"
			                                     		 </c:if>
					                                    >否
					                                    </label>
				                                    </div>
				                                    
				                                    <div class="bootstrap-table" id="gpsCalType"
				                                    <c:if test="${product.feeConfig.gpsType == 2}">
			                                                             style="display:none;"
			                                     		 </c:if>
				                                    >
				                                        <span class="table-head-title">GPS安装费：</span>
				                                        <label class="label-box-item"> 初次安装 :<input name="feeConfig.gpsFirstFee"  type="text" value="${product.feeConfig.gpsFirstFee}">元
					                                    </label>
					                                    <label class="label-box-item"> 已安装 :<input name="feeConfig.gpsFee"  type="text" value="${product.feeConfig.gpsFee}">元
					                                    </label>
					                                    <br/>
				                                        <span class="table-head-title">GPS服务费：</span>
				                                        <label class="label-box-item"> 按月支付 :<input name="feeConfig.gpsServiceFee" type="text" value="${product.feeConfig.gpsServiceFee}">元
					                                    </label>
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

<script type="text/javascript" src="${ctx}/static/pagejs/system/partnerCorp/editProduct.js?t=1"></script>

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
                                        style="color: #FF0000;">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="wylStart" name="wylStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="wylEnd" name="wylEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>违约金率：</label>
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
                                        style="color: #FF0000;">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="bzjlStart" name="bzjlStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="bzjlEnd" name="bzjlEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>保证金率：</label>
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
                                        style="color: #FF0000;">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="znjlStart" name="znjlStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="znjlEnd" name="znjlEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>滞纳金率：</label>
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
                                        style="color: #FF0000;">*</span>借款金额从(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="otherStart" name="otherStart">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>借款金额到(元)：</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="12" class="form-control"
                                           id="otherEnd" name="otherEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fee" class="col-sm-2 control-label"><span
                                        style="color: #FF0000;">*</span>其他费用(元)：</label>
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