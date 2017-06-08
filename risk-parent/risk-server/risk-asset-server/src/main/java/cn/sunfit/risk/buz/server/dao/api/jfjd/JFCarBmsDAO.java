package cn.sunfit.risk.buz.server.dao.api.jfjd;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCarBms;

@Repository
public interface JFCarBmsDAO {

    List<JFCarBms> selectAllCarBrand();

    List<JFCarBms> selectModelsBySeries(String seriesId);

    List<JFCarBms> selectSeriesByBrand(String brandId);
}