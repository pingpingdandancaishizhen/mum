package cn.sunfit.risk.buz.api.vo.loan;

import java.util.Date;

import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.vo.ReqBase;

public class LoanQueryReq extends ReqBase {

    private static final long serialVersionUID = 1L;

    // 借款合同号
    private String loanContractId;

    // 借款人
    private String loanCustName;

    // 借款手机号
    private String loanCustMobile;

    private String deptCode;

    private Date startDate;

    private Date endDate;

    private String deptId;

    // 还款类型
    private LoanRepaymentType repaymentType;

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public Date getEndDate() {
        return endDate;
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

    public String getRepaymentType() {
        if (repaymentType != null) {
            return repaymentType.getTypeId();
        } else {
            return null;
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = LoanRepaymentType.getTypeNameByTypeId(repaymentType);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
