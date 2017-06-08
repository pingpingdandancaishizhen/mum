package base;

import org.junit.Test;

import orj.worf.container.spring.server.StandardServer;

public class StandardServerTest {

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
