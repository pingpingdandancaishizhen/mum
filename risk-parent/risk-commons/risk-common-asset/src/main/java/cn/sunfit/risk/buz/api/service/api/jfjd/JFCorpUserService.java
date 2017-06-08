package cn.sunfit.risk.buz.api.service.api.jfjd;

import java.util.Map;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCorpUserDTO;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFCorpUserExisitQueryReq;

public interface JFCorpUserService {

    JFCorpUserDTO queryUserById(String sassId);

    Map<String, Object> userAuth(JFCorpUserExisitQueryReq req) throws ServiceException;
}
