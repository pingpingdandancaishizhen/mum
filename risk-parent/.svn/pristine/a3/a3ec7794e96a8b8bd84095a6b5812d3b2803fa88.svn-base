package cn.sunfit.risk.buz.server.service.api.jfjd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCorpShowVO;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFCorpService;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFCorpDAO;

@Service("jfjd.corpService")
public class JFCorpServiceImpl implements JFCorpService {

    @Autowired
    private JFCorpDAO jFCorpDAO;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public String getDomainByCorpId(String corpId) {
        return jFCorpDAO.getDomainByCorpId(corpId);
    }

    @Override
    public Map<String, Object> queryCorps() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<JFCorpShowVO> list = jFCorpDAO.queryCorps();
        result.put("list", list);
        return result;
    }
}
