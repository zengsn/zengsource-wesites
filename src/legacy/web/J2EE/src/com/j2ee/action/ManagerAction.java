package com.j2ee.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.j2ee.service.IRoleService;
import com.j2ee.service.RoleService;
import com.j2ee.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ManagerAction extends ActionSupport{
	private int page;
    private PageBean pageBean;
    private int rate;
    
   
    public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public PageBean getPageBean() {
		return pageBean;
	}


	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	
	public int getRate() {
		return rate;
	}


	public void setRate(int rate) {
		this.rate = rate;
	}




	public String execute() throws Exception
	{
		IRoleService roleService = new RoleService();
		PageBean pageBean = roleService.queryForPage(5, page,rate);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		return "success";

	}




}
