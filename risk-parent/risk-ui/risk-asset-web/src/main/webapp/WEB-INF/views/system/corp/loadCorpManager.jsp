<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
    <link rel="stylesheet" href="${ctx}/static/assets/plugins/jQuery-city/css/animate.min.css${timeStyle}">
    <link rel="stylesheet" href="${ctx}/static/assets/plugins/position/base.css${timeStyle}"/>
    <link rel="stylesheet" href="${ctx}/static/assets/plugins/position/big-window.css${timeStyle}"/>
    <script src="${ctx}/static/assets/plugins/position/position.data.min.js${timeStyle}"
            type="text/javascript"></script>
    <script src="${ctx}/static/assets/plugins/position/jquery.position.select.js${timeStyle}"
            type="text/javascript"></script>

    <link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/main.css${timeStyle}"/>
    <link rel="stylesheet" href="${ctx}/static/assets/plugins/city-picker/css/city-picker.css${timeStyle}"/>
    <script src="${ctx}/static/assets/plugins/city-picker/city-picker.js${timeStyle}"></script>

    <link rel="stylesheet" href="${ctx}/static/assets/plugins/webuploader/webuploader.css${timeStyle}"/>
    <script src="${ctx}/static/assets/plugins/webuploader/webuploader.js${timeStyle}"></script>
</head>
<body  class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
        <!-- Main content -->
    <section class="content content-padding ">
      <div class="row table-box">
        <div class="col-xs-12">
          <div class="panel">
            <div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal custom-form" id="corpForm"
					action="${ctx}/system/corp/updateCorp" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="corpName" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>企业全称：</label>
							<div class="col-sm-8">
								<input type="text" maxlength="100"  class="form-control" id="corpName"	name="corpName" value="${vo.corpName}">
							</div>
						</div>
						<div class="form-group">
							<label for="simpleName" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>企业简称：</label>
							<div class="col-sm-8">
								<input type="text" maxlength="50" class="form-control" id="simpleName" name="simpleName" value="${vo.simpleName}">
							</div>
						</div>
						<div class="form-group">
							<label for="linkPhone" class="col-sm-2 control-label">联系电话：</label>
							<div class="col-sm-8">
								<input type="text" maxlength="11"  class="form-control" id="linkPhone" name="linkPhone" value="${vo.linkPhone}">
							</div>
						</div>
						<div class="form-group">
							<label for="address" class="col-sm-2 control-label">通讯地址：</label>
							<div class="col-sm-4">
								<div style="position: relative">
									<input type="text" readonly="readonly" class="form-control" id="address" name="address"  value="${vo.address}">

								</div>
								</div>
							<div class="col-sm-4">
                                 <input type="text" maxlength="20" class="form-control" id="addressDetail" name="addressDetail"  placeholder="请输入详细地址" value="${vo.addressDetail}">
                            </div>
						</div>
						<div class="form-group">
							<label for="admin" class="col-sm-2 control-label">企业管理员：</label>
							<div class="col-sm-8">
								<input type="text" disabled="disabled" class="form-control" id="admin" name="admin" value="${vo.admin}">
							</div>
						</div>
						<div class="form-group uploadFile">
							<label for="logo" class="col-sm-2 control-label">LOGO：</label>
                                                        <div class="col-sm-8">
                                                            <div class="input-group uploadFileDiv">
			                                                              <input type="text" id="logo" class="hiddenInput" 
																	   name="logo" value="${vo.logo}">
																<div class="form-control">
																	<div class="uploadFileName">
																		<c:if test="${not empty vo.logo}">
																			<div title="LOGO" class="file-caption-name">
																				<i class="glyphicon glyphicon-file"></i>
																				<span><a href="${vo.logo}" target="_blank">logo</a></span>
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
                                                                    <div class="btn btn-upload " id="pick-logo">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                         </div>
						<div class="form-group">
							<label for="descc" class="col-sm-2 control-label">企业简介：</label>
							<div class="col-sm-8">
								  <textarea class="form-control" maxlength="100" rows="3" id="descc" name="descc"   >${vo.descc}</textarea>
							</div>
						</div>
						<div class="btn-center">
							<shiro:hasPermission name="corp:modify">
								<input type="submit" class="btn  btn-primary  btn-primary-lg" id="modifyCorpInfo" value="修改"/>
							</shiro:hasPermission>
						</div>
					</div>
				</form>
				
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<shiro:hasPermission name="corp:modify">
	<script type="text/javascript" src="${ctx}/static/pagejs/system/corp/corp-modify.js"></script>
 </shiro:hasPermission>
</body>
</html>