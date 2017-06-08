$(function () {

	var $table = $('#dept_table');
	
	var allNodes = [];
	(function initNodeSelectModal(){
		worf.ajax({
			url : web_root+'/system/dept/loadNodeSelect',
			type : 'get',
			success : function(data) {
				allNodes = data.data;
				var htm =createTableHtml(data.data);
				$("#nodeSelectEditModal .box-body").empty();
				$("#nodeSelectEditModal .box-body").append(htm);
			}
		});
	})();
	
	
	$("#nodeSelectedEdit").on("click",function(){
		$('#nodeSelectEditModal').showModal();
	});
	
	function createTableHtml(data){
		var table = $("<table class='table table-bordered'></table>");
		//获取流程中 节点 创建二级选项
		function createFuncHtml(nodes ,productName){
			var nodeshtm = '';
			$.each(nodes,function(i,value){
				nodeshtm+='<label class="label-box-item">'+
				'<input type="checkbox" data-product="'+productName+'" data-nodeName="'+value.nodeName+'" data-bpDefId="'+value.bpDefId+'" value="'+value.nodeId+'" /> <span>'+
				value.nodeName+'</span></label>';
			});
			return nodeshtm;
		}
		//取出流程作为一级
		$.each(data,function(i,value){
			var first = $("<tr>");
			first.append("<td colspan='2'>" +
					"<label class='label-box-item'>" +
							"<span>"+value.productName+"</span>" +
					"</label>" +
					"</td><td>" +
					createFuncHtml(value.bpMetaNodes,value.productName)+
					"</td>");
			table.append(first);
		});
		return table;
	}
	
	
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
			$("#nodeSelectEditModal input").removeAttr("checked");
			worf.ajax({
				url : web_root+'/system/dept/queryDeptMetaNode?deptId='+node.id,
				type : 'get',
				async:false,
				success : function(data) {
					$.each(data.data,function(i,val){
						$("#nodeSelectEditModal input[value='"+ val.nodeId +"']").attr("checked",true).prop("checked",true);
					});
					sumbitEditNodeEvent();
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

	function sumbitEditNodeEvent(){
		var htm = "";
		var productName = "";
		var nodeArr = [];
		// 页面效果遍历
		$.each($("#nodeSelectEditModal input:checked"),function(index,value){
			if( productName != $(value).attr("data-product")){
				htm += nodeArr.join("/") +"</br>";
				nodeArr = [];
				nodeArr.push($(value).attr("data-nodeName"));
				productName = $(value).attr("data-product");
				htm += productName+":";
			} else {
				nodeArr.push($(value).attr("data-nodeName"));
			}
		});
		htm += nodeArr.join("/");
		$("#nodeResultEdit").empty();
		$("#nodeResultEdit").append(htm);
		$('#nodeSelectEditModal').hideModal();
		// 创建提交内容遍历
		$("#nodeHiddenInputEdit").empty();
		var hiddenInput = "";
		$.each($("#nodeSelectEditModal input:checked"),function(index,value){
			hiddenInput = '<input type="hidden" value="'+$(value).attr("data-bpDefId")+'" name="node['+index+'].bpDefId"/>';
			hiddenInput += '<input type="hidden" value="'+$(value).val()+'" name="node['+index+'].nodeId"/>';
			$("#nodeHiddenInputEdit").append(hiddenInput);
		});
	}
	
	$("#selectNodeEditBtn").on("click",function(){
		sumbitEditNodeEvent();
	});
});