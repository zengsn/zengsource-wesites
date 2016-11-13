package com.j2ee.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.j2ee.pojo.AutoReply;
import com.j2ee.service.AutoReplyService;
import com.j2ee.service.IAutoReplyService;
import com.j2ee.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class AutoReplyAction extends ActionSupport{
	
	/**
	 * 
	 */
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
	public String execute() throws Exception
	{
		IAutoReplyService autoreplyService = new AutoReplyService();
		PageBean<AutoReply>pageBean = autoreplyService.queryForPage(5, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		return "success";
	}
}
