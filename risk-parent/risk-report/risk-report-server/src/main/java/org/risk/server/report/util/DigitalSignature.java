package org.risk.server.report.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigitalSignature {
    protected static final Logger logger = LoggerFactory.getLogger(DigitalSignature.class);

    public static String getSignature(Map<String, Object> params, String secret) throws IOException {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, Object> sortedParams = new TreeMap<String, Object>(params);
        Set<Entry<String, Object>> entrys = sortedParams.entrySet();
        StringBuilder basestring = new StringBuilder();
        for (Entry<String, Object> param : entrys) {
            basestring.append(param.getKey()).append("=").append(param.getValue());
        }
        basestring.append(secret);
        String result = sign(basestring.toString());
        return result;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> params = new HashMap<>();
        // LoanInfoReq req2 = new LoanInfoReq();
        // req2.setLicenseNum("苏Etest2");
        // req2.setMaster("wwiii");
        // req2.setColor("red");
        // req2.setBorrowOrderId("999996");
        // req2.setBackPayName("等额本息");
        // req2.setOrderStatusName("通过");
        // req2.setBorrowMoney("2000");
        Map<String, String> map = new HashMap<String, String>();
        map.put("licenseNum", "苏Etest2");
        map.put("master", "wwiii");

        params.put("key", "440d7b99-d99f-499a-a28b-6ae56a4c35c8");
        String sign = DigitalSignature.getSignature(params, "Ea7BrdA3cdd0Ye3fdTKwV");
        System.out.println(sign);
    }

    public static String sign(String basestring) {
        // 使用MD5对待签名串求签
        byte[] bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            bytes = md5.digest(basestring.getBytes("UTF-8"));

            // 将MD5输出的二进制结果转换为小写的十六进制
            StringBuilder sign = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(bytes[i] & 0xFF);
                if (hex.length() == 1) {
                    sign.append("0");
                }
                sign.append(hex);
            }
            return sign.toString().toUpperCase();
        } catch (Exception ex) {
            logger.error("签名失败");
        }
        return null;
    }
}
