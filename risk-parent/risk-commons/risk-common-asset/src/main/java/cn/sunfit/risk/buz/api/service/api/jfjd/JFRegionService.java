package cn.sunfit.risk.buz.api.service.api.jfjd;

import java.util.Map;

public interface JFRegionService {

    Map<String, Object> queryNodes(String code);

    Map<String, Object> queryProvinces();

}
