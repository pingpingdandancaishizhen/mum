
function toViewUser(row){
	$('#viewCorpUserModal').showModal();
	$.when(
		worf.getAllDataRole()
		,getUserDetail(row)).done(function (v1,v2) {
		var data=v2[0];
		var allDataRole=v1[0];
		var dataRoles=allDataRole.data;
		var tempDataRoles={};
		$.each(dataRoles,function (k, item) {
			tempDataRoles[item.id]=item;
		})
		if(data.status==1){
			var user = data.data;
			$('#viewCorpUserModal #id').val(user.id);
			$('#viewCorpUserModal #userAccount').val(user.userAccount);
			$('#viewCorpUserModal #userName').val(user.userName);
			$('#viewCorpUserModal #email').val(user.email);
			$('#viewCorpUserModal #desc').val(user.desc);
			$('#viewCorpUserModal #idcard').val(user.idcard);
			$('#viewCorpUserModal #telephone').val(user.telephone);
			$('#viewCorpUserModal #job').val(user.job);
			$('#viewCorpUserModal #deptId').val(user.deptId);
			$('#viewCorpUserModal #deptName').val(user.deptName);
			var roleHtml=[];
			var roleNames=user.roleNames||'';
			var userRoles=roleNames.split(',');
			$.each(userRoles,function(i,value){
				var htm = '<label class="label-box-item" >'+
					value+
					'</label>';
				roleHtml.push(htm);
			});
			$("#viewCorpUserModal #roles").html(roleHtml.join(''));
			var dataRoleHtml=[];
			$.each(user.dataRoleIds,function(i,value){
				var htm = '<label class="label-box-item">'+
					tempDataRoles[value].roleName+
					'</label>';
				dataRoleHtml.push(htm);
			});
			$("#viewCorpUserModal #dataRoles").html(dataRoleHtml.join(''));
		}
	});
}

//获取修改员工的详情
function getUserDetail(row) {
	return worf.ajax({
		url : web_root+'/system/user/getUserById',
		type : 'post',
		data : {userId:row.id},
		success : function(data) {
		}
	});
}