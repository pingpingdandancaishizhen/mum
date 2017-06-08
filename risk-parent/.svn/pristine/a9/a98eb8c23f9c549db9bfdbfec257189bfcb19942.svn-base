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
function treeTableHtml(parentDom,data,callback) {
	var $_item = $('<div class="item"><span></span></div>');
	var $_item_box = $('<div class="item-box"></div>');
	var $_item_box_02 = $('<div class="item-box-02"></div>');
	var $_item_text = $('<div class="item-text"><span ></span></div>');
	var $_item_text_clone_main = $_item_text.clone();
	var item_html='<label class="label-box-item" data-pid="'+data.parentCode+'" data-id="'+data.deptCode+'" title="'+data.deptName+'"><input type="checkbox" value="'+data.id+'"><span>'+data.deptName+'</span></label>';
	$_item_text_clone_main.find("span").html(item_html);

	var $_treeTable=$(parentDom).find("#treeTableHtml");
	$_treeTable.html($_item_text_clone_main);
	/*if(data.nodes&&data.nodes.length>0){
		$_item_text_clone_main.addClass('has-child');
	}*/
	var $_item_box_02_clone_main = $_item_box_02.clone();
	$_treeTable.append($_item_box_02_clone_main);


	appendNodes($_item_box_02_clone_main,data.nodes,data.level);
	function appendNodes($_parentDiv,nodesArr,level){

		nodesArr.forEach(function(oneNode,index){

			if(oneNode.level-level==1){

				var $_item_box_clone = $_item_box.clone();

				var $_item_text_clone = $_item_text.clone();
				var item_html='<label class="label-box-item" data-pid="'+oneNode.parentCode+'" data-id="'+oneNode.deptCode+'" title="'+oneNode.deptName+'"><input type="checkbox" value="'+oneNode.id+'"><span>'+oneNode.deptName+'</span></label>';
				$_item_text_clone.find("span").html(item_html);
				$_item_box_clone.append($_item_text_clone);

				var $_item_box_02_clone = $_item_box_02.clone();
				$_item_box_clone.append($_item_box_02_clone);

				$_parentDiv.append($_item_box_clone);


				if(oneNode.nodes && oneNode.nodes.length>0){
					$_item_text_clone.addClass("node-level-"+oneNode.level);
					appendNodes($_item_box_02_clone,oneNode.nodes,oneNode.level);
				}
			}else if(oneNode.level-level>=2){
				var n = oneNode.level-level-1;
				var nodeLevel=oneNode.level;
				var $_next_parentDiv = $_parentDiv;

				for(var c = 0;c<n;c++){
					var $_item_box_clone = $_item_box.clone();

					var $_item_text_clone = $_item_text.clone();
					$_item_text_clone.find("span").text("");
					$_item_box_clone.append($_item_text_clone);

					var $_item_box_02_clone = $_item_box_02.clone();
					$_item_box_clone.append($_item_box_02_clone);

					$_next_parentDiv.append($_item_box_clone);
					$_item_text_clone.addClass("node-level-"+nodeLevel+1);
					$_next_parentDiv = $_item_box_02_clone;
				}


				var $_item_box_clone = $_item_box.clone();

				var $_item_text_clone = $_item_text.clone();
				var item_html='<label class="label-box-item" data-pid="'+oneNode.parentCode+'" data-id="'+oneNode.deptCode+'" title="'+oneNode.deptName+'"><input type="checkbox" value="'+oneNode.id+'"><span>'+oneNode.deptName+'</span></label>';
				$_item_text_clone.find("span").html(item_html);
				$_item_box_clone.append($_item_text_clone);

				var $_item_box_02_clone = $_item_box_02.clone();
				$_item_box_clone.append($_item_box_02_clone);

				$_next_parentDiv.append($_item_box_clone);


				if(oneNode.nodes && oneNode.nodes.length>0){
					$_item_text_clone.addClass("node-level-"+oneNode.level);
					appendNodes($_item_box_02_clone,oneNode.nodes,oneNode.level);
				}


			}





		});


	}


	$_treeTable.find('label').on('change',function () {
		var $this=$(this);
		var $input=$this.find('input');
		var pid=$this.data('pid');
		var id=$this.data('id');
		var checked=false;
		if($input.is(':checked')){
			checked='true';
		}
		// $('label[data-pid="'+id+'"]').find('input').prop('checked',checked);
		var checkedInput=$_treeTable.find('input:checked');
		var ids=[];
		$.each(checkedInput,function (key, item) {
			var id=$(item).val();
			ids.push(id);
		});
		callback&&callback(ids)
	})
}