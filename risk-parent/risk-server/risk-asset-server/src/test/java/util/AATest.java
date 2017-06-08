package util;

import java.util.HashMap;
import java.util.Map;

import cn.sunfit.risk.buz.api.utils.api.jfjd.Base64;
import cn.sunfit.risk.buz.api.utils.api.jfjd.HttpUtils;
import cn.sunfit.risk.buz.server.util.JsonUtil;

public class AATest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("idCard", "123456789123456789");
        map.put("corpId", "3");
        try {
            String str = JsonUtil.objectToJsonStr(map);
            str = Base64.getBASE64(str);
            String result = HttpUtils.sendPost("http://172.16.88.58:8080/jfjd/corpUser/userAuth", str);
            System.out.println(result);
        } catch (Exception e) {
        }
    }

}
