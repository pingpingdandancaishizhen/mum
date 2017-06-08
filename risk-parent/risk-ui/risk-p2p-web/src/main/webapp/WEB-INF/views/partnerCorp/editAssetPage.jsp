<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>风控SAAS</title>
    <%@ include file="/WEB-INF/import/head.jsp"%>
    <link rel="stylesheet" href="${ctx}/static/assets/plugins/jQuery-city/css/animate.min.css">
    <link rel="stylesheet" href="${ctx}/static/assets/plugins/position/base.css"/>
    <link rel="stylesheet" href="${ctx}/static/assets/plugins/position/big-window.css"/>
    <script src="${ctx}/static/assets/plugins/position/position.data.min.js"
            type="text/javascript"></script>
    <script src="${ctx}/static/assets/plugins/position/jquery.position.select.js"
            type="text/javascript"></script>

    <link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/main.css"/>
    <link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/css/city-picker.css"/>
    <script src="${ctx}/static/assets/plugins/city-picker/city-picker.js"></script>

    <link rel="stylesheet" href="${ctx}/static/assets/plugins/webuploader/webuploader.css"/>
    <script src="${ctx}/static/assets/plugins/webuploader/webuploader.js"></script>
     <script src="${ctx}/static/assets/plugins/bootstrap-suggest/bootstrap-suggest.min.js"></script>
