$(function () {
	var $table = $('#dept_table');
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
			        },deptPhone:{
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
	});

});