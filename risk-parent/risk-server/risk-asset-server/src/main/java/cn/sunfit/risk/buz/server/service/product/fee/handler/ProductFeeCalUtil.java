package cn.sunfit.risk.buz.server.service.product.fee.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.loan.LoanFee;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.constants.LoanEachTimeType;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.server.util.MortgageCalculatorUtil;

/**
 * 产品费率计算工具 
 * @Title: ProductFeeCalUtil.java
 * @Package cn.sunfit.risk.buz.server.service.product.fee
 * @Description: TODO
 * @author RJS
 * @date 2017年3月7日 下午8:58:18
 * @version V1.0
 */
public class ProductFeeCalUtil {

    public static String getAttr(List<BPAttr> attrs, String attrName) {
        String attr = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), attrName) && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                attr = bpAttr.getAttrValue();
                break;
            }
        }
        return attr;
    }

    public final static BigDecimal getDayZHFeeRate(List<BPAttr> attrs) {
        BigDecimal daylyZHFee = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_daylyZHFee")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                daylyZHFee = new BigDecimal(bpAttr.getAttrValue());
                break;
            }
        }
        if (daylyZHFee == null) {
            throw new ServiceException("未获得日综合费率");
        }
        // 返回前 换算为百分比
        return daylyZHFee.divide(new BigDecimal("100")).setScale(6, BigDecimal.ROUND_HALF_UP);
    }

    public final static LoanEachTimeType getEachTime(List<BPAttr> attrs) {
        LoanEachTimeType eachTimes = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_eachTimes")) {
                eachTimes = LoanEachTimeType.getTypeByStatus(bpAttr.getAttrValue());
                break;
            }
        }
        if (eachTimes == null) {
            throw new ServiceException("未获得每期时长");
        } else {
            return eachTimes;
        }
    }

    public static int getInterestDayCount(List<BPAttr> attrs) {
        Integer daylyTerm = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_daylyTerm")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                daylyTerm = new Integer(bpAttr.getAttrValue());
                break;
            }
        }
        if (daylyTerm == null) {
            throw new ServiceException("未获得一次性还款时长");
        }
        // 返回前 换算为百分比
        return daylyTerm;
    }

    public final static BigDecimal getInterestDayRate(List<BPAttr> attrs) {
        BigDecimal daylyFee = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_daylyRate")) {
                daylyFee = new BigDecimal(bpAttr.getAttrValue());
                break;
            }
        }
        if (daylyFee == null) {
            throw new ServiceException("未获得日利率");
        }
        // 返回前 换算为百分比
        return daylyFee.divide(new BigDecimal("100")).setScale(6, BigDecimal.ROUND_HALF_UP);
    }

    public static int getInterestMonthCount(List<BPAttr> attrs) {
        Integer monthlyCount = null;
        Integer monthlyTerm = null;
        Integer monthlyEachTime = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_monthlyTerm")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                if (StringUtils.startsWith(bpAttr.getAttrValue(), "M")) {
                    monthlyTerm = new Integer(bpAttr.getAttrValue().substring(1)) * 30;
                } else if (StringUtils.startsWith(bpAttr.getAttrValue(), "D")) {
                    monthlyTerm = new Integer(bpAttr.getAttrValue().substring(1));
                }
                break;
            }
        }
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_eachTimes")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                if (StringUtils.startsWith(bpAttr.getAttrValue(), "M")) {
                    monthlyEachTime = new Integer(bpAttr.getAttrValue().substring(1)) * 30;
                } else if (StringUtils.startsWith(bpAttr.getAttrValue(), "D")) {
                    monthlyEachTime = new Integer(bpAttr.getAttrValue().substring(1));
                }
                break;
            }
        }
        if (monthlyTerm == null || monthlyEachTime == null) {
            throw new ServiceException("未获得还款时长");
        } else {
            monthlyCount = monthlyTerm / monthlyEachTime;
        }
        // 返回前 换算为百分比
        return monthlyCount;
    }

    public final static BigDecimal getInterestMonthRate(List<BPAttr> attrs) {
        BigDecimal monthlyFee = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_monthlyRate")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                monthlyFee = new BigDecimal(bpAttr.getAttrValue());
                break;
            }
        }
        if (monthlyFee == null) {
            throw new ServiceException("未获得月利率");
        }
        LoanEachTimeType eachTimes = getEachTime(attrs);
        switch (eachTimes) {
            case D15:
                monthlyFee = monthlyFee.divide(new BigDecimal("2")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M1:
                break;
            case M2:
                monthlyFee = monthlyFee.multiply(new BigDecimal("2")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M3:
                monthlyFee = monthlyFee.multiply(new BigDecimal("3")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M6:
                monthlyFee = monthlyFee.multiply(new BigDecimal("6")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M12:
                monthlyFee = monthlyFee.multiply(new BigDecimal("12")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
        }
        // 返回前 换算为百分比
        return monthlyFee.divide(new BigDecimal("100")).setScale(6, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 获得还款方式
     * @Title: getLoanRepaymentType
     * @Description: TODO
     * @param @param list 存库容器
     * @param @param attrs
     * @param @param approvedAmount
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月7日 
     * @throws
     */
    public final static LoanRepaymentType getLoanRepaymentType(List<BPAttr> attrs) {
        LoanRepaymentType loanRepaymentType = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_repaymentTypes")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                loanRepaymentType = LoanRepaymentType.getTypeNameByTypeId(bpAttr.getAttrValue());
                break;
            }
        }
        if (loanRepaymentType == null) {
            throw new ServiceException("未获得还款方式");
        }
        return loanRepaymentType;
    }

    /**
     * 判断是否期初支付
     * @Title: isFirstPay
     * @Description: TODO
     * @param @param attrs
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月7日 
     * @throws
     */
    public final static BigDecimal getManageFeeRate(List<BPAttr> attrs) {
        BigDecimal monthlyGLFee = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_monthlyGLFee")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                monthlyGLFee = new BigDecimal(bpAttr.getAttrValue());
                break;
            }
        }
        if (monthlyGLFee == null) {
            throw new ServiceException("未获得月管理费率");
        }
        LoanEachTimeType eachTimes = getEachTime(attrs);
        switch (eachTimes) {
            case D15:
                monthlyGLFee = monthlyGLFee.divide(new BigDecimal("2")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M1:
                break;
            case M2:
                monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("2")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M3:
                monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("3")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M6:
                monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("6")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M12:
                monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("12")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
        }
        // 返回前 换算为百分比
        return monthlyGLFee.divide(new BigDecimal("100")).setScale(6, BigDecimal.ROUND_HALF_UP);
    }

    public final static BigDecimal getMonthZHFeeRate(List<BPAttr> attrs) {
        BigDecimal monthlyGLFee = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_monthlyZHFee")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                monthlyGLFee = new BigDecimal(bpAttr.getAttrValue());
                break;
            }
        }
        if (monthlyGLFee == null) {
            throw new ServiceException("未获得月综合费率");
        }
        LoanEachTimeType eachTimes = getEachTime(attrs);
        switch (eachTimes) {
            case D15:
                monthlyGLFee = monthlyGLFee.divide(new BigDecimal("2")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M1:
                break;
            case M2:
                monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("2")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M3:
                monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("3")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M6:
                monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("6")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
            case M12:
                monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("12")).setScale(6, BigDecimal.ROUND_HALF_UP);
                break;
        }
        // 返回前 换算为百分比
        return monthlyGLFee.divide(new BigDecimal("100")).setScale(6, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal getRate(List<BPAttr> attrs, String attrName) {
        BigDecimal fee = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), attrName) && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                // 获得GPS安装费
                fee = new BigDecimal(bpAttr.getAttrValue());
                break;
            }
        }
        return fee;
    }

    public static Date getRepayDayCount(List<BPAttr> attrs, Date loanDay) {
        String daylyTerm = null;
        String repayDay = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanofee_repay_day_type")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                daylyTerm = bpAttr.getAttrValue();
                break;
            }
        }
        if (daylyTerm == null) {
            throw new ServiceException("未获得还款日");
        }
        if (StringUtils.equals(daylyTerm, "1")) {
            return loanDay;
        } else {
            for (BPAttr bpAttr : attrs) {
                if (StringUtils.equals(bpAttr.getAttrName(), "loanofee_repay_day")
                        && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                    repayDay = bpAttr.getAttrValue();
                    break;
                }
            }
            if (repayDay == null) {
                throw new ServiceException("未获得还款日");
            }
            Date result = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(result);
            calendar.set(Calendar.DATE, new Integer(repayDay));
            return calendar.getTime();
        }
    }

    /**
     * 判断是否期初支付
     * @Title: isFirstPay
     * @Description: TODO
     * @param @param attrs
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月7日 
     * @throws
     */
    public final static boolean isFirstPay(List<BPAttr> attrs) {
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_supportFirstPay")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                // 1位期初支付 2为期末支付
                if (StringUtils.equals(bpAttr.getAttrValue(), "1")) {
                    return true;
                }
                if (StringUtils.equals(bpAttr.getAttrValue(), "2")) {
                    return false;
                }
                throw new ServiceException("未获得首期支付方式");
            }
        }
        throw new ServiceException("未获得首期支付方式");
    }

    /**
     * 计算保证金
     * @Title: setBzjFee
     * @Description: TODO
     * @param @param list 存库容器
     * @param @param attrs
     * @param @param approvedAmount
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月7日 
     * @throws
     */
    public final static BigDecimal setBzjFee(List<LoanFee> list, List<BPAttr> attrs, BigDecimal approvedAmount) {
        BigDecimal bzj = BigDecimal.ZERO;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_bzjFee")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                // 保证金率百分比转换
                BigDecimal bzjRate = new BigDecimal(bpAttr.getAttrValue()).divide(new BigDecimal("100"), 6,
                        BigDecimal.ROUND_HALF_UP);
                LoanFee bzjFee = new LoanFee();
                BigDecimal loanGuaranteeFee = approvedAmount.multiply(bzjRate).setScale(2, BigDecimal.ROUND_HALF_UP);
                bzjFee.setId(IdUtil.geneId());
                bzjFee.setFeeName("loan_guarantee_fee");
                bzjFee.setFeeValue(loanGuaranteeFee);
                list.add(bzjFee);
                bzj = loanGuaranteeFee;
                break;
            }
        }
        return bzj;
    }

    /**
     * 计算咨询费
     * @Title: setConsulting
     * @Description: TODO
     * @param @param list 存库容器
     * @param @param attrs
     * @param @param approvedAmount
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月7日 
     * @throws
     */
    protected final static void setConsulting(List<LoanFee> list, List<BPAttr> attrs, BigDecimal approvedAmount,
            BigDecimal bzjFee) {
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanofee_consulting")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                // 咨询费率
                BigDecimal consulting = new BigDecimal(bpAttr.getAttrValue()).divide(new BigDecimal("100"), 6,
                        BigDecimal.ROUND_HALF_UP);
                LoanFee consultingFee = new LoanFee();
                BigDecimal consultFee = (approvedAmount.add(bzjFee)).multiply(consulting).setScale(2,
                        BigDecimal.ROUND_HALF_UP);
                consultingFee.setId(IdUtil.geneId());
                consultingFee.setFeeName("loan_consult_fee");
                consultingFee.setFeeValue(consultFee);
                list.add(consultingFee);
            }
        }
    }

    /**
     * 计算GPS安装费
     * @Title: setGPSFee
     * @Description: TODO
     * @param @param list 存库容器
     * @param @param attrs
     * @param @param approvedAmount
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月7日 
     * @throws
     */
    protected final static void setGPSFee(List<LoanFee> list, List<BPAttr> attrs) {
        LoanFee gpsFee = new LoanFee();
        BigDecimal fee = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanofee_gps")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                // 获得GPS安装费
                fee = new BigDecimal(bpAttr.getAttrValue());
                gpsFee.setFeeValue(fee);
                break;
            }
        }
        if (fee == null) {
            throw new ServiceException("未获得GPS安装费");
        }
        gpsFee.setId(IdUtil.geneId());
        gpsFee.setFeeName("loan_gps_fee");
        list.add(gpsFee);
    }

    /**
     * 计算GPS安装费
     * @Title: setGPSFee
     * @Description: TODO
     * @param @param list 存库容器
     * @param @param attrs
     * @param @param approvedAmount
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月7日 
     * @throws
     */
    public final static double setGPSServiceFee(List<LoanFee> list, List<BPAttr> attrs) {
        LoanFee gpsFee = new LoanFee();
        BigDecimal fee = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanofee_gpsservice")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                // 获得GPS安装费
                fee = new BigDecimal(bpAttr.getAttrValue());
                if (isFirstPay(attrs)) {
                    gpsFee.setFeeValue(fee);
                } else {
                    gpsFee.setFeeValue(BigDecimal.ZERO);
                }
                break;
            }
        }
        if (fee == null) {
            throw new ServiceException("未获得GPS服务费");
        }
        gpsFee.setId(IdUtil.geneId());
        gpsFee.setFeeName("loan_gpsservice_fee");
        list.add(gpsFee);
        return fee.doubleValue();
    }

    // 计算首期利息
    protected final static void setInterest(List<LoanFee> list, List<BPAttr> attrs, BigDecimal approvedAmount,
            BigDecimal bzjFee, LoanRepaymentType LoanRepaymentType) {
        LoanFee manageFee = new LoanFee();
        manageFee.setId(IdUtil.geneId());
        manageFee.setFeeName("loan_interest");
        switch (LoanRepaymentType) {
            case YCXHQ:
                manageFee.setFeeValue(BigDecimal.ZERO);
                break;
            default:
                if (isFirstPay(attrs)) {
                    BigDecimal interestRate = getInterestMonthRate(attrs);
                    BigDecimal fee = (approvedAmount.add(bzjFee)).multiply(interestRate).setScale(2,
                            BigDecimal.ROUND_HALF_UP);
                    manageFee.setFeeValue(fee);
                } else {
                    manageFee.setFeeValue(BigDecimal.ZERO);
                }
                break;
        }
        list.add(manageFee);
    }

    // 计算管理费
    protected final static void setManageFee(List<LoanFee> list, List<BPAttr> attrs, BigDecimal approvedAmount,
            BigDecimal bzjFee, LoanRepaymentType LoanRepaymentType) {
        LoanFee manageFee = new LoanFee();
        manageFee.setId(IdUtil.geneId());
        manageFee.setFeeName("loan_manage_fee");
        switch (LoanRepaymentType) {
            case YCXHQ:
                if (isFirstPay(attrs)) {
                    throw new ServiceException("一次性还清不支持期初支付");
                } else {
                    manageFee.setFeeValue(BigDecimal.ZERO);
                }
                break;
            default:
                if (isFirstPay(attrs)) {
                    BigDecimal manageFeeRate = getManageFeeRate(attrs);
                    BigDecimal fee = (approvedAmount.add(bzjFee)).multiply(manageFeeRate).setScale(2,
                            BigDecimal.ROUND_HALF_UP);
                    manageFee.setFeeValue(fee);
                } else {
                    manageFee.setFeeValue(BigDecimal.ZERO);
                }
                break;
        }
        list.add(manageFee);
    }

    /**
     * 计算停车费
     * @Title: setGPSFee
     * @Description: TODO
     * @param @param list 存库容器
     * @param @param attrs
     * @param @param approvedAmount
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月7日 
     * @throws
     */
    public final static double setParkFee(List<LoanFee> list, List<BPAttr> attrs) {
        LoanFee gpsFee = new LoanFee();
        BigDecimal fee = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanofee_park")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                // 获得GPS安装费
                fee = new BigDecimal(bpAttr.getAttrValue());
                if (isFirstPay(attrs)) {
                    gpsFee.setFeeValue(fee);
                } else {
                    gpsFee.setFeeValue(BigDecimal.ZERO);
                }
                break;
            }
        }
        if (fee == null) {
            throw new ServiceException("未获得停车费");
        }
        gpsFee.setId(IdUtil.geneId());
        gpsFee.setFeeName("loan_park_fee");
        list.add(gpsFee);
        return fee.doubleValue();
    }

    // 计算首期本金
    protected final static void setPrinciple(List<LoanFee> list, List<BPAttr> attrs, BigDecimal approvedAmount,
            BigDecimal bzjFee, LoanRepaymentType LoanRepaymentType) {
        LoanFee fee = new LoanFee();
        fee.setId(IdUtil.geneId());
        fee.setFeeName("loan_principle");
        if (!isFirstPay(attrs)) {
            fee.setFeeValue(BigDecimal.ZERO);
        } else {
            // 如果是期初支付
            List<RepaymentDetail> repaymentDetailList = new ArrayList<RepaymentDetail>();
            switch (LoanRepaymentType) {
                case YCXHQ:
                    throw new ServiceException("一次性还清不支持期初支付");
                case XXHB:
                    fee.setFeeValue(BigDecimal.ZERO);
                    break;
                // TODO
                case DEBJ:
                    BigDecimal monthRate = ProductFeeCalUtil.getInterestMonthRate(attrs);
                    int monthCount = ProductFeeCalUtil.getInterestMonthCount(attrs);
                    repaymentDetailList = MortgageCalculatorUtil.DEBJCalculator(approvedAmount.add(bzjFee), monthRate,
                            monthCount);
                    if (repaymentDetailList != null && repaymentDetailList.size() > 0) {
                        fee.setFeeValue(new BigDecimal(repaymentDetailList.get(0).getPrinciple()));
                    } else {
                        throw new ServiceException("生成首期还款本金失败");
                    }
                    break;
                case DEBX:
                    BigDecimal monthRate1 = ProductFeeCalUtil.getInterestMonthRate(attrs);
                    int monthCount1 = ProductFeeCalUtil.getInterestMonthCount(attrs);
                    repaymentDetailList = MortgageCalculatorUtil.DEBXCalculator(approvedAmount.add(bzjFee), monthRate1,
                            monthCount1);
                    if (repaymentDetailList != null && repaymentDetailList.size() > 0) {
                        fee.setFeeValue(new BigDecimal(repaymentDetailList.get(0).getPrinciple()));
                    } else {
                        throw new ServiceException("生成首期还款本金失败");
                    }
                    break;
                case DBDX:
                    BigDecimal monthRate2 = ProductFeeCalUtil.getInterestMonthRate(attrs);
                    int monthCount2 = ProductFeeCalUtil.getInterestMonthCount(attrs);
                    repaymentDetailList = MortgageCalculatorUtil.DBDXCalculator(approvedAmount.add(bzjFee), monthRate2,
                            monthCount2);
                    if (repaymentDetailList != null && repaymentDetailList.size() > 0) {
                        fee.setFeeValue(new BigDecimal(repaymentDetailList.get(0).getPrinciple()));
                    } else {
                        throw new ServiceException("生成首期还款本金失败");
                    }
                    break;
            }

        }
        list.add(fee);
    }

}
