package cn.sunfit.risk.buz.api.vo.loan;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.loan.LoanStatus;
import cn.sunfit.risk.buz.api.vo.ReqBase;

public class LoanQueryResp extends ReqBase {

    private static final long serialVersionUID = 1L;

    private String bpId;
    // 借款合同号
    private String loanContractId;

    // 借款人
    private String loanCustName;

    // 借款手机号
    private String loanCustMobile;

    private BigDecimal approvedAmount;

    private BigDecimal loanConsultFee;

    private BigDecimal loanManageFee;

    private BigDecimal loanGuaranteeFee;

    private BigDecimal loanParkFee;

    private BigDecimal loanGPSFee;

    private BigDecimal loanGPSServiceFee;

    // 还款类型
    private LoanRepaymentType loanApprovalRepayment;

    private String supportFirstPay;

    private LoanStatus loanStatus;

    private Date loanTime;

    private BigDecimal loanAmount;

    private String loanLender;

    private String deptName;

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public String getBpId() {
        return bpId;
    }

    public String getDeptName() {
        return deptName;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public String getLoanApprovalRepayment() {
        if (loanApprovalRepayment != null) {
            return loanApprovalRepayment.getTypeName();
        }
        return null;
    }

    public BigDecimal getLoanConsultFee() {
        return loanConsultFee;
    }

    public String getLoanContractId() {
        return loanContractId;
    }

    public String getLoanCustMobile() {
        return loanCustMobile;
    }

    public String getLoanCustName() {
        return loanCustName;
    }

    public BigDecimal getLoanGPSFee() {
        return loanGPSFee;
    }

    public BigDecimal getLoanGPSServiceFee() {
        return loanGPSServiceFee;
    }

    public BigDecimal getLoanGuaranteeFee() {
        return loanGuaranteeFee;
    }

    public String getLoanLender() {
        return loanLender;
    }

    public BigDecimal getLoanManageFee() {
        return loanManageFee;
    }

    public BigDecimal getLoanParkFee() {
        return loanParkFee;
    }

    public String getLoanStatus() {
        if (loanStatus != null) {
            return loanStatus.getStatusName();
        } else {
            return null;
        }
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public String getSupportFirstPay() {
        if (StringUtils.equals(supportFirstPay, "1")) {
            return "期初支付";
        }
        if (StringUtils.equals(supportFirstPay, "2")) {
            return "期末支付";
        }
        return "";
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setLoanApprovalRepayment(String loanApprovalRepayment) {
        this.loanApprovalRepayment = LoanRepaymentType.getTypeNameByTypeId(loanApprovalRepayment);
    }

    public void setLoanConsultFee(BigDecimal loanConsultFee) {
        this.loanConsultFee = loanConsultFee;
    }

    public void setLoanContractId(String loanContractId) {
        this.loanContractId = loanContractId;
    }

    public void setLoanCustMobile(String loanCustMobile) {
        this.loanCustMobile = loanCustMobile;
    }

    public void setLoanCustName(String loanCustName) {
        this.loanCustName = loanCustName;
    }

    public void setLoanGPSFee(BigDecimal loanGPSFee) {
        this.loanGPSFee = loanGPSFee;
    }

    public void setLoanGPSServiceFee(BigDecimal loanGPSServiceFee) {
        this.loanGPSServiceFee = loanGPSServiceFee;
    }

    public void setLoanGuaranteeFee(BigDecimal loanGuaranteeFee) {
        this.loanGuaranteeFee = loanGuaranteeFee;
    }

    public void setLoanLender(String loanLender) {
        this.loanLender = loanLender;
    }

    public void setLoanManageFee(BigDecimal loanManageFee) {
        this.loanManageFee = loanManageFee;
    }

    public void setLoanParkFee(BigDecimal loanParkFee) {
        this.loanParkFee = loanParkFee;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = LoanStatus.getNameByStatus(loanStatus);
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public void setSupportFirstPay(String supportFirstPay) {
        this.supportFirstPay = supportFirstPay;
    }

}
