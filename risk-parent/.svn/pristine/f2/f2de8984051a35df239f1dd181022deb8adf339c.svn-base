package org.risk.server.report.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.JSONException;
import org.json.JSONObject;

import cn.sunfit.risk.buz.api.constants.GlobalConstants;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat(GlobalConstants.DATE_FORMAT_DATE_TIME);
        objectMapper.setDateFormat(sdf);
    }

    public static String jsonStrByKey(String attributes, String key) throws JSONException {
        JSONObject jsonObject = new JSONObject(attributes);
        return jsonObject.get(key).toString();
    }

    public static String jsonStringByKey(String attributes, String key) throws JSONException {
        JSONObject jsonObject = new JSONObject(attributes);
        return jsonObject.getString(key);
    }

    public static Map jsonStrToMap(String attributes) throws JsonParseException, JsonMappingException, IOException {
        return objectMapper.readValue(attributes, HashMap.class);
    }

    public static <T> T jsonStrToObject(String json, Class<T> cls) throws JsonParseException, JsonMappingException,
            IOException {
        return objectMapper.readValue(json, cls);
    }

    public static String objectToJsonStr(Object o) throws JsonGenerationException, JsonMappingException, IOException {
        return objectMapper.writeValueAsString(o);
    }
}
