package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.constants.BpStatus;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.LoanTermType;
import cn.sunfit.risk.buz.api.constants.loan.LoanStatus;

public class BpQueryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bpId;

    private String bpNo;

    private String customerId;

    private String custName;

    private String custGender;

    private String custGenderStr;

    private String custLicenseNum;

    private String custMobile;

    private String custType;

    private String custTypeStr;

    private String productType;

    private String productName;

    private Date createTime;

    private BigDecimal applyAmount;

    private String loanUsage;

    private String loanUsageStr;

    private String loanApplyDaylyTerm;

    private String loanApplyMonthlyTerm;

    private String loanRepaymentMethod;

    private String loanRepaymentMethodStr;

    private String loancarLicensePlate;

    private String loancarCarBrand;

    private String createUserId;

    private String currentTaskName;

    private String brandName;

    private String userName;

    private String deptName;

    private String deptHead;

    private String loanApprovalRepaymentMethod;
    private String loanApprovalRepaymentMethodStr;

    private Integer bpStatus;
    private Integer loanStatus;

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public String getBpId() {
        return bpId;
    }

    public String getBpNo() {
        return bpNo;
    }

    public Integer getBpStatus() {
        return bpStatus;
    }

    public String getBrandName() {
        return brandName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public String getCurrentTaskName() {
        if (BpStatus.LOAN_ING.equals(BpStatus.getByStatus(bpStatus))) {
            return LoanStatus.getNameByStatus(loanStatus).getStatusName();
        } else if (BpStatus.LOAN_AFTER.equals(BpStatus.getByStatus(bpStatus))) {
            return BpStatus.LOAN_AFTER.getLabel();
        } else if (BpStatus.LOAN_FINISH.equals(BpStatus.getByStatus(bpStatus))) {
            return BpStatus.LOAN_FINISH.getLabel();
        } else {
            if (StringUtils.isNotBlank(currentTaskName)) {
                currentTaskName = currentTaskName.substring(1, currentTaskName.length() - 1);
            }
        }
        return currentTaskName;
    }

    public String getCustGender() {
        return custGender;
    }

    public String getCustGenderStr() {
        return custGenderStr;
    }

    public String getCustLicenseNum() {
        return custLicenseNum;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustType() {
        return custType;
    }

    public String getCustTypeStr() {
        return custTypeStr;
    }

    public String getDeptHead() {
        return deptHead;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getLoanApplyDaylyTerm() {
        return loanApplyDaylyTerm;
    }

    public String getLoanApplyMonthlyTerm() {
        return loanApplyMonthlyTerm;
    }

    public String getLoanApplyPeriodStr() {
        if (LoanRepaymentType.YCXHQ.equals(LoanRepaymentType.getTypeNameByTypeId(loanRepaymentMethod))) {
            // 一次性还款
            return loanApplyDaylyTerm + "天";
        } else {
            return LoanTermType.getLabelByStatus(loanApplyMonthlyTerm);
        }
    }

    public String getLoanApprovalRepaymentMethod() {
        return loanApprovalRepaymentMethod;
    }

    public String getLoanApprovalRepaymentMethodStr() {
        return loanApprovalRepaymentMethodStr;
    }

    public String getLoancarCarBrand() {
        return loancarCarBrand;
    }

    public String getLoancarLicensePlate() {
        return loancarLicensePlate;
    }

    public String getLoanRepaymentMethod() {
        return loanRepaymentMethod;
    }

    public String getLoanRepaymentMethodStr() {
        return loanRepaymentMethodStr;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public String getLoanUsage() {
        return loanUsage;
    }

    public String getLoanUsageStr() {
        return loanUsageStr;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getUserName() {
        return userName;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setBpNo(String bpNo) {
        this.bpNo = bpNo;
    }

    public void setBpStatus(Integer bpStatus) {
        this.bpStatus = bpStatus;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public void setCurrentTaskName(String currentTaskName) {
        this.currentTaskName = currentTaskName;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public void setCustGenderStr(String custGenderStr) {
        this.custGenderStr = custGenderStr;
    }

    public void setCustLicenseNum(String custLicenseNum) {
        this.custLicenseNum = custLicenseNum;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public void setCustTypeStr(String custTypeStr) {
        this.custTypeStr = custTypeStr;
    }

    public void setDeptHead(String deptHead) {
        this.deptHead = deptHead;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setLoanApplyDaylyTerm(String loanApplyDaylyTerm) {
        this.loanApplyDaylyTerm = loanApplyDaylyTerm;
    }

    public void setLoanApplyMonthlyTerm(String loanApplyMonthlyTerm) {
        this.loanApplyMonthlyTerm = loanApplyMonthlyTerm;
    }

    public void setLoanApprovalRepaymentMethod(String loanApprovalRepaymentMethod) {
        this.loanApprovalRepaymentMethod = loanApprovalRepaymentMethod;
    }

    public void setLoanApprovalRepaymentMethodStr(String loanApprovalRepaymentMethodStr) {
        this.loanApprovalRepaymentMethodStr = loanApprovalRepaymentMethodStr;
    }

    public void setLoancarCarBrand(String loancarCarBrand) {
        this.loancarCarBrand = loancarCarBrand;
    }

    public void setLoancarLicensePlate(String loancarLicensePlate) {
        this.loancarLicensePlate = loancarLicensePlate;
    }

    public void setLoanRepaymentMethod(String loanRepaymentMethod) {
        this.loanRepaymentMethod = loanRepaymentMethod;
    }

    public void setLoanRepaymentMethodStr(String loanRepaymentMethodStr) {
        this.loanRepaymentMethodStr = loanRepaymentMethodStr;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public void setLoanUsage(String loanUsage) {
        this.loanUsage = loanUsage;
    }

    public void setLoanUsageStr(String loanUsageStr) {
        this.loanUsageStr = loanUsageStr;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
