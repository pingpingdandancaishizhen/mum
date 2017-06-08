package cn.sunfit.risk.buz.server.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.constants.LoanEachTimeType;
import cn.sunfit.risk.buz.api.exception.ServiceException;

/**
 * 
 * @Title: MortgageCalculatorUtil.java
 * @Package cn.sunfit.risk.buz.server.util
 * @Description: 借款计算工具类
 * @author XJ
 * @date 2017年2月15日 下午2:28:35
 * @version V1.0
 */
public class MortgageCalculatorUtil {

    /**
     * @Title: DEDXCalculator
     * @Description: 等本等息计算方法
     * @param @param invest     借款金额
     * @param @param rate       每期利率
     * @param @param period     借款期数
     * @param @param cycle      借款周期
     * @param @return   
     * @return Map<Integer,Double> 
     * @author XJ 2017年2月15日 
     * @throws
     */
    public final static List<RepaymentDetail> DBDXCalculator(BigDecimal invest, BigDecimal rate, int period) {
        List<RepaymentDetail> list = new ArrayList<RepaymentDetail>();
        // 每期本金
        double monthPri = getPerMonthPrincipal(invest, period);
        // 当期利息计算
        double interest = getInterest(invest, rate, 1);
        Map<Integer, Double> perMonthLeft = getPerMonthLeft(invest, period);
        for (int i = 1; i <= period; i++) {
            double left = perMonthLeft.get(i - 1);
            RepaymentDetail repaymentDetail = new RepaymentDetail();
            repaymentDetail.setInterest(interest);
            repaymentDetail.setPrinciple(monthPri);
            repaymentDetail.setPayment(new BigDecimal(monthPri).add(new BigDecimal(interest))
                    .setScale(2, BigDecimal.ROUND_UP).doubleValue());
            // if (i == period) {
            // repaymentDetail.setLeftPrinciple(0d);
            // } else {
            // repaymentDetail.setLeftPrinciple(invest.setScale(2, BigDecimal.ROUND_UP).doubleValue());
            // }
            left = new BigDecimal(left).subtract(new BigDecimal(monthPri)).setScale(2, BigDecimal.ROUND_UP)
                    .doubleValue();
            repaymentDetail.setLeftPrinciple(left);
            repaymentDetail.setIssue(i);
            list.add(repaymentDetail);
        }
        return list;
    }

    /**
     * @Title: DEBJCalculator
     * @Description: 等额本金计算方法
     * @param @param invest     借款金额
     * @param @param yearRate   年利率
     * @param @param period     借款期数
     * @param @param cycle      借款周期
     * @param @return   
     * @return Map<Integer,Double> 
     * @author XJ 2017年2月15日 
     * @throws
     */
    public final static List<RepaymentDetail> DEBJCalculator(BigDecimal invest, BigDecimal rate, int period) {
        List<RepaymentDetail> list = new ArrayList<RepaymentDetail>();
        // 每期本金
        double monthPri = getPerMonthPrincipal(invest, period);
        // 利率计算
        // BigDecimal rate = yearRate.divide(new BigDecimal(12 / cycle), 6, BigDecimal.ROUND_HALF_UP);
        Map<Integer, Double> perMonthLeft = getPerMonthLeft(invest, period);
        for (int i = 1; i <= period; i++) {
            RepaymentDetail repaymentDetail = new RepaymentDetail();
            // 剩余本金
            double left = perMonthLeft.get(i - 1);
            // 当期利息计算
            double interest = getInterest(new BigDecimal(left), rate, 1);

            left = new BigDecimal(left).subtract(new BigDecimal(monthPri)).setScale(2, BigDecimal.ROUND_UP)
                    .doubleValue();
            repaymentDetail.setInterest(interest);
            repaymentDetail.setPrinciple(monthPri);
            repaymentDetail.setPayment(new BigDecimal(monthPri).add(new BigDecimal(interest))
                    .setScale(2, BigDecimal.ROUND_UP).doubleValue());
            repaymentDetail.setLeftPrinciple(left);
            repaymentDetail.setIssue(i);
            list.add(repaymentDetail);
        }
        return list;
    }

