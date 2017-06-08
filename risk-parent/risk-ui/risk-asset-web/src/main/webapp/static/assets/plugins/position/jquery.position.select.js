/*
 职业选择
 Date：2016-09-27
 Author:Mr.Luo

 settings 参数说明
 -----
 data:填充下拉框的数据；
 nameId:所选择值附加到的文本框或其它容器Id
 maxCount:允许最大选择数量
 ------------------------------ */
(function ($) {
	$.fn.positionSelect = function (settings, callback) {
		if (this.length < 1) {
			return;
		};

		// 默认值
		settings = $.extend({
			containerId: null,
			industryId: null,
			className: null,
			nameId: null,
			required: true,
			maxCount: 1,
			onConfirm: null,
			defaultValue: ''
		}, settings);


		var containerElement=document.createElement('div');
		containerElement.id=settings.containerId;
		containerElement.className='col-sm-10';
		$('body').append(containerElement)
		var container = $(containerElement);
		var $industryId=$('#'+settings.industryId);
		var num = settings.containerId;
		var eventClick='';
		$industryId.on('click',(eventClick=function () {
			var defaultIndustryJob=$industryId.data('industryJob');
			var defaultSelectArr = (defaultIndustryJob||settings.defaultValue).split(',');
			var defaultIndustryId = defaultSelectArr[0];
			var defaultName = defaultSelectArr[1];
			var title = "<div class=\"title\"><b>选择所属行业和职业</b><span class=\"tip\">(最多选择" + settings.maxCount + "项)</span> &nbsp&nbsp;<span class='tip' style='font-weight:bold;' id='tip_" + num + "'></span><a href=\"javascript:void(0)\" ></a></div>";
			var selectedResult = "<div class=\"sele-tag\"><dl><dt>已选择：</dt><dd id='ddResult_" + num + "'></dd><dd style='display: inline-block;float: right;'><a id='btnSure_" + num + "' href='javascript:void(0)' class='btn btn-primary btn-primary-sm'>确定</a></dd></dl></div>";
			var menuContent='<div class="position-menu" id="'+num+'_datalist"><div class="menu" id="'+num+'_firstMenu"></div><div id="'+num+'_secondMenu" class="sub-menu"></div></div>';
			init();
			function init() {
				if ($("body #" + num + "_bg").length <= 0) {
					$("body").append("<div id='" + num + "_bg' class='mask-Bg'></div>");
				}
				if (settings.className != null) {
					container.addClass(settings.className);
				}
				var data = positiondata;
				container.html(title+selectedResult+menuContent);
				var _fHtml='',_sHtml='';
				$.each(data.positionlist, function (i, obj) {   // 循环第一级
					_fHtml+="<li id='dl_" + i + "' name='" + i + "'>" + obj.p + "</li>";
					_sHtml+='<div class="second-menu-content">';
					$.each(data.positionlist[i].c, function (j, item) {
						_sHtml+='<dl id="dl_'+j+'">'
						_sHtml+='<dt id="dt_'+j+'">'+item.n+'</dt><dd id="dd_'+j+'">';
						$.each(data.positionlist[i].c[j].a, function (m, dist) {
							_sHtml+='<a href="javascript:void(0)" data-name="'+dist.s+'" data-industry="'+item.n+'">'+dist.s+'</a>'
						});
						_sHtml+='</dd></dl>'
					});
					_sHtml+='</div>'
				});
				var $firstMenu=$('#'+num+'_firstMenu'),$secondMenu=$('#'+num+'_secondMenu'),
					$btnSure=container.find("[id='btnSure_" + num + "']"),
					$result=container.find("[id='ddResult_" + num + "']");
				$firstMenu.html(_fHtml)
				$secondMenu.html(_sHtml);

				// 第一级菜单鼠标悬浮事件，弹出二级菜单和三级菜单项
				$firstMenu.find('li').on('mouseover',function () {
					var $this=$(this);
					var index=$this.index();
					$this.addClass('sele').siblings().removeClass('sele')
					$secondMenu.find('.second-menu-content').eq(index).addClass('active').siblings().removeClass('active');
				})


				// 关闭选择框
				container.find(".title a").bind("click", function () {
					hide()
				});
				//选择职业
				$secondMenu.find('a').on('click',function () {
					var $this=$(this);
					var name=$this.data('name');
					if($this.hasClass('sele')){
						$this.removeClass('sele');
						$result.find('[data-name="'+name+'"]').remove();
					}else{
						$secondMenu.find('.sele').removeClass('sele');
						$this.addClass('sele');
						$result.html($this.clone())
					}
				});
				$result.on('click','a',function () {
					var $this=$(this);
					$this.remove();
					$secondMenu.find('[data-name="'+name+'"]').removeClass('sele')
				})
				// 确定
				$btnSure.on("click", function () {
					var $itemA=$result.find('a');
					var industry=$itemA.data('industry');
					var jobName=$itemA.data('name')
					setValue(industry, jobName);
					hide()
				});
				container.show();
				$("#" + num + "_bg").show();

				// 默认显示第一级
				if(defaultIndustryId&&defaultName){
					var _dom=$secondMenu.find('[data-name="'+defaultName+'"]');
					var index=_dom.parents('.second-menu-content').index();
					$firstMenu.find('li').eq(index).addClass("sele").trigger("mouseover");
					_dom.click();
				}else{
					$firstMenu.find('li').eq(0).addClass("sele").trigger("mouseover");
				}


			}
			function hide() {
				container.hide();
				$("#" + num + "_bg").hide();
			}
			function setValue(industry, name) {
				this.defaultValue=[industry,name];
				$industryId.data('industryJob',[industry,name].join(','))
				callback&&callback(industry,name)
			}
		}));
	};

})(jQuery);
