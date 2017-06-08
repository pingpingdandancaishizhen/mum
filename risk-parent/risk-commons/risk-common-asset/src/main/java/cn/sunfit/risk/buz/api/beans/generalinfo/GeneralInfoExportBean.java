package cn.sunfit.risk.buz.api.beans.generalinfo;

import java.math.BigDecimal;
import java.util.Date;

public class GeneralInfoExportBean {

    // 订单号
    private String bpNo;

    // 订单来源
    private String orderSource;

    // 放款平台
    private String loanPlatform;

    // 产品
    private String product;

    // 客户名称
    private String custName;

    // 主合同号
    private String contractNo;

    // 身份证号
    private String custLicenseNo;

    // 客户类型
    private String custType;

    // 申请日期
    private Date applyDate;

    // 是否共同借款
    private Boolean shareLoan;

    // 申请金额
    private BigDecimal applyAmount;

    // 申请期限
    private String applyPeriodStr;

    // 申请还款方式
    private String applyRepaymentMethodStr;

    // 审批金额
    private BigDecimal loanApprovalAmount;

    // 审批期限
    private String approvalPeriodStr;

    // 保证金
    private BigDecimal loanApprovalBzjAmount;

    // 合同金额
    private BigDecimal contractAmount;

    // 审批还款方式
    private String approvalRepaymentTypeStr;

    // 车牌号码
    private String carNo;

    // 所属门店
    private String owenStore;

    // 借款性质
    private String loanType;

    // 订单状态
    private String currentTaskName;

    // 审核状态
    private String auditStatus;

    // 放款时间
    private Date lendDate;

    // 还款状态
    private String repayStatus;

    // 已还期次
    private String repayedTerm;

    // 标状态
    private String tenderStatus;

    // 满标时间
    private Date tenderFullDate;

    // 标还款方式
    private String tenderRepayType;

    public GeneralInfoExportBean() {

    }

