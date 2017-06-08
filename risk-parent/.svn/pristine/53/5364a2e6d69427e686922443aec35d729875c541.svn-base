package cn.sunfit.risk.buz.api.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getCurrentDay() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        return dayFormat.format(date);
    }

    public static String getCurrentMonth() {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        return monthFormat.format(date);
    }

    public static String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        return timeFormat.format(date);
    }

    public static String getCurrentYear() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return yearFormat.format(date);
    }

    public static String getFullDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        if (date != null) {
            return dateFormat.format(date);
        } else {
            return "";
        }
    }

    public static String getFullDateAddDay(Date date, String days) {
        int dayCount = Integer.parseInt(days);
        Date issueDate = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(issueDate);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + dayCount));
        return getFullDate(calendar.getTime());
    }

    public static String getStandardDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (date != null) {
            return dateFormat.format(date);
        } else {
            return "";
        }
    }

}
