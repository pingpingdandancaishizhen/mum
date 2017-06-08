<%@ page contentType="text/html;charset=UTF-8"%>

<div class="modal" id="viewSignModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">查看签章</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="custom-form" id="viewSignForm" action="#">
					<div class="col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="col-sm-12">
                                	<img id="view_img" alt="" src="">
                                </div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                    </div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-default" data-dismiss="modal">返回</div>
		</div>
	</div>
	</div>
</div>
