package cn.sunfit.risk.buz.server.dao.repayment;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.repayment.RepaymentRecord;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentRecordSaveReq;

@Repository
public interface RepaymentRecordDAO {

    int insert(RepaymentRecordSaveReq record);

    List<RepaymentRecord> selectRepaymentRecords4Detail(@Param("domain") String domain,
            @Param("repaymentDetailId") String repaymentDetailId);

}
