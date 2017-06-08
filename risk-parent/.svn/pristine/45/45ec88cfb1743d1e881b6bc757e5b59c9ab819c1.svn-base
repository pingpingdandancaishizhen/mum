package cn.sunfit.risk.buz.server.dao.repayment;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.repayment.RepaymentSettlement;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentSettlementSaveReq;

@Repository
public interface RepaymentSettlementDAO {
    int insert(RepaymentSettlementSaveReq record);

    RepaymentSettlement queryByPrimaryKey(@Param("bpId") String bpId, @Param("domain") String domain);
}