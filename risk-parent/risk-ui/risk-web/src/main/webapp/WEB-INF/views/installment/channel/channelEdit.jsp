<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>乐位云风控</title>
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
    <style type="text/css">
    .city-picker-dropdown{
    	top: 100%!important;
    }
    </style>
</head>
<body class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper ">
    <!-- Main content -->
    <section class="content no-padding" id="addChannelForm">
        <form onsubmit="return false;"  class="form-label-auto "
              action="${ctx}/channel/save" method="post">
            <input type="hidden" id="channelId" name="channelId" value="${channel.channelId}"/>
            <input type="hidden" id="releId" name="releId" value="${channel.releId}"/>
            <div class="col-md-12 pages-form">
                <div class="sub-head">渠道商信息</div>
                <div class="panel panel-default">
                    <div class="panel-body">

                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="channelName" class="label-head label-head-lg  text-right"><span class="require">名称</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="channelName" name="channelName" value="${channel.channelName}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="subname" class="label-head label-head-lg  text-right"><span class="require">简称</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="18" class="form-control" id="subname" name="subname" value="${channel.subname}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="channelCode" class="label-head label-head-lg  text-right"><span class="require">机构代码</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="channelCode" name="channelCode" value="${channel.channelCode}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="email" class="label-head label-head-lg  text-right"><span class="require">邮箱地址</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="18" class="form-control" id="email" name="email" value="${channel.email}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="contact" class="label-head label-head-lg  text-right"><span class="require">企业联系人</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="contact" name="contact" value="${channel.contact}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="tel" class="label-head label-head-lg  text-right"><span class="require">联系电话</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="18" class="form-control" id="tel" name="tel" value="${channel.tel}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="fax" class="label-head label-head-lg  text-right"><span class="require">传真号</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="fax" name="fax" value="${channel.fax}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg text-right" for="address"><span>通讯地址</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" class="form-control" id="location" name="location" readonly="readonly" value="${channel.location}">
                                </div>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="address" name="address" value="${channel.address}" placeholder="请输入详细地址">
                                </div>
                            </div>
                            <input type="hidden" id="address" name="address" value="${channel.address}">
                        </div>
	
						<div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="bankCardUser" class="label-head label-head-lg  text-right"><span class="require">收款账户户名</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="bankCardUser" name="bankCardUser" value="${channel.bankCardUser}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="bankCardNo" class="label-head label-head-lg  text-right"><span class="require">收款银行帐号</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="18" class="form-control" id="bankCardNo" name="bankCardNo" value="${channel.bankCardNo}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="bankName" class="label-head label-head-lg  text-right"><span class="require">收款银行开户行</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="bankName" name="bankName" value="${channel.bankName}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="bankSubname" class="label-head label-head-lg  text-right"><span class="require">收款银行支行</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="18" class="form-control" id="bankSubname" name="bankSubname" value="${channel.bankSubname}">
                                </div>
                            </div>
                        </div>
						
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.box -->
				<div class="sub-head">计费方式</div>
                <div class="panel panel-default">
                	<div class="panel-body">

                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="gender" class="label-head label-head-lg  text-right"><span class="require">手续费</span></label>
                                <div class="label-box label-box-sm">
                                    <div class="input-group">
                                    <input type="text" maxlength="20" class="form-control" id="poundage" name="poundage" value="${channel.poundageStr}">
                                    <span class="input-group-addon">%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="gender" class="label-head label-head-lg  text-right"><span class="require">利息</span></label>
                                <div class="label-box label-box-sm">
                                    <div class="input-group">
                                    <input type="text" maxlength="18" class="form-control" id="interest" name="interest" value="${channel.interestStr}">
                                    <span class="input-group-addon">%</span>
                                	</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer btn-center">
                    <div  class="btn btn-primary btn-primary-lg" id="saveCustomerBtn" data-loading-text="确定...">确定</div>
                    <div  class="btn btn-cancel btn-primary-lg" id="cancelBtn">取消</div>
                </div>
            </div>
        </form>
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script type="text/javascript">
$(function(){
	
	worf.ajax({
		url : web_root+'/district/info',
		type : 'get',
		success : function(data) {
			$('#addChannelForm #location').citypicker({simple:true,data:data.data});
		}
	});
	
	$("#cancelBtn").bind("click",function(){
		var url=tools.getCurrentIFrameUrl();
		debugger
		tools.closeParentTab(url)
	});
	
	
})
</script>
</body>
</html>