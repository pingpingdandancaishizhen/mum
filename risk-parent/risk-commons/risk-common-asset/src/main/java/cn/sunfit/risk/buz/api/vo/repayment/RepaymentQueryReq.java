package cn.sunfit.risk.buz.api.vo.repayment;

import java.util.Date;

import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class RepaymentQueryReq extends CorpReqBase {

    private static final long serialVersionUID = 1L;

    // 借款合同号
    private String loanContractId;

    // 借款人
    private String loanCustName;

    private String status;

    // 还款类型
    private LoanRepaymentType repaymentType;

    private Date startDate;

    private Date endDate;

    private String deptId;

    public String getDeptId() {
        return deptId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getLoanContractId() {
        return loanContractId;
    }

    public String getLoanCustName() {
        return loanCustName;
    }

    public String getRepaymentType() {
        if (repaymentType != null) {
            return repaymentType.getTypeId();
        }
        return null;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStatus() {
        return status;
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

    public void setLoanCustName(String loanCustName) {
        this.loanCustName = loanCustName;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = LoanRepaymentType.getTypeNameByTypeId(repaymentType);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
