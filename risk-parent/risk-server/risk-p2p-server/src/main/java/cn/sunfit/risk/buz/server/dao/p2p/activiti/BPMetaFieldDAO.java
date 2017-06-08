package cn.sunfit.risk.buz.server.dao.p2p.activiti;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaField;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;

@Repository
public interface BPMetaFieldDAO {

    List<BPMetaField> findFieldKey(FormQuery req);

}