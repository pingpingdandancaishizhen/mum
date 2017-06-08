package cn.sunfit.risk.buz.server.dao.api.jfjd;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFRegion;
import cn.sunfit.risk.buz.api.beans.corp.District;

@Repository
public interface JFRegionDAO {

    List<JFRegion> queryRegions(String code);

    List<District> selectNodes();

    List<District> selectProvinces();

}