package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.CorpGroup;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.GroupQueryReq;

public interface CorpGroupService {

    RespPage<List<CorpGroup>> queryGroupList(GroupQueryReq req);

}
