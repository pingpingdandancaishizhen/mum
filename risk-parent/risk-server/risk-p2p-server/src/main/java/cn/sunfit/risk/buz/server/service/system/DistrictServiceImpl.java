package cn.sunfit.risk.buz.server.service.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.corp.District;
import cn.sunfit.risk.buz.api.service.system.DistrictService;
import cn.sunfit.risk.buz.api.vo.system.DistrictNodeDTO;
import cn.sunfit.risk.buz.api.vo.system.ProvinceNodeDTO;
import cn.sunfit.risk.buz.server.dao.corp.DistrictDAO;

@Service("risk.districtService")
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictDAO districtDAO;

    /**
     * 地址信息接口
     * 返回map
     *      provinces ：所有省信息 带有拼音
     *      districtList ： 所有省市区信息 级联
     * <p>Description:TODO </p>
     * @author RJS 2017年1月16日 
     * @return
     * @see cn.sunfit.risk.buz.api.service.system.DistrictService#queryDistrictInfo()
     */
    @Override
    public Map<String, Object> queryDistrictInfo() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<District> provinces = districtDAO.selectProvinces();
        List<District> nodes = districtDAO.selectNodes();

        List<DistrictNodeDTO> info = new ArrayList<DistrictNodeDTO>();
        result.put("provinces", createProvinceMap(provinces));
        result.put("districtList", createRootNode(info, nodes));
        return result;
    }

    /**
     * provinces ：所有省信息 带有拼音
     * @Title: createProvinceMap
     * @Description: provinces ：所有省信息 带有拼音
     * @param @param provinces
     * @param @return   
     * @return Map<String,List<ProvinceNodeDTO>> 
     * @author XJ 2017年1月16日 
     * @throws
     */
    private Map<String, List<ProvinceNodeDTO>> createProvinceMap(List<District> provinces) {
        Map<String, List<ProvinceNodeDTO>> result = new HashMap<String, List<ProvinceNodeDTO>>();
        String py = "";
        for (District district : provinces) {
            ProvinceNodeDTO provinceNodeDTO = new ProvinceNodeDTO();
            provinceNodeDTO.setAddress(district.getDistName());
            provinceNodeDTO.setCode(district.getDistCode());
            if (!StringUtils.equals(district.getPy(), py)) {
                py = district.getPy();
                result.put(district.getPy(), new ArrayList<ProvinceNodeDTO>());
            }
            result.get(py).add(provinceNodeDTO);
        }
        return result;
    }

    /**
     * districtList ： 所有省市区信息 级联
     * @Title: createRootNode
     * @Description: districtList ： 所有省市区信息 级联
     * @param @param provinces
     * @param @return   
     * @return Map<String,List<ProvinceNodeDTO>> 
     * @author XJ 2017年1月16日 
     * @throws
     */
    private List<DistrictNodeDTO> createRootNode(List<DistrictNodeDTO> info, List<District> nodes) {
        for (District district : nodes) {
            // 如果是省级地址
            if (StringUtils.equals(district.getParentCode(), "1")) {
                DistrictNodeDTO node = createNode(district);
                node.setNodes(createSubNode(nodes, district.getDistCode()));
                info.add(node);
            } else {
                // 地址编号6位 中间两位非零 最后两位为零 为市级
                Integer cityFlag = Integer.parseInt(district.getDistCode().substring(2, 4));
                Integer districtFlag = Integer.parseInt(district.getDistCode().substring(4, 6));
                if (cityFlag > 0 && districtFlag == 0) {
                    DistrictNodeDTO node = createNode(district);
                    node.setNodes(createSubNode(nodes, district.getDistCode()));
                    info.add(node);
                }
            }
        }
        return info;
    }

    private DistrictNodeDTO createNode(District district) {
        DistrictNodeDTO node = new DistrictNodeDTO();
        node.setCode(district.getDistCode());
        node.setAddress(district.getDistName());
        return node;
    }

    private List<DistrictNodeDTO> createSubNode(List<District> nodes, String code) {
        List<DistrictNodeDTO> info = new ArrayList<DistrictNodeDTO>();
        for (District district : nodes) {
            if (StringUtils.equals(district.getParentCode(), code)) {
                DistrictNodeDTO node = createNode(district);
                info.add(node);
            }
        }
        return info;
    }

    @Override
    public List<District> selectNodes() {
        // TODO Auto-generated method stub
        return districtDAO.selectNodes();
    }

}
