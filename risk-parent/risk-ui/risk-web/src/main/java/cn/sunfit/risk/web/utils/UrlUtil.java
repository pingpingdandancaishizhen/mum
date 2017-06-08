package cn.sunfit.risk.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.constants.GlobalConstants;

public class UrlUtil {

    public static String getContractSignatureUrl(String id, String name, String suffix) {
        String key = GlobalConstants.OSS_URL_HEADER + "/Contract/Signature/" + id + "/signature" + getRadom(name)
                + suffix;
        return key;
    }

    public static String getContractTemplateUrl(String id, String name, String suffix) {
        String key = GlobalConstants.OSS_URL_HEADER + "/Contract/Template/" + id + "/template" + getRadom(name)
                + suffix;
        return key;
    }

    public static String getLOGOUrl(String id, String name, String suffix) {
        String key = GlobalConstants.OSS_URL_HEADER + "/PubFile/" + new SimpleDateFormat("yyyyMM").format(new Date())
                + "/" + new SimpleDateFormat("dd").format(new Date()) + "/" + id + "/" + getRadom(name) + suffix;
        return key;
    }

    private static String getRadom(String name) {
        return name + StringUtils.leftPad(String.valueOf(RandomUtils.nextInt(999, 9999)), 4, '0');
    }

    public static String getUrl(String id, String name, String suffix) {
        String key = GlobalConstants.OSS_URL_HEADER + "/Resource/" + new SimpleDateFormat("yyyyMM").format(new Date())
                + "/" + new SimpleDateFormat("dd").format(new Date()) + "/" + id + "/" + getRadom(name) + suffix;
        return key;
    }
}
