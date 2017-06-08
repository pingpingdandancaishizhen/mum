package cn.sunfit.risk.web.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;

@Service
public class OSSUtil {

    static Logger logger = LoggerFactory.getLogger(OSSUtil.class);

    private static URLClassLoader initOSSClassLoader() {
        try {
            String[] jars = {};
            String home = System.getProperty("catalina.home") + "/wtpwebapps/risk-web/WEB-INF/";
            URL[] urls = new URL[jars.length];
            int index = 0;
            for (String jarName : jars) {
                urls[index] = new File(home + jarName).toURI().toURL();
                index++;
            }
            return new URLClassLoader(urls, OSSUtil.class.getClassLoader().getSystemClassLoader().getParent()
                    .getParent());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint;

    // private static String accessKeyId = "0Y4bSdyELXFnj1if";
    // private static String accessKeySecret = "iixVDNYywv4cHgprFt00b3GHATalI0";
    // private static String endpoint = "oss-cn-hzjbp-b-internal.aliyuncs.com";
    // private static String bucketName = GlobalConstants.OSS_URL;
    // // 下载时外网访问地址
    // private static String url = "http://imgrjr.rjs.com/";

    private String bucketName;

    // 下载时外网访问地址
    private String url;

    private OSSClient ossClient;

    private final URLClassLoader ossCL = initOSSClassLoader();

    @Autowired
    private ServerConfig serverConfig;

    /**
     * @Title:OSS文件的外网访问路径
     * @param key 文件夹以及文件名组合的字符串。OSS不支持多级目录，用KEY的方式来模拟
     * @return String 
     * @throws
     */
    public String buildUrl(String key) {
        if (!url.endsWith("/")) {
            return url + "/" + key;
        }
        return url + key;
    }

    private void createClient() {
        if (ossClient == null) {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        }
    }

    /**
     * 删除文件
     */
    public void deleteFile(String key) {
        createClient();
        try {
            ossClient.deleteObject(bucketName, key);
        } catch (OSSException oe) {
            logger.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            logger.error("Error Message: " + oe.getErrorCode());
            logger.error("Error Code:       " + oe.getErrorCode());
            logger.error("Request ID:      " + oe.getRequestId());
            logger.error("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            logger.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            logger.error("Error Message: " + ce.getMessage());
        } finally {
            shutdownClient();
        }
    }

    /**
     * @Title: 从OSS获取文件
     * @param key 文件夹以及文件名组合的字符串。OSS不支持多级目录，用KEY的方式来模拟
     * @return byte[] 
     * @throws
     */
    public byte[] downloadFile(String key) {
        createClient();
        try {
            OSSObject oo = ossClient.getObject(bucketName, key);
            InputStream is = oo.getObjectContent();
            byte[] byteArray = IOUtils.toByteArray(is);
            return byteArray;
        } catch (OSSException oe) {
            logger.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            logger.error("Error Message: " + oe.getErrorCode());
            logger.error("Error Code:       " + oe.getErrorCode());
            logger.error("Request ID:      " + oe.getRequestId());
            logger.error("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            logger.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            logger.error("Error Message: " + ce.getMessage());
        } catch (IOException e) {
            logger.error("读取OSS流失败");
        } finally {
            shutdownClient();
        }
        return null;
    }

    /**
     * @Title: 从OSS获取文件
     * @param key 文件夹以及文件名组合的字符串。OSS不支持多级目录，用KEY的方式来模拟
     * @return byte[] 
     * @throws
     */
    public byte[] downloadFileWithQuality(String key, String height) {
        createClient();
        try {
            GetObjectRequest request = new GetObjectRequest(bucketName, key);
            if (StringUtils.isNotBlank(height)) {
                request.setProcess("image/resize,h_" + height);
            }

            OSSObject oo = ossClient.getObject(request);
            InputStream is = oo.getObjectContent();
            byte[] byteArray = IOUtils.toByteArray(is);
            return byteArray;
        } catch (OSSException oe) {
            logger.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            logger.error("Error Message: " + oe.getErrorCode());
            logger.error("Error Code:       " + oe.getErrorCode());
            logger.error("Request ID:      " + oe.getRequestId());
            logger.error("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            logger.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            logger.error("Error Message: " + ce.getMessage());
        } catch (IOException e) {
            logger.error("读取OSS流失败");
        } finally {
            shutdownClient();
        }
        return null;
    }

    @PostConstruct
    private void init() {
        accessKeyId = Base64.getFromBASE64(serverConfig.getOss_accessKey_id());
        accessKeySecret = Base64.getFromBASE64(serverConfig.getOss_accessKey_secret());
        endpoint = Base64.getFromBASE64(serverConfig.getOss_endpoint());
        bucketName = Base64.getFromBASE64(serverConfig.getOss_bucketName());
        url = Base64.getFromBASE64(serverConfig.getOss_url());
    }

    private void shutdownClient() {
        // if (ossClient != null) {
        // ossClient.shutdown();
        // }
    }

    /**
     * @Title: 上传文件到OSS
     * @param key 文件夹以及文件名组合的字符串。OSS不支持多级目录，用KEY的方式来模拟
     * @param b  输入
     * @return void 
     * @throws
     */
    public void uploadFile(String key, byte[] b) {
        init();
        ClassLoader oldCL = Thread.currentThread().getContextClassLoader();

        // try {
        Thread.currentThread().setContextClassLoader(ossCL);
        createClient();
        ObjectMetadata omt = new ObjectMetadata();
        omt.setCacheControl("max-age=186400");
        omt.setLastModified(new Date());
        ossClient.putObject(bucketName, key, new ByteArrayInputStream(b), omt);
        // } catch (OSSException oe) {
        // logger.error("Caught an OSSException, which means your request made it to OSS, "
        // + "but was rejected with an error response for some reason.");
        // logger.error("Error Message: " + oe.getErrorCode());
        // logger.error("Error Code:       " + oe.getErrorCode());
        // logger.error("Request ID:      " + oe.getRequestId());
        // logger.error("Host ID:           " + oe.getHostId());
        // } catch (ClientException ce) {
        // logger.error("Caught an ClientException, which means the client encountered "
        // + "a serious internal problem while trying to communicate with OSS, "
        // + "such as not being able to access the network.");
        // logger.error("Error Message: " + ce.getMessage());
        // } finally {
        // shutdownClient();
        // }
        Thread.currentThread().setContextClassLoader(oldCL);
    }

}
