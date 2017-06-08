package cn.sunfit.risk.buz.server.dao.api.jfjd;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.buz.ValueSelectReq;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFValueSelectDTO;

@Repository
public interface JFBPAttrDAO {

    JFValueSelectDTO getValueByBpAndKey(ValueSelectReq req);

    String getValueFromDic(ValueSelectReq req);
}