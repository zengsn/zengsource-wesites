package com.wesites.menu;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wesites.autoReply.pojo.AutoReply;
import com.wesites.menu.pojo.Menu;
import com.wesites.menu.service.MenuService;
import com.wesites.menu.service.MenuServiceImpl;
import com.wesites.util.PageBean;

public class MenuAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
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

	public String execute() throws Exception {
		MenuService menuService = new MenuServiceImpl();
		PageBean<Menu> pageBean = menuService.queryForPage(5, page);
		if (!pageBean.getList().isEmpty()) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("pageBean", pageBean);
			return "success";
		} else
			return "fail";
	}
}