    /**
     * @Title: DEBXCalculator
     * @Description: 等额本息计算方法
     * @param @param invest     借款金额
     * @param @param rate       每期利率
     * @param @param period     借款期数
     * @param @param cycle      借款周期
     * @param @return   
     * @return Map<Integer,Double> 
     * @author XJ 2017年2月15日 
     * @throws
     */
    public final static List<RepaymentDetail> DEBXCalculator(BigDecimal invest, BigDecimal rate, int period) {
        List<RepaymentDetail> list = new ArrayList<RepaymentDetail>();
        double preMonthPrincipalInterest = getPerMonthPrincipalInterest(invest, rate, period);
        Map<Integer, BigDecimal> perMonthPrincipal = getPerMonthPrincipal(invest, rate, period);
        Map<Integer, BigDecimal> perMonthInterest = getPerMonthInterest(invest, rate, period);
        double left = invest.doubleValue();
        for (int i = 1; i <= period; i++) {
            RepaymentDetail repaymentDetail = new RepaymentDetail();
            // 当期还款本金
            double monthPri = perMonthPrincipal.get(i).doubleValue();
            // 剩余本金
            left = new BigDecimal(left).subtract(perMonthPrincipal.get(i)).setScale(2, BigDecimal.ROUND_UP)
                    .doubleValue();
            // 当期利息计算
            double interest = perMonthInterest.get(i).doubleValue();
            repaymentDetail.setInterest(interest);
            repaymentDetail.setPrinciple(monthPri);
            repaymentDetail.setPayment(preMonthPrincipalInterest);
            repaymentDetail.setLeftPrinciple(left);
            repaymentDetail.setIssue(i);
            list.add(repaymentDetail);
        }
        return list;
    }

    /**
     * 计算每期利息
     * @Title: getInterest
     * @Description: 计算每期利息
     * @param @param perMonthLeft
     * @param @param rate
     * @param @param count
     * @param @return   
     * @return double 
     * @author RJS 2017年2月15日 
     * @throws
     */
    private final static double getInterest(BigDecimal perMonthLeft, BigDecimal rate, int count) {
        BigDecimal monthIncome = perMonthLeft.multiply(rate).multiply(new BigDecimal(count))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        return monthIncome.doubleValue();
    }

    /**
     * @Title: DEBXCalculator
     * @Description: 等额本息计算获取还款方式为等额本息的每月偿还利息  
     *                  公式：每月偿还利息=贷款本金×月利率×〔(1+月利率)^还款月数-(1+月利率)^(还款月序号-1)〕÷〔(1+月利率)^还款月数-1〕
     * @param @param invest     借款金额
     * @param @param rate       每期利息
     * @param @param period     借款期数
     * @param @param cycle      借款周期
     * @param @return   每月偿还本金和利息,不四舍五入，直接截取小数点最后两位  
     * @return Map<Integer,Double> 
     * @author XJ 2017年2月15日 
     * @throws
     */
    private static Map<Integer, BigDecimal> getPerMonthInterest(BigDecimal invest, BigDecimal rate, int period) {
        Map<Integer, BigDecimal> map = new HashMap<Integer, BigDecimal>();
        // 利率计算
        // double rate = yearRate.divide(new BigDecimal(12 / cycle), 6, BigDecimal.ROUND_HALF_UP).doubleValue();
        BigDecimal monthInterest;
        for (int i = 1; i < period + 1; i++) {
            BigDecimal multiply = invest.multiply(rate);
            BigDecimal sub = new BigDecimal(Math.pow(1 + rate.doubleValue(), period)).subtract(new BigDecimal(Math.pow(
                    1 + rate.doubleValue(), i - 1)));
            monthInterest = multiply.multiply(sub).divide(new BigDecimal(Math.pow(1 + rate.doubleValue(), period) - 1),
                    6, BigDecimal.ROUND_DOWN);
            monthInterest = monthInterest.setScale(2, BigDecimal.ROUND_DOWN);
            map.put(i, monthInterest);
        }
        return map;
    }

    private final static Map<Integer, Double> getPerMonthLeft(BigDecimal invest, int period) {
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        map.put(0, invest.doubleValue());
        // 每月本金
        double monthPri = getPerMonthPrincipal(invest, period);
        // 还款总本金误差 ( 每期本金 * 还款期数 - 借款金额)
        double overflow = (new BigDecimal(monthPri).multiply(new BigDecimal(period))).subtract(invest)
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        for (int i = 1; i <= period; i++) {
            if (overflow > 0d) {
                // 第一个月开始补还款本金误差 直到补完
                overflow = overflow - 0.01d;
                invest = invest.subtract(new BigDecimal(monthPri - 0.01d)).setScale(2, BigDecimal.ROUND_HALF_UP);
            } else {
                // 修补完本金误差 剩余本金为 上期本金 减当期还款本金部分
                invest = invest.subtract(new BigDecimal(monthPri)).setScale(2, BigDecimal.ROUND_HALF_UP);
            }
            map.put(i, invest.doubleValue());
        }
        return map;
    }

