<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tab-pane" id="action">
	<div class="row table-box">
	        <div class="col-md-3">
	          <div class="box box-solid">
	            <div class="box-header with-border">
	              <h4 class="box-title">自定义事件</h4>
	            </div>
	            <div class="box-body">
	              <!-- the events -->
	              <div id="external-events">
	                <div class="checkbox">
	                  <label for="drop-remove">
	                    <input type="checkbox" id="drop-remove">
	                    	拖动后删除
	                  </label>
	                </div>
	              </div>
	            </div>
	            <!-- /.box-body -->
	          </div>
	          <!-- /. box -->
	          <div class="box box-solid">
	            <div class="box-header with-border">
	              <h3 class="box-title">添加行程事件</h3>
	            </div>
	            <div class="box-body">
	              <div class="btn-group" style="width: 100%; margin-bottom: 10px;">
	                <!--<div  id="color-chooser-btn" class="btn btn-primary btn-block dropdown-toggle" data-toggle="dropdown">Color <span class="caret"></span></div>-->
	                <ul class="fc-color-picker" id="color-chooser">
	                  <li><span class="text-aqua" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-blue" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-light-blue" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-teal" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-yellow" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-orange" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-green" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-lime" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-red" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-purple" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-fuchsia" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-muted" ><i class="fa fa-square"></i></span></li>
	                  <li><span class="text-navy" ><i class="fa fa-square"></i></span></li>
	                </ul>
	              </div>
	              <!-- /btn-group -->
	              <div class="input-group">
	                <input id="new-event" type="text" class="form-control" placeholder="Event Title">
	
	                <div class="input-group-btn">
	                  <button id="add-new-event" type="button" class="btn btn-primary btn-flat">Add</button>
	                </div>
	                <!-- /btn-group -->
	              </div>
	              <!-- /input-group -->
	            </div>
	          </div>
	        </div>
	        <!-- /.col -->
	        <div class="col-md-9">
	          <div class="box box-primary">
	            <div class="box-body no-padding">
	              <!-- THE CALENDAR -->
	              <div id="calendar"></div>
	            </div>
	            <!-- /.box-body -->
	          </div>
	          <!-- /. box -->
	        </div>	
	  </div>      
</div>
<%@ include file="./modal/dayEvent.jsp"%>
<script type="text/javascript">
	var ctx = '${ctx}';
</script>
<script type="text/javascript" src="${ctx}/static/pagejs/index/action.js${timeStyle}"></script>