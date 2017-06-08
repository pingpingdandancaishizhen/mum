function timeFormatter(value){
 		if(value && value != ''){
		    return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
 		}
 	}

function requestNoticeData(params) {
	var params = {
		status : '1',
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#toolbar').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#toolbar').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}

function noticeContentFormatter(value ,row ,index){
	var result = "";
	if(value && value.length > 10){
		result = value.substring(0,10)+"......";
	} else {
		result = value;
	}
	return "<a href='javascript:void(0);' onclick='showDetail(\""+ row.id + "\");' >"+result+"</a>";
}

function showDetail(value){
	$('#noticeDetailModal').modal("show");
	var row = $("#notice_table").bootstrapTable('getRowByUniqueId',value);
	$('#noticeDetailModal .box-body').html(row.artContent);
}