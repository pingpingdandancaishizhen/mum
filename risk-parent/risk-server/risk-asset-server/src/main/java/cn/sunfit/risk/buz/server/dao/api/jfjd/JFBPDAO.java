package cn.sunfit.risk.buz.server.dao.api.jfjd;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.vo.api.jfjd.JFBpStatusDTO;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFBpStatusGetReq;

@Repository
public interface JFBPDAO {

    long countBpById(@Param("bpId") String bpId, @Param("domain") String domain);

    Integer getLoanStatus(JFBpStatusGetReq req);

    String getProductByBp(JFBpStatusGetReq req);

    JFBpStatusDTO getStatusById(JFBpStatusGetReq req);
}