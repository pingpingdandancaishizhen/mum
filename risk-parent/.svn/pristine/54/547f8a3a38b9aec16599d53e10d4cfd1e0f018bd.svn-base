<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
body {
	color: #686868
}

.structure-core {
	width: 100%;
	margin: auto;
	flex: 1;
}

.container {
	width: 1170px;
	margin-right: auto;
	margin-left: auto;
}

h2 {
	margin-top: 15px !important;
}

.h2, h2 {
	font-size: 30px;
}

.report-title {
	margin: 0;
}

.text-center {
	text-align: center;
}

.text-right {
	text-align: right;
}

.report {
	margin-top: 20px;
	background: #FFF;
	padding: 50px;
	border-radius: 4px;
	border: 1px solid #ccc;
	box-shadow: 0 0 3px 5px #eee;
}

.table {
	width: 100%;
	max-width: 100%;
	margin-bottom: 20px;
}

.table th {
	text-align: right;
}

.border-table {
	width: 100%;
	max-width: 100%;
	margin-bottom: 20px;
	border-collapse: collapse;
	border: none;
}

.border-table td, th {
	border: solid #EEEEEE 1px;
	padding: 8px;
}

.border-table th {
	background: #F5F5F5
}

.report-item-title {
	background: #06b;
	padding: 13px;
	color: #FFF;
	text-align: center;
	font-weight: 600;
	font-size: 14px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.label-success {
	background-color: #5cb85c;
}

.label-fail {
	background-color: #D9544D;
}

.label-guess {
	background-color: #777777;
}

.label {
	display: inline;
	padding: .2em .6em .3em;
	font-size: 75%;
	color: #fff;
	border-radius: .25em;
	margin-left: 8px;
}

@media print {
	.noprint {
		display: none
	}
}
</style>
</head>
<body>
<%-- <input type="hidden" id="userLanguage" value="<%=userLanuage%>" />
<input type="hidden" id="contextPath" value="<%=contextPath %>" />
<input type="hidden" id="msgInfo" value="${msgInfo }" /> --%>
	<article class="structure-core">
		<div class="container">
			<div class="report" style="position: relative;">
				<div class="watermark-theme-text">
					 <h2 class="h2 report-title text-center ng-binding" style="font-weight: 700;">
		               	互联网资信报告
		                <button style="position: absolute;top:12px;right:28px;" class="noprint" onclick="javascript:window.print();">打印</button>
		            </h2>
		
		            <!--基本信息开始-->
		            <div>
		                <table class="table" style="margin-bottom:10px;">
		                    <tbody>
		                        <tr>
		                            <td>
		                                <em style="font-style: normal">编号：${result.data.report.rpt_id }</em>
		                            </td>
		                            <td style="text-align: right">
		                                <em style="font-style: normal">报告时间：<fmt:formatDate  value="${result.data.report.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/></em>
		                            </td>
		                        </tr>
		                    </tbody>
		                </table>
		            </div>
		            <!--基本信息结束-->
		            
		            <h4 class="report-item-title">用户申请表检测</h4>
		            
		            <!--申请信息核查开始-->
           			<div class="report-basic-info" style="margin: 10px 0px;">
           				<table class="table border-table" style="font-size:14px;">
           					<c:forEach items="${result.data.application_check}" var="applicationCheck">
           						<!-- 姓名 -->
           						<c:if test="${applicationCheck.app_point eq 'user_name'}">
									<tr>
		        						<th style="width:100px;">姓名：</th>
		                           		<td colspan="2">${applicationCheck.check_points.key_value }</td>
									</tr>
           						</c:if>
           						<!-- 身份证 -->
           						<c:if test="${applicationCheck.app_point eq 'id_card'}">
									<tr>
		        						<th style="width:100px;">身份证：</th>
		                           		<td>
		                           			${applicationCheck.check_points.key_value }
		                           			<c:if test="${applicationCheck.check_points.court_blacklist.arised == false}"><span class="label label-success">不在法院黑名单</span></c:if>
		                           			<c:if test="${applicationCheck.check_points.court_blacklist.arised == true}"><span class="label label-fail">在法院黑名单</span></c:if>
		                           			<c:if test="${applicationCheck.check_points.financial_blacklist.arised == false}"><span class="label label-success">不在金融机构黑名单</span></c:if>
		                           			<c:if test="${applicationCheck.check_points.financial_blacklist.arised == true}"><span class="label label-fail">在金融机构黑名单</span></c:if>
		                           		</td>
		                           		<td>
		                           			${applicationCheck.check_points.gender } | ${applicationCheck.check_points.age } | ${applicationCheck.check_points.province }.${applicationCheck.check_points.city }.${applicationCheck.check_points.region }
		                           		</td>
									</tr>
           						</c:if>
           						<!-- 手机号 -->
           						<c:if test="${applicationCheck.app_point eq 'cell_phone'}">
									<tr>
		        						<th style="width:100px;" valign="top">手机号：</th>
		                           		<td style="color:#3C763D">
		                           			${applicationCheck.check_points.website}
		                           			<span 
		                           			<c:if test="${applicationCheck.check_points.reliability eq '实名认证'}">class="label label-success"</c:if>
		                           			<c:if test="${applicationCheck.check_points.reliability ne '实名认证'}">class="label label-fail"</c:if> >${applicationCheck.check_points.reliability}
		                           			</span>
		                           			<span>${applicationCheck.check_points.reg_time }</span>
		                           			<div style="padding-top:4px;">${applicationCheck.check_points.check_name }</div>
		                           			<div style="padding-top:4px;">${applicationCheck.check_points.check_idcard }</div>
		                           			<div style="padding-top:4px;">${applicationCheck.check_points.check_ebusiness }</div>
		                           		</td>
		                           		<td valign="top">
		                           			${applicationCheck.check_points.key_value }
		                           			<c:if test="${applicationCheck.check_points.financial_blacklist.arised == false}"><span class="label label-success">不在金融机构黑名单</span></c:if>
		                           			<c:if test="${applicationCheck.check_points.financial_blacklist.arised == true}"><span class="label label-fail">在金融机构黑名单</span></c:if>
		                           		</td>
									</tr>
           						</c:if>
           						<!-- 居住地址 -->
           						<c:if test="${applicationCheck.app_point eq 'home_addr'}">
           							<tr>
		        						<th style="width:100px;" valign="top">居住地址：</th>
		        						<td>${applicationCheck.check_points.key_value }</td>
		        						<td>${applicationCheck.check_points.check_addr }</td>
           						</c:if>
           						<!-- 家庭电话 -->
           						<c:if test="${applicationCheck.app_point eq 'home_phone' && empty applicationCheck.check_points.key_value}">
           							<tr>
		        						<th style="width:100px;" valign="top">家庭电话：</th>
		        						<td>${applicationCheck.check_points.key_value }</td>
		        						<td>${applicationCheck.check_points.check_mobile }</td>
           						</c:if>
           						<!-- 联系人 -->
           						<c:if test="${applicationCheck.app_point eq 'contact'}">
           							<tr>
		        						<th style="width:100px;" valign="top">联系人：</th>
		        						<td colspan="2">
		        							${applicationCheck.check_points.relationship } | ${applicationCheck.check_points.contact_name} | ${applicationCheck.check_points.key_value}
		        							<span class="label label-success">
		        								<c:if test="${fn:indexOf(applicationCheck.check_points.check_xiaohao,'非临时小号') != -1}">非临时小号</c:if>
		        								<c:if test="${fn:indexOf(applicationCheck.check_points.check_xiaohao,'非临时小号') == -1}">临时小号</c:if>
		        							</span>
		        							<div style="padding:4px 0;color:#3C763D">${applicationCheck.check_points.check_mobile }</div>
		        						</td>
           						</c:if>
           					</c:forEach>
           				</table>
           			</div>
           			<!--申请信息核查结束-->
           			
           			<!-- 用户信息检测开始 -->
           			<h4 class="report-item-title">用户信息检测</h4>
           			<div class="report-basic-info" style="margin: 10px 0px;">
           				<!-- 联系人数据开始 -->
           				<div style="padding:4px;font-size: 14px;color:#337AB7">联系人数据</div>
           				<table class="table border-table" style="font-size:14px;">
           					<tr>
           						<th rowspan="9" style="width:120px;">用户查询信息</th>
           						<th style="width:210px;">查询过该用户的相关企业数量</th>
           						<td>${result.data.user_info_check.check_search_info.searched_org_cnt }</td>
           					</tr>
           					<tr>
           						<th>查询过该用户的相关企业类型</th>
           						<td>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.searched_org_type) == 0}">
           								<span class="label label-success">无数据</span>
           							</c:if>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.searched_org_type) > 0}">
	           							<c:forEach items="${result.data.user_info_check.check_search_info.searched_org_type}" var="searchedOrgType">
	           								<span style="margin-right:20px;">${searchedOrgType }</span>
	           							</c:forEach>
           							</c:if>
           						</td>
           					</tr>
           					<tr>
           						<th>身份证组合过的其他姓名</th>
           						<td>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.idcard_with_other_names) == 0}">
           								<span class="label label-success">无数据</span>
           							</c:if>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.idcard_with_other_names) > 0}">
           								<c:forEach items="${result.data.user_info_check.check_search_info.idcard_with_other_names}" var="idcardWithOtherName">
           									<span style="margin-right:20px;">${idcardWithOtherName }</span>
           								</c:forEach>
           							</c:if>
           						</td>
           					</tr>
           					<tr>
           						<th>身份证组合过其他电话</th>
           						<td>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.idcard_with_other_phones) == 0}">
           								<span class="label label-success">无数据</span>
           							</c:if>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.idcard_with_other_phones) > 0}">
           								<c:forEach items="${result.data.user_info_check.check_search_info.idcard_with_other_phones}" var="idcardWithOtherPhone">
           									<span style="margin-right:20px;">${idcardWithOtherPhone }</span>
           								</c:forEach>
           							</c:if>
           						</td>
           					</tr>
           					<tr>
           						<th>电话号码组合过其他姓名</th>
           						<td>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.phone_with_other_names) == 0}">
           								<span class="label label-success">无数据</span>
           							</c:if>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.phone_with_other_names) > 0}">
           								<c:forEach items="${result.data.user_info_check.check_search_info.phone_with_other_names}" var="phoneWithOtherName">
           									<span style="margin-right:20px;">${phoneWithOtherName }</span>
           								</c:forEach>
           							</c:if>
           						</td>
           					</tr>
           					<tr>
           						<th>电话号码组合过其他身份证</th>
           						<td>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.phone_with_other_idcards) == 0}">
           								<span class="label label-success">无数据</span>
           							</c:if>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.phone_with_other_idcards) > 0}">
           								<c:forEach items="${result.data.user_info_check.check_search_info.phone_with_other_idcards}" var="phoneWithOtherIdcard">
           									<span style="margin-right:20px;">${phoneWithOtherIdcard }</span>
           								</c:forEach>
           							</c:if>
           						</td>
           					</tr>
           					<tr>
           						<th>电话号码注册过的相关企业数量</th>
           						<td>${result.data.user_info_check.check_search_info.register_org_cnt }</td>
           					</tr>
           					<tr>
           						<th>电话号码注册过的相关企业类型</th>
           						<td>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.register_org_type) == 0}">
           								<span class="label label-success">无数据</span>
           							</c:if>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.register_org_type) > 0}">>
           								<c:forEach items="${result.data.user_info_check.check_search_info.register_org_type}" var="registerOrgType">
           									<span style="margin-right:20px;">${registerOrgType }</span>
           								</c:forEach>
           							</c:if>
           						</td>
           					</tr>
           					<tr>
           						<th>电话号码出现过的公开网站</th>
           						<td>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.arised_open_web) == 0}">
           								<span class="label label-success">无数据</span>
           							</c:if>
           							<c:if test="${fn:length(result.data.user_info_check.check_search_info.arised_open_web) > 0}">
           								<c:forEach items="${result.data.user_info_check.check_search_info.arised_open_web}" var="arisedOpenWeb">
           									<span style="margin-right:20px;">${arisedOpenWeb }</span>
           								</c:forEach>
           							</c:if>
           						</td>
           					</tr>
           				</table>
           			</div>
           			<!-- 联系人数据结束  -->
           			<!-- 黑名单开始  -->
           			<div style="padding:4px;font-size: 14px;color:#337AB7">黑名单</div>
      				<table class="table border-table" style="font-size:14px;">
      					<tr>
      						<th rowspan="6" style="width:120px;">黑名单信息</th>
      						<th style="width:210px;">黑中介分数</th>
      						<td>${result.data.user_info_check.check_black_info.phone_gray_score } （分数范围0-100，参考分为10，分数越低关系越紧密）</td>
      					</tr>
      					<tr>
      						<th>直接联系人中黑名单人数</th>
      						<td>${result.data.user_info_check.check_black_info.contacts_class1_blacklist_cnt } (直接联系人：和被查询号码有通话记录)</td>
      					</tr>
      					<tr>
      						<th>间接联系人中黑名单人数</th>
      						<td>${result.data.user_info_check.check_black_info.contacts_class2_blacklist_cnt } (间接联系人：和被查询号码的直接联系人有通话记录)</td>
      					</tr>
      					<tr>
      						<th>直接联系人人数</th>
      						<td>${result.data.user_info_check.check_black_info.contacts_class1_cnt } (直接联系人：和被查询号码有通话记录)</td>
      					</tr>
      					<tr>
      						<th>引起黑名单的直接联系人数量</th>
      						<td>${result.data.user_info_check.check_black_info.contacts_router_cnt } (直接联系人有和黑名单用户的通讯记录的号码数量)</td>
      					</tr>
      					<tr>
      						<th>直接联系人中引起间接黑名单占比</th>
      						<td><fmt:formatNumber value="${result.data.user_info_check.check_black_info.contacts_router_cnt / result.data.user_info_check.check_black_info.contacts_class1_cnt * 100}" pattern="#"/>% (直接联系人有和黑名单用户的通讯记录的号码数量在直接联系人数量中的百分比)</td>
      					</tr>
      				</table>
           			<!-- 黑名单结束  -->
           			<!-- 用户信息检测结束 -->
           			
           			<!-- 用户行为检测开始 -->
           			<h4 class="report-item-title">用户行为检测</h4>
           			<table class="table border-table" style="font-size:14px;">
      					<tr>
      						<th style="width:180px;text-align:center;">检查项</th>
      						<th style="width:260px;text-align:center;">结果</th>
      						<th style="text-align:center;">依据</th>
      					</tr>
      					<c:forEach items="${result.data.behavior_check}" var="behaviorCheck">
	      					<tr>
	      						<td>${behaviorCheck.check_point_cn }</td>
	      						<td>${behaviorCheck.result}</td>
	      						<td>
	      							<c:forEach items="${fn:split(behaviorCheck.evidence,';')}" var="as">
									      ${as}<br/>
	      							</c:forEach>
	      						</td>
	      					</tr>
      					</c:forEach>
      				</table>
           			<!-- 用户行为检测结束 -->
           			
           			<!-- 运营商消费数据开始 -->
        			<h4 class="report-item-title">运营商消费数据</h4>
        			<table class="border-table" style="font-size:14px;">
           				<tr>
      						<th class="text-center">运营商</th>
      						<th class="text-center">号码</th>
      						<th class="text-center">归属地</th>
      						<th class="text-center">月份</th>
      						<th class="text-center">呼叫次数</th>
      						<th class="text-center">主叫次数</th>
      						<th class="text-center">主叫时间(分钟)</th>
      						<th class="text-center">被叫次数</th>
      						<th class="text-center">被叫时间(分钟)</th>
      						<th class="text-center">短信数量</th>
      						<th class="text-center">话费消费</th>
      					</tr>
      					<c:forEach items="${result.data.cell_behavior}" var="cellBehavior">
      						<c:forEach items="${cellBehavior.behavior}" var="cb">
		      					<tr>
		      						<td>${cb.cell_operator_zh }</td>
		      						<td>${cb.cell_phone_num }</td>
		      						<td>${cb.cell_loc }</td>
		      						<td>${cb.cell_mth }</td>
		      						<td>${cb.call_cnt }</td>
		      						<td>${cb.call_out_cnt }</td>
		      						<td><fmt:formatNumber value="${cb.call_out_time}" pattern="#.00"/></td>
		      						<td>${cb.call_in_cnt }</td>
		      						<td><fmt:formatNumber value="${cb.call_in_time}" pattern="#.00"/></td>
		      						<td>${cb.sms_cnt }</td>
		      						<td>
		      							<c:if test="${cb.total_amount gt 0}">${cb.total_amount }</c:if>
		      							<c:if test="${cb.total_amount le 0}">${cb.total_amount }<span class="label label-fail">无数据</span></c:if>
		      						</td>
		      					</tr>
      						</c:forEach>
      					</c:forEach>
           			</table>
           			<!-- 运营商消费数据结束 -->
           			
           			<!-- 联系人区域汇总开始 -->
           			<h4 class="report-item-title">联系人区域汇总</h4>
        			<table class="border-table" style="font-size:14px;">
           				<tr>
      						<th class="text-center">地区</th>
      						<th class="text-center">号码次数</th>
      						<th class="text-center">呼入次数</th>
      						<th class="text-center">呼出次数</th>
      						<th class="text-center">呼入时间(分钟)</th>
      						<th class="text-center">呼出时间(分钟)</th>
      						<th class="text-center">呼入次数百分比</th>
      						<th class="text-center">呼出次数百分比</th>
      						<th class="text-center">呼入时间百分比</th>
      						<th class="text-center">呼出时间百分比</th>
      					</tr>
      					<c:forEach items="${result.data.contact_region}" var="contactRegion">
	      					<tr>
	      						<td>${contactRegion.region_loc }</td>
	      						<td>${contactRegion.region_uniq_num_cnt}</td>
	      						<td>${contactRegion.region_call_in_cnt}</td>
	      						<td>${contactRegion.region_call_out_cnt}</td>
	      						<td><fmt:formatNumber value="${contactRegion.region_call_in_time}" pattern="0.00"/></td>
	      						<td><fmt:formatNumber value="${contactRegion.region_call_out_time}" pattern="0.00"/></td>
	      						<td><fmt:formatNumber value="${contactRegion.region_call_in_cnt_pct * 100}" pattern="0.0"/>%</td>
	      						<td><fmt:formatNumber value="${contactRegion.region_call_out_cnt_pct * 100}" pattern="0.0"/>%</td>
	      						<td><fmt:formatNumber value="${contactRegion.region_call_in_time_pct * 100}" pattern="0.0"/>%</td>
	      						<td><fmt:formatNumber value="${contactRegion.region_call_out_time_pct * 100}" pattern="0.0"/>%</td>
	      					</tr>
      					</c:forEach>
      				</table>
           			<!-- 联系人区域汇总结束 -->
           			
           			<!-- 运营商数据分析开始 -->
           			<h4 class="report-item-title">运营商数据分析</h4>
           			<table class="border-table" style="font-size:14px;">
           				<tr>
      						<th class="text-center">号码</th>
      						<th class="text-center">互联网标识</th>
      						<th class="text-center">需求类型</th>
      						<th class="text-center">归属地</th>
      						<th class="text-center">联系次数</th>
      						<th class="text-center">联系时间(分)</th>
      						<th class="text-center">主叫次数</th>
      						<th class="text-center">被叫次数</th>
      					</tr>
      					<c:forEach items="${result.data.contact_list}" var="contact">
	      					<tr>
	      						<td>${contact.phone_num }</td>
	      						<td>${contact.contact_name }</td>
	      						<td>${contact.needs_type}</td>
	      						<td>${contact.phone_num_loc}</td>
	      						<td>${contact.call_cnt}</td>
	      						<td><fmt:formatNumber value="${contact.call_len}" pattern="0"/></td>
	      						<td>${contact.call_out_cnt }</td>
	      						<td>${contact.call_in_cnt }</td>
	      					</tr>
	      				</c:forEach>
      				</table>
           			<!-- 运营商数据分析结束 -->
           			
           			<!-- 联系人信息和地址信息开始 -->
           			<h4 class="report-item-title">联系人信息和地址信息</h4>
           			<!-- 联系人数据 -->
           			<div style="padding:4px;font-size: 14px;color:#337AB7">联系人数据(来源于紧急联系人和电商收货人)</div>
           			<table class="border-table" style="font-size:14px;">
           				<tr>
      						<th class="text-center">联系人</th>
      						<th class="text-center">最早联系时间</th>
      						<th class="text-center">最晚联系时间</th>
      						<th class="text-center">联系电话</th>
      						<th class="text-center">近半年通话</th>
      					</tr>
      					<c:forEach items="${result.data.collection_contact}" var="collectionContact">
      						<c:forEach items="${collectionContact.contact_details}" var="detail">
		      					<tr>
		      						<td>${collectionContact.contact_name }</td>
		      						<td>${detail.trans_start }</td>
		      						<td>${detail.trans_end }</td>
		      						<td>${detail.phone_num }</td>
		      						<td>通话<fmt:formatNumber value="${detail.call_len}" pattern="0.00"/>分钟</td>
		      					</tr>
      						</c:forEach>
	      				</c:forEach>
      				</table>
      				<!-- 地址信息 -->
           			<div style="padding:4px;font-size: 14px;color:#337AB7">地址信息</div>
           			<table class="border-table" style="font-size:14px;">
           				<tr>
      						<th class="text-center">地址</th>
      						<th class="text-center">总消费金额</th>
      						<th class="text-center">收货人姓名</th>
      						<th class="text-center">收货人手机</th>
      					</tr>
      					<c:if test="${fn:length(result.data.deliver_address) == 0}">
      						<tr>
      							<td colspan="4" class="text-center">未收集到电商数据</td>
      						</tr>
      					</c:if>
      					<c:if test="${fn:length(result.data.deliver_address) > 0}">
	      					<c:forEach items="${result.data.deliver_address}" var="deliverAddres">
	      						<c:forEach items="${deliverAddres.receiver}" var="rec">
			      					<tr>
			      						<td>
			      							${deliverAddres.address } 
			      							<span class="label label-guess">${deliverAddres.predict_addr_type }(推测)</span>
			      						</td>
			      						<td>${rec.amount }</td>
			      						<td>${rec.name }</td>
			      						<td>
			      							<c:forEach items="${rec.phone_num_list}" var="phoneNum">
			      								<span style="margin-right:20px;">${phoneNum}</span>
			      							</c:forEach>
			      						</td>
			      					</tr>
	      						</c:forEach>
		      				</c:forEach>
      					</c:if>
      				</table>
           			<!-- 联系人信息和地址信息结束 -->
           			
           			<!-- 电商数据分析开始 -->
           			<h4 class="report-item-title">电商数据分析</h4>
           			<div style="padding:4px;font-size: 14px;color:#337AB7">电商消费记录</div>
           			<table class="border-table" style="font-size:14px;">
           				<tr>
      						<th class="text-center">月份</th>
      						<th class="text-center">全部消费笔数</th>
      						<th class="text-center">全部消费金额(元)</th>
      						<th class="text-center">品类分析</th>
      					</tr>
      					<c:if test="${fn:length(result.data.ebusiness_expense) == 0}">
      						<tr>
      							<td colspan="4" class="text-center">未收集到电商数据</td>
      						</tr>
      					</c:if>
      					<c:if test="${fn:length(result.data.ebusiness_expense) > 0}">
	      					<c:forEach items="${result.data.ebusiness_expense}" var="ebusinessExpense">
		      					<tr>
		      						<td width="20%">${ebusinessExpense.trans_mth }</td>
		      						<td width="20%">${ebusinessExpense.all_count }</td>
		      						<td width="20%">${ebusinessExpense.all_amount }</td>
		      						<td>
		      							<c:forEach items="${ebusinessExpense.all_category}" varStatus="status" var="category">
		      								<c:if test="${status.index == 0}">${category}</c:if>
		      								<c:if test="${status.index > 0}">、${category}</c:if>
		      							</c:forEach>
		      						</td>
		      					</tr>
		      				</c:forEach>
      					</c:if>
      				</table>
           			<!-- 电商数据分析结束 -->
           			
           			<!-- 出行数据分析开始 -->
           			<h4 class="report-item-title">出行数据分析</h4>
           			<div style="padding:4px;font-size: 14px;color:#337AB7">出行数据</div>
           			<table class="border-table" style="font-size:14px;">
           				<tr>
      						<th class="text-center">时间段</th>
      						<th class="text-center">出发时间</th>
      						<th class="text-center">回程时间</th>
      						<th class="text-center">出发地</th>
      						<th class="text-center">目的地</th>
      					</tr>
      					<c:if test="${fn:length(result.data.trip_info) == 0}">
      						<tr>
      							<td colspan="4" class="text-center">运营商漫游记录中无出行记录发现</td>
      						</tr>
      					</c:if>
      					<c:forEach items="${result.data.trip_info}" var="tripInfo">
	      					<tr>
	      						<td>${tripInfo.trip_type }</td>
	      						<td>${tripInfo.trip_start_time }</td>
	      						<td>${tripInfo.trip_end_time }</td>
	      						<td>${tripInfo.trip_leave }</td>
	      						<td>${tripInfo.trip_dest }</td>
	      					</tr>
	      				</c:forEach>
      				</table>
           			<!-- 出行数据分析结束 -->
				</div>
			</div>
		</div>
	</article>
</body>
</html>