package cn.sunfit.risk.buz.api.vo.p2p.product.config;

import java.io.Serializable;
import java.util.List;

public class CydFeeConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    // 还款类型
    private List<RepaymentType> repaymentTypes;
    // 还款周期
    private List<Term> terms;
    // 第一期本息扣除方式,参照枚举类FirstIssueType
    private int firstIssueType;
    // 借款人实收金额，参照枚举类LoanType
    private int loanType;
    // 支持的自动流程
    private String autoTypeCheck;
    // 月利率
    private List<CydMonthlyFee> monthlyFee;
    // 日利率/日管理费率
    private List<CydDayFee> daylyFee;
    // 违约费率
    private List<WyFee> wyFee;
    // 滞纳金率的配置方式,1:按借款金额配置 2:按借款期限配置
    private int znjCalType;
    // 滞纳金率
    private List<ZnFee> znFee;
    // 是否有保证金,参照枚举类 BzjType
    private int bzjType;
    // 保证金费率
    private List<BzjFee> bzjFee;
    // 是否有其他费用，参照枚举类OtherType
    private int otherType;
    // 其他费用
    private List<OtherFee> otherFee;
    // 是否有gps费用，参照枚举类GpsType
    private int gpsType;
    // gps初次安装情况收取的费用
    private GpsFirstFee gpsFirstFee;

    // gps服务费（按月收取）
    private GpsServiceFee gpsServiceFee;

    // 咨询费
    private ZxFee zxfee;
    // 是否有咨询费，1：有 2：无
    private int zxfType;

    // 停车费
    private ParkFee parkFee;
    // 是否有停车费 1：有 2：无
    private int parkType;

    public String getAutoTypeCheck() {
        return autoTypeCheck;
    }

    public List<BzjFee> getBzjFee() {
        return bzjFee;
    }

    public int getBzjType() {
        return bzjType;
    }

    public List<CydDayFee> getDaylyFee() {
        return daylyFee;
    }

    public int getFirstIssueType() {
        return firstIssueType;
    }

    public GpsFirstFee getGpsFirstFee() {
        return gpsFirstFee;
    }

    public GpsServiceFee getGpsServiceFee() {
        return gpsServiceFee;
    }

    public int getGpsType() {
        return gpsType;
    }

    public int getLoanType() {
        return loanType;
    }

    public List<CydMonthlyFee> getMonthlyFee() {
        return monthlyFee;
    }

    public List<OtherFee> getOtherFee() {
        return otherFee;
    }

    public int getOtherType() {
        return otherType;
    }

    public ParkFee getParkFee() {
        return parkFee;
    }

    public int getParkType() {
        return parkType;
    }

    public List<RepaymentType> getRepaymentTypes() {
        return repaymentTypes;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public List<WyFee> getWyFee() {
        return wyFee;
    }

    public List<ZnFee> getZnFee() {
        return znFee;
    }

    public int getZnjCalType() {
        return znjCalType;
    }

    public ZxFee getZxfee() {
        return zxfee;
    }

    public int getZxfType() {
        return zxfType;
    }

    public void setAutoTypeCheck(String autoTypeCheck) {
        this.autoTypeCheck = autoTypeCheck;
    }

    public void setBzjFee(List<BzjFee> bzjFee) {
        this.bzjFee = bzjFee;
    }

    public void setBzjType(int bzjType) {
        this.bzjType = bzjType;
    }

    public void setDaylyFee(List<CydDayFee> daylyFee) {
        this.daylyFee = daylyFee;
    }

    public void setFirstIssueType(int firstIssueType) {
        this.firstIssueType = firstIssueType;
    }

    public void setGpsFirstFee(GpsFirstFee gpsFirstFee) {
        this.gpsFirstFee = gpsFirstFee;
    }

    public void setGpsServiceFee(GpsServiceFee gpsServiceFee) {
        this.gpsServiceFee = gpsServiceFee;
    }

    public void setGpsType(int gpsType) {
        this.gpsType = gpsType;
    }

    public void setLoanType(int loanType) {
        this.loanType = loanType;
    }

    public void setMonthlyFee(List<CydMonthlyFee> monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public void setOtherFee(List<OtherFee> otherFee) {
        this.otherFee = otherFee;
    }

    public void setOtherType(int otherType) {
        this.otherType = otherType;
    }

    public void setParkFee(ParkFee parkFee) {
        this.parkFee = parkFee;
    }

    public void setParkType(int parkType) {
        this.parkType = parkType;
    }

    public void setRepaymentTypes(List<RepaymentType> repaymentTypes) {
        this.repaymentTypes = repaymentTypes;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }

    public void setWyFee(List<WyFee> wyFee) {
        this.wyFee = wyFee;
    }

    public void setZnFee(List<ZnFee> znFee) {
        this.znFee = znFee;
    }

    public void setZnjCalType(int znjCalType) {
        this.znjCalType = znjCalType;
    }

    public void setZxfee(ZxFee zxfee) {
        this.zxfee = zxfee;
    }

    public void setZxfType(int zxfType) {
        this.zxfType = zxfType;
    }

}
