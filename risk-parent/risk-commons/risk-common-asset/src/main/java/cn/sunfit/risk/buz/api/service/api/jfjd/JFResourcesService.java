package cn.sunfit.risk.buz.api.service.api.jfjd;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFResources;
import cn.sunfit.risk.buz.api.beans.corp.Resources;

public interface JFResourcesService {

    void deleteResource(String resourceId, String domain);

    void insertResource(Resources resource, String domain);

    JFResources queryResourcesById(String corpId, String resourceId, String domain);

    List<JFResources> queryResourcesByIds(String corpId, List<String> resourceIds, String domain);

}
