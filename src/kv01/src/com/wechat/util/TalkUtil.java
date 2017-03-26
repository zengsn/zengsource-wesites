package com.wechat.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

/**
 * 聊天机器人
 * @类名	TalkUtil.java
 */
public class TalkUtil {
	public static final Logger logger = Logger.getLogger(TalkUtil.class);
	private static final String URL_  = "http://www.tuling123.com/openapi/api?key=KEY&info=INFO&userid=USERID";
	private static final String KEY_  = "74fa83eed5c58430100194749bc49ccf";

	public static void main(String[] args) {
		String str = "我爱你";
		System.out.println(str);
		str = talk(str);
		System.out.println(str);
	}
	
    public static String talk(String str) {
    	return talk(str, null);
    }
    
	public static String talk(String info, String openId) {
		String url = URL_.replace("KEY", KEY_).replace("INFO", urlEncodeUTF8(info));
		if (!StringUtil.isEmpty(openId)){
			url = url.replace("USERID", openId);
		}
		JSONObject jsonObject = httpRequest(url);
		String text = null;
		if (null != jsonObject) { 
			System.out.println("-------" + jsonObject.toString());
        	text = jsonObject.getString("text");
        }
		if (!StringUtil.isEmpty(text)){
			text = text.replaceAll("<br>", "\n");
		}
		return text;
	}
	
	private static JSONObject httpRequest(String urlStr) {
		JSONObject jsonObject = null;
		try {
		    URL url = new URL(urlStr);
		    //远程url
			URLConnection conn = url.openConnection();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
		    String line = null;
		    StringBuffer buffer = new StringBuffer();
		    while ((line = reader.readLine()) != null){
		    	buffer.append(line + " ");
		    }
		    jsonObject = JSONObject.fromObject(buffer.toString());  
		    reader.close();  
		    conn = null;
		} catch (Exception e) {
		}
		return jsonObject;
	}
	
	/** 
     * UTF-8编码 
     * @param source 
     * @return 
     */  
    private static String urlEncodeUTF8(String source) {  
        String result = source;  
        try {  
            result = java.net.URLEncoder.encode(source, "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
}
