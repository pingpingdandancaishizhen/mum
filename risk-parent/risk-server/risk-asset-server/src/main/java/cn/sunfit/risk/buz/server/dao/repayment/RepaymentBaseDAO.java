package cn.sunfit.risk.buz.server.dao.repayment;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.repayment.RepaymentBase;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFBpStatusGetReq;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentReportDTO;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentReportReq;

@Repository
public interface RepaymentBaseDAO {
    int insert(@Param("record") RepaymentBase record, @Param("domain") String domain);

    RepaymentBase selectByPrimaryKey(@Param("domain") String domain, @Param("bpId") String bpId);

    List<RepaymentReportDTO> selectRepaymentReport(@Param("req") RepaymentReportReq req, RowBounds rowBounds);

    Integer selectStatusByBp(JFBpStatusGetReq req);

    int updateRepaymentFee(@Param("base") RepaymentBase record, @Param("domain") String domain);

    int updateRepaymentFee4Settlement(@Param("base") RepaymentBase record, @Param("domain") String domain);

}