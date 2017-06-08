package cn.sunfit.risk.buz.server.service.activiti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Event;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SubProcess;
import org.activiti.bpmn.model.Task;
import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.util.io.StringStreamSource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.templates.MetaCategoryTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaFieldsTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaFormsTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaNodesTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaOperationsTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaTemplates;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.activiti.TemplatesService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.ReqBase;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.activiti.CategoryQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.FieldsQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.FormsQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.NodeQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.OperationsQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.UploadBpmnReq;
import cn.sunfit.risk.buz.server.dao.templates.MetaCategoryTemplatesDAO;
import cn.sunfit.risk.buz.server.dao.templates.MetaFieldsTemplatesDAO;
import cn.sunfit.risk.buz.server.dao.templates.MetaFormsTemplatesDAO;
import cn.sunfit.risk.buz.server.dao.templates.MetaNodesTemplatesDAO;
import cn.sunfit.risk.buz.server.dao.templates.MetaOperationsTemplatesDAO;
import cn.sunfit.risk.buz.server.dao.templates.MetaTemplatesDAO;

@Service("risk.templatesService")
public class TemplatesServiceImpl implements TemplatesService {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private FormService formService;
    @Autowired
    private MetaTemplatesDAO metaTemplatesDAO;
    @Autowired
    private MetaNodesTemplatesDAO metaNodesTemplatesDAO;
    @Autowired
    private MetaCategoryTemplatesDAO metaCategoryTemplatesDAO;

    @Autowired
    private MetaFieldsTemplatesDAO metaFieldsTemplatesDAO;
    @Autowired
    private MetaOperationsTemplatesDAO metaOperationsTemplatesDAO;
    @Autowired
    private MetaFormsTemplatesDAO metaFormsTemplatesDAO;

    @Override
    public void addMetaCategoryTemplates(MetaCategoryTemplates t) {
        t.setCategoryId(IdUtil.geneId());
        metaCategoryTemplatesDAO.insert(t);
    }

    @Override
    public void addMetaFieldsTemplates(MetaFieldsTemplates f) {
        f.setFieldId(IdUtil.geneId());
        metaFieldsTemplatesDAO.insert(f);
    }

    @Override
    public void addMetaFormsTemplates(MetaFormsTemplates f) {
        f.setFormId(IdUtil.geneId());
        metaFormsTemplatesDAO.insert(f);
    }

