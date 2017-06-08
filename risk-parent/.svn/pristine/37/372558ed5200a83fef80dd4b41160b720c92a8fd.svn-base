package cn.sunfit;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.web.utils.HttpUtils;
import cn.sunfit.risk.web.utils.JsonUtil;

public class DTest {
    public static void login() throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "001001");
        param.put("password", "123456");
        param.put("domain", "wdgs");
        System.out.println(param);
        String url = "http://localhost:8080/risk-web/loginSendSmsCode";
        String res = HttpUtils.httpPostRequest(url, param);
        Resp r = JsonUtil.jsonStrToObject(res, Resp.class);
        param.put("smsCode", r.getData());
        url = "http://localhost:8080/risk-web/login";
        res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void test() throws URISyntaxException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleId", "1");
        String url = "http://localhost:8080/risk-web/system/role/loadAddRole";
        String res = HttpUtils.httpGetRequest(url, param);
        System.out.println(res);
    }

    @Test
    public void test1() throws URISyntaxException, UnsupportedEncodingException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleId", "1");
        String url = "http://localhost:8080/risk-web/system/role/queryFuncMenuByRole";
        String res = HttpUtils.httpPostRequest(url, param);
        System.out.println(res);
    }
}
