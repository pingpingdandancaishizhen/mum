package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.District;

@Repository
public interface DistrictDAO {

    List<District> selectProvinces();

    List<District> selectNodes();

}