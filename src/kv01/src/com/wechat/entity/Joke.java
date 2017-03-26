package com.wechat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 笑话
 * @类名	Joke.java
 */
public class Joke implements Serializable{

	private static final long serialVersionUID = -1501540019885686401L;
	private int id;// 主键
	private String title;// 标题
	private String content;// 内容
	private Date createDate;//生成时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
