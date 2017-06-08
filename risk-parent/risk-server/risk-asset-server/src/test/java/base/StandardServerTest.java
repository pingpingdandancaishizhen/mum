package base;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import orj.worf.container.spring.server.StandardServer;
import cn.sunfit.risk.buz.api.utils.IdUtil;

public class StandardServerTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // orj.worf.datasource.DataSourceSecurityUtil.print();
        // java.util.Properties props = new java.util.Properties();
        // try {
        // props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/jdbc.properties"));
        // Set<String> stringPropertyNames = props.stringPropertyNames();
        // java.util.List<String> sortList = new ArrayList<String>();
        // for (String key : stringPropertyNames) {
        // String value = props.getProperty(key);
        // String encryptData = RJSCipher.decryptData(value);
        // value = key + "=" + encryptData;
        // sortList.add(value);
        // }
        // Collections.sort(sortList);
        // for (String string : sortList) {
        // System.out.println(string);
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        System.out.println(IdUtil.geneId());
        System.out.println(IdUtil.geneId());
        System.out.println(IdUtil.geneId());
    }

    @Test
    public void testStartContainer() throws Exception {
        try {
            StandardServer standardServer = new StandardServer();
            standardServer.setContainerDefaultConfigPath("classpath:test/container-spring_config_default.xml");
            standardServer.setContainerConfigPath("classpath:test/container-spring_config.xml");
            standardServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testStopContainer() {
        // StandardServer standardServer = new StandardServer();
        // standardServer.setContainerConfigPath("classpath:test/container-spring_config.xml");
        // standardServer.stopServer();
    }
}
