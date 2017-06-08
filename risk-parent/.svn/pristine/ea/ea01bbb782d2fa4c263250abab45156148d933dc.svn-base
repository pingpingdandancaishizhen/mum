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

public class UserTest {

    @Test
    public void addUser() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "A123456");
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
        // param.put("userName", "测试1号");
        param.put("userAccount", "002001");
        // param.put("deptId", "001");
        param.put("email", "aa@aa.com");
        param.put("desc", "我是备注啊");
        param.put("idcard", "321322198802222215");
        // param.put("telephone", "18666666666");
        param.put("job", "测试工");
        param.put("roleId", "1");
        param.put("password", "123456");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/addUser";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void changeStatus() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
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
        param.put("id", "0ee7b3a16bda4dc4b820fce62f818234");
        param.put("status", "1");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/changeStatus";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void checkAccountExist() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
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
        // param.put("id", "0ee7b3a16bda4dc4b820fce62f818234");
        param.put("account", "003001");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/checkAccountExist";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void deleteUser() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
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
        param.put("id", "0ee7b3a16bda4dc4b820fce62f818234");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/deleteUser";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void getUserById() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
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
        param.put("userId", "0ee7b3a16bda4dc4b820fce62f818234");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/getUserById";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void modifyUser() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
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
        param.put("id", "0ee7b3a16bda4dc4b820fce62f818234");
        param.put("userName", "测试2号");
        param.put("userName", "测试2号");
        param.put("userAccount", "004001");
        param.put("deptId", "1");
        param.put("email", "bbbbb@aa.com");
        param.put("desc", "我是备注啊111");
        param.put("idcard", "421322198802222215");
        param.put("telephone", "18999999999");
        param.put("job", "测试工1");
        param.put("roleId", "1");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/modifyUser";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void queryAllRole() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
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
        url = "http://localhost:8080/risk-web/system/role/queryAllRole";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void queryUserList() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
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
        param.put("userName", "管理员");
        param.put("userAccount", "001001");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/queryUserList";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void resetPassword() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
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
        param.put("id", "0ee7b3a16bda4dc4b820fce62f818234");
        param.put("password", "456789");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/resetPassword";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }
}
