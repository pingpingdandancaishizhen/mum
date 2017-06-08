package cn.sunfit.risk.buz.server.service.corp;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.corp.CorpGroup;
import cn.sunfit.risk.buz.api.service.corp.CorpGroupService;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.GroupQueryReq;
import cn.sunfit.risk.buz.server.dao.corp.CorpGroupDAO;

@Service("risk.corpGroupService")
public class CorpGroupServiceImpl implements CorpGroupService {
    @Autowired
    private CorpGroupDAO corpGroupDAO;

    @Override
    public RespPage<List<CorpGroup>> queryGroupList(GroupQueryReq req) {
        List<CorpGroup> list = corpGroupDAO.selectGroup(req, new RowBounds(req.getOffset(), req.getLimit()));
        final int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<CorpGroup>>(list, totalCount);
    }
}
