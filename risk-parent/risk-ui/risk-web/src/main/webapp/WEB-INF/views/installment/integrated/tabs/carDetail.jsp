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
<div class="tab-pane " id="carDetail">
    <div class="box-body">
        <form onsubmit="return false;"  class="form-inline form-label-auto" id="viewContractPartnerForm" action="#">
            <div class=" pages-form">
                <div class="sub-head">
                    车辆信息
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right">是否已上牌:</label>
                                <div class="label-box label-box-sm">
                                    <%-- <div  class="form-control">${car.hasLicense }</div> --%>
                                    <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${car.hasLicense }" >
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"><span >车牌号码:</span></label>
                                <div class="label-box label-box-sm">
                                    <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${car.licenseNo }" >
                                    <!-- <label class="form-control label_view" id="name_view">${car.licenseNo }</label> -->
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"><span >发动机号:</span></label>
                                <div class="label-box label-box-sm">
                                    <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${car.engineNo }" >
                                    <!-- <label class="form-control label_view" id="name_view">${car.engineNo }</label> -->
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"><span >车架号:</span></label>
                                <div class="label-box label-box-sm">
                                    <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${car.frameNo }" >
                                    <!-- <label class="form-control label_view" id="name_view">${car.frameNo }</label> -->
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"><span >初次登记日期:</span></label>
                                <div class="label-box label-box-sm">
                                    <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${car.firstRegisterDate }" >
                                    <!-- <label class="form-control label_view" id="name_view">${car.firstRegisterDate }</label> -->
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right">是否为过户车:</label>
                                <div class="label-box label-box-sm">
                                    <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${car.specialCarFlag }" >
                                    <%-- <div class="form-control label_view" id="name_view">${car.specialCarFlag }</input> --%>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"><span >车品牌/车系/车型号:</span></label>
                                <div class="label-box label-box-sm">
                                    <input readonly style="background:#FFFFFF" type="text" class="form-control" value="${car.brandName }" >
                                    <!-- <label class="form-control label_view" id="name_view">${car.brandName }</label> -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <div class="sub-head">影像资料:</div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="form-group col-sm-12" style="color:#BEBEBE">
                            文件类型支持JPG、png、pdf、doc、xls、mp3、wav、wmv等常见类型，文件大小不超过10M。
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="bootstrap-table">
                                <div class="fixed-table-container">
                                    <div class="fixed-table-body">
                                        <table class="table table-striped" >
                                           <thead>
                                           <tr >
                                               <th>ID</th>
                                               <th>车辆资料</th>
                                               <th>必填</th>
                                               <th>上传文件</th>
                                               <th>上传日期</th>
                                           </tr>
                                           </thead>
                                            <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>行驶证主页</td>
                                                <td></td>
                                                <td><a href="${owner.driverCardImgPositive }" target="view_window">行驶证主页</a></td>
                                                <td>上传日期:${owner.createTime }</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>行驶证副页</td>
                                                <td></td>
                                                <td><a href="${owner.driverCardImgBack }" target="view_window">行驶证副页</a></td>
                                                <td>上传日期:${owner.createTime }</td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>车辆登记证书</td>
                                                <td></td>
                                                <td></td>
                                                <td>上传日期:</td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>车辆正面照</td>
                                                <td></td>
                                                <td></td>
                                                <td>上传日期:</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
