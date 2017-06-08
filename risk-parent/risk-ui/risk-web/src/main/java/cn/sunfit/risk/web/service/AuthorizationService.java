package cn.sunfit.risk.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.api.service.system.PermissionService;
import cn.sunfit.risk.buz.api.vo.system.SystemUrlFunc;

@Component
public class AuthorizationService {

    protected static final Logger logger = LoggerFactory.getLogger(AuthorizationService.class);

    // 注意\r\n前不能有空格
    private static final String CRLF = "\r\n";

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ShiroFilterFactoryBean shiroFilter;

    // 获取动态权限规则
    // 没有配置的url不给访问
    private String getDynaAuthRule() {
        StringBuffer stringBuffer = new StringBuffer();
        List<SystemUrlFunc> allFunctionList = permissionService.queryAllUrlFunc();
        Map<String, String> urlFuncMap = new HashMap<String, String>();

        for (SystemUrlFunc urlFunc : allFunctionList) {
            String url = urlFunc.getActionUrl();
            String func = urlFunc.getFuncCode();
            if (urlFuncMap.containsKey(url)) {
                urlFuncMap.put(url, urlFuncMap.get(url) + "," + func);
            } else {
                urlFuncMap.put(url, url + " = shiroAuthc,shiroFunc[" + urlFunc.getFuncCode());
            }
        }
        for (Map.Entry<String, String> entry : urlFuncMap.entrySet()) {
            stringBuffer.append(entry.getValue()).append("]").append(CRLF);
        }
        // 根目录不校验权限
        // stringBuffer.append("/web/*=anon").append(CRLF);
        stringBuffer.append("/login=anon").append(CRLF);
        stringBuffer.append("/loginSendSmsCode=anon").append(CRLF);
        stringBuffer.append("/index=shiroAuthc").append(CRLF);
        stringBuffer.append("/district/info=shiroAuthc").append(CRLF);
        stringBuffer.append("/data/datadic=shiroAuthc").append(CRLF);
        stringBuffer.append("/data/genNo=shiroAuthc").append(CRLF);
        stringBuffer.append("/carInfo/info=shiroAuthc").append(CRLF);
        stringBuffer.append("/querySystemMenu=shiroAuthc").append(CRLF);
        // 未匹配url校验权限
        // stringBuffer.append("/web/*=shiroAuthc,shiroFunc").append(CRLF);
        stringBuffer.append("/**=shiroAuthc").append(CRLF);
        return stringBuffer.toString();
    }

    // 获取固定权限验证规则
    private String getFixedAuthRule() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("/static/**=anon").append(CRLF);
        stringBuffer.append("/logout=shiroAuthc").append(CRLF);
        stringBuffer.append("/error/**=anon").append(CRLF);
        stringBuffer.append("/jfjd/**=anon").append(CRLF);
        stringBuffer.append("/order/api/**=anon").append(CRLF);
        // 获取保险数据接口不做权限校验
        stringBuffer.append("/v1/Insurance/**=anon").append(CRLF);
        return stringBuffer.toString();
    }

    public String loadFilterChainDefinitions() {
        while (!testPermissionService()) {
            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(getFixedAuthRule()).append(getDynaAuthRule());
        logger.info("loadFilterChainDefinitions");
        logger.info(stringBuffer.toString());
        return stringBuffer.toString();
    }

    public synchronized void recreateFilterChains() throws Exception {
        AbstractShiroFilter abstractShiroFilter = null;
        // try {
        abstractShiroFilter = (AbstractShiroFilter) shiroFilter.getObject();
        /*
         * } catch (Exception e) { logger.error("getShiroFilter from shiroFilterFactoryBean error!", e); throw new
         * RuntimeException( "get ShiroFilter from shiroFilterFactoryBean error!"); }
         */

        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) abstractShiroFilter
                .getFilterChainResolver();
        DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

        // 清空旧的权限控制
        manager.getFilterChains().clear();

        shiroFilter.getFilterChainDefinitionMap().clear();
        shiroFilter.setFilterChainDefinitions(loadFilterChainDefinitions());
        // 重新构建生成
        Map<String, String> chains = shiroFilter.getFilterChainDefinitionMap();
        for (Map.Entry<String, String> entry : chains.entrySet()) {
            String url = entry.getKey();
            String chainDefinition = entry.getValue().trim().replace(" ", "");
            manager.createChain(url, chainDefinition);
        }
    }

    public void setShiroFilter(ShiroFilterFactoryBean shiroFilter) {
        this.shiroFilter = shiroFilter;
    }

    private boolean testPermissionService() {
        try {
            permissionService.queryAllUrlFunc();
            logger.warn("测试permissionService成功");
        } catch (Exception e) {
            logger.warn("调用permissionService失败");
            return false;
        }
        return true;
    }

}
