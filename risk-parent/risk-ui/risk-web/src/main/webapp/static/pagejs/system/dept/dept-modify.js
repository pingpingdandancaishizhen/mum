$(function () {

	var $table = $('#dept_table');
	$("#edit_dept_btn").on("click",function(){
		var node = $table.bootstrapTable('getSelections');
		if(node.length === 1 && node[0].status == "1"){
			$.alert("该部门处于停用状态,无法修改");
			return ;
		} else if(node.length === 1 && node[0].status == "0"){
			var $modifyCorpDeptModal = $("#modifyCorpDeptModal");
			$modifyCorpDeptModal.modal("show");
			node = node[0];
			$("#modifyCorpDeptModal #id").val(node.id);
			$("#modifyCorpDeptModal #deptCode").val(node.deptCode);
			$("#modifyCorpDeptModal #deptName").val(node.deptName);
			$("#modifyCorpDeptModal #deptShortName").val(node.deptShortName);
			$("#modifyCorpDeptModal #level").val(node.level);
			$("#modifyCorpDeptModal #parentCode").val(node.parentCode);
			$("#modifyCorpDeptModal #deptType").val(node.deptType);
			$("#modifyCorpDeptModal #deptHead").val(node.deptHead);
			$("#modifyCorpDeptModal #deptPhone").val(node.deptPhone);
			$("#modifyCorpDeptModal #deptAddrArea").empty();
			$("#modifyCorpDeptModal #deptAddrArea").html('<input type="text" class="form-control" id="deptAddr" name="deptAddr" readonly="readonly">');
			$("#modifyCorpDeptModal #deptAddr").val(node.deptAddr);
			$("#modifyCorpDeptModal #deptAddrDetail").val(node.deptAddrDetail);
			worf.ajax({
				url : web_root+'/district/info',
				type : 'get',
				async:false,
				success : function(data) {
					$('#modifyCorpDeptModal #deptAddr').citypicker({simple:true,data:data.data},function(){
					});
				}
			});
			$("#modifyCorpDeptModal #parentCode").attr("default-data",node.deptCode);
			loadAddableParentDept(node.level,function(){
				if(node.level > 1){
					$('#modifyCorpDeptModal #parentCode').val(node.parentCode);
				}else{
					$('#modifyCorpDeptModal #parentCode').val(node.deptCode);
				}
			});
		} else {
			$.alert("请先选择公司");
		}
	});
	
	function loadAddableParentDept(level,cb){
		worf.ajax({
			url : ctx+'/system/dept/queryAllAddableParentDept',
			type : 'post',
			data : {
				level : level
			},
			aysc:false,
			success : function(data) {
				if(data.status==1){
					var list = data.data;
					$('#modifyCorpDeptModal #parentCode option:not(:first)').remove();
					var parentCode = $('#modifyCorpDeptModal #parentCode').attr("default-data");
					for(var i in list){
						if(list[i].deptCode !== parentCode || list[i].level == 1 ){
							$('#modifyCorpDeptModal #parentCode option:first').after('<option value="'+ list[i].deptCode +'">'+ list[i].deptName +'</option>');
						}
					}
					if(cb){
						cb();
					}
				}
			}
		});			
	}

});