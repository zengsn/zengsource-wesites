package com.j2ee.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.j2ee.pojo.AutoReply;
import com.j2ee.pojo.Menu;
import com.j2ee.service.IMenuService;
import com.j2ee.service.MenuService;
import com.j2ee.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport{
	private int page;
    private PageBean<AutoReply> pageBean;
    
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public PageBean<AutoReply> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<AutoReply> pageBean) {
		this.pageBean = pageBean;
	}
	
	public String execute() throws Exception
	{
		IMenuService menuService = new MenuService();
		PageBean<Menu>pageBean = menuService.queryForPage(5, page);
		if(!pageBean.getList().isEmpty())
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("pageBean", pageBean);
			return "success";
		}
		else
			return "fail";
	}
}
