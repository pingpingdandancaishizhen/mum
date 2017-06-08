package cn.sunfit.risk.buz.server.service.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sunfit.risk.buz.api.beans.bank.DmBank;
import cn.sunfit.risk.buz.api.beans.corp.BlackList;
import cn.sunfit.risk.buz.api.beans.corp.CustOperLog;
import cn.sunfit.risk.buz.api.service.bank.BankService;
import cn.sunfit.risk.buz.api.service.corp.BlackListService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.corp.CustomerDTO;
import cn.sunfit.risk.buz.server.dao.bank.BankDAO;
import cn.sunfit.risk.buz.server.dao.corp.BlackListDAO;
import cn.sunfit.risk.buz.server.dao.corp.CustOperLogDAO;
import cn.sunfit.risk.buz.server.dao.corp.CustomerDAO;

@Service("risk.bankService")
public class BankServiceImpl implements BankService {

    @Autowired
    BankDAO bankDao;

	@Override
	public List<DmBank> findAll() {
		// TODO Auto-generated method stub
		return bankDao.findAll();
	}

	

    
    
}
