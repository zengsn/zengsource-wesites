package com.wechat.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wechat.po.TextMessage;
import com.wechat.util.MessageUtil;

public class CoreService {
	 /**
     * 澶勭悊寰俊鍙戞潵鐨勮姹�     * 
     * @param request
     * @return
     */
    public static String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 榛樿杩斿洖鐨勬枃鏈秷鎭唴瀹�            
        	String respContent = "111";
            // xml璇锋眰瑙ｆ瀽
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 鍙戦�鏂瑰笎鍙凤紙open_id锛�            
            String fromUserName = requestMap.get("FromUserName");
            // 鍏紬甯愬彿
            String toUserName = requestMap.get("ToUserName");
            // 娑堟伅绫诲瀷
            String msgType = requestMap.get("MsgType");
            // 鍥炲鏂囨湰娑堟伅
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);
            /*
            // 鏂囨湰娑堟伅
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = "鎮ㄥ彂閫佺殑鏄枃鏈秷鎭紒";
            }
            // 鍥剧墖娑堟伅
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "鎮ㄥ彂閫佺殑鏄浘鐗囨秷鎭紒";
            }
            // 鍦扮悊浣嶇疆娑堟伅
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "鎮ㄥ彂閫佺殑鏄湴鐞嗕綅缃秷鎭紒";
            }
            // 閾炬帴娑堟伅
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "鎮ㄥ彂閫佺殑鏄摼鎺ユ秷鎭紒";
            }
            // 闊抽娑堟伅
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "鎮ㄥ彂閫佺殑鏄煶棰戞秷鎭紒";
            }
            // 浜嬩欢鎺ㄩ�
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 浜嬩欢绫诲瀷
                String eventType = requestMap.get("Event");
                // 璁㈤槄
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "璋㈣阿鎮ㄧ殑鍏虫敞锛�;
                }
                // 鍙栨秷璁㈤槄
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 鍙栨秷璁㈤槄鍚庣敤鎴峰啀鏀朵笉鍒板叕浼楀彿鍙戦�鐨勬秷鎭紝鍥犳涓嶉渶瑕佸洖澶嶆秷鎭�                }
                // 鑷畾涔夎彍鍗曠偣鍑讳簨浠�                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 鑷畾涔夎彍鍗曟潈娌℃湁寮�斁锛屾殏涓嶅鐞嗚绫绘秷鎭�                }
            }
            */
            textMessage.setContent(respContent);
            respMessage = MessageUtil.textMessageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }

}
