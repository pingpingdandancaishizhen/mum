var tree = null;
	
//function initTree(){
//	worf.ajax({
// 		url : web_root+'/system/dept/queryAllAvailableDept',
// 		type : 'get',
// 		success : function(data) {
// 			if(data.status==1){
// 				tree = $('#depts').treeview({
// 					 data: formatTreeDataRoot(data.data),
// 					 levels : 5,
// 					 multiSelect : true,
// 					 showTags :true
// 				 });
// 				$('#tree').on('nodeSelected', function(event, data) {
//				  $("#displayDeptName").html(data.text);
//				  $("#displayDeptShortName").html(data.deptShortName);
//				});
// 			}else{
// 				$.alert(data.message);
// 			}
// 		},
// 		error : function(){
// 		}
// 	});
//};
	
function formatTreeDataRoot(treeData){
	var tree = [];
	if(treeData.nodes){
		tree.push({
			id : treeData.id,
			text :treeData.deptName,
			deptShortName :treeData.deptShortName,
			level :treeData.level,
			deptCode :treeData.deptCode,
			parentCode :treeData.parentCode,
			deptType :treeData.deptType,
			deptHead :treeData.deptHead,
			deptPhone :treeData.deptPhone,
			deptAddr :treeData.deptAddr,
			status :treeData.status,
			tags : ["level"+treeData.level],
			// 禁用部门 背景置灰
			backColor : (treeData.status == "1" )? "#bfbfbf" :"",
			nodes : formatTreeDataLeaf(treeData.nodes ,treeData.status)
		});
	} else {
		tree.push({
			id : treeData.id,
			text :treeData.deptName ,
			deptShortName :treeData.deptShortName,
			level :treeData.level,
			deptCode :treeData.deptCode,
			parentCode :treeData.parentCode,
			deptType :treeData.deptType,
			deptHead :treeData.deptHead,
			deptPhone :treeData.deptPhone,
			deptAddr :treeData.deptAddr,
			status :treeData.status,
			// 禁用部门 背景置灰
			backColor : (treeData.status == "1" )? "#bfbfbf" :"",
			tags : ["level"+treeData.level]
		});
	}
	function formatTreeDataLeaf(treeLeaf ,parentStatus) {
		var treeNodes = [];
		for( var i in treeLeaf){
			if(treeLeaf[i].nodes && treeLeaf[i].nodes.length > 0){
				treeNodes.push({
					id : treeLeaf[i].id,
					text :treeLeaf[i].deptName,
					deptShortName :treeLeaf[i].deptShortName,
					level :treeLeaf[i].level,
					deptCode :treeLeaf[i].deptCode,
					parentCode :treeLeaf[i].parentCode,
					deptType :treeLeaf[i].deptType,
					deptHead :treeLeaf[i].deptHead,
					deptPhone :treeLeaf[i].deptPhone,
					deptAddr :treeLeaf[i].deptAddr,
					status :treeLeaf[i].status,
					tags : ["level"+treeLeaf[i].level],
					backColor : (treeLeaf[i].status == "1" )? "#bfbfbf" :"",
					selectable : (parentStatus == "1" )? false :true,
					nodes : formatTreeDataLeaf(treeLeaf[i].nodes ,treeLeaf[i].status)
				});
			} else {
				treeNodes.push({
					id : treeLeaf[i].id,
					text :treeLeaf[i].deptName,
					deptShortName :treeLeaf[i].deptShortName,
					level :treeLeaf[i].level,
					deptCode :treeLeaf[i].deptCode,
					parentCode :treeLeaf[i].parentCode,
					deptType :treeLeaf[i].deptType,
					deptHead :treeLeaf[i].deptHead,
					deptPhone :treeLeaf[i].deptPhone,
					deptAddr :treeLeaf[i].deptAddr,
					status :treeLeaf[i].status,
					backColor : (treeLeaf[i].status == "1" )? "#bfbfbf" :"",
					selectable : (parentStatus == "1" )? false :true,
					tags : ["level"+treeLeaf[i].level]
				});
			}
		}
		return treeNodes;
	}
	return tree;
}

$(function () { 
	$("#add_role_btn").click(function(){
		var $addRoleModal = $("#addRoleModal");
		$('#addRoleModal #deptStr').val("");
		$addRoleModal.showModal();
		$("#addRoleModal #validate_dept").hide();
		$.when(worf.getAllDepts(function (data) {
			if(data.status==1){
 				/*tree = $('#addRoleModal #depts').treeview({
 					 data: formatTreeDataRoot(data.data),
 					 levels : 5,
 					 multiSelect : true,
 					 showTags :true
 				 });
 				$('#addRoleModal #depts').on('nodeSelected', function(event, data) {
 					var node = $('#addRoleModal #depts').treeview("getSelected");
 					var depts = [];
 					for(var i in node){
 						depts.push(node[i].id);
 					}
 					$("#addRoleModal #deptStr").val(depts.join(","));
				});
 				$('#addRoleModal #depts').on('nodeUnselected', function(event, data) {
 					var node = $('#addRoleModal #depts').treeview("getSelected");
 					var depts = [];
 					for(var i in node){
 						depts.push(node[i].id);
 					}
 					$("#addRoleModal #deptStr").val(depts.join(","));
				});*/
 			treeTableHtml('#addRoleModal',data.data,function (depts) {
			    $("#addRoleModal #deptStr").val(depts.join(","));
		    })
 			}else{
 				$.alert(data.message);
 			}
		}).done(function(){
			var $form=$('#addRoleModal').find('form');
			$form.resetForm();
			$form.validate({
				roleName:{
					validators: {
						notEmpty: {
							message: '请输入角色名'
						},regexp:{
							regexp :/^[\u4e00-\u9fa5a-zA-Z]{2,20}$/,
							message: '请输入2-20个中英文个字符'
						}
					}
				},
				desc: {
					message: '角色描述校验失败',
					validators: {
						stringLength: {
							min: 0,
							max: 60,
							message: '请输入0-60个字符'
						}
					}
				},
				selfOnly : {
					notEmpty: {
						message: '请选择'
					}
				}
			});

			$form.off().on('success.form.bv',function () {
				var depts = $("#addRoleModal #deptStr").val();
				if($("#addRoleModal #selfOnly").is(":checked") || $("#addRoleModal #deptOnly").is(":checked")){
					// do nothing
				}else {
					if(depts == ""){
						$("#addRoleModal #validate_dept").show();
						return;
					} else {
						$("#addRoleModal #validate_dept").hide();
					}
				}
				//提交服务器封装MENUID 和 roleid
				$form.btnAjaxSubmit({
					success:function () {
						$table.bootstrapTable('refresh');
						$('#addRoleModal').hideModal();
						worf.clearAllRole();
						$.showPop('新增数据角色成功');
					}
				});
			});
			
			$("#addRoleModal #saveRoleBtn").off().on('click',function(){
				var bootstrapValidator=$form.data('bootstrapValidator');
				bootstrapValidator.validate();
			});
			
		}));
	});
	
});
