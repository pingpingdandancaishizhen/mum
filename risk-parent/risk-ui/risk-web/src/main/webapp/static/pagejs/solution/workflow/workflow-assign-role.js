var $table1 = $("#workflow_assign_table");
function showAssignRole(row){
	//获取所有FORM
	$('#assignRoleModal').showModal();
	$('#assignRoleModal #bpDefId').val(row.bpDefId);
	$('#assignRoleModal #nodeId').val(row.nodeId);
	$table1.bootstrapTable('refresh');
	
	$("#assignRoleModal #add_assign_btn").click(function(){
		$('#addAssignModal #bpDefId').val(row.bpDefId);
		$('#addAssignModal #nodeId').val(row.nodeId);
		showAddAssignRole(row);
	});
}

function requestData1(params) {
	var params = {
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#searchbar1').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#searchbar1').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}

function showAddAssignRole(row){
	$('#addAssignModal').showModal();
	//初始化数据
	$("#addAssignModal #assignType").val('0');
	$("#addAssignModal #relateGroup").val('');
	// $("#addAssignModal #relateType").val('1');
	$("#addAssignModal #relateType").find("option[value='1']").prop('selected',true).trigger('change');
	$("#addAssignModal #relateName").val('发起人');
	$("#addAssignModal #relateIds").empty();
	$("#addAssignModal #relateIds").append('<option value="发起人" selected="selected">发起人</option>');
	$("#addAssignModal #assignType").change(function(){
		var vv = $(this).val();
		if(vv == '0'){
			$("#addAssignModal #relateIds").empty();
			$("#addAssignModal #relateIds").append('<option value="发起人" selected="selected">发起人</option>');
			$("#addAssignModal #relateName").val('发起人');
		}else if(vv == '1'){
			//获取功能角色
			worf.getAllRole(function (data) {
				$("#addAssignModal #relateIds").empty();
	            $.each(data.data,function(i,value){
	            	$("#addAssignModal #relateIds").append('<option value="'+value.id+'" >'+value.roleName+'</option>');
	            });
	        });
		}
	});
	
	var $form=$('#addAssignModal').find('form');
    $form.resetForm();
    $form.validate({
    	relateIds:{
            validators: {
                notEmpty: {
                    message: '请选择分配值'
                }
            }
        },
        relateGroup:{
        	 validators: {
                 notEmpty: {
                     message: '请填写分配组'
                 },
                 integer:{
                	 message: '请输入整数值'
                 }
             }
        }
    });
    // 先注册监听表单验证成功事件==》验证表单
    $form.off().on('success.form.bv',function () {
    	//获取值丢到relateName中
    	var relatename = [];
    	var relateid = [];
    	$.each($("#addAssignModal #relateIds option:selected"),function(i,value){
    		relatename.push($(this).text());
    		relateid.push($(this).val());
    	});
    	$("#addAssignModal #relateName").val(relatename.join(','));
    	$("#addAssignModal #relateId").val(relateid.join(','));
        //提交服务器
        $("#addAssignModal #addAssignForm").btnAjaxSubmit({
            success:function(data){
            	$table1.bootstrapTable('refresh');
                $('#addAssignModal').hideModal();
                $.showPop('新增分配规则成功');
            }
        });
    });
    // 绑定提交按钮
    $("#addAssignModal #saveAssignBtn").off().on('click',function () {
        var bootstrapValidator=$form.data('bootstrapValidator');
        bootstrapValidator.validate();

    })
}
 
function operateFormatter1(){
	return '<shiro:hasPermission name="workflow:deleteNode"><div class="btn-group" ><div class="btn btn-white" id="o_assign_delete"><span>删除</span></div></div></shiro:hasPermission>';
}

window.operateEvents1 = {
		'click #o_assign_delete' : function(e, value, row) {
			$.confirm({
			    title: '',
			    content: "确定要删除该分配规则吗？",
			    confirm: function(){
			    	worf.ajax({
			    		url : web_root+'/solution/workflow/deleteNodeAssign',
			    		type : 'post',
			    		data : {bpDefId:row.bpDefId,nodeId:row.nodeId,assignId:row.assignId},
			    		success : function(data) {
			    			if(data.status==1){
			    				$table1.bootstrapTable('refresh');
			    			}else{
			    				$.alert(data.message);
			    			}
			    		},
			    		error : function(){
			    		}
			    	});
			    },
			});
		}
};