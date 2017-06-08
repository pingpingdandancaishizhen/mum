package cn.sunfit.risk.buz.server.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.sunfit.risk.buz.api.constants.GlobalConstants;

public class UrlUtil {

    public static String getContractSignatureUrl(String id, String name, String suffix) {
        String key = GlobalConstants.OSS_URL_HEADER + "/Contract/Signature/" + id + "/signature" + name + suffix;
        return key;
    }

    public static String getContractTemplateUrl(String id, String name, String suffix) {
        String key = GlobalConstants.OSS_URL_HEADER + "/Contract/Template/" + id + "/template" + name + suffix;
        return key;
    }

    public static String getLOGOUrl(String id, String name, String suffix) {
        String key = GlobalConstants.OSS_URL_HEADER + "/PubFile/" + new SimpleDateFormat("yyyyMM").format(new Date())
                + "/" + new SimpleDateFormat("dd").format(new Date()) + "/" + id + "/" + name + suffix;
        return key;
    }

    public static String getUrl(String id, String name, String suffix) {
        String key = GlobalConstants.OSS_URL_HEADER + "/Resource/" + new SimpleDateFormat("yyyyMM").format(new Date())
                + "/" + new SimpleDateFormat("dd").format(new Date()) + "/" + id + "/" + name + suffix;
        return key;
    }
}
