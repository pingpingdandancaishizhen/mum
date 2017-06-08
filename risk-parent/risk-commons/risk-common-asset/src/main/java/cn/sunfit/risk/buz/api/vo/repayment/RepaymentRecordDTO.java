package cn.sunfit.risk.buz.api.vo.repayment;

import java.math.BigDecimal;
import java.util.List;

import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentRecord;

/**
 * 
 * @Title: RepaymentDetailDTO.java
 * @Package cn.sunfit.risk.buz.api.vo.repayment
 * @Description: TODO
 * @author RJS
 * @date 2017年3月3日 下午2:42:16
 * @version V1.0
 */
public class RepaymentRecordDTO extends RepaymentDetail {

    private static final long serialVersionUID = 1L;

    private boolean isCurrent;

    private Integer overdueDay;

    private BigDecimal overdueFee;

    private List<RepaymentRecord> records;

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public BigDecimal getOverdueFee() {
        return overdueFee;
    }

    public List<RepaymentRecord> getRecords() {
        return records;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public void setOverdueFee(BigDecimal overdueFee) {
        this.overdueFee = overdueFee;
    }

    public void setRecords(List<RepaymentRecord> records) {
        this.records = records;
    }

}
