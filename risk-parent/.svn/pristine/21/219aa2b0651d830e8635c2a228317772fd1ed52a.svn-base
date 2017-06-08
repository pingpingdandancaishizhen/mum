<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<div class="modal" id="assignRoleModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">分配规则</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
					<div class="panel panel-default"  id="searchbar1"  style="display:none">
					<div class="panel-heading">搜索条件</div>
					<div class="panel-body">
						<form onsubmit="return false;"  class="form-inline" role="form">
							<div class="form-group">
								<input type="hidden" name="bpDefId"  value="${bpDefId}"/>
								<input type="hidden" name="nodeId" id="nodeId" value=""/>
							</div>
						</form>
					</div>
				</div>
				<div class="table-top-tool">
				<shiro:hasPermission name="workflow:addNode">
						<div class="btn btn-primary btn-primary-lg" id="add_assign_btn">
							<i class="icon icon-plus"></i>
							<span>新增规则</span>
						</div>
				</shiro:hasPermission>
				</div>
              <table class="table  table-striped table-hover table-responsive" id="workflow_assign_table" data-toggle="table"
				data-url="${ctx}/solution/p2pworkflow/queryNodeAssignList"
				data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				data-query-params="requestData1" data-query-params-type=""
				data-page-number=1 data-page-size=20
				data-response-handler="responseData" data-side-pagination="server"
				data-pagination="true" data-page-list="[5, 10, 20]">
					<thead>
						<tr>
						    <th data-field="assignTypeStr">分配类型</th>
						    <th data-field="relateName">分配名称</th>
						    <th data-field="relateTypeStr">分配关系</th>
						    <th data-field="relateGroup">关系排序</th>
							<th data-formatter="operateFormatter1" data-events="operateEvents1" class="l_cz2" >操作</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-default" data-dismiss="modal">关闭</div>
		</div>
	</div>
	</div>
</div>


<div class="modal" id="addAssignModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增分配规则</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-inline form-label-auto" id="addAssignForm" action="${ctx}/solution/p2pworkflow/addNodeAssign" method="post">
					<div class="form-group col-sm-12">
						<div class="input-group">
							<label for="assignType" class="label-head label-head-top label-head-lg"><span class="require">分配类型：</span></label>
							<input type="hidden" name="bpDefId"  value="${bpDefId}"/>
							<input type="hidden" name="nodeId" id="nodeId" value=""/>
							<select id="assignType" name="assignType" class="form-control">
								<option value="0" selected>发起人</option>
								<option value="1">功能角色</option>
							</select>
						</div>

					</div>
					<div class="form-group col-sm-12">
						<div class="input-group">
							<label for="relateIds" class="label-head label-head-top label-head-lg"><span class="require">分配值：</span></label>
							<input type="hidden" name="relateName" id="relateName" value="发起人"/>
							<input type="hidden" name="relateId" id="relateId" value=""/>
							<select class="form-control" id="relateIds" name="relateIds" multiple="multiple">
								<option value="发起人">发起人</option>
							</select>
						</div>

					</div>
					<div class="form-group col-sm-12">
						<div class="input-group">
							<label for="relateType" class="label-head label-head-top label-head-lg"><span class="require">分配关系：</span></label>
							<select class="form-control" id="relateType" name="relateType">
								<option value="1" selected>并集</option>
								<option value="0">交集</option>
								<option value="2">非</option>
							</select>
						</div>

					</div>
					<div class="form-group col-sm-12">
						<div class="input-group">
							<label for="relateType" class="label-head label-head-lg"><span class="require">关系排序：</span></label>
							<input class="form-control" id="relateGroup" name="relateGroup" />
						</div>

					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="saveAssignBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
 <script type="text/javascript" src="${ctx}/static/pagejs/solution/p2pworkflow/workflow-assign-role.js"></script>