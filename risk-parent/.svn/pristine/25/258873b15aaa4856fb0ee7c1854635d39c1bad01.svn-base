$(function(){
	$("#cfg_temp_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请先选择合同模板");
		} else {
			$("#cfgContractTemplateModal").showModal();
			$("#tempId").val(selected[0].id);
			worf.ajax({
				url : web_root+"/contract/template/getTempFields",
		 		type : 'get',
		 		data : {
		 			tempId : selected[0].id
				},
		 		success : function(data) {
		 			if(data.status==1){
		 				var tableHtml='<thead><tr><th width="30%">合同字段</th><th colspan=2>系统字段</th></tr></thead><tbody>';
		 				$.each(data.data.tempFields,function(i,tfield){
		 					var options = [];
			 				options.push('<option value="">请选择</option>');
			 				$.each(data.data.dataFields,function(j,category){
			 					options.push('<optgroup label="'+category.category+'">');
			 					$.each(category.fields,function(k,dfield){
			 						var flag = false;
			 						$.each(data.data.selectRelList,function(j,selRel){
				 						if(tfield === selRel.tempField && selRel.dataField === dfield.key){
				 							flag = true;
				 							return false;
				 						}
				 					});
			 						if(flag){
			 							options.push('<option value="'+dfield.key+'" selected="selected">'+category.category+'-'+dfield.name+'</option>');
			 						}else{
			 							options.push('<option value="'+dfield.key+'">'+category.category+'-'+dfield.name+'</option>');
			 						}
			 					});
			 					options.push('</optgroup>');
			 				});
		 					var htm = '<tr><td>'+tfield+'<input type="hidden" name="tempFields" value="'+tfield+'"></td>'+
		 								'<td width="35%">'+
	 									'<select class="form-control" name="dataFields">'+
	 									options.join('')+'</select></td></tr>';
						    tableHtml+=htm;
		 				});
					    tableHtml+='</tbody>';
					    $('#field_table').html(tableHtml);
		 			}else{
		 				$.showPop(data.message,"",2000);
		 			}
		 		}
			});
			
			// 注册验证
	        $form=$('#cfgContractTemplateModal').find('form');
	        $form.resetForm();
	        
	        $form.validate({
	        });
	    	// 先注册监听表单验证成功事件==》验证表单
			$form.off().on('success.form.bv',function () {
		        //提交服务器
		        $("#cfgContractTemplateModal #cfgContractTemplateForm").btnAjaxSubmit({
		            success:function(data){
		                $table.bootstrapTable('refresh');
		                $form.data('bootstrapValidator').resetForm();
		                $form.resetForm();
		                $('#cfgContractTemplateModal').hideModal();
		                $.showPop('保存合同模板字段成功');
		            }
		        });
		    });
		}
	});
	$("#cfgContractTemplateModal #saveFieldBtn").bind("click",function(){
		 $('#cfgContractTemplateModal #cfgContractTemplateForm').submit();
	});
})