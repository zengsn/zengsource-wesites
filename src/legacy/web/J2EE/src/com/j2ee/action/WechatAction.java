package com.j2ee.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.j2ee.pojo.Wechat;
import com.j2ee.service.IWechatService;
import com.j2ee.service.WechatService;
import com.j2ee.util.PageBean;

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
		IWechatService wechatService = new WechatService();
		PageBean<Wechat>pageBean = wechatService.queryForPage(5, page);
		Wechat wechat = wechatService.queryWechatByID(1);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		request.getSession().setAttribute("wechat",wechat);
		return "success";
	}
	
    
}
