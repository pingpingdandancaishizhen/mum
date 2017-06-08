<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="modifyCorpDeptModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">编辑机构</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="modifyCorpDeptForm" action="${ctx}/system/dept/updateDept" method="post">
				 <div class="box-body">
						<div class="form-group">
							<label for="deptName" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>机构名称：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptName" name="deptName"  maxlength="20">
								<input type="hidden" class="form-control" id="id" name="id" >
								<input type="hidden" class="form-control" id="deptCode" name="deptCode" >
							</div>
						</div>
						<div class="form-group">
							<label for="deptShortName" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>机构简称：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptShortName" name="deptShortName"  maxlength="10">
							</div>
						</div>
						<div class="form-group">
							<label for="level" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>机构级别：</label>
							<div class="col-sm-8">
								<select  class="form-control" id="level" name="level">
									<option value="1">一级</option>
									<option value="2">二级</option>
									<option value="3">三级</option>
									<option value="4">四级</option>
									<option value="5">五级</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="parentCode" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>上级管理机构：</label>
							<div class="col-sm-8">
								<select  class="form-control" id="parentCode" name="parentCode" default-data="">
									<option value="">请选择</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="dept" class="col-sm-2 control-label">机构性质：</label>
							<div class="col-sm-8">
								<select  class="form-control" id="deptType" name="deptType">
									<option value="">请选择</option>
									<option value="1">营业门店</option>
									<option value="2">审批机构</option>
									<option value="3">管理机构</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="roleId" class="col-sm-2 control-label">机构负责人：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptHead" name="deptHead" maxlength="10">
							</div>
						</div>
						<div class="form-group">
							<label for="job" class="col-sm-2 control-label">机构联系电话：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptPhone" name="deptPhone" maxlength="12">
							</div>
						</div>
						<div class="form-group">
							<label for="deptAddr" class="col-sm-2 control-label">机构地址：</label>
							<div class="col-sm-8" id="deptAddrArea">
								<input type="text" class="form-control" id="deptAddr" name="deptAddr" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label for="deptAddrDetail" class="col-sm-2 control-label">机构详细地址：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="deptAddrDetail" name="deptAddrDetail">
							</div>
						</div>
						<div class="form-group">
							<label for="nodeSelected" class="col-sm-2 control-label">机构流程权限：</label>
							<div class="col-sm-8">
								<div class="btn btn-white" id="nodeSelectedEdit"><span>请选择</span></div>
								<div id="nodeResultEdit">
								</div>
								<div id="nodeHiddenInputEdit">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div class="btn btn-primary btn-primary-lg" id="saveCorpDeptBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	
	$('#modifyCorpDeptModal #level').on("change",function(){
		var level = $(this).val();
		//if(level > 1){
			loadAddableParentDept($(this).val());
		//}
	});
	
	function loadAddableParentDept(level,cb){
		$.ajax({
			url : '${ctx}/system/dept/queryAllAddableParentDept',
			type : 'post',
			data : {
				level : level
			},
			aysc:false,
			success : function(data) {
				if(data.status==1){
					var list = data.data;
					$('#modifyCorpDeptModal #parentCode option:not(:first)').remove()
					var parentCode = $('#modifyCorpDeptModal #parentCode').attr("default-data");
					for(var i in list){
//						console.info(list[i].level);
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
	
	
	 //获取公司所有角色
	 //$.ajax({
  	//	url : '${ctx}/system/role/queryAllRole',
  	//	type : 'post',
  	//	data : {},
  	//	aysc:false,
  	//	success : function(data) {
  	//		if(data.status==1){
  	//			$("#addCorpDeptModal #roles").empty();
  	//			$.each(data.data,function(i,value){
  	//				var htm = '<label class="btn btn-default">'+
     //              '<input type="checkbox" name="roleId" value="'+value.id+'" /> '+value.roleName+
	//                '</label>';
  	//				$("#addCorpDeptModal #roles").append(htm);
  	//			
  	//			});

  				$('#modifyCorpDeptModal #modifyCorpDeptForm').bootstrapValidator({
  				    message: 'This value is not valid',
  				    feedbackIcons: {        //提示图标
  				        valid: 'glyphicon glyphicon-ok',
  				        invalid: 'glyphicon glyphicon-remove',
  				        validating: 'glyphicon glyphicon-refresh'
  				    },
  				  fields: {
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
  		                },
				      	deptAddr: {
				            validators: {
				            	regexp:{
									regexp :/^[\u4e00-\u9fa5a-zA-Z0-9\/]{0,30}$/,
									message: '请输入0-30个中英文数字字符'
								}
				            }
				        }
				    },
  				    submitHandler: function (validator, form, submitButton) {
  				    
  				    }
  				}).on('success.form.bv', function(e) {//点击提交之后
  			        // Prevent form submission
  			        e.preventDefault();
  			        // Get the form instance
  			        var $form = $(e.target);
  			        // Get the BootstrapValidator instance
  			        var bv = $form.data('bootstrapValidator');
  			        //提交服务器
  			        $("#modifyCorpDeptModal #modifyCorpDeptForm").btnAjaxSubmit({
  			        	success:function(data){
  			        		if(data.status == 1){
  			        			$.showPop(data.message,"",2000);
  			        			$("#modifyCorpDeptModal #modifyCorpDeptForm").resetForm();
  			        			bv.resetForm();
  			        			var $modifyCorpDeptModal = $("#modifyCorpDeptModal");
  			        			$modifyCorpDeptModal.modal("hide");
								$('#dept_table').bootstrapTable('refresh')
  			        		}else{
  			        			$.showPop(data.message,"",2000);
  			        		}
  			        		
  			        	}
  			        });
  				});
  	//		}else{
  	//			$.alert(data.message);
  	//		}
  	//	},
  	//	error : function(){
  	//	}
	//});
	
	 $("#modifyCorpDeptModal #saveCorpDeptBtn").click(function(){
		 $('#modifyCorpDeptModal #modifyCorpDeptForm').submit();
	}); 
	
});
</script>