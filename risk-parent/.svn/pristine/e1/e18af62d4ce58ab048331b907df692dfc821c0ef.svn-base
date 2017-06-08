package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.CustContact;

@Repository
public interface CustContactDAO {

    void deleteCustContactsByCustId(@Param("custId") String custId, @Param("domain") String domain);

    void insert(@Param("custContacts") List<CustContact> custContacts, @Param("domain") String domain);

    List<CustContact> selectCustContactsByCustId(@Param("custId") String custId, @Param("domain") String domain);

}