package cn.sunfit.risk.buz.api.vo.p2p.product.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseFeeConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    // 保证金费率
    private List<FeeRegin> bzjFee;
    // 违约金费率
    private List<FeeRegin> wyFee;
    // 滞纳金
    private List<FeeRegin> znjFee;

    // 每期时长
    private List<EachTime> eachTimes;
    // 还款方式
    private List<RepaymentType> repaymentTypes;

    // 固定费率 1固定综合费率 2固定管理费
    private String feeCaType;

    // 滞纳金计算方式 1 剩余本金*逾期天数*滞纳金率 2合同金额*逾期天数*滞纳金率
    private String znjFeeCal;

    public List<EachTime> buildEachTime(EachTime... as) {
        List<EachTime> l = new ArrayList<EachTime>();
        for (EachTime a : as) {
            l.add(a);
        }
        return l;

    }

    public List<FeeRegin> buildFeeRegin(FeeRegin... as) {
        List<FeeRegin> l = new ArrayList<FeeRegin>();
        for (FeeRegin a : as) {
            l.add(a);
        }
        return l;

    }

    public List<FeeRegin> getBzjFee() {
        return bzjFee;
    }

    public List<EachTime> getEachTimes() {
        return eachTimes;
    }

    public String getFeeCaType() {
        return feeCaType;
    }

    public List<RepaymentType> getRepaymentTypes() {
        return repaymentTypes;
    }

    public List<FeeRegin> getWyFee() {
        return wyFee;
    }

    public List<FeeRegin> getZnjFee() {
        return znjFee;
    }

    public String getZnjFeeCal() {
        return znjFeeCal;
    }

    public void setBzjFee(List<FeeRegin> bzjFee) {
        this.bzjFee = bzjFee;
    }

    public void setEachTimes(List<EachTime> eachTimes) {
        this.eachTimes = eachTimes;
    }

    public void setFeeCaType(String feeCaType) {
        this.feeCaType = feeCaType;
    }

    public void setRepaymentTypes(List<RepaymentType> repaymentTypes) {
        this.repaymentTypes = repaymentTypes;
    }

    public void setWyFee(List<FeeRegin> wyFee) {
        this.wyFee = wyFee;
    }

    public void setZnjFee(List<FeeRegin> znjFee) {
        this.znjFee = znjFee;
    }

    public void setZnjFeeCal(String znjFeeCal) {
        this.znjFeeCal = znjFeeCal;
    }
}
