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

public class SettingTest {
    @Test
    public void changePassowrd() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
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
        param.put("oldpassword", "123456");
        param.put("password", "456789");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/changePassowrd";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void changeUser() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "004001");
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
        param.put("userName", "测试2号");
        param.put("email", "bbbbb@aa.com");
        param.put("desc", "我是备注啊111");
        param.put("idcard", "421322198802222215");
        param.put("telephone", "18999999999");
        param.put("job", "测试工1");
        System.out.println(param);
        url = "http://localhost:8080/risk-web/system/user/changeUser";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void getUserInfo() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
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
        url = "http://localhost:8080/risk-web/system/user/getUserInfo";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }
}
