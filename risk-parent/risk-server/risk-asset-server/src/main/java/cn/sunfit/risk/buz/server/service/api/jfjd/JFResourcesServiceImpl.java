package cn.sunfit.risk.buz.server.service.api.jfjd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFResources;
import cn.sunfit.risk.buz.api.beans.corp.Resources;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFResourcesService;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFResourcesDAO;

@Service("jfjd.resourcesService")
public class JFResourcesServiceImpl implements JFResourcesService {

    @Autowired
    JFResourcesDAO jFresourcesDAO;

    @Override
    public void deleteResource(String resourceId, String domain) {
        jFresourcesDAO.delete(domain, resourceId);
    }

    @Override
    public void insertResource(Resources resource, String domain) {
        jFresourcesDAO.insert(domain, resource);
    }

    @Override
    public JFResources queryResourcesById(String corpId, String resourceId, String domain) {
        return jFresourcesDAO.selectById(domain, resourceId);
    }

    @Override
    public List<JFResources> queryResourcesByIds(String corpId, List<String> resourceIds, String domain) {
        return jFresourcesDAO.selectByIds(domain, resourceIds);
    }

}
