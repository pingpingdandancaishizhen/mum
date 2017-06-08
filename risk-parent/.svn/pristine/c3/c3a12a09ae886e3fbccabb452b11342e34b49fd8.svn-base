package cn.sunfit.risk.buz.server.util;

import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import orj.worf.util.JsonUtils;

public class IpUtil {
    public static String[] getAddrByIP(String ipAddr) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ip", ipAddr);
        if (StringUtils.equals(ipAddr, "0:0:0:0:0:0:0:1")) {
            return new String[] { "未分配或者内网IP", "", "", "" };
        }
        if (isInner(ipAddr)) {
            return new String[] { "未分配或者内网IP", "", "", "" };
        }
        try {
            String response = HttpUtils.httpGetRequest("http://ip.taobao.com/service/getIpInfo.php", param);
            if (StringUtils.isBlank(response)) {
                return null;
            } else {
                try {
                    Map<String, Object> result = JsonUtils.parseJSON(response, Map.class, String.class, Object.class);
                    Integer code = (Integer) result.get("code");
                    if (code == 0) {
                        Map<String, Object> data = (Map<String, Object>) result.get("data");
                        String country = data.get("country") == null ? "" : data.get("country").toString();
                        String region = data.get("region") == null ? "" : data.get("region").toString();
                        String city = data.get("city") == null ? "" : data.get("city").toString();
                        String isp = data.get("isp") == null ? "" : data.get("isp").toString();
                        return new String[] { country, region, city, isp };
                    } else {
                        return null;
                    }
                } catch (Exception e) {
                    return null;
                }

            }
        } catch (URISyntaxException e) {
        }
        return null;
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        // ipAddress = this.getRequest().getRemoteAddr();
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                                                            // = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    public static boolean isInner(String ip) {
        String reg = "(10|172|192)\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})";// 正则表达式=。
                                                                                                                                                                                          // =、懒得做文字处理了、
        Pattern p = Pattern.compile(reg);
        Matcher matcher = p.matcher(ip);
        return matcher.find();
    }

    public static void main(String[] args) {
        IpUtil.getAddrByIP("223.112.77.18");
    }

}
