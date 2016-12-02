package com.wesites.menu.pojo;

import com.wesites.core.pojo.Wechat;

public class Menu {
	private Integer menuid;
	private String menuname;
	private String type;
	private String action;
	private String respondaction;
	private Integer wechatid;
	private Wechat wechat;
	public Integer getMenuid() {
		return menuid;
	}
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getRespondaction() {
		return respondaction;
	}
	public void setRespondaction(String respondaction) {
		this.respondaction = respondaction;
	}
	public Integer getWechatid() {
		return wechatid;
	}
	public void setWechatid(Integer wechatid) {
		this.wechatid = wechatid;
	}
	public Wechat getWechat() {
		return wechat;
	}
	public void setWechat(Wechat wechat) {
		this.wechat = wechat;
	}
	
}
