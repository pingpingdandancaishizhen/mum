
var tree = null;
	
function initTree(){
	worf.ajax({
 		url : ctx+'/system/dept/queryAllAvailableDept',
 		type : 'get',
 		success : function(data) {
 			if(data.status==1){
 				tree = $('#tree').treeview({
 					 data: formatTreeDataRoot(data.data),
 					 levels : 5,
 					 showTags :true
 				 });
 				$('#tree').on('nodeSelected', function(event, data) {
				  $("#displayDeptName").html(data.text);
				  $("#displayDeptShortName").html(data.deptShortName);
				});
 			}else{
 				$.alert(data.message);
 			}
 		},
 		error : function(){
 		}
 	});
};
	
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
	
	initTree();
	
	$("#deptModal #saveCorpUserBtn").bind("click",function(){
		var node = $('#tree').treeview('getSelected');
		if(node.length === 0 ){
			$.alert("请先选择部门");
			return ;
		} else {
			if($("#addCorpUserModal:visible")){
				$("#addCorpUserModal #deptId").val(node[0].id);
				$("#addCorpUserModal #deptName").val(node[0].text).trigger('change');
			}
			if($("#modifyCorpUserModal:visible")){
				$("#modifyCorpUserModal #deptId").val(node[0].id);
				$("#modifyCorpUserModal #deptName").val(node[0].text).trigger('change');
			}
			var $deptModal = $("#deptModal");
			$deptModal.modal("hide");
		}
	});
	
});