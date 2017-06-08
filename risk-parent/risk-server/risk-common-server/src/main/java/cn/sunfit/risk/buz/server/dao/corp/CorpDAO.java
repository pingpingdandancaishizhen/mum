package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.Corp;
import cn.sunfit.risk.buz.api.vo.corp.CorpLwInfoVO;
import cn.sunfit.risk.buz.api.vo.corp.CorpVO;

@Repository
public interface CorpDAO {
    int insert(Corp record);

    Corp selectByPrimaryKey(String id);

    List<String> selectCorpDomain();

    CorpVO selectCorpInfo(String corpId);

    CorpLwInfoVO selectLwInfoByDomain(String domain);

    int updateByPrimaryKey(Corp record);
}