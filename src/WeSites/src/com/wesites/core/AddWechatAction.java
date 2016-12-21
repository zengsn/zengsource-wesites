package com.wesites.core;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wesites.core.dao.WechatDAOImpl;
import com.wesites.core.pojo.User;
import com.wesites.core.pojo.Wechat;

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
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("user2");
			WechatDAOImpl dao = new WechatDAOImpl();
			Wechat wechat = new Wechat();
			wechat.setAppid(appid);
			wechat.setAppsecret(appsecret);
			wechat.setEncodingaeskey(encodingaeskey);
			wechat.setToken(token);
			wechat.setUrl(url);
			wechat.setUserid(user.getId());
			dao.save(wechat);
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "fail";
		}
	}

}
