<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<title>UMEDITOR 完整demo</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link href="${ctx}/umeditor-dev/themes/default/_css/umeditor.css" type="text/css" rel="stylesheet">
	<script src="${ctx}/static/assets/js/lib/umeditor.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/umeditor-dev/umeditor.config.js"></script>
	<script type="text/javascript" src="${ctx}/umeditor-dev/lang/zh-cn/zh-cn.js"></script>
	
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/editor.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/browser.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/utils.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/EventBase.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/dtd.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/domUtils.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/Range.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/Selection.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/Editor.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/filterword.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/node.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/htmlparser.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/core/filternode.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/inserthtml.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/image.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/justify.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/font.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/link.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/print.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/paragraph.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/horizontal.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/cleardoc.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/undo.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/paste.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/list.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/source.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/enterkey.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/preview.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/basestyle.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/video.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/selectall.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/removeformat.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/keystrokes.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/autosave.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/autoupload.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/plugins/formula.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/widget.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/button.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/toolbar.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/menu.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/dropmenu.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/splitbutton.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/colorsplitbutton.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/popup.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/scale.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/colorpicker.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/combobox.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/buttoncombobox.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/modal.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/tooltip.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/tab.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/separator.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/ui/scale.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/adapter/adapter.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/adapter/button.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/adapter/fullscreen.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/adapter/dialog.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/adapter/popup.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/adapter/imagescale.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/adapter/autofloat.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/adapter/source.js'></script>
	<script type='text/javascript' src='${ctx}/umeditor-dev/_src/adapter/combobox.js'></script>
    
</head>
<body>
<!--style给定宽度可以影响编辑器的最终宽度-->
<script type="text/plain" id="myEditor" style="width:100%;height:310px;">
</script> 

<script type="text/javascript">
	var UMEDITOR_HOME_URL = "${ctx}";
    //实例化编辑器
    var um = UM.getEditor('myEditor');
    
	 //判断富文本编辑器是否为空
	 function validateUmeditor(){
		
       var plainTxt = UM.getEditor('myEditor').getPlainTxt();
       if(plainTxt.trim() == ""){
       	
       	$("#myEditor_span").css("display","block");
       	$("#myEditor").css("border","1px solid #a94442");
       	
       	setTimeout(function(){
       		$("#myEditor_span").css("display","none");
           	$("#myEditor").css("border","");	
       	},1500);
       	return false;
       }else{
       	
       	var content = UM.getEditor('myEditor').getContent();
       	$("textarea[name='desc']").val(content);
       	$("textarea[name='activityContent']").val(content);
       }
       return true;
	 }
    
</script>

</body>
</html>