package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.Resources;

public interface ResourcesService {

    void deleteResource(String resourceId, String domain);

    void insertResource(Resources resource, String domain);

    Resources queryResourcesById(String corpId, String resourceId, String domain);

    List<Resources> queryResourcesByIds(String corpId, List<String> resourceIds, String domain);

}
