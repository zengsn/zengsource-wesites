package com.wechat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信自动回复类
 * @类名	Reply.java
 */
public class Reply implements Serializable {

	private static final long serialVersionUID = 7837960351057729885L;
	private int id;// 主键
	// error 错误消息   subscribe关注回复
	private String keyword;//关键字
	private String content;//内容
	private Date createDate;// 创建时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
