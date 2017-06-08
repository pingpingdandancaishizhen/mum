package cn.sunfit.risk.web.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import cn.sunfit.risk.buz.api.vo.p2p.excel.FeeItem;

public class FeeUtil {
    
    public static FeeItem parsingFeeJson(String feeJson){
        FeeItem fee = null;
        try {
            fee = JsonUtil.jsonStrToObject(feeJson, FeeItem.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fee;
    }
    
}
