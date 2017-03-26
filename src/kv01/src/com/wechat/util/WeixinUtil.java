package com.wechat.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.wechat.dto.wx.AccessToken;


/**
 * 公众平台通用接口工具类 
 * @类名	WeixinUtil.java
 */
public class WeixinUtil {
	private static final Logger logger = Logger.getLogger(WeixinUtil.class);
	
	// 获取access_token的接口地址（GET） 限200（次/天）  
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";  
	// 菜单创建（POST） 限100（次/天）  
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
	// 菜单创建（POST） 限100（次/天）  
	public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";  
	
	/** 
     * 发起https请求并获取结果 
     *  
     * @param requestUrl 请求地址 
     * @param requestMethod 请求方式（GET、POST） 
     * @param outputStr 提交的数据 
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
     */  
    private static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {  
        JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {  
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            // 当有数据需要提交时  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            }  
  
            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.fromObject(buffer.toString());  
        } catch (ConnectException ce) {  
        	logger.error("Weixin server connection timed out.");  
        } catch (Exception e) {  
        	logger.error("https request error:{}", e);  
        }  
        return jsonObject;  
    }  
    
    /** 
     * 获取access_token 
     *  
     * @param appid 凭证 
     * @param appsecret 密钥 
     * @return 
     */  
    public static AccessToken getAccessToken(String appid, String appsecret) {
    	AccessToken accessToken = null;  
    	String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);  
    	JSONObject jsonObject = httpRequest(requestUrl, "GET", null);  
    	// 如果请求成功  
        if (null != jsonObject) { 
        	accessToken = new AccessToken();  
            accessToken.setToken(jsonObject.getString("access_token"));  
            accessToken.setExpiresIn(jsonObject.getInt("expires_in"));  
        }
		return accessToken;  
    }
    
    /** 
     * 创建菜单 
     *  
     * @param menu 菜单实例 
     * @param accessToken 有效的access_token 
     * @return 0表示成功，其他值表示失败 
     */  
    public static String createMenu(String jsonMenu, String accessToken) {  
        // 拼装创建菜单的url  
        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);  
        // 调用接口创建菜单  
        JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);  
        return jsonObject.toString();
    }  
    
    /** 
     * 删除菜单 
     * @param accessToken 有效的access_token 
     * @return 0表示成功，其他值表示失败 
     */  
    public static int deleteMenu(String accessToken) {  
    	int result = 0;  
    	// 拼装创建菜单的url  
    	String url = menu_delete_url.replace("ACCESS_TOKEN", accessToken);  
    	// 调用接口创建菜单  
    	JSONObject jsonObject = httpRequest(url, "GET", null);  
    	if (null != jsonObject) {  
    		if (0 != jsonObject.getInt("errcode")) {  
    			result = jsonObject.getInt("errcode");  
    			logger.error("删除菜单失败 errcode:{} errmsg:{}");  
    		}  
    	}  
    	return result;  
    }  
    
    /** 
     * 生成TOKEN
     *  
     * @return 0表示成功，其他值表示失败 
     */  
    public static String createToken() {  
        String result = "";  
        String[] arr = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e",
        		"f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int length = arr.length;
        // 拼装
        for (int i = 0; i < 10; i++) {
        	int random = (int) (Math.random() * length);
        	result += arr[random];
		}
        return result;  
    }  
}
