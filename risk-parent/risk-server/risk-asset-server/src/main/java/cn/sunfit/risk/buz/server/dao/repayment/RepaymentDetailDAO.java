package cn.sunfit.risk.buz.server.dao.repayment;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.vo.repayment.OverdueQueryResp;
import cn.sunfit.risk.buz.api.vo.repayment.OverdueQueryVO;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentQueryReq;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentQueryResp;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentQueryVO;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentRecordDTO;

@Repository
public interface RepaymentDetailDAO {
    void addRepaymentDetail(@Param("repaymentDetailList") List<RepaymentDetail> repaymentDetailList,
            @Param("domain") String domain);

    List<OverdueQueryVO> queryOverdueExportList(@Param("req") RepaymentQueryReq req, @Param("domain") String domain);

    List<OverdueQueryResp> queryOverdueList(@Param("req") RepaymentQueryReq req, @Param("domain") String domain,
            RowBounds rowBounds);

    RepaymentDetail queryRepaymentDetailInfo(@Param("id") String id, @Param("domain") String domain);

    List<RepaymentDetail> queryRepaymentDetailList(@Param("bpId") String bpId, @Param("domain") String domain);

    List<RepaymentQueryVO> queryRepaymentExportList(@Param("req") RepaymentQueryReq req, @Param("domain") String domain);

    List<RepaymentQueryResp> queryRepaymentList(@Param("req") RepaymentQueryReq req, @Param("domain") String domain,
            RowBounds rowBounds);

    List<RepaymentRecordDTO> queryRepaymentRecordList(@Param("bpId") String bpId, @Param("domain") String domain);

    /**
     * 还款专用 计算已还金额 是否换完
     * @Title: updateRepaymentFee
     * @Description: TODO
     * @param @param repaymentDetail
     * @param @param domain   
     * @return void 
     * @author RJS 2017年3月4日 
     * @throws
     */
    void updateRepaymentFee(@Param("detail") RepaymentDetail repaymentDetail, @Param("domain") String domain,
            @Param("znjFee") BigDecimal znjFee, @Param("overdueCount") Integer overdueCount,
            @Param("overdueAmount") BigDecimal overdueAmount, @Param("znjFeeCal") String znjFeeCal);

}