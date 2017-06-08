package cn.sunfit.risk.buz.server.dao.metadata;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaField;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;

@Repository
public interface BPMetaFieldDAO {

    List<BPMetaField> findFieldKey(FormQuery req);

}