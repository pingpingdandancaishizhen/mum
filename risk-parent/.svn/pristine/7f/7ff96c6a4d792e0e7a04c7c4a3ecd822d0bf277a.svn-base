<%@ page contentType="text/html;charset=UTF-8"%>

<style>
.partnerDiv label {
	display: inline-block;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-left: 10px;
}
</style>
<div class="modal" id="addContractTemplateModal" tabindex="-1"
	role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">导入订单</h4>
			</div>
			<div class="modal-body">
				<form onsubmit="return false;" class="custom-form form-horizontal"
					  id="addContractTemplateForm"
					  action="" method="post">
					<input type="hidden" id="id" name="id" value=""> <input
						type="hidden" id="status" name="status" value="1">
					<div class="panel-body">
						<div class="form-group clearfix">
							<label for="fileResource" class="col-sm-2 control-label">
									导入订单：</label>
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
				<div  class="btn btn-default" data-dismiss="modal">关闭</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
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
			maxSize:1024*1024,
			extensions:'xlsx',
			mimeTypes: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
			message:'只能上传EXCEL文件'
		}
		
		var domArr = [tempPick];
		
		$("#batch_import_btn").bind("click",function(){
				$("#addContractTemplateModal").showModal();
				$("input:hidden").val('');
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
						server: web_root+'/order/importExcel',
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
					uploader.option('formData', {
						bpId: "",
						category :""
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
							var err = "";
							if(res.data.err.length > 0){
								err = "导入失败订单： \n";
								for(var i = 0;i<res.data.err.length;i++){
									err += "第"+res.data.err[i].id+"行,订单号："+res.data.err[i].thirdLoanId+",失败原因:"+res.data.err[i].err+" \n";
								}
							}
							if(res.data.err.length == 0){
								alert("真棒！您已成功导入全部"+res.data.importCount+"条数据。");
							}else{
								alert("导入成功"+res.data.importCount+"条数据，失败"+res.data.errCount+"条数据！ \n"+err);
							}
							
							$("#addContractTemplateModal").hideModal();
							$("#p2pOrder_table").bootstrapTable('refresh');
						}else{
							alert(res.message);
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
						if(!webuploaderArr[v].file) {
							$.showPop("请先选择文件","",2000);
							return;
						}
						uploader.option('formData', {
							bpId: "",
							category :""
						});
						uploader.upload(webuploaderArr[v].file.id);
					})
					
			    });
		});
			
	});
	
</script>