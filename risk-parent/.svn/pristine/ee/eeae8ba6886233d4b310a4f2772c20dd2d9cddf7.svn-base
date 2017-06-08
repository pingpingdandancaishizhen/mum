<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal" id="uploadAttachmentModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header" id="uploadAttachmentModal_title">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
		</div>
		<div class="box-body">
              <div class="row">
              <c:forEach items="${attachParams}" var="p">
                <div class="col-xs-2" id="${param.id}" name="group_${p.paramGroup}" onclick="showParam(this,'${p.paramName}','${p.paramGroup}')" style="margin-top:5px">
                  <input type="button" class="form-control" value="${p.paramName}">
                </div>
              </c:forEach>
              </div>
        </div>
			<div class="modal-body">
			<form onsubmit="return false;" class="custom-form form-horizontal" id="addContractTemplateForm"
				  action="" method="post">
				<input type="hidden" id="id" name="id" value=""> 
				<input type="hidden" id="status" name="status" value="1">
				<div class="panel-body">
					<div class="form-group clearfix">
						<label for="fileResource" class="col-sm-2 control-label"></label>
						<div class="col-sm-10 uploadFileDiv">
							<div class="input-group uploadFile">
								<input type="text" id="fileResource" class="hiddenInput"
									   name="fileResource"> <input type="text"
																   id="fileName" class="hiddenInput" name="fileName">
								<div class="form-control">
									<div class="uploadFileName"></div>
									<div class="fileNote"></div>
								</div>
								<div class="input-group-btn">
									<!-- <div class="btn btn-white deleteFileBtn">
										<i class="glyphicon glyphicon-trash"></i> <span>删除</span>
									</div> -->
									<!--<div class="btn btn-white uploadFileBtn">
										<div>
											<i class="glyphicon glyphicon-upload"></i> <span>上传</span>
										</div>
									</div>-->
									<div class="btn btn-white " id="pick-temp"></div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</form>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-default" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
var _paramName="";
var _groupName="";
var _loanInfoId="${info.id}";
function showParam(obj,paramName,group){
	$(obj).find("input").css("background-color","#3c8dbc");
	$(obj).siblings("div").find("input").css("background-color","");
	$(".control-label").html(paramName+":");
	$(".fileNote").html('');
	_groupName=group;
	_paramName=paramName;
}
$(function(){
	
	var tempUploader;
	var BASE_URL='/static/assets/plugins/webuploader'; 
	var tempPick='#pick-temp';
	var webuploaderArr={};
	
	var fileState={
		loading:'<i class="fa fa-spinner fa-spin"></i>',
		success:'<i class="fa fa-check fileSuccess"></i>',
		error:'<i class="fa fa-close fileError"></i>'
	};
	
	var fileValidate={
		maxSize:1024*1024*10,
		extensions:'jpg,jpeg,png,gif,pdf,doc,wav,mp3',
		mimeTypes: 'image/jpg,image/jpeg,image/png,image/gif,application/pdf,application/msword,audio/x-wav,audio/mpeg',
		message:'不支持上传该类型文件'
	}
	
	var domArr = [tempPick];
	
	$("#yx_attach_upload_btn,#sr_attach_upload_btn").bind("click",function(){
		var _gname=$(this).attr("groupname");
		$(".col-xs-2").hide();
		$("div[name='group_"+_gname+"']").show();
		$(".control-label").html("");
		$(".col-xs-2 input").css("background-color","");
		$("#uploadAttachmentModal_title").find("h4").html($(this).find("span").html());
		$("#uploadAttachmentModal").showModal();
		$('#uploadAttachmentModal').on('hide.bs.modal', function () {
			window.location.reload();
		});
			$("#addContractTemplateForm input:hidden").val('');
		    $(".uploadFileName").html('');
		    $(".fileNote").html('');
			domArr.forEach(function (v) {
		    	webuploaderArr[v]={};
				var uploader=WebUploader.create({
					auto:true,
					swf:BASE_URL+'/Uploader.swf',
					pick:{
						id:v,
						label:'<i class="glyphicon glyphicon-folder-open"></i><span>选择文件</span>'
					},
					server: web_root+'/order/uploadLoanAttach',
					fileSingleSizeLimit: fileValidate.maxSize,
					accept:{
						extensions: fileValidate.extensions,
						mimeTypes:fileValidate.mimeTypes
					},
					duplicate: true
				});
				webuploaderArr[v].uploader=uploader;
				var parentDiv=$(v).parents('.uploadFileDiv');
				var fileNoteDiv=parentDiv.find('.fileNote');
				var uploadFileNameDiv=parentDiv.find('.uploadFileName');
				var hiddenFileInput=parentDiv.find('.hiddenInput');
				var uploadFileBtn=parentDiv.find('.uploadFileBtn');
				$(".fileNote").html('');
				var setHeader = function(object, data, headers) {
					headers['Access-Control-Allow-Origin'] = '*';
					headers['Access-Control-Request-Headers'] = 'content-type';
					headers['Access-Control-Request-Method'] = 'POST';
				}
				uploader.on('uploadBeforeSend', function (obj, data, headers) {
					$.extend(headers, {
						Accept: "*/*"
					});
				});
				uploader.on('beforeFileQueued',function () {
					if(_paramName==""){
						$.showPop("请选择附件类型","",1000);
						return;
					}
					uploader.option('formData', {
						loanInfoId: _loanInfoId,
						attachGroup:_groupName,
						attachType:_paramName
					});
				});
				uploader.on( 'fileQueued', function( file ) {
					webuploaderArr[v].file=file;
					var content = '<div title="'+ file.name+'" class="file-caption-name"><i class="glyphicon glyphicon-file"></i> <span>'+ file.name+'</span></div>';
					uploadFileNameDiv.html(content);
					fileNoteDiv.html('')
				});
				
				//监听上传状态
				uploader.on('all',function (type) {
					if ( type === 'startUpload' ) {
						fileNoteDiv.html(fileState.loading);
					}
				});
				
				//监听上传成功
				uploader.on('uploadSuccess',function (file,res) {
					if(res.status==1){
						fileNoteDiv.html(fileState.success);
						$(hiddenFileInput.get(1)).val(file.name);
						$.showPop(res.message,"",1000);
						webuploaderArr[v].file=null;
						$("#addContractTemplateForm input:hidden").val('');
					    $(".uploadFileName").html('');
					    
					}else{
						$.showPop(res.message,"",1000);
						fileNoteDiv.html(fileState.error);
					}
				});
				
				//监听上传失败
				uploader.on('uploadError',function (file,res) {
					fileNoteDiv.html(fileState.error);
				});
				
				//监听validate不通过是的错误提示
				uploader.on('error', function (type) {
					switch (type) {
						case 'Q_TYPE_DENIED':
							$.alert(fileValidate.message);
							break;
						case 'F_EXCEED_SIZE':
							var size=WebUploader.formatSize(fileValidate.maxSize, ['B', 'KB', 'MB'])
							$.alert('上传的文件大小超过' + size);
							break;
					}
				})
				
				// 监听上传按钮
				uploadFileBtn.off().on('click',function () {
					if(_paramName==""){
						$.showPop("请选择附件类型","",1000);
						return;
					}
					if(!webuploaderArr[v].file) {
						$.showPop("请先选择文件","",2000);
						return;
					}
					uploader.option('formData', {
						loanInfoId: _loanInfoId,
						attachGroup:_groupName,
						attachType:_paramName
					});
					uploader.upload(webuploaderArr[v].file.id);
				})
				
		    });
	});
		
});

</script>	