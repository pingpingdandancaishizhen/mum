package cn.sunfit.risk.buz.server.service.system;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.system.DataDic;
import cn.sunfit.risk.buz.api.service.system.DataService;
import cn.sunfit.risk.buz.server.dao.system.DataDicDAO;

@Service("risk.dataService")
public class DataServiceImpl implements DataService {
    @Autowired
    DataDicDAO dataDicDAO;

    @Override
    public List<DataDic> getDataDic(String type, String corpId, String productId, String bpDefId) {
        String[] types = type.split(",");
        List<DataDic> list = dataDicDAO.getDicByType(Arrays.asList(types), Boolean.TRUE, corpId, productId, bpDefId);
        return list;
    }

    @Override
    public List<DataDic> getDataDicP2P(String type, String corpId, String productId, String bpDefId, String domain) {
        String[] types = type.split(",");
        List<DataDic> list = dataDicDAO.getDicByTypeP2P(Arrays.asList(types), Boolean.TRUE, corpId, productId, bpDefId,
                domain);
        return list;
    }

    @Override
    public String getDicKeyFromValue(String domain, String productId, String fieldKey, String dicValue) {
        String dataProvider = dataDicDAO.getFieldProvider(domain, fieldKey, productId);
        if (StringUtils.isBlank(dataProvider)) {
            return dicValue;
        }
        String dicKey = dataDicDAO.getDataDicKey(domain, dicValue, dataProvider, productId);
        if (StringUtils.isBlank(dicKey)) {
            dicKey = dicValue;
        }
        return dicKey;
    }

}
