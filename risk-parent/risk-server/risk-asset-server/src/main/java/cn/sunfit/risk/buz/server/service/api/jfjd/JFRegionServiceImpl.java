package cn.sunfit.risk.buz.server.service.api.jfjd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFRegion;
import cn.sunfit.risk.buz.api.beans.corp.District;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFRegionService;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFRegionDAO;

@Service("jfjd.regionService")
public class JFRegionServiceImpl implements JFRegionService {

    @Autowired
    JFRegionDAO jFRegionDAO;

    private List<JFRegion> createRegionList(List<District> provinces) {
        List<JFRegion> result = new ArrayList<JFRegion>();
        for (District district : provinces) {
            JFRegion region = new JFRegion();
            region.setCode(district.getDistCode());
            region.setAddress(district.getDistName());
            result.add(region);
        }
        return result;
    }

    @Override
    public Map<String, Object> queryNodes(String code) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<JFRegion> regions = jFRegionDAO.queryRegions(code);
        result.put("regions", regions);
        return result;
    }

    @Override
    public Map<String, Object> queryProvinces() {
        List<District> provinces = jFRegionDAO.selectProvinces();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("regions", createRegionList(provinces));
        return result;
    }
}
