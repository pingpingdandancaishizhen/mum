package cn.sunfit.risk.buz.api.service.system;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.system.DataDic;

/**
 * 
 * @Title: DataService.java
 * @Package cn.sunfit.risk.buz.api.service.system
 * @Description: 表单数据服务
 * @author XFL
 * @date 2017年1月5日 上午10:46:24
 * @version V1.0
 */
public interface DataService {
    List<DataDic> getDataDic(String type, String corpId, String productId, String bpDefId);

    List<DataDic> getDataDicP2P(String type, String corpId, String productId, String bpDefId, String domain);

    String getDicKeyFromValue(String domain, String productId, String fieldKey, String dicValue);
}
