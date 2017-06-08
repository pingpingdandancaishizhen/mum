package cn.sunfit.risk.buz.server.service;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.service.OSSService;
import cn.sunfit.risk.buz.server.util.Base64;
import cn.sunfit.risk.buz.server.util.ServerConfig;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;

@Service("risk.ossService")
public class OSSServiceImpl implements OSSService {

    static Logger logger = LoggerFactory.getLogger(OSSService.class);

    private static URLClassLoader initOSSClassLoader() {
        try {
            String[] jars = {};
            String home = System.getProperty("catalina.home") + "/wtpwebapps/risk-buz/WEB-INF/";
            URL[] urls = new URL[jars.length];
            int index = 0;
            for (String jarName : jars) {
                urls[index] = new File(home + jarName).toURI().toURL();
                index++;
            }
            return new URLClassLoader(urls, OSSService.class.getClassLoader().getSystemClassLoader().getParent()
                    .getParent());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Base64.getBASE64("loanftp.oss-cn-hzjbp-b-internal.aliyuncs.com"));
        ;
        System.out.println(Base64.getFromBASE64("aHR0cDovL3N0YXRpY3Rlc3QueGlhbmdmYWpyLmNvbS8="));
    }

    private String accessKeyId;
    private String accessKeySecret;

    // private static String accessKeyId = "0Y4bSdyELXFnj1if";
    // private static String accessKeySecret = "iixVDNYywv4cHgprFt00b3GHATalI0";
    // private static String endpoint = "oss-cn-hzjbp-b-internal.aliyuncs.com";
    // private static String bucketName = GlobalConstants.OSS_URL;
    // // 下载时外网访问地址
    // private static String url = "http://imgrjr.rjs.com/";

    private String endpoint;

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
    @Override
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
    @Override
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
    @Override
    public byte[] downloadFile(String key) {
        init();
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
    @Override
    public void uploadFile(String key, byte[] b) {
        init();
        ClassLoader oldCL = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(ossCL);
            createClient();
            ObjectMetadata omt = new ObjectMetadata();
            omt.setCacheControl("max-age=186400");
            omt.setLastModified(new Date());
            ossClient.putObject(bucketName, key, new ByteArrayInputStream(b), omt);
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
            try {
                shutdownClient();
            } catch (Exception ex) {
                logger.info("Exception", ex);
            }
            Thread.currentThread().setContextClassLoader(oldCL);
        }
    }

    /** 
     * 
     * @Title: uploadFile 
     * @Description: TODO 
     * @param @param key 文件夹以及文件名组合的字符串。oss不支持多级目录，只能用KEY的方式来模拟 
     * @param @param input OBJECT的输入流 
     * @return void 
     * @author RJS 2016年5月4日 
     * @throws 
     */
    @Override
    public void uploadFile(String key, InputStream input) {
        init();
        this.createClient();
        try {
            ObjectMetadata omt = new ObjectMetadata();
            omt.setCacheControl("max-age=186400");
            omt.setLastModified(new Date());
            this.ossClient.putObject(this.bucketName, key, input, omt);
        } catch (OSSException oe) {
            oe.printStackTrace();
            logger.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            logger.error("Error Code: " + oe.getErrorCode());
            logger.error("Request ID: " + oe.getRequestId());
            logger.error("Host ID: " + oe.getHostId());
        } catch (ClientException ce) {
            ce.printStackTrace();
            logger.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            logger.error("Error Message: " + ce.getMessage());
        } finally {
            try {
                shutdownClient();
            } catch (Exception ex) {
                logger.info("Exception", ex);
            }
        }
    }
}
