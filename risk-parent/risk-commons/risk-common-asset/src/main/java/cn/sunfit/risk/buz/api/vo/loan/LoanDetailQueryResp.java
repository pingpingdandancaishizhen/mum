package cn.sunfit.risk.buz.api.vo.loan;

import java.io.Serializable;
import java.math.BigDecimal;

import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.constants.loan.LoanStatus;

public class LoanDetailQueryResp implements Serializable {

    private static final long serialVersionUID = 1L;

    private static String accountFormatter(String accountNo) {
        if (StringUtils.isNotEmpty(accountNo)) {
            StringBuilder str = new StringBuilder(accountNo.replace(" ", ""));
            int i = str.length() / 4;
            int j = str.length() % 4;
            for (int x = (j == 0 ? i - 1 : i); x > 0; x--) {
                str = str.insert(x * 4, " ");
            }
            return str.toString();
        }
        return accountNo;
    }

    private String bpId;
    private String custName;

    // 借款合同号
    private String loanContractId;

    // 合同金额
    private BigDecimal approvedAmount;

    // 放款总金额
    private BigDecimal totalLoanAmount;

    // 借款人实收金额
    private BigDecimal loanerAmount;

    // 咨询费
    private BigDecimal loanConsultFee;

    // 首期利息
    private BigDecimal interest;

    // 首期利息
    private BigDecimal principle;

    // 首期管理费
    private BigDecimal loanManageFee;

    // 首期保证金
    private BigDecimal loanGuaranteeFee;

    // 首期GPS安装费
    private BigDecimal loanGPSFee;

    // 首期GPS服务费
    private BigDecimal loanGPSServiceFee;

    // 首期停车费
    private BigDecimal loanParkFee;

    private String loanbankAccountName;

    private String loanbankAccountNo;

    private String loanbankBank;

    // 放款状态
    private LoanStatus loanStatus;

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public String getBpId() {
        return bpId;
    }

    public String getCustName() {
        return custName;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public String getLoanbankAccountName() {
        return loanbankAccountName;
    }

    public String getLoanbankAccountNo() {
        return accountFormatter(loanbankAccountNo);
    }

    public String getLoanbankBank() {
        return loanbankBank;
    }

    public BigDecimal getLoanConsultFee() {
        return loanConsultFee;
    }

    public String getLoanContractId() {
        return loanContractId;
    }

    public BigDecimal getLoanerAmount() {
        return loanerAmount;
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

    public BigDecimal getPrinciple() {
        return principle;
    }

    public BigDecimal getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public void setLoanbankAccountName(String loanbankAccountName) {
        this.loanbankAccountName = loanbankAccountName;
    }

    public void setLoanbankAccountNo(String loanbankAccountNo) {
        this.loanbankAccountNo = loanbankAccountNo;
    }

    public void setLoanbankBank(String loanbankBank) {
        this.loanbankBank = loanbankBank;
    }

    public void setLoanConsultFee(BigDecimal loanConsultFee) {
        this.loanConsultFee = loanConsultFee;
    }

    public void setLoanContractId(String loanContractId) {
        this.loanContractId = loanContractId;
    }

    public void setLoanerAmount(BigDecimal loanerAmount) {
        this.loanerAmount = loanerAmount;
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

    public void setLoanManageFee(BigDecimal loanManageFee) {
        this.loanManageFee = loanManageFee;
    }

    public void setLoanParkFee(BigDecimal loanParkFee) {
        this.loanParkFee = loanParkFee;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = LoanStatus.getNameByStatus(loanStatus);
    }

    public void setPrinciple(BigDecimal principle) {
        this.principle = principle;
    }

    public void setTotalLoanAmount(BigDecimal totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

}
