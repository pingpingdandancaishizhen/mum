<%@ page contentType="text/html;charset=UTF-8"%>
<style>
.partnerDiv label{display: inline-block;margin: 10px;}
.label_view{font-weight:100}
</style>
<div class="modal" id="viewContractPartnerModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">查看参与方</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="custom-form" id="viewContractPartnerForm" action="#">
					<div class="col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                            	参与方
                            </div>
                            <div class="panel-body">
                                <div class="col-sm-12">
                                	<div class="form-group  clearfix">
										<label class="col-sm-3 control-label"><span style="color: #FF0000;">*</span>参与方类型：</label>
										<div class="col-sm-9 partnerDiv" id="roles_view" data-toggle="buttons"></div>
									</div>
                                </div>
                                <div class="col-sm-12">
                                	<div class="form-group clearfix">
										<label class="col-sm-3 control-label"><span style="color: #FF0000;">*</span>参与方类别：</label>
										<div class="col-sm-9">
											<select class="form-control" id="type_view" disabled="disabled">
                                            	<option value="">请选择</option>
                                            	<option value="1">法人</option>
                                            	<option value="2">公司</option>
                                            </select>
										</div>
									</div>
                                </div>
                                <div class="col-sm-12">
                                	<div class="form-group clearfix">
                                		<label class="col-sm-3 control-label"><span style="color: #FF0000;">*</span>参与企业名称：</label>
                                		<div class="col-sm-9">
                                			<label class="form-control label_view" id="name_view"></label>
                                		</div>
                                	</div>
                                </div>
                                <div class="col-sm-12">
                                	<div class="form-group clearfix">
                                		<label class="col-sm-3 control-label"><span style="color: #FF0000;">*</span>机构代码：</label>
                                		<div class="col-sm-9">
                                			<label class="form-control label_view" id="code_view"></label>
                                		</div>
                                	</div>
                                </div>
                                <div class="col-sm-12" id = "coopDeptDiv" style="display:none">
	                                    	<div class="form-group clearfix">
												<label for="coopDept" class="col-sm-3 control-label"><span style="color: #FF0000;">*</span>合作门店：</label>
												<div class="col-sm-9">
													<select class="form-control" id="coopDept" name="coopDept" disabled="disabled">
	                                                	<option value="">请选择</option>
	                                                	<c:forEach items="${deptList}" var="dept">
	                                                		<option value="${dept.id }">${dept.name }</option>
	                                                	</c:forEach>
	                                                </select>
												</div>
											</div>
	                                    </div>
                                <div class="col-sm-12">
                                	<div class="form-group clearfix">
                                		<label class="col-sm-3 control-label"><span style="color: #FF0000;">*</span>联系电话：</label>
                                		<div class="col-sm-9">
                                			<label class="form-control label_view" id="phone_view"></label>
                                		</div>
                                	</div>
                                </div>
                                <div class="col-sm-12">
                                	<div class="form-group">
                                		<label class="col-sm-3 control-label">邮箱地址：</label>
                                		<div class="col-sm-9">
                                			<label class="form-control label_view" id="email_view"></label>
                                		</div>
                                	</div>
                                </div>
                                <div class="col-sm-12">
                                	<div class="form-group">
                                		<label class="col-sm-3 control-label">传真号：</label>
                                		<div class="col-sm-9">
                                			<label class="form-control label_view" id="fax_view"></label>
                                		</div>
                                	</div>
                                </div>
                                <div class="col-sm-12">
                                	<div class="form-group">
                                		<label class="col-sm-3 control-label"><span style="color: #FF0000;">*</span>通讯地址：</label>
                                		<div class="col-sm-9">
                                			<label class="form-control label_view" id="address_view"></label>
                                		</div>
                                	</div>
                                </div>
                                <div class="col-sm-12">
                                	<div class="form-group">
                                		<label class="col-sm-3 control-label"><span style="color: #FF0000;">*</span>公章：</label>
                                		<div class="col-sm-9">
                                			<label class="form-control label_view" id="sealResource_view"></label>
										</div>
                                	</div>
                                </div>
                                <div class="col-sm-12" id = "signDiv_view" style="display:none">
                                	<div class="form-group">
                                		<label class="col-sm-3 control-label"><span style="color: #FF0000;">*</span>签名：</label>
                                		<div class="col-sm-9">
                                			<label class="form-control label_view" id="signResource_view"></label>
										</div>
                                	</div>
                                </div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                    </div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-default" data-dismiss="modal">返回</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/static/pagejs/system/partner/partner-view.js${timeStyle}"></script>
