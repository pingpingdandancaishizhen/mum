package cn.sunfit.risk.buz.server.dao.system;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.system.CarSeries;

@Repository
public interface CarSeriesDAO {
    List<CarSeries> selectAllCarSeries();
}