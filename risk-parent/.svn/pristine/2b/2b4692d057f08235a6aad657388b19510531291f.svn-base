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

public class LoginTest {

    @Test
    public void login() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
        param.put("domain", "wdgs");
        param.put("smsCode", "278982");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/login";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void loginSendSmsCode() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
        param.put("domain", "wdgs");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/loginSendSmsCode";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void querySystemMenu() throws URISyntaxException, JsonParseException, JsonMappingException, IOException {
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
        url = "http://localhost:8080/risk-web/querySystemMenu";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }
}
