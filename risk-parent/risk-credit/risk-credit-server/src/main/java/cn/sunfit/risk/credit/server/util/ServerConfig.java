package cn.sunfit.risk.credit.server.util;

/**
 * 
 * @Title: ServerConfig.java
 * @date 2016年7月28日 下午1:26:13
 * @version V1.0
 */
public class ServerConfig {

    // 车鉴定服务接口配置
    public static String JXL_SERVICE_URL;
    public static String JXL_SERVICE_ORG_NAME;
    public static String JXL_SERVICE_ACCESS_TOKEN;
    public static String JXL_SERVICE_CLIENT_SECRET;

    // 车鉴定服务接口配置
    public static String CJD_SERVICE_PRIVATE_KEY;
    public static String CJD_SERVICE_USER_NAME;
    public static String CJD_SERVICE_PASSWORD;
    public static String CJD_SERVICE_URL;

    // 同盾服务接口配置
    public static String RISK_FRAUDMETRIX_PARTNERCODE;
    public static String RISK_FRAUDMETRIX_SECRETKEY;
    public static String RISK_FRAUDMETRIX_EVENTID;

    // 鹏元征信接口配置
    public static String PY_SERVICE_URL;

    // 上海征信接口配置
    public static String NFCS_HOST; // 地址
    public static Integer NFCS_PORT; // 端口
    public static String NFCS_URL_PREFIX; // 地址前缀,此地址的获取请参考上海资信《JAVA开发人员必读.doc》
    public static String NFCS_USER_NAME; // VPN用户名
    public static String NFCS_PASSWORD; // VPN登录密码
    public static String NFCS_ORG_CODE; // 机构号
    public static String NFCS_SSECRET; // NFCS分配的报文上传密码(直连密码)

    public static String getCJD_SERVICE_PASSWORD() {
        return CJD_SERVICE_PASSWORD;
    }

    public static String getCJD_SERVICE_PRIVATE_KEY() {
        return CJD_SERVICE_PRIVATE_KEY;
    }

    public static String getCJD_SERVICE_URL() {
        return CJD_SERVICE_URL;
    }

    public static String getCJD_SERVICE_USER_NAME() {
        return CJD_SERVICE_USER_NAME;
    }

    public static String getJXL_SERVICE_ACCESS_TOKEN() {
        return JXL_SERVICE_ACCESS_TOKEN;
    }

    public static String getJXL_SERVICE_CLIENT_SECRET() {
        return JXL_SERVICE_CLIENT_SECRET;
    }

    public static String getJXL_SERVICE_ORG_NAME() {
        return JXL_SERVICE_ORG_NAME;
    }

    public static String getJXL_SERVICE_URL() {
        return JXL_SERVICE_URL;
    }

    public static String getNFCS_HOST() {
        return NFCS_HOST;
    }

    public static String getNFCS_ORG_CODE() {
        return NFCS_ORG_CODE;
    }

    public static String getNFCS_PASSWORD() {
        return NFCS_PASSWORD;
    }

    public static Integer getNFCS_PORT() {
        return NFCS_PORT;
    }

    public static String getNFCS_SSECRET() {
        return NFCS_SSECRET;
    }

    public static String getNFCS_URL_PREFIX() {
        return NFCS_URL_PREFIX;
    }

    public static String getNFCS_USER_NAME() {
        return NFCS_USER_NAME;
    }

    public static String getPY_SERVICE_URL() {
        return PY_SERVICE_URL;
    }

    public static String getRISK_FRAUDMETRIX_EVENTID() {
        return RISK_FRAUDMETRIX_EVENTID;
    }

    public static String getRISK_FRAUDMETRIX_PARTNERCODE() {
        return RISK_FRAUDMETRIX_PARTNERCODE;
    }

    public static String getRISK_FRAUDMETRIX_SECRETKEY() {
        return RISK_FRAUDMETRIX_SECRETKEY;
    }

    public static void setCJD_SERVICE_PASSWORD(String cJD_SERVICE_PASSWORD) {
        CJD_SERVICE_PASSWORD = cJD_SERVICE_PASSWORD;
    }

    public static void setCJD_SERVICE_PRIVATE_KEY(String cJD_SERVICE_PRIVATE_KEY) {
        CJD_SERVICE_PRIVATE_KEY = cJD_SERVICE_PRIVATE_KEY;
    }

    public static void setCJD_SERVICE_URL(String cJD_SERVICE_URL) {
        CJD_SERVICE_URL = cJD_SERVICE_URL;
    }

    public static void setCJD_SERVICE_USER_NAME(String cJD_SERVICE_USER_NAME) {
        CJD_SERVICE_USER_NAME = cJD_SERVICE_USER_NAME;
    }

    public static void setJXL_SERVICE_ACCESS_TOKEN(String jXL_SERVICE_ACCESS_TOKEN) {
        JXL_SERVICE_ACCESS_TOKEN = jXL_SERVICE_ACCESS_TOKEN;
    }

    public static void setJXL_SERVICE_CLIENT_SECRET(String jXL_SERVICE_CLIENT_SECRET) {
        JXL_SERVICE_CLIENT_SECRET = jXL_SERVICE_CLIENT_SECRET;
    }

    public static void setJXL_SERVICE_ORG_NAME(String jXL_SERVICE_ORG_NAME) {
        JXL_SERVICE_ORG_NAME = jXL_SERVICE_ORG_NAME;
    }

    public static void setJXL_SERVICE_URL(String jXL_SERVICE_URL) {
        JXL_SERVICE_URL = jXL_SERVICE_URL;
    }

    public static void setNFCS_HOST(String nFCS_HOST) {
        NFCS_HOST = nFCS_HOST;
    }

    public static void setNFCS_ORG_CODE(String nFCS_ORG_CODE) {
        NFCS_ORG_CODE = nFCS_ORG_CODE;
    }

    public static void setNFCS_PASSWORD(String nFCS_PASSWORD) {
        NFCS_PASSWORD = nFCS_PASSWORD;
    }

    public static void setNFCS_PORT(Integer nFCS_PORT) {
        NFCS_PORT = nFCS_PORT;
    }

    public static void setNFCS_SSECRET(String nFCS_SSECRET) {
        NFCS_SSECRET = nFCS_SSECRET;
    }

    public static void setNFCS_URL_PREFIX(String nFCS_URL_PREFIX) {
        NFCS_URL_PREFIX = nFCS_URL_PREFIX;
    }

    public static void setNFCS_USER_NAME(String nFCS_USER_NAME) {
        NFCS_USER_NAME = nFCS_USER_NAME;
    }

    public static void setPY_SERVICE_URL(String pY_SERVICE_URL) {
        PY_SERVICE_URL = pY_SERVICE_URL;
    }

    public static void setRISK_FRAUDMETRIX_EVENTID(String rISK_FRAUDMETRIX_EVENTID) {
        RISK_FRAUDMETRIX_EVENTID = rISK_FRAUDMETRIX_EVENTID;
    }

    public static void setRISK_FRAUDMETRIX_PARTNERCODE(String rISK_FRAUDMETRIX_PARTNERCODE) {
        RISK_FRAUDMETRIX_PARTNERCODE = rISK_FRAUDMETRIX_PARTNERCODE;
    }

    public static void setRISK_FRAUDMETRIX_SECRETKEY(String rISK_FRAUDMETRIX_SECRETKEY) {
        RISK_FRAUDMETRIX_SECRETKEY = rISK_FRAUDMETRIX_SECRETKEY;
    }

}
