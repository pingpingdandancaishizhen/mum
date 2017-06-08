package cn.sunfit.risk.buz.server.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.system.DataDic;

@Repository
public interface DataDicDAO {

    String getDataDicKey(@Param("domain") String domain, @Param("dicValue") String dicValue,
            @Param("dicType") String dicType, @Param("productCode") String productCode);

    List<DataDic> getDicByField(@Param("domain") String domain, @Param("corpId") String corpId,
            @Param("productCode") String productCode, @Param("provide") String provide);

    /**
     * 查询所有的某类型的键值
     * @param productId 
     * @param corpId 
     * @param configType
     * @return
     */
    List<DataDic> getDicByType(@Param("dicTypes") List<String> dicTypes, @Param("dicStatus") Boolean dicStatus,
            @Param("corpId") String corpId, @Param("productId") String productId, @Param("bpDefId") String bpDefId);

    List<DataDic> getDicByTypeP2P(@Param("dicTypes") List<String> asList, @Param("dicStatus") Boolean true1,
            @Param("corpId") String corpId, @Param("productId") String productId, @Param("bpDefId") String bpDefId,
            @Param("domain") String domain);

    String getFieldProvider(@Param("domain") String domain, @Param("fieldKey") String fieldKey,
            @Param("productCode") String productCode);

    List<Map<String, String>> getListByType(@Param("domain") String domain, @Param("productCode") String productCode,
            @Param("dicType") String dicType);
}
