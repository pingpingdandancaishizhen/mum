package cn.sunfit.risk.buz.server.dao.buz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.buz.BPBigAttr;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;

@Repository
public interface BPBigAttrDAO {
    void clearDraftValueByBpId(BPBigAttr attr);

    List<BPBigAttr> findByBP(FormQuery req);

    void insertBigAttr(BPBigAttr attr);

    List<BPBigAttr> selectBatch(@Param("bigattrs") List<BPBigAttr> bigattrs, @Param("bpId") String bpId,
            @Param("domain") String domain);

    String selectValueByNameBpId(BPBigAttr bpAttr);

    // void updateBatch(@Param("bigattrs") List<BPBigAttr> bigattrs, @Param("bpId") String bpId,@Param("domain") String
    // domain);

    int updateDraftByNameBpId(BPBigAttr attr);

    int updateValueByNameBpId(BPBigAttr attr);
}