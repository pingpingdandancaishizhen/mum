(function () {
    var option={
        type:'post',
        url: web_root+'/querySystemMenu',
        dataType:'json',
    };
    var $sideBarMenu=$('#sideBarMenu');
    $sideBarMenu.treeView(option,function () {
        // 默认加载第一页
        var $itemMenu=$sideBarMenu.find('.treeview');
        var $clickDiv=$itemMenu.eq(0).find('.parent-item-menu');
        var $treeviewMenu=$itemMenu.eq(0).find('.treeview-menu ');
        $clickDiv.click();
        $treeviewMenu.find('li').click();

    });
    $("#content-wrapper").find('.mainContent').height($(window).height() - 100);
    $(window).resize(function (e) {
        $("#content-wrapper").find('.mainContent').height($(window).height() - 100);
    });
    //菜单收缩操作
    var toggleBtn='.toggle-sidebar-menu';
    var screenSizes={};
    screenSizes.sm= 768;
    $(document).on('click', toggleBtn, function (e) {
        e.preventDefault();

        //Enable sidebar push menu
        if ($(window).width() > (screenSizes.sm - 1)) {
            if ($("body").hasClass('sidebar-collapse')) {
                $("body").removeClass('sidebar-collapse');
            } else {
                $("body").addClass('sidebar-collapse');
            }
        }
        //Handle sidebar push menu for small screens
        else {
            $("body").removeClass('sidebar-collapse');
        }
    });

    //收缩子菜单
    $(document).on('click','#sidebarBtn',function () {
        var hasActive=$('body').hasClass('sidebar-close');
        if(hasActive){
            $('body').removeClass('sidebar-close');
        }else{
            $('body').addClass('sidebar-close');
        }
    })
    //添加hover title
    $(document).on('mouseenter','.sidebar-collapse .sidebar-menu li.treeview>.parent-item-menu',function () {
        var offset=$(this).offset();
        var top=offset.top;
        var name=$(this).find('.menu-name').text();
        var html='<div class="menu-hover-title" style="position: absolute;top:'+(top+10)+'px;left:60px;background:#3a3a3c;font-size:12px;color:#fff;padding:2px;z-index: 9">'+name+'</div>';
        $('.menu-hover-title').remove();
        $('body').append(html);
    });
    $(document).on('mouseleave','.sidebar-collapse .sidebar-menu li.treeview>.parent-item-menu',function () {
        $('.menu-hover-title').remove();
    });
    // 个人设置
    $('#userSetting').on('click',function () {
        var $span=$(this).find('span');
        var url=$span.data('url');
        var name=$span.text();
        $sideBarMenu.treeView('addTab','/index/settings#userinfo',name)
    });
    //iframe请求打开新的menu标签
    window.addParentTab=function (url,name) {
        $sideBarMenu.treeView('addTab',url,name)
    }
    //iframe请求关闭当前标签
    window.closeParentTab=function (url,refreshUrl) {
        $sideBarMenu.treeView('closeTab',url);
        if(refreshUrl){
            $sideBarMenu.treeView('refresh',refreshUrl)
        }
    };
    //刷新指定的标签
    window.refreshParentTab=function (refreshUrl) {
        $sideBarMenu.treeView('refresh',refreshUrl)
    }

})();