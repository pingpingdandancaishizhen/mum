<%@ page contentType="text/html;charset=UTF-8"%>
<div id="ajax-loader" style="cursor: progress; position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #fff; z-index: 10000; overflow: hidden">
  <img src="${ctx}/static/assets/dist/img/ajax-loader.gif${timeStyle}" style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; margin: auto">
</div>
<script>
$(function () { 
	$.ajaxload();
});
</script>