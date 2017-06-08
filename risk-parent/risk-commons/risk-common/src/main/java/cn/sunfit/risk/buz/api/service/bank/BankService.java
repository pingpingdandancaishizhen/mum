package cn.sunfit.risk.buz.api.service.bank;

import java.io.InputStream;
import java.util.List;

import cn.sunfit.risk.buz.api.beans.bank.DmBank;
import cn.sunfit.risk.buz.api.beans.corp.CalendarEvent;

public interface BankService {

	List<DmBank> findAll();

}
