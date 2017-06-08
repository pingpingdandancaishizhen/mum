/**
 * Created by RJS on 2017/3/16.
 */
(function ($) {
	var allowedMethods=[
		'addTab','closeTab','refresh','fullScreen'
	];
	var treeView=function(element,option,callback) {
		this.element = $(element);
		this.option=option;
		this.tabsArr=[];
		this.menuTab='#menuTabs';
		this.iFrameContent='#content-iframe';
		this.treeMinMenu='#sideBarMinMenu';
		this.init()
		if(callback){
			this.callback=callback;
		}
	};
	treeView.prototype={
		Constructor:treeView,
		init:function () {
			this.getTree();
			this.formatTreeCode()
		},
		getTree:function () {
			var _this=this;
			var options={
				success:function (res) {
					if(res.status==1){
						_this.data=res.data;
						_this.formatTreeCode();

					}else{
						$.alert(res.message)
					}
				}
			};
			$.extend(options,this.option);
			worf.ajax(options)
		},
		formatTreeCode:function () {
			var data=this.data;
			if(data){
				var tempTree={},temp=[],tree=[],treeJson={};
				$.each(data,function (index, item) {
					var menuCode=item.menuCode;
					if(!tempTree[menuCode]){
						tempTree[menuCode]=item;
						temp.push(item)
					}

				})
				$.each(temp,function (k, v) {
					var parentCode=v.parentCode;
					var menuCode=v.menuCode;
					if(tempTree[parentCode]){
						if(!tempTree[parentCode].hasOwnProperty('children')){
							tempTree[parentCode]['children']=[];
						}
						tempTree[parentCode]['children'].push(tempTree[menuCode])
					}else{
						treeJson[menuCode]=tempTree[menuCode];
						tree.push(tempTree[menuCode]);
					}
				})
				this.treeCode=tree;
				this.treeJson=treeJson;
				this.renderMenuTree();
			}
		},
		renderMenuTree:function () {
			var _html='';
			$.each(this.treeCode,function (key, item) {
				_html+='<li class="treeview " ><div class="icon-content parent-item-menu" data-code="'+(item.menuCode||'')+'" data-url="'+(item.actionUrl||'')+'" data-name="'+(item.menuName||'')+'">';
				// _html+='<i class="icon icon-menu '+item.menuImg+'"></i>';
				_html+='<i class="icon icon-menu '+(item.menuImg?item.menuImg:"icon-default-menu")+' "></i>';
				_html+='<span class="menu-name">'+item.menuName+'</span>';

				if(item.children){
					_html+='<span class="fa fa-angle-left"></span>';
				}
				_html+='</div>';
				if(item.children){
					_html+='<ul class="treeview-menu ">';
					$.each(item.children,function (index, cItem) {
						_html+='<li class="sub-item-menu" data-url="'+cItem.actionUrl+'" data-name="'+(cItem.menuName||'')+'"><span>'+cItem.menuName+'</span></li>'
					})
					_html+='</ul>'
				}
				_html+='</li>'
			})
			this.element.html(_html);
			this.bindEvent();
			this.callback('');
		},
		renderMinMenuTree:function (code) {
			var $treeMinMenu=$(this.treeMinMenu).find('ul');
			var minTreeMenu=this.treeJson[code]||{};
			var _html='';
			if(minTreeMenu.children){
				$.each(minTreeMenu.children,function (key, item) {
					_html+='<li class="treeview " ><div class="icon-content parent-item-menu" data-code="'+(item.menuCode||'')+'" data-url="'+(item.actionUrl||'')+'" data-name="'+(item.menuName||'')+'">';
					// _html+='<i class="icon icon-menu '+item.menuImg+'"></i>';
					_html+='<span class="menu-name">'+item.menuName+'</span>';
					if(item.children){
						_html+='<span class="fa fa-angle-left"></span>';
					}
					_html+='</div>';
					if(item.children){
						_html+='<ul class="treeview-menu ">';
						$.each(item.children,function (index, cItem) {
							_html+='<li class="sub-item-menu" data-url="'+cItem.actionUrl+'" data-name="'+(cItem.menuName||'')+'"><span>'+cItem.menuName+'</span></li>'
						})
						_html+='</ul>'
					}
					_html+='</li>'
				});
				$treeMinMenu.html(_html);
				$('body').addClass('sidebar-min')
			}else{
				$treeMinMenu.html('');
				$('body').removeClass('sidebar-min')
			}

		},
		bindEvent:function() {
			var _this=this;
			_this.element.on('click','.treeview .parent-item-menu',function () {
				var $this=$(this);
				var $body=$('body');
				var dataUrl=$this.data('url');
				var dataName=$this.data('name');
				var dataCode=$this.data('code');
				var $parentEl=$this.parent();
				var $siblingsDom=$parentEl.siblings();
				var $treeviewMenu=$parentEl.find('.treeview-menu');
				if(_this.editKey==dataCode){
					$parentEl.removeClass('active');
					$treeviewMenu.slideUp();
					_this.editKey='';
					_this.renderMinMenuTree('')
				}else{
					_this.editKey=dataCode;
					$parentEl.addClass('active');
					$siblingsDom.removeClass('active').find('.treeview-menu').slideUp();
					if(!$body.hasClass('sidebar-collapse')){
						$treeviewMenu.slideDown();
					}else{
						$treeviewMenu.show()
					}
					$siblingsDom.find('.sub-item-menu').removeClass('sub-active');
					_this.renderMinMenuTree(dataCode)
				}
				$body.removeClass('sidebar-close');
				if(dataUrl){
					_this.addTab(dataUrl,dataName)
				}

			});
			_this.element.on('click','.treeview .sub-item-menu',function () {
				var $this=$(this);
				var dataUrl=$this.data('url');
				var dataName=$this.data('name');
				$this.addClass('sub-active').siblings().removeClass('sub-active');
				$this.parent().parent().addClass('active')
				if(dataUrl){
					if(_this.tabsArr.indexOf(dataUrl)>0){
						_this.setActiveTab(dataUrl)
					}else{
						_this.addTab(dataUrl,dataName)
					}

				}
			});
			//menu min bind
			$(_this.treeMinMenu).on('click','.treeview .parent-item-menu',function () {
				var $this=$(this);
				var dataUrl=$this.data('url');
				var dataName=$this.data('name');
				var $parentEl=$this.parent();
				$parentEl.addClass('active').find('.treeview-menu').slideToggle();
				$parentEl.siblings().removeClass('active').find('.treeview-menu').slideUp().find('.sub-item-menu').removeClass('.sub-active');
				if(dataUrl){
					_this.addTab(dataUrl,dataName)
				}
			});
			$(_this.treeMinMenu).on('click','.treeview .sub-item-menu',function () {
				var $this=$(this);
				var dataUrl=$this.data('url');
				var dataName=$this.data('name');
				$this.addClass('.sub-active').siblings().removeClass('.sub-active');
				if(dataUrl){
					_this.addTab(dataUrl,dataName)
				}
			});
			//tab bind
			$(_this.menuTab).on('click','.page-tab-name',function () {
				var $this=$(this);
				var dataUrl=$this.parent().data('url');
				_this.setActiveTab(dataUrl);
			});
			$(_this.menuTab).on('click','.page-tab-remove',function () {
				var $this=$(this);
				var dataUrl=$this.parent().data('url');
				var tip=$this.parent().data('tip');
				if(tip){
					$.confirm({
						title: '提醒',
						content: '确定要关闭不保存数据？',
						confirm: function(){
							_this.closeTab(dataUrl)
						}
					})
				}else{
					_this.closeTab(dataUrl)
				}

			});
			//关闭全屏
			$(document).on('click','.full-screen-head .closeFullScreen',function () {
				_this.fullScreen();
			})
		},
		addTab:function (url, name,fromUrl,tip) {
			this.reChangeTabs();
			if(url){
				var menuTabs=$(this.menuTab);
				if(this.tabsArr.indexOf(url)>=0){
					this.setActiveTab(url)
				}else{
					var _html=[' <li class="active" data-url="'+url+'" data-from-url="'+(fromUrl?fromUrl:'')+'" data-tip="'+(tip?tip:'')+'" title="'+(name?name:'')+'">',
						url.indexOf('/index/toIndex')<0?'<div class="page-tab-name" >'+(name?name:'')+'</div><div class="page-tab-remove"><i class="fa fa-remove"></i></div>':'<div class="page-tab-name" style="margin-right:0">'+(name?name:'')+'</div>',
						'</li>'].join('');
					menuTabs.find('li').removeClass('active');
					menuTabs.append(_html);
					this.openIFrame(url);
				}

			}
		},
		openIFrame:function (url) {
			var iFrameContent=$(this.iFrameContent);
			if(this.tabsArr.indexOf(url)>=0){
				var _currentiFrame=iFrameContent.find('[data-url="'+url+'"]');
				_currentiFrame.addClass('active').siblings().removeClass('active');
			}else{
				var _html='<iframe class="LRADMS_iframe active"  width="100%" height="100%" frameborder="0" data-url="'+url+'"></iframe>';
				iFrameContent.find('.LRADMS_iframe').removeClass('active');
				iFrameContent.append(_html);
				var _currentiFrame=$('.LRADMS_iframe[data-url="'+url+'"]')
				_currentiFrame.contents().find("body").empty();
				_currentiFrame.attr('src',url);
				this.tabsArr.push(url);
			}

		},
		setActiveTab:function (url) {
			var iFrameContent=$(this.iFrameContent);
			var menuTabs=$(this.menuTab);
			var _currentLi=menuTabs.find('[data-url="'+url+'"]');
			if(_currentLi.length==0){
				_currentLi=menuTabs.find('li').last()
			}
			var iframeUrl=_currentLi.data('url');
			var _currentiFrame=iFrameContent.find('[data-url="'+iframeUrl+'"]');
			_currentLi.addClass('active').siblings().removeClass('active');
			_currentiFrame.addClass('active').siblings().removeClass('active');
		},
		closeTab:function (url) {
			var _removeTabDom=$(this.menuTab).find('[data-url="'+url+'"]');
			var _removeIFrameDom=$(this.iFrameContent).find('[data-url="'+url+'"]');
			var hasActive=_removeTabDom.hasClass('active');
			var fromUrl=_removeTabDom.data('fromUrl');
			var _removeTabDomIndex=_removeTabDom.index();
			_removeTabDom.remove();
			_removeIFrameDom.remove();
			this.tabsArr.splice($.inArray(url,this.tabsArr),1)
			if(hasActive){
				if(fromUrl){
					this.setActiveTab(fromUrl);
				}else{
					var activeUrl= $(this.menuTab).find('li').eq(_removeTabDomIndex-1).data('url');
					this.setActiveTab(activeUrl);
				}
			}

		},
		refresh:function (url) {
			if(!url){
				var $activeIFrame=$('.LRADMS_iframe.active');
				url=$activeIFrame.data('url');
			}
			if((typeof url).toLowerCase()=="object"&&url instanceof Array){
				$.each(url,function (k, item) {
					reload(item)
				})
			}else{
				reload(url)
			}

			function reload(url) {
				var target = $('.LRADMS_iframe[data-url="' + url + '"]');
				var url = target.attr('src');
				target.attr('src', url).load(function () {});
			}

		},
		reChangeTabs:function () {
			var $menuTabs=$(this.menuTab),$tabsLi=$menuTabs.find('li');
			var menuTabsWidth=$menuTabs.innerWidth();
			var liLen=$tabsLi.length;
			var liWidth=$tabsLi.outerWidth();
			var num=Math.floor(menuTabsWidth/liWidth)-1;
			if(num<=liLen){
				var url=$tabsLi.eq(1).data('url');
				this.closeTab(url);
			}
		},
		fullScreen:function () {
			var $activeIFrame=$('.LRADMS_iframe.active');
			var $activeTabLi=$(this.menuTab).find('li.active');
			var title=$activeTabLi.attr('title');
			var fullHead='<div class="full-screen-head" style="position: fixed;z-index:1000;top:0;left: 0;height:40px;line-height: 40px;padding:0 10px;width: 100%;color:#fff;font-size:14px;background: #333;"><b >'+title+'</b><div class="closeFullScreen" style="position: absolute;top:0;bottom: 0;right:0;margin:auto;padding:0 15px;cursor: pointer"><i class="fa fa-times"></i></div></div>';
			$activeIFrame.before(fullHead);
			if(!this.isFullScreen){
				this.isFullScreen=true;
				$activeIFrame.css({
					'position':'absolute',
					'top':'40px',
					'left':0,
					'z-index':1000
				});
				screenfull && screenfull.request()
			}else{
				this.isFullScreen=false;
				$activeIFrame.css({
					'position':'static'
				})
				$('body').find('.full-screen-head').remove()
				screenfull && screenfull.exit()
			}
		}
	};
	$.fn.treeView=function (option,callback) {
		var value,
			args = Array.prototype.slice.call(arguments, 1);
		this.each(function () {
			var $this = $(this),
				data = $this.data('treeView');
			if (typeof option === 'string') {
				if ($.inArray(option, allowedMethods) < 0) {
					throw new Error("Unknown method: " + option);
				}
				if (!data) {
					return;
				}
				value = data[option].apply(data, args);
			}

			if (!data) {
				$this.data('treeView', (data = new treeView(this, option,callback)));
			}
		});
		return typeof value === 'undefined' ? this : value;
	}
})(window.jQuery);


