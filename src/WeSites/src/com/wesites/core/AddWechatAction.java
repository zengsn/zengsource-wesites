package com.wesites.core;

import com.opensymphony.xwork2.ActionSupport;

public class AddWechatAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String appid;
	private String appsecret;
	private String url;
	private String token;
	private String encodingaeskey;

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

	public String execute() throws Exception {

		return "success";
	}

}
