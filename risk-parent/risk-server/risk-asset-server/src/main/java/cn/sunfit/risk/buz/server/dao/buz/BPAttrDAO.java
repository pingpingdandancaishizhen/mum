package cn.sunfit.risk.buz.server.dao.buz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.buz.ValueSelectDTO;
import cn.sunfit.risk.buz.api.beans.buz.ValueSelectReq;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;

@Repository
public interface BPAttrDAO {

    void clearDraftValueByBpId(BPAttr attr);

    List<BPAttr> findByBP(FormQuery req);

    ValueSelectDTO getValueByBpAndKey(ValueSelectReq req);

    String getValueFromDic(ValueSelectReq req);

    void insertAttr(BPAttr attr);

    List<BPAttr> selectBatch(@Param("attrs") List<BPAttr> attrs, @Param("bpId") String bpId,
            @Param("domain") String domain);

    String selectValueByNameBpId(BPAttr bpAttr);
    
    String selectDraftValueByNameBpId(BPAttr bpAttr);

    // void updateBatch(@Param("attrs") List<BPAttr> attrs, @Param("bpId") String bpId, @Param("domain") String domain);

    int updateDraftByNameBpId(BPAttr attr);

    int updateValueByNameBpId(BPAttr attr);
}