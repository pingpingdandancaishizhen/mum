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
<body class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper ">
    <!-- Main content -->
    <section class="content no-padding" id="addCustomerForm">
        <form onsubmit="return false;"  class="form-label-auto "
              action="${ctx}/system/customer/saveCustomer" method="post">
            <div class="col-md-12 pages-form">
                <div class="sub-head">
                    客户基本信息
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group" >
                                <label for="type" class="label-head label-head-lg  text-right"> <span class="require">客户类型：</span></label>
                                <div class="label-box label-box-sm form-group">
                                    <select class="form-control" name="type" id="type">
                                        <option value="">请选择</option>
                                        <c:forEach items="${types}" var="type">
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
                                <label for="gender" class="label-head label-head-lg  text-right"><span class="require">客户姓名：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="name" name="name">
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="gender" class="label-head label-head-lg  text-right"><span class="require">身份证号码：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="18" class="form-control" id="licenseNum" name="licenseNum">
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label for="gender" class="label-head label-head-lg  text-right"> <span class="require">性别：</span></label>
                                <div class="label-box label-box-sm">
                                    <select class="form-control" name="gender"
                                            id="gender">
                                        <option value="">请选择</option>
                                        <c:forEach items="${genders}" var="gender">
                                            <option value="${gender.type}">
                                                ${gender.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right" for="maritalStatus"><span>婚姻状况：</span></label>
                                <div class="label-box label-box-sm">
                                    <select class="form-control" name="maritalStatus"
                                            id="maritalStatus">
                                        <option value="">请选择</option>
                                        <c:forEach items="${marital}" var="marry">
                                            <option value="${marry.type}">
                                                ${marry.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right" for="childCount"><span>子女数目： </span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="3" class="form-control" id="childCount" name="childCount">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right" for="supportNum"><span>供养人数</span>：</label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="3" class="form-control" id="supportNum" name="supportNum">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="houseSpending"><span>每月家庭支出：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="houseSpending" name="houseSpending">
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="education"><span>最高学历：</span></label>
                                <div class="label-box label-box-sm">
                                    <select class="form-control" name="education"
                                            id="education">
                                        <option value="">请选择</option>
                                        <c:forEach items="${education}" var="education">
                                            <option value="${education.type}">
                                                ${education.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="gender" ><span class="require">移动电话1：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="11" class="form-control" id="mobile" name="mobile">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="mobile2"><span>移动电话2：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="11" class="form-control" id="mobile2" name="mobile2">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="email"><span>邮箱：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="32"
                                           class="form-control" id="email" name="email">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="qq"><span>QQ：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="15"
                                           class="form-control" id="qq" name="qq">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="wechat"><span>微信：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="wechat" name="wechat">
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="phone"><span>住宅电话：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="13" class="form-control" id="phone" name="phone">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="houseTime"><span>现住址入住时间：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="houseTime" name="houseTime" readonly="readonly">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="houseType"><span>现住址类别：</span></label>
                                <div class="label-box label-box-sm">
                                    <select class="form-control" name="houseType"
                                            id="houseType">
                                        <option value="">请选择</option>
                                        <c:forEach items="${houseTypes}"
                                                   var="houseType">
                                            <option value="${houseType.typeId}">
                                                ${houseType.typeName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  ><span>来本市时间：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" class="form-control" id="comeTime" name="comeTime" readonly="readonly">
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

                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="liveAddr"><span>现住址：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" class="form-control" id="liveAddr" name="liveAddr" readonly="readonly">
                                </div>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="liveAddrDetail" name="liveAddrDetail" placeholder="请输入详细地址">
                                </div>


                            </div>
                        </div>


                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.box -->
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
                                                                       name="idCardFront">
                                                                <div class="form-control">
                                                                    <div class="uploadFileName">

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
                                                    </div> <!---->
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
                                                                <input type="text" id="idCardBack" name="idCardBack" class="hiddenInput" >
                                                                <div class="form-control ">
                                                                    <div class="uploadFileName">
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
                    <!-- /.panel-body -->
                </div>
                <!-- /.box -->
                <div class="sub-head">
                    客户职业信息
                </div>
                <div class="panel panel-default">

                    <div class="panel-body">
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="industry"><span>所属行业：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" class="form-control" id="industry" name="industry" readonly="readonly">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="companyType"><span>公司性质：</span></label>
                                <div class="label-box label-box-sm">
                                    <select class="form-control" name="companyType"
                                            id="companyType">
                                        <option value="">请选择</option>
                                        <c:forEach items="${companyType}"
                                                   var="companyType">
                                            <option value="${companyType.type}">
                                                ${companyType.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="job"><span>职位：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" class="form-control" id="job" name="job" readonly="readonly">
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="companyName"><span>单位名称：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="companyName" name="companyName">
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="deptName"><span>所在部门/科室：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="15" class="form-control" id="deptName" name="deptName">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  ><span>入职时间：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" class="form-control" id="entryTime" name="entryTime" readonly="readonly">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="salary"><span>月均工资：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="salary" name="salary">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right ">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="salaryDate"><span>每月发薪日：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20" class="form-control" id="salaryDate" name="salaryDate">
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="salaryType"><span>工资发放形式：</span></label>
                                <div class="label-box label-box-sm">
                                    <select class="form-control" name="salaryType"
                                            id="salaryType">
                                        <option value="">请选择</option>
                                        <c:forEach items="${salaryType}"
                                                   var="salaryType">
                                            <option value="${salaryType.type}">
                                                ${salaryType.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right"  for="companyPhone"><span>单位电话：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="13"
                                           class="form-control" id="companyPhone"
                                           name="companyPhone">
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6 row-right">
                            <div class="form-group input-group">
                                <label class="label-head label-head-lg  text-right" ><span>单位地址：</span></label>
                                <div class="label-box label-box-sm">
                                    <input type="text"
                                           class="form-control" id="companyAddr"
                                           name="companyAddr" readonly="readonly">
                                </div>
                                <div class="label-box label-box-sm">
                                    <input type="text" maxlength="20"
                                           class="form-control"
                                           id="companyAddrDetail"
                                           name="companyAddrDetail"
                                           placeholder="请输入详细地址">
                                </div>


                            </div>
                        </div>

                    </div>
                </div>
                <!-- /.box -->
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
<script type="text/javascript"
        src="${ctx}/static/pagejs/system/customer/customer-add.js${timeStyle}"></script>
</body>
</html>