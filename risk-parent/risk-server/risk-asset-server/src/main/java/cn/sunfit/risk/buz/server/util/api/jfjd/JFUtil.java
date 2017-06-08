package cn.sunfit.risk.buz.server.util.api.jfjd;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import orj.worf.util.DateUtils;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;

public class JFUtil {

    /**
     * 
     * @Title: getAddrCity
     * @Description: 获取市
     * @param @param addr
     * @param @return   
     * @return String 
     * @author XFL 2017年3月23日 
     * @throws
     */
    public static String getAddrCity(String addr) {
        if (StringUtils.isNotBlank(addr)) {
            String[] a = addr.split("/");
            if (a.length == 4) {
                return a[1];
            }
        }
        return null;
    }

    /**
     * 
     * @Title: getAddrCounties
     * @Description: 获取县
     * @param @param addr
     * @param @return   
     * @return String 
     * @author XFL 2017年3月23日 
     * @throws
     */
    public static String getAddrCounties(String addr) {
        if (StringUtils.isNotBlank(addr)) {
            String[] a = addr.split("/");
            if (a.length == 4) {
                return a[2];
            }
        }
        return null;
    }

    /**
     * 
     * @Title: getAddrDetail
     * @Description: 获取详细地址
     * @param @param addr
     * @param @return   
     * @return String 
     * @author XFL 2017年3月23日 
     * @throws
     */
    public static String getAddrDetail(String addr) {
        if (StringUtils.isNotBlank(addr)) {
            String[] a = addr.split("/");
            if (a.length == 4) {
                return a[3];
            }
        }
        return null;
    }

    /**
     * 
     * @Title: getAddrProvince
     * @Description: 获取省
     * @param @param addr
     * @param @return   
     * @return String 
     * @author XFL 2017年3月23日 
     * @throws
     */
    public static String getAddrProvince(String addr) {
        if (StringUtils.isNotBlank(addr)) {
            String[] a = addr.split("/");
            if (a.length == 4) {
                return a[0];
            }
        }
        return null;
    }

    public static String getDateStr(Date date) {
        if (date != null) {
            return DateUtils.format(GlobalConstants.DATE_FORMAT_DATE, date);
        }
        return null;
    }

    public static String getDecimalStr(BigDecimal a) {
        if (a != null) {
            return a.toString();
        }
        return null;
    }

    public static String getIntegerStr(Integer a) {
        if (a != null) {
            return a.toString();
        }
        return null;
    }
}
