
var $table = $("#myLoan_table");
$(function(){

	$("#myLoan_assign_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择要分配的单据");
		}else{
			//弹出分配人员审核 获取有该数据权限的人
			$('#assignModal #bpId').val(selected[0]['bpId']);
			worf.ajax({
				url : web_root+'/system/user/sameDeptBPList',
				type : 'post',
				data : {
					'bpId':$('#assignModal #bpId').val()
				},
				success : function(data) {
					var list = data.data;
					$('#assignModal #assignId').empty();
					$.each(list,function(i,v){
						$('#assignModal #assignId').append('<option value="'+v.id+'">'+v.userName+'</option>');
					});
				}
			});
			$('#assignModal').showModal();
		}
		
	});
	$("#assignModal #assignBtn").off().on('click',function () {
		//查询是否有正在进行的单子
		worf.ajax({
			url : web_root+'/loanApply/assign',
			type : 'post',
			data : {
				'bpId':$('#assignModal #bpId').val(),
				'assignId':$('#assignModal #assignId').val()
			},
			success : function(data) {
				if(data.status==1){
					$('#assignModal').hideModal();
					$table.bootstrapTable('refresh');
				}else{
					$.alert('分配失败');
				}

			}
		});
		//跳转页面
		//window.location.href=web_root+'/system/customer/loadApplyLoan?productId='+$("#selectProductModal #productId").val();
	})
	
	
});
