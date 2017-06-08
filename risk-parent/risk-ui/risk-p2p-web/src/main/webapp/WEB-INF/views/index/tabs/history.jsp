<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tab-pane" id="loginhistory">
   <table class="table  table-striped table-hover table-responsive" id="loginhistory_table" data-toggle="table"
				data-url="${ctx}/index/loghistory"
				data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
				data-query-params="requestData" data-query-params-type=""
				data-page-number=1 data-page-size=5 
				data-response-handler="responseData" data-side-pagination="server"
				data-pagination="true" data-page-list="[5, 10, 20]">
					<thead>
						<tr>
							<th data-field="createTimeStr">登录时间</th>
							<th data-field="ip">登录IP</th>
							<th data-field="address">登录地点</th>
							<th data-field="channelStr">登录类型</th>
						</tr>
					</thead>
	</table>
	
</div>