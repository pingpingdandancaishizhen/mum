///*******************************************************************************
// * @Title: BPMetaAdminServiceImplTest.java
// *
// * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
// * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
// ******************************************************************************/
//package cn.sunfit.risk.buz.server.service.meta;
//
//import static org.junit.Assert.fail;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import cn.sunfit.risk.buz.api.beans.metadata.BPMeta;
//import cn.sunfit.risk.buz.api.service.metadata.BPMetaAdminService;
//
///**   
// * @Title: BPMetaAdminServiceImplTest.java
// * @Description: TODO
// * @author zouxuejun
// * @date 2016年12月16日 下午6:50:24
// * @version V1.0   
// */
//public class BPMetaAdminServiceImplTest {
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaAdminServiceImpl#deployBPMeta(java.util.Map)}.
//     */
//    @Test
//    public void testDeployBPMeta() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaAdminService bpMetaAdminService = (BPMetaAdminService) classPathXmlApplicationContext
//                .getBean(BPMetaAdminService.class);
//        BPMeta bpMeta = new BPMeta();
//        bpMeta.setBpDefKey("test");
//        Map<String, Object> bpMetaDTO = new HashMap<String, Object>();
//        bpMetaDTO.put("bpMeta", bpMeta);
//
//        String bpDefId = bpMetaAdminService.deployBPMeta(bpMetaDTO);
//        if (bpDefId == null) {
//            throw new RuntimeException("bpDefId is null");
//        }
//        System.out.println(bpDefId);
//        Assert.assertNotNull(bpDefId);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaAdminServiceImpl#copyBPMeta(java.util.Map)}.
//     */
//    @Test
//    public void testCopyBPMeta() {
//        fail("Not yet implemented");
//    }
//
// }
