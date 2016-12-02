package com.wesites.menu;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wesites.core.pojo.Wechat;
import com.wesites.menu.dao.MenuDAOImpl;
import com.wesites.menu.pojo.Menu;
import com.wesites.wechat.pojo.AccessToken;
import com.wesites.wechat.utils.WeixinUtil;

public class DeleteMenuAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer menuid;

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String execute() throws Exception {
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
			if (result == 0)
				System.out.println("成功");
			else
				System.out.println("errorcode：" + result);
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "fail";
		}
	}
}
