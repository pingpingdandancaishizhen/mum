package cn.sunfit.risk.buz.api.beans.api.jfjd;

import java.io.Serializable;

import cn.sunfit.risk.buz.api.vo.solution.dyc.MonthlyFee;

public class JFMonthlyFee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String term;

    private String termText;

    public JFMonthlyFee() {

    }

    public JFMonthlyFee(MonthlyFee fee) {
        if (fee != null) {
            term = fee.getTerm();
            termText = fee.getTermText();
        }
    }

    public String getTerm() {
        return term;
    }

    public String getTermText() {
        return termText;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setTermText(String termText) {
        this.termText = termText;
    }

}
