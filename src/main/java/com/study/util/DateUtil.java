package com.study.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	public final static String LONG_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public final static String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * 获得20150803 --> 15/8/3,15/12/6,15/2/15,15/10/3文件夹形式
	 * 
	 * @return 15/10/3文件夹形式
	 */
	public static String endFileDir() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(date).toString();
		StringBuffer sb = new StringBuffer();
		char[] timeArr = str.toCharArray();
		sb = sb.append(timeArr[2]).append(timeArr[3]);
		// str = ""+timeArr[2]+timeArr[3];
		if (timeArr[4] != '0') {
			sb = sb.append(timeArr[4]);
			// str+=timeArr[4];
		}
		sb = sb.append(timeArr[5]).append("/");
		// str+=""+timeArr[5]+"/";//根据当前系统环境确定分隔符

		// 确定天数作为文件夹,测试部不需要天数，直接注释即可
		if (timeArr[6] != '0') {
			sb = sb.append(timeArr[6]);
		}
		sb = sb.append(timeArr[7]).append("/");
		return sb.toString().trim();
	}

	/**
	 * 获得当天日期
	 *
	 * @param pattern
	 * @return
	 */
	public static String getDate(String pattern) {
		if (pattern == null || pattern.equals("")) {
			pattern = "yyyyMMdd";
		}
		return DateUtil.getTime(pattern);
	}

	/**
	 * 时间格式转换
	 *
	 * @param cday
	 * @param pattern
	 * @return
	 */
	public static String getTime(Date cday, String pattern) {
		String timestr;
		if (pattern == null || pattern.equals("")) {
			pattern = "yyyyMMddHHmmss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		timestr = sdf.format(cday);
		return timestr;
	}

	/**
	 * 获得当天时间
	 *
	 * @param pattern
	 *            输出的时间格式
	 * @return 返回时间
	 */
	public static String getTime(String pattern) {
		String timestr;
		if (pattern == null || pattern.equals("")) {
			pattern = "yyyyMMddHHmmss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date cday = new Date();
		timestr = sdf.format(cday);
		return timestr;
	}

	/**
	 * 今天剩余多少秒
	 *
	 * @return
	 */
	public static int getSecond() {
		Calendar curDate = Calendar.getInstance();
		Calendar tomorrowDate = new GregorianCalendar(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH),
				curDate.get(Calendar.DATE) + 1, 0, 0, 0);
		return (int) (tomorrowDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000;
	}

	/**
	 * 将字串转换为指定格式的日期
	 *
	 * @param time
	 *            时间
	 * @param pattern
	 *            为空时，将使用yyyy-MM-dd格式
	 * @return
	 */
	public static Date StrToDate(String time, String pattern) {
		if (time == null || time.trim().equals("")) {
			return null;
		}
		if (pattern == null || pattern.equals("")) {
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		ParsePosition pos = new ParsePosition(0);
		Date dt1 = formatter.parse(time, pos);
		return dt1;
	}

	/**
	 * 日期转化为cron表达式
	 * 
	 * @param date
	 * @return
	 */
	public static String getCron(Date date) {
		String dateFormat = "ss mm HH dd MM ? yyyy";
		return DateUtil.fmtDateToStr(date, dateFormat);
	}

	/**
	 * cron表达式转为日期
	 * 
	 * @param cron
	 * @return
	 */
	public static Date getCronToDate(String cron) {
		String dateFormat = "ss mm HH dd MM ? yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = sdf.parse(cron);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * Description:格式化日期,String字符串转化为Date
	 * 
	 * @param date
	 * @param dtFormat
	 *            例如:yyyy-MM-dd HH:mm:ss yyyyMMdd
	 * @return
	 */
	public static String fmtDateToStr(Date date, String dtFormat) {
		if (date == null)
			return "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);
			return dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
