<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>流程上传</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body style="padding: 30px">
	<form onsubmit="return false;"  class="form-horizontal" id="form1">
		<div class="form-inline" role="form" aria-label="..." style="margin-left: 50px">
			<div class="row">
	        <div class="form-group" >
	            <span class="xs-hide">文件：</span>
	            <input type="text" name="name" class="form-control"  >
	        </div>
	        </div>
	         <div class="row">
	        <div class="form-group " >
	            <span class="xs-hide">文件：</span>
	            <input type="file" name="file" class="form-control"  >
	        </div>
	        </div>
	        <div class="row">
	        <div class="form-group"  style="margin-left: 30px">
	            <div type="button" class="btn btn-default " id="btnSearch"><i class=" glyphicon glyphicon-search"></i>搜索</div>
	        </div>
	        </div>
    	</div>
	</form>

	<script type="text/javascript">
	
	$("#btnSearch").click(function(){
		var formData = new FormData($("#form1")[0]);
		$.ajax({
	      	type:'post',
	      	url:'${pageContext.request.contextPath}/web/activiti/deploy',
	      	data:formData,
	      	cache: false, 
			contentType: false, 
			processData: false, 
	      	success:function(data){
	      		if(data && data.status == -1 ){
	      			worf.dialog.info(data.message,1500);
	      		} else {
	          		worf.dialog.info("保存成功！",1500);
	      		}
	      	},
	      	error:function(){
	      		alert("内部服务器错误！");
	      	}
	    }); 
	});
	</script>
</body>
</html>