    public GeneralInfoExportBean(GeneralInfoListBean lb) {
        this.bpNo = lb.getBpNo();
        this.orderSource = lb.getOrderSource();
        this.loanPlatform = lb.getLoanPlatform();
        this.product = lb.getProduct();
        this.custName = lb.getCustName();
        this.contractNo = lb.getContractNo();
        this.custLicenseNo = lb.getCustLicenseNo();
        this.custType = lb.getCustType();
        this.applyDate = lb.getApplyDate();
        this.shareLoan = lb.getShareLoan();
        this.applyAmount = lb.getApplyAmount();
        this.applyPeriodStr = lb.getApplyPeriodStr();
        this.applyRepaymentMethodStr = lb.getApplyRepaymentMethodStr();
        this.loanApprovalAmount = lb.getLoanApprovalAmount();
        this.approvalPeriodStr = lb.getApprovalPeriodStr();
        this.loanApprovalBzjAmount = lb.getLoanApprovalBzjAmount();
        this.contractAmount = lb.getContractAmount();
        this.approvalRepaymentTypeStr = lb.getApprovalRepaymentTypeStr();
        this.carNo = lb.getCarNo();
        this.owenStore = lb.getOwenStore();
        this.loanType = lb.getLoanType();
        this.currentTaskName = lb.getCurrentTaskName();
        this.auditStatus = lb.getAuditStatus();
        this.lendDate = lb.getLendDate();
        this.repayStatus = lb.getRepayStatus();
        this.repayedTerm = lb.getRepayedTerm();
        this.tenderStatus = lb.getTenderStatus();
        this.tenderFullDate = lb.getTenderFullDate();
        this.tenderRepayType = lb.getTenderRepayType();
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public String getApplyPeriodStr() {
        return applyPeriodStr;
    }

    public String getApplyRepaymentMethodStr() {
        return applyRepaymentMethodStr;
    }

    public String getApprovalPeriodStr() {
        return approvalPeriodStr;
    }

    public String getApprovalRepaymentTypeStr() {
        return approvalRepaymentTypeStr;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public String getBpNo() {
        return bpNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public String getContractNo() {
        return contractNo;
    }

    public String getCurrentTaskName() {
        return currentTaskName;
    }

    public String getCustLicenseNo() {
        return custLicenseNo;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustType() {
        return custType;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public BigDecimal getLoanApprovalAmount() {
        return loanApprovalAmount;
    }

    public BigDecimal getLoanApprovalBzjAmount() {
        return loanApprovalBzjAmount;
    }

    public String getLoanPlatform() {
        return loanPlatform;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public String getOwenStore() {
        return owenStore;
    }

    public String getProduct() {
        return product;
    }

    public String getRepayedTerm() {
        return repayedTerm;
    }

    public String getRepayStatus() {
        return repayStatus;
    }

    public String getShareLoan() {
        if (shareLoan == null) {
            return "";
        }
        return shareLoan ? "是" : "否";
    }

    public Date getTenderFullDate() {
        return tenderFullDate;
    }

    public String getTenderRepayType() {
        return tenderRepayType;
    }

    public String getTenderStatus() {
        return tenderStatus;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public void setApplyPeriodStr(String applyPeriodStr) {
        this.applyPeriodStr = applyPeriodStr;
    }

    public void setApplyRepaymentMethodStr(String applyRepaymentMethodStr) {
        this.applyRepaymentMethodStr = applyRepaymentMethodStr;
    }

    public void setApprovalPeriodStr(String approvalPeriodStr) {
        this.approvalPeriodStr = approvalPeriodStr;
    }

    public void setApprovalRepaymentTypeStr(String approvalRepaymentTypeStr) {
        this.approvalRepaymentTypeStr = approvalRepaymentTypeStr;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public void setBpNo(String bpNo) {
        this.bpNo = bpNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public void setCurrentTaskName(String currentTaskName) {
        this.currentTaskName = currentTaskName;
    }

    public void setCustLicenseNo(String custLicenseNo) {
        this.custLicenseNo = custLicenseNo;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public void setLoanApprovalAmount(BigDecimal loanApprovalAmount) {
        this.loanApprovalAmount = loanApprovalAmount;
    }

    public void setLoanApprovalBzjAmount(BigDecimal loanApprovalBzjAmount) {
        this.loanApprovalBzjAmount = loanApprovalBzjAmount;
    }

    public void setLoanPlatform(String loanPlatform) {
        this.loanPlatform = loanPlatform;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public void setOwenStore(String owenStore) {
        this.owenStore = owenStore;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setRepayedTerm(String repayedTerm) {
        this.repayedTerm = repayedTerm;
    }

    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }

    public void setShareLoan(Boolean shareLoan) {
        this.shareLoan = shareLoan;
    }

    public void setTenderFullDate(Date tenderFullDate) {
        this.tenderFullDate = tenderFullDate;
    }

    public void setTenderRepayType(String tenderRepayType) {
        this.tenderRepayType = tenderRepayType;
    }

    public void setTenderStatus(String tenderStatus) {
        this.tenderStatus = tenderStatus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GeneralInfoExportBean [bpNo=");
        builder.append(bpNo);
        builder.append(", orderSource=");
        builder.append(orderSource);
        builder.append(", loanPlatform=");
        builder.append(loanPlatform);
        builder.append(", product=");
        builder.append(product);
        builder.append(", custName=");
        builder.append(custName);
        builder.append(", contractNo=");
        builder.append(contractNo);
        builder.append(", custLicenseNo=");
        builder.append(custLicenseNo);
        builder.append(", custType=");
        builder.append(custType);
        builder.append(", applyDate=");
        builder.append(applyDate);
        builder.append(", shareLoan=");
        builder.append(shareLoan);
        builder.append(", applyAmount=");
        builder.append(applyAmount);
        builder.append(", applyPeriodStr=");
        builder.append(applyPeriodStr);
        builder.append(", applyRepaymentMethodStr=");
        builder.append(applyRepaymentMethodStr);
        builder.append(", loanApprovalAmount=");
        builder.append(loanApprovalAmount);
        builder.append(", approvalPeriodStr=");
        builder.append(approvalPeriodStr);
        builder.append(", loanApprovalBzjAmount=");
        builder.append(loanApprovalBzjAmount);
        builder.append(", contractAmount=");
        builder.append(contractAmount);
        builder.append(", approvalRepaymentTypeStr=");
        builder.append(approvalRepaymentTypeStr);
        builder.append(", carNo=");
        builder.append(carNo);
        builder.append(", owenStore=");
        builder.append(owenStore);
        builder.append(", loanType=");
        builder.append(loanType);
        builder.append(", currentTaskName=");
        builder.append(currentTaskName);
        builder.append(", auditStatus=");
        builder.append(auditStatus);
        builder.append(", lendDate=");
        builder.append(lendDate);
        builder.append(", repayStatus=");
        builder.append(repayStatus);
        builder.append(", repayedTerm=");
        builder.append(repayedTerm);
        builder.append(", tenderStatus=");
        builder.append(tenderStatus);
        builder.append(", tenderFullDate=");
        builder.append(tenderFullDate);
        builder.append(", tenderRepayType=");
        builder.append(tenderRepayType);
        builder.append("]");
        return builder.toString();
    }

}
