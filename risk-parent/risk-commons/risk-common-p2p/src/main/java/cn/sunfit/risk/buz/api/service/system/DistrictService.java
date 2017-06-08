package cn.sunfit.risk.buz.api.service.system;

import java.util.List;
import java.util.Map;

import cn.sunfit.risk.buz.api.beans.corp.District;

public interface DistrictService {

    Map<String, Object> queryDistrictInfo();
    
    List<District> selectNodes();
}
