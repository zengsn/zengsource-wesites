package com.wesites.autoReply;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wesites.autoReply.pojo.AutoReply;
import com.wesites.autoReply.service.AutoReplyService;
import com.wesites.autoReply.service.AutoReplyServiceImpl;
import com.wesites.util.PageBean;

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
		AutoReplyService autoreplyService = new AutoReplyServiceImpl();
		PageBean<AutoReply>pageBean = autoreplyService.queryForPage(5, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		return "success";
	}
}
