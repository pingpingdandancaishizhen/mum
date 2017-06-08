///*******************************************************************************
// * @Title: BPMetaServiceImplTest.java
// *
// * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
// * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
// ******************************************************************************/
//package cn.sunfit.risk.buz.server.service.meta;
//
//import static org.junit.Assert.fail;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import cn.sunfit.risk.buz.api.beans.metadata.BPMeta;
//import cn.sunfit.risk.buz.api.beans.metadata.BPMetaField;
//import cn.sunfit.risk.buz.api.beans.metadata.BPMetaForm;
//import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
//import cn.sunfit.risk.buz.api.beans.metadata.BPMetaOperation;
//import cn.sunfit.risk.buz.api.service.metadata.BPMetaService;
//
///**   
// * @Title: BPMetaServiceImplTest.java
// * @Description: TODO
// * @author zouxuejun
// * @date 2016年12月15日 下午3:00:11
// * @version V1.0   
// */
//public class BPMetaServiceImplTest {
//
//    /**
//     * @Title: setUp
//     * @Description: TODO
//     * @param @throws java.lang.Exception   
//     * @return void 
//     * @throws
//     */
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    /**
//     * @Title: tearDown
//     * @Description: TODO
//     * @param @throws java.lang.Exception   
//     * @return void 
//     * @throws
//     */
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaById(java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaById() {
//        // fail("Not yet implemented");
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        BPMeta bpMeta = bpMetaService.getBPMetaById("1", "1000");
//        if (bpMeta == null) {
//            throw new RuntimeException("bpmeta is null");
//        }
//        System.out.println(bpMeta.toString());
//        Assert.assertNotNull(bpMeta);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMeta(java.lang.String, java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMeta() {
//        // fail("Not yet implemented");
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        BPMeta bpMeta = bpMetaService.getBPMeta("1", "wxcd", "1");
//        if (bpMeta == null) {
//            throw new RuntimeException("bpmeta is null");
//        }
//        System.out.println(bpMeta.toString());
//        Assert.assertNotNull(bpMeta);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getLatestBPMeta(java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetLatestBPMeta() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        BPMeta bpMeta = bpMetaService.getLatestBPMeta("1", "wxcd");
//        if (bpMeta == null) {
//            throw new RuntimeException("bpmeta is null");
//        }
//        System.out.println(bpMeta.toString());
//        Assert.assertNotNull(bpMeta);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaFields(java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaFields() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        List<BPMetaField> fields = bpMetaService.getBPMetaFields("1", "1000");
//        if (fields == null) {
//            throw new RuntimeException("fields is null");
//        }
//        System.out.println(fields.toString());
//        Assert.assertNotNull(fields);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaOperations(java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaOperations() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        List<BPMetaOperation> operations = bpMetaService.getBPMetaOperations("1", "1000");
//        if (operations == null) {
//            throw new RuntimeException("fields is null");
//        }
//        System.out.println(operations.toString());
//        Assert.assertNotNull(operations);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaForms(java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaForms() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        List<BPMetaForm> forms = bpMetaService.getBPMetaForms("1", "1000");
//        if (forms == null) {
//            throw new RuntimeException("forms is null");
//        }
//        System.out.println(forms.toString());
//        Assert.assertNotNull(forms);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaNodes(java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaNodes() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        List<BPMetaNode> nodes = bpMetaService.getBPMetaNodes("1", "1000");
//        if (nodes == null) {
//            throw new RuntimeException("nodes is null");
//        }
//        System.out.println(nodes.toString());
//        Assert.assertNotNull(nodes);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaStatuses(java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaStatuses() {
//        fail("Not yet implemented");
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaField(java.lang.String, java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaField() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        BPMetaField field = bpMetaService.getBPMetaField("1", "1000", "customer_name");
//        if (field == null) {
//            throw new RuntimeException("field is null");
//        }
//        System.out.println(field.toString());
//        Assert.assertNotNull(field);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaOperation(java.lang.String, java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaOperation() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        BPMetaOperation operation = bpMetaService.getBPMetaOperation("1", "1000", "new");
//        if (operation == null) {
//            throw new RuntimeException("operation is null");
//        }
//        System.out.println(operation.toString());
//        Assert.assertNotNull(operation);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaForm(java.lang.String, java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaForm() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        BPMetaForm form = bpMetaService.getBPMetaForm("1", "1000", "apply_form");
//        if (form == null) {
//            throw new RuntimeException("operation is null");
//        }
//        System.out.println(form.toString());
//        Assert.assertNotNull(form);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaNode(java.lang.String, java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaNode() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
//                "sunfit-risk_context.xml");
//        classPathXmlApplicationContext.start();
//
//        BPMetaService bpMetaService = (BPMetaService) classPathXmlApplicationContext.getBean(BPMetaService.class);
//        BPMetaNode node = bpMetaService.getBPMetaNode("1", "1000", "start");
//        if (node == null) {
//            throw new RuntimeException("operation is null");
//        }
//        System.out.println(node.toString());
//        Assert.assertNotNull(node);
//    }
//
//    /**
//     * Test method for {@link cn.sunfit.risk.buz.server.service.meta.BPMetaServiceImpl#getBPMetaStatus(java.lang.String, java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public void testGetBPMetaStatus() {
//        fail("Not yet implemented");
//    }
//
// }
