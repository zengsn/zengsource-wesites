package com.gizwits.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Marvel
 * 
 * 时间日期格式转换
 */
public class FormatDate {

    private static final String DATE = "yyyy-MM-dd";
    private static final String TIME = "HH:mm:ss";
    private static final String TIMESTAMP = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * 根据给定的日期格式把日期字符串转换为Date
     * @param strDate 日期字符串
     * @param format 日期格式
     */
    public static Date parse(String strDate, String format) {
        if (strDate == null) {
            return null;
        }
        try {
            SimpleDateFormat ft = new SimpleDateFormat(format);
            Date date = ft.parse(strDate);
            return date;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * 根据给定的日期格式把Date转换为String
     * @param date 日期
     * @param format 日期格式
     */
    public static String parse(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat ft = new SimpleDateFormat(format);
        return ft.format(date);
    }
    
    /**
     * @param strDate 日期字符串，格式为"yyyy-MM-dd"
     */
    public static Date strToDate(String strDate) {
        return parse(strDate, DATE);
    }
    
    /**
     * @param strDate 日期字符串，格式为"HH:mm:ss"
     */
    public static Date strToTime(String strDate) {
        return parse(strDate, TIME);
    }
    
    /**
     * @param strDate 日期字符串，格式为"yyyy-MM-dd HH:mm:ss"
     */
    public static Date strToTimestamp(String strDate) {
        return parse(strDate, TIMESTAMP);
    }
    
    /**
     * @return 返回日期字符串格式为"yyyy-MM-dd"
     */
    public static String dateToStr(Date date) {
        return parse(date, DATE);
    }
    
    /**
     * @return 返回日期字符串格式为"HH:mm:ss"
     */
    public static String timeToStr(Date date) {
        return parse(date, TIME);
    }
    
    /**
     * @return 返回日期字符串格式为"yyyy-MM-dd HH:mm:ss"
     */
    public static String timestampToStr(Date date) {
        return parse(date, TIMESTAMP);
    }
}
