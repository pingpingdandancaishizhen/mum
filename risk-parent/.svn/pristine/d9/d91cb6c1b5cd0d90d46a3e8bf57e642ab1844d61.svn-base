package cn.sunfit.risk.web.resolver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import cn.sunfit.risk.web.resolver.annotation.FormModel;

public class FormModelResolver implements WebArgumentResolver {

    // 帮前面几级的对象都new出来。
    public BeanWrapper guaranteeProp(BeanWrapper objWrapper, String[] props, int dept) throws BeansException,
            InstantiationException, IllegalAccessException {
        Object tmpObj = objWrapper;
        for (int i = 1; i < dept; i++) {
            tmpObj = objWrapper.getPropertyValue(props[i]);
            if (tmpObj == null) {
                tmpObj = objWrapper.getPropertyType(props[i]).newInstance();
                objWrapper.setPropertyValue(props[i], tmpObj);
            }
            objWrapper = new BeanWrapperImpl(tmpObj);
        }
        return objWrapper;
    }

    @Override
    public Object resolveArgument(MethodParameter param, NativeWebRequest request) throws Exception {
        FormModel formModel = param.getParameterAnnotation(FormModel.class);

        // 取到要带的前缀名字
        String paramName = formModel.value();
        if (paramName.equals("_param_name")) {
            paramName = param.getParameterName();
        }

        Class<?> parameterType = param.getParameterType();
        Object ret = parameterType.newInstance();

        // 开始绑定值
        Map<String, String[]> needBindParamMap = new HashMap<String, String[]>();
        Iterator<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasNext()) {
            String parameterName = parameterNames.next();
            String[] parameterValues = request.getParameterValues(parameterName);

            // TODO去除parameterValues为null或者为空的值

            if (parameterName.startsWith(paramName)) {
                needBindParamMap.put(parameterName, parameterValues);
            }
        }

        BeanWrapper retWrapper = new BeanWrapperImpl(ret);
        for (String key : needBindParamMap.keySet()) {
            String[] props = key.split("\\.");
            String[] propVals = needBindParamMap.get(key);

            BeanWrapper tmpWrapper = guaranteeProp(retWrapper, props, props.length - 1);
            tmpWrapper.setPropertyValue(props[props.length - 1], propVals);
        }

        return ret;
    }
}
