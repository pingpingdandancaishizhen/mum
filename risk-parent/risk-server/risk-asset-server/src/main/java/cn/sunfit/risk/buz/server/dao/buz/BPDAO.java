package cn.sunfit.risk.buz.server.dao.buz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.vo.activiti.TodoQueryDTO;
import cn.sunfit.risk.buz.api.vo.activiti.TodoQueryReq;
import cn.sunfit.risk.buz.api.vo.contract.ContractDTO;
import cn.sunfit.risk.buz.api.vo.contract.ContractQueryReq;
import cn.sunfit.risk.buz.api.vo.corp.BpQueryDTO;
import cn.sunfit.risk.buz.api.vo.corp.BpQueryReq;

@Repository
public interface BPDAO {

    BP findById(@Param("corpId") String corpId, @Param("domain") String corpDomain, @Param("bpId") String bpId);

    String getProductByBpId(@Param("bpId") String bpId, @Param("domain") String corpDomain);

    void insertBp(BP bp);

    List<ContractDTO> queryContractList(ContractQueryReq req, RowBounds rowBounds);

    String selectFeeConfigByBpId(@Param("bpId") String bpId, @Param("domain") String domain);

    List<BpQueryDTO> selectMyBorrowList(BpQueryReq req, RowBounds rowBounds);

    List<TodoQueryDTO> selectTodoList(TodoQueryReq req, RowBounds rowBounds);

    int update(BP bp);

    /**
     * 更新结束贷款状态 会清空activiti流程key id name
     * @Title: updateFinishBPstatus
     * @Description: 更新结束贷款状态 会清空activiti流程key id name
     * @param @param bp
     * @param @return   
     * @return int 
     * @author XJ 2017年3月15日 
     * @throws
     */
    int updateFinishBPstatus(BP bp);

    /**
     * 还款更新结束贷款状态 会清空activiti流程key id name 
     * @Title: updateFinishBPstatus
     * @Description: 还款更新结束贷款状态 会清空activiti流程key id name (判断是否还清)
     * @param @param bp
     * @param @return   
     * @return int 
     * @author XJ 2017年3月15日 
     * @throws
     */
    int updateFinishBPstatus4Repayment(BP bp);
}