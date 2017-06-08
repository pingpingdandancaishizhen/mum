package cn.sunfit;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.web.utils.HttpUtils;
import cn.sunfit.risk.web.utils.JsonUtil;

public class RoleTest {

    @Test
    public void addRole() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "456789");
        param.put("domain", "wdgs");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/loginSendSmsCode";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        Resp r = JsonUtil.jsonStrToObject(res, Resp.class);
        param.put("smsCode", r.getData());
        System.out.println(param);
        url = "http://localhost:8080/risk-web/login";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        param = new HashMap<String, Object>();
        param.put("roleName", "测试1角色");
        param.put("desc", "123132");
        param.put("menuStr", "1,2,3");
        param.put("funcStr", "1,2,3");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/role/addRole";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void changeStatus() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "456789");
        param.put("domain", "wdgs");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/loginSendSmsCode";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        Resp r = JsonUtil.jsonStrToObject(res, Resp.class);
        param.put("smsCode", r.getData());
        System.out.println(param);
        url = "http://localhost:8080/risk-web/login";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        param = new HashMap<String, Object>();
        param.put("roleId", "fcd8036c85484dcea7565a39a1f43d2c");
        param.put("status", "1");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/role/changeStatus";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void modifyRole() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "456789");
        param.put("domain", "wdgs");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/loginSendSmsCode";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        Resp r = JsonUtil.jsonStrToObject(res, Resp.class);
        param.put("smsCode", r.getData());
        System.out.println(param);
        url = "http://localhost:8080/risk-web/login";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        param = new HashMap<String, Object>();
        param.put("id", "fcd8036c85484dcea7565a39a1f43d2c");
        param.put("roleName", "测试1角色");
        param.put("desc", "123132");
        param.put("menuStr", "1,2,3");
        param.put("funcStr", "1,2,3");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/role/modifyRole";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void queryAllFuncMenu() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "456789");
        param.put("domain", "wdgs");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/loginSendSmsCode";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        Resp r = JsonUtil.jsonStrToObject(res, Resp.class);
        param.put("smsCode", r.getData());
        System.out.println(param);
        url = "http://localhost:8080/risk-web/login";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        param = new HashMap<String, Object>();
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/role/queryAllFuncMenu";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void queryFuncMenuByRole() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "456789");
        param.put("domain", "wdgs");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/loginSendSmsCode";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        Resp r = JsonUtil.jsonStrToObject(res, Resp.class);
        param.put("smsCode", r.getData());
        System.out.println(param);
        url = "http://localhost:8080/risk-web/login";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        param = new HashMap<String, Object>();
        param.put("roleId", "1");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/role/queryFuncMenuByRole";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void queryModifyRole() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "456789");
        param.put("domain", "wdgs");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/loginSendSmsCode";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        Resp r = JsonUtil.jsonStrToObject(res, Resp.class);
        param.put("smsCode", r.getData());
        System.out.println(param);
        url = "http://localhost:8080/risk-web/login";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        param = new HashMap<String, Object>();
        param.put("roleId", "1");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/role/queryModifyRole";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void queryRoleList() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "456789");
        param.put("domain", "wdgs");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/loginSendSmsCode";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        Resp r = JsonUtil.jsonStrToObject(res, Resp.class);
        param.put("smsCode", r.getData());
        System.out.println(param);
        url = "http://localhost:8080/risk-web/login";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
        param = new HashMap<String, Object>();
        param.put("paseSize", "5");
        param.put("currentPage", "1");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/role/queryRoleList";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }
}
