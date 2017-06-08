package cn.sunfit.risk.buz.server.service.p2p.excel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.p2p.P2PBank;
import cn.sunfit.risk.buz.api.service.p2p.excel.P2PBankService;
import cn.sunfit.risk.buz.server.dao.p2p.excel.P2PBankDAO;

@Service("risk.p2PBankService")
public class P2PBankServiceImpl implements P2PBankService {
    @Autowired
    private P2PBankDAO p2PBankDAO;

    @Override
    public List<P2PBank> findBank() {
        return p2PBankDAO.findBank();
    }

    @Override
    public P2PBank findByBankCode(String bankCode) {
        // TODO Auto-generated method stub
        return p2PBankDAO.findByBankCode(bankCode);
    }

    @Override
    public List<P2PBank> getBankByThirdType(String thirdType) {
        // TODO Auto-generated method stub
        return p2PBankDAO.getBankByThirdType(thirdType);
    }

    @Override
    public String getBankcodeByName(String bankName) {
        return p2PBankDAO.getBankcodeByName(bankName);
    }

    @Override
    public List<Map<String, String>> getBankList() {
        return p2PBankDAO.getBankList();
    }
}
