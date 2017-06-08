$(function(){
	$("#view_temp_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请先选择合同模板");
		} else {
			$("#viewContractTemplateModal").showModal();
			worf.ajax({
				url : web_root+"/contract/template/getTemplateView",
		 		type : 'get',
		 		data : {
		 			tempId : selected[0].id
				},
		 		success : function(data) {
		 			if(data.status==1){
		 				$("#product-view").val(data.data.ct.product);
		 				$("#templateName-view").html(data.data.ct.templateName);
		 				$("#templateDesc-view").html(data.data.ct.templateDesc);
		 				if(data.data.ct.mainFlag === '1'){
		 					$("#mainFlag-view").html('是');
		 				}else{
		 					$("#mainFlag-view").html('否');
		 				}
		 				$("#file-view").html('<a href="'+web_root+'/getResourceById?resourceId='+data.data.ct.fileResource+'" target="_blank">'+data.data.ct.fileName+'</a>');
		 				$("#partner-view").html('');
					    var partnerHtml='';
		 				$.each(data.data.ct.partnerList,function(i,partner){
						    partnerHtml+='<div class="input-group">';
						    partnerHtml+='<label class="label-head " >'+getRoleName(data.data.roleList,partner.role)+':'+'</label>';
						    partnerHtml+='<div class="label-box col-sm-12">';
						    partnerHtml+='<label  class="label-box-item">'+
							    '<input type="checkbox"  checked/>'+partner.name+
							    '</label>';
						    partnerHtml+='</div></div>';
		 				});
					    $("#partner-view").html(partnerHtml);

					    var configViewHtml='';
					    configViewHtml+='<thead><tr><th>合同标签</th><th>所属模块</th><th>系统字段</th></tr></thead><tbody>';
		 				if(data.data.selectRelList && data.data.selectRelList.length > 0){
			 				$.each(data.data.selectRelList,function(i,rel){
			 					configViewHtml+='<tr><td>'+rel.tempField+'</td><td>'+getCategoryByKey(data.data.dataFields,rel.dataField)+'</td><td>'+getNameByKey(data.data.dataFields,rel.dataField)+'</td></tr>'
			 				});
		 				}else{
		 					configViewHtml+='<tr><td colspan="3" align="center">暂无配置数据</td></tr>';
		 				}
		 				configViewHtml+='</tbody>';
					    $('#config-view').html(configViewHtml);
		 			}else{
		 				$.showPop(data.message,"",2000);
		 			}
		 		}
			});
			
		}
	});
});

function getCategoryByKey(contractFieldList,fieldKey){
	var result = '';
	$.each(contractFieldList,function(i,category){
		$.each(category.fields,function(j,field){
			if(field.key == fieldKey){
				result = category.category;
				return false;
			}
		});
	});
	return result;
}

function getNameByKey(contractFieldList,fieldKey){
	var result = '';
	$.each(contractFieldList,function(i,category){
		$.each(category.fields,function(j,field){
			if(field.key == fieldKey){
				result = field.name;
				return false;
			}
		});
	});
	return result;
}

function getRoleName(roleList,roleKey){
	var result = '';
	$.each(roleList,function(i,role){
		if(role.id == roleKey){
			result = role.name;
			return false;
		}
	});
	return result;
}