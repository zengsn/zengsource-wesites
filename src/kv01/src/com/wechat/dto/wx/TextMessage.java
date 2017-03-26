package com.wechat.dto.wx;

/**
 * 文本消息类
 * @类名	TextMessage.java
 */
public class TextMessage extends BaseMessage{

	// 消息内容  
    private String Content;

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	} 
}