    @Override
    public void addMetaOperationsTemplates(MetaOperationsTemplates f) {
        f.setOperationId(IdUtil.geneId());
        metaOperationsTemplatesDAO.insert(f);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void copy(String bpDefId, String corpId, String domain) {
        // TODO Auto-generated method stub
        // 开始拷贝数据
        // 拷贝BP_META_TEMPLATE 到 WDGS_BP_META
        metaTemplatesDAO.copy2Corp(bpDefId, corpId, domain);
    }

    @Override
    public RespPage<List<MetaCategoryTemplates>> queryMetaCategoryTemplates(CategoryQueryReq req) {
        List<MetaCategoryTemplates> list = metaCategoryTemplatesDAO.selectMetaCategoryTemplates(req.getBpDefId(),
                new RowBounds(req.getOffset(), req.getLimit()));
        int total = CountHelper.getTotalRow();
        return new RespPage<List<MetaCategoryTemplates>>(list, total);
    }

    @Override
    public List<MetaCategoryTemplates> queryMetaCategoryTemplatesAll(CategoryQueryReq req) {
        List<MetaCategoryTemplates> list = metaCategoryTemplatesDAO.selectMetaCategoryTemplatesAll(req.getBpDefId());
        return list;
    }

    @Override
    public RespPage<List<MetaFieldsTemplates>> queryMetaFieldsTemplates(FieldsQueryReq req) {
        List<MetaFieldsTemplates> list = metaFieldsTemplatesDAO.selectMetaFieldsTemplates(req.getBpDefId(),
                new RowBounds(req.getOffset(), req.getLimit()));
        int total = CountHelper.getTotalRow();
        return new RespPage<List<MetaFieldsTemplates>>(list, total);
    }

    @Override
    public RespPage<List<MetaFormsTemplates>> queryMetaFormsTemplates(FormsQueryReq req) {
        List<MetaFormsTemplates> list = metaFormsTemplatesDAO.selectMetaFormsTemplates(req.getBpDefId(), new RowBounds(
                req.getOffset(), req.getLimit()));
        int total = CountHelper.getTotalRow();
        return new RespPage<List<MetaFormsTemplates>>(list, total);
    }

    @Override
    public List<MetaFormsTemplates> queryMetaFormsTemplatesAll(FormsQueryReq req) {
        List<MetaFormsTemplates> list = metaFormsTemplatesDAO.selectMetaFormsTemplates(req.getBpDefId(),
                new RowBounds());
        return list;
    }

    @Override
    public RespPage<List<MetaNodesTemplates>> queryMetaNodesTemplates(NodeQueryReq req) {
        List<MetaNodesTemplates> list = metaNodesTemplatesDAO.selectMetaNodesTemplates(req.getBpDefId(), new RowBounds(
                req.getOffset(), req.getLimit()));
        int total = CountHelper.getTotalRow();
        return new RespPage<List<MetaNodesTemplates>>(list, total);
    }

    @Override
    public RespPage<List<MetaOperationsTemplates>> queryMetaOperationsTemplates(OperationsQueryReq req) {
        List<MetaOperationsTemplates> list = metaOperationsTemplatesDAO.selectMetaOperationsTemplates(req.getBpDefId(),
                new RowBounds(req.getOffset(), req.getLimit()));
        int total = CountHelper.getTotalRow();
        return new RespPage<List<MetaOperationsTemplates>>(list, total);
    }

    @Override
    public List<MetaOperationsTemplates> queryMetaOperationsTemplatesAll(OperationsQueryReq req) {
        List<MetaOperationsTemplates> list = metaOperationsTemplatesDAO.selectMetaOperationsTemplatesNoNode(req
                .getBpDefId());
        return list;
    }

    @Override
    public RespPage<List<MetaTemplates>> queryMetaTemplates(ReqBase req) {
        List<MetaTemplates> list = metaTemplatesDAO.selectMetaTemplates(new RowBounds(req.getOffset(), req.getLimit()));
        int total = CountHelper.getTotalRow();
        return new RespPage<List<MetaTemplates>>(list, total);
    }

    /**
     * 
     * <p>Description:保存BPMN源 </p>
     * @author XFL 2016年12月22日 
     * @param bpmnxml
     * @param corpId
     * @see cn.sunfit.risk.buz.api.service.activiti.TemplatesService#save(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UploadBpmnReq req) {
        // 解析BPMN.XML
        BpmnXMLConverter c = new BpmnXMLConverter();
        BpmnModel bm = c.convertToBpmnModel(new StringStreamSource(req.getBpmnxml()), true, true);
        Process a = bm.getProcesses().get(0);
        System.out.println("流程定义ID" + a.getId());
        System.out.println("流程定义名称" + a.getName());
        // 放入BPS
        MetaTemplates metaTemplates = new MetaTemplates();
        metaTemplates.setBpDefId(IdUtil.geneId());
        metaTemplates.setBpDefKey(a.getId());
        metaTemplates.setBindClazz(null);
        metaTemplates.setBpDesc(a.getDocumentation());
        metaTemplates.setBpmnXml(req.getBpmnxml());
        metaTemplates.setBpName(a.getName());
        metaTemplates.setBpNoRule(null);
        metaTemplates.setCreateTime(new Date());
        metaTemplates.setCreateUserId(req.getUserId());
        metaTemplates.setEngineDefId(null);
        metaTemplates.setLoanExtTable(null);
        metaTemplates.setLoanType(Byte.valueOf(req.getLoanType()));
        metaTemplates.setProductKey(req.getProductId());
        metaTemplates.setVersion(req.getVersion().toString());
        metaTemplates.setUpdateTime(null);
        metaTemplatesDAO.insert(metaTemplates);
        // 读取节点 放入到Node中
        List<MetaNodesTemplates> nodeList = new ArrayList<MetaNodesTemplates>();
        Collection<FlowElement> eles = a.getFlowElements();
        for (FlowElement cf : eles) {
            if (cf instanceof Task || cf instanceof Event) {
                MetaNodesTemplates n = new MetaNodesTemplates();
                n.setBpDefId(metaTemplates.getBpDefId());
                n.setFormKey(null);
                n.setGateway(null);
                n.setNodeDesc(cf.getDocumentation());
                n.setNodeId(IdUtil.geneId());
                n.setNodeKey(cf.getId());
                n.setNodeName(cf.getName());
                n.setNodeType(cf.getClass().getSimpleName().toLowerCase());
                nodeList.add(n);
            }
            if (cf instanceof SubProcess) {
                SubProcess sp = (SubProcess) cf;
                Collection<FlowElement> seles = sp.getFlowElements();
                for (FlowElement scf : seles) {
                    if (scf instanceof Task) {
                        MetaNodesTemplates n = new MetaNodesTemplates();
                        n.setBpDefId(metaTemplates.getBpDefId());
                        n.setFormKey(null);
                        n.setGateway(null);
                        n.setNodeDesc(scf.getDocumentation());
                        n.setNodeId(IdUtil.geneId());
                        n.setNodeKey(scf.getId());
                        n.setNodeName(scf.getName());
                        n.setNodeType(scf.getClass().getSimpleName().toLowerCase());
                        nodeList.add(n);
                    }
                }
            }
        }
        if (nodeList.isEmpty()) {
            throw new ServiceException("居然没节点");
        }
        metaNodesTemplatesDAO.insertBatch(nodeList);
    }

    @Override
    public void updateNodeFormKey(MetaNodesTemplates req) {
        MetaNodesTemplates node = metaNodesTemplatesDAO.selectByPrimaryKey(req.getNodeId());
        node.setFormKey(req.getFormKey());
        metaNodesTemplatesDAO.updateByPrimaryKey(node);
    }

    @Override
    public void updateNodeOperation(List<String> operationIds, String bpDefId, String nodeKey) {
        metaOperationsTemplatesDAO.updateOperationsNodeKey(operationIds, bpDefId, nodeKey);
    }
}
