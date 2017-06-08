package cn.sunfit.risk.buz.server.dao.log;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.log.LoginLog;
import cn.sunfit.risk.buz.api.vo.corp.LoginHistoryReq;

@Repository
public interface LoginLogDAO {
    int insert(LoginLog record);

    LoginLog selectByPrimaryKey(String id);

    List<LoginLog> selectByUserId(LoginHistoryReq req, RowBounds rowBounds);

    int updateByPrimaryKey(LoginLog record);
}