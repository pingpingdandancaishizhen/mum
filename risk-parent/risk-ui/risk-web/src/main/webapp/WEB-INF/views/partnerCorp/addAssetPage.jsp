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
</head>
<body class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content no-padding" id="addAssetForm">
            <form  onsubmit="return false;" class="form-label-auto "
                  action="${ctx}/asset/saveAsset" method="post">
                        <div class="col-md-12 pages-form">
                         <div class="sub-head">
                    资产方基本信息
                </div>
                            <div class="panel panel-default">
                             
                                <div class="panel-body">
                                    
                                    <div class="col-sm-6 row-right ">
                            <div class="form-group input-group" >
                                <label for="assetType" class="label-head label-head-lg  text-right"> <span >资产方归属：</span></label>
                                <div class="label-box label-box-sm form-group">
                                    <select class="form-control" name="assetType" id="assetType">
                                        <option value="">请选择</option>
                                        <c:forEach items="${assetType}" var="type">
                                                        <option value="${type.typeId}"
                                                        <c:if test="${type.selected}">
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
                                    <input type="text" maxlength="40" class="form-control" id="corpName" name="corpName">
                                </div>

                            </div>
                        </div>
                                <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="corpName" class="label-head label-head-lg  text-right"><span class="require">企业简称：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="40" class="form-control" id="corpAbbreviation" name="corpAbbreviation">
                                </div>

                            </div>
                        </div>
                                      <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="corpName" class="label-head label-head-lg  text-right"><span >机构代码：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="institutionCode" name="institutionCode">
                                </div>

                            </div>
                        </div>
                         <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="corpContact" class="label-head label-head-lg  text-right"><span >企业联系人：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="corpContact" name="corpContact">
                                </div>

                            </div>
                        </div>
                         <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="corpContactTel" class="label-head label-head-lg  text-right"><span >联系电话：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="11" class="form-control" id="corpContactTel" name="corpContactTel">
                                </div>

                            </div>
                        </div>
                        
                         <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="email" class="label-head label-head-lg  text-right"><span >邮箱地址：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="32" class="form-control" id="email" name="email">
                                </div>

                            </div>
                        </div>
                         <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="fax" class="label-head label-head-lg  text-right"><span >传真号：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="fax" name="fax">
                                </div>

                            </div>
                        </div>
                                    
                        
                        
                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right" ><span>户口所在地：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" class="form-control" id="registAddr" name="registAddr" readonly="readonly" placeholder="请选择省市县">
                                </div>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="registAddrDetail" name="registAddrDetail" placeholder="请输入详细地址">
                                </div>

                            </div>
                        </div>       
                              
                               <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="acceptAccountName" class="label-head label-head-lg  text-right"><span >收款账户户名：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="acceptAccountName" name="acceptAccountName">
                                </div>

                            </div>
                        </div>
                        
                          <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="acceptAccountNum" class="label-head label-head-lg  text-right"><span >收款银行账号：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="acceptAccountNum" name="acceptAccountNum">
                                </div>

                            </div>
                        </div>
                        
                                  <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="acceptAccountBank"><span>收款银行开户行：</span></label>
                                <div class="label-box label-box-sm">
                                    <select class="form-control" name="acceptAccountBank"
                                            id="acceptAccountBank">
                                        <option value="">请选择</option>
                                         <c:forEach items="${banks}" var="bank">
                                                        <option value="${bank.id}">
                                                            ${bank.bankName}
                                                        </option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                        </div>
                        
                           <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="branchBank" class="label-head label-head-lg  text-right"><span class="require">收款银行支行：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="branchBank" name="branchBank">
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
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script type="text/javascript"
        src="${ctx}/static/pagejs/system/asset/asset-add.js${timeStyle}"></script>
</body>
</html>