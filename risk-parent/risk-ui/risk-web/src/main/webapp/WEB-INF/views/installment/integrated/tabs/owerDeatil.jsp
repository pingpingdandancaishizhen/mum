<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script src="${ctx}/static/assets/plugins/datepicker/bootstrap-datepicker.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/moment.min.js${timeStyle}"></script>
<script src="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.js${timeStyle}"></script>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/datepicker/datepicker3.css${timeStyle}"></link>
<link rel="stylesheet"
      href="${ctx}/static/assets/plugins/daterangepicker/daterangepicker.css${timeStyle}"></link>
<div class="tab-pane " id="owerDetail">
    <div class="box-body">
        <form onsubmit="return false;" class="form-inline form-label-auto" id="viewContractPartnerForm" action="#">
            <div class="sub-head">
                客户基本信息
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">客户姓名：</label>
                            <div class="label-box label-box-sm">
                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${owner.ownerName }">
                                <!-- <label class="form-control label_view" >${owner.ownerName }</label> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">性别：</label>
                            <div class="label-box label-box-sm">
                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${owner.sex }">
                                <!-- <label class="form-control label_view" >${owner.sex }</label> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">身份证号：</label>
                            <div class="label-box label-box-sm">
                                <!-- <label class="form-control label_view" >${owner.ownerIdNoStr }</label> -->
                                <input readonly="" style="background:#FFFFFF" type="text" maxlength="18" class="form-control" value="${owner.ownerIdNoStr }">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">年龄：</label>
                            <div class="label-box label-box-sm">
                                <input readonly="" style="background:#FFFFFF" type="text" maxlength="18" class="form-control" value="${owner.age }">
                                <%-- <label class="form-control label_view">${owner.age }</label> --%>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">出生日期：</label>
                            <div class="label-box label-box-sm">
                                <!-- <label class="form-control label_view" >${owner.birthDay }</label> -->
                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${owner.birthDay }">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">手机号：</label>
                            <div class="label-box label-box-sm">
                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${owner.ownerMobile }">
                                <!-- <label class="form-control label_view" >${owner.ownerMobile }</label> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="sub-head">
                客户影像资料：
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="form-group  clearfix">
                        <div class="col-sm-12 control-label"><font color="#BEBEBE">
                            文件类型支持JPG、png、pdf、doc、xls、mp3、wav、wmv等常见类型，文件大小不超过10M。</font></div>
                    </div>
                    <div class="form-group  clearfix col-sm-12">
                        <div class="bootstrap-table">
                            <div class="fixed-table-container">
                                <div class="fixed-table-body">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>身份资料</th>
                                            <th>上传文件</th>
                                            <th>上传日期</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>身份证照正面</td>
                                            <td><a href="${owner.idCardImgPositive }" target="view_window">身份证照正面</a></td>
                                            <td>上传日期：${owner.createTime }</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>身份证照反面</td>
                                            <td><a href="${owner.idCardImgBack }" target="view_window">身份证照反面</a></td>
                                            <td>上传日期：${owner.createTime }</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="sub-head">
                收件人信息(紧急联系人)
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">收件人姓名：</label>
                            <div class="label-box label-box-sm">
                                <%-- <div class="form-control label_view">${receiver.receiverName }</div> --%>
                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${receiver.receiverName }">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">移动电话：</label>
                            <div class="label-box label-box-sm">
                                <%-- <div class="form-control label_view">${receiver.receiverMobile }</div> --%>
                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${receiver.receiverMobile }">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">邮箱地址：</label>
                            <div class="label-box label-box-sm">
                                <%-- <div class="form-control label_view">${receiver.email }
                                </div> --%>
                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${receiver.email }">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 row-right">
                        <div class="input-group form-group">
                            <label class="label-head label-head-lg  text-right">邮寄地址：</label>
                            <div class="label-box label-box-sm">
                                <%-- <div class="form-control">${receiver.receiverProvinceName }${receiver.receiverCityName }${receiver.receiverCountyName }${receiver.receiverAddress }
                                </div> --%>
                                <input readonly="" style="background:#FFFFFF" type="text" class="form-control" value="${receiver.receiverCityName }${receiver.receiverCountyName }${receiver.receiverAddress }">
                            </div>
                        </div>
                    </div>
                        <!-- /.panel-body -->
                </div>
            </div>
        </form>
    </div>
</div>
