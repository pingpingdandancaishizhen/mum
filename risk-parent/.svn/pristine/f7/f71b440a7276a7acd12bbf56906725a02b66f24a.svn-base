var row ;
$(function () { 
	$.ajaxload();
	var $table = $('#dept_table');
	$table.bootstrapTable({
		clickToSelect:"true",
		singleSelect:"true",
		selectItemName:"id",
		cache:false,
		toolbar:'#toolbar',
		treeShowField: 'deptName',
		idField:'deptCode',
		parentIdField:'parentCode',
		url: tools.www_root()+'/system/dept/queryCorpDeptList',
		method:'get',
	});
});