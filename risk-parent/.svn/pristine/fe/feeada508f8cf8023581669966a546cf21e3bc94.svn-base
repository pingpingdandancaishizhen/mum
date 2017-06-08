package cn.sunfit.risk.buz.api.service.p2p.activiti;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNode;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryDTO;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryReq;
import cn.sunfit.risk.buz.api.vo.RespPage;

public interface BpService {
    public List<String> getDataRole(String userId, String corpId);

    List<BPMetaNode> selectAllBPMetaNode(String domain);

    List<BPMetaNode> selectBPMetaNodeByProduct(String domain, String product);

    /**
     * 根据筛选条件查询待办事项
     * @Title: selectTodoList
     * @Description: TODO
     * @param @param req 域名，公司id，产品类型等过滤条件
     * @param @return   
     * @return RespPage<List<TodoQueryDTO>> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    public RespPage<List<TodoQueryDTO>> selectTodoList(TodoQueryReq req);
}
