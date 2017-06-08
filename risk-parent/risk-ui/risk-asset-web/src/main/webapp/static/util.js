/**
 *
 */
$.ajaxload = function() {
	$("body").removeClass("hold-transition")
	$(window).load(function() {
		window.setTimeout(function() {
			$('#ajax-loader').fadeOut();
		}, 300);
	});
};
/**
 * bootstrap table 修饰返回值
 *
 * @param data
 * @returns
 */
function responseData(data) {
	if (data.status != 1) {
		//$.alert(data.message)
		return {
			total : 0,
			rows : {}
		};
	}
	return {
		total : data.data.totalCount,
		rows : data.data.data
	};
}

/**
 * bootstrap table 修饰请求值
 *
 * @param data
 * @returns
 */
function requestData(params) {
	var params = {
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#searchbar').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#searchbar').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}

//公用方法
var worf={
	ajax:function (options,errorBack) {
		var _opts={
			url : options.url||'',
			type : options.type||'post',
			data : options.data||{},
			dataType:options.dataType||'json',
			async:options.async||true,
			cache :false,
			success : function(data) {
				var status=data.status;
				if(status!=1){
					errorBack?errorBack(data.message):$.showPop(data.message,'',10000);
					if(status=='-999'){
						window.location.href='/login'
					}
					return false;
				}
				options.success&&options.success(data);
			},
			error : function(){
				$.showPop('网络错误','',4000);
			},
			beforeSend:function () {
				options.beforeSend&&options.beforeSend()
			},
			complete:function () {
				options.complete&&options.complete()
			},
			timeout: 30000
		};
		return $.ajax(_opts)
	},
	//获取全部角色
	getAllRole:function (callback) {
//		var roles=tools.localStorage.get('roles');
//		if(roles){
//			callback&&callback(roles);
//			return false;
//		}
		return worf.ajax({
			url : web_root+'/system/role/queryAllRole',
			type : 'post',
			data : {},
			async:false,
			success : function(data) {
				if(data.status==1){
					tools.localStorage.set('roles',data);
					callback&&callback(data);
				}
			}
		});
	},
	getAllDataRole:function (callback) {
		return worf.ajax({
			url : web_root+'/system/dataRole/queryAllDataRole',
			type : 'post',
			data : {},
			async:false,
			success : function(data) {
				if(data.status==1){
					callback&&callback(data);
				}
			}
		});
	},
	//清空本地已缓存的全部角色
	clearAllRole:function () {
		tools.localStorage.remove('roles');
	},
	//获取全部功能
	getAllFuncMenu:function (callback) {
		/*var allFuncMenu=tools.localStorage.get('allFuncMenu');
		 if(allFuncMenu){
		 callback&&callback(allFuncMenu);
		 return false;
		 }*/
		return worf.ajax({
			url : web_root+'/system/role/queryAllFuncMenu',
			type : 'post',
			data : {},
			async:false,
			success : function(data) {
				if(data.status==1){
					tools.localStorage.set('allFuncMenu',data);
					callback&&callback(data);
				}
			}
		});
	},
	//获取全部可用部门
	getAllDepts:function (callback) {
		return worf.ajax({
			url : web_root+'/system/dept/queryAllAvailableDept',
			type : 'get',
			async:false,
			success : function(data) {
				if(data.status==1){
					callback&&callback(data);
				}
			}
		});
	}
};
window.worf=worf;
var tools = {
	//本地存储
	localStorage: {
		get: function (key) {
			var store = localStorage.getItem(key);
			return store ? JSON.parse(store) : '';
		},
		set: function (key, data) {
			localStorage.setItem(key, JSON.stringify(data || ''));
		},
		remove: function (key) {
			localStorage.removeItem(key);
		}
	},
	isIE: function (ver) {
		// check for IE versions < 11
		if (navigator.appName !== 'Microsoft Internet Explorer') {
			return false;
		}
		if (ver === 10) {
			return new RegExp('msie\\s' + ver, 'i').test(navigator.userAgent);
		}
		var div = document.createElement("div"), status;
		div.innerHTML = "<!--[if IE " + ver + "]> <i></i> <![endif]-->";
		status = div.getElementsByTagName("i").length;
		document.body.appendChild(div);
		div.parentNode.removeChild(div);
		return status;
	},
	isEmpty: function (value, trim) {
		return value === undefined || value === null || value.length === 0 || (trim && $.trim(value) === '');
	},
	//网站部署路径
	www_root:function () {
		var loc=window.location
		var host=loc.host||'';
		var protocol=loc.protocol;
		var origin=protocol+'//'+host;
		var www_root=$.cookie('www_root')||'';
		return www_root?'/'+www_root:''
	},
	//获取全部get的所有请求
	getqueryParams:function () {
		var params={};
		var search=window.location.search;
		if(search){
			var searchArr=search.replace('?','').split('&');
			$.each(searchArr,function (index,item) {
				var itemArr=item.split('=');
				params[itemArr[0]]=itemArr[1]
			})
		}
		return params
	},
	//获取网页get的参数
	queryString: function (n) {
		var m = window.location.search.match(new RegExp("(\\?|&)" + n + "=([^&]*)(&|$)"));
		return !m ? "" : decodeURIComponent(m[2]);
	},
	//添加父页面的导航标签
	addParentTab:function (url, name) {
		var fromUrl=tools.getCurrentIFrameUrl();
		if(window.parent.addParentTab){
			window.parent.addParentTab(url,name,fromUrl);
		}else{
			window.location.href=url;
		}
	},
	/*
	 * 关闭父页面的导航标签
	 * @param url：要打开的地址，refreshUrl要刷新的页面
	 * */
	closeParentTab:function (url,refreshUrl) {
		if(window.parent.closeParentTab){
			if(!url){
				/*var pathname=window.location.pathname,
				 search=window.location.search;*/
				url=tools.getCurrentIFrameUrl()
			}
			window.parent.closeParentTab(url,refreshUrl);
		}else{
			location.href=document.referrer;
		}
	},
	//获取当前iframe的url
	getCurrentIFrameUrl:function () {
		var url = $(window.parent.document).find('.page-tabs .active').data('url');
		return url||location.href;
	},

	//校验规则
	rules:{
		integer:{
			reg:"^-?\\d+$",
			message:'必须是整数'
		},
		phone:{
			reg:"^0{0,1}1[0-9]{10}$",
			message:'手机号码格式不正确'
		},
		telephone:{
			reg:"((^0{0,1}1[0-9]{10}$)|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)",
			message:'电话号码格式不正确'
		},
		email:{
			reg:"\\w+([-+.´]\\w+)*@\\w+([-.]\\w+)*\.\\w+([-.]\\w+)*",
			message:'邮箱地址格式不正确'
		},
		idnumber:{
			reg:"^[1-9]([0-9]{16}|[0-9]{13})[xX0-9]$",
			message:'身份证格式不正确'
		}
	},
	//打开查看图片modal
	looksImgModal:function (url) {
		var $body=$('body');
		var _html=['<div class="modal in" id="looksImgModal"  tabindex="-1" role="dialog" aria-expanded="true" style="display: block;z-index: 99999;">',
			'<div class="modal-dialog modal-lg">',
			'<div class="modal-content">',
			'<div class="modal-header">',
			'<button class="close" data-dismiss="modal">×</button>',
			'</div>',
			'<div class="modal-body" style="text-align: center;">',
			'<div class="panel-body" style="text-align: center;">',
			'<img style="width: 80%" alt="" src="'+url+'">',
			'</div></div></div> </div> </div>'].join('')
		$body.prepend(_html);
		$(document).off().on('click','#looksImgModal .close',function () {
			$('#looksImgModal').remove()
		})
	},
	//打开新窗口
	open:function (url) {
		var newWin=window.open("");
		newWin.location=url;
	},
	//格式化时间
	formatDate:function (value, formatString) {
		var date=new Date();
		if(value){
			date=new Date(value)
		}
		var year=date.getFullYear();
		var month=date.getMonth()+1;
		var day=date.getDate();
		var hours=date.getHours();
		var minutes=date.getMinutes();
		var seconds=date.getSeconds();
		if(typeof formatString=='string'){
			formatString=formatString.replace(/yyyy|YYYY/i,year)
				.replace(/MM/i,month>9?month:['0',month].join(''))
				.replace(/dd|DD/i,day>9?day:['0',day].join(''))
				.replace(/HH|hh/i,hours>9?hours:['0',hours].join(''))
				.replace(/mm/i,minutes>9?minutes:['0',minutes].join(''))
				.replace(/ss/i,seconds>9?seconds:['0',seconds].join(''));
			return formatString;
		}else{
			return date.toLocaleString()
		}

	},
	//以空格 格式化 银行账号等账号
	formatAccount:function (value,type) {
		var fValue='';
		if(type=='account'){
			fValue=value.replace(/\s/g,'').replace(/([0-9a-zA-Z]{4})(?=[0-9a-zA-Z])/g,"$1 ").trim();
		}
		if(type=='mobile'){
			fValue=value.replace(/\D|\s/g,'').replace(/(\d{3})(\d{0,4})/,"$1 $2 ").trim()
		}
		if(type=='IDAccount'){
			fValue=value.replace(/\s/g,'').replace(/(\d{6})(\d{0,4})(\d{0,4})/,"$1 $2 $3 ").trim()
		}
		if(type=='amount'){
			var rex = /\d{1,3}(?=(\d{3})+$)/g;
			fValue= value.replace(/,/g,'').replace(/^(-?)(\d+)((\.\d+)?)$/, function (s, s1, s2, s3) {
				return s1 + s2.replace(rex, '$&,') + s3;
			})
		}
		return fValue;
	},
	unFormatAccount:function(value){
		return value.replace(/\s|,/g,'')
	},
	caretPosition:{
		get:function (element) {
			var CaretPos = 0;
			if (document.selection) {//支持IE
				element.focus();
				var Sel = document.selection.createRange();
				Sel.moveStart('character', -element.value.length);
				CaretPos = Sel.text.length;
			}
			else if (element.selectionStart || element.selectionStart == '0')//支持firefox
				CaretPos = element.selectionStart;
			return (CaretPos);
		},
		set:function (element,pos) {
			if(element.setSelectionRange)
			{
				element.focus();
				element.setSelectionRange(pos,pos);
			}
			else if (element.createTextRange) {
				var range = element.createTextRange();
				range.collapse(true);
				range.moveEnd('character', pos);
				range.moveStart('character', pos);
				range.select();
			}
		}
	},
	format:function (e,type) {
		var $this=$(e.target);
		var value=$this.val();
		$this.val(tools.formatAccount(value,type))
	}

};
window.tools=tools;
// 扩展jQuery方法
$.fn.extend({
	// 验证表单
	validate:function (options) {
		this.bootstrapValidator({
			message: 'This value is not valid',
			feedbackIcons: {        //提示图标
				valid: 'glyphicon glyphicon-ok',
				invalid: 'glyphicon glyphicon-remove',
				validating: 'glyphicon glyphicon-refresh fa-spin'
			},
			excluded:[":disabled"],
			fields: options
		})
	},
	// 打开modal
	showModal:function () {
		var $dom=this;
		$dom.modal("show");
		$dom.find('.modal-body').scrollTop(0);
		var $form=$dom.find('form');
		$dom.off('hidden.bs.modal').on('hidden.bs.modal',function () {
			// $form.bootstrapValidator('resetForm', true);
			if($form.data('bootstrapValidator')){
				$form.data('bootstrapValidator').destroy();
				$(this).off('hidden.bs.modal');
			}
		})
	},
	//关闭modal
	hideModal:function () {
		this.modal('hide');
	},
	//form ajaxsubmit 表单提交
	btnAjaxSubmit:function (opts,btn) {
		var o=this;
		var $btn=o.parents('.modal').find('.modal-footer .btn').eq(0)||$(btn);
		/*console.log($btn);
		 debugger*/
		var options={
			beforeSend:function () {
				$btn.attr('disabled','disabled');
				$btn.button('loading');
			},
			success:function (data) {
				if(data.status!=1){
					$.showPop(data.message,'',5000);
					return false;
				}
				opts.success&&opts.success(data);
			},
			error:function () {
				$.showPop('网络错误','',5000);
			},
			complete:function () {
				$btn.button('reset');
				$btn.removeAttr('disabled');
				opts.complete&&opts.complete();
			}
		}
		if(opts.data){
			options.data=opts.data;
		}
		o.ajaxSubmit(options)
	},
	//iCheck 单选 多选改造
	iBoxCheck:function () {
		this.iCheck({
			checkboxClass: 'icheckbox_square-blue',
			radioClass: 'iradio_square-blue',
		});
	},


});
$(function () {
	$(document).on('click','[data-close="closed"]',function () {
		tools.closeParentTab()
	})
});


function idCarValidate(idCar) {
	var numArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); // 系数
	var lastArr = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'); // 最后一位身份证的号码
	if (idCar == null || idCar.length != 18) {
		return false;
	}
	var sum = 0;
	var strArr = idCar.toUpperCase().split("");
	for (var i = 0; i < strArr.length - 1; i++) {
		sum += (strArr[i] - '0') * numArr[i];
	}
	return strArr[17] == lastArr[sum % 11];
}
