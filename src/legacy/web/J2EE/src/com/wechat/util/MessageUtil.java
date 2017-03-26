package com.wechat.util;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wechat.po.TextMessage;

public class MessageUtil {
    /**
     * 杩斿洖娑堟伅绫诲瀷锛氭枃鏈�     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    /**
     * 杩斿洖娑堟伅绫诲瀷锛氶煶涔�     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    /**
     * 杩斿洖娑堟伅绫诲瀷锛氬浘鏂�     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    /**
     * 璇锋眰娑堟伅绫诲瀷锛氭枃鏈�     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    /**
     * 璇锋眰娑堟伅绫诲瀷锛氬浘鐗�     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    /**
     * 璇锋眰娑堟伅绫诲瀷锛氶摼鎺�     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";
    /**
     * 璇锋眰娑堟伅绫诲瀷锛氬湴鐞嗕綅缃�     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    /**
     * 璇锋眰娑堟伅绫诲瀷锛氶煶棰�     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    /**
     * 璇锋眰娑堟伅绫诲瀷锛氭帹閫�     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";
    /**
     * 浜嬩欢绫诲瀷锛歴ubscribe(璁㈤槄)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    /**
     * 浜嬩欢绫诲瀷锛歶nsubscribe(鍙栨秷璁㈤槄)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    /**
     * 浜嬩欢绫诲瀷锛欳LICK(鑷畾涔夎彍鍗曠偣鍑讳簨浠�
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";

    /**
     * 瑙ｆ瀽寰俊xml璇锋眰
     * @param request
     * @return
     * @throws Exception
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 瑙ｆ瀽缁撴灉瀛樺偍鍦℉ashMap 涓�        
    	Map<String, String> map = new HashMap<String, String>();
        // 浠巖equest寰楀埌杈撳叆娴�       
    	InputStream is = request.getInputStream();
        // 瑙ｆ瀽xml
        SAXReader sax = new SAXReader();
        Document document = sax.read(is);
        // 寰楀埌xml鏍瑰厓绱�        
        Element root = document.getRootElement();
        // 寰楀埌瀛愯妭鐐�        
        List<Element> elementList = root.elements();
        // 閬嶅巻瀛愯妭鐐�        
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        // 閲婃斁璧勬簮
        if (is != null) {
            is.close();
            is = null;
        }
        return map;
    }

    /**
     * 鏂囨湰娑堟伅杞垚xml
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 闊充箰娑堟伅杞xml
     * @param musicMessage
     * @return
     
    public static String musicMessageToXml(MusicMessage musicMessage) {
        xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }
	*/
    /**
     * 鍥炬枃娑堟伅瀵硅薄杞崲鎴恱ml
     * 
     * @param newsMessage 鍥炬枃娑堟伅瀵硅薄
     * @return xml
     
    public static String newsMessageToXml(NewsMessage newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);
    }
*/
    /**
     * /** 鎵╁睍xstream锛屼娇鍏舵敮鎸丆DATA鍧�     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 瀵规墍鏈墄ml鑺傜偣鐨勮浆鎹㈤兘澧炲姞CDATA鏍囪
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
}