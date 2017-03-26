package com.wechat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信配置类
 * @类名	Config.java
 * @作者	cdl
 * @版本 V 1.0
 */
public class Config implements Serializable {

	private static final long serialVersionUID = -318413297779734630L;
	private int id; // 主键
	private String appId;// 微信appId
	private String appSecret;// 微信appSecret
	private String token;// 微信token
	private String menu ;// 微信加密串
	private Date createDate;// 创建时间

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}

	
	
}
