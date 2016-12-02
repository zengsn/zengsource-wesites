package com.wesites.core;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wesites.core.service.RoleService;
import com.wesites.core.service.RoleServiceImpl;
import com.wesites.util.PageBean;

public class ManagerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int page;
	private PageBean<?> pageBean;
	private int rate;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean<?> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<?> pageBean) {
		this.pageBean = pageBean;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String execute() throws Exception {
		RoleService roleService = new RoleServiceImpl();
		PageBean<?> pageBean = roleService.queryForPage(5, page, rate);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		return "success";

	}

}
