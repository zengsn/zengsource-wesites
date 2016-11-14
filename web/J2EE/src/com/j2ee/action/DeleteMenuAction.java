package com.j2ee.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.j2ee.dao.MenuDAOImpl;
import com.j2ee.pojo.Menu;
import com.j2ee.pojo.Wechat;
import com.opensymphony.xwork2.ActionSupport;
import com.wechat.po.AccessToken;
import com.wechat.util.WeixinUtil;

public class DeleteMenuAction extends ActionSupport{

	private Integer menuid;
	
	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String execute() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Wechat wechat = (Wechat) request.getSession().getAttribute("wechat");
			MenuDAOImpl dao = new MenuDAOImpl();
			Menu menu = dao.findById(Menu.class, menuid);
			dao.delete(menu);
			WeixinUtil.setAPPID(wechat.getAppid());
			WeixinUtil.setAPPSECRET(wechat.getAppsecret());
			AccessToken token = WeixinUtil.getAccessToken();
			int result = WeixinUtil.deleteMenu(token.getToken());
			if(result == 0)
				System.out.println("成功");
			else
				System.out.println("errorcode："+result);
			return "success";
			
		} catch (Exception e) {
			// TODO: handle exception
			return "fail";
		}
	}
}
