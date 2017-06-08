package cn.sunfit.risk.buz.api.utils;

import java.math.BigDecimal;

public class NumberUtil {

    public static BigDecimal getBigDecimalMoney(BigDecimal money) {
        return money == null ? BigDecimal.ZERO : money;
    }

    /**
     * 采用银行家进位算法
     * 四舍六入，当为五时，如果五后为非零值则入，如果五后为零，看五前的值如果为偶数则 不进位舍弃，为奇数则进位
     * @param b
     * @param scale
     * @return
     */
    public static BigDecimal getDecimalRoundByBank(double b, int scale) {
        return new BigDecimal(String.valueOf(b)).setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 采用银行家进位算法
     * 四舍六入，当为五时，如果五后为非零值则入，如果五后为零，看五前的值如果为偶数则 不进位舍弃，为奇数则进位
     * @param b
     * @param scale
     * @return
     */
    public static double getRoundByBank(double b, int scale) {
        return new BigDecimal(String.valueOf(b)).setScale(scale, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

    /**
     * 保留几位小数，四舍五入
     * 
     * @param b
     * @return
     *
     */
    public static BigDecimal getRoundHalfUpDown(BigDecimal b, int scale) {
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 
     * 保留几位小数，四舍五入
     * @param b
     * @return
     *
     */
    public static double getRoundHalfUpValue(double b, int scale) {
        return new BigDecimal(b).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
