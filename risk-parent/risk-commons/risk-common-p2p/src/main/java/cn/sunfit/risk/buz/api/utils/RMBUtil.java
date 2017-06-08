package cn.sunfit.risk.buz.api.utils;

import java.math.BigDecimal;

/**
 * 软妹币大小写转换工具
 * 2016年2月2日 下午1:47:17
 */
public class RMBUtil {

    // public static String hangeToBig(double value) {
    // if (value == 0) {
    // return "零元整";
    // }
    // char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
    // char[] vunit = { '万', '亿' }; // 段名表示
    // char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
    // long midVal = (long) (value * 100); // 转化成整形
    // String valStr = String.valueOf(midVal); // 转化成字符串
    //
    // String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
    // String rail = valStr.substring(valStr.length() - 2); // 取小数部分
    //
    // String prefix = ""; // 整数部分转化的结果
    // String suffix = ""; // 小数部分转化的结果
    // // 处理小数点后面的数
    // if (rail.equals("00")) { // 如果小数部分为0
    // suffix = "整";
    // } else {
    // suffix = digit[rail.charAt(0) - '0'] + "角" + digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
    // }
    // // 处理小数点前面的数
    // char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
    // char zero = '0'; // 标志'0'表示出现过0
    // byte zeroSerNum = 0; // 连续出现0的次数
    // for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
    // int idx = (chDig.length - i - 1) % 4; // 取段内位置
    // int vidx = (chDig.length - i - 1) / 4; // 取段位置
    // if (chDig[i] == '0') { // 如果当前字符是0
    // zeroSerNum++; // 连续0次数递增
    // if (zero == '0') { // 标志
    // zero = digit[0];
    // } else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
    // prefix += vunit[vidx - 1];
    // zero = '0';
    // }
    // continue;
    // }
    // zeroSerNum = 0; // 连续0次数清零
    // if (zero != '0') { // 如果标志不为0,则加上,例如万,亿什么的
    // prefix += zero;
    // zero = '0';
    // }
    // prefix += digit[chDig[i] - '0']; // 转化该数字表示
    // if (idx > 0)
    // prefix += hunit[idx - 1];
    // if (idx == 0 && vidx > 0) {
    // prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
    // }
    // }
    //
    // if (prefix.length() > 0)
    // prefix += '圆'; // 如果整数部分存在,则有圆的字样
    // return prefix + suffix; // 返回正确表示
    // }
    //
    // public static void main(String[] args) {
    // System.out.println(RMBUtil.hangeToBig(500000.23));
    // }

    /**
          * 汉语中数字大写
          */
    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
    /**
     * 汉语中货币单位大写，这样的设计类似于占位符
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "圆", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿",
            "拾", "佰", "仟", "兆", "拾", "佰", "仟" };
    /**
     * 特殊字符：整
     */
    private static final String CN_FULL = "整";
    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";
    /**
     * 金额的精度，默认值为2
     */
    private static final int MONEY_PRECISION = 2;
    /**
     * 特殊字符：零元整
     */
    private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

    /**
     * 把输入的金额转换为汉语中人民币的大写
     * 
     * @param numberOfMoney
     *            输入的金额
     * @return 对应的汉语大写
     */
    public static String hangeToBig(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();
        // -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
        // positive.
        int signum = numberOfMoney.signum();
        // 零元整的情况
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }
        // 这里会进行金额的四舍五入
        long number = numberOfMoney.movePointRight(MONEY_PRECISION).setScale(0, 4).abs().longValue();
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                // if(!(getZero) && numIndex != 2)
                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        // 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
        if (!(scale > 0)) {
            sb.append(CN_FULL);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        double money = 500000.01;
        BigDecimal numberOfMoney = new BigDecimal(money);
        String s = RMBUtil.hangeToBig(numberOfMoney);
        System.out.println("你输入的金额为：【" + money + "】   #--# [" + s.toString() + "]");
    }
}
