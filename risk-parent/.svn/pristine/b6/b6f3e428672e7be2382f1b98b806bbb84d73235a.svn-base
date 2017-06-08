package cn.sunfit.risk.buz.server.dao.api.jfjd;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCustomerAddDTO;

@Repository
public interface JFCustomerDAO {

    long checkCustomerBlackList(@Param("licenseNum") String licenseNum, @Param("domain") String domain);

    String checkCustomerExist(@Param("uid") String uid, @Param("licenseNum") String licenseNum,
            @Param("domain") String domain);

    void insert(JFCustomerAddDTO dto);

}