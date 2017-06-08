package cn.sunfit.risk.buz.server.dao.p2p.order;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoAttachment;

@Repository
public interface LoanInfoAttachDAO {
    void backup(@Param("attachId") Long attachId, @Param("domain") String domain);

    void delete(@Param("attachId") Long attachId, @Param("domain") String domain);

    void insert(@Param("attach") LoanInfoAttachment attach, @Param("domain") String domain);
}
