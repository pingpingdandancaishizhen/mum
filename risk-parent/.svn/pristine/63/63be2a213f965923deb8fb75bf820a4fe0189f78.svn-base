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
		var cb = function (name, industry) {
			console.log(name, industry)
		};
		var defaultSelectArr = settings.defaultValue.split(',');
		var defaultIndustryId = defaultSelectArr[0];
		var defaultName = defaultSelectArr[1];
		var newJob='';
		var box_obj = $(this);

		var num = settings.containerId;
		var eventClick='';
		var containerElement=document.createElement('div');
		containerElement.id=settings.containerId;
		containerElement.className='col-sm-10';
		$('body').append(containerElement)
		var container = $(containerElement);
		$('#'+settings.industryId).on('click',(eventClick=function () {
			var selectDiv = ''
			if (defaultName) {
				selectDiv = "<a href='javascript:void(0)'>" + defaultName + "</a>"
			}
			if(newJob){
				selectDiv = "<a href='javascript:void(0)'>" + newJob + "</a>"
			}
			var title = "<div class=\"title\"><b>选择所属行业和职业</b><span class=\"tip\">(最多选择" + settings.maxCount + "项)</span> &nbsp&nbsp;<span class='tip' style='font-weight:bold;' id='tip_" + num + "'></span><a href=\"javascript:void(0)\" ></a></div>";
			var selectedResult = "<div class=\"sele-tag\"><dl><dt>已选择：</dt><dd id='ddResult_" + num + "'>" + selectDiv + "<a id='btnSure_" + num + "' href='javascript:void(0)' class='btn btn-primary btn-primary-sm'>确定</a></dd></dl></div>";
			init();


			function setValue(value, value2) {
				var newValue=[value, value2].join(',');
				if(!settings.defaultValue!=newValue){
					settings.defaultValue = [value, value2].join(',');
					newJob=value2;
					if (callback) {
						callback(value, value2);
					} else {
						cb(value, value2);
					}
				}
			}

			function init() {
				if ($("body #" + num + "_bg").length <= 0) {
					$("body").append("<div id='" + num + "_bg' class='mask-Bg'></div>");
				}
				if (settings.className != null) {
					container.addClass(settings.className);
				}
				var data = positiondata;
				container.html('')
				container.append(title);
				container.append(selectedResult);
				container.append("<div class=\"position-menu\" id='" + num + "_datalist'></div>");
				var datalist = $("#" + num + "_datalist");
				datalist.append("<div class='menu' id='firstMenu'></div>");
				var firstMenu = datalist.find("#firstMenu");
				firstMenu.append("<ul></ul>");
				$.each(data.positionlist, function (i, obj) {   // 循环第一级
					$(firstMenu).find("ul").append("<li id='dl_" + i + "' name='" + i + "'>" + obj.p + "</li>");
				});

				if (datalist.find("div[class='sub-menu']").length <= 0) {
					datalist.append("<div class='sub-menu' id='secondMenu'></div>");
				}
				var secondMenu = datalist.find("#secondMenu");

				// 第一级菜单鼠标悬浮事件，弹出二级菜单和三级菜单项
				$("#" + num + "_datalist #firstMenu ul li").bind("mouseover", function () {
					secondMenu.html("");
					$("#" + num + "_datalist #firstMenu ul li").removeClass("sele");
					$(this).addClass("sele");

					var index = $(this).attr("name");
					$.each(data.positionlist[index].c, function (j, item) {
						secondMenu.append("<dl id='dl_" + j + "'></dl>");
						var dtItem = "<dt id='dt_" + j + "'>" + item.n + "</dt>";
						secondMenu.find("dl[id='dl_" + j + "']").append(dtItem);
						secondMenu.find("dl[id='dl_" + j + "']").append("<dd id='dd_" + j + "'></dd>");
						$.each(data.positionlist[index].c[j].a, function (m, dist) {
							var className='';
							if(defaultName){
								className=(defaultName == dist.s ? 'sele' : '')
							}
							if(newJob){
								className=(newJob == dist.s ? 'sele' : '')
							}
							var threeMenu = "<a href='javascript:void(0)' class='" + className + "' data-id='" + index + "," + j + "," + m + "' id='item_" + index + "_" + j + "_" + m + "'>" + dist.s + "</a>";
							secondMenu.find("dl[id='dl_" + j + "'] dd[id='dd_" + j + "']").append(threeMenu);

						});
					});

					/*//根据已选择的项，将相同的列表展示项添加样式
					 var resultItems = container.find("#ddResult_" + num + " a");
					 $.each(resultItems, function (n, ritem) {
					 var rid = $(ritem).attr("id").substr(2, $(ritem).attr("id").length);
					 secondMenu.find("a[id='" + rid + "']").addClass("sele");
					 });*/

					// 列表项点击事件，选中则在结果容器中显示添加选中样式
					secondMenu.find("a").bind("click", function () {
						if ($(this).hasClass("sele")) {
							$(this).removeClass("sele");
							container.find("#ddResult_" + num).find("a[id='c_" + $(this).attr("id") + "']").remove();
						}

						else {
							$('#' + settings.containerId + '_datalist').find('.sele').removeClass('sele');
							$(this).addClass("sele");
							container.find("#ddResult_" + num + " #btnSure_" + num).siblings('a').remove();
							container.find("#ddResult_" + num + " #btnSure_" + num).before("<a href='#' id='c_" + $(this).attr("id") + "' data-id=" + $(this).data('id') + ">" + $.trim($(this).html()) + "</a>");
						}

						// 结构容器中选中项点击事件，移除并将列表中的选中样式取消
						container.find("#ddResult_" + num + " a").bind("click", function () {
							var rid = $(this).attr("id");
							if (rid != "btnSure_" + num) {
								var sid = rid.substr(2, rid.length);
								$(this).remove();
								secondMenu.find("a[id='" + sid + "']").removeClass("sele");
							}
						});
					});

				});

				// 默认显示第一级
				$(firstMenu).find("ul li:first").addClass("sele").trigger("mouseover");


				// 关闭选择框
				container.find(".title a").bind("click", function () {
					hide()
				});

				// 确定
				container.find("#ddResult_" + num + " a[id='btnSure_" + num + "']").bind("click", function () {
					var selectedItems = container.find("#ddResult_" + num + " a[id!='btnSure_" + num + "']");
					var results = "";
					var results2 = "";
					//$.trim($(this).parent().prev().html())
					// console.info(selectedItems);
					/*$.each(selectedItems, function (i, item) {
					 results += $.trim($(item).html()) + ",";
					 var id = $(item).data("id")||'';
					 var idArr=id.split(',');
					 results2 += $.trim( $("#"+id.substr(2,id.length - 1)).parent().prev().html() ) + ",";
					 });
					 if (results.length > 0) {
					 results = results.substr(0, results.length - 1);
					 results2 = results2.substr(0, results2.length - 1);
					 }*/
					var dataId = selectedItems.data('id') || "";
					var dataIdArr = dataId.split(',');
					if (dataIdArr.length == 3) {
						var firstData = data.positionlist[dataIdArr[0]] || {};
						var secData = firstData.c[dataIdArr[1]] || {};
						var thrData = secData.a[dataIdArr[2]] || {};
						results = secData.n;
						results2 = thrData.s;
					}
					setValue(results, results2);
					hide()
				});

				container.show();
				$("#" + num + "_bg").show();
			}
			function hide() {
				container.hide();
				$("#" + num + "_bg").hide();
			}
		}));
	};

})(jQuery);