</head>
<body class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content no-padding" id="addAssetForm">
            <form  onsubmit="return false;" class="form-label-auto"
                  action="${ctx}/asset/updateAsset" method="post">
                        <div class="col-md-12 pages-form">
                        
                        <input type="hidden" name="acceptAccountBank" value="${asset.acceptAccountBank}"/>
					    <input type="hidden" name="repaymentBank" value="${repaymentBank.bankCode}"/>
					    <input type="hidden" name="acceptAccountBankVal" value="${acceptAccountBank.bankName}"/>
					    <input type="hidden" name="repaymentBankVal" value="${repaymentBank.bankName}"/>
					    
		                        <div class="sub-head">
							   资产方基本信息
						</div>
                            <div class="panel panel-default">
                                
                                <div class="panel-body">
                                    <div>
                                    <input type="hidden" name="id" value="${asset.id}" />
                                    </div>
                                    
                                                                
                                    
                                    <div class="col-sm-6 row-right ">
                            <div class="form-group input-group" >
                                <label for="assetType" class="label-head label-head-lg  text-right"> <span >资产方归属：</span></label>
                                <div class="label-box label-box-sm form-group">
                                    <select class="form-control" name="assetType" id="assetType">
                                        <option value="">请选择</option>
                                        <c:forEach items="${assetType}" var="type">
                                                        <option value="${type.typeId}"
                                                        <c:if test="${asset.assetType== type.typeId}">
                                                            selected="selected"
                                                        </c:if>
                                                        > ${type.typeName}</option>
                                                    </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                                     <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="corpName" class="label-head label-head-lg  text-right"><span class="require">企业名称：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="40" class="form-control" id="corpName" name="corpName" value="${asset.corpName}">
                                </div>

                            </div>
                        </div>
                                <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="corpName" class="label-head label-head-lg  text-right"><span class="require">企业简称：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="40" class="form-control" id="corpAbbreviation" name="corpAbbreviation" value="${asset.corpAbbreviation}">
                                </div>

                            </div>
                        </div>
                                      <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="corpName" class="label-head label-head-lg  text-right"><span >机构代码：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="institutionCode" name="institutionCode" value="${asset.institutionCode}">
                                </div>

                            </div>
                        </div>
                         <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="corpContact" class="label-head label-head-lg  text-right"><span >企业联系人：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="corpContact" name="corpContact" value="${asset.corpContact}">
                                </div>

                            </div>
                        </div>
                         <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="corpContactTel" class="label-head label-head-lg  text-right"><span class="require">联系电话：</span></label>
                                <div class="label-box label-box-sm">
                                    <input value="${asset.corpContactTel}" type="text" maxlength="11" class="form-control" id="corpContactTel" name="corpContactTel">
                                </div>

                            </div>
                        </div>
                        
                         <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="email" class="label-head label-head-lg  text-right"><span >邮箱地址：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" value="${asset.email}" maxlength="32" class="form-control" id="email" name="email">
                                </div>

                            </div>
                        </div>
                         <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="fax" class="label-head label-head-lg  text-right"><span >传真号：</span></label>
                                <div class="label-box label-box-sm">
                                    <input value="${asset.fax}" type="text" maxlength="20" class="form-control" id="fax" name="fax">
                                </div>

                            </div>
                        </div>
                                    
                        
                        
                        <div class="col-sm-12 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right" ><span>通讯地址：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" class="form-control" id="registAddr" value="${asset.corpAddress}" name="registAddr" readonly="readonly" placeholder="请选择省市县">
                                </div>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" value="${asset.addressDetail}" id="registAddrDetail" name="registAddrDetail" placeholder="请输入详细地址">
                                </div>

                            </div>
                        </div>       
                              
                               <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="acceptAccountName" class="label-head label-head-lg  text-right"><span class="require">收款账户户名：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" value="${asset.acceptAccountName}" class="form-control" id="acceptAccountName" name="acceptAccountName">
                                </div>

                            </div>
                        </div>
                        
                          <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="acceptAccountNum" class="label-head label-head-lg  text-right"><span class="require">收款银行账号：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" value="${asset.acceptAccountNum}" class="form-control" id="acceptAccountNum" name="acceptAccountNum">
                                </div>

                            </div>
                        </div>
                        
                          <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="acceptAccountBank"><span class="require">收款银行开户行:</span></label>
                                <div class="label-box label-box-sm">
                                    <div class="input-group plugin-acceptAccountBank">
				                        <!-- <i class="clearable fa fa-remove" style="position: absolute; top: 12px; right: 35px; z-index: 4; cursor: pointer; font-size: 12px; "></i> -->
				                        <input type="text" class="form-control "  name="acceptAccountBankShow" id="plugin-acceptAccountBank" autocomplete="off"
				                        value="${acceptAccountBank.bankName}">
				                        <div class="input-group-btn ">
				                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="">
				                                <span class="caret"></span>
				                            </button>
				                            <ul class="dropdown-menu dropdown-menu-right" role="menu" style="padding-top: 0px; max-height: 375px; max-width: 800px; overflow: auto; width: auto; transition: 0.3s;">
				                            </ul>
				                        </div>
				                    </div>
                                </div>

                            </div>
                        </div> 
                        
                           <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="branchBank" class="label-head label-head-lg  text-right"><span class="require">收款银行支行：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="branchBank" value="${asset.branchBank}" name="branchBank">
                                </div>

                            </div>
                        </div>
                        
                        
                         <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="repaymentName" class="label-head label-head-lg  text-right"><span class="require">还款账户户名：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="repaymentName" name="repaymentName" value="${asset.repaymentName }">
                                </div>

                            </div>
                        </div>
                        
                          <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="repaymentNum" class="label-head label-head-lg  text-right"><span class="require">还款银行账号：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text"  class="form-control" id="repaymentNum" name="repaymentNum" value="${asset.repaymentNum }">
                                </div>

                            </div>
                        </div>
                        
                                  
                           <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="repaymentBank"><span class="require">还款银行开户行:</span></label>
                                <div class="label-box label-box-sm">
                                     <div class="input-group">
				                        <!-- <i class="clearable fa fa-remove" style="position: absolute; top: 12px; right: 35px; z-index: 4; cursor: pointer; font-size: 12px; "></i> -->
				                        <input type="text" class="form-control " name="repaymentBankShow" id="plugin-repaymentBank" autocomplete="off"
				                        value="${repaymentBank.bankName}">
				                        <div class="input-group-btn plugin-repaymentBank">
				                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="">
				                                <span class="caret"></span>
				                            </button>
				                            <ul class="dropdown-menu dropdown-menu-right" role="menu" style="padding-top: 0px; max-height: 375px; max-width: 800px; overflow: auto; width: auto; transition: 0.3s;">
				                            </ul>
				                        </div>
				                    </div>
                                </div>

                            </div>
                        </div>
                               
                        
                           <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="repaymentBranchBank" class="label-head label-head-lg  text-right"><span class="require">还款银行支行：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="repaymentBranchBank" name="repaymentBranchBank" value="${asset.repaymentBranchBank}">
                                </div>

                            </div>
                        </div>    
                        
                        
                        
                        
                        
                                   
                           
                                </div>
                                
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.box -->
                          
                    
                            <div class="modal-footer btn-center">
                                
                                <div  class="btn btn-primary btn-submit"
                                        id="saveAssetBtn" data-loading-text="保存...">保存
                                </div>
                                <div  class="btn btn-primary btn-submit"
                                        id="cancelBtn">取消
                                </div>
                            </div>
                        </div>
            </form>
            <!-- /.col -->
     
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script type="text/javascript"
        src="${ctx}/static/pagejs/system/asset/asset-add.js${timeStyle}"></script>
</body>
</html>