/*!
 * CityPicker v@VERSION
 * https://github.com/tshi0912/citypicker
 *
 * Copyright (c) 2015-@YEAR Tao Shi
 * Released under the MIT license
 *
 * Date: @DATE
 */

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as anonymous module.
        define(['jquery'], factory);
    } else if (typeof exports === 'object') {
        // Node / CommonJS
        factory(require('jquery'));
    } else {
        // Browser globals.
        factory(jQuery);
    }
})(function ($) {

    'use strict';
    var NAMESPACE = 'citypicker';
    var EVENT_CHANGE = 'change.' + NAMESPACE;
    var PROVINCE = 'province';
    var CITY = 'city';
    var DISTRICT = 'district';

    function CityPicker(element, options,callback) {
        this.$element = $(element);
        this.$dropdown = null;
        this.options = $.extend({}, CityPicker.DEFAULTS, $.isPlainObject(options) && options);
        this.active = false;
        this.dems = [];
        this.needBlur = false;
        this.disc=options.disc||['省份','城市','区县'];
        this.level=options.level||[PROVINCE, CITY, DISTRICT];
        var placeholder='请选择'
        var placeHolderArr=[];

        $.each(this.level,function (k) {
          placeHolderArr.push(this.disc[k])
        }.bind(this));
        this.placeholder=placeholder+placeHolderArr.join('/');
        this.callback=callback||function () {}
      var data=this.options.data;
      var ChineseDistricts={};
      if(this.options.data){
        ChineseDistricts.index = {};
        var dataPro=this.options.type=='car'?data.brands:data.provinces;
        $.each(dataPro,function (key, item) {
          ChineseDistricts.index[key]=item;
        })
        /*ChineseDistricts[86]['A-G'] = data.provinces['A-G'];
        ChineseDistricts[86]['H-K'] = data.provinces['H-K'];
        ChineseDistricts[86]['L-S'] = data.provinces['L-S'];
        ChineseDistricts[86]['T-Z'] = data.provinces['T-Z'];*/
        var citylist = this.options.type=='car'?data.carInfos: data.districtList;
        for(var i in citylist){
          ChineseDistricts[citylist[i].code] = {};
          for(var j in citylist[i].nodes){
            if(this.options.type=='car'){
              ChineseDistricts[citylist[i].code][citylist[i].nodes[j].code] = citylist[i].nodes[j].name;
            }else{
              ChineseDistricts[citylist[i].code][citylist[i].nodes[j].code] = citylist[i].nodes[j].address;
            }

          }
        }
        this.ChineseDistricts=ChineseDistricts;
      }
      this.init();

    }

    CityPicker.prototype = {
        constructor: CityPicker,

        init: function () {

            this.defineDems();

            this.render();
            this.bind();

            this.active = true;
        },

        render: function () {
            var p = this.getPosition(),
                placeholder = this.$element.attr('placeholder') || this.placeholder,
                textspan = '<span class="city-picker-span" style="' +
                    this.getWidthStyle(p.width) + 'height:' +
                    p.height + 'px;line-height:' + (p.height) + 'px;">' +
                    (placeholder ? '<span class="placeholder">' + placeholder + '</span>' : '') +
                    '<span class="title"><div class="title-content"></div></span><div class="arrow"><i class="fa fa-angle-down"></i></div>' + '</span>',

                dropdown = '<div class="city-picker-dropdown" style="left:0px;top:100%;' +
                    this.getWidthStyle(p.width, true) + '">' +
                    '<div class="city-select-wrap">' +
                    '<div class="city-select-tab">' +
                    '<a class="active" data-count="province">'+this.disc[0]+'</a>' +
                    (this.includeDem('city') ? '<a data-count="city">'+this.disc[1]+'</a>' : '') +
                    (this.includeDem('district') ? '<a data-count="district">'+this.disc[2]+'</a>' : '') + '</div>' +
                    '<div class="city-select-content">' +
                    '<div class="city-select province" data-count="province"></div>' +
                    (this.includeDem('city') ? '<div class="city-select city" data-count="city"></div>' : '') +
                    (this.includeDem('district') ? '<div class="city-select district" data-count="district"></div>' : '') +
                    '</div></div>';

            this.$element.addClass('city-picker-input');
            this.$textspan = $(textspan).insertAfter(this.$element);
            this.$dropdown = $(dropdown).insertAfter(this.$textspan);
            var $select = this.$dropdown.find('.city-select');

            // setup this.$province, this.$city and/or this.$district object
            $.each(this.dems, $.proxy(function (i, type) {
                this['$' + type] = $select.filter('.' + type + '');
            }, this));
            this.refresh();
            var $content=this.$element.parents('.content')||$('body');
            var contentHeight=$content.height()||0;
            var _elementTop=this.$element.offset().top;
            if(contentHeight-_elementTop<250){
                this.$dropdown.css({
                    top:-this.$dropdown.outerHeight()+'px'
                })
                this.$dropdown.find('.city-select-content').css({
                    height:'330px'
                })

            }
        },

        refresh: function (force) {
            // clean the data-item for each $select
            var $select = this.$dropdown.find('.city-select');
            $select.data('item', null);
            // parse value from value of the target $element
            var val = this.$element.val() || '';
            val = val.split('/');
            $.each(this.dems, $.proxy(function (i, type) {
                if (val[i] && i < val.length) {
                    this.options[type] = val[i];
                } else if (force) {
                    this.options[type] = '';
                }
                this.output(type);
            }, this));
            this.tab(PROVINCE);
            this.feedText();
            this.feedVal();
        },

        defineDems: function () {
            var stop = false;
            $.each(this.level, $.proxy(function (i, type) {
                if (!stop) {
                    this.dems.push(type);
                }
                if (type === this.options.level) {
                    stop = true;
                }
            }, this));
        },

        includeDem: function (type) {
            return $.inArray(type, this.dems) !== -1;
        },

        getPosition: function () {
            var p, h, w, s, pw;
            p = this.$element.position();
            s = this.getSize(this.$element);
            h = s.height;
            w = s.width;
            if (this.options.responsive) {
                pw = this.$element.offsetParent().width();
                if (pw) {
                    w = w / pw;
                    if (w > 0.99) {
                        w = 1;
                    }
                    w = w * 100 + '%';
                }
            }

            return {
                top: p.top || 0,
                left: p.left || 0,
                height: h,
                width: w
            };
        },

        getSize: function ($dom) {
            var $wrap, $clone, sizes;
            if (!$dom.is(':visible')) {
                $wrap = $("<div />").appendTo($("body"));
                $wrap.css({
                    "position": "absolute !important",
                    "visibility": "hidden !important",
                    "display": "block !important"
                });

                $clone = $dom.clone().appendTo($wrap);

                sizes = {
                    width: $clone.outerWidth(),
                    height: $clone.outerHeight()
                };

                $wrap.remove();
            } else {
                sizes = {
                    width: $dom.outerWidth(),
                    height: $dom.outerHeight()
                };
            }

            return sizes;
        },

        getWidthStyle: function (w, dropdown) {
            if (this.options.responsive && !$.isNumeric(w)) {
                return 'width:' + w + ';';
            } else {
                return 'width:' + (dropdown ? Math.max(320, w) : w) + 'px;';
            }
        },

        bind: function () {
            var $this = this;

            $(document).on('click', '.city-picker-span',(this._mouteclick = function (e) {
                var $target = $(e.target);
                var $dropdown, $span, $input;
                if ($target.is('.city-picker-span')) {
                    $span = $target;
                } else if ($target.is('.city-picker-span *')) {
                    $span = $target.parents('.city-picker-span');
                }
                if ($target.is('.city-picker-input')) {
                    $input = $target;
                }
                if ($target.is('.city-picker-dropdown')) {
                    $dropdown = $target;
                } else if ($target.is('.city-picker-dropdown *')) {
                    $dropdown = $target.parents('.city-picker-dropdown');
                }
                if ((!$input && !$span && !$dropdown) ||
                    ($span && $span.get(0) !== $this.$textspan.get(0)) ||
                    ($input && $input.get(0) !== $this.$element.get(0)) ||
                    ($dropdown && $dropdown.get(0) !== $this.$dropdown.get(0))) {
                    $this.close(true);
                }
            }));
            $(document).on('click',function (e) {
                var $target=$(e.target);
                if($target.is('.city-picker-span')||$target.parents('.city-picker-span').length>0||$target.parents('.city-picker-dropdown').length>0){
                    return;
                }
                $this.close(true);
            });

            this.$element.on('focus', (this._focusElement = $.proxy(function () {
                this.needBlur = true;
                this.open();
            }, this))).on('blur', (this._blurElement = $.proxy(function () {

                if (this.needBlur) {
                    this.needBlur = false;
                    this.close(true);
                }
            }, this)));

            this.$textspan.on('click', function (e) {
                var $target = $(e.target), type;
                $this.needBlur = false;
                if ($target.parent().is('.select-item')) {
                    type = $target.parent().data('count');
                    $this.open(type);
                } else {
                    if ($this.$dropdown.is(':visible')) {
                        $this.close();
                    } else {
                        $this.open();
                    }
                }
            }).on('mousedown', function () {
                $this.needBlur = false;
            });

            this.$dropdown.on('click', '.city-select a', function () {
                var $select = $(this).parents('.city-select');
                var $active = $select.find('a.active');
                var last = $select.next().length === 0;
                $active.removeClass('active');
                $(this).addClass('active');
                if ($active.data('code') !== $(this).data('code')) {
                    $select.data('item', {
                        address: $(this).attr('title'), code: $(this).data('code')
                    });
                    $(this).trigger(EVENT_CHANGE);
                    $this.feedText();
                    $this.feedVal(true);
                    if (last) {
                        $this.close();
                    }
                }
            }).on('click', '.city-select-tab a', function () {
                if (!$(this).hasClass('active')) {
                    var type = $(this).data('count');
                    $this.tab(type);
                }
            }).on('mousedown', function () {
                $this.needBlur = false;
            });

            if (this.$province) {
                this.$province.on(EVENT_CHANGE, (this._changeProvince = $.proxy(function () {
                    this.output(CITY);
                    this.output(DISTRICT);
                    this.tab(CITY);
                }, this)));
            }

            if (this.$city) {
                this.$city.on(EVENT_CHANGE, (this._changeCity = $.proxy(function () {
                    this.output(DISTRICT);
                    this.tab(DISTRICT);
                }, this)));
            }
        },

        open: function (type) {
            type = type || PROVINCE;
            this.$dropdown.css({
                width:this.$element.outerWidth()
            })
            this.$dropdown.show();
            this.$textspan.addClass('open').addClass('focus');
            this.tab(type);
        },

        close: function (blur) {
            this.$dropdown.hide();
            this.$textspan.removeClass('open');
            if (blur) {
                this.$textspan.removeClass('focus');
            }
            // this.callback(this.getVal())
        },

        unbind: function () {

            $(document).off('click', this._mouteclick);
            this.$element.off('change', this._changeElement);
            this.$element.off('focus', this._focusElement);
            this.$element.off('blur', this._blurElement);

            this.$textspan.off('click');
            this.$textspan.off('mousedown');

            this.$dropdown.off('click');
            this.$dropdown.off('mousedown');

            if (this.$province) {
                this.$province.off(EVENT_CHANGE, this._changeProvince);
            }

            if (this.$city) {
                this.$city.off(EVENT_CHANGE, this._changeCity);
            }
        },

        getText: function () {
            var $this=this;
            var text = '';
            var simple = this.options.simple;
            var $citySelect= $this.$dropdown.find('.city-select');
            $citySelect.each(function () {
                    var item = $(this).data('item'),
                        type = $(this).data('count');
                    if (item) {
                        var address=(simple ? $this.simplize(item.address, type) : item.address);

                        text +=  '<span class="select-item" data-count="' +
                            type + '" data-code="' + item.code + ' "><span>' + address + '</span></span>';
                    }
                });
            return text;
        },

        getPlaceHolder: function () {
            return this.$element.attr('placeholder') || this.options.placeholder;
        },

        feedText: function () {
            var text = this.getText();
            if (text) {
                this.$textspan.find('>.placeholder').hide();
                this.$textspan.attr('title',this.getVal()).find('>.title>.title-content').html(this.getText()).parent().show();
                var $citySelect= this.$dropdown.find('.city-select');
                var length=$citySelect.length;
                for(var i=0;i<length-1;i++){
                    this.$textspan.find('.select-item').eq(i).css({
                        maxWidth:1/length*100+'%'
                    });
                }
            } else {
                this.$textspan.find('>.placeholder').text(this.getPlaceHolder()).show();
                this.$textspan.find('>.title').hide().find('.title-content').html('');
            }
        },

        getCode: function (count) {
            var obj = {}, arr = [];
            this.$textspan.find('.select-item')
                .each(function () {
                    var code = $(this).data('code');
                    var count = $(this).data('count');
                    obj[count] = code;
                    arr.push(code);
                });
            return count ? obj[count] : arr.join('/');
        },

        getVal: function () {
            var text = '';
            this.$dropdown.find('.city-select')
                .each(function () {
                    var item = $(this).data('item');
                    if (item) {
                        text += ($(this).hasClass('province') ? '' : '/') + item.address;
                    }
                });
            return text;
        },

        feedVal: function (trigger) {
            this.$element.val(this.getVal());
            if(trigger) {
                this.$element.trigger('change');
            }
            this.callback(this.getVal())
        },

        output: function (type) {
            var options = this.options;
            //var placeholders = this.placeholders;
            var $select = this['$' + type];
            var data = type === PROVINCE ? {} : [];
            var item;
            var districts;
            var code;
            var matched = null;
            var value;

            if (!$select || !$select.length) {
                return;
            }

            item = $select.data('item');

            value = (item ? item.address : null) || options[type];

            code = (
                type === PROVINCE ? 'index' :
                    type === CITY ? this.$province && this.$province.find('.active').data('code') :
                        type === DISTRICT ? this.$city && this.$city.find('.active').data('code') : code
            );

            districts =  this.ChineseDistricts[code];

            if ($.isPlainObject(districts)) {
                $.each(districts, function (code, address) {
                    var provs;
                    if (type === PROVINCE) {
                        provs = [];
                        for (var i = 0; i < address.length; i++) {
                            if ((address[i].address||address[i].name) === value) {
                                matched = {
                                    code: address[i].code,
                                    address: address[i].address||address[i].name
                                };
                            }
                            provs.push({
                                code: address[i].code,
                                address: address[i].address||address[i].name,
                                selected:(address[i].address||address[i].name) === value
                            });
                        }
                        data[code] = provs;
                    } else {
                        if (address === value) {
                            matched = {
                                code: code,
                                address: address
                            };
                        }
                        data.push({
                            code: code,
                            address: address,
                            selected: address === value
                        });
                    }
                });
            }

            $select.html(type === PROVINCE ? this.getProvinceList(data) :
                this.getList(data, type));
            $select.data('item', matched);
        },

        getProvinceList: function (data) {
            var list = [],
                $this = this,
                simple = this.options.simple;

            $.each(data, function (i, n) {
                list.push('<dl class="clearfix">');
                list.push('<dt>' + i + '</dt><dd>');
                $.each(n, function (j, m) {
                    list.push(
                        '<a' +
                        ' title="' + (m.address || '') + '"' +
                        ' data-code="' + (m.code || '') + '"' +
                        ' class="' +
                        (m.selected ? ' active' : '') +
                        '">' +
                        ( simple ? $this.simplize(m.address, PROVINCE) : m.address) +
                        '</a>');
                });
                list.push('</dd></dl>');
            });

            return list.join('');
        },

        getList: function (data, type) {
            var list = [],
                $this = this,
                simple = this.options.simple;
            list.push('<dl class="clearfix"><dd>');

            $.each(data, function (i, n) {
                list.push(
                    '<a' +
                    ' title="' + (n.address || '') + '"' +
                    ' data-code="' + (n.code || '') + '"' +
                    ' class="' +
                    (n.selected ? ' active' : '') +
                    '">' +
                    ( simple ? $this.simplize(n.address, type) : n.address) +
                    '</a>');
            });
            list.push('</dd></dl>');

            return list.join('');
        },

        simplize: function (address, type) {
            address = address || '';
            if (type === PROVINCE) {
                return address.replace(/[特别行政,自治区,壮族,回族,维吾尔]/g, '');
            } else if (type === CITY) {
                return address.replace(/[市,地区,回族,蒙古,苗族,白族,傣族,景颇族,藏族,彝族,壮族,傈僳族,布依族,侗族]/g, '')
                    .replace('哈萨克', '').replace('自治州', '').replace(/自治县/, '');
            } else if (type === DISTRICT) {
                return address.length > 3 ? address.replace(/[市,区,县,旗]/g, '') : address;
            }
        },

        tab: function (type) {
            var $selects = this.$dropdown.find('.city-select');
            var $tabs = this.$dropdown.find('.city-select-tab > a');
            var $select = this['$' + type];
            var $tab = this.$dropdown.find('.city-select-tab > a[data-count="' + type + '"]');
            if ($select) {
                $selects.hide();
                $select.show();
                $tabs.removeClass('active');
                $tab.addClass('active');
            }
        },

        reset: function () {
            this.$element.val(null).trigger('change');
        },

        destroy: function () {
            this.unbind();
            this.$element.removeData(NAMESPACE).removeClass('city-picker-input');
            this.$textspan.remove();
            this.$dropdown.remove();
        }
    };

    CityPicker.DEFAULTS = {
        simple: false,
        responsive: false,
        level: 'district',
        province: '',
        city: '',
        district: ''
    };

    CityPicker.setDefaults = function (options) {
        $.extend(CityPicker.DEFAULTS, options);
    };

    // Save the other citypicker
    CityPicker.other = $.fn.citypicker;

    // Register as jQuery plugin
    $.fn.citypicker = function (option,callback) {
        var args = [].slice.call(arguments, 1);
        return this.each(function () {
            var $this = $(this);
            var data = $this.data(NAMESPACE);
            var options;
            var fn;
            if (!data) {
                if (/destroy/.test(option)) {
                    return;
                }

                options = $.extend({}, $this.data(), $.isPlainObject(option) && option);
                $this.data(NAMESPACE, (data = new CityPicker(this, options,callback)));
            }

            if (typeof option === 'string' && $.isFunction(fn = data[option])) {
                fn.apply(data, args,callback);
            }
        });
    };

    $.fn.citypicker.Constructor = CityPicker;
    $.fn.citypicker.setDefaults = CityPicker.setDefaults;

    // No conflict
    $.fn.citypicker.noConflict = function () {
        $.fn.citypicker = CityPicker.other;
        return this;
    };

    $(function () {
        $('[data-toggle="city-picker"]').citypicker();
    });
});
