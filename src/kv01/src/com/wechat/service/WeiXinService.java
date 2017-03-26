package com.wechat.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.wechat.dto.wx.NewsMessage;
import com.wechat.dto.wx.TextMessage;
import com.wechat.entity.Article;
import com.wechat.entity.Config;
import com.wechat.entity.Joke;
import com.wechat.entity.Reply;
import com.wechat.util.HistoryTodayUtil;
import com.wechat.util.MessageUtil;
import com.wechat.util.StringUtil;
import com.wechat.util.TranslationUtil;
import com.wechat.util.WeatherUtil;

/**
 * 微信处理核心类
 * @类名	WeiXinService.java
 */
public class WeiXinService {
	public static final Logger logger = Logger.getLogger(WeiXinService.class);
	private BaseService<?> baseService;
	
	public BaseService<?> getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService<?> baseService) {
		this.baseService = baseService;
	}
	private String baseUrl = null;

	/** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // 默认返回的文本消息内容  
            String textContent = "";  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
            // 消息类型  
            String msgType = requestMap.get("MsgType"); 
            String fromUserName = requestMap.get("FromUserName");
            baseUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            // 文本消息  ---- 自动回复
            if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) {  
            	String Content = requestMap.get("Content");
            	textContent = initReply(Content);
            	if (StringUtil.isEmpty(textContent)){
            		respMessage = initArticle(requestMap, Content);
            	}
            } 
            // 事件推送  
            else if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)){
            	// 事件类型  
                String eventType = requestMap.get("Event");  
                //订阅
                if (MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(eventType)){
                	textContent = initReply("subscribe");
                }
                // 取消订阅  
                else if (MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)) {  
                    //  取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                } 
                // 自定义菜单点击事件  
                else if (MessageUtil.EVENT_TYPE_CLICK.equals(eventType)) {  
                	// 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey");  
                    if ("btn_31".equals(eventKey)){// 进入微信商城
                    	List<Article> articleList = new ArrayList<Article>();
                    	String title = "欢迎进入微信商城";
                    	String description = "欢迎进入微信商城";
                    	String picUrl = "";
                    	String url = baseUrl + "/shop/index?uuid=" + fromUserName;
                    	Article article = new Article(title, description, picUrl, url);
                    	articleList.add(article);
                    	respMessage = formatArticle(requestMap, articleList);
                    } else {
                    	textContent = initReply(eventKey);
                    }
                } 
            }
            if (StringUtil.isEmpty(respMessage)){
            	// 错误消息
            	if (StringUtil.isEmpty(textContent)){
            		textContent = initReply("error");
            	}
            	requestMap.put("Content", textContent);
            	respMessage = formatText(requestMap);
            }
        } catch (Exception e) {  
        }  
        return respMessage;  
    }  
    
    /**
     * 格式化自动回复
     * @param keyword
     * @return
     */
    private String initReply(String keyword){
    	keyword =  keyword.trim();
    	String result = null;
    	// 历史的今天
    	if ("今天".equals(keyword)){
    		result = HistoryTodayUtil.getInfo();
    	} 
    	// 天气预报
    	else if (keyword.startsWith("天气")){
    		keyword = keyword.replace("天气", "");
    		if (StringUtil.isEmpty(keyword)){
    			result = "输入错误，请发送【天气深圳】";
    		} else {
    			result = WeatherUtil.getWeather(keyword);
    		}
    	}
    	// 有道翻译
		else if (keyword.startsWith("翻译")){
			result = TranslationUtil.translate(keyword.replace("翻译", ""));
		}
    	// 笑话
		else if ("笑话".equals(keyword)){
			Joke joke = (Joke) baseService.random("from Joke");
        	StringBuffer buffer = new StringBuffer();
        	if (joke != null){
        		buffer.append("《").append(joke.getTitle()).append("》").append("\n");
        		buffer.append("    ").append(joke.getContent());
        	}
        	result = buffer.toString();
    	} else {
    		Reply reply = (Reply) baseService.findFirst("from Reply where keyword = '" + keyword.trim() + "'");
    		if (reply != null){
    			result = reply.getContent();
    		}
    	}
    	return result;
    }
    
    /**
     * 格式化自动回复--图文
     * @param keyword
     * @return
     */
    private String initArticle(Map<String, String> requestMap, String keyword){
    	Article article = (Article) baseService.findFirst("from Article where keyword = '" + keyword.trim() + "'");
    	if (article != null){
    		String picUrl = article.getPicUrl();
    		if (!picUrl.startsWith("http:")){
    			article.setPicUrl(baseUrl + "/" + picUrl);
    		}
    		List<Article> articleList = new ArrayList<Article>();
        	articleList.add(article);
            return formatArticle(requestMap, articleList);
    	}
    	return null;
    }
    
    /**
     * 格式化文字
     * @param map
     * @return
     */
    private String formatText(Map<String, String> map){
    	// 发送方帐号（open_id）  
        String fromUserName = map.get("FromUserName");  
        // 公众帐号  
        String toUserName = map.get("ToUserName");  
        //消息内容
    	String content = map.get("Content");
    	// 回复文本消息 
    	TextMessage textMessage = new TextMessage();  
        textMessage.setToUserName(fromUserName);  
        textMessage.setFromUserName(toUserName);  
        textMessage.setCreateTime(new Date().getTime());  
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
        textMessage.setFuncFlag(0);
        textMessage.setContent(content);  
        return MessageUtil.textMessageToXml(textMessage);  
    }
    
    /***
     * 格式化图文
     * @param map
     * @param articleList
     * @return
     */
    private String formatArticle(Map<String, String> map, List<Article> articleList){
    	// 发送方帐号（open_id）  
        String fromUserName = map.get("FromUserName");  
        // 公众帐号  
        String toUserName = map.get("ToUserName");  
    	// 创建图文消息  
        NewsMessage newsMessage = new NewsMessage();  
        newsMessage.setToUserName(fromUserName);  
        newsMessage.setFromUserName(toUserName);  
        newsMessage.setCreateTime(new Date().getTime());  
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
        newsMessage.setFuncFlag(0);  
        
        newsMessage.setArticleCount(articleList.size());  
        newsMessage.setArticles(articleList);  
        return MessageUtil.newsMessageToXml(newsMessage);  
    }
    
    /** 
     * 验证签名 
     *  
     * @param signature 
     * @param timestamp 
     * @param nonce 
     * @return 
     */  
    public boolean checkSignature(String signature, String timestamp, String nonce) {  
    	Config config = (Config) baseService.findFirst("from Config");
        String[] arr = new String[] { config.getToken(), timestamp, nonce };  
        // 将token、timestamp、nonce三个参数进行字典序排序  
        Arrays.sort(arr);  
        StringBuilder content = new StringBuilder();  
        for (int i = 0; i < arr.length; i++) {  
            content.append(arr[i]);  
        }  
        MessageDigest md = null;  
        String tmpStr = null;  
  
        try {  
            md = MessageDigest.getInstance("SHA-1");  
            // 将三个参数字符串拼接成一个字符串进行sha1加密  
            byte[] digest = md.digest(content.toString().getBytes());  
            tmpStr = byteToStr(digest);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
  
        content = null;  
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信  
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;  
    }  
  
    /** 
     * 将字节数组转换为十六进制字符串 
     *  
     * @param byteArray 
     * @return 
     */  
    private static String byteToStr(byte[] byteArray) {  
        String strDigest = "";  
        for (int i = 0; i < byteArray.length; i++) {  
            strDigest += byteToHexStr(byteArray[i]);  
        }  
        return strDigest;  
    }  
  
    /** 
     * 将字节转换为十六进制字符串 
     *  
     * @param mByte 
     * @return 
     */  
    private static String byteToHexStr(byte mByte) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] tempArr = new char[2];  
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
        tempArr[1] = Digit[mByte & 0X0F];  
  
        String s = new String(tempArr);  
        return s;  
    }  
}
