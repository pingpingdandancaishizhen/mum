
function toViewUser(row){
	$('#viewCorpUserModal').showModal();
	$.when(
		worf.getAllRole(function (data) {
		$("#viewCorpUserModal #roles").empty();
		$.each(data.data,function(i,value){
			var htm = '<label class="label-box-item" data-id="'+value.id +'">'+
				value.roleName+
				'</label>';
			$("#viewCorpUserModal #roles").append(htm);

		});
	})
	,worf.getAllDataRole(function (data) {
	            var roleHtml=[];
	            $.each(data.data,function(i,value){
	                var htm = '<label class="label-box-item"  data-id="'+value.id +'">'+
	                    value.roleName+
	                    '</label>';
	                roleHtml.push(htm);
	            });
	            $("#viewCorpUserModal #dataRoles").html(roleHtml.join(''));
	        })
	,getUserDetail(row)).done(function (v1,vdr,v2) {
		var data=v2[0];
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
			$.each(user.roleIds,function(i,value){
				$("#viewCorpUserModal #roles label[data-id='"+value+"']").addClass('active');
			});
			$.each(user.dataRoleIds,function(i,value){
				$("#viewCorpUserModal #dataRoles label[data-id='"+value+"']").addClass('active');
			});
			
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