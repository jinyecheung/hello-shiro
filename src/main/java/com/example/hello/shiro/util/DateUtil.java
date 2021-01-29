package com.example.hello.shiro.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_SHORT_DATETIME_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT_YY_MM_DD = "yyMMdd";
    /**
     * 使用指定格式将日期转换为它的字符串表示形式。
     * @param localDateTime 日期，非 null。
     * @param format 指定返回格式的字符串。
     * @return 日期的字符串表示形式。
     */
    public static String format(LocalDateTime localDateTime, String format) {
        if(localDateTime == null){
            return null;
        }
        return DateTimeFormatter.ofPattern(format).format(localDateTime);
    }

    /**
     * 把日期格式化成yyMMdd格式
     * @param localDateTime LocalDateTime
     * @return yyMMdd
     */
    public static String formatYYMMDD(LocalDateTime localDateTime) {
        if(localDateTime == null){
            return null;
        }
        return DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_YY_MM_DD).format(localDateTime);
    }

    public static LocalDateTime parse(String localDateTimeStr, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(localDateTimeStr, dateTimeFormatter);
    }

    /**
     * 格式化时间为yyyy-MM-dd HH:mm:ss 字符串
     * @param localDateTime LocalDateTime
     * @return String
     */
    public static String format(LocalDateTime localDateTime) {
        if(localDateTime == null){
            return null;
        }
        return DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT).format(localDateTime);
    }

    /**
     * 格式化时间为yyyy-MM-dd 字符串
     * @param localDateTime LocalDateTime
     * @return String
     */
    public static String formatDay(LocalDateTime localDateTime) {
        if(localDateTime == null){
            return null;
        }
        return DateTimeFormatter.ofPattern(DEFAULT_SHORT_DATETIME_FORMAT).format(localDateTime);
    }

    /**
     * 使用指定格式将日期转换为它的字符串表示形式。
     *
     * @param date   日期，非 null。
     * @param format 指定返回格式的字符串。
     * @return 日期的字符串表示形式。
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    //某个日期增加天数
    public  static Date plusMinute(Date sourceDate,int minute){
        if (sourceDate == null) {
            return null;
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(sourceDate);
        ca.add(Calendar.MINUTE,minute);
        return ca.getTime();
    }

    public static String formatDateTime(Date date) {
        return format(date, DEFAULT_DATETIME_FORMAT);
    }

    public static  int minutesBetween(Date early, Date late)throws Exception {
        if(early ==null || late == null){
            throw  new Exception("日期不能为空");
        }
        String earlyString = formatDateTime(early);
        String lateString = formatDateTime(late);
        long from =0L;
        Date parseDate = parseDate(earlyString, DEFAULT_DATETIME_FORMAT);
        if(parseDate!=null){
            from = parseDate.getTime();
        }
        long to =0L;
        Date lateDte = parseDate(lateString, DEFAULT_DATETIME_FORMAT);
        if(lateDte!=null){
            to= lateDte.getTime();
        }
        int minutes = (int) ((to - from)/(1000 * 60));
        return minutes;
    }

    /**
     * 使用指定格式将日期字符串转换为时间。
     *
     * @param dateStr 日期字符串，非 null。
     * @param format  指定日期字符串的格式。
     * @return
     */
    public static Date parseDate(String dateStr, String format) throws ParseException {
        if (dateStr == null) {
            return null;
        }
        return new SimpleDateFormat(format).parse(dateStr);
    }

    /**
     * 将long类型的timestamp转为LocalDateTime
     * @param timestamp long
     * @return LocalDateTime
     */
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 获取今天
     * @return String
     */
    public static String getToday() {
        return new SimpleDateFormat(DEFAULT_SHORT_DATETIME_FORMAT).format(new Date());
    }

    /**
     * 获取一周，即从今天开始往前推七天
     * @return String
     */
    public static String getForwardOneWeek(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        return new SimpleDateFormat(DEFAULT_SHORT_DATETIME_FORMAT).format(d);
    }

    /**
     * 获取一个月，即从今天开始往前推一个月
     * @return String
     */
    public static String getForwardOneMonth(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        return new SimpleDateFormat(DEFAULT_SHORT_DATETIME_FORMAT).format(m);
    }
    /**
     * 获取三个月，即从今天开始往前推三个月
     * @return String
     */
    public static String getForwardThreeMonth(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -3);
        Date m3 = c.getTime();
        return new SimpleDateFormat(DEFAULT_SHORT_DATETIME_FORMAT).format(m3);
    }
    /**
     * 获取一年，即从今天开始往前推一年
     * @return String
     */
    public static String getForwardOneYear(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        return new SimpleDateFormat(DEFAULT_SHORT_DATETIME_FORMAT).format(y);
    }

    public static void main(String[] args) throws Exception{
        System.out.println(DateUtil.format(DateUtil.parseDate("20010101","yyyyMMdd"),"yyMM"));
        double a = 16.0;
        double b = 4.0;
        int i = (int)a;
        System.out.println(String.format("%0"+(int)b+"d", (int)a));

        System.out.println("--------test start----------");
        System.out.println(getToday());
        System.out.println(getForwardOneWeek());
        System.out.println(getForwardOneMonth());
        System.out.println(getForwardThreeMonth());
        System.out.println(getForwardOneYear());
        System.out.println("--------test end------------");
    }

}

