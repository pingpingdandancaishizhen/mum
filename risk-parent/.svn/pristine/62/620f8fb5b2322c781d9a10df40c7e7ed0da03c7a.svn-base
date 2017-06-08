$(function () {
	var $table = $('#dept_table');
	
	(function initNodeSelectModal(){
		worf.ajax({
			url : web_root+'/system/dept/loadNodeSelect',
			type : 'get',
			success : function(data) {
				var htm =createTableHtml(data.data);
				$("#nodeSelectAddModal .box-body").empty();
				$("#nodeSelectAddModal .box-body").append(htm);
			}
		});
	})();
	
	
	$("#nodeSelectedAdd").on("click",function(){
		$('#nodeSelectAddModal').showModal();
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
	
	$("#add_dept_btn").on("click",function(){
		var node = $table.bootstrapTable('getSelections');
		if(node.length === 0){
			$.alert("添加部门前,请先选择父级部门");
			return ;
		} else if(node.length === 1 && node[0].status == "1"){
			$.alert("该部门处于禁用状态,无法添加部门");
			return ;
		} else if(node.length === 1 && node[0].level == "5"){
			$.alert("该部门为第五级部门,无法新增部门");
			return ;
		} else if(node.length === 1 && node[0].status == "0"){
			$("#addCorpDeptModal #deptAddrArea").empty();
			$("#addCorpDeptModal #deptAddrArea").html('<input type="text" class="form-control" id="deptAddr" name="deptAddr" readonly="readonly">');
			worf.ajax({
				url : web_root+'/district/info',
				type : 'get',
				success : function(data) {
					$('#addCorpDeptModal #deptAddr').citypicker({simple:true,data:data.data});
				}
			});
			$('#addCorpDeptModal').showModal();
			var $form=$('#addCorpDeptModal').find('form');
			$form.resetForm();
            $form.validate({
			    	deptName:{
						validators: {
				   			notEmpty: {
				      			message: '请输入机构名称'
				    		},
				    		regexp:{
								regexp :/^[\u4e00-\u9fa5a-zA-Z]{2,20}$/,
								message: '请输入2-20个中英文字符'
							}
						}
					},
					deptShortName: {
			            validators: {
			                notEmpty: {
			                    message: '请输入机构简称'
			                },
			              	regexp:{
						regexp :/^[\u4e00-\u9fa5a-zA-Z]{2,10}$/,
						message: '请输入2-10个中英文字符'
					}
			            }
			        },
			        level:{
			 			validators: {
			   				notEmpty: {
				          		message: '请选择级别'
				    		}
						}
			        },
			        parentCode:{
			 			validators: {
			   				notEmpty: {
				          		message: '请选择上级管理机构'
				    		}
						}
			        },
			        deptHead: {
			            validators: {
			            	regexp:{
								regexp :/^[\u4e00-\u9fa5a-zA-Z]{2,10}$/,
								message: '请输入2-10个中英文字符'
							}
			            }
			        },
			        deptPhone:{
	                   validators: {
	                       regexp: {
	                       	regexp: /^[0-9-]{0,12}$/,
	                           message: '请输入手机号码或座机号'
	                       }
	                   }
	               }
			});
			$form.off().on('success.form.bv', function(e) {//点击提交之后
				e.preventDefault();
		        //提交服务器
		        $("#addCorpDeptModal #addCorpDeptForm").btnAjaxSubmit({
		        	success:function(data){
		        		if(data.status == 1){
		        			$.showPop(data.message,"",2000);
		        			$("#addCorpDeptModal #addCorpDeptForm").resetForm();
		        			var $addCorpDeptModal = $("#addCorpDeptModal");
		        			$addCorpDeptModal.modal("hide");
					        $('#dept_table').bootstrapTable('refresh')
		        		}else{
		        			$.showPop(data.message,"",2000);
		        		}
		        	}
		        });
			});
			node = node[0];
			var $addCorpDeptModal = $("#addCorpDeptModal");
			var maxIndex = 5;
			var lvlMap = ['一级','二级','三级','四级','五级'];
			$('#addCorpDeptModal #level option').remove();
			for(var index = node.level + 1 ; index <= maxIndex ; index++ ){
				$('#addCorpDeptModal #level').append('<option value="'+ index +'">'+ lvlMap[(index-1)] +'</option>');
			}
			$('#addCorpDeptModal #parentCode option:not(:first)').remove();
			$('#addCorpDeptModal #parentCode option:first').after('<option value="'+ node.deptCode +'">'+ node.deptName +'</option>');
			$('#addCorpDeptModal #parentCode').val(node.deptCode);
		}

		$("#addCorpDeptModal #saveCorpDeptBtn").off().on('click',function(){
			var bootstrapValidator=$form.data('bootstrapValidator');
			bootstrapValidator.validate();
		});
		
		$("#selectNodeAddBtn").on("click",function(){
			var htm = "";
			var productName = "";
			var nodeArr = [];
			// 页面效果遍历
			$.each($("#nodeSelectAddModal input:checked"),function(index,value){
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
			$("#nodeResultAdd").empty();
			$("#nodeResultAdd").append(htm);
			$('#nodeSelectAddModal').hideModal();
			// 创建提交内容遍历
			$("#nodeHiddenInputAdd").empty();
			var hiddenInput = "";
			$.each($("#nodeSelectAddModal input:checked"),function(index,value){
				hiddenInput = '<input type="hidden" value="'+$(value).attr("data-bpDefId")+'" name="node['+index+'].bpDefId"/>';
				hiddenInput += '<input type="hidden" value="'+$(value).val()+'" name="node['+index+'].nodeId"/>';
				$("#nodeHiddenInputAdd").append(hiddenInput);
			});
		});
	});

});