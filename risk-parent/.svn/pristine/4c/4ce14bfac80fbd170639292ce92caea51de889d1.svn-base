package cn.sunfit.risk.buz.api.utils;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/**
 * 
 * @Title: HideInfoUtils.java
 * @Package cn.sunfit.risk.web.utils
 * @Description: 隐藏重要信息
 * @author wangguang
 * @date 2017年4月26日 上午11:22:48
 * @version V1.0
 */
public class HideInfoUtils {

    /**
     * 
     * @Title: hideIdentificationCard
     * @Description: 身份证隐藏出生信息
     * @param @param identificationCard
     * @param @return   
     * @return String 
     * @author wangguang 2017年4月26日 
     * @throws
     */
    public static String hideIdentificationCard(String identificationCard) {
        if (StringUtils.isEmpty(identificationCard)) {
            return null;
        }
        if (Pattern.matches("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$", identificationCard)) {
            return identificationCard.replaceAll("(\\d{6})\\d{6}(\\w{3})", "$1******$2");
        }
        if (Pattern.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$",
                identificationCard)) {
            return identificationCard.replaceAll("(\\d{6})\\d{8}(\\w{4})", "$1********$2");
        }
        return null;
    }

    /**
     * 
     * @Title: hidePhoneNo
     * @Description: 手机号隐藏中间4位数字
     * @param @param phoneNo
     * @param @return   
     * @return String 
     * @author wangguang 2017年4月26日 
     * @throws
     */
    public static String hidePhoneNo(String phoneNo) {
        if (StringUtils.isEmpty(phoneNo)) {
            return null;
        }
        if (Pattern.matches("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9]))\\d{8}$", phoneNo)) {
            return phoneNo.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(Pattern.matches("^[\u4e00-\u9fa5a-zA-Z0-9]{7}$", "aJH960&"));

    }

}
