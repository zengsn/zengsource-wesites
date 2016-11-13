package com.j2ee.pojo;

import java.util.HashSet;
import java.util.Set;

public class Wechat {
	private Integer wechatid;
	private String appid;
	private String appsecret;
	private String url;
	private String token;
	private String encodingaeskey;
	private Set<AutoReply> autoreply = new HashSet<AutoReply>(0);
	private Set<Menu> menu = new HashSet<Menu>(0);
	public Integer getWechatid() {
		return wechatid;
	}
	public void setWechatid(Integer wechatid) {
		this.wechatid = wechatid;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEncodingaeskey() {
		return encodingaeskey;
	}
	public void setEncodingaeskey(String encodingaeskey) {
		this.encodingaeskey = encodingaeskey;
	}
	public Set<AutoReply> getAutoreply() {
		return autoreply;
	}
	public void setAutoreply(Set<AutoReply> autoreply) {
		this.autoreply = autoreply;
	}
	public Set<Menu> getMenu() {
		return menu;
	}
	public void setMenu(Set<Menu> menu) {
		this.menu = menu;
	}

	
	

}
