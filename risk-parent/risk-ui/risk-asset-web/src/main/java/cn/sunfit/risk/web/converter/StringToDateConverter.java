package cn.sunfit.risk.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import cn.sunfit.risk.buz.api.constants.GlobalConstants;

/**
 * 字符串自动转换成日期
 * @author Liuzhenghua
 * @date 2015年12月4日 下午4:58:50
 */
public class StringToDateConverter implements Converter<String, Date> {

    private SimpleDateFormat sdf_date = new SimpleDateFormat(GlobalConstants.DATE_FORMAT_DATE_TIME);

    private SimpleDateFormat sdf_date_y_m_d = new SimpleDateFormat(GlobalConstants.DATE_FORMAT_DATE);

    @Override
    public Date convert(final String strDate) {
        Date date = null;
        if (!StringUtils.isBlank(strDate)) {
            try {
                if (strDate.contains(":")) {
                    return sdf_date.parse(strDate);
                } else {
                    return sdf_date_y_m_d.parse(strDate);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

}
