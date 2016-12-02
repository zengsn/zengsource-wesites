package com.wesites.autoReply.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.wesites.autoReply.dao.AutoReplyDAO;
import com.wesites.autoReply.dao.AutoReplyDAOImpl;
import com.wesites.autoReply.pojo.AutoReply;
import com.wesites.core.pojo.Wechat;
import com.wesites.util.PageBean;

public class AutoReplyServiceImpl implements AutoReplyService{
	
	
	private AutoReplyDAO dao = new AutoReplyDAOImpl();
	
	public PageBean<AutoReply> queryForPage(int pageSize, int page)
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		Wechat wechat = (Wechat) request.getSession().getAttribute("wechat");
		String hql = "select count(*) from AutoReply where wechatid="+wechat.getWechatid();
		int count = dao.getCount(hql); // 总记录数
		System.out.print(count);
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);
		List<AutoReply> list = dao.queryForPage("from AutoReply where wechatid ="+wechat.getWechatid(), offset, length); // 该分页的记录
		PageBean<AutoReply> pageBean = new PageBean<AutoReply>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

}
