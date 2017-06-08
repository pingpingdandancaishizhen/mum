package cn.sunfit.risk.buz.server.util.p2p;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DataDisposeUtil<T> {

    public List<T> mapsToObj(List<Map<String, Object>> temp, Class<T> c) throws IllegalArgumentException,
            IllegalAccessException, InstantiationException {
        List<T> list = new ArrayList<T>();
        T o = null;
        Field[] fields = c.getDeclaredFields();
        for (Map<String, Object> t : temp) {
            o = mapToObj(t, c);
            list.add(o);
        }
        return list;
    }

    public T mapToObj(Map<String, Object> temp, Class<T> c) throws InstantiationException, IllegalAccessException {
        T o = c.newInstance();
        Field[] fields = c.getDeclaredFields();
        Object val = null;
        for (Field field : fields) {
            field.setAccessible(true);
            if (temp.get(field.getName()) != null && !Modifier.isFinal(field.getModifiers())
                    && !Modifier.isStatic(field.getModifiers())) {
                val = valDispose(temp.get(field.getName()), field.getGenericType().toString());
                if (val != null)
                    field.set(o, val);
            }
        }
        return o;
    }

    public Object valDispose(Object val, String valType) {
        if ("class java.lang.Long".equals(valType)) {
            return Long.valueOf(val.toString());
        } else if ("class java.lang.String".equals(valType)) {
            return val.toString();
        } else if ("class java.lang.Integer".equals(valType)) {
            return Integer.valueOf(val.toString());
        } else if ("class java.math.BigDecimal".equals(valType)) {
            return BigDecimal.valueOf(Double.valueOf(val.toString()));
        } else if ("class java.util.Date".equals(valType)) {
            return (Date) val;
        }
        return null;
    }
}
