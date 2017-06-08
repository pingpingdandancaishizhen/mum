package cn.sunfit.risk.buz.server.dao.api.jfjd;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCorpUserDTO;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFCorpUserExisitQueryReq;

@Repository
public interface JFCorpUserDAO {

    int getExisitUserCount(JFCorpUserExisitQueryReq req);

    String getIdByCard(JFCorpUserExisitQueryReq req);

    JFCorpUserDTO selectUserById(String id);
}