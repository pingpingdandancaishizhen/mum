$(function(){
   				$('#resetPasswordModal #resetpasswordForm').bootstrapValidator({
   				    message: 'This value is not valid',
   				    feedbackIcons: {        //提示图标
   				        valid: 'glyphicon glyphicon-ok',
   				        invalid: 'glyphicon glyphicon-remove',
   				        validating: 'glyphicon glyphicon-refresh'
   				    },
   				    fields: {
   				        password:{
   				        	validators: {
   				        	 notEmpty: {
   	                            message: '请输入密码'
   				        	 },
   				        		regexp: {
   				        			regexp:/^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\(\)])+$)([^(0-9a-zA-Z)]|[\(\)]|[a-zA-Z]|[0-9]){6,20}$/,
   				                    message: '请输入6-20位字母/数字/符号的任意组合'
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
   			        $("#resetPasswordModal #resetpasswordForm").btnAjaxSubmit({
   			        	success:function(data){
   			        		if(data.status == 1){
   			        			$table.bootstrapTable('refresh');
   			        			$("#resetPasswordModal #resetpasswordForm").resetForm();
   			        			bv.resetForm();
   			        			var $resetPasswordModal = $("#resetPasswordModal");
   			        			$resetPasswordModal.modal("hide");
   			        			
   			        		}else{
   			        			$.alert(data.message);
   			        		}
   			        	}
   			        });
   				});
	
	 $("#resetPasswordModal #savepasswordBtn").click(function(){
		 $('#resetPasswordModal #resetpasswordForm').submit();
	}); 
	
});
function toResetpassword(row){
	 $('#resetPasswordModal #id').val(row.id);
	 $("#resetPasswordModal").modal("show");
}