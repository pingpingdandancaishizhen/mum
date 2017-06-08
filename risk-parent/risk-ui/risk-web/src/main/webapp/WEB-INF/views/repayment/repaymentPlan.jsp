<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/import/import.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title>乐位云风控</title>
<%@ include file="/WEB-INF/import/head.jsp"%>
</head>
<body  class="hold-transition skin-#bfbfbf sidebar-mini">
<%@ include file="/WEB-INF/import/loading.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content body-box">
		<!--<div class="body-header">
			<div class="closed" data-close="closed">&times;<span>关闭</span></div>
			<div class="body-title">还款计划</div>
		</div>-->
		<div class="col-md-12 new-box">
			<div class="panel panel-my">
				<div class="panel-body form-label-auto">
					<div class="col-sm-12 ">
						<div class="border-dotted">
							<div class="col-sm-3 form-group form-margin">
								<div class="input-group">
									<div class="label-head text-right">借款人：</div>
									<div class="label-box label-name">${attr.custName}</div>
								</div>
							</div>
							<div class="col-sm-3 form-group form-margin">
								<div class="input-group">
									<div class="label-head text-right">借款合同号：</div>
									<div class="label-box label-name">${attr.contractId}</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="border-dotted">
							<div class="col-sm-3 form-group form-margin">
								<div class="input-group">
									<div class="label-head text-right">合同金额：</div>
									<div class="label-box label-name">
										${attr.amount}
									</div>
								</div>
							</div>
							<div class="col-sm-3 form-group form-margin">
								<div class="input-group">
									<div class="label-head text-right">借款期次：</div>
									<div class="label-box label-name">
										${attr.issueCount}
									</div>
								</div>
							</div>
							<div class="col-sm-3 form-group form-margin">
								<div class="input-group">
									<c:choose>
										<c:when test="${attr.repaymentType eq '3'}">
											<div class="label-head text-right">日利率：</div>
											<div class="label-box label-name">
												<fmt:formatNumber value="${attr.daylyRate}" pattern="#0.00#"/>%
											</div>
										</c:when>
										<c:otherwise>
											<div class="label-head text-right">期利率：</div>
											<div class="label-box label-name">
												<fmt:formatNumber value="${attr.monthlyRate}" pattern="#0.00#"/>%
											</div>

										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<div class="col-sm-3 form-group form-margin">
								<div class="input-group">
									<c:choose>
										<c:when test="${attr.repaymentType eq '3'}">
											<div class="label-head text-right">日管理费率：</div>
											<div class="label-box label-name">
												<fmt:formatNumber value="${attr.daylyGLFee}" pattern="#0.00#"/>%
											</div>

										</c:when>
										<c:otherwise>
											<div class="label-head text-right">期管理费率：</div>
											<div class="label-box label-name">
												<fmt:formatNumber value="${attr.monthlyGLFee}" pattern="#0.00#"/>%
											</div>
										</c:otherwise>
									</c:choose>
								</div>
							</div>

						</div>
					</div>
					<div class="col-sm-12">
						<div class="border-dotted">
							<div class="col-sm-3 form-group form-margin">
								<div class="input-group ">
									<div class="label-head text-right">还款账户户名：</div>
									<div class="label-box label-name">
										${attr.accountName}
									</div>
								</div>
							</div>
							<div class="col-sm-3 form-group form-margin">
								<div class="input-group">
									<div class="label-head text-right">还款银行开户行：</div>
									<div class="label-box label-name">
										${attr.bank}
									</div>
								</div>
							</div>
							<div class="col-sm-3 form-group form-margin">
								<div class="input-group">
									<div class="label-head text-right">还款银行账号：</div>
									<div class="label-box label-name">
										${attr.accountNo}
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group col-md-12">
			<div class="sub-head">
				还款信息
			</div>
		</div>
		<div class="col-md-12 form-group" id="repaymentRecordForm">
			<form onsubmit="return false;" action="${ctx}/repayment/saveRepaymentRecord" method="post">
				<div class="bootstrap-table">
					<div class="fixed-table-body">
						<table class="table  table-striped" >
							<thead>
							<tr>
								<th>期次</th>
								<th>计划还款时间</th>
								<th>期还款总额</th>
								<th>期还款本金</th>
								<th>期还款利息</th>
								<th>期还款管理费</th>
								<th>期GPS服务费</th>
								<th>停车费</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${requestDetails}" var="detail">
								<tr>
									<td>${detail.issue}</td>
									<td><fmt:formatDate value="${detail.issueDate}" pattern="yyyy-MM-dd"/></td>
									<td><fmt:formatNumber value="${detail.payment + detail.manageFee + detail.extraFee + detail.extraFee2}" pattern="#,##0.00#"/></td>
									<td><fmt:formatNumber value="${detail.principle}" pattern="#,##0.00#"/></td>
									<td><fmt:formatNumber value="${detail.interest}" pattern="#,##0.00#"/></td>
									<td><fmt:formatNumber value="${detail.manageFee}" pattern="#,##0.00#"/></td>
									<td><fmt:formatNumber value="${detail.extraFee}" pattern="#,##0.00#"/></td>
									<td><fmt:formatNumber value="${detail.extraFee2}" pattern="#,##0.00#"/></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</form>
		</div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
 
</body>
</html>