package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.activiti.TodoQueryDTO;
import cn.sunfit.risk.buz.api.vo.activiti.TodoQueryReq;
import cn.sunfit.risk.buz.api.vo.contract.ContractDTO;
import cn.sunfit.risk.buz.api.vo.contract.ContractQueryReq;
import cn.sunfit.risk.buz.api.vo.corp.BpQueryDTO;
import cn.sunfit.risk.buz.api.vo.corp.BpQueryReq;

public interface BpService {
    public List<String> getDataRole(String userId, String corpId);

    RespPage<List<ContractDTO>> queryContractList(ContractQueryReq req);

    List<BPMetaNode> selectAllBPMetaNode(String domain);

    RespPage<List<BpQueryDTO>> selectAllLoanList(BpQueryReq req);

    List<BPMetaNode> selectBPMetaNodeByProduct(String domain, String product);

    RespPage<List<BpQueryDTO>> selectMyLoanList(BpQueryReq req);

    public RespPage<List<TodoQueryDTO>> selectTodoList(TodoQueryReq req);
}
