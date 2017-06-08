package cn.sunfit.risk.buz.util.p2p;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil
{
	private static Calendar			calendar		= Calendar.getInstance(java.util.Locale.CHINA);
	private static SimpleDateFormat	dateFormat		= new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat	dateFormat1		= new SimpleDateFormat("yyyy-MM-dd HH");
	private static SimpleDateFormat	dateFormat2		= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static SimpleDateFormat	dateTimeFormat	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 此方法做出调整，因为Linux的原因，请使用此方法的需要只能传入（yyyy-MM-dd，yyyy.MM.dd）两种字符串
	 * @param dateS
	 * @return
	 * @throws ParseException 
	 */
     public static Date sToDate(String dateS) throws ParseException
     {
    	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	 if(dateS.indexOf("-")==-1)
    	 {
    		 format = new SimpleDateFormat("yyyy.MM.dd");
    	 }
    	 Date date = null;
    	 date = format.parse(dateS);
		return date;
     }
     
     
    /**
     * 将日期转换成yyyy-MM-dd型的字符串
     * @param date 日期
     * @return 字符串
     */
     public static String dateToStringOne(Date date)
     {
    	 if(date!=null)
    	 {
    	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	 String sDate = format.format(date);
    	    return sDate;
    	 }else{
    		return null;
    	 }
     }
     
     /**
      * 将日期装换成yyyy.MM.dd型的字符串
      * @param date 日期
      * @return 字符串
      */
     public static String dateToStringTwo(Date date)
     {
    	 if(date!=null)
    	 {
    	 SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
    	 String sDate = format.format(date);
    	    return sDate;
    	 }else{
    		return null;
    	 }
     }
     
     /**
      * 将日期装换成yyyy.MM.dd HH:mm型的字符串
      * @param date 日期
      * @return 字符串
      */
     public static String dateToStringThree(Date date)
     {
    	 if(date!=null)
    	 {
    	 SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    	 String sDate = format.format(date);
    	    return sDate;
    	 }else{
    		return null;
    	 }
     }
     
     /**
      * 将日期装换成yyyy-MM-dd HH:mm:ss型的字符串
      * @param date 日期
      * @return 字符串
      */
     public static String dateToStringFour(Date date)
     {
    	 if(date!=null)
    	 {
    	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 String sDate = format.format(date);
    	    return sDate;
    	 }else{
    		return null;
    	 }
     }

     /**
      * 将日期装换成用户输入的类型的字符串
      * @param date 日期
      * @param formatStr 字符串转换类型
      * @return 字符串
      */
     public static String dateToString(Date date,String formatStr)
     {
    	 if(date!=null)
    	 {
    	 SimpleDateFormat format = new SimpleDateFormat(formatStr);
    	 String sDate = format.format(date);
    	    return sDate;
    	 }else{
    		return null;
    	 }
     }
     
     /**
      * 根据时间字符串获得时间差（天数）
      * @param oldDate 上一个时间
      * @param currentDate 当前时间
      * @return 时间差
      */
	public static int countDate(Date oldDate, Date currentDate)
	{
		long time = currentDate.getTime()-oldDate.getTime();
	    int day = (int) (time/(86400*1000));
		return day;
	}

     /**
      * 根据时间字符串获得时间差（天数,字符串格式yyyy-MM-dd）
      * @param oldDate 上一个时间
      * @param currentDate 当前时间
      * @return 时间差
     * @throws ParseException 
      */
	public static int countDateString(String oldDate, String currentDate) throws ParseException
	{
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    int day = 0;
			long oldMill = format.parse(oldDate).getTime();
			long newMill = format.parse(currentDate).getTime();
			long time = newMill-oldMill;
			day = (int) (time/(86400*1000));
		return day;
	}

	/**
	 * 将"yyyy-MM-dd"型字符串转换为date对象。
	 * 
	 * @param date:满足"yyyy-MM-dd"的字符串
	 * @return
	 */
	public static Date getDate(String dateString)
	{
		try
		{
			return dateFormat.parse(dateString);
		}
		catch (ParseException e)
		{
			return null;
		}
	}

	/**
	 * 获取指定年月日的Date
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date getDate(int year, int month, int day)
	{
		calendar.clear();
		calendar.set(year, month - 1, day);
		return calendar.getTime();
	}

	/**
	 * 判断该date是星期几.
	 * 
	 * @param date:指定date
	 * @return 返回1-7，1代表Sunday,7代表Saturday.
	 */
	public static int getWeekday(Date date)
	{
		calendar.clear();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 判断该”year年month月date日“是星期几.
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @return 返回1-7，1代表Sunday,7代表Saturday.
	 */
	public static int getWeekday(int year, int month, int day)
	{
		calendar.clear();
		calendar.set(year, month - 1, day);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 判断该date是否是星期六
	 * 
	 * @param date:指定date
	 */
	public static boolean isSaturday(Date date)
	{
		return getWeekday(date) == Calendar.SATURDAY;
	}

	/**
	 * 判断该date是否是星期日
	 * 
	 * @param date:指定date
	 */
	public static boolean isSunday(Date date)
	{
		return getWeekday(date) == Calendar.SUNDAY;
	}

	/**
	 * 判断该date是否是周末
	 * 
	 * @param date:指定date
	 */
	public static boolean isWeekend(Date date)
	{
		return isSaturday(date) || isSunday(date);
	}

	/**
	 * 将"yyyy-MM-dd hh:mm:ss"型字符串转换为date对象。
	 * 
	 * @param
	 * @return
	 */
	public static Date getDateTime(String dateTimeString)
	{
		try
		{
			return dateTimeFormat.parse(dateTimeString);
		}
		catch (ParseException e)
		{
			return null;
		}
	}

	/**
	 * 将date对象转换为"yyyy-MM-dd hh:mm:ss"型字符串。
	 * 
	 * @param
	 * @return
	 */
	public static String getDateTime(Date time)
	{
		return dateTimeFormat.format(time);
	}

	/**
	 * 获取date对象的 "yyyy-MM-dd"字符串形式
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date)
	{
		if(date == null){
			return "";
		}
		return dateFormat.format(date);
	}
	
	public static String getDateString1(Date date)
	{
		return dateFormat1.format(date);
	}
	
	public static String getDateString2(Date date)
	{
		return dateFormat2.format(date);
	}

	/**
	 * 获取Date对象中 年份
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date)
	{
		calendar.clear();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 获取Date对象中 月份(月份以现实为准,1代表一月)
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date)
	{
		calendar.clear();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1; // JAVA中一月从0开始，为避免混淆，故+1
	}

	/**
	 * 获取Date对象中 天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(Date date)
	{
		calendar.clear();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 返回指定指定月份 天数
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysCount(int year, int month)
	{
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1); // Calendar中month是从0开始
		return calendar.getActualMaximum(Calendar.DATE);
	}
	
	/**
	 * 返回指定时间范围每个月的最后一天
	 * @param startDate
	 * @param endDate
	 * @return 起始时间大于结束时间则返回NULL
	 */
	public static List<String> getDatesLastDay(Date startDate,Date endDate){
		if(startDate == null || endDate == null)
			return null;
		List<String>list = new ArrayList<String>();
		if(startDate.getTime() > endDate.getTime())
			return null;
		if(getDateString(startDate).equals(getDateString(endDate))){
			list.add(getDateString(getDate(getYear(startDate), getMonth(startDate), getDaysCount(getYear(startDate),getMonth(startDate)))));
			return list;
		}
		Date d = startDate;
		String date = null;
		do{
			date = getDateString(d);
			list.add(getDateString(getDate(getYear(d), getMonth(d), getDaysCount(getYear(d),getMonth(d)))));
			d = addMonths(d, 1);
		}while(d.getTime() <= endDate.getTime());
		return list;
	}

	public static void main(String[] args) throws ParseException
	{
//		 System.out.println(getWeekday(getDate("2009-3-1")));
//		 System.out.println(getWeekday(2009, 3, 1));
		
//		 Date date1 = getDate("2009-12-1");
//		 Date date2 = getDate(2010, 3, 1);
//		 List<String>list = getDatesLastDay(date1,date2);
//		 for(String s:list){
//			 System.out.println(s);
//		 }
		 //System.out.println(getDateString(addMonths(date1, 1)));
		// System.out.println(getDaysCount(2009, 3));
		 
		// System.out.println(getWeekday(new Date()));
		// System.out.println(getWeekday(2009, 3, 13));

		// Date date1 = new Date();
		// Date date2 = getDate(2009, 3, 13);
		// System.out.println(getWeekday(date1));
		// System.out.println(getWeekday(2009,3,13));
		// System.out.println(getYear(date1));
		
		List<Date>ds = getDateBetweenDays(getDateTime("2016-07-10 10:10:10"),getDateTime("2016-07-13 05:10:10"));
		for(Date d: ds){
			System.out.println(dateToStringFour(d));
		}
		
		System.out.println(new BigDecimal(3600088555.54));
		
	}
	
	/**
	 * 但指定日期进行加减天数
	 * @param date
	 * @param offset
	 * @return
	 */
	public static Date addDays(Date date,int offset){
		Calendar calendar=Calendar.getInstance();   
		calendar.setTime(date); 		
		calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+offset);//让日期加位移量  
		   
		return calendar.getTime();
	}
	
	/**
	 * 指定日期进行加减小时
	 * @param date
	 * @param offset
	 * @return
	 */
	public static Date addHours(Date date,int offset){
		Calendar calendar=Calendar.getInstance();   
		calendar.setTime(date); 		
		calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY)+offset);  
		   
		return calendar.getTime();
	}
	
	public static Date toDate(String dateS, String formatStr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date date = null;
		date = format.parse(dateS);
		return date;
	}
	
	public static Date addMonths(Date date, int months){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	
	public static String getStartHour(Date date){
		String tmpDate = getDateString1(date);
			if(!"".equals(tmpDate)){
				tmpDate = tmpDate + ":00:00";
			}
		return tmpDate;
	}
	
	public static String getEndHour(Date date){
		String tmpDate = getDateString1(date);
			if(!"".equals(tmpDate)){
				tmpDate = tmpDate + ":59:59";
			}
		return tmpDate;
	}
	
	public static Date getEndDay(Date date) throws ParseException{
		String tmpDate = getDateString(date);
		Date result = date;
		if(!"".equals(tmpDate)){
			tmpDate = tmpDate + " 23:59:59";
			result = dateTimeFormat.parse(tmpDate);
		}
		return result;
	}
	
	public static Date getStartDay(Date date) throws ParseException{
		String tmpDate = getDateString(date);
		Date result = date;
		if(!"".equals(tmpDate)){
			tmpDate = tmpDate + " 00:00:00";
			result = dateTimeFormat.parse(tmpDate);
		}
		return result;
	}
	
	public static String getDateStr(Date date, String format){
		if(date == null) return "";
		SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
		return simpleFormat.format(date);
	}
	
	public static int getSecond(Date oldDate, Date currentDate){
	    int seconds = 0;
		long oldMill = oldDate.getTime();
		long newMill = currentDate.getTime();
		long time = newMill-oldMill;
		seconds = (int) (time/1000);
		return seconds;
	}
	
	public static int getYears(Date startDate, Date endDate){
		int startYear = getYear(startDate);
		int endYear = getYear(endDate);
		int startMonth = getMonth(startDate);
		int endMonth = getMonth(endDate);
		int startDay = getDay(startDate);
		int endDay = getDay(endDate);
		
		int years = endYear - startYear;
		
		if(endMonth < startMonth){
			return years - 1;
		}else if(endMonth == startMonth){
			if(endDay >= startDay){
				return years;
			}else{
				return years - 1;
			}
		}else{
			return years;
		}
	}
	
	public static boolean checkTimein(Date date, String starttime, String endtime) throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String datestr = sdf1.format(date);
		Date starttimestr = sdf2.parse(datestr + " " + starttime);
		Date endtimestr = sdf2.parse(datestr + " " + endtime);
		if(date.getTime() < starttimestr.getTime() || date.getTime() > endtimestr.getTime()){
			return false;
		}else{
			return true;
		}
	}
	
	public static Date getPreMonthFirstDay() {
		Calendar calendar= Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		return calendar.getTime();
	}
	
	public static Date getPreMonthLastDay() throws ParseException {
		Calendar calendar= Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return getEndDay(calendar.getTime());
	}
	
	public static Date getMonthLastDay() throws ParseException {
		Calendar calendar= Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return getEndDay(calendar.getTime());
	}
	
	public static Date getMonthLastDay(Date date) throws ParseException {
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return getEndDay(calendar.getTime());
	}
	
	/**
	 * 返回date所在月份的第一天
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthFirstDay(Date date) throws ParseException {
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return getStartDay(calendar.getTime());
	}
	
	public static Date getPreMonthDay(Date date) {
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();
	}
	
	public static Date getPreMonthNextDay(Date date) {
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}
	
	/**
	 * 返回date所在月份的所有天数时间
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static List<Date> getMonthAllDays(Date date) throws ParseException{
		int maxDays = getMonthLastDay(date).getDate();
		List<Date> monthAllDays = new ArrayList<Date>();
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date);
		for(int i = 1;i<= maxDays; i++){
			calendar.set(Calendar.DAY_OF_MONTH, i);
			monthAllDays.add(calendar.getTime());
		}
		return monthAllDays;
	}
	
	/**
	 * 返回指定时间之间包括参数本身的时间集合（忽视时分秒）
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException 
	 */
	public static List<Date> getDateBetweenDays(Date startDate,Date endDate) throws ParseException{
		List<Date> dates = new ArrayList<Date>();
		int count = countDate(getStartDay(startDate), getStartDay(endDate));
		if(count > 0){
			dates.add(startDate);
			for(int i = 1;i<=count;i++){
				dates.add(addDays(startDate, i));
			}
		}else{
			dates.add(endDate);
			count = 0 - count;
			for(int i = 1;i<= count;i++){
				dates.add(addDays(endDate, i));
			}
		}
		
		return dates;
	}
}
