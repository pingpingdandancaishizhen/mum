package cn.sunfit.risk.buz.api.vo.solution.dyc;

import java.io.Serializable;

public class MonthlyZHFee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String deptId;

    private Double rate;

    private String deptName;

    public String getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public Double getRate() {
        return rate;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}
