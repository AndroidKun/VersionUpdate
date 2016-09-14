package com.androidkun.versionupdate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by PHP on 2016/6/1.
 * 时间转换工具
 */
public class DateUtils {
    /**
     * String 转换 Date
     *
     * @param str
     * @param format
     * @return
     */
    public static Date string2Date(String str, String format) {
        try {
            return new SimpleDateFormat(format).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /**
     * Date（long） 转换 String
     *
     * @param time
     * @param format
     * @return
     */
    public static String date2String(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(time);
        return s;
    }

    /**
     * 根据年 月 获取对应的月份 天数
     * */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     *  根据起始日期和间隔时间计算结束日期
     * @param sDate
     * @param days
     * @return
     */
    public static String calculateEndDate(String sDate,int days){
        //将开始时间赋给日历实例
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(string2Date(sDate,"yyyy-MM-dd"));
        // 计算结束时间
        sCalendar.add(Calendar.DATE,days);
        return date2String(sCalendar.getTimeInMillis(),"yyyy-MM-dd");
    }

    /**
     * long 去除 时分秒
     * 时分秒全部为0
     *
     * @param date
     * @return
     */
    public static long getYearMonthDay(long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 将时长格式化为 秒
     *
     * @param ms
     * @return
     */
    public static int timeFormatMinte(long ms) {
        int s = (int) (ms / 1000);
        return s;
    }

    /**
     * 获取当前Year
     *
     * @return
     */
    public static int getCurYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }

    /**
     * 获取当前MONTH
     *
     * @return
     */
    public static int getCurMONTH() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH);
    }

    /**
     * 获取当前Day
     *
     * @return
     */
    public static int getCurDAY() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前Hour
     *
     * @return
     */
    public static int getCurHour() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY);

    }

    /**
     * 获取当前MINUTE
     *
     * @return
     */
    public static int getCurMINUTE() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MINUTE);

    }

    /**
     * 获取当前Year
     *
     * @return
     */
    public static String getCurYear(Calendar c) {
        return c.get(Calendar.YEAR) + "";
    }

    /**
     * 获取当前MONTH
     *
     * @return
     */
    public static String getCurMONTH(Calendar c) {
        int month = c.get(Calendar.MONTH);
        String sMonth;
        if (month == 0) {
            sMonth = "12";
        } else if (month < 10) {
            sMonth = "0" + month;
        } else {
            sMonth = month + "";
        }
        return sMonth;
    }

    /**
     * 获取当前Day
     *
     * @return
     */
    public static String getCurDAY(Calendar c) {
        return c.get(Calendar.DAY_OF_MONTH) + "";
    }

    /**
     * 获取当前Hour
     *
     * @return
     */
    public static String getCurHour(Calendar c) {
        return c.get(Calendar.HOUR_OF_DAY) + "";

    }

    /**
     * 获取当前MINUTE
     *
     * @return
     */
    public static String getCurMINUTE(Calendar c) {
        return c.get(Calendar.MINUTE) + "";

    }

    public static String getStringTime(Calendar c, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date curDate = new Date(c.getTimeInMillis());
        return formatter.format(curDate);
    }

    public static String getCurTime(String format) {
        /*SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date curDate = new Date(System.currentTimeMillis());*/
//        return formatter.format(curDate);
        Date date = new Date();
        SimpleDateFormat sdformat = new SimpleDateFormat(format);
        return sdformat.format(date);
    }

    public static String getTimeInterval(long time){

        long interval = System.currentTimeMillis() - time * 1000;//获取时间差
        long fiveMin = 5 * 60 * 1000;//5分钟的时间
        if(interval<fiveMin){
            return "刚刚";
        }
        long oneHour = 60 * 60 * 1000;//1个小时的时间
        if(interval<oneHour){
            long min = interval / (60 * 1000);
            return min+"分钟前";
        }
        long zeroToNow = (getCurHour()*60+getCurMINUTE())*60*1000;//获取0点到当前时分的时间
        if(interval<zeroToNow){//如果时间搓小于0点到当前的时分，则是今天
            long hour = interval / oneHour;
            return hour+"小时前";
        }

        long oneDay = 24 * oneHour;
        
        long yesZeroToNow = oneDay + zeroToNow;//获取昨天0点到当前时分的时间
        if(interval<yesZeroToNow){//如果时间小于昨天0点到现在的时分，则是昨天
            return "昨天 "+getStringTime(time,"hh时mm分");
        }
        //大于的情况下，昨天以前的时间
        return getStringTime(time,"MM月dd日 hh时mm分");
    }
    public static String getStringTime(long time, String format) {
        Date date = new Date(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getStringTime(calendar,format);
    }
}
