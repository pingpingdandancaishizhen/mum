package cn.sunfit.risk.buz.server.service.corp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.corp.Resources;
import cn.sunfit.risk.buz.api.service.corp.ResourcesService;
import cn.sunfit.risk.buz.server.dao.corp.ResourcesDAO;

@Service("risk.resourcesService")
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    ResourcesDAO resourcesDAO;

    @Override
    public void deleteResource(String resourceId, String domain) {
        resourcesDAO.delete(domain, resourceId);
    }

    @Override
    public void insertResource(Resources resource, String domain) {
        resourcesDAO.insert(domain, resource);
    }

    @Override
    public Resources queryResourcesById(String corpId, String resourceId, String domain) {
        return resourcesDAO.selectById(domain, resourceId);
    }

    @Override
    public List<Resources> queryResourcesByIds(String corpId, List<String> resourceIds, String domain) {
        return resourcesDAO.selectByIds(domain, resourceIds);
    }

}
