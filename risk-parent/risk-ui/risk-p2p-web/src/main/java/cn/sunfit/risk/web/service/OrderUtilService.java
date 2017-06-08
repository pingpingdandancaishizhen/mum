package cn.sunfit.risk.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.web.utils.ServerConfig;

@Service
public class OrderUtilService {
    @Autowired
    private ServerConfig serverConfig;

    // public String pushFKP2PApproveXJD(P2PImportExcelTemplateXJD info) {
    // Map<String, Object> data = new HashMap<String, Object>();
    // Map<String, Object> param = new HashMap<String, Object>();
    // param.put("p2pAssetId", info.getId());
    // param.put("loanKind", "209");
    // param.put("loanSubKind", "20901");
    // param.put("loanType", "先息后本");
    // param.put("loanMoney", info.getLoanMoney().doubleValue());
    // param.put("loanPeriod", info.getLoanPeriod());
    // param.put("loanPurpose", info.getLoanPurpose());
    // param.put("loanPurposeOther", "其他");
    // if ("个人".equals(info.getCustomerType())) {
    // param.put("loanShape", "个人信用");
    // param.put("loanInfoType", "个人信息");
    // } else {
    // param.put("loanShape", "企业信用");
    // param.put("loanInfoType", "企业信息");
    // }
    // FeeItem feeItem = FeeUtil.parsingFeeJson(info.getFeeConfig());
    // if (feeItem == null)
    // return "产品缺少关联费用项";
    // List<Map<String, Object>> monthlyFee = feeItem.getMonthlyFee();
    // List<Map<String, Object>> monthlyGLFee = feeItem.getMonthlyGLFee();
    // List<Map<String, Object>> otherFee = feeItem.getOtherFee();
    // param.put("monthFee", monthlyFee == null || monthlyFee.size() == 0 ? 0 : monthlyFee.get(0).get("monthlyRate"));
    // param.put("manageFee",
    // monthlyGLFee == null || monthlyGLFee.size() == 0 ? 0 : monthlyGLFee.get(0).get("monthlyGLRate"));
    // param.put("otherFee", otherFee == null || otherFee.size() == 0 ? 0 : otherFee.get(0).get("fee"));
    // List<Map<String, Object>> wyFees = feeItem.getWyFee();
    // List<Map<String, Object>> znjFees = feeItem.getZnjFee();
    // List<Map<String, Object>> bzjFees = feeItem.getBzjFee();
    // param.put("aheadFee", wyFees == null || wyFees.size() == 0 ? 0 : wyFees.get(0).get("fee"));
    // param.put("lateFee", znjFees == null || znjFees.size() == 0 ? 0 : znjFees.get(0).get("fee"));
    // param.put("marginFee", bzjFees == null || bzjFees.size() == 0 ? 0 : bzjFees.get(0).get("fee"));
    //
    // param.put("name", info.getCustomerName());
    // param.put("gender", info.getGender());
    // param.put("mobilePhone", info.getMobilePhone());
    // param.put("idCard", info.getIdCard());
    // param.put("houseProvince", info.getHouseHoldProvince());
    // param.put("houseCity", info.getHouseHoldCity());
    // param.put("houseRegion", info.getHouseHoldRegion());
    // param.put("houseAddress", info.getHouseHoldAddress());
    // param.put("marriageState", MaritalStatus.getNameByType(info.getMarriage().toString()).getName());
    // param.put("haveChild", info.getHasChild() > 0 ? "有" : "无");
    // param.put("company", info.getCompanyName());
    // param.put("companyProvince", info.getCompanyProvince());
    // param.put("companyCity", info.getCompanyCity());
    // param.put("companyRegion", info.getCompanyRegion());
    // param.put("companyAddress", info.getCompanyAddress());
    // param.put("companyPhone", info.getCompanyTel());
    // param.put("degree", info.getHightDegree());
    // param.put("finishSchool", info.getGraduateInstitutions());
    // param.put("finishSchoolProvince", info.getSchoolProvince());
    // param.put("finishSchoolCity", info.getSchoolCity());
    // param.put("finishSchoolRegion", info.getSchoolRegion());
    // param.put("finishSchoolAddress", info.getSchoolAddress());
    // param.put("emergencyContactName1", info.getUrgenContact1());
    // param.put("emergencyContactPhone1", info.getUrgenPhone1());
    // param.put("emergencyContactRelation1", info.getRelation1());
    // param.put("emergencyContactName2", info.getUrgenContact2());
    // param.put("emergencyContactPhone2", info.getUrgenPhone2());
    // param.put("emergencyContactRelation2", info.getRelation2());
    // param.put("sesameCredit", info.getzMCreditScore());
    // param.put("payeeName", info.getReceiversName());
    // param.put("payeeTlBankName", info.getReceiversBankName());
    // param.put("payeeBranch", info.getReceiversBankBranch());
    // param.put("payeeBankAccount", info.getReceiversBankAccount());
    // param.put("payeeProvince", info.getReceiversBankProvince());
    // param.put("payeeCity", info.getReceiversBankCity());
    // param.put("refundName", info.getRepaymentName());
    // param.put("refundTlBankName", info.getRepaymentBankName());
    // param.put("refundBranch", info.getRepaymentBankBranch());
    // param.put("refundBankAccount", info.getRepaymentBankAccount());
    // param.put("refundProvince", info.getRepaymentBankProvince());
    // param.put("refundCity", info.getRepaymentBankCity());
    // data.put("data", param);
    // String res = null;
    // try {
    // res = HttpUtils.httpPostRequestFK(serverConfig.getFengkong_api_services() + "/v1/loan/applyCashLoan.json",
    // data);
    // if (res == null || res == "")
    // return "接口访问失败！";
    // String status = JsonUtil.jsonStrByKey(res, "status");
    // if (!"1".equals(status))
    // return JsonUtil.jsonStrByKey(res, "message");
    // } catch (UnsupportedEncodingException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } catch (JSONException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // return "解析接口访问结果异常！";
    // }
    //
    // return "success";
    // }

}
