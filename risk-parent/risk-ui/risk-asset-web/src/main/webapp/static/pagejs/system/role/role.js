$(function(){
	$("#btn_search").click(function() {
		$table.bootstrapTable('refresh');
	});
});
window.operateEvents = {
		'click #o_modify' : function(e, value, row) {
			showModifyModal(row);
		},
		'click #o_status' : function(e, value, row) {
			rolechangestatus(row);
		},
		'click #o_delete' : function(e, value, row) {
			roledelete(row);
		}
};

//角色公用方法
function createTableHtml(data){
	var table = $("<table class='table table-bordered'></table>");
	function createFuncHtml(funcs){
		var funcshtm = '';
		$.each(funcs,function(i,value){
			funcshtm+='<label class="label-box-item">'+'<input type="checkbox" data-type="func" data-parentMenu="'+value.menuId+'"  name="funcId" value="'+value.id+'" /> <span>'+value.funcName+'</span></label>';
		});
		return funcshtm;
	}
	//首页为 0000  首页固有权限不用分
	//取出一级。
	$.each(data,function(i,value){
		//首页
		if(value.menuCode == '0000'){
			var first = $("<tr>");
			first.append("<td colspan='2'><label class='label-box-item'><input type='checkbox'  data-type='secmenu'   name='menuId' value='"+value.id+"' /><span>"+value.menuName+"</span></label></td><td>"+createFuncHtml(value.funcList,true)+"</td>");
			table.append(first);
		}else{
			if(value.parentCode == '0'){
				//查找二级
				var second = [];
				$.each(data,function(i,valued){
					if(valued.parentCode==value.menuCode){
						second.push(valued);
					}
				});
				var htm="";
				//二级先生成
				$.each(second,function(i,valuedd){
					if(i==0){
						htm+="<tr><td rowspan='"+second.length+"'><label class='label-box-item'><input type='checkbox' data-type='firmenu'  name='menuId' value='"+value.id+"' /><span>"+value.menuName+"</span></label></td><td><label class='label-box-item'><input type='checkbox' data-type='secmenu' data-parentMenu='"+value.id+"'  name='menuId' value='"+valuedd.id+"' /><span>"+valuedd.menuName+"</span></label></td><td>"+createFuncHtml(valuedd.funcList,false)+"</td></tr>";
					}else{
						htm+="<tr><td><label class='label-box-item'><input type='checkbox'  data-type='secmenu' data-parentMenu='"+value.id+"' name='menuId' value='"+valuedd.id+"' /><span>"+valuedd.menuName+"</span></label></td><td>"+createFuncHtml(valuedd.funcList,false)+"</td></tr>";
					}
				});
				table.append(htm);

			}

		}

	});
	return table;
}