$(function(){
	 $('#modifypassword #passwordForm').bootstrapValidator({
		    message: 'This value is not valid',
		    feedbackIcons: {        //提示图标
		        valid: 'glyphicon glyphicon-ok',
		        invalid: 'glyphicon glyphicon-remove',
		        validating: 'glyphicon glyphicon-refresh'
		    },
		    fields: {
		    	oldpassword: {
		            message: '旧密码验证失败',
		            validators: {
		                notEmpty: {
		                    message: '请输入旧密码'
		                },regexp: {
		        			regexp:/^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\(\)])+$)([^(0-9a-zA-Z)]|[\(\)]|[a-zA-Z]|[0-9]){6,20}$/,
		                    message: '请输入6-20位字母/数字/符号的任意组合'
		                }
		            }
		        },
		        password: {
		        	validators: {
			        		notEmpty: {
			                    message: '请输入新密码'
			                },
			        		regexp: {
			        			regexp:/^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\(\)])+$)([^(0-9a-zA-Z)]|[\(\)]|[a-zA-Z]|[0-9]){6,20}$/,
			                    message: '请输入6-20位字母/数字/符号的任意组合'
			                }
			         }
		        },
		        passwordr:{
		        		validators: {
		        			notEmpty: {
			                    message: '请输入确认密码'
			                },
			        		regexp: {
			        			regexp:/^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\(\)])+$)([^(0-9a-zA-Z)]|[\(\)]|[a-zA-Z]|[0-9]){6,20}$/,
			                    message: '请输入6-20位字母/数字/符号的任意组合'
			                },
			                identical: {//相同
		                         field: 'password',
		                         message: '两次密码不一致'
		                     },
		                     different: {//相同
		                         field: 'oldpassword',
		                         message: '新密码不能与旧密码相同'
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
	        $("#modifypassword #passwordForm").btnAjaxSubmit({
	        	success:function(data){
	        		if(data.status == 1){
	        			bv.resetForm();
	        			$.showPop("修改密码成功,您需要使用新密码重新登录","",2000);
	        			window.setTimeout(function(){
	        				window.location.href=web_root+'/logout';
	        			},2000);

	        		}else{
	        			$.alert(data.message);
	        		}
	        		
	        	}
	        });
		});
});


(function($) {
    $('#passwords').entropizer({

        // The input field to watch: any selector, DOM element or jQuery instance
        // Default: 'input[type=password]:first'
        target: '#password',

        // The event(s) upon which to update the meter UI
        // Default: 'keydown keyup'
        on: 'input',

        // Used to calculate the percentage of the bar to fill (see map function below)
        // Default: 100
        maximum: 100,
        min:6,

        // An array of ranges to use when classifying password strength. Used internally by default map
        // function and can be used publicly via $.entropizer.classify(value, buckets). Properties
        // 'min' and 'max' are used to calculate which bucket to use - upon finding a match, an object
        // containing all the other properties is returned, e.g. below, a value of 42 returns
        // { message: ':)' }
        // Default: 4 ranges with strength and color properties (see source for values)
        buckets: [
            { max: 50, message: '差' ,color: '#e13'},
            { min: 50, max: 75, message: '还行',color: '#f80' },
            { min: 75, max: 90, message: '强', color: '#0c8'},
            { min: 90, message: '很强', color: '#0c8'}
        ],
        engine: {
            classes: ['lowercase','uppercase','numeric','symbols']
        },
        create: function(container) {
            var track = $('<div>').addClass('entropizer-track').appendTo(container),
                    bar = $('<div>').addClass('entropizer-bar').appendTo(track),
                    text = $('<div>').addClass('entropizer-text').appendTo(track);
            return {
                track: track,
                bar: bar,
                text: text
            };
        },
        destroy: function(ui) {
            ui.track.remove();
        },
        map: function(entropy, mapOptions) {
            var selectedBucket = $.entropizer.classify(entropy, mapOptions.buckets);
            var percent = Math.min(1, entropy / mapOptions.maximum) * 100;
            return $.extend({ entropy: entropy, percent: percent }, selectedBucket);

        },
        update: function(data, ui) {
            if(data.percent){
                ui.track.parent().css({
                    "display":'block'
                })
            }
            ui.bar.css({
                'background-color': data.color,
                'width': data.percent + '%'
            });
            ui.text.html(data.message);
        },
    });
})($);
