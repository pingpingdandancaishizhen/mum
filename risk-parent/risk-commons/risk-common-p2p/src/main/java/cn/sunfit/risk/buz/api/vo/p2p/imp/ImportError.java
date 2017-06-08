package cn.sunfit.risk.buz.api.vo.p2p.imp;

import java.io.Serializable;

public class ImportError implements Serializable {

    private static final long serialVersionUID = 1L;

    private int line;

    private String loanId;

    private String errorInfo;

    public String getErrorInfo() {
        return errorInfo;
    }

    public int getLine() {
        return line;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

}
