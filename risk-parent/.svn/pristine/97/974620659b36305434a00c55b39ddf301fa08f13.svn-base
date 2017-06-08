package cn.sunfit.risk.buz.server.service.api.jfjd;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCorpUserDTO;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFCorpUserService;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFCorpUserExisitQueryReq;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFCorpUserDAO;

@Service("jfjd.corpUserService")
public class JFCorpUserServiceImpl implements JFCorpUserService {

    @Autowired
    private JFCorpUserDAO jFCorpUserDAO;

    @Override
    public JFCorpUserDTO queryUserById(String sassId) {
        return jFCorpUserDAO.selectUserById(sassId);
    }

    @Override
    public Map<String, Object> userAuth(JFCorpUserExisitQueryReq req) throws ServiceException {
        int count = jFCorpUserDAO.getExisitUserCount(req);
        if (count >= 1) {
            Map<String, Object> result = new HashMap<String, Object>();
            String userId = jFCorpUserDAO.getIdByCard(req);
            result.put("userId", userId);
            return result;
        } else {
            throw new ServiceException("机构认证失败");
        }
    }

}
