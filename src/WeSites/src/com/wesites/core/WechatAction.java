package com.wesites.core;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.wesites.core.pojo.Wechat;
import com.wesites.core.service.WechatService;
import com.wesites.core.service.WechatServiceImpl;
import com.wesites.util.PageBean;

public class WechatAction {
	private String action;
	private int page;
    private PageBean<Wechat> pageBean;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public PageBean<Wechat> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<Wechat> pageBean) {
		this.pageBean = pageBean;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public String execute() throws Exception
	{
		return show();
		
	}

	public String show()
	{
		WechatService wechatService = new WechatServiceImpl();
		PageBean<Wechat>pageBean = wechatService.queryForPage(5, page);
		Wechat wechat = wechatService.queryWechatByID(1);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		request.getSession().setAttribute("wechat",wechat);
		return "success";
	}
	
    
}
