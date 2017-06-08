<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tab-pane" id="notice">
	<div class="table-box">
		<table class="table  table-striped table-hover" id="notice_table" data-toggle="table"
			   data-url="${ctx}/system/notice/queryCorpNotice"  	data-unique-id="id"
			   data-method="post" data-cache="false"  data-content-type="application/x-www-form-urlencoded"
			   data-query-params="requestNoticeData" data-query-params-type=""
			   data-click-to-select="true"
			   data-page-number=1 data-page-size=5
			   data-response-handler="responseData" data-side-pagination="server"
			   data-pagination="true" data-page-list="[5, 10, 20]">
			<thead>
			<tr>
				<th data-field="artContent" data-formatter="noticeContentFormatter">公告内容</th>
				<th data-field="typeName">公告分类</th>
				<th data-field="artReviewerName">发布人</th>
				<th data-field="reviewTime" data-formatter="timeFormatter">发布时间</th>
			</tr>
			</thead>
		</table>
	</div>
</div>
<%@ include file="./modal/noticeDetail.jsp"%>
<script type="text/javascript" src="${ctx}/static/pagejs/index/notice.js${timeStyle}"></script>