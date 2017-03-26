package com.j2ee.action;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.j2ee.dao.AutoReplyDAOImpl;
import com.j2ee.dao.MenuDAOImpl;
import com.j2ee.pojo.Menu;
import com.j2ee.pojo.Wechat;
import com.opensymphony.xwork2.ActionSupport;
import com.wechat.po.AccessToken;
import com.wechat.util.WeixinUtil;

public class AddMenuAction extends ActionSupport{
	private String menuname;
	private String type;
	private String action;
	private String respondaction;
	
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
	
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		Wechat wechat = (Wechat) request.getSession().getAttribute("wechat");
		try {
			MenuDAOImpl dao = new MenuDAOImpl();
			Menu menu = new Menu();
			menu.setMenuname(menuname);
			menu.setType(type);
			menu.setAction(action);
			menu.setRespondaction(respondaction);
			menu.setWechatid(wechat.getWechatid());
			dao.save(menu);
			//TODO:WECHAT MENU's CREATE
			WeixinUtil.setAPPID(wechat.getAppid());
			WeixinUtil.setAPPSECRET(wechat.getAppsecret());
			AccessToken token = WeixinUtil.getAccessToken();
			String menuXML = JSONObject.fromObject(WeixinUtil.initMenu(menu)).toString();
			int result = WeixinUtil.createMenu(token.getToken(),menuXML);
			if(result == 0)
				System.out.println("鎴愬姛");
			else
				System.out.println("errorcode锛�+result");
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "fail";
		}
	}
	

}
