package cn.sunfit.risk.buz.api.vo.solution.dyc;

import java.io.Serializable;

public class DaylyFee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String termStart;

    private String termEnd;

    private Double daylyRate;

    public Double getDaylyRate() {
        return daylyRate;
    }

    public String getTermEnd() {
        return termEnd;
    }

    public String getTermStart() {
        return termStart;
    }

    public void setDaylyRate(Double daylyRate) {
        this.daylyRate = daylyRate;
    }

    public void setTermEnd(String termEnd) {
        this.termEnd = termEnd;
    }

    public void setTermStart(String termStart) {
        this.termStart = termStart;
    }

}
