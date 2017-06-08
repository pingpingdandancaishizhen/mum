package cn.sunfit.risk.buz.server.dao.p2p.activiti;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BP;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryDTO;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryReq;

@Repository
public interface BPDAO {

    BP findById(@Param("corpId") String corpId, @Param("domain") String corpDomain, @Param("bpId") String bpId);

    String getProductByBpId(@Param("bpId") String bpId, @Param("domain") String corpDomain);

    void insertBp(BP bp);

    String selectFeeConfigByBpId(@Param("bpId") String bpId, @Param("domain") String domain);

    List<TodoQueryDTO> selectTodoList(TodoQueryReq req, RowBounds rowBounds);

    int update(BP bp);

    void updateOper(@Param("domain") String domain, @Param("bpId") String bpId, @Param("operUser") String userId,
            @Param("operdate") Date date);
}