package cn.sunfit.risk.buz.server.dao.corp;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.BlackList;

@Repository
public interface BlackListDAO {
    int insert(BlackList record);

    int delete(@Param("domain") String domain, @Param("licenseNum") String licenseNum);

    BlackList selectByLicenseNum(@Param("licenseNum") String licenseNum, @Param("domain") String domain);

}