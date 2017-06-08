package cn.sunfit.risk.buz.api.vo.loan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.loan.LoanStatus;

public class LoanQueryExportVO implements Serializable {

    private static final long serialVersionUID = 1L;
    // 借款人
    private String loanCustName;
    // 借款手机号
    private String loanCustMobile;
    // 借款合同号
    private String loanContractId;
    // 合同金额
    private BigDecimal approvedAmount;
    // 咨询费
    private BigDecimal loanConsultFee;
    // 管理费
    private BigDecimal loanManageFee;
    // 保证金
    private BigDecimal loanGuaranteeFee;
    // GPS安装费
    private BigDecimal loanGPSFee;
    // GPS服务费
    private BigDecimal loanGPSServiceFee;
    // 停车费
    private BigDecimal loanParkFee;
    // 所属门店
    private String deptName;
    // 还款类型
    private LoanRepaymentType loanApprovalRepayment;
    // 支付方式(期初/期末)
    private String supportFirstPay;
    // 放款状态
    private LoanStatus loanStatus;
    // 实际放款金额
    private BigDecimal loanAmount;
    // 实际放款时间
    private Date loanTime;
    // 放款人
    private String loanLender;

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
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
