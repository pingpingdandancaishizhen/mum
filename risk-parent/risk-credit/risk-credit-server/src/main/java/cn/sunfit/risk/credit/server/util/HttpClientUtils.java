package cn.sunfit.risk.credit.server.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import orj.worf.util.StringUtils;

public class HttpClientUtils {

    private static final Logger logger = Logger.getLogger(HttpClientUtils.class);

    /**
     * HTTP get 获取内容
     * @param params
     * @param url
     * @return
     * @throws IOException 
     * @throws UnsupportedEncodingException 
     * @throws ParseException 
     */
    public static Map<String, Object> httpGet(Map<String, Object> params, String url) throws IOException {
        String result = "";
        if (StringUtils.isBlank(url)) {
            return null;
        }
        if (params != null) {
            List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
            for (String key : params.keySet()) {
                pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, "utf-8"));
        }
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpclient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            httpGet.abort();
            throw new RuntimeException("HttpClient,error status code :" + statusCode);
        }
        // 获取返回数据
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            result = EntityUtils.toString(entity, HTTP.UTF_8);
            if (result.indexOf("502 Bad Gateway") > -1 || result.indexOf("<html>") > -1) {
                return null;
            }
        }
        EntityUtils.consume(entity);
        return JsonUtil.nonDefaultMapper().fromJson(result, Map.class);
    }

    /**
     * HTTP 提交方法（无超时处理）
     * @param params
     * @param url
     * @return
     */
    public static Map<String, Object> httpPost(Object params, String url) {

        String result = "";
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("content-type", "application/json");
        httppost.setHeader("Accept", "application/json");
        httppost.getParams().setParameter(HTTP.DEFAULT_CONTENT_CHARSET, "utf-8");
        try {
            if (params != null) {
                String content = JsonUtil.nonDefaultMapper().toJson(params);
                System.out.println("request:" + content);
                httppost.setEntity(new StringEntity(content, "utf-8"));
            }

            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httppost);
            // 获取返回数据
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                result = EntityUtils.toString(entity, HTTP.UTF_8);
                if (result.indexOf("502 Bad Gateway") > -1 || result.indexOf("<html>") > -1) {
                    return null;
                }
                System.out.println(DateUtil.dateToStringFour(new Date()) + " result:"
                        + JsonUtil.nonDefaultMapper().toJson(JsonUtil.nonDefaultMapper().fromJson(result, Map.class)));
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return JsonUtil.nonDefaultMapper().fromJson(result, Map.class);
    }

    public static Map<String, Object> post(Object params, String url) {

        String result = "";
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("content-type", "application/json");
        httppost.setHeader("Accept", "application/json");
        httppost.getParams().setParameter(HTTP.DEFAULT_CONTENT_CHARSET, "utf-8");
        try {
            if (params != null) {
                String content = JsonUtil.nonDefaultMapper().toJson(params);
                System.out.println("request:" + content);
                httppost.setEntity(new StringEntity(content, "utf-8"));
            }

            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);// 连接时间
            httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);// 数据传输时间
            HttpResponse response = httpclient.execute(httppost);
            // 获取返回数据
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                result = EntityUtils.toString(entity, HTTP.UTF_8);
                if (result.indexOf("502 Bad Gateway") > -1 || result.indexOf("<html>") > -1) {
                    return null;
                }
                System.out.println(DateUtil.dateToStringFour(new Date()) + " result:"
                        + JsonUtil.nonDefaultMapper().toJson(JsonUtil.nonDefaultMapper().fromJson(result, Map.class)));
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return JsonUtil.nonDefaultMapper().fromJson(result, Map.class);
    }

}
