package cn.sunfit.risk.buz.server.service.solution;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.metadata.BPMeta;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeAssign;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.solution.SolutionService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaFormDefQuery;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaFormDefVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaFormRelateReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeAssignAddReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeAssignDeleteReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeAssignQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaReq;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaFormDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaNodeAssignDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaNodeDAO;

@Service("risk.solutionService")
public class SolutionServiceImpl implements SolutionService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BPMetaDAO bpMetaDAO;

    @Autowired
    BPMetaFormDAO bpMetaFormDAO;

    @Autowired
    BPMetaNodeDAO bpMetaNodeDAO;

    @Autowired
    BPMetaNodeAssignDAO bpMetaNodeAssignDAO;
    @Autowired
    private RepositoryService repositoryService;

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30)
    public void deploy(BpMetaReq req) {
        // 查询流程
        BPMeta meta = bpMetaDAO.findById(req.getCorpId(), req.getDomain(), req.getBpDefId());
        // BpmnXMLConverter c = new BpmnXMLConverter();
        // BpmnModel bm = c.convertToBpmnModel(new StringStreamSource(meta.getBpmnXml()), true, true);
        // 部署流程
        String resourceName = meta.getBpName() + ".bpmn20.xml";
        DeploymentBuilder db = repositoryService.createDeployment();
        // db.name(meta.getBpName()).addBpmnModel(resourceName, bm).deploy();
        Deployment d = db.name(meta.getBpName()).addString(resourceName, meta.getBpmnXml()).tenantId(req.getCorpId())
                .deploy();
        // 修改此条为lastest 获取最新的版本。赋值engine——def-id

        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().deploymentId(d.getId())
                .processDefinitionTenantId(req.getCorpId()).latestVersion().singleResult();
        String version = meta.getVersion().split(":")[0];
        meta.setVersion(version + ":" + String.valueOf(pd.getVersion()));
        meta.setEngineDefId(pd.getId());
        meta.setLatest((byte) 1);
        meta.setDomain(req.getDomain());
        // 先将之前的同一种流程的lastest设为0
        bpMetaDAO.updateLastest(meta);
        bpMetaDAO.updateByPrimaryKey(meta);

    }

    @Override
    public void nodeAssign(BpMetaNodeAssignAddReq req) throws ServiceException {
        List<BPMetaNodeAssign> list = new ArrayList<BPMetaNodeAssign>();
        String[] relateIds = req.getRelateId().split(",");
        String[] relateNames = req.getRelateName().split(",");
        if (relateIds.length != relateNames.length) {
            throw new ServiceException("数据错误");
        }
        for (int i = 0; i < relateIds.length; i++) {
            BPMetaNodeAssign na = new BPMetaNodeAssign();
            na.setAssignId(IdUtil.geneId());
            na.setAssignType(req.getAssignType());
            na.setBpDefId(req.getBpDefId());
            na.setCorpId(req.getCorpId());
            na.setCreateTime(new Date());
            na.setCreateUserId(req.getUserId());
            na.setNodeId(req.getNodeId());
            na.setRelateId(relateIds[i]);
            na.setRelateName(relateNames[i]);
            na.setRelateType(req.getRelateType());
            na.setRelateGroup(req.getRelateGroup());
            list.add(na);
        }
        bpMetaNodeAssignDAO.insertBatch(list, req.getDomain());
    }

    @Override
    public void nodeAssignDelete(BpMetaNodeAssignDeleteReq req) {
        bpMetaNodeAssignDAO.deleteAssign(req);
    }

    @Override
    public void nodeRelateForm(BpMetaFormRelateReq req) {
        bpMetaNodeDAO.updateFormKeyByNodeId(req);
    }

    @Override
    public List<BpMetaCorpProductVO> queryAllBPMetaCorpProduct(BpMetaQueryReq req) {
        List<BpMetaCorpProductVO> list = bpMetaDAO.selectBPMetaCorpProduct(req);
        return list;
    }

    @Override
    public List<BpMetaNodeVO> queryAllNodeListTask(BpMetaNodeQueryReq req) {
        List<BpMetaNodeVO> list = bpMetaNodeDAO.selectBpMetaNodeMetaTask(req);
        return list;
    }

    @Override
    public RespPage<List<BpMetaCorpProductVO>> queryBPMetaCorpProduct(BpMetaQueryReq req) {
        List<BpMetaCorpProductVO> list = bpMetaDAO.selectBPMetaCorpProduct(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        int row = CountHelper.getTotalRow();
        return new RespPage<List<BpMetaCorpProductVO>>(list, row);
    }

    @Override
    public List<BpMetaFormDefVO> queryBpMetaFormByDefId(BpMetaFormDefQuery req) {
        return bpMetaFormDAO.selectBPMetaFormByDefId(req);
    }

    @Override
    public List<BpMetaCorpProductVO> queryDeptMeteCorpProduct(String domain, String deptId) {
        List<BpMetaCorpProductVO> list = bpMetaDAO.queryDeptMeteCorpProduct(domain, deptId);
        return list;
    }

    @Override
    public List<BpMetaNodeVO> queryDeptNodeListTask(String domain, String bpDefId, String deptId) {
        List<BpMetaNodeVO> list = bpMetaNodeDAO.selectDeptBpMetaNodeMetaTask(domain, bpDefId, deptId);
        return list;
    }

    @Override
    public RespPage<List<BPMetaNodeAssign>> queryNodeAssignList(BpMetaNodeAssignQueryReq req) {
        List<BPMetaNodeAssign> list = bpMetaNodeAssignDAO.selectByNodeId(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        int row = CountHelper.getTotalRow();
        return new RespPage<List<BPMetaNodeAssign>>(list, row);
    }

    @Override
    public RespPage<List<BpMetaNodeVO>> queryNodeListTask(BpMetaNodeQueryReq req) {
        List<BpMetaNodeVO> list = bpMetaNodeDAO.selectBpMetaNodeMetaTask(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        int row = CountHelper.getTotalRow();
        return new RespPage<List<BpMetaNodeVO>>(list, row);
    }

    @Override
    public RespPage<List<BpMetaNodeVO>> queryNodeListTaskAndStart(BpMetaNodeQueryReq req) {
        List<BpMetaNodeVO> list = bpMetaNodeDAO.selectBpMetaNodeMetaTaskAndStart(req, new RowBounds(req.getOffset(),
                req.getLimit()));
        int row = CountHelper.getTotalRow();
        return new RespPage<List<BpMetaNodeVO>>(list, row);
    }

}
