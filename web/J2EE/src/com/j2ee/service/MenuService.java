package com.j2ee.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.j2ee.dao.IMenuDAO;
import com.j2ee.dao.MenuDAOImpl;
import com.j2ee.pojo.Menu;
import com.j2ee.pojo.Wechat;
import com.j2ee.util.PageBean;



public class MenuService implements IMenuService{
	private IMenuDAO dao = new MenuDAOImpl();
	
	public PageBean<Menu> queryForPage(int pageSize, int page)
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		Wechat wechat = (Wechat) request.getSession().getAttribute("wechat");
		String hql = "select count(*) from Menu where wechatid="+wechat.getWechatid();
		int count = dao.getCount(hql); // 总记录数
		System.out.print(count);
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);
		List<Menu> list = dao.queryForPage("from Menu where wechatid ="+wechat.getWechatid(), offset, length); // 该分页的记录
		PageBean<Menu> pageBean = new PageBean<Menu>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

}
