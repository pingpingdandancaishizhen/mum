package cn.sunfit.risk.buz.api.service.api.jfjd;

import java.util.Map;

public interface JFCorpService {

    String getDomainByCorpId(String corpId);

    Map<String, Object> queryCorps();
}
