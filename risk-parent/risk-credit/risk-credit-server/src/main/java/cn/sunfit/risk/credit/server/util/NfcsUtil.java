package cn.sunfit.risk.credit.server.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

import orj.worf.util.ArrayUtils;
import orj.worf.util.StringUtils;

/**
 * 上海资信直连工具类 
 * 查询步骤：
 * 		1、模拟登录vpn
 * 		2、执行相应的接口
 * 注：需将jssecacerts拷贝到%JAVA_HOME%\jre\lib\security目录下
 */
public class NfcsUtil {

    private static Logger log = Logger.getLogger(NfcsUtil.class);
    // 以下参数由上海资信分配，一般是通过邮件发给快易信部门老大

    public final static String TMP_PATH = "temp/";
    public final static String FILE_EXTENSION = ".zip";

    // --------以下参数为固定参数--------
    private static String batchCreditWebServiceURI = ServerConfig.NFCS_URL_PREFIX + "/webservice/batchcredit?wsdl";
    private static String step1URI = "https://vpn.shanghai-cis.com.cn/+CSCOE+/logon.html";
    private static String step2URI = "https://vpn.shanghai-cis.com.cn/+webvpn+/index.html";

    static Cookie[] cookies = null;

    /**
     * 模拟登录VPN
     */
    /**
     * 模拟登录VPN
     * @throws IOException 
     * @throws  
     */
    public static HttpClient getUrlContent() throws IOException {
        HttpClient httpClient = new HttpClient();
        HttpClientParams httparams = new HttpClientParams();
        httparams.setSoTimeout(30000);
        httpClient.setParams(httparams);

        httpClient.getHostConfiguration().setHost(ServerConfig.NFCS_HOST, ServerConfig.NFCS_PORT);

        PostMethod login = new PostMethod(step1URI);
        login.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        httpClient.executeMethod(login);

        cookies = httpClient.getState().getCookies();
        System.out.println("==========Cookies============");
        httpClient.getState().addCookies(cookies);

        PostMethod login2 = new PostMethod(step2URI);
        login2.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        login2.addRequestHeader("Refer", step1URI);
        login2.addRequestHeader(
                "Accept",
                "image/jpeg, application/x-ms-application, image/gif, application/xaml+xml, image/pjpeg, application/x-ms-xbap, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");

        NameValuePair tgroup = new NameValuePair("tgroup", "");
        NameValuePair next = new NameValuePair("next", "");
        NameValuePair tgcookieset = new NameValuePair("tgcookieset", "");
        NameValuePair Login = new NameValuePair("Login", "登录");
        NameValuePair Email = new NameValuePair("username", ServerConfig.NFCS_USER_NAME);
        NameValuePair password1 = new NameValuePair("password", ServerConfig.NFCS_PASSWORD);

        NameValuePair[] data = { tgroup, next, tgcookieset, Login, Email, password1 };
        login2.setRequestBody(data);

        httpClient.executeMethod(login2);

        cookies = httpClient.getState().getCookies();
        System.out.println("==========Cookies============");
        int j = 0;
        for (Cookie c : cookies) {
            System.out.println(++j + ":   " + c);
        }
        httpClient.getState().addCookies(cookies);
        return httpClient;
    }

    /**
     * 查询方法
     * @param idCard 身份证号
     * @param name 客户姓名
     * @param plate 查询板式类型:1-机构版(金融版) 3-特殊交易版
     * @return {"RESULT_CODE":查询状态(OK-成功 ERR-失败), "MSG":返回消息, "CUSTOMER_ID":客户id, "VALUE":文件内容}
     * @throws Exception
     */
    public static Map<String, String> query(String idCard, String name, String plate) throws IOException {
        Map<String, String> resultMap = null;
        HttpClient httpClient = getUrlContent();
        PostMethod postMethod = new PostMethod(batchCreditWebServiceURI);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("soapenv:Envelope");
        root.add(new Namespace("soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
        root.addAttribute("xmlns:web", "http://webservice.creditreport.p2p.sino.com/");
        root.addElement("soapenv:Header");
        // 创建元素时需指定与父节点相同的命名空间,否则将生成XMLNS=""这样的属性,导致报错
        Element body = root.addElement(QName.get("soapenv:Body", root.getNamespace()));
        Element queryCredit = body.addElement(QName.get("web:queryCredit", body.getNamespace()));
        queryCredit.addElement("orgcode").addCDATA(ServerConfig.NFCS_ORG_CODE);
        queryCredit.addElement("secret").addCDATA(ServerConfig.NFCS_SSECRET);
        queryCredit.addElement("plate").addCDATA(plate);
        queryCredit.addElement("certtype").addCDATA("0"); // 证件类型，0-身份证
        queryCredit.addElement("certno").addCDATA(idCard);
        queryCredit.addElement("name").addCDATA(name);
        queryCredit.addElement("reason").addCDATA("02"); // 查询原因：01-贷后管理 02-贷款审批 04-担保资格审查 05-异议查询 06-本人查询 07-司法调查
                                                         // 08-金融监管
        queryCredit.addElement("createtype").addCDATA("1"); // 返回值类型 0-html格式 (压缩包) 1-xml
        postMethod.setRequestBody(doc.asXML());
        httpClient.executeMethod(postMethod);
        String result = postMethod.getResponseBodyAsString();
        if (StringUtils.isNotEmpty(result)) {
            // 将获取结果转换为字符串，并生成压缩文件
            Element el = XMLUtil.getRootElement(result);
            JSONArray arr = JSONArray.fromObject(el.getStringValue());
            if (arr.size() > 0) {
                resultMap = new HashMap<String, String>();
                JSONObject jsonObject = JSONObject.fromObject(arr.get(0));
                if (jsonObject.get("errors") == null) {
                    Object obj = jsonObject.get("result");
                    String resultStr = "";
                    if (obj == null || StringUtils.isBlank(obj.toString())) {
                        resultMap.put("RESULT_CODE", "ERR");
                        resultMap.put("VALUE", "被查询人不存在");
                    } else {
                        resultStr = obj.toString();
                        resultStr = resultStr.replace("[", "").replace("]", "");
                        resultMap.put("RESULT_CODE", "OK");
                        resultMap.put("CUSTOMER_ID", idCard);
                        resultMap.put("VALUE", resultStr);
                    }
                } else {
                    resultMap.put("RESULT_CODE", "ERR");
                    resultMap.put("MSG", jsonObject.get("errors").toString());
                }
            }
        }
        return resultMap;
    }

    public static String writeFile(String str) throws IOException {
        String[] strArr = org.apache.commons.lang.StringUtils.split(str, ",");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);

        }
        byte[] bytes = new byte[0];
        for (int i = 0; i < intArr.length; i++) {
            bytes = ArrayUtils.add(bytes, (byte) (intArr[i]));
        }

        String fileName = new Date().getTime() + FILE_EXTENSION;

        OutputStream out = new FileOutputStream("D:" + File.separator + fileName);
        out.write(bytes);
        out.close();

        return fileName;
    }
}