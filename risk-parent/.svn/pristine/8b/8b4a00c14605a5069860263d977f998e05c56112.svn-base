<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程上传</title>

</head>
<body style="padding: 30px">
	<table>	<thead>
	 	<td>getId||</td><td>getVersion||</td><td>getName||</td><td>getKey||</td><td>getDeploymentId||</td>
	 	</thead>
	
	 <c:forEach items="${list}" var="x">
	 	<tr>
	 	<td>${x.id}   || </td><td>${x.version}  || </td><td>${x.name}  ||</td><td>${x.key}||</td><td>${x.deploymentId}||</td>
	 	<td> <input type="button" onclick="startx('${x.id}')" value="启动流程"/>||</td>
	 	</tr>
	 
	 </c:forEach>
	</table>
	 
	<script type="text/javascript">
	function startx(pdid){
		window.location.href="${pageContext.request.contextPath}/web/activiti/next?processDefinitionId="+encodeURIComponent(pdid);
	}
	</script>
	 
</body>
</html>