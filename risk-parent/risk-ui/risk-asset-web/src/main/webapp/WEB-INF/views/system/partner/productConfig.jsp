<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
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
    <!-- Main content -->
    <section class="content content-padding" id="productConfigForm">
        <form onsubmit="return false;" class="form-inline form-label-auto table-box"
              action="${ctx}/system/partner/saveProductConfig" method="post">
            <input type="hidden" id="productId" name="productId" value="${productId }">
            <div class="box-body">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        产品参与方配置
                    </div>
                    <div class="panel-body">
                        <div>
                            <script>
                                window.proConfigOptions = {};
                            </script>
                            <table class="table  table-striped">
                                <thead>
                                <tr>
                                    <th width="20%">类别</th>
                                    <th>参与方</th>
                                </tr>
                                </thead>
                               <tbody>
                               <c:forEach items="${roleList }" var="role">
                                   <script>
                                       var roleId="${role.id}";
                                       var validateKey="ip_role_${role.id}";
                                       if(roleId==1||roleId==3){
                                           proConfigOptions[validateKey]={
                                               validators:{
                                                   choice:{
                                                       min:1,
                                                       message:'请选择最少一个${role.name}'
                                                   }
                                               }
                                           }
                                       }else{
                                           proConfigOptions[validateKey]={
                                               validators:{
                                                   notEmpty: {
                                                       message: '请选择${role.name}'
                                                   }
                                               }
                                           }
                                       }
                                   </script>
                                   <c:if test="${role.partnerList != null && role.partnerList.size()>0}">
                                       <tr >
                                           <td>${role.name}</td>
                                           <td >
                                               <div class="form-group no-margin">
                                                   <div class="label-box checkbox">
                                                       <c:forEach items="${role.partnerList }" var="partner">
                                                           <label class="label-box-item" id="lb_role_${role.id }_${partner.id}"  for="ip_role_${role.id}_${partner.id}" >
                                                               <input type="checkbox" id="ip_role_${role.id}_${partner.id}" class="ip_cla_${role.id}" name="ip_role_${role.id}" onchange="javascript:partnerChange('${role.id }','${partner.id}',<c:choose> <c:when test="${role.id == 3 || role.id == 1}">true</c:when><c:otherwise>false</c:otherwise></c:choose>);" value="${role.id}_${partner.id}"/> ${partner.name}
                                                           </label>
                                                       </c:forEach>
                                                   </div>

                                               </div>


                                           </td>
                                       </tr>
                                   </c:if>
                               </c:forEach>
                               </tbody>

                            </table>
                        </div>
                        <div class="col-sm-12 text-center">
                            <shiro:hasPermission name="product:partnerconfig">
                                <div  class="btn btn-primary " id="saveConfigBtn"
                                        data-loading-text="确定...">确定
                                </div>
                            </shiro:hasPermission>
                            <div  class="btn btn-default " id="cancelBtn">取消
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script type="text/javascript"
        src="${ctx}/static/pagejs/system/partner/product-config.js${timeStyle}"></script>
</body>
</html>