package cn.sunfit.risk.buz.server.dao.system;

import cn.sunfit.risk.buz.api.beans.system.SystemUrl;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUrlDAO {
    int insert(SystemUrl record);

    SystemUrl selectByPrimaryKey(String urlId);

    int updateByPrimaryKey(SystemUrl record);
}