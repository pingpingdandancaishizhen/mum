package cn.sunfit.risk.buz.server.dao.corp;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.UserCode;

@Repository
public interface UserCodeDAO {
    long countSendCode(@Param("userId") String userId, @Param("type") String type);

    int insert(UserCode record);

    UserCode selectByPrimaryKey(String id);

    UserCode selectLastCode(@Param("userId") String userId, @Param("type") String type);

    long selectSmsCode(UserCode code);

    int updateByPrimaryKey(UserCode record);
}