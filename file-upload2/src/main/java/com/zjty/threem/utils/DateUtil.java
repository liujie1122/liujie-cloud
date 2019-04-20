package com.zjty.threem.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil { 
	
	/**
	   * 获取现在时间
	   *
	   * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	   */
	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		System.out.println(dateString);
		Date date = null; 
		try {
			date = formatter.parse(dateString); 
		} catch (ParseException e) { 
		    e.printStackTrace(); 
		} 
		return date; 
	} 

	/**
	   * 获取现在时间
	   *
	   * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	   */
	public static String getStringDate() {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String dateString = formatter.format(currentTime);
	   return dateString;
	}
	/**
	   * 得到现在时间
	   *
	   * @return
	   */
	public static Date getNow() {
	   Date currentTime = new Date();
	   return currentTime;
	}
	
	/**
     * 将系统当前时间转换为“yyyy-MM-dd HH:mm:ss”格式的日期字符   Timestamp
     */
    public static Timestamp nowDateToTimestamp() {
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 	   	String dateString = formatter.format(System.currentTimeMillis());
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
			timestamp = Timestamp.valueOf(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return timestamp;
    }
    
    
    /**
     * 将给定的字符串时间转换为“yyyy-MM-dd HH:mm:ss”格式的日期   Timestamp
     */
    public static Timestamp stringToTimestamp(String timestampString) {
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
			timestamp = Timestamp.valueOf(timestampString);
//			timestamp.
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return timestamp;
    }
    

    /**
     * 将给定的字符串“yyyy-MM-dd HH:mm:ss”，转换为该格式的日期字符    
     */
    public static Date stringToDate(String dateString) {
    	try {
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
    }
    
    /**
     * 获取时间的天数差
     * @return
     */
    public static int compareDate(Date bd, Date ed) {
    	Long subtractionNum = null;
    	try {
//	    	Date bd = df.parse(beginDate);
//	    	Date ed = df.parse(endDate);
	    	subtractionNum = ed.getTime() - bd.getTime();
//	    	System.out.println(subtractionNum/1000/60/60/24);
    	} catch (Exception exception) {
    		exception.printStackTrace();
    	}
		return (int) (subtractionNum/1000/60/60/24);
    }
} 