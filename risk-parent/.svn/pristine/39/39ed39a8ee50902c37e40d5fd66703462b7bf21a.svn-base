package cn.sunfit.risk.web.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

/**
 * 让spring mvc可以自动绑定list
 * @author Liuzhenghua
 * @date 2015年12月16日 上午11:11:09
 */
public class ObjectToIntListConverter implements Converter<Object[], List<Integer>> {

    @SuppressWarnings("rawtypes")
	@Override
	public List convert(Object[] arrs) {
		if (arrs == null || arrs.length == 0) {
			return new ArrayList<>();
		}
		
		List resultList = new ArrayList(arrs.length);
		for (int i = 0; i < arrs.length; i++) {
			Object ret = arrs[i];
			try {
				ret = Integer.valueOf(ret.toString());
			} catch (Exception e) {
			
			}
			resultList.add(ret);
		}
		return resultList;
	}
}
