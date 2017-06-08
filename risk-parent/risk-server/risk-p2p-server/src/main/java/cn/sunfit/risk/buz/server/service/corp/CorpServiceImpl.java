package cn.sunfit.risk.buz.server.service.corp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.corp.Corp;
import cn.sunfit.risk.buz.api.service.corp.CorpService;
import cn.sunfit.risk.buz.api.vo.corp.CorpLwInfoVO;
import cn.sunfit.risk.buz.api.vo.corp.CorpUpdateReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpVO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;

@Service("risk.corpService")
public class CorpServiceImpl implements CorpService {
    @Autowired
    private CorpDAO corpDAO;

    @Override
    public CorpVO queryCorpInfo(String corpId) {
        CorpVO vo = corpDAO.selectCorpInfo(corpId);
        return vo;
    }

    @Override
    public List<String> selectCorpDomain() {
        return corpDAO.selectCorpDomain();
    }

    @Override
    public CorpLwInfoVO selectLwInfoByDomain(String domain) {
        return corpDAO.selectLwInfoByDomain(domain);
    }

    @Override
    public void updateCorpInfo(CorpUpdateReq req) {
        Corp c = corpDAO.selectByPrimaryKey(req.getId());
        c.setCorpName(req.getCorpName());
        c.setSimpleName(req.getSimpleName());
        c.setDescc(req.getDescc());
        c.setLogo(req.getLogo());
        c.setLinkPhone(req.getLinkPhone());
        c.setAddress(req.getAddress());
        c.setAddressDetail(req.getAddressDetail());
        corpDAO.updateByPrimaryKey(c);
    }

}
