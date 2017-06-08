package cn.sunfit.risk.buz.api.service.activiti;

import java.util.List;

import cn.sunfit.risk.buz.api.vo.loan.AssignReq;

public interface AssignService {

    /**
     * 
     * @Title: assignBp2Other
     * @Description: 指派单子给另外一个人
     * @param @param req   
     * @return void 
     * @author XFL 2017年2月7日 
     * @throws
     */
    void assignBp2Other(AssignReq req);

    /**
     * 
     * @Title: getUserIdsByNode
     * @Description: 根据参数获取可以参与流程节点的人员ID
     * @param @param engineDefId 流程定义ID
     * @param @param nodeKey 节点KEY
     * @param @param corpId 公司ID
     * @param @return   
     * @return List<String> 
     * @author XFL 2017年1月4日 
     * @throws
     */
    List<String> getUserIdsByNode(String engineDefId, String nodeKey, String corpId, String bpId);
}
