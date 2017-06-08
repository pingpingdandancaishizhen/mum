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
	 <form onsubmit="return false;"  action="${pageContext.request.contextPath}/web/activiti/sub" method="post">
	 	<input type="text" name="processInstanceId" value="${vo.processInstanceId}"/>
	 	<input type="text" name="processDefinitionId" value="${vo.processDefinitionId}"/>
	 	<input type="text" name="taskId" value="${vo.taskId}"/>
	 	${vo.renderedTaskForm}
	 	
	 	
	 	<input type="submit" value="下一步"/>
	 </form>
	 
</body>
</html>