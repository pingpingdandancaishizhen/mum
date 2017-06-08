package cn.sunfit.risk.buz.server.service.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.system.CarBrand;
import cn.sunfit.risk.buz.api.beans.system.CarModel;
import cn.sunfit.risk.buz.api.beans.system.CarSeries;
import cn.sunfit.risk.buz.api.service.system.CarInfoService;
import cn.sunfit.risk.buz.api.vo.system.CarBrandNodeDTO;
import cn.sunfit.risk.buz.api.vo.system.CarInfoNodeDTO;
import cn.sunfit.risk.buz.server.dao.system.CarBrandDAO;
import cn.sunfit.risk.buz.server.dao.system.CarModelDAO;
import cn.sunfit.risk.buz.server.dao.system.CarSeriesDAO;

@Service("risk.carInfoService")
public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    CarBrandDAO carBrandDAO;
    @Autowired
    CarSeriesDAO carSeriesDAO;
    @Autowired
    CarModelDAO carModelDAO;

    private Map<String, Object> r;

    @PostConstruct
    private void cache() {
        r = new HashMap<String, Object>();
        List<CarInfoNodeDTO> info = new ArrayList<CarInfoNodeDTO>();
        List<CarBrand> carBrandList = carBrandDAO.selectAllCarBrand();
        List<CarSeries> carSeriesList = carSeriesDAO.selectAllCarSeries();
        List<CarModel> carModelList = carModelDAO.selectAllCarModel();
        r.put("brands", createBrandMap(carBrandList));
        r.put("carInfos", createCarInfoMap(info, carBrandList, carSeriesList, carModelList));
    }

    /**
     * provinces ：所有省信息 带有拼音
     * @Title: createBrandMap
     * @Description: provinces ：所有省信息 带有拼音
     * @param @param provinces
     * @param @return   
     * @return Map<String,List<ProvinceNodeDTO>> 
     * @author XJ 2017年1月16日 
     * @throws
     */
    private Map<String, List<CarBrandNodeDTO>> createBrandMap(List<CarBrand> carBrandList) {
        Map<String, List<CarBrandNodeDTO>> result = new HashMap<String, List<CarBrandNodeDTO>>();
        String py = "";
        for (CarBrand carBrand : carBrandList) {
            CarBrandNodeDTO carBrandNodeDTO = new CarBrandNodeDTO();
            carBrandNodeDTO.setName(carBrand.getBrandName());
            carBrandNodeDTO.setCode("b_" + carBrand.getBrandId() + "");
            if (!StringUtils.equals(carBrand.getFirstPinyin(), py)) {
                py = carBrand.getFirstPinyin();
                result.put(carBrand.getFirstPinyin(), new ArrayList<CarBrandNodeDTO>());
            }
            result.get(py).add(carBrandNodeDTO);
        }
        return result;
    }

    private List<CarInfoNodeDTO> createCarInfoMap(List<CarInfoNodeDTO> info, List<CarBrand> carBrandList,
            List<CarSeries> carSeriesList, List<CarModel> carModelList) {
        for (CarBrand carBrand : carBrandList) {
            CarInfoNodeDTO brandNode = new CarInfoNodeDTO();
            brandNode.setName(carBrand.getBrandName());
            brandNode.setCode("b_" + carBrand.getBrandId() + "");
            brandNode.setNodes(createCarSeriesNode(carSeriesList, carBrand.getBrandId()));
            info.add(brandNode);
        }
        for (CarSeries carSeries : carSeriesList) {
            CarInfoNodeDTO seriesNode = new CarInfoNodeDTO();
            seriesNode.setName(carSeries.getSeriesName());
            seriesNode.setCode("s_" + carSeries.getSeriesId() + "");
            seriesNode.setNodes(createCarModelNode(carModelList, carSeries.getSeriesId()));
            info.add(seriesNode);
        }
        return info;
    }

    private List<CarInfoNodeDTO> createCarModelNode(List<CarModel> carModelList, Integer seriesId) {
        List<CarInfoNodeDTO> info = new ArrayList<CarInfoNodeDTO>();
        for (CarModel carModel : carModelList) {
            if (seriesId.equals(carModel.getSeriesId())) {
                CarInfoNodeDTO modelNode = new CarInfoNodeDTO();
                modelNode.setName(carModel.getModelName());
                modelNode.setCode("m_" + carModel.getModelId() + "");
                info.add(modelNode);
            }
        }
        return info;
    }

    private List<CarInfoNodeDTO> createCarSeriesNode(List<CarSeries> carSeriesList, Integer brandId) {
        List<CarInfoNodeDTO> info = new ArrayList<CarInfoNodeDTO>();
        for (CarSeries carSeries : carSeriesList) {
            if (brandId.equals(carSeries.getBrandId())) {
                CarInfoNodeDTO seriesNode = new CarInfoNodeDTO();
                seriesNode.setName(carSeries.getSeriesName());
                seriesNode.setCode("s_" + carSeries.getSeriesId() + "");
                info.add(seriesNode);
            }
        }
        return info;
    }

    @Override
    public Map<String, Object> queryCarInfo() {
        return r;
    }

}
