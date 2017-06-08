<%@ page contentType="text/html;charset=UTF-8"%>
<style>
    .roleDiv label {
        display: inline-block;
    }
</style>
<div class="modal" id="addContractPartnerModal" tabindex="-1"
     role="dialog" aria-expanded="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">新增参与方</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <form onsubmit="return false;" class="form-label-auto form-horizontal custom-form"
                          id="addContractPartnerForm"
                          action="${ctx}/system/partner/savePartner" method="post">
                        <input type="hidden" id="id" name="id"> <input
                            type="hidden" id="status" name="status">
                        <div class="col-sm-12">
                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                <label for="roleIds" class="label-head label-head-top label-head-lg"><span
                                        class="require">参与方类型：</span></label>
                                <div id="roleDiv" class="label-box">
                                    <!--<c:forEach items="${roleList}" var="role">
                                        <label id="lb_${role.id}" class="label-box-item">
                                            <input id="ip_${role.id}" type="checkbox" name="roleIds"
                                                   value="${role.id}"><span>${role.name}</span>
                                        </label>
                                    </c:forEach>-->
                                </div>
                            </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                    <label for="type" class="label-head label-head-top label-head-lg"><span
                                            class="require">参与方类别：</span></label>
                                    <select class="form-control" id="type" name="type">
                                        <option value="">请选择</option>
                                        <option value="1">法人</option>
                                        <option value="2">公司</option>
                                    </select>
                                </div>

                            </div>
                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                    <label for="name" class="label-head  label-head-lg"><span id="name_sp" class="require">参与企业名称：</span></label>
                                    <input type="text" class="form-control"
                                           id="name" name="name" value="">
                                </div>

                            </div>
                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                    <label for="code" class="label-head  label-head-lg">
                                        <span class="require" id="code_sp">机构代码：</span>
                                    </label>
                                    <input type="text" class="form-control" id="code" name="code">
                                </div>


                            </div>
                            <div class="form-group col-sm-12" id="coopDeptDiv" style="display: none">
                                <div class="input-group">
                                    <label for="coopDept" class="label-head label-head-top label-head-lg"><span
                                            class="require">合作门店：</span></label>
                                    <select class="form-control" id="coopDept" name="coopDept">
                                        <option value="">请选择</option>
                                        <c:forEach items="${deptList}" var="dept">
                                            <option value="${dept.id }">${dept.name }</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="form-group col-sm-12 ">
                                <div class="input-group">
                                    <label for="phone" class="label-head  label-head-lg"><span
                                            class="require">联系电话：</span></label>
                                    <input type="text" class="form-control" id="phone" name="phone">
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                    <label for="email" class="label-head  label-head-lg">邮箱地址：</label>
                                    <input type="text" class="form-control" id="email" name="email">
                                </div>
                            </div>

                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                    <label for="fax" class="label-head  label-head-lg">传真号：</label>
                                    <input type="text" class="form-control" id="fax" name="fax">
                                </div>

                            </div>
                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                    <label for="address" class="label-head  label-head-lg"><span
                                            class="require">通讯地址：</span></label>
                                    <div class="label-box">
                                        <div class="  col-sm-6 row-left">
                                            <input type="text" class="form-control" id="address"
                                                   name="address" readonly="readonly" value="">
                                        </div>
                                        <div class=" col-sm-6">
                                            <input type="text" class="form-control"
                                                   id="addrDetail" name="addrDetail"
                                                   placeholder="请输入详细地址">
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="form-group col-sm-12">
                                <div class="input-group">
                                    <label for="sealResource" class="label-head label-head-lg"><span
                                            class="require">公章：</span></label>
                                    <div class="uploadFileDiv">
                                        <div class="input-group uploadFile">
                                            <input type="text" id="sealResource" class="hiddenInput"
                                                   name="sealResource"> <input type="text"
                                                                               id="sealName"
                                                                               class="hiddenInput"
                                                                               name="sealName">
                                            <div class="form-control">
                                                <div id="sealFileDiv" class="uploadFileName"></div>
                                                <div id="sealNoteDiv" class="fileNote"></div>
                                            </div>
                                            <div class="input-group-btn">
                                                <div class="btn btn-upload deleteFileBtn">
                                                    <i class="glyphicon glyphicon-trash"></i>
                                                    <span>删除</span>
                                                </div>
                                               <!-- <div class="btn btn-upload uploadFileBtn">
                                                    <div>
                                                        <i class="glyphicon glyphicon-upload"></i>
                                                        <span>上传</span>
                                                    </div>
                                                </div>-->
                                                <div class="btn btn-upload " id="pick-seal"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="form-group col-sm-12" id="signDiv">
                                <div class="input-group">
                                    <label for="signResource" class="label-head label-head-lg"><span
                                            class="require">签名：</span></label>
                                    <div class=" uploadFileDiv">
                                        <div class="input-group uploadFile">
                                            <input type="text" id="signResource" class="hiddenInput"
                                                   name="signResource"> <input type="text"
                                                                               id="signName"
                                                                               class="hiddenInput"
                                                                               name="signName">
                                            <div class="form-control">
                                                <div id="signFileDiv" class="uploadFileName"></div>
                                                <div id="signNoteDiv" class="fileNote"></div>
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
                                                <div class="btn btn-upload " id="pick-sign"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                    </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <div  class="btn btn-primary" id="savePartnerBtn"
                        data-loading-text="确定中...">确定
                </div>
                <div  class="btn btn-cancel" data-dismiss="modal">取消</div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript"
        src="${ctx}/static/pagejs/system/partner/partner-add.js${timeStyle}"></script>
