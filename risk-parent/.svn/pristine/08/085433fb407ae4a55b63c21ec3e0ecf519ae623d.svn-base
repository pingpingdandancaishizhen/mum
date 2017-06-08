package cn.sunfit.risk.buz.server.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.server.service.product.fee.handler.ProductFeeCalUtil;

public class ContractFieldCalculateUtil {

    /**
     * 
     * @Title: getBzjFee
     * @Description: 计算保证金
     * @param @param attrs
     * @param @param approvedAmount
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月10日 
     * @throws
     */
    public final static BigDecimal getBzjFee(List<BPAttr> attrs, BigDecimal approvedAmount) {
        BigDecimal bzj = BigDecimal.ZERO;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanapproval_bzjFee")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                // 保证金率百分比转换
                BigDecimal bzjRate = new BigDecimal(bpAttr.getAttrValue()).divide(new BigDecimal("100"), 6,
                        BigDecimal.ROUND_HALF_UP);
                BigDecimal loanGuaranteeFee = approvedAmount.multiply(bzjRate).setScale(2, BigDecimal.ROUND_HALF_UP);
                bzj = loanGuaranteeFee;
                break;
            }
        }
        return bzj;
    }

    /**
     * 
     * @Title: getConsulting
     * @Description: 计算咨询费
     * @param @param attrs
     * @param @param approvedAmount
     * @param @param bzjFee
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月10日 
     * @throws
     */
    public static BigDecimal getConsulting(List<BPAttr> attrs, BigDecimal approvedAmount, BigDecimal bzjFee) {
        BigDecimal consultFee = new BigDecimal(0);
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), "loanofee_consulting")
                    && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                // 咨询费率
                BigDecimal consulting = new BigDecimal(bpAttr.getAttrValue()).divide(new BigDecimal("100"), 6,
                        BigDecimal.ROUND_HALF_UP);
                consultFee = (approvedAmount.add(bzjFee)).multiply(consulting).setScale(2, BigDecimal.ROUND_HALF_UP);
                break;
            }
        }
        return consultFee;
    }

    /**
     * 
     * @Title: getManageFee
     * @Description: 计算管理费
     * @param @param attrs
     * @param @param approvedAmount
     * @param @param bzjFee
     * @param @param LoanRepaymentType
     * @param @return   
     * @return BigDecimal 
     * @author RJS 2017年3月10日 
     * @throws
     */
    public static BigDecimal getManageFee(List<BPAttr> attrs, BigDecimal approvedAmount, BigDecimal bzjFee,
            LoanRepaymentType LoanRepaymentType) {
        BigDecimal manageFee = BigDecimal.ZERO;
        double totalAmount = approvedAmount.add(bzjFee).doubleValue();
        List<RepaymentDetail> repaymentDetailList = new ArrayList<RepaymentDetail>();
        switch (LoanRepaymentType) {
            case YCXHQ:
                BigDecimal rate = ProductFeeCalUtil.getInterestDayRate(attrs);
                int dayCount = ProductFeeCalUtil.getInterestDayCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.YCXHQCalculator(new BigDecimal(totalAmount), rate,
                        dayCount);
                MortgageCalculatorUtil.ManageFeeCalculator4YCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getDayZHFeeRate(attrs), dayCount);
                break;
            case DEBJ:
                BigDecimal monthRate = ProductFeeCalUtil.getInterestMonthRate(attrs);
                int monthCount = ProductFeeCalUtil.getInterestMonthCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.DEBJCalculator(new BigDecimal(totalAmount), monthRate,
                        monthCount);
                MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getMonthZHFeeRate(attrs));
                break;
            case DEBX:
                BigDecimal monthRate1 = ProductFeeCalUtil.getInterestMonthRate(attrs);
                int monthCount1 = ProductFeeCalUtil.getInterestMonthCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.DEBXCalculator(new BigDecimal(totalAmount), monthRate1,
                        monthCount1);
                MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getMonthZHFeeRate(attrs));
                break;
            case DBDX:
                BigDecimal monthRate2 = ProductFeeCalUtil.getInterestMonthRate(attrs);
                int monthCount2 = ProductFeeCalUtil.getInterestMonthCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.DBDXCalculator(new BigDecimal(totalAmount), monthRate2,
                        monthCount2);
                MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getMonthZHFeeRate(attrs));
                break;
            case XXHB:
                BigDecimal monthRate3 = ProductFeeCalUtil.getInterestMonthRate(attrs);
                int monthCount3 = ProductFeeCalUtil.getInterestMonthCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.XXHBCalculator(new BigDecimal(totalAmount), monthRate3,
                        monthCount3);
                MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getMonthZHFeeRate(attrs));
                break;
        }
        if (repaymentDetailList != null && repaymentDetailList.size() > 0) {
            for (RepaymentDetail rd : repaymentDetailList) {
                manageFee = manageFee.add(new BigDecimal(rd.getManageFee()));
            }
        }
        return manageFee.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 
     * @Title: getRepayDetail
     * @Description: 获取分期还款表     V1.4暂时不做
     * @param @param attrs
     * @param @param approvedAmount
     * @param @param bzjFee
     * @param @return   
     * @return List<List<String>> 
     * @author RJS 2017年3月10日 
     * @throws
     */
    // public static List<List<String>> getRepayDetail(List<BPAttr> attrs, BigDecimal approvedAmount, BigDecimal bzjFee)
    // {
    // List<List<String>> result = new ArrayList<List<String>>();
    // double totalAmount = approvedAmount.add(bzjFee).doubleValue();
    // List<RepaymentDetail> repaymentDetailList = new ArrayList<RepaymentDetail>();
    // LoanRepaymentType loanRepaymentType = ProductFeeCalUtil.getLoanRepaymentType(attrs);
    // switch (loanRepaymentType) {
    // case YCXHQ:
    // BigDecimal rate = ProductFeeCalUtil.getInterestDayRate(attrs);
    // int dayCount = ProductFeeCalUtil.getInterestDayCount(attrs);
    // repaymentDetailList = MortgageCalculatorUtil.YCXHQCalculator(new BigDecimal(totalAmount), rate,
    // dayCount);
    // MortgageCalculatorUtil.ManageFeeCalculator4YCX(repaymentDetailList, new BigDecimal(totalAmount),
    // ProductFeeCalUtil.getDayZHFeeRate(attrs), dayCount);
    // break;
    // case DEBJ:
    // BigDecimal monthRate = ProductFeeCalUtil.getInterestMonthRate(attrs);
    // int monthCount = ProductFeeCalUtil.getInterestMonthCount(attrs);
    // repaymentDetailList = MortgageCalculatorUtil.DEBJCalculator(new BigDecimal(totalAmount), monthRate,
    // monthCount);
    // MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
    // ProductFeeCalUtil.getMonthZHFeeRate(attrs));
    // break;
    // case DEBX:
    // BigDecimal monthRate1 = ProductFeeCalUtil.getInterestMonthRate(attrs);
    // int monthCount1 = ProductFeeCalUtil.getInterestMonthCount(attrs);
    // repaymentDetailList = MortgageCalculatorUtil.DEBXCalculator(new BigDecimal(totalAmount), monthRate1,
    // monthCount1);
    // MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
    // ProductFeeCalUtil.getMonthZHFeeRate(attrs));
    // break;
    // case DBDX:
    // BigDecimal monthRate2 = ProductFeeCalUtil.getInterestMonthRate(attrs);
    // int monthCount2 = ProductFeeCalUtil.getInterestMonthCount(attrs);
    // repaymentDetailList = MortgageCalculatorUtil.DBDXCalculator(new BigDecimal(totalAmount), monthRate2,
    // monthCount2);
    // MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
    // ProductFeeCalUtil.getMonthZHFeeRate(attrs));
    // break;
    // case XXHB:
    // BigDecimal monthRate3 = ProductFeeCalUtil.getInterestMonthRate(attrs);
    // int monthCount3 = ProductFeeCalUtil.getInterestMonthCount(attrs);
    // repaymentDetailList = MortgageCalculatorUtil.XXHBCalculator(new BigDecimal(totalAmount), monthRate3,
    // monthCount3);
    // MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
    // ProductFeeCalUtil.getMonthZHFeeRate(attrs));
    // break;
    // }
    // switch (loanRepaymentType) {
    // case YCXHQ:
    // Integer daylyTerm = new Integer(ProductFeeCalUtil.getAttr(attrs, "loanapproval_daylyTerm"));
    // Calendar calendar = Calendar.getInstance();
    // // calendar.setTime(repayDay);
    // calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + daylyTerm));
    // repaymentDetailList.get(0).setIssueDate(calendar.getTime());
    // break;
    // default:
    // // MortgageCalculatorUtil.IssueDateCalculator(repaymentDetailList, repayDay,
    // // ProductFeeCalUtil.getEachTime(attrs));
    // break;
    // }
    // List<String> title = new ArrayList<String>();
    // title.add("还款日期");
    // title.add("期次");
    // title.add("应还金额");
    // result.add(title);
    // if (repaymentDetailList != null && repaymentDetailList.size() > 0) {
    // for (RepaymentDetail repaymentDetail : repaymentDetailList) {
    // List<String> item = new ArrayList<String>();
    // item.add(DateUtils.getStandardDate(repaymentDetail.getIssueDate()));
    // item.add(repaymentDetail.getIssue() + "");
    // item.add((repaymentDetail.getManageFee() + repaymentDetail.getManageFee()
    // + repaymentDetail.getExtraFee() + repaymentDetail.getExtraFee2())
    // + "");
    // result.add(item);
    // }
    // }
    // return result;
    // }
}
