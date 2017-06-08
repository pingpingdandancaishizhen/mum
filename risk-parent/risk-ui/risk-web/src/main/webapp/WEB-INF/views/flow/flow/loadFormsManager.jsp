<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body  class="hold-transition skin-blue sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
   <section class="content">
       <div class="row">
        <div class="col-xs-12">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              	<li class="active"><a href="#category" data-toggle="tab">表单字段分类</a></li>
              <li><a href="#fields" data-toggle="tab">表单字段</a></li>
              <li><a href="#operations" data-toggle="tab">表单操作</a></li>
              <li><a href="#forms" data-toggle="tab">表单</a></li>
            </ul>
            <div class="tab-content">
	              <%@ include file="./tabs/category.jsp"%>
	              <%@ include file="./tabs/fields.jsp"%>
	              <%@ include file="./tabs/operations.jsp"%>
	               <%@ include file="./tabs/forms.jsp"%>
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  
  </div>
  <!-- /.content-wrapper -->
</body>
</html>