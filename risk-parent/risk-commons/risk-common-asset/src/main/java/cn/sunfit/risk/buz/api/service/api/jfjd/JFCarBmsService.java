package cn.sunfit.risk.buz.api.service.api.jfjd;

import java.util.Map;

import cn.sunfit.risk.buz.api.exception.ServiceException;

public interface JFCarBmsService {

    public Map<String, Object> getBmsInfo(String type, String id) throws ServiceException;

}
