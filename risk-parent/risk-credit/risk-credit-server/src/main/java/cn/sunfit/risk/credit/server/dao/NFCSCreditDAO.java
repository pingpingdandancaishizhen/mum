package cn.sunfit.risk.credit.server.dao;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.credit.api.beans.NFCSCredit;

@Repository
public interface NFCSCreditDAO {

    int insert(NFCSCredit record);

    NFCSCredit selectCreditResultCurDate(NFCSCredit record);

}