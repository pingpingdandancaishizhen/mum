package cn.sunfit.risk.buz.server.dao.system;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.system.CarModel;

@Repository
public interface CarModelDAO {
    List<CarModel> selectAllCarModel();
}