    /**
     * @Title: DEBXCalculator
     * @Description: 等额本息计算获取还款方式为等额本息的每月偿还本金 
     * @param @param invest     借款金额
     * @param @param yearRate   年利率
     * @param @param period     借款期数
     * @param @param cycle      借款周期
     * @param @return   每月偿还本金和利息,不四舍五入，直接截取小数点最后两位  
     * @return Map<Integer,Double> 
     * @author XJ 2017年2月15日 
     * @throws
     */
    private final static Map<Integer, BigDecimal> getPerMonthPrincipal(BigDecimal invest, BigDecimal rate, int period) {
        Map<Integer, BigDecimal> mapPrincipal = new HashMap<Integer, BigDecimal>();
        BigDecimal monthIncome = invest.multiply(
                new BigDecimal(rate.doubleValue() * Math.pow(1 + rate.doubleValue(), period))).divide(
                new BigDecimal(Math.pow(1 + rate.doubleValue(), period) - 1), 2, BigDecimal.ROUND_DOWN);
        Map<Integer, BigDecimal> mapInterest = getPerMonthInterest(invest, rate, period);
        for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {
            mapPrincipal.put(entry.getKey(), monthIncome.subtract(entry.getValue()));
        }
        return mapPrincipal;
    }

    /**
     * 均分每期本金
     * @Title: getPerMonthPrincipal
     * @param @param invest
     * @param @param period
     * @param @return   
     * @return double 
     * @author RJS 2017年2月15日 
     * @throws
     */
    private final static double getPerMonthPrincipal(BigDecimal invest, int period) {
        BigDecimal monthIncome = invest.divide(new BigDecimal(period), 2, BigDecimal.ROUND_UP);
        return monthIncome.doubleValue();
    }

    /**
     * @Description: 等额本息计算获取还款方式为等额本息的每月偿还本金和利息 
     *                  公式：每月偿还本息=〔贷款本金×利率×(1＋利率)＾还款期数〕÷〔(1＋利率)＾还款期数-1〕   
     * @param @param invest     借款金额
     * @param @param yearRate   年利率
     * @param @param period     借款期数
     * @param @param cycle      借款周期
     * @param @return   每月偿还本金和利息,不四舍五入，直接截取小数点最后两位  
     * @return Map<Integer,Double> 
     * @author XJ 2017年2月15日 
     * @throws
     */
    private final static double getPerMonthPrincipalInterest(BigDecimal invest, BigDecimal rate, int period) {
        BigDecimal monthIncome = invest.multiply(
                new BigDecimal(rate.doubleValue() * Math.pow(1 + rate.doubleValue(), period))).divide(
                new BigDecimal(Math.pow(1 + rate.doubleValue(), period) - 1), 2, BigDecimal.ROUND_DOWN);
        return monthIncome.doubleValue();
    }

    // 每期管理费
    public final static void GPSServiceFeeCalculator(List<RepaymentDetail> list, double gpsServiceFee, String gpsPayType) {
        if (StringUtils.equals(gpsPayType, "1")) {
            for (RepaymentDetail repaymentDetail : list) {
                // 每期GPS管理费用
                repaymentDetail.setExtraFee(gpsServiceFee);
            }
        } else if (StringUtils.equals(gpsPayType, "2")) {
            list.get(0).setExtraFee(gpsServiceFee);
        } else {
            throw new ServiceException("未获得GPS服务费支付方式");
        }
    }

