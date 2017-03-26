package com.wechat.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.wechat.dto.api.TranslateResult;

/**
 * 有道翻译API
 * @类名	TranslationUtil.java
 */
public class TranslationUtil {
	// 接口URL
	private static final String API_URL = "http://fanyi.youdao.com/openapi.do?keyfrom=81face&key=1651620054&type=data&doctype=DOCTYPE&version=1.1&q=Q&only=ONLY";
	
	public static void main(String[] args) {
		System.out.println(translate("我爱你"));
		System.out.println(translate("i love you"));
	}
  
	/**
	 * 翻译api
	 * @param source
	 * @return
	 */
	public static String translate(String source) {
		if (StringUtil.isEmpty(source)){
			return null;
		}
		source = urlEncodeUTF8(source);
		String dst = null;

		//only - 可选参数，dict表示只获取词典数据，
		String url = API_URL.replace("DOCTYPE", "json")
	    		.replace("ONLY", "translate")
	    		.replace("Q", source);
		try {
	    	String json = httpRequest(url);
	    	if (!StringUtil.isEmpty(json)){
	    		TranslateResult result = new Gson().fromJson(json.replace("[", "").replace("]", ""), TranslateResult.class);
	    		if (result != null && result.getErrorCode() == 0){
	    			StringBuffer buffer = new StringBuffer();
	    			buffer.append("原文：").append(result.getQuery()).append("\n");
	    			buffer.append("译文：").append(result.getTranslation());
	    			dst = buffer.toString();
	    		}
	    	}
		} catch (Exception e) {
		}

	    if (StringUtil.isEmpty(dst)) {
			dst = "翻译系统异常，请稍候尝试！";
	    }
	    return dst;
	}
	
	/**
	 * urlencode编码
	 * @param source
	 * @return
	 */
	private static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}
	
	/**
	 * get 请求
	 * @param requestUrl
	 * @return
	 */
	private static String httpRequest(String requestUrl) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection)url.openConnection();
			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
		} catch (Exception localException) {
		}
		return buffer.toString();
	}
}