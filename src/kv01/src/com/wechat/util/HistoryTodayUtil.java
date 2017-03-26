package com.wechat.util;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 历史上的今天
 * @类名	TodayInHistoryUtil.java
 */
public class HistoryTodayUtil {

	private static final String URL = "http://hao.360.cn/histoday/DATE.html";
	
	/** 
     * 获取今天日期(MMdd) 
     *  
     * @return 
     */  
    private static String getNow() {  
    	DateFormat df = new SimpleDateFormat("MMdd");  
    	return df.format(new Date());
    }
    
    /** 
     * 获取今天日期(yyyy年MM月dd日) 
     *  
     * @return 
     */  
    private static String getToday (){
    	DateFormat df = new SimpleDateFormat("MM月dd日");  
    	return df.format(new Date());
    }
    
	/** 
     * 通过main在本地测试 
     *  
     * @param args 
	 * @throws UnsupportedEncodingException 
     */  
    public static void main(String[] args)  {  
    	String s = getInfo();
    	System.out.println(s);
    }  
    
	 /** 
     * 封装历史上的今天查询方法，供外部调用 
     *  
     * @return 
     */  
    public static String getInfo() {  
    	String url = URL.replace("DATE", getNow());
    	// 获取网页源代码  
        String html = HttpUtil.httpGet(url);
        // 从网页中抽取信息  
        return extract(html);  
    }  
  
	/** 
     * 从html中抽取出历史上的今天信息 
     *  
     * @param html 
     * @return 
     */  
    private static String extract(String html) {  
        StringBuffer buffer = null;
        //Pattern p = Pattern.compile("(.*)(<div class=\"listren\">)(.*?)(</div>)(.*)");  
        Pattern p = Pattern.compile("<dt><em>[0-9]*</em>[. -“”、0-9\u4e00-\u9fa5]*</dt>");  
        Matcher matcher = p.matcher(html);  
        // 拼装标题  
        buffer = new StringBuffer();  
        buffer.append("≡≡ ").append("历史上的").append(getToday()).append(" ≡≡").append("\n\n");  
        while (matcher.find()) {  
        	String group = matcher.group();
        	group = group.replace("<dt><em>", "")
        			.replace("</em>.", "、").replace("</dt>", "");
        	buffer.append(group).append("\n\n");
        }  
        return  buffer.substring(0, buffer.lastIndexOf("\n\n"));  
    }
}
