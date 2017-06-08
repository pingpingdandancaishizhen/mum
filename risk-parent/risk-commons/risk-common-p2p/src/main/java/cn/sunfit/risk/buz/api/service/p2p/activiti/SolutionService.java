package cn.sunfit.risk.buz.api.service.p2p.activiti;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNodeAssign;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaFormDefQuery;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaFormDefVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaFormRelateReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeAssignAddReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeAssignDeleteReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeAssignQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaReq;

public interface SolutionService {

    /**
     * 
     * @Title: deploy
     * @Description: 部署流程
     * @param @param req   
     * @return void 
     * @author XFL 2017年1月4日 
     * @throws
     */
    void deploy(BpMetaReq req);

    /**
     * 
     * @Title: nodeAssign
     * @Description: 节点指派规则
     * @param @param req   
     * @return void 
     * @author XFL 2017年1月3日 
     * @throws
     */
    void nodeAssign(BpMetaNodeAssignAddReq req) throws ServiceException;

    /**
     * 
     * @Title: nodeAssignDelete
     * @Description: 删除节点指派规则
     * @param @param req   
     * @return void 
     * @author XFL 2017年1月3日 
     * @throws
     */
    void nodeAssignDelete(BpMetaNodeAssignDeleteReq req);

    /**
     * 
     * @Title: nodeRelateForm
     * @Description: 节点关联表单
     * @param @param req   
     * @return void 
     * @author XFL 2016年12月30日 
     * @throws
     */
    void nodeRelateForm(BpMetaFormRelateReq req);

    /**
     * 
     * @Title: queryBPMetaCorpProduct
     * @Description: 获取流程元数据和公司和产品信息
     * @param @return   
     * @return RespPage<List<BpMetaCorpProductVO>> 
     * @author XFL 2016年12月29日 
     * @throws
     */
    RespPage<List<BpMetaCorpProductVO>> queryBPMetaCorpProduct(BpMetaQueryReq req);

    /**
     * 
     * @Title: queryBpMetaFormByDefId
     * @Description: 根据流程定义查询表单
     * @param @param req
     * @param @return   
     * @return List<BpMetaFormDefVO> 
     * @author XFL 2016年12月30日 
     * @throws
     */
    List<BpMetaFormDefVO> queryBpMetaFormByDefId(BpMetaFormDefQuery req);

    /**
     * 
     * @Title: queryNodeAssignList
     * @Description: 查询任务审核指派的配置
     * @param @param req
     * @param @return   
     * @return RespPage<BPMetaNodeAssign> 
     * @author XFL 2017年1月3日 
     * @throws
     */
    RespPage<List<BPMetaNodeAssign>> queryNodeAssignList(BpMetaNodeAssignQueryReq req);

    /**
     * 
     * @Title: queryNodeListTask
     * @Description: 查询类型任务的节点。
     * @param @param req
     * @param @return   
     * @return RespPage<List<BpMetaNodeVO>> 
     * @author XFL 2016年12月30日 
     * @throws
     */
    RespPage<List<BpMetaNodeVO>> queryNodeListTask(BpMetaNodeQueryReq req);

    /**
     * 
     * @Title: queryNodeListTaskAndStart
     * @Description: 查询类型是任务和开始的节点
     * @param @param req
     * @param @return   
     * @return RespPage<List<BpMetaNodeVO>> 
     * @author XFL 2016年12月30日 
     * @throws
     */
    RespPage<List<BpMetaNodeVO>> queryNodeListTaskAndStart(BpMetaNodeQueryReq req);

}
