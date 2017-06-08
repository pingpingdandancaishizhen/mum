package cn.sunfit.risk.buz.server.dao.p2p.excel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.P2PBank;

@Repository
public interface P2PBankDAO {
    public List<P2PBank> findBank();

    public P2PBank findByBankCode(@Param("bankCode") String bankCode);

    public List<P2PBank> getBankByThirdType(@Param("thirdType") String thirdType);

    public String getBankcodeByName(@Param("bankName") String bankName);

    public List<Map<String, String>> getBankList();

}
