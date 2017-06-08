package cn.sunfit.risk.buz.server.dao.api.jfjd;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFIdNameVO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFMetaDTO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFProduct;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFProductShowVO;

@Repository
public interface JFProductDAO {

    List<JFProductShowVO> queryProducts(String corpId);

    JFProduct selectById(String id);

    int selectCountByIdForJF(String id);

    String selectFeeConfigById(@Param("id") String id);

    JFMetaDTO selectMeta(@Param("productId") String productId, @Param("domain") String domain);

    List<JFIdNameVO> selectPartner(@Param("domain") String domain, @Param("productId") String productId,
            @Param("roleId") String roleId);
}