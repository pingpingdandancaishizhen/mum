package cn.sunfit.risk.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class UniqueIDUtil {

    private final static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");

    /**
     * 生成流水号
     */
    public static String genFlowNo() {
        return df.format(new Date()).concat(String.valueOf(rand(6)));
    }

    /**
     * 获取卡号的指定后X位
     */
    public static String lastCardNum(String cardNum, int num) {
        if (StringUtils.isBlank(cardNum)) {
            return cardNum;
        }
        return cardNum.substring(cardNum.length() - num < 0 ? 0 : cardNum.length() - num);
    }

    private static int rand(int n) {
        int ans = 0;
        while (Math.log10(ans) + 1 < n)
            ans = (int) (Math.random() * Math.pow(10, n));
        return ans;
    }
}
