package cn.sunfit.risk.buz.server.service.api.jfjd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCarBms;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFCarBmsService;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFCarBmsDAO;

@Service("jfjd.carBmsService")
public class JFCarBmsServiceImpl implements JFCarBmsService {

    @Autowired
    private JFCarBmsDAO jFCarBmsDAO;

    @Override
    public Map<String, Object> getBmsInfo(String type, String id) throws ServiceException {
        Map<String, Object> result = new HashMap<String, Object>();
        if ("brand".equals(type)) {
            List<JFCarBms> brandList = jFCarBmsDAO.selectAllCarBrand();
            result.put("list", brandList);
        } else if ("series".equals(type)) {
            if (StringUtils.isBlank(id)) {
                throw new ServiceException("参数错误");
            }
            List<JFCarBms> seriesList = jFCarBmsDAO.selectSeriesByBrand(id);
            result.put("list", seriesList);
        } else {
            if (StringUtils.isBlank(id)) {
                throw new ServiceException("参数错误");
            }
            List<JFCarBms> modelList = jFCarBmsDAO.selectModelsBySeries(id);
            result.put("list", modelList);
        }
        return result;
    }

}
