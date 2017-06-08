<%@ page contentType="text/html;charset=UTF-8"%>

<div class="modal" id="ConfigModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">显示设置</h4>
		</div>
		<div class="modal-body">
			<div class="nav-tabs-custom">
	            <div class="tab-content">
            		<!--<div class="panel-body">
            			<div>
            				<span>请选择需要显示的查询项</span>
            			</div>
						<div id="tableDiv" style="border-top:1px solid #ddd">
							<input id="showsearchall" type="checkbox" name="showsearchall" checked="checked" value="all">
							<label for="showsearchall" >全选</label>
						
							<input id="showsearch1" type="checkbox" name="showsearch" checked="checked" value="sproductType">
							<label id="sproductType" for="showsearch1" >产品</label>
						
							<input id="showsearch2" type="checkbox" name="showsearch" checked="checked" value="sbpNo">
							<label id="sbpNo" for="showsearch2" >订单号</label>
						
							<input id="showsearch3" type="checkbox" name="showsearch" checked="checked" value="scustName">
							<label id="scustName" for="showsearch3" >客户名称</label>
						
							<input id="showsearch4" type="checkbox" name="showsearch" checked="checked" value="slicenseNo">
							<label id="slicenseNo" for="showsearch4">身份证号</label>
						
							<input id="showsearch5" type="checkbox" name="showsearch" checked="checked" value="scustType">
							<label id="scustType" for="showsearch5" >客户类型</label>
						
							<input id="showsearch6" type="checkbox" name="showsearch" checked="checked" value="scarNo">
							<label id="scarNo" for="showsearch6">车牌号码</label>
						
							<input id="showsearch7" type="checkbox" name="showsearch" checked="checked" value="scurrTaskKey">
							<label id="scurrTaskKey" for="showsearch7">单据状态</label>
						
							<input id="showsearch8" type="checkbox" name="showsearch" checked="checked" value="scontractNo">
							<label id="scontractNo" for="showsearch8" >主合同号</label>
					
							<input id="showsearch9" type="checkbox" name="showsearch" checked="checked" value="sloanType">
							<label id="sloanType" for="showsearch9" >借款性质</label>
						
							<input id="showsearch10" type="checkbox" name="showsearch" checked="checked" value="sapplytime">
							<label id="sapplytime" for="showsearch10">申请日期</label>
						
							<input id="showsearch11" type="checkbox" name="showsearch" checked="checked" value="sauditStatus">
							<label id="sauditStatus" for="showsearch11">审核状态</label>
					
							<input id="showsearch12" type="checkbox" name="showsearch" checked="checked" value="sloanShare">
							<label id="sloanShare" for="showsearch12" >共同借款</label>
						
							<input id="showsearch13" type="checkbox" name="showsearch" checked="checked" value="slendtime">
							<label id="slendtime" for="showsearch13" >放款时间</label>
						
							<input id="showsearch14" type="checkbox" name="showsearch" checked="checked" value="sowenStore">
							<label id="sowenStore" for="showsearch14" >所属门店</label>
						
							<input id="showsearch15" type="checkbox" name="showsearch" checked="checked" value="sapproveLine">
							<label id="sapproveLine" for="showsearch15" >审批期限</label>
						
							<input id="showsearch16" type="checkbox" name="showsearch" checked="checked" value="srepayStatus">
							<label id="srepayStatus" for="showsearch16" >还款状态</label>
							
							<input id="showsearch17" type="checkbox" name="showsearch" checked="checked" value="srepayedTerm">
							<label id="srepayedTerm" for="showsearch17" >已还期次</label>
							
							<input id="showsearch18" type="checkbox" name="showsearch" checked="checked" value="stenderStatus">
							<label id="stenderStatus" for="showsearch18" >标的状态</label>
							
							<input id="showsearch19" type="checkbox" name="showsearch" checked="checked" value="srepaymentMethod">
							<label id="srepaymentMethod" for="showsearch19" >还款方式</label>
							
							<input id="showsearch20" type="checkbox" name="showsearch" checked="checked" value="stendertime">
							<label id="srepayStatus" for="showsearch20" >满标时间</label>
							
							<input id="showsearch21" type="checkbox" name="showsearch" checked="checked" value="sorderSource">
							<label id="sorderSource" for="showsearch21" >订单来源</label>
							
							<input id="showsearch22" type="checkbox" name="showsearch" checked="checked" value="sloanPlatform">
							<label id="sloanPlatform" for="showsearch22" >放款平台</label>
						</div>
					</div>-->
					<div class="panel-body">
            			<div>
            				<span>请选择需要显示的列表项</span>
            			</div>
						<div id="tableDiv" style="border-top:1px solid #ddd">
							<input id="showcolumnall" type="checkbox" name="showcolumnall" checked="checked" value="all">
							<label for="showcolumnall" >全选</label>
					
							<input id="showcolumn1" type="checkbox" name="showcolumn" checked="checked" value="orderSource">
							<label id="orderSource" for="showcolumn1" >订单来源</label>
						
							<input id="showcolumn2" type="checkbox" name="showcolumn" checked="checked" value="loanPlatform">
							<label id="loanPlatform" for="showcolumn2" >放款平台</label>
						
							<input id="showcolumn3" type="checkbox" name="showcolumn" checked="checked" value="product">
							<label id="product" for="showcolumn3" >产品</label>
						
							<input id="showcolumn4" type="checkbox" name="showcolumn" checked="checked" value="custName">
							<label id="custName" for="showcolumn4">客户名称</label>
						
							<input id="showcolumn5" type="checkbox" name="showcolumn" checked="checked" value="contractNo">
							<label id="contractNo" for="showcolumn5" >主合同号</label>
					
							<input id="showcolumn6" type="checkbox" name="showcolumn" checked="checked" value="custLicenseNo">
							<label id="custLicenseNo" for="showcolumn6">身份证号</label>
						
							<input id="showcolumn7" type="checkbox" name="showcolumn" checked="checked" value="custType">
							<label id="custType" for="showcolumn7">客户类型</label>
					
							<input id="showcolumn8" type="checkbox" name="showcolumn" checked="checked" value="applyDate">
							<label id="applyDate" for="showcolumn8" >申请日期</label>
					
							<input id="showcolumn9" type="checkbox" name="showcolumn" checked="checked" value="loanShare">
							<label id="loanShare" for="showcolumn9" >是否共同借款</label>
					
							<input id="showcolumn10" type="checkbox" name="showcolumn" checked="checked" value="applyAmount">
							<label id="applyAmount" for="showcolumn10">申请金额</label>
					
							<input id="showcolumn11" type="checkbox" name="showcolumn" checked="checked" value="applyPeriodStr">
							<label id="applyPeriodStr" for="showcolumn11">申请期限</label>
						
							<input id="showcolumn12" type="checkbox" name="showcolumn" checked="checked" value="applyRepaymentMethodStr">
							<label id="applyRepaymentMethodStr" for="showcolumn12" >申请还款方式</label>
					
							<input id="showcolumn13" type="checkbox" name="showcolumn" checked="checked" value="loanApprovalAmount">
							<label id="loanApprovalAmount" for="showcolumn13" >审批金额</label>
						
							<input id="showcolumn14" type="checkbox" name="showcolumn" checked="checked" value="approvalPeriodStr">
							<label id="approvalPeriodStr" for="showcolumn14" >审批期限</label>
				
							<input id="showcolumn15" type="checkbox" name="showcolumn" checked="checked" value="loanApprovalBzjAmount">
							<label id="loanApprovalBzjAmount" for="showcolumn15" >保证金</label>
					
							<input id="showcolumn16" type="checkbox" name="showcolumn" checked="checked" value="contractAmount">
							<label id="contractAmount" for="showcolumn16" >合同金额</label>
							
							<input id="showcolumn17" type="checkbox" name="showcolumn" checked="checked" value="approvalRepaymentTypeStr">
							<label id="approvalRepaymentTypeStr" for="showcolumn17" >审批还款方式</label>
							
							<input id="showcolumn18" type="checkbox" name="showcolumn" checked="checked" value="carNo">
							<label id="carNo" for="showcolumn18" >车牌号码</label>
							
							<input id="showcolumn19" type="checkbox" name="showcolumn" checked="checked" value="owenStore">
							<label id="owenStore" for="showcolumn19" >所属门店</label>
							
							<input id="showcolumn20" type="checkbox" name="showcolumn" checked="checked" value="loanType">
							<label id="loanType" for="showcolumn20" >借款性质</label>
							
							<input id="showcolumn21" type="checkbox" name="showcolumn" checked="checked" value="orderStatus">
							<label id="orderStatus" for="showcolumn21" >订单状态</label>
							
							<input id="showcolumn22" type="checkbox" name="showcolumn" checked="checked" value="auditStatus">
							<label id="auditStatus" for="showcolumn22" >审核状态</label>
							
							<input id="showcolumn23" type="checkbox" name="showcolumn" checked="checked" value="lendDate">
							<label id="lendDate" for="showcolumn23" >放款时间</label>
							
							<input id="showcolumn24" type="checkbox" name="showcolumn" checked="checked" value="repayStatus">
							<label id="repayStatus" for="showcolumn24" >还款状态</label>
							
							<input id="showcolumn25" type="checkbox" name="showcolumn" checked="checked" value="repayedTerm">
							<label id="repayedTerm" for="showcolumn25" >已还期次</label>
							
							<input id="showcolumn26" type="checkbox" name="showcolumn" checked="checked" value="tenderStatus">
							<label id="tenderStatus" for="showcolumn26" >标的状态</label>
							
							<input id="showcolumn27" type="checkbox" name="showcolumn" checked="checked" value="tenderDate">
							<label id="tenderDate" for="showcolumn27" >满标时间</label>
							
							<input id="showcolumn28" type="checkbox" name="showcolumn" checked="checked" value="tenderRepayType">
							<label id="tenderRepayType" for="showcolumn28" >标的还款方式</label>
							
						</div>
					</div>
	            	<div class="modal-footer">
						<div  class="btn btn-primary btn-primary-lg" id="colConfigBtn" data-loading-text="确定中...">确定</div>
						<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
					</div>
	            </div>
	            <!-- /.tab-content -->
	          </div>
		</div>
	</div>
	</div>
</div>