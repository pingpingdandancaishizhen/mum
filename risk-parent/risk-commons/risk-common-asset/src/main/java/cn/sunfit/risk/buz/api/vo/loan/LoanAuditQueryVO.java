package cn.sunfit.risk.buz.api.vo.loan;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.constants.BpStatus;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.LoanTermType;
import cn.sunfit.risk.buz.api.constants.OperationType;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.constants.loan.LoanStatus;

public class LoanAuditQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bpId;
    private String bpNo;
    private String custName;
    private String custLicenseNum;
    private String custMobile;
    private String custType;
    private String productName;

    private Date createTime;
    // private String loanApplyPeriod;

    private String loanApplyDaylyTerm;
    private String loanApplyMonthlyTerm;
    private String loanRepaymentMethod;
    private String handlerName;
    private String handlerTaskName;
    private Integer handlerTaskDuration;
    private String handlerTaskOperation;
    private String currentTaskName;
    private String businessMan;
    private String deptName;
    private String deptHead;
    private String bpDefId;
    private String productId;
    private String bpDefKey;
    private String customerId;
    private Double applyAmount;

    private Integer bpStatus;
    private Integer loanStatus;

    private String loancarLicensePlate;

    private String loanApprovalRepaymentMethod;

    public Double getApplyAmount() {
        return applyAmount;
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public String getBpDefKey() {
        return bpDefKey;
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

    public String getBusinessMan() {
        return businessMan;
    }

    public Date getCreateTime() {
        return createTime;
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
        return CustomerType.getTypeNameStrByTypeId(custType);
    }

    public String getDeptHead() {
        return deptHead;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public Integer getHandlerTaskDuration() {
        return handlerTaskDuration;
    }

    public String getHandlerTaskDurationStr() {
        if (handlerTaskDuration != null) {
            int day = handlerTaskDuration / (1000 * 60 * 60 * 24);
            // 算小时
            int hour = handlerTaskDuration / (1000 * 60 * 60) % 24;
            // 算分钟
            int minute = handlerTaskDuration / (1000 * 60) % 60;
            // 算秒
            int second = handlerTaskDuration / (1000) % 60;
            return String.format("%d天%d小时%d分%d秒", day, hour, minute, second);
        }

        return null;
    }

    public String getHandlerTaskName() {
        return handlerTaskName;
    }

    public String getHandlerTaskOperation() {
        return handlerTaskOperation;
    }

    public String getHandlerTaskOperationStr() {
        return OperationType.getLabelByStatus(handlerTaskOperation);
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
        // return loanApplyPeriod;
    }

    public String getLoanApprovalRepaymentMethod() {
        return loanApprovalRepaymentMethod;
    }

    public String getLoanApprovalRepaymentMethodStr() {
        return LoanRepaymentType.getTypeNameStrByTypeId(loanApprovalRepaymentMethod);
    }

    public String getLoancarLicensePlate() {
        return loancarLicensePlate;
    }

    public String getLoanRepaymentMethod() {
        return loanRepaymentMethod;
    }

    public String getLoanRepaymentMethodStr() {
        return LoanRepaymentType.getTypeNameStrByTypeId(loanRepaymentMethod);
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setApplyAmount(Double applyAmount) {
        this.applyAmount = applyAmount;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setBpDefKey(String bpDefKey) {
        this.bpDefKey = bpDefKey;
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

    public void setBusinessMan(String businessMan) {
        this.businessMan = businessMan;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCurrentTaskName(String currentTaskName) {
        this.currentTaskName = currentTaskName;
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

    public void setDeptHead(String deptHead) {
        this.deptHead = deptHead;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public void setHandlerTaskDuration(Integer handlerTaskDuration) {
        this.handlerTaskDuration = handlerTaskDuration;
    }

    public void setHandlerTaskName(String handlerTaskName) {
        this.handlerTaskName = handlerTaskName;
    }

    public void setHandlerTaskOperation(String handlerTaskOperation) {
        this.handlerTaskOperation = handlerTaskOperation;
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

    public void setLoancarLicensePlate(String loancarLicensePlate) {
        this.loancarLicensePlate = loancarLicensePlate;
    }

    public void setLoanRepaymentMethod(String loanRepaymentMethod) {
        this.loanRepaymentMethod = loanRepaymentMethod;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
