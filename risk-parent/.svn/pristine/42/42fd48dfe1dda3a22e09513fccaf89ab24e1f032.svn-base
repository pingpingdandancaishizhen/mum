package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.CorpGroup;
import cn.sunfit.risk.buz.api.vo.corp.GroupQueryReq;

@Repository
public interface CorpGroupDAO {
    int insert(CorpGroup record);

    CorpGroup selectByPrimaryKey(String id);

    List<CorpGroup> selectGroup(GroupQueryReq req, RowBounds rowBounds);

    int updateByPrimaryKey(CorpGroup record);
}