    // 还款时间设置
    public final static void IssueDateCalculator(List<RepaymentDetail> list, Date startDate,
            LoanEachTimeType loanEachTimeType) {
        for (int i = 0; i < list.size(); i++) {
            Date issueDate = startDate;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(issueDate);
            switch (loanEachTimeType) {
                case D15:
                    calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + (15 * (i + 1))));
                    break;
                case M1:
                    calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) + (1 * (i + 1))));
                    break;
                case M2:
                    calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) + (2 * (i + 1))));
                    break;
                case M3:
                    calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) + (3 * (i + 1))));
                    break;
                case M6:
                    calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) + (6 * (i + 1))));
                    break;
                case M12:
                    calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) + (12 * (i + 1))));
                    break;
            }
            list.get(i).setIssueDate(calendar.getTime());
        }
    }

    // 每期管理费
    public final static void ManageFeeCalculator4NotYCX(List<RepaymentDetail> list, BigDecimal invest, BigDecimal rate) {
        for (RepaymentDetail repaymentDetail : list) {
            // 每期综合费用
            double interest = getInterest(invest, rate, 1);
            repaymentDetail.setManageFee(new BigDecimal(interest).subtract(
                    new BigDecimal(repaymentDetail.getInterest())).doubleValue());
        }
    }

    // 每期管理费
    public final static void ManageFeeCalculator4YCX(List<RepaymentDetail> list, BigDecimal invest, BigDecimal rate,
            int dayCount) {
        for (RepaymentDetail repaymentDetail : list) {
            // 综合费用
            double interest = getInterest(invest, rate, dayCount);
            repaymentDetail.setManageFee(new BigDecimal(interest).subtract(
                    new BigDecimal(repaymentDetail.getInterest())).doubleValue());
        }
    }

    // 每期停车费
    public final static void ParkFeeCalculator(List<RepaymentDetail> list, double parkFee, String parkPayType) {
        if (StringUtils.equals(parkPayType, "1")) {
            for (RepaymentDetail repaymentDetail : list) {
                // 每期GPS管理费用
                repaymentDetail.setExtraFee2(parkFee);
            }
        } else if (StringUtils.equals(parkPayType, "2")) {
            list.get(0).setExtraFee2(parkFee);
        } else {
            throw new ServiceException("未获得停车费支付方式");
        }
    }

    /**
     * @Title: XXHBCalculator
     * @Description: 先息后本计算方法
     * @param @param invest     借款金额
     * @param @param yearRate   年利率
     * @param @param period     借款期数
     * @param @param cycle      借款周期
     * @param @return   
     * @return Map<Integer,Double> 
     * @author XJ 2017年2月15日 
     * @throws
     */
    public final static List<RepaymentDetail> XXHBCalculator(BigDecimal invest, BigDecimal rate, int period) {
        List<RepaymentDetail> list = new ArrayList<RepaymentDetail>();
        // 利率计算
        // BigDecimal rate = yearRate.divide(new BigDecimal(12 / cycle), 6, BigDecimal.ROUND_HALF_UP);
        // 当期利息计算
        double interest = getInterest(invest, rate, 1);
        for (int i = 1; i <= period; i++) {
            RepaymentDetail repaymentDetail = new RepaymentDetail();
            System.out.println("interest" + i + "--->" + interest);
            repaymentDetail.setInterest(interest);
            if (i == period) {
                repaymentDetail.setPrinciple(invest.setScale(2, BigDecimal.ROUND_UP).doubleValue());
                repaymentDetail.setLeftPrinciple(0d);
            } else {
                repaymentDetail.setPrinciple(0d);
                repaymentDetail.setLeftPrinciple(invest.setScale(2, BigDecimal.ROUND_UP).doubleValue());
            }
            repaymentDetail.setPayment(new BigDecimal(repaymentDetail.getPrinciple()).add(new BigDecimal(interest))
                    .setScale(2, BigDecimal.ROUND_UP).doubleValue());
            repaymentDetail.setIssue(i);
            list.add(repaymentDetail);
        }
        return list;
    }

    /**
     * @Title: YCXHQCalculator
     * @Description: 一次性还清计算方法
     * @param @param invest     借款金额
     * @param @param rate       日利息
     * @param @param dayCount   借款周期
     * @param @return   
     * @return Map<Integer,Double> 
     * @author XJ 2017年2月15日 
     * @throws
     */
    public final static List<RepaymentDetail> YCXHQCalculator(BigDecimal invest, BigDecimal rate, int dayCount) {
        List<RepaymentDetail> list = new ArrayList<RepaymentDetail>();
        // 当期利息计算
        double interest = getInterest(invest, rate, dayCount);
        RepaymentDetail repaymentDetail = new RepaymentDetail();
        repaymentDetail.setInterest(interest);
        repaymentDetail.setPrinciple(invest.setScale(2, BigDecimal.ROUND_UP).doubleValue());
        repaymentDetail.setPayment(invest.add(new BigDecimal(interest)).setScale(2, BigDecimal.ROUND_UP).doubleValue());
        repaymentDetail.setLeftPrinciple(0d);
        repaymentDetail.setIssue(1);
        list.add(repaymentDetail);
        return list;
    }

}
