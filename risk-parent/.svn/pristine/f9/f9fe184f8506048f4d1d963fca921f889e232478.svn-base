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
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 系统管理</a></li>
        <li class="active"><a href="${ctx}/system/param/loadParamsManager">系统参数配置</a></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-body">
                <div id="toolbar">
                    <shiro:hasPermission name="role:add">
                        <div class="btn btn-white" id="add_role_btn">
                            <i class="icon icon-plus"></i>
                            <span>系统参数配置</span>
                        </div>
                    </shiro:hasPermission>
               </div>
				<div class="bootstrap-table">
					<div class="fixed-table-container" style="padding-bottom: 0px;">
						<div class="fixed-table-header" style="display: none;">
							<table></table>
						</div>
						<div class="fixed-table-body">
							<table class="table  table-striped table-hover"	id="role_table">
								<thead>
									<tr>
										<th style="" data-field="1" tabindex="0">
											<div class="th-inner ">参数名</div>
											<div class="fht-cell"></div>
										</th>
										<th class="l_cz2" data-field="3" tabindex="0">
											<div class="th-inner ">参数描述</div>
											<div class="fht-cell"></div>
										</th>
										<th style="" data-field="1" tabindex="0">
											<div class="th-inner ">操作</div>
											<div class="fht-cell"></div>
										</th>
									</tr>
								</thead>
								<tbody>
									<tr data-index="0">
										<td style="">附件列表</td>
										<td style="">客户影像资料-客户收入资料附件上传列表设置</td>
										<td class="l_cz2" style="">
											<div class="btn-group">
												<div class="btn btn-white" id="attach_edit">
													<i class="fa fa-edit"></i><span>编辑</span>
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
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
  <script type="text/javascript" src="${ctx}/static/pagejs/system/params/paramsEdit.js${timeStyle}"></script>

</body>
